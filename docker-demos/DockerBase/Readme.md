

## Building the docker Image
```
    sudo docker build -t sshd_tagged_image .
```

## run the docker to inspect the create
 ```bash
 docker images
 ```

## Running the container using the newly built image
```bash
    docker run -d -P --name test_sshd_container sshd_tagged_image
```

 Run *docker port* to verify SSH connectivity between the Docker host and the container. The docker port command list’s the port mappings or a specific mapping for the container.

 ```bash
 sudo docker port test_sshd_container
 ```

 ## find the IP address of the container
 ```bash
    docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' test_sshd_container
 ```

 ## try to SSH to the container, and it should work

```bash
 base ssh root@Ip-Address-of-the-container
 ```

 ```bash
  ssh root@172.17.0.3
```
