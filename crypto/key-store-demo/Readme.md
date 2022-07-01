Java KeyStore 

base winwods

```
keytool -genkeypair -alias ssl -keyalg RSA -keysize 2048 -dname "CN=localhost,OU=IT,O=Javarush,L=SaintPetersburg,C=RU,email=contact@email.com" -validity 90 -keystore C:/keystore.jks -storepass passw0rd -keypass passw0rd -ext san:critical=dns:localhost,ip:127.0.0.1 -ext bc=ca:false
```
ubuntu
```
keytool -genkeypair -alias ssl -keyalg RSA -keysize 2048 -dname "CN=localhost,OU=IT,O=selo,L=ZP,C=RU,email=contact@email.com" -validity 90 -keystore /home/softkit/Documents/keystore/keystore.jks -storepass 123456 -keypass passw0rd -ext san:critical=dns:localhost,ip:172.17.0.1 -ext bc=ca:false
```

импорт

```
keytool -importkeystore -srckeystore /home/softkit/Documents/keystore/keystore.jks -destkeystore /home/softkit/Documents/keystore/keystore.jks  -deststoretype pkcs12
```

экспорта сертификата в файл
```
   keytool -export -alias ssl -storepass 123456 -file /home/softkit/Documents/keystore/server.cer -keystore /home/softkit/Documents/keystore/keystore.jks
```

/Documents/certification-manager/downloaded

chmod -R 777 /home/softkit/Documents/certification-manager/


закинуть by ssh откуда -> куда
scp /home/softkit/Documents/keystore/server.cer root@172.17.0.2:/home/
