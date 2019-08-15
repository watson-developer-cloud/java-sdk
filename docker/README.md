## Using this library in Docker
You can use the provided Dockerfile and POM to help test issues you have with the SDK.

1.  Install Docker
    - Mac: <https://docs.docker.com/docker-for-mac/install/>
    - Windows: <https://docs.docker.com/docker-for-windows/install/>
2.  Add the dependencies and code you'd like to test
    - If you're testing a simple project, you can edit the `DockerTest.java` file directly. Everything's set up to pull in the lastest version of the `ibm-watson` package and run that file when building the image.
    - If you'd like to use your own files, feel free to add them. Just be sure to edit the execution line in the Dockerfile to run your main class:

        ```
        RUN mvn -e exec:java -Dexec.mainClass="com.ibm.<MAIN_CLASS>"
        ```
      If you import a project with a different group ID, you'll need to change that in the provided `pom.xml` as well.
    
    - For more information on dockerfile construction please visit <https://docs.docker.com/engine/reference/builder/>
3.  Build the Docker image
    - From the directory with the Dockerfile, run `docker build --tag=<your-tag> .`
    - You should be able to verify that everything worked properly based on the output!