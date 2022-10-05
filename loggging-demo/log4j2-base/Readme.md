# Log4j2 base

## base log configuration file 
```
    resources/log4j2.xml
```

## How set log config file 
### To set logger settings use VM arguments in intellij 
```properties
    -Dlog4j.configurationFile=conf/log4j2-text.properties
```

### command line arguments 

```http request
  java -Dlog4j.configurationFile=conf/log4j2-text.properties  -jar target/log-demo.jar
```