# Watson APIs Java SDK

[![Build Status](https://travis-ci.org/watson-developer-cloud/java-sdk.svg?branch=master)](https://travis-ci.org/watson-developer-cloud/java-sdk)
[![Slack](https://wdc-slack-inviter.mybluemix.net/badge.svg)](https://wdc-slack-inviter.mybluemix.net)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson.developer_cloud/java-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson.developer_cloud/java-sdk)
[![CLA assistant](https://cla-assistant.io/readme/badge/watson-developer-cloud/java-sdk)](https://cla-assistant.io/watson-developer-cloud/java-sdk)

Java client library to use the [Watson APIs][wdc].

<details>
  <summary>Table of Contents</summary>

  * [Installation](#installation)
    * [Maven](#maven)
    * [Gradle](#gradle)
  * [Usage](#usage)
  * [Running in IBM Cloud](#running-in-ibm-cloud)
  * [Authentication](#authentication)
    * [Username and Password](#username-and-password)
    * [API Key](#api-key)
    * [Using IAM](#using-iam)
  * IBM Watson Services
    * [Assistant](assistant)
    * [Discovery](discovery)
    * [Language Translator](language-translator)
    * [Natural Language Classifier](natural-language-classifier)
    * [Natural Language Understanding](natural-language-understanding)
    * [Personality Insights](personality-insights)
    * [Speech to Text](speech-to-text)
    * [Text to Speech](text-to-speech)
    * [Tone Analyzer](tone-analyzer)
    * [Tradeoff Analytics](tradeoff-analytics)
    * [Visual Recognition](visual-recognition)
  * [Android](#android)
  * [Using a Proxy](#using-a-proxy)
  * [Default Headers](#default-headers)
  * [Sending Request Headers](#sending-request-headers)
  * [Parsing HTTP Response Info](#parsing-http-response-info)
  * [Specifying a Service URL](#specifying-a-service-url)
  * [401 Unauthorized Error](#401-unauthorized-error)
  * [Changes for v4.0](#changes-for-v40)
  * [Debug](#debug)
  * [Eclipse and Intellij](#working-with-eclipse-and-intellij-idea)
  * [License](#license)
  * [Contributing](#contributing)

</details>

## Installation

##### Maven

All the services:

```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>java-sdk</artifactId>
	<version>6.1.0</version>
</dependency>
```

Only Discovery:

```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>discovery</artifactId>
	<version>6.1.0</version>
</dependency>
```

##### Gradle

All the services:

```gradle
'com.ibm.watson.developer_cloud:java-sdk:6.1.0'
```

Only Assistant:

```gradle
'com.ibm.watson.developer_cloud:assistant:6.1.0'
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
'com.ibm.watson.developer_cloud:speech-to-text:6.1.1-SNAPSHOT'
```

##### JAR

Download the jar with dependencies [here][jar].

Now, you are ready to see some [examples](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/src/main/java/com/ibm/watson/developer_cloud).

## Usage

The examples within each service assume that you already have service credentials. If not,
you will have to create a service in [IBM Cloud][ibm_cloud].

If you are running your application in IBM Cloud (or other platforms based on Cloud Foundry), you don't need to specify the
credentials; the library will get them for you by looking at the [`VCAP_SERVICES`][vcap_services] environment variable.

## Running in IBM Cloud

When running in IBM Cloud (or other platforms based on Cloud Foundry), the library will automatically get the credentials from [`VCAP_SERVICES`][vcap_services].
If you have more than one plan, you can use `CredentialUtils` to get the service credentials for an specific plan.

## Authentication

There are three ways to authenticate with IBM Cloud through the SDK: using a `username` and `password`, using an `api_key`, and with IAM.

Getting the credentials necessary for authentication is the same process for all methods. To get them, follow these steps:

1. Log in to [IBM Cloud](https://console.bluemix.net/catalog?category=watson)
1. In the IBM Cloud **Catalog**, select the service you want to use.
1. Click **Create**.
1. On the left side of the page, click **Service Credentials**, and then **View credentials** to view your service credentials.
1. Copy the necessary credentials (`url`, `username`, `password`, `api_key`, `apikey`, etc.).

In your code, you can use these values in the service constructor or with a method call after instantiating your service. Here are some examples:

### Username and Password

```java
// in the constructor
Discovery service = new Discovery("2017-11-07", "<username>", "<password>");
```

```java
// after instantiation
Discovery service = new Discovery("2017-11-07");
service.setUsernameAndPassword("<username>", "<password>");
```

### API Key

_Important: Instantiation with API key works only with Visual Recognition service instances created before May 23, 2018. Visual Recognition instances created after May 22 use IAM._

```java
// in the constructor
VisualRecognition service = new VisualRecognition("2016-05-20", "<api_key>");
```

```java
// after instantiation
VisualRecognition service = new VisualRecognition("2016-05-20");
service.setApiKey("<api_key>");
```

### Using IAM

When authenticating with IAM, you have the option of passing in:
- the IAM API key and, optionally, the IAM service URL
- an IAM access token

**Be aware that passing in an access token means that you're assuming responsibility for maintaining that token's lifecycle.** If you instead pass in an IAM API key, the SDK will manage it for you.

```java
// in the constructor, letting the SDK manage the IAM token
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .url("<iam_url>") // optional - the default value is https://iam.bluemix.net/identity/token
  .build();
Discovery service = new Discovery("2017-11-07", options);
```

```java
// after instantiation, letting the SDK manage the IAM token
Discovery service = new Discovery("2017-11-07");
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);
```

```java
// in the constructor, assuming control of managing IAM token
IamOptions options = new IamOptions.Builder()
  .accessToken("<access_token>")
  .build();
Discovery service = new Discovery("2017-11-07", options);
```

```java
// after instantiation, assuming control of managing IAM token
Discovery service = new Discovery("2017-11-07");
IamOptions options = new IamOptions.Builder()
  .accessToken("<access_token>")
  .build();
service.setIamCredentials(options);
```

If at any time you would like to let the SDK take over managing your IAM token, simply override your stored IAM credentials with an IAM API key by calling the `setIamCredentials()` method again.

## Android

The Android SDK utilizes the Java SDK while making some Android-specific additions. This repository can be found [here](https://github.com/watson-developer-cloud/android-sdk). It depends on [OkHttp][] and [gson][].

## Using a Proxy

Override the `configureHttpClient()` method and add the proxy using the `OkHttpClient.Builder` object.

For example:

```java
Assistant service = new Assistant("2018-02-16") {
  @Override
  protected OkHttpClient configureHttpClient() {
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxyHost", 8080));
    return super.configureHttpClient().newBuilder().proxy(proxy).build();
  }
};

service.setUsernameAndPassword("<username>", "<password>");

WorkspaceCollection workspaces = service.listWorkspaces().execute();
System.out.println(workspaces);
```

For more information see: [OkHTTPClient Proxy authentication how to?](https://stackoverflow.com/a/35567936/456564)

```java
PersonalityInsights service = new PersonalityInsights("2016-10-19");
String apiKey = CredentialUtils.getAPIKey(service.getName(), CredentialUtils.PLAN_STANDARD);
service.setApiKey(apiKey);
```

## Sending Request Headers

Custom headers can be passed with any request. To do so, add the header to the `ServiceCall` object before executing the request. For example, this is what it looks like to send the header `Custom-Header` along with a call to the Watson Assistant service:

```java
WorkspaceCollection workspaces = service.listWorkspaces()
  .addHeader("Custom-Header", "custom_value")
  .execute();
```

## Parsing HTTP Response Info

The basic `execute()`, `enqueue()`, and `rx()` methods make HTTP requests to your Watson service and return models based on the requested endpoint. If you would like access to some HTTP response information along with the response model, you can use the more detailed versions of those three methods: `executeWithDetails()`, `enqueueWithDetails()`, and `rxWithDetails()`. To capture the responses, use the new `Response<T>` class, with `T` being the expected response model.

Here is an example of calling the Watson Assistant `listWorkspaces()` method and parsing its response model as well as the response headers:

```java
Response<WorkspaceCollection> response = service.listWorkspaces().executeWithDetails();

// getting result equivalent to execute()
WorkspaceCollection workspaces = response.getResult();

// getting returned HTTP headers
Headers responseHeaders = response.getHeaders();
```

Note that when using `enqueueWithDetails()`, you must also implement the new `ServiceCallbackWithDetails` interface. For example:

```java
service.listWorkspaces().enqueueWithDetails(new ServiceCallbackWithDetails<WorkspaceCollection>() {
  @Override
  public void onResponse(Response<WorkspaceCollection> response) {
    WorkspaceCollection workspaces = response.getResult();
    Headers responseHeaders = response.getHeaders();
  }

  @Override
  public void onFailure(Exception e) { }
});
```

## Default Headers

Default headers can be specified at any time by using the `setDefaultHeaders(Map<String, String> headers)` method.

The example below sends the `X-Watson-Learning-Opt-Out` header in every request preventing Watson from using the payload to improve the service.

```java
PersonalityInsights service = new PersonalityInsights("2016-10-19");

Map<String, String> headers = new HashMap<String, String>();
headers.put(HttpHeaders.X_WATSON_LEARNING_OPT_OUT, 1);

service.setDefaultHeaders(headers);

// All the api calls from now on will send the default headers
```

## Specifying a Service URL

You can set the correct API Endpoint for your service calling `setEndPoint()`.

For example, if you have the Discovery service in Germany, the Endpoint may be `https://gateway-fra.watsonplatform.net/discovery/api`.

You will need to call

```java
Discovery service = new Discovery("2017-11-07");
service.sentEndPoint("https://gateway-fra.watsonplatform.net/discovery/api")
```

## 401 Unauthorized Error

Make sure you are using the service credentials and not your IBM Cloud account/password.
Check the API Endpoint, you may need to update the default using `setEndPoint()`.

## Changes for v4.0
Version 4.0 focuses on the move to programmatically-generated code for many of the services. See the [changelog](https://github.com/watson-developer-cloud/java-sdk/wiki/Changelog) for the details. This version also includes many breaking changes as a result of standardizing behavior across the new generated services. Full details on migration from previous versions can be found [here](https://github.com/watson-developer-cloud/java-sdk/wiki/Migration).

## Debug

HTTP requests can be logged by adding a `logging.properties` file to your classpath.

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
gradle jar  # build jar file (build/libs/watson-developer-cloud-6.1.0.jar)
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


[wdc]: https://www.ibm.com/watson/developer/
[ibm_cloud]: https://console.bluemix.net
[Gradle]: http://www.gradle.org/
[OkHttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[apache_maven]: http://maven.apache.org/
[sonatype_snapshots]: https://oss.sonatype.org/content/repositories/snapshots/com/ibm/watson/developer_cloud/
[vcap_services]: https://docs.run.pivotal.io/devguide/deploy-apps/environment-variable.html#VCAP-SERVICES


[jar]: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-6.1.0/java-sdk-6.1.0-jar-with-dependencies.jar
