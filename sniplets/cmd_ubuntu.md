# unix cmp samples

## crds
### set all credential
```bash
    chmod -R 777 /tmp/routing-conf
```


## SSH working

### Download Folder
```bash
  sshpass -p "PASSWOR" scp -r y804476@10.164.210.44:/tmp/routing-conf  /imn/downloaded/
```


#### File
```bash
  sshpass -p "PASSWOR" scp -r y804476@10.164.210.44:/imn/app/imn-datasync-1.0.0.12_sasi/bin/functions /imn/tmp/imn-datasync/functions
```



#### Current java  processing
```
    ps -ef|grep java
```


#### Aliases

in .bashrc

alias psjava="ps -ef|grep java"


