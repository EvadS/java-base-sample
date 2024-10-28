# log4j2  base information

## base appenders 

* ConsoleAppender – the appender that appends the log events to System.out or System.err with the default being System.out. When using this appender you will see your logs in the console of your application.
* FileAppender – the appender that appends the log events to a defined file storing them on the file system.
* RollingFileAppender – the appender that extends the FileAppender and rotates the file when it reaches a defined size. The use of RollingFileAppender prevents the log files from becoming very big and hard to maintain.
* SyslogAppender – the appender sending the log events to a remote Syslog daemon.
* JDBCAppender – the appender that stores the log events to the database. Keep in mind that this appender will not store errors and it is generally not the best idea to store the log events in a database.
* SocketAppender – the appender that sends the serialized log events to a remote socket. Keep in mind that this appender doesn’t use layouts because it sends the serialized, raw log events.
* NullAppender – the appender that just discards the log events.

## log4j introduction
log4j состоит из трех основных компонентов:
* Регистраторы : Ответственный за сбор информации журнала.
* appenders : Отвечает за публикацию информации о регистрации в различных предпочтительных местах назначения.
* макеты : отвечает за форматирование информации журнала в разных стилях.

Если не определить конфигурацию, то при запуске log4j2 выдаст гневное сообщение, о том, что конфигурация не задана и будет печатать ваши сообщения на консоль уровнем не ниже ERROR.
нужен api и log4j-core
```
ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
```

Конфигурация log4j2 задается несколькими вариантами: xml, json, yaml

## Demo log4j properties file 
default log level is the “error” and “fatal”
The default configuration simply logs to the console log entries with the level configured as “error” or higher

Each logger configuration contains:
 * appender section 
 * Loggers section

In loggers section should be Root. in thees place 
 - default log level 
 - appenders will be used by default (in log4j2.xml - root level all, appender by default is console )

#### Demo2 
```xml
  <Logger name="coreappender" level="info" additivity="false">
            <AppenderRef ref="coreappender"/>
        </Logger>
```
 - uses appender with name "coreappender" 
 - we use LEVEL.INFO  
 - additivity - exclude duplicates 

#### Demo 3 
```xml
  <!-- Логгер нашего класса -->
        <Logger name="com.se.sample.User" level="debug" additivity="false">
            <AppenderRef ref="Console"/>
        </Logger>
```
для класса com.se.sample.User
будет использоваться  апендер  с именем Console
level = debug и выше
дубликаты исключены