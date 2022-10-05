# Oracle Db DBMS_CRYPTO

используется пакет шифрования DBMS_CRYPTO
при попытке вызова без дополнительных дествий - не будет работать, поскольку
изначально права у sys, мы работаем под system

## oracle Db in docker container

по умолчанию
 username=system
password=oracle

## display runned docker containers
```
docker ps
```
## Open SQL plus command line in run container by name :
my container has the name oracle01

```bash
docker exec -it oracle01 /bin/bash
```
Run SQL console with system database administrator role

```bash
sqlplus sys as sysdba
```

## to check all users
```sql
    SELECT USERNAME FROM dba_users;
```

## Add credential to use DBMS_CRYPTO by system user
```
GRANT EXECUTE ON sys.DBMS_CRYPTO TO SYSTEM;
```
OR
```
grant execute on dbms_crypto to SYSTEM;
```

проверить в SQL клиенте
```
   select * from dba_tab_privs where table_name = 'DBMS_CRYPTO' and owner = 'SYS';
```

результат должен быть как на DBMS_CRYPTO_to_system_user.jpg
