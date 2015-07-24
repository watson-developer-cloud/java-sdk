# Java Wrapper Release Process

 * code: https://github.com/watson-developer-cloud/java-wrapper
 * maven: http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22java-wrapper%22

## Guide to uploading artifacts to the Central Repository

We use sonatype as repository manager, it's used as the input channel for the Central Repository running the Sonatype Open Source Repository Hosting OSSRH service.

### Prerequisites
If you are not familiar with sonatype and/or the maven release process please read the following material:  
 * Sonatype: http://central.sonatype.org/pages/apache-maven.html
 * Releasing artifacts to Sonatype: http://kirang89.github.io/blog/2013/01/20/uploading-your-jar-to-maven-central/
 * Install GPG and create a public key. More info: http://blog.sonatype.com/2010/01/how-to-generate-pgp-signatures-with-maven/#.VUL_DtNViko


### Release steps

  1. Make sure that `pom.xml` and `build.gradle` have the same version number. In the `pom.xml` file the version should ends with -SNAPSHOT

  2. With the SCM connection configured correctly you can perform a release deployment to OSSRH (Staging) with:
    
    `mvn release:clean release:prepare`
    
    You will have to answer prompts for versions and tags. That will tag and commit a new version into your repository automatically.

  3. Deploy to maven central:
    
    `mvn release:perform`

    This execution will deploy to OSSRH and release to the Central Repository in one go.