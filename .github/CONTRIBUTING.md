# Questions

If you are having difficulties using the APIs or have a question about the IBM Watson Services,
please ask a question on [dW Answers][dw] or [Stack Overflow][stackoverflow].

# Issues

If you encounter an issue with the Java SDK, you are welcome to submit a [bug report](https://github.com/watson-developer-cloud/java-sdk/issues).
Before that, please search for similar issues. It's possible somebody has encountered this issue already.

# Pull Requests

If you want to contribute to the repository, here's a quick guide:
  1. Fork the repository
  1. Create a `.config.properties` similar to [`config.properties`](https://github.com/watson-developer-cloud/java-sdk/blob/master/core/src/test/resources/config.properties).
  2. develop and test your code changes, gradle: `gradle test`.
    * Run `checkstyle`: `gradle checkstyle`. 🏁
    * Create minimal diffs - disable on save actions like reformat source code or organize imports. If you feel the source code should be reformatted create a separate PR for this change.
    * Check for unnecessary whitespace with git diff --check before committing.
  3. Make the test pass
  4. Commit your changes:   
    * Use the present tense (`"Add feature"` not `"Added Feature"`)
    * Use the imperative mood (`"Move cursor to…"` not `"Moves cursor to…"`)
    * Include relevant Emoji from our [Emoji cheatsheet](#emoji-cheatsheet)
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

## Emoji Cheatsheet

When creating creating commits or updating the `CHANGELOG`, please **start** the commit message or update with one of the following applicable Emoji. Emoji should not be used at the start of issue or pull request titles.

* :new: `:new:` when adding new functionality
* :bug: `:bug:` when fixing a bug
* :memo: `:memo:` when writing documentation
* :art: `:art:` when improving the format/structure of the code
* :fire: `:fire:` when removing code or files
* :racehorse: `:racehorse:` when improving performance
* :white_check_mark: `:white_check_mark:` when adding tests
* :green_heart: `:green_heart:` when fixing the CI build
* :lock: `:lock:` when dealing with security
* :crystal_ball: `:crystal_ball:` when experimenting
* :unamused: `:unamused:` when doing chore work (updating dependencies, etc…)
* :boom: `:boom:` when changing in a non-backwards-compatible way current functionality
* :shipit: `:shipit:` when creating a new release

## Additional Resources
+ [General GitHub documentation](https://help.github.com/)
+ [GitHub pull request documentation](https://help.github.com/send-pull-requests/)

[dw]: https://developer.ibm.com/answers/questions/ask/?topics=watson
[stackoverflow]: http://stackoverflow.com/questions/ask?tags=ibm-watson
[Maven]: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
[Gradle]: https://docs.gradle.org/current/userguide/installation.html
