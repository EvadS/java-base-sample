# Tomcat log4j2 demo
Describe how to work with log4j with irregular logger configuration file name 

## the scenario in a nutshell
 default logger location  is resources folder 
default logger name is log4j2.xml. we should make additional steps to configure logger setting file used

## Set up loggers 
A file named log4j2-tomcat.xml, log4j2-tomcat.json, log4j2-tomcat.yaml, log4j2-tomcat.yml, or log4j2-tomcat.properties must also be placed in the boot classpath. This is most easily done by:

### setup for all 
1. Creating a set of directories in catalina home named log4j2/lib and log4j2/conf.
2. Placing log4j2-api-2.19.0.jar, log4j2-core-2.19.0.jar, and log4j2-appserver-2.19.0.jar in the log4j2/lib directory.

3. Creating a file named log4j2-tomcat.xml, log4j2-tomcat.json, log4j2-tomcat.yaml, log4j2-tomcat.yml, or log4j2-tomcat.properties in the log4j2/conf directory.
Create or modify setenv.sh in the tomcat **bin** directory to include CLASSPATH=$CATALINA_HOME/log4j2/lib/*:$CATALINA_HOME/log4j2/conf

You can use logs folders with lib s and conf from logs-lib in this  project root directory

### setenv.sh file
```properties
    CLASSPATH="$CLASSPATH""$CATALINA_HOME"/log4j2/lib/*:"$CATALINA_HOME"/log4j2/conf
    CATALINA_OPTS="${CATALINA_OPTS} -Dlog4j.configurationFile=${CATALINA_HOME}/log4j2/conf/log4j2-text.xml"
```

optional. The application name
```properties
    CATALINA_OPTS="${CATALINA_OPTS} -DappName=test"
```

### Application address on local 

#### App was started from intellij
```http request
   http://localhost:8080/tomcat_hello_world_war/
```
#### Run from command line in tomcat

move to ${CATALINA_HOME}/bin directory 
Use the next command to start tomcat in Unix
```bash
  ./startup.sh 
```
to check runing service 
```http request
 http://localhost:8080/tomcat_hello_world_war/
```

