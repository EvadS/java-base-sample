# Base carcase to made executable jar file
## Technologies
* maven
### compile 
```bash
   mvn clean install
```
### run 
```bash
  java -jar target/executable-java-base-1.0.jar
```


## Args in main 
### intellij
program arguments section

### command line 

```bash 
    java -jar target/executable-java-cmd-1.0.jar  1 2 3 4 5
```

how to parse 
```java
  for(String str: args){
        // convert into integer type
        int argument=Integer.parseInt(str);
        }
```

```
export JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8001,server=y,suspend=n -Xms512m -Xmx512m"
java   $JAVA_OPTS -jar target/executable-java-cmd-1.0.jar
```
### System property 
full list of the standard Java JVM command line options, -> java.exe
-D<name>=<value>
set a system property

#### creation like so:
-Dblog=JRebelBlog 

#### using 
System.getProperty("blog"); //JRebelBlog


##### intrlijj 
VM options

#### test -D 
```java
  java -Dcfg-db.group=build -Dcfg-db.url=jdbc:oracle:thin:@localhost:9001:mesdev -Dcfg-db.user=IMNDEVDB -Dcfg-db.passwd=IMNDEVDB -Dcfg-db.driver=oracle.jdbc.driver.OracleDriver -Dresolver-memory=12 -Dcfg-db.site=2 -Dcfg-db.app=accepter -jar target/executable-java-cmd-1.0.jar

```
