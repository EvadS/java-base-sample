

-Dlog4j.configuration=log4j-dev.xml

```
-Dlog4j.configuration=/home/softkit/Documents/projects/Learning/java-base-sample/tomcat/tomcat-hello-world/src/main/resources/config/log4j-dev.properties
```


workied without 

CLASSPATH=$CATALINA_HOME/log4j2/lib/*:$CATALINA_HOME/log4j2/conf
CATALINA_OPTS="${CATALINA_OPTS} -Dlog4j.configurationFile=${CATALINA_HOME}/log4j2/conf/log4j2-text.xml"
CATALINA_OPTS="${CATALINA_OPTS} -DappName=test"