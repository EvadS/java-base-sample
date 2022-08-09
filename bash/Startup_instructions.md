 
##  BASH «Bourne Again Shell».

просто комманда
### Comment1
bash: ./sample1.sh: Permission denied  -> "-rw-rw-r--"
solution
```bash
    sudo chmod +x  sample1.sh
```
result: "-rwxrwxr-x"

### comment2. имя файла и функция совпадает

 testFunction.sh -> testfunction()
```
sudo chmod +x  testFunction.sh
```

```
 ./testFunction.sh,
```

### comment3. several parametes
```
sudo chmod +x  testFunction2.sh
```
```
./testFunction2.sh 100  200
```



ls -la /bin/sh

 Список доступных оболочек можно проверить, введя следующую команду:

cat /etc/shells




## Vi
switch to edit mode : -> "i"
delete row -> "dd"

save ->
    switch to command mode -> "ESC"
    чтобы сохранить и выйти -> "wq"
