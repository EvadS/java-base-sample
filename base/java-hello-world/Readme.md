# Your First Java Program

## the three basic steps required to get a simple program running.
I use this sceleton to show javac manually flow

## Requiements
 java comppiler and JAVA_HOME

### check is java installed
```
   java --version
```

### check java home system property

windows
```
   echo $JAVA_HOME
```
linux
```
  echo %JAVA_HOME%
```

### Set java home system property
only current terminal

```bash
    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

```bash
    export PATH=${PATH}:${JAVA_HOME}/bin
```

```bash
    ~/.bashrc
```


## Programming in Java.
### compile
```bash
    javac src/Program.java
```
will be created *.class file or printed errors

### run
move directories with *.class file

```bash
    java Program
```

