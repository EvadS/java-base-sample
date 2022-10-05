# Crypte demo
Непомню что это

Генерируем сертификат

### base winwods

```bash
keytool -genkeypair -alias ssl -keyalg RSA -keysize 2048 -dname "CN=localhost,OU=IT,O=Javarush,L=SaintPetersburg,C=RU,email=contact@email.com" -validity 90 -keystore C:/keystore.jks -storepass passw0rd -keypass passw0rd -ext san:critical=dns:localhost,ip:127.0.0.1 -ext bc=ca:false
```

### ubuntu

```bash
keytool -genkeypair -alias ssl -keyalg RSA -keysize 2048 -dname "CN=localhost,OU=IT,O=selo,L=ZP,C=RU,email=contact@email.com" -validity 90 -keystore /home/softkit/Documents/keystore/keystore.jks -storepass 123456 -keypass passw0rd -ext san:critical=dns:localhost,ip:172.17.0.1 -ext bc=ca:false
```

импорт

```bash
keytool -importkeystore -srckeystore /home/softkit/Documents/keystore/keystore.jks -destkeystore /home/softkit/Documents/keystore/keystore.jks  -deststoretype pkcs12
```

экспорта сертификата в файл

```bash
   keytool -export -alias ssl -storepass 123456 -file /home/softkit/Documents/keystore/server.cer -keystore /home/softkit/Documents/keystore/keystore.jks
```

```bash
    /home/softkit/Documents/certification-manager/downloaded
```

```bash
    chmod -R 777 /home/softkit/Documents/certification-manager/
```


закинуть by ssh откуда -> куда

```bash
scp /home/softkit/Documents/keystore/server.cer root@172.17.0.2:/home/
```

прробуем создать сертификат в докере

mypassword - root

```bash
keytool -genkeypair -alias demo-two -keyalg RSA -keysize 2048 -dname "CN=localhost,OU=IT,O=dockerPne,L=Kiev,C=UA,email=contact@email.com" -validity 90 -keystore /home/keystore.jks -storepass passw0rd -keypass mypassword -ext san:critical=dns:localhost,ip:172.17.0.2 -ext bc=ca:false
```


```bash
   keytool -export -alias demo-two -storepass passw0rd -file /home/server.cer -keystore /home/keystore.jks
```

скачать сертификат


```bash
scp username@hostname:/path/to/remote/file /path/to/local/file
```

```bash
scp root@172.17.0.2:/home/server.cer /home/softkit/Documents/server.cer
```
