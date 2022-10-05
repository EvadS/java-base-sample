# Maven usefully command
## generate java project 
```mvn
 mvn archetype:generate -DgroupId=com.se.sample \
 -DartifactId=executable-java-base \
 -DarchetypeArtifactId=maven-archetype-quickstart \
 -DinteractiveMode=false
```



## Maven plugins

### 1. Compilation plugin 
```xml
<properties>
    <jdkVersion>17</jdkVersion>
</properties>

<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>2.3.2</version>
	<configuration>
		<source>${jdkVersion}</source>
		<target>${jdkVersion}</target>
	</configuration>
</plugin>
```
### 2. maven-dependency-plugin
copy all dependencies to target 
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <configuration>
        <outputDirectory>${project.build.directory}/lib/</outputDirectory>
        <overWriteReleases>false</overWriteReleases>
        <overWriteSnapshots>false</overWriteSnapshots>
        <overWriteIfNewer>true</overWriteIfNewer>
    </configuration>
    <executions>
        <execution>
            <id>copy-dependencies</id>
            <phase>package</phase>
            <goals>
                <goal>copy-dependencies</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
Take a notice, all dependency put to lib directory. Use **package** phase

### 3. Make manifest
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <classpathPrefix>lib/</classpathPrefix>
                <classpathLayoutType>simple</classpathLayoutType>
                <mainClass>com.khmb.block_v2.Block_v2App</mainClass>
            </manifest>
            <manifestEntries>
                <Version>${buildNumber}</Version>
            </manifestEntries>
        </archive>
    </configuration>
</plugin>
```


### 4. build number plugin 
The role of the plugin is to generate a version number
```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>buildnumber-maven-plugin</artifactId>
    <version>1.0</version>
    <configuration>
        <format>{0}-{1,date,yyyyMMdd}</format>
        <items>
            <item>${project.version}</item>
            <item>timestamp</item>
        </items>
        <doCheck>true</doCheck>
        <doUpdate>true</doUpdate>
    </configuration>
    <executions>
        <execution>
            <phase>validate</phase>
            <goals>
                <goal>create</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```


## Executable jar

#### Step 1  
The default java version is 6. That one should be changed

```xml
    <properties>
        <java.version>11</java.version>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>
```
#### step 2. 
Put maven-jar-plugin to pom file

#### step 3.
put maven-dependency-plugin if to use dependencies uses 