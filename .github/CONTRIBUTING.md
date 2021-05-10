# Issues

If you encounter an issue with the Java SDK, you are welcome to submit a [bug report](https://github.com/watson-developer-cloud/java-sdk/issues).
Before that, please search for similar issues. It's possible somebody has encountered this issue already.

# Building and testing
This project uses [Maven] as the build tool (> v1.x). Here are some helpful commands:
```sh
cd java-sdk
mvn clean  # Delete target directory.
mvn test # Run tests
mvn package # Take the compiled code and package it in its distributable format, e.g. JAR.
mvn verify # Run any checks to verify the MVN package is valid and meets quality criteria.
mvn verify -fae -DskipITs=false # Run Integration tests to verify the MVN package is valid and meets quality criteria.
mvn install # Install the package into the local repository.
```

# Pull Requests

If you want to contribute to the repository, here's a quick guide:
  1. Fork the repository
  1. Edit the [`config.properties`](../common/src/test/resources/config.properties) file to add your service credentials to the appropriate fields.
  2. develop and test your code changes, gradle: `mvn verify -fae -DskipITs=false`.
    * Run `checkstyle`: `mvn checkstyle:check`. 🏁
    * Create minimal diffs - disable on save actions like reformat source code or organize imports. If you feel the source code should be reformatted create a separate PR for this change.
    * Check for unnecessary whitespace with git diff --check before committing.
  3. Make the test pass
  4. Commit your changes:   
    * Commits should follow the [Angular commit message guidelines](https://github.com/angular/angular/blob/master/CONTRIBUTING.md#-commit-message-guidelines). This is because our release tool uses this format for determining release versions and generating changelogs. To make this easier, we recommend using the [Commitizen CLI](https://github.com/commitizen/cz-cli) with the `cz-conventional-changelog` adapter.
  5. Push to your fork and submit a pull request to the **master** branch

# Developer's Certificate of Origin 1.1

By making a contribution to this project, I certify that:

(a) The contribution was created in whole or in part by me and I
   have the right to submit it under the open source license
   indicated in the file; or

(b) The contribution is based upon previous work that, to the best
   of my knowledge, is covered under an appropriate open source
   license and I have the right under that license to submit that
   work with modifications, whether created in whole or in part
   by me, under the same open source license (unless I am
   permitted to submit under a different license), as indicated
   in the file; or

(c) The contribution was provided directly to me by some other
   person who certified (a), (b) or (c) and I have not modified
   it.

(d) I understand and agree that this project and the contribution
   are public and that a record of the contribution (including all
   personal information I submit with it, including my sign-off) is
   maintained indefinitely and may be redistributed consistent with
   this project or the open source license(s) involved.

## Additional Resources
+ [General GitHub documentation](https://help.github.com/)
+ [GitHub pull request documentation](https://help.github.com/send-pull-requests/)

[dw]: https://developer.ibm.com/answers/questions/ask/?topics=watson
[stackoverflow]: http://stackoverflow.com/questions/ask?tags=ibm-watson
[Maven]: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
[Gradle]: https://docs.gradle.org/current/userguide/installation.html
