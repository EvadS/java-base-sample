# Describe how to use ssh command by sshpass

## FROM -> TO

## change permission
```bash
    chmod -R 777 /tmp/imn-datasync
```

## download

### file
```bash
    sshpass -p "PASSWORD" scp  y804476@10.164.210.44:/imn/3rdparty/jdk-17  /imn/downloaded/jdk-17
```

### folder
```bash
    sshpass -p "PASSWORD" scp -r y804476@10.164.210.44:/imn/3rdparty/jdk-17  /imn/downloaded/jdk-17
```

### authorization by public key

#### upload

FROM -> TO
```bash
    scp /Documents/keystore/server.cer root@172.17.0.2:/home/
```
