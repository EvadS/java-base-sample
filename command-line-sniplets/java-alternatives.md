# Alternatives command 

## find java location
```bash
  which java 
```

## java alteernatives list 
```bash
  update-java-alternatives -l
```

## change java VM  version
```bash
	sudo update-alternatives --config java
```

## change java compiler version
```
	sudo update-alternatives --config javac
```

## add java from jvm-directory 
```
	sudo update-alternatives  --install /usr/bin/java java /usr/lib/jvm/jdk-12.0.1/bin/java 2082
```
