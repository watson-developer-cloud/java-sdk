# Watson APIs Java SDK

[![Build Status](https://travis-ci.org/watson-developer-cloud/java-sdk.svg?branch=master)](https://travis-ci.org/watson-developer-cloud/java-sdk)
[![Slack](https://wdc-slack-inviter.mybluemix.net/badge.svg)](https://wdc-slack-inviter.mybluemix.net)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson/java-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson/java-sdk)
[![CLA assistant](https://cla-assistant.io/readme/badge/watson-developer-cloud/java-sdk)](https://cla-assistant.io/watson-developer-cloud/java-sdk)

Java client library to use the [Watson APIs][wdc].

<details>
  <summary>Table of Contents</summary>
  
  * [Before you begin](#before-you-begin)
  * [Installation](#installation)
    * [Maven](#maven)
    * [Gradle](#gradle)
  * [Usage](#usage)
  * [Running in IBM Cloud](#running-in-ibm-cloud)
  * [Authentication](#authentication)
    * [IAM](#iam)
    * [Username and password](#username-and-password)
    * [ICP](#icp)
  * [Using the SDK](#using-the-sdk)
    * [Parsing responses](#parsing-responses)
    * [Configuring the HTTP client](#configuring-the-http-client)
    * [Making asynchronous API calls](#making-asynchronous-api-calls)
    * [Default headers](#default-headers)
    * [Sending request headers](#sending-request-headers)
  * [FAQ](#faq)
  * IBM Watson Services
    * [Assistant](assistant)
    * [Compare and Comply](compare-comply)
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
  * [Debug](#debug)
  * [Eclipse and Intellij](#working-with-eclipse-and-intellij-idea)
  * [License](#license)
  * [Contributing](#contributing)
  * [Featured projects](#featured-projects)

</details>

## Before you begin
* You need an [IBM Cloud][ibm-cloud-onboarding] account.

## Installation

##### Maven
All the services:

```xml
<dependency>
	<groupId>com.ibm.watson</groupId>
	<artifactId>ibm-watson</artifactId>
	<version>7.3.0</version>
</dependency>
```

Only Discovery:

```xml
<dependency>
	<groupId>com.ibm.watson</groupId>
	<artifactId>discovery</artifactId>
	<version>7.3.0</version>
</dependency>
```

##### Gradle
All the services:

```gradle
'com.ibm.watson:ibm-watson:7.3.0'
```

Only Assistant:

```gradle
'com.ibm.watson:assistant:7.3.0'
```

##### JAR

Download the jar with dependencies [here][jar].

Now, you are ready to see some [examples](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/src/main/java/com/ibm/watson/developer_cloud).

## Usage

The examples within each service assume that you already have service credentials. If not,
you will have to [create a service](#getting-credentials) in IBM Cloud.

If you are running your application in IBM Cloud (or other platforms based on Cloud Foundry), you don't need to specify the
credentials; the library will get them for you by looking at the [`VCAP_SERVICES`][vcap_services] environment variable.

## Running in IBM Cloud

When running in IBM Cloud (or other platforms based on Cloud Foundry), the library will automatically get the credentials from [`VCAP_SERVICES`][vcap_services].
If you have more than one plan, you can use `CredentialUtils` to get the service credentials for an specific plan.

## Authentication

Watson services are migrating to token-based Identity and Access Management (IAM) authentication.

- With some service instances, you authenticate to the API by using **[IAM](#iam)**.
- In other instances, you authenticate by providing the **[username and password](#username-and-password)** for the service instance.
- If you're using a Watson service on ICP, you'll need to authenticate in a [specific way](#icp).

### Getting credentials

To find out which authentication to use, view the service credentials. You find the service credentials for authentication the same way for all Watson services:

1.  Go to the IBM Cloud [Dashboard](https://cloud.ibm.com/) page.
1.  Either click an existing Watson service instance in your [resource list](https://cloud.ibm.com/resources) or click [**Create resource > AI**](https://cloud.ibm.com/catalog?category=ai) and create a service instance.
1. Click on the **Manage** item in the left nav bar of your service instance.

On this page, you should be able to see your credentials for accessing your service instance.

In your code, you can use these values in the service constructor or with a method call after instantiating your service.

### Supplying credentials

There are two ways to supply the credentials you found above to the SDK for authentication.

#### Credential file (easier!)

With a credential file, you just need to put the file in the right place and the SDK will do the work of parsing it and authenticating. You can get this file by clicking the **Download** button for the credentials in the **Manage** tab of your service instance.

The file downloaded will be called `ibm-credentials.env`. This is the name the SDK will search for and **must** be preserved unless you want to configure the file path (more on that later). The SDK will look for your `ibm-credentials.env` file in the following places (in order):

- Your system's home directory
- The top-level directory of the project you're using the SDK in

As long as you set that up correctly, you don't have to worry about setting any authentication options in your code. So, for example, if you created and downloaded the credential file for your Discovery instance, you just need to do the following:

```java
Discovery service = new Discovery("2017-11-07");
```

And that's it!

If you're using more than one service at a time in your code and get two different `ibm-credentials.env` files, just put the contents together in one `ibm-credentials.env` file and the SDK will handle assigning credentials to their appropriate services.

If you would like to configure the location/name of your credential file, you can set an environment variable called `IBM_CREDENTIALS_FILE`. **This will take precedence over the locations specified above.** Here's how you can do that:

```bash
export IBM_CREDENTIALS_FILE="<path>"
```

where `<path>` is something like `/home/user/Downloads/<file_name>.env`.

#### Manually

If you'd prefer to set authentication values manually in your code, the SDK supports that as well. The way you'll do this depends on what type of credentials your service instance gives you.

##### IAM

Some services use token-based Identity and Access Management (IAM) authentication. IAM authentication uses a service API key to get an access token that is passed with the call. Access tokens are valid for approximately one hour and must be regenerated.

You supply either an IAM service **API key** or an **access token**:

- Use the API key to have the SDK manage the lifecycle of the access token. The SDK requests an access token, ensures that the access token is valid, and refreshes it if necessary.
- Use the access token if you want to manage the lifecycle yourself. For details, see [Authenticating with IAM tokens](https://cloud.ibm.com/docs/services/watson/getting-started-iam.html). If you want to switch to API key, override your stored IAM credentials with an IAM API key. Then call the `setIamCredentials()` method again.


Supplying the IAM API key:

```java
// letting the SDK manage the IAM token
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .url("<iam_url>") // optional - the default value is https://iam.cloud.ibm.com/identity/token
  .build();
Discovery service = new Discovery("2017-11-07", options);
```

Supplying the access token:

```java
// assuming control of managing IAM token
IamOptions options = new IamOptions.Builder()
  .accessToken("<access_token>")
  .build();
Discovery service = new Discovery("2017-11-07", options);
```

#### Username and password

```java
// in the constructor
BasicAuthConfig config = new BasicAuthConfig.Builder()
  .username("<username>")
  .password("<password")
  .build();
Discovery service = new Discovery("2017-11-07", config);
```

#### ICP
Like IAM, you can pass in credentials to let the SDK manage an access token for you or directly supply an access token to do it yourself.

```java
// letting the SDK manage the token
ICP4DConfig config = new ICP4DConfig.Builder()
  .url("<ICP token exchange base URL>")
  .username("<username>")
  .password("<password>")
  .disableSSLVerification(true)
  .build();
Discovery service = new Discovery("2017-11-07", config);
service.setEndPoint("<service ICP URL>");
```

```java
// assuming control of managing the access token
ICP4DConfig config = new ICP4DConfig.Builder()
  .url("<ICP token exchange base URL>")
  .userManagedAccessToken("<access token>")
  .disableSSLVerification(true)
  .build();
Discovery service = new Discovery("2017-11-07", config);
service.setEndPoint("<service ICP URL>");
```

Be sure to both disable SSL verification when authenticating and set the endpoint explicitly to the URL given in ICP.

## Using the SDK

### Parsing responses

No matter which method you use to make an API request (`execute()`, `enqueue()`, or `reactiveRequest()`), you'll get back an object of form `Response<T>`, where `T` is the model representing the specific response model.

Here's an example of how to parse that response and get additional information beyond the response model:

```java
// listing our workspaces with an instance of the Assistant v1 service
Response<WorkspaceCollection> response = service.listWorkspaces().execute();

// pulling out the specific API method response, which we can manipulate as usual
WorkspaceCollection collection = response.getResult();
System.out.println("My workspaces: " + collection.getWorkspaces());

// grabbing headers that came back with our API response
Headers responseHeaders = response.getHeaders();
System.out.println("Response header names: " + responseHeaders.names());
```

### Configuring the HTTP client

The HTTP client can be configured by using the `configureClient()` method on your service object, passing in an `HttpConfigOptions` object. Currently, the following options are supported:
- Disabling SSL verification (only do this if you really mean to!) ⚠️
- Using a proxy (more info here: [OkHTTPClient Proxy authentication how to?](https://stackoverflow.com/a/35567936/456564))

Here's an example of setting both of the above:

```java
Discovery service = new Discovery("2017-11-07");

// setting configuration options
HttpConfigOptions options = new HttpConfigOptions.Builder()
  .disableSslVerification(true)
  .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxyHost", 8080)))
  .build();

service.configureClient(options);
```

### Making asynchronous API calls

The basic, synchronous way to make API calls with this SDK is through the use of the `execute()` method. Using this method looks something like this:
```java
// make API call
Response<ListEnvironmentsResponse> response = service.listEnvironments().execute();

// continue execution
```

However, if you need to perform these calls in the background, there are two other methods to do this asynchronously: `enqueue()` and `reactiveRequest()`.

#### `enqueue()`

This method allows you to set a callback for the service response through the use of the `ServiceCallback` object. Here's an example:
```java
// make API call in the background
service.listEnvironments().enqueue(new ServiceCallback<ListEnvironmentsResponse>() {
  @Override
  public void onResponse(Response<ListEnvironmentsResponse> response) {
    System.out.println("We did it! " + response);
  }

  @Override
  public void onFailure(Exception e) {
    System.out.println("Whoops...");
  }
});

// continue working in the meantime!
```

#### `reactiveRequest()`

If you're a fan of the [RxJava](https://github.com/ReactiveX/RxJava) library, this method lets you leverage that to allow for "reactive" programming. The method will return a `Single<T>` which you can manipulate how you please. Example:
```java
// get stream with request
Single<Response<ListEnvironmentsResponse>> observableRequest
  = service.listEnvironments().reactiveRequest();

// make API call in the background
observableRequest
  .subscribeOn(Schedulers.single())
  .subscribe(response -> System.out.println("We did it with s~t~r~e~a~m~s! " + response));

// continue working in the meantime!
```

### Default headers

Default headers can be specified at any time by using the `setDefaultHeaders(Map<String, String> headers)` method.

The example below sends the `X-Watson-Learning-Opt-Out` header in every request preventing Watson from using the payload to improve the service.

```java
PersonalityInsights service = new PersonalityInsights("2016-10-19");

Map<String, String> headers = new HashMap<String, String>();
headers.put(WatsonHttpHeaders.X_WATSON_LEARNING_OPT_OUT, "true");

service.setDefaultHeaders(headers);

// All the api calls from now on will send the default headers
```

### Sending request headers

Custom headers can be passed with any request. To do so, add the header to the `ServiceCall` object before executing the request. For example, this is what it looks like to send the header `Custom-Header` along with a call to the Watson Assistant service:

```java
Response<WorkspaceCollection> workspaces = service.listWorkspaces()
  .addHeader("Custom-Header", "custom_value")
  .execute();
```

## FAQ

### Does this SDK play well with Android?

It does! You should be able to plug this dependency into your Android app without any issue. In addition, we have an Android SDK meant to be used with this library that adds some Android-specific functionality, which you can find [here](https://github.com/watson-developer-cloud/android-sdk).

### How does debugging work?

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

### How can I contribute?

Great question (and please do)! You can find contributing information [here](.github/CONTRIBUTING.md).

### Where can I get more help with using Watson APIs?

If you have a question about/problem with using the Watson APIs in general, feel free to ask a question on [dW Answers](https://developer.ibm.com/answers/questions/ask/?topics=watson) or trusty [Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-watson).

### Does IBM have any other open source work?

We do :sunglasses:  http://ibm.github.io/

[wdc]: https://www.ibm.com/watson/developer/
[ibm_cloud]: https://cloud.ibm.com
[apache_maven]: http://maven.apache.org/
[vcap_services]: https://cloud.ibm.com/docs/services/watson/getting-started-variables.html
[ibm-cloud-onboarding]: http://cloud.ibm.com/registration?target=/developer/watson&cm_sp=WatsonPlatform-WatsonServices-_-OnPageNavLink-IBMWatson_SDKs-_-Java

## Featured projects
We'd love to highlight cool open-source projects that use this SDK! If you'd like to get your project added to the list, feel free to make an issue linking us to it.

[jar]: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-7.3.0/ibm-watson-7.3.0-jar-with-dependencies.jar
