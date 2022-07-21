 
# Docker base command with it contaner

run SSH commands when starting a new Docker container.

## Creating the container named ubuntu_container_ssh and start a Bash session.
```
    sudo docker run --name ubuntu_container_ssh -i -t ubuntu
```

* The *name* of the container to run (ubuntu_container_ssh)
* The i flag indicating you’d like to open an interactive SSH session to the container. * The i flag does not close the SSH session even if the container is not attached.
* The t flag allocates a pseudo-TTY which much be used to run commands interactively.
* The base image to create the container from (ubuntu).


##  create a new folder named myfolder in the tmp
```bash
    touch /tmp/myfolder
```
## close the session.
```bash
    exit
```   

## To SSH into a running Docker container 
available containers 
```bash
 docker ps -a 
```

### run stopped container 

```
docker start ubuntu_container_ssh
```

## run bash in interractive mode
```
sudo docker exec -it ubuntu_container_ssh /bin/bash
```
