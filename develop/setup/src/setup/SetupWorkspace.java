package setup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SetupWorkspace
{
  private static final File downloads = new File("/develop/downloads").getAbsoluteFile();

  private static final int BUFFER_SIZE = 16 * 1024;

  public static void main(String[] args) throws Exception
  {
    downloads.mkdirs();
    System.out.println("Downloads: " + downloads);

    File workspace = new File("..").getCanonicalFile();
    System.out.println("Workspace: " + workspace.getAbsolutePath());

    setup(new File("urls-baseline.txt"), new File(workspace, ".baseline"));
    setup(new File("urls-target.txt"), new File(workspace, ".target"));
  }

  private static void setup(File urls, File target) throws IOException
  {
    System.out.println();
    System.out.println("Deleting " + target);
    delete(target);
    if (target.exists())
    {
      throw new IOException("Could not delete " + target.getAbsolutePath());
    }

    System.out.println();
    List<File> zips = new ArrayList<File>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(urls)));
    String url;
    while ((url = reader.readLine()) != null)
    {
      File zip = download(new URL(url.trim()));
      zips.add(zip);
    }

    System.out.println();
    for (File zip : zips)
    {
      unzip(zip, target);
    }
  }

  private static int delete(File file)
  {
    if (file == null || !file.exists())
    {
      return 0;
    }

    int deleted = 0;
    if (file.isDirectory())
    {
      for (File child : file.listFiles())
      {
        deleted += delete(child);
      }
    }

    if (file.delete())
    {
      return deleted + 1;
    }

    file.deleteOnExit();
    return deleted;
  }

  private static File download(URL url) throws IOException
  {
    return download(url, downloads);
  }

  private static File download(URL url, File folder) throws IOException, FileNotFoundException
  {
    if (folder.exists())
    {
      if (!folder.isDirectory())
      {
        throw new IllegalStateException("Not a folder: " + folder.getAbsolutePath());
      }
    }
    else
    {
      folder.mkdirs();
    }

    String name = new File(url.getFile()).getName();
    File file = new File(folder, name);
    if (file.exists())
    {
      if (file.isDirectory())
      {
        throw new IllegalStateException("Folder in the way: " + file.getAbsolutePath());
      }

      System.out.println("Skipping download of " + file.getAbsolutePath());
      return file;
    }

    System.out.println("Downloading " + file.getAbsolutePath() + " from " + url.toString());

    URLConnection connection = url.openConnection();
    String contentType = connection.getContentType();
    if (!"application/zip".equals(contentType))
    {
      copy((InputStream)connection.getContent(), System.err);
      throw new IOException("Invalid content type: " + contentType);
    }

    InputStream input = url.openStream();

    try
    {
      OutputStream output = new FileOutputStream(file);

      try
      {
        copy(input, output);
        output.close();
      }
      catch (IOException ex)
      {
        cleanupAfterProblem(output, file);
        throw ex;
      }
      catch (RuntimeException ex)
      {
        cleanupAfterProblem(output, file);
        throw ex;
      }
      catch (Error ex)
      {
        cleanupAfterProblem(output, file);
        throw ex;
      }
    }
    finally
    {
      input.close();
    }

    return file;
  }

  private static void cleanupAfterProblem(OutputStream stream, File file)
  {
    try
    {
      stream.close();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }

    try
    {
      delete(file);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private static void copy(InputStream input, OutputStream output) throws IOException
  {
    byte buffer[] = new byte[BUFFER_SIZE];
    copy(input, output, buffer);
  }

  private static void copy(InputStream input, OutputStream output, byte[] buffer) throws IOException
  {
    int n;
    while ((n = input.read(buffer)) != -1)
    {
      output.write(buffer, 0, n);
    }
  }

  private static void unzip(File zipFile, UnzipHandler handler) throws IOException
  {
    FileInputStream fis = new FileInputStream(zipFile);
    ZipInputStream zis = null;

    try
    {
      zis = new ZipInputStream(new BufferedInputStream(fis, BUFFER_SIZE));

      ZipEntry entry;
      while ((entry = zis.getNextEntry()) != null)
      {
        if (entry.isDirectory())
        {
          handler.unzipDirectory(entry.getName());
        }
        else
        {
          // TODO Provide delegating InputStream that ignores close()
          handler.unzipFile(entry.getName(), zis);
        }
      }
    }
    finally
    {
      zis.close();
      fis.close();
    }
  }

  private static void unzip(File zipFile, File targetFolder) throws IOException
  {
    System.out.println("Unzipping " + zipFile.getAbsolutePath() + " to " + targetFolder.getAbsolutePath());
    unzip(zipFile, new FileSystemUnzipHandler(targetFolder, BUFFER_SIZE));
  }

  /**
   * @author Eike Stepper
   */
  private interface UnzipHandler
  {
    public void unzipDirectory(String name) throws IOException;

    public void unzipFile(String name, InputStream zipStream) throws IOException;
  }

  /**
   * @author Eike Stepper
   */
  private static final class FileSystemUnzipHandler implements UnzipHandler
  {
    private File targetFolder;

    private transient byte[] buffer;

    public FileSystemUnzipHandler(File targetFolder, int bufferSize)
    {
      this.targetFolder = targetFolder;
      buffer = new byte[bufferSize];
    }

    public void unzipDirectory(String name)
    {
      File directory = new File(targetFolder, name);
      if (!directory.exists())
      {
        directory.mkdirs();
      }
    }

    public void unzipFile(String name, InputStream zipStream)
    {
      File targetFile = new File(targetFolder, name);
      if (!targetFile.getParentFile().exists())
      {
        targetFile.getParentFile().mkdirs();
      }

      try
      {
        FileOutputStream out = new FileOutputStream(targetFile);

        try
        {
          copy(zipStream, out, buffer);
        }
        finally
        {
          out.close();
        }
      }
      catch (IOException ex)
      {
        throw new RuntimeException(ex);
      }
    }
  }
}
