# Imn dependencies test 

## Sonar 

```bash
  mvn sonar:sonar 
```
qwerty123456
```sql


HOME/conf/sonar.properties file:
sonar.forceAuthentication=false



```
    mvn clean install -P dev-build
```


```
    mvn dependency:tree -P dev-build
```

```
    mvn -X sonar:sonar -P dev-build
```



 java -jar imn-my-test-1.0-SNAPSHOT.jar  org.example.App

VM OPTIONS 
```
    -Dlog4j2.configurationFile=resources/HSMDecryptTool/log4j2-text.xml
```


## Run on deployed dirrectory 
```
    /imn/3rdparty/jdk-17/bin/java -DappName=HSMDecryptTool -Xms12m -Xmx512m -Xss512k -XX:+HeapDumpOnOutOfMemoryError \
    -XX:HeapDumpPath=/tmp/heapdump.bin -Djava.security.egd=file:///dev/urandom \
    -Djdk.tls.client.protocols=TLSv1,TLSv1.1,TLSv1.2 \
    -Dresolver-memory=12 -Dcfg-db.site=2 \
    -Dcfg-db.app=HSMDecryptTool \
    -classpath resources/HSMDecryptTool/log4j2-text.xml:lib/* org.example.App
```

## work correct 
```bash
/imn/3rdparty/jdk-17/bin/java -DappName=HSMDecryptTool -Xms12m -Xmx512m -Xss512k -XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/tmp/heapdump.bin -Djava.security.egd=file:///dev/urandom \
-Djdk.tls.client.protocols=TLSv1,TLSv1.1,TLSv1.2 \
-Dresolver-memory=12 -Dcfg-db.site=2 \
-Dcfg-db.app=HSMDecryptTool \
-Dlog4j2.configurationFile=resources/HSMDecryptTool/log4j2-text.xml \
-classpath resources/HSMDecryptTool/log4j2-text.xml:lib/* org.example.App
```