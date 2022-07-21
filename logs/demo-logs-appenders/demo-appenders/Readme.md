
base 
```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.14.1</version> <!-- update this! -->
</dependency>
```
to check
```bash
    mvn dependency:tree -Dincludes=org.apache.logging.log4j:log4j-core
```
ya-yay
````xml
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ demo-logs-appenders ---
[INFO] com.se.sample:demo-logs-appenders:jar:1.0-SNAPSHOT
[INFO] \- org.apache.logging.log4j:log4j-core:jar:2.14.1:compile
````

to make effective pom
```xml
   mvn help:effective-pom | grep log
```

log4j состоит из трех основных компонентов:
  * Регистраторы : Ответственный за сбор информации журнала.
  * appenders : Отвечает за публикацию информации о регистрации в различных предпочтительных местах назначения.
  * макеты : отвечает за форматирование информации журнала в разных стилях.

step1. Base appenders 
```properties
 ### Настройки ###
log4j.rootLogger = debug,stdout,D,E

### Вывод информации на контрольный лифт ###
log4j.appender.stdout = org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target = System.out
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n

### Вывести журналы выше уровня DEBUG в = E://logs/error.log ###
log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
log4j.appender.D.File = /imn/logs/log.log
log4j.appender.D.Append = true
log4j.appender.D.Threshold = DEBUG
log4j.appender.D.layout = org.apache.log4j.PatternLayout
log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

### Вывести журналы выше уровня ERROR в = E://logs/error.log ###
log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
log4j.appender.E.File =/imn/logs/error.log
log4j.appender.E.Append = true
log4j.appender.E.Threshold = ERROR
log4j.appender.E.layout = org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```

Result in file 
```path
/imn/logs/log.log
```
```txt
2022-07-21 19:15:33  [ main:0 ] - [ DEBUG ]  This is debug message.
2022-07-21 19:15:33  [ main:1 ] - [ INFO ]  This is info message.
2022-07-21 19:15:33  [ main:2 ] - [ ERROR ]  This is error message.

```
тип логирования - консоль
log4j.appender.stdout = org.apache.log4j.ConsoleAppender 


```
    https://javastudy.ru/log4j/log4j-hello-world-example/
```

- рутовый логгер - для всех 
- логгер для конкретного класса.

атрибут level=’debug’ и атрибут additivity=’true’.
* level — задает уровень на котором будет происходить логирование (например при дебаге, при ошибках или всегда).
* additivity — поможет убрать дубляж в логах. 

нужен api и log4j-core
```
ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
```

Automatic Configuration
