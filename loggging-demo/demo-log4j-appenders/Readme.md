# Log4j hello world example

logs messages with different priorities, for example, debug, info, warn, error and fatal.

Example : Logger is set to debug priority.

```log4j.properties
log4j.rootLogger=DEBUG, stdout
```

will be lacated in project root 
log4j.appender.file.File=\log4j-application.log