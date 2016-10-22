
# Watson Developer Cloud Java SDK
[![Build Status](https://travis-ci.org/watson-developer-cloud/java-sdk.svg?branch=master)](https://travis-ci.org/watson-developer-cloud/java-sdk)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson.developer_cloud/java-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson.developer_cloud/java-sdk)
[![CLA assistant](https://cla-assistant.io/readme/badge/watson-developer-cloud/java-sdk)](https://cla-assistant.io/watson-developer-cloud/java-sdk)

The Java SDK uses the [Watson Developer Cloud][wdc] services, a collection of REST
APIs and SDKs that use cognitive computing to solve complex problems.

## Table of Contents
  * [Installation](#installation)
    * [Maven](#maven)
    * [Gradle](#gradle)
  * [Usage](#usage)
  * [Getting the Service Credentials](#getting-the-service-credentials)
  * [Questions](#questions)
  * IBM Watson Services
    * [Alchemy Language](alchemy)
    * [Alchemy Vision](alchemy)
    * [Alchemy Data News](alchemy)
    * [Concept Insights](alchemy)
    * [Conversation](conversation)
    * [Dialog](dialog)
    * [Document Conversion](document-conversion)
    * [Language Translation](language-translation)
    * [Language Translator](language-translator)
    * [Natural Language Classifier](natural-language-classifier)
    * [Personality Insights](personality-insights)
    * [Retrieve and Rank](retrieve-and-rank)
    * [Speech to Text](speech-to-text)
    * [Text to Speech](text-to-speech)
    * [Tone Analyzer](tone-analyzer)
    * [Tradeoff Analytics](tradeoff-analytics)
    * [Visual Recognition](visual-recognition)
  * [Reactive API call for v3.0.1](#introduce-reactive-api-call-for-v301)
  * [Breaking Changes for v3.0](#breaking-changes-for-v30)
  * [Android](#android)
  * [Running in Bluemix](#running-in-bluemix)
  * [Eclipse and Intellij](#working-with-eclipse-and-intellij-idea)
  * [License](#license)
  * [Contributing](#contributing)

## Installation

##### Maven

All the services:
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>java-sdk</artifactId>
	<version>3.5.0</version>
</dependency>
```

Only Retrieve and Rank:
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>retrieve-and-rank</artifactId>
	<version>3.5.0</version>
</dependency>
```

##### Gradle

All the services:
```gradle
'com.ibm.watson.developer_cloud:java-sdk:3.5.0'
```

Only Retrieve and Rank:
```gradle
'com.ibm.watson.developer_cloud:retrieve-and-rank:3.5.0'
```

Only Visual Recognition:
```gradle
'com.ibm.watson.developer_cloud:visual-recognition:3.5.0'
```

Snapshots of the development version are available in [Sonatype's snapshots repository][sonatype_snapshots].


##### JAR

Download the jar with dependencies [here][jar].

Now, you are ready to see some [examples](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/java/com/ibm/watson/developer_cloud).


## Usage

The examples within each service assume that you already have service credentials. If not,
you will have to create a service in [Bluemix][bluemix].

If you are running your application in Bluemix, you don't need to specify the
credentials; the library will get them for you by looking at the `VCAP_SERVICES` environment variable.

## Getting the Service Credentials
You will need the `username` and `password` (`api_key` for AlchemyAPI) credentials for each service. Service credentials are different from your Bluemix account username and password.

To get your service credentials, follow these steps:
 1. Log in to Bluemix at https://bluemix.net.

 1. Create an instance of the service:
     1. In the Bluemix **Catalog**, select the service you want to use.
     1. Under **Add Service**, type a unique name for the service instance in the Service name field. For example, type `my-service-name`. Leave the default values for the other options.
     1. Click **Create**.

 1. Copy your credentials:
     1. On the left side of the page, click **Service Credentials** to view your service credentials.
     1. Copy `username` and `password`(`api_key` for AlchemyAPI).

Once you have credentials, copy config.properties.example to src/test/resources/config.properties, and fill them in as necessary.

## Questions

If you are having difficulties using the APIs or you have a question about the IBM
Watson Services, please ask a question on
[dW Answers](https://developer.ibm.com/answers/questions/ask/?topics=watson)
or [Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-watson).


## Introduce reactive API call for v3.0.1  

To do a reactive call, you need to add `rx()`.  With reactive you can use synchronous or asynchronous calls as you like, and you can combine multiple rest calls more efficiently.

Use callback way

```java
service.getDialogs().rx().thenApply(new CompletableFuture.Fun<List<Dialog>, Integer>() {
  @Override
  public Integer apply(List<Dialog> dialogs) {
    return dialogs.size();
  }
}).thenAccept(new CompletableFuture.Action<Integer>() {
  @Override
  public void accept(Integer integer) {
    System.out.println(integer);
  }
});
```

Use asynchronous callback way

```java
service.getDialogs().rx().thenApplyAsync(new CompletableFuture.Fun<List<Dialog>, Integer>() {
  @Override
  public Integer apply(List<Dialog> dialogs) {
    return dialogs.size();
  }
}).thenAccept(new CompletableFuture.Action<Integer>() {
  @Override
  public void accept(Integer size) {
    System.out.println(size);
  }
});
```

Use synchronous way

```java
Integer size=service.getDialogs().rx().get().size();
System.out.println(size);
```

## Breaking Changes for v3.0

The version 3.0 is a major release focused on simplicity and consistency. Several breaking changes were introduced.

### Synchronous vs. Asynchronous

Before 3.0 all the API calls were synchronous.
```java
List<Dialog> dialogs = dialogService.getDialogs();
System.out.println(dialogs);
```
To do a synchronous call, you need to add `execute()`.

```java
List<Dialog> dialogs = dialogService.getDialogs().execute();
System.out.println(dialogs);
```
To do an asynchronous call, you need to specify a callback.

```java
service.getDialogs().enqueue(new ServiceCallback<List<Dialog>>() {
  @Override
  public void onResponse(List<Dialog> response) {
    System.out.println(response);
  }

  @Override
  public void onFailure(Exception e) {
  }}
);
```

See the [CHANGELOG](CHANGELOG.md) for the release notes.

## Migration

To migrate to 3.0 from a previous version, simply add `.execute()` to the old methods.
For example if you previously had
```java
List<Dialog> dialogs = dialogService.getDialogs();
System.out.println(dialogs);
```
Just add `execute()` on the end, and your code will work exactly the same as before.

```java
List<Dialog> dialogs = dialogService.getDialogs().execute();
System.out.println(dialogs);
```

## Android
The library supports Android 2.3 and above. For Java, the minimum requirement is 1.7.  
It depends on [OkHttp][] and [gson][].


## Running in Bluemix
When running in Bluemix, the library will automatically get the credentials from `VCAP_SERVICES`.
If you have more than one plan, you can use `BluemixUtils` to get the service credentials for an specific plan.

```java
PersonalityInsights service = new PersonalityInsights();
String apiKey = BluemixUtils.getAPIKey(service.getName(), BluemixUtils.PLAN_STANDARD);
service.setApiKey(apiKey);
```

## Build + Test

To build and test the project you can use [Gradle][] (version 1.x): or [Apache Maven][apache_maven].

Gradle:

  ```sh
  $ cd java-sdk
  $ gradle jar  # build jar file (build/libs/watson-developer-cloud-3.5.0.jar)
  $ gradle test # run tests
  ```

or Maven:

  ```sh
  $ cd java-sdk
  $ mvn install
  ```

## Working with Eclipse and Intellij IDEA

If you want to work on the code in an IDE instead of a text editor you can
easily create project files with gradle:

  ```sh
  $ gradle idea     # Intellij IDEA
  $ gradle eclipse  # Eclipse
  ```

or maven:

  ```sh
  $ mvn idea:idea # Intellij IDEA
  $ mvn eclipse:eclipse # Eclipse
  ```


## Open Source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## License

This library is licensed under Apache 2.0. Full license text is
available in [LICENSE](LICENSE).

## Contributing
See [CONTRIBUTING.md](.github/CONTRIBUTING.md).

[wdc]: http://www.ibm.com/watson/developercloud/
[bluemix]: https://console.ng.bluemix.net
[Gradle]: http://www.gradle.org/
[OkHttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[apache_maven]: http://maven.apache.org/
[sonatype_snapshots]: https://oss.sonatype.org/content/repositories/snapshots/com/ibm/watson/developer_cloud/

[jar]: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-3.5.0/java-sdk-3.5.0-jar-with-dependencies.jar
