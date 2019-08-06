## Docker
You can use docker to test issues you have with the SDK.

1.  Install docker
    -   Mac: <https://docs.docker.com/docker-for-mac/install/>
    -   Windows: <https://docs.docker.com/docker-for-windows/install/>

2.  Download the dockerfile for this SDK and edit as needed.
    -   Change the maven version as needed `FROM maven:<your-version>` ( this java project is built using maven )
        -   For valid maven java images on docker see <https://hub.docker.com/_/maven>

    -   Copy code/project that you wish to test into the dockerfile 
        -   Add line `COPY <src>... <dest>`
        -   App Path: `/src/main/java/java-sdk-docker-app`
        -   Test Path: `/src/test/java/java-sdk-docker-app`

    -   Set dockerfile to execute code
        -   Add line `CMD [ "<executable>" ]`
    
    -   For more information on dockerfile construction please visit <https://docs.docker.com/engine/reference/builder/>

3.  Build and run the docker image.
    -   Navigate to docker file directory
    -   To build the docker image run `docker build --tag=<your-tag> .`
    -   To run the docker image run `docker run <your-tag>`
