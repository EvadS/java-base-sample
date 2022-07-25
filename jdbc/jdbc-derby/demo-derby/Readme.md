

JAVA 17



export DERBY_HOME=/home/softkit/software/derby
export PATH="$DERBY_HOME/bin:$PATH"


source .bashrc

. ~/.bashrc



Step 1. Derby terminal
```
    ./bin/ij
```

Step 2. Create Database
```
   connect 'jdbc:derby:logger-db;create=true';
```

connect to DataBase
```
 connect 'jdbc:derby:logger-db' user 'user' password 'oracle';
```


SQL demo
```
    CREATE SCHEMA schema_name AUTHORIZATION userName;
```

DROP SCHEMA schema_name RESTRICT
-----------


### check connection
inside libs
```
    java -jar -Dij.protocol=jdbc:derby: -Dij.database=logger-db derbyrun.jar ij
```

Example response
```
ij version 10.13
CONNECTION0* - 	jdbc:derby:baeldung
* = current connection
```

```
    java -jar -Dij.protocol=jdbc:derby: -Dij.database=baeldung derbyrun.jar ij
```


### DBLook
tool provides the DDL (Data Definition Language) of the database
```
 $DERBY_HOME/bin/dblook -d jdbc:derby:baeldung
```
variant 2
```
 $DERBY_HOME/bin/logger-db -d jdbc:derby:baeldung
```


### Sysinfo
displays information regarding our Java environment and the Derby version
```
    java -jar $DERBY_HOME/lib/derbyrun.jar sysinfo
```

## Use Apache Derby in Embedded Mode
```
    jdbc:derby:[subsubprotocol:][databaseName][;attribute=value]
```
### sample
String urlConnection = "jdbc:derby:baeldung";
String urlConnection = "jdbc:derby:baeldung;create=true";


## Use Apache Derby in Client/Server Mode
in /lib folder

#### start server 
```
    java -jar $DERBY_HOME/lib/derbyrun.jar server start
```

#### change db mode 
```
./bin/setNetworkClientCP
```

#### create data base 
```
 connect 'jdbc:derby://localhost:1527/logger-db;create=true';
```


```properties
 connect 'jdbc:derby://localhost:1527/logger-db;create=true'; 
```

create database with user and pwd 
```
    connect 'jdbc:derby://localhost:1527/logger-db;create=true'  user 'user' password 'oracle';
```

#### connection string 
```java
String urlConnection = "jdbc:derby://localhost:1527/logger-db"
```

## UTILS

### enable all permistion
```bash
    chmod -R 777 ./
```

