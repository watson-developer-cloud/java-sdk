# Release Process

 * code: https://github.com/watson-developer-cloud/java-sdk
 * maven: http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22java-sdk%22

## Guide to uploading artifacts to the Central Repository

We use Sonatype as repository manager, it's used as the input channel for the Central Repository running the Sonatype Open Source Repository Hosting(OSSRH) service.

### Prerequisites

If you are not familiar with Sonatype and/or the maven release process please read the following material:  
 * Sonatype: http://central.sonatype.org/pages/apache-maven.html
 * Releasing artifacts to Sonatype: http://kirang89.github.io/blog/2013/01/20/uploading-your-jar-to-maven-central/
 * Install GPG, and create a public key. More info: http://central.sonatype.org/pages/working-with-pgp-signatures.html


### Release steps

  1. Update `CHANGELOG.md`

  2. Update `README.md` to include the new version number

  3. Perform a release deployment to OSSRH (Staging) with:

    `gradle release`

    You will have to answer prompts for versions and tags. That will tag and commit a new version into your repository automatically.
