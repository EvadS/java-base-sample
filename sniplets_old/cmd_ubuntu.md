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

#### output

Run on background - nohub (No Hang Up)
###
    nohup ...
###

(No Hang Up)
nohub.out will be generate. This file contains output from runned processing

Or we can set up specified file to output (stdout) information
```
    nohub ... >> output.txt
```
To disable output information
```
    nohup java -jar java-base.jar>> /dev/null
```

3. To run a command in the background (with ‘&’)
```
    nohup java -jar java-base.jar &
```

 It can be brought back to the foreground with the fg command.




