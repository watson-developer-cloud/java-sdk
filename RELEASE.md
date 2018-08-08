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

### Releasing
As part of your PR into `master` for a release, make a commit updating version number strings across the SDK. To do this, we use [bumpversion](https://github.com/peritus/bumpversion).

To use `bumpversion`, simply run the following command with the proper semantic version for your desired release:
```bash
bumpversion major|minor|patch
```

After you've merged your PR and After the `master` branch successfully builds from the release changes, check out the `master` branch and perform a release deployment to OSSRH (Staging) with:
```bash
gradle release
```
You will have to answer prompts for versions and tags. That will tag and commit a new version into your repository automatically.

After the above commits pass, `git checkout` the new tag branch for your release. In that branch, execute the following command:

```bash
./gradlew uploadArchives -Psigning.keyId=<keyId> -Psigning.password=<keyPassword> -Psigning.secretKeyRingFile=<pathToKeyRingFile> -PossrhUsername=<sonatypeUsername> -PossrhPassword=<sonatypePassword>
```

The arguments should be populated with the following:
- `-Psigning.keyId`: The ID of your public key you created after following the link in the prerequisites
- `-Psigning.password`: Your password you created for making public GPG keys
- `-Psigning.secretKeyRingFile`: After creating your public key, you create your keyring file with the following command and use the absolute path to your new file:

```bash
gpg --export-secret-keys -o <outputFilename>.gpg
```

- `-PossrhUsername`: Your Sonatype username
- `-PossrhPassword`: Your Sonatype password

Assuming this command works properly, you should be able to then log into Sonatype and close and release the repository.
