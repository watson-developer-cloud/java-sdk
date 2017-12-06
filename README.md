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
* IBM Watson Services
  * [Alchemy Language](alchemy)
  * [Alchemy Vision](alchemy)
  * [Alchemy Data News](alchemy)
  * [Concept Insights](alchemy)
  * [Conversation](conversation)
  * [Dialog](dialog)
  * [Discovery](discovery)
  * [Document Conversion](document-conversion)
  * [Language Translation](language-translation)
  * [Language Translator](language-translator)
  * [Natural Language Classifier](natural-language-classifier)
  * [Natural Language Understanding](natural-language-understanding)
  * [Personality Insights](personality-insights)
  * [Retrieve and Rank](retrieve-and-rank)
  * [Speech to Text](speech-to-text)
  * [Text to Speech](text-to-speech)
  * [Tone Analyzer](tone-analyzer)
  * [Tradeoff Analytics](tradeoff-analytics)
  * [Visual Recognition](visual-recognition)
* [Changes for v4.0](#changes-for-v40)
* [Using a Proxy](#using-a-proxy)
* [Android](#android)
* [Running in Bluemix](#running-in-bluemix)
* [Default Headers](#default-headers)
* [Debug](#debug)
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
	<version>4.1.0</version>
</dependency>
```

Only Retrieve and Rank:

```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>retrieve-and-rank</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle

All the services:

```gradle
'com.ibm.watson.developer_cloud:java-sdk:4.1.0'
```

Only Retrieve and Rank:

```gradle
'com.ibm.watson.developer_cloud:retrieve-and-rank:4.1.0'
```

Only Visual Recognition:

```gradle
'com.ibm.watson.developer_cloud:visual-recognition:4.1.0'
```

##### Development Snapshots

Snapshots of the development version are available in [Sonatype's snapshots repository][sonatype_snapshots].

###### Gradle

Add repository to your project Gradle file

```gradle
allprojects {
    repositories {
        maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
    }
}
```

And then reference the snapshot version on your app module gradle
Only Speech to Text:

```gradle
'com.ibm.watson.developer_cloud:speech-to-text:3.8.1-SNAPSHOT'
```

##### JAR

Download the jar with dependencies [here][jar].

Now, you are ready to see some [examples](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/src/main/java/com/ibm/watson/developer_cloud).

## Usage

The examples within each service assume that you already have service credentials. If not,
you will have to create a service in [Bluemix][bluemix].

If you are running your application in Bluemix, you don't need to specify the
credentials; the library will get them for you by looking at the `VCAP_SERVICES` environment variable.

## Getting the Service Credentials

You will need the `username` and `password` (`api_key` for AlchemyAPI) credentials, and the API endpoint for each service. Service credentials are different from your Bluemix account username and password.

To get your service credentials, follow these steps:

1. Log in to [Bluemix](https://console.bluemix.net/catalog?category=watson)

1. Create an instance of the service:
    1. In the Bluemix **Catalog**, select the service you want to use.
    1. Click **Create**.

1. Copy your credentials:
    1. On the left side of the page, click **Service Credentials**, and then **View credentials** to view your service credentials.
    1. Copy `url`, `username` and `password`(`api_key` for AlchemyAPI or Visual Recognition).

## Changes for v4.0
Version 4.0 focuses on the move to programmatically-generated code for many of the services. See the [changelog](https://github.com/watson-developer-cloud/java-sdk/wiki/Changelog) for the details.

## Migration
This version includes many breaking changes as a result of standardizing behavior across the new generated services. Full details on migration from previous versions can be found [here](https://github.com/watson-developer-cloud/java-sdk/wiki/Migration).

## Android

The Android SDK utilizes the Java SDK while making some Android-specific additions. This repository can be found [here](https://github.com/watson-developer-cloud/android-sdk). It depends on [OkHttp][] and [gson][].

## Using a Proxy

Override the `configureHttpClient()` method and add the proxy using the `OkHttpClient.Builder` object.

For example:

```java
ConversationService service = new ConversationService("2017-05-26") {
  @Override
  protected OkHttpClient configureHttpClient() {
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxyHost", 8080));
    return super.configureHttpClient().newBuilder().proxy(proxy).build();
  }
};

service.setUsernameAndPassword("<username>", "<password>");

WorkspaceCollectionResponse workspaces = service.listWorkspaces(null, null, null, null).execute();
System.out.println(workspaces);
```

For more information see: [OkHTTPClient Proxy authentication how to?](https://stackoverflow.com/a/35567936/456564)

## Running in Bluemix

When running in Bluemix, the library will automatically get the credentials from `VCAP_SERVICES`.
If you have more than one plan, you can use `BluemixUtils` to get the service credentials for an specific plan.

```java
PersonalityInsights service = new PersonalityInsights();
String apiKey = BluemixUtils.getAPIKey(service.getName(), BluemixUtils.PLAN_STANDARD);
service.setApiKey(apiKey);
```

## Default Headers

Default headers can be specified at any time by using the `setDefaultHeaders(Map<String, String> headers)` method.

The example below sends the `X-Watson-Learning-Opt-Out` header in every request preventing Watson from using the payload to improve the service.

```java
PersonalityInsights service = new PersonalityInsights();

Map<String, String> headers = new HashMap<String, String>();
headers.put(HttpHeaders.X_WATSON_LEARNING_OPT_OUT, 1);

service.setDefaultHeaders(headers);

// All the api calls from now on will send the default headers
```

## Specifying a service URL

You can set the correct API Endpoint for your service calling `setEndPoint()`.

For example, if you have the conversation service in Germany, the Endpoint may be `https://gateway-fra.watsonplatform.net/conversation/api`. 

You will need to call

```java
Conversation service = new Conversation("<version-date>");
service.sentEndPoint("https://gateway-fra.watsonplatform.net/conversation/api")
```

## 401 Unauthorized error

Make sure you are using the service credentials and not your Bluemix account/password.
Check the API Endpoint, you may need to update the default using `setEndPoint()`.

## Debug

HTTP requests can be logging by adding a `loggging.properties` file to your classpath.

```none
handlers=java.util.logging.ConsoleHandler
java.util.logging.ConsoleHandler.level=FINE
java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter
java.util.logging.SimpleFormatter.format=%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s %4$s: %5$s%n
.level=SEVERE
# HTTP Logging - Basic
com.ibm.watson.developer_cloud.util.HttpLogging.level=INFO
```

The configuration above will log only the URL and query parameters for each request.

For example:

```none
Mar 30, 2017 7:31:22 PM okhttp3.internal.platform.Platform log
INFO: --> POST https://gateway.watsonplatform.net/tradeoff-analytics/api/v1/dilemmas?generate_visualization=false http/1.1 (923-byte body)
Mar 30, 2017 7:31:22 PM okhttp3.internal.platform.Platform log
INFO: <-- 200 OK https://gateway.watsonplatform.net/tradeoff-analytics/api/v1/dilemmas?generate_visualization=false (104ms, unknown-length body)
Mar 30, 2017 7:31:23 PM okhttp3.internal.platform.Platform log
INFO: --> POST https://gateway.watsonplatform.net/tradeoff-analytics/api/v1/dilemmas?generate_visualization=true http/1.1 (12398-byte body)
Mar 30, 2017 7:31:35 PM okhttp3.internal.platform.Platform log
INFO: <-- 200 OK https://gateway.watsonplatform.net/tradeoff-analytics/api/v1/dilemmas?generate_visualization=true (12311ms, unknown-length body)
```

**Warning:** The logs generated by this logger when using the level `FINE` or `ALL` has the potential to leak sensitive information such as "Authorization" or "Cookie" headers and the contents of request and response bodies. This data should only be logged in a controlled way or in a non-production environment.

## Build + Test

To build and test the project you can use [Gradle][] (version 1.x).

Gradle:

```sh
cd java-sdk
gradle jar  # build jar file (build/libs/watson-developer-cloud-4.1.0.jar)
gradle test # run tests
gradle check # performs quality checks on source files and generates reports
gradle testReport # run tests and generate the aggregated test report (build/reports/allTests)
gradle codeCoverageReport # run tests and generate the code coverage report (build/reports/jacoco)
```

## Working with Eclipse and Intellij IDEA

If you want to work on the code in an IDE instead of a text editor you can
easily create project files with gradle:

```sh
gradle idea     # Intellij IDEA
gradle eclipse  # Eclipse
```

## Open Source @ IBM

Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## License

This library is licensed under Apache 2.0. Full license text is
available in [LICENSE](LICENSE).

## Contributing

See [CONTRIBUTING.md](.github/CONTRIBUTING.md).

## Code of Conduct

See [CODE_OF_CONDUCT.md](.github/CODE_OF_CONDUCT.md).

### Other

If you are having difficulties using the APIs or you have a question about the IBM
Watson Services, please ask a question on
[dW Answers](https://developer.ibm.com/answers/questions/ask/?topics=watson)
or [Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-watson).


[wdc]: http://www.ibm.com/watson/developercloud/
[bluemix]: https://console.bluemix.net
[Gradle]: http://www.gradle.org/
[OkHttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[apache_maven]: http://maven.apache.org/
[sonatype_snapshots]: https://oss.sonatype.org/content/repositories/snapshots/com/ibm/watson/developer_cloud/

[jar]: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-4.1.0/java-sdk-4.1.0-jar-with-dependencies.jar
