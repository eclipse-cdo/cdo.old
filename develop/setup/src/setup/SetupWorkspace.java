package setup;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
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
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SetupWorkspace
{
  public static final String DOWNLOAD_OVERRIDE_FILE = "SetupWorkspace.properties";

  public static final String DOWNLOAD_OVERRIDE_PROPERTY = "download.dir";

  public static final String DOWNLOAD_DIR = "/develop/downloads";

  private static File downloads;

  private static final int BUFFER_SIZE = 16 * 1024;

  public static void main(String[] args) throws Exception
  {
    downloads = getDownloadsOverride(System.getProperty("user.dir"));
    if (downloads == null)
    {
      downloads = getDownloadsOverride(System.getProperty("user.home"));
    }

    if (downloads == null)
    {
      downloads = new File(getTempDir(), DOWNLOAD_DIR);
    }

    downloads.mkdirs();
    System.out.println("Downloads: " + downloads);

    File workspace = new File("..").getCanonicalFile();
    System.out.println("Workspace: " + workspace.getAbsolutePath());

    File baseline = new File(workspace, ".baseline");
    File target = new File(workspace, ".target");

    System.out.println();
    deleteTarget(baseline);
    deleteTarget(target);

    setup(baseline, new File("urls-baseline.txt"));
    setup(target, new File("urls-target.txt"));
  }

  private static File getDownloadsOverride(String path) throws IOException
  {
    File file = new File(path, DOWNLOAD_OVERRIDE_FILE);
    if (!file.canRead())
    {
      return null;
    }

    Properties properties = new Properties();
    properties.load(new FileInputStream(file));

    String downloadDir = properties.getProperty(DOWNLOAD_OVERRIDE_PROPERTY);
    if (downloadDir == null)
    {
      return null;
    }

    return new File(downloadDir).getCanonicalFile();
  }

  private static File getTempDir() throws IOException
  {
    File tempDir = new File(System.getProperty("java.io.tmpdir"));
    if (!tempDir.canWrite())
    {
      throw new IOException("Temporary directory (needed for download) does not exist or is not writable");
    }

    return tempDir.getCanonicalFile();
  }

  private static void setup(File target, File urls) throws IOException
  {
    System.out.println();
    System.out.println("Setting up " + target.getAbsolutePath());
    System.out.println();
    List<File> downloadedFiles = new ArrayList<File>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(urls)));
    String url;
    while ((url = reader.readLine()) != null)
    {
      File downloadedFile = download(new URL(url.trim()));
      downloadedFiles.add(downloadedFile);
    }

    System.out.println();
    for (File packedFile : downloadedFiles)
    {
      if (packedFile.getName().endsWith(".zip"))
      {
        System.out.println("Unpacking " + packedFile.getName());
        unzip(packedFile, target);
      }
      else if (packedFile.getName().endsWith(".tar.gz"))
      {
        System.out.println("Unpacking " + packedFile.getName());
        untargz(packedFile, target);
      }
      else
      {
        System.out.println("Unknown file type " + packedFile.getAbsolutePath());
      }
    }
  }

  private static void deleteTarget(File target) throws IOException
  {
    System.out.println("Deleting " + target);
    delete(target);
    if (target.exists())
    {
      throw new IOException("Could not delete " + target.getAbsolutePath());
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

      System.out.println("Skipping download of " + file.getName());
      return file;
    }

    System.out.println("Downloading " + file.getName());

    URLConnection connection = url.openConnection();
    String contentType = connection.getContentType();
    if (!("application/zip".equals(contentType) || "application/x-gzip".equals(contentType)))
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
        close(output);
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
      close(input);
    }

    return file;
  }

  private static void cleanupAfterProblem(OutputStream stream, File file)
  {
    try
    {
      close(stream);
      delete(file);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private static void close(Closeable closeable)
  {
    try
    {
      if (closeable != null)
      {
        closeable.close();
      }
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

  private static void unzip(File zipFile, UnpackHandler handler) throws IOException
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
          handler.unpackDirectory(entry.getName());
        }
        else
        {
          // TODO Provide delegating InputStream that ignores close()
          handler.unpackFile(entry.getName(), zis);
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      close(zis);
      close(fis);
    }
  }

  private static void unzip(File zipFile, File targetFolder) throws IOException
  {
    unzip(zipFile, new FileSystemUnpackHandler(targetFolder, BUFFER_SIZE));
  }

  private static void untargz(File targzFile, UnpackHandler handler) throws IOException
  {
    FileInputStream fis = new FileInputStream(targzFile);
    TarInputStream tis = null;

    try
    {
      tis = new TarInputStream(new GZIPInputStream(new BufferedInputStream(fis, BUFFER_SIZE)));

      TarEntry entry;
      while ((entry = tis.getNextEntry()) != null)
      {
        if (entry.isDirectory())
        {
          handler.unpackDirectory(entry.getName());
        }
        else
        {
          handler.unpackFile(entry.getName(), tis);
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      close(tis);
      close(fis);
    }
  }

  private static void untargz(File targzFile, File targetFolder) throws IOException
  {
    untargz(targzFile, new FileSystemUnpackHandler(targetFolder, BUFFER_SIZE));
  }

  /**
   * @author Eike Stepper
   */
  private interface UnpackHandler
  {
    public void unpackDirectory(String name) throws IOException;

    public void unpackFile(String name, InputStream packedStream) throws IOException;
  }

  /**
   * @author Eike Stepper
   */
  private static final class FileSystemUnpackHandler implements UnpackHandler
  {
    private File targetFolder;

    private transient byte[] buffer;

    public FileSystemUnpackHandler(File targetFolder, int bufferSize)
    {
      this.targetFolder = targetFolder;
      buffer = new byte[bufferSize];
    }

    public void unpackDirectory(String name)
    {
      File directory = new File(targetFolder, name);
      if (!directory.exists())
      {
        directory.mkdirs();
      }
    }

    public void unpackFile(String name, InputStream packedStream)
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
          copy(packedStream, out, buffer);
        }
        finally
        {
          close(out);
        }
      }
      catch (IOException ex)
      {
        throw new RuntimeException(ex);
      }
    }
  }
}
