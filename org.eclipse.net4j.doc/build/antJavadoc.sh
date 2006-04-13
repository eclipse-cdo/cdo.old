#!/bin/sh

# BEGIN CUSTOMIZATIONS

# The plugin name
pluginName="org.eclipse.net4j"; 

# string labels for javadoc content
windowTitle="Net4j Javadoc";
groupTitle="Net4j";

# files to exclude from javadoc process - use Ant syntax
javadocExclusions="<exclude name=\"**/internal/**\"/> <exclude name=\"**/examples/**\"/> <exclude name=\"**/tests/**\"/>";

# use 1.5
export JAVA_HOME=/opt/sun-java2-5.0

# END CUSTOMIZATIONS

##########################################################################

debug=0; if [ $debug -gt 0 ]; then echo "[antJd] debug: "$debug; fi

if [ "x"$ANT_HOME = "x" ]; then export ANT_HOME=/opt/apache-ant-1.6; fi
if [ "x"$JAVA_HOME = "x" ]; then export JAVA_HOME=/opt/ibm-java2-1.4; fi
export PATH=${PATH}:${ANT_HOME}/bin

# current directory - all but the name of this script, no trailing slash
currentPath=$PWD"/"$0; currentPath=${currentPath%/*}; if [ $debug -gt 0 ]; then echo "[antJd] currentPath: "$currentPath; fi

# path to $buildID/eclipse/plugins, no trailing slash
pluginPath=${currentPath%/$pluginName*}; if [ $debug -gt 0 ]; then echo "[antJd] pluginName: "$pluginName; echo "[antJd] pluginPath: "$pluginPath; fi

# ant script to create and then execute
antScript=$currentPath"/javadoc.xml"; if [ $debug -gt 0 ]; then echo "[antJd] antScript: "$antScript; fi

# The eclipse directory
eclipseDir=`cd $1; echo $PWD`; if [ $debug -gt 0 ]; then echo "[antJd] eclipseDir: "$eclipseDir; fi

# The destination directory
destDir=$currentPath/../references/javadoc; mkdir -p $destDir; destDir=`cd $destDir; echo $PWD`; # resolve relative path
if [ $debug -gt 0 ]; then echo "[antJd] destDir: "$destDir; fi

hasToken=`grep "@plugin@" $antScript.template`;
if [ "x$hasToken" != "x"  ]; then
	srcDir=$pluginPath/$pluginName/src; if [ $debug -gt 0 ]; then echo "[antJd] srcDir: "$srcDir; fi
	if [ -d "$srcDir" ]; then
		if [ $debug -gt 0 ]; then echo "[antJd] *.java in \$srcDir: "; echo "-----------------"; echo `find $srcDir -type f -name '*.java'`; echo "-----------------"; fi
		packages=`find $srcDir -type f -name '*.java' -exec grep -e '^package .*;' {} \; | sed -e 's/^package *\(.*\);/\1/' | sed -e 's/[ ]*//g' | sort | uniq | xargs | sed -e 's/ /:/g'`;
		if [ $debug -gt 1 ]; then echo "[antJd] packages1: "$packages; fi
		packages=`echo $packages | sed -e 's/\//\\\\\\//g' | sed -e 's/\./\\\\\./g'`; # slash escape
		if [ $debug -gt 1 ]; then echo "[antJd] packages2: "$packages; fi
		sed -e "s/\@plugin\@/${packages}/g" $antScript.template > $antScript.template.tmp;
	fi
else 
	echo "[antJd] ERROR! "$currentPath"/javadoc.xml.template does not contain token @plugin@!";
fi

# Finds plugins in the Workspace:
pluginDirs=`find $pluginPath -name "${pluginName}*" -maxdepth 1 -type d -printf '%T@ %p\n' | sort -n | cut -f2 -d' '`; 
if [ $debug -gt 0 ]; then 
	echo "[antJd] pluginDirs:"; 
	for pluginDir in $pluginDirs; do echo "[antJd]   "$pluginDir; done
fi

### TODO?: missing emf/sdo/xsd plugins in $eclipseDir - need to copy them over or reference source so that all classes/packages (and thus @links) can be resolved

# All the jars in the plugins directory
classpath=`find $eclipseDir/plugins -name "*.jar" -printf "%p:"`; if [ $debug -gt 0 ]; then echo "[antJd] classpath: "$classpath; fi

# Calculates the packagesets and the calls to copyDocFiles
packagesets="";
copydocfiles="";
for pluginDir in $pluginDirs; do
	pluginDir=`echo $pluginDir | sed -e 's/\/runtime$//g'`;
	srcDir=$pluginDir/src;
	if [ $debug -gt 0 ]; then echo "[antJd] srcDir: "$srcDir; fi
	if [ -d "$srcDir" ]; then
		# define what to include when javadoc'ing here:
		packagesets=$packagesets"<packageset dir=\"$srcDir\"> ";
		packagesets=$packagesets"<exclude name=\"$srcDir/**/doc-files/**\"/> ";
		packagesets=$packagesets""$javadocExclusions;
		packagesets=$packagesets"</packageset>";
		copydocfiles=$copydocfiles"<copyDocFiles pluginDir=\"$pluginDir\"/>";
	fi
done
if [ $debug -gt 0 ]; then 
	echo "[antJd] packagesets:";	echo $packagesets;
	echo "[antJd] copydocfiles:";	echo $copydocfiles;
fi
	
# Finds the proper org.eclipse.platform.doc.isv jar
docjar=`find $eclipseDir/plugins/ -name "org.eclipse.platform.doc.isv*.jar" -printf "%f"`; if [ $debug -gt 1 ]; then echo "[antJd] docjar: "$docjar; fi

if [ -f $antScript.template ]; then
	true;
else
	cp $antScript.template $antScript.template.tmp;
fi

# do replacements in template
if [ $debug -gt 1 ]; then echo "[antJd] Replace @packagesets@ in the template ..."; fi
packagesets=`echo $packagesets | sed -e 's/\//\\\\\\//g' | sed -e 's/\./\\\\\./g'`;
sed -e "s/\@packagesets\@/${packagesets}/g" $antScript.template.tmp > $antScript.template.tmp2;

if [ $debug -gt 1 ]; then echo "[antJd] Replace @copydocfiles@ in the template ..."; fi
copydocfiles=`echo $copydocfiles | sed -e 's/\//\\\\\\//g' | sed -e 's/\./\\\\\./g'`;
sed -e "s/\@copydocfiles\@/${copydocfiles}/g" $antScript.template.tmp2 > $antScript;

#run ant to do javadoc build
ant -f $antScript \
	-DdestDir="$destDir" \
	-Dclasspath="$classpath" \
	-DeclipseDir="$eclipseDir" \
	-Ddocjar="$docjar" \
	-DwindowTitle="$windowTitle" \
	-DgroupTitle="$groupTitle" \
	-Doverview="$currentPath/overview.html";

# Clean up templates
rm -f $antScript $antScript.template.tmp $antScript.template.tmp2;
