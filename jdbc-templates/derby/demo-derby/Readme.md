
## Install
JAVA 17
```
    export DERBY_HOME=/home/softkit/software/derby
    export PATH="$DERBY_HOME/bin:$PATH"
```

source .bashrc
```
. ~/.bashrc
```

## Embedded db
Connect to Apache Derby in Embedded Mode
```
    jdbc:derby:[subsubprotocol:][databaseName][;attribute=value]
```
### Step 1. Derby terminal

```bash
    ./bin/ij
```

### Step 2. Create Database
Db will be created when not exists 
```bash
   connect 'jdbc:derby:logger-db;create=true';
```
sample response
```
    ij version 10.16
    ij>  connect 'jdbc:derby:logger-db;create=true';
    WARNING 01J01: Database 'logger-db' not created, connection made to existing database instead.
```

connect to DataBase with users name and pwd 
```
 connect 'jdbc:derby:logger-db' user 'user' password 'oracle';
```
working with database in ij console 
```sql
    CREATE SCHEMA schema_name AUTHORIZATION userName;
```
```
DROP SCHEMA schema_name RESTRICT
```

### Utils 
#### check connection
location $DERBY_HOME/lib
```
    java -jar -Dij.protocol=jdbc:derby: -Dij.database=logger-db derbyrun.jar ij
```
response like sample 
```
    ij version 10.16
    CONNECTION0* -  jdbc:derby:logger-db
    * = current connection
```

#### DBLook
tool provides the DDL (Data Definition Language) of the database
```
 $DERBY_HOME/bin/dblook -d jdbc:derby:logger-db
```
Response 
```
-- Timestamp: 2022-07-26 10:17:54.033
-- Source database is: logger-db
-- Connection URL is: jdbc:derby:logger-db
-- appendLogs: false
```
### Sysinfo
displays information regarding our Java environment and the Derby version
```
    java -jar $DERBY_HOME/lib/derbyrun.jar sysinfo
```

### Jdbc sample
String urlConnection = "jdbc:derby:baeldung";
String urlConnection = "jdbc:derby:baeldung;create=true";
---------------
## Use Apache Derby in Server/Client Mode
in $DERBY_HOME/lib folder
#### start server 
```bash
    java -jar $DERBY_HOME/lib/derbyrun.jar server start
```

#### change db mode 
```bash
    ./bin/setNetworkClientCP
```
#### run client 

```bash
    ./bin/ij
```

#### create database 
```bash
 connect 'jdbc:derby://localhost:1527/logger-db;create=true';
```
#### create database with user and pwd 
```bash
    connect 'jdbc:derby://localhost:1527/logger-db;create=true'  user 'user' password 'oracle';
```
#### connection string 
```java
    String urlConnection = "jdbc:derby://localhost:1527/logger-db"
```
#### unix UTILS
enable all permission
```bash
    chmod -R 777 ./
```