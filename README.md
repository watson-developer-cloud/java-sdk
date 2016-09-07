
# Watson Developer Cloud Java SDK
[![Build Status](https://travis-ci.org/watson-developer-cloud/java-sdk.svg?branch=master)](https://travis-ci.org/watson-developer-cloud/java-sdk)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson.developer_cloud/java-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.ibm.watson.developer_cloud/java-sdk)
[![codecov.io](https://codecov.io/github/watson-developer-cloud/java-sdk/coverage.svg?branch=master)](https://codecov.io/github/watson-developer-cloud/java-sdk?branch=master)
[![CLA assistant](https://cla-assistant.io/readme/badge/watson-developer-cloud/java-sdk)](https://cla-assistant.io/watson-developer-cloud/java-sdk)

The Java SDK uses the [Watson Developer Cloud][wdc] services, a collection of REST
APIs and SDKs that use cognitive computing to solve complex problems.

## Table of Contents
  * [Reactive API call for v3.0.1](#introduce-reactive-api-call-for-v301)
  * [Breaking Changes for v3.0](#breaking-changes-for-v30)
  * [Installation](#installation)
    * [Maven](#maven)
    * [Gradle](#gradle)
  * [Usage](#usage)
  * [Getting the Service Credentials](#getting-the-service-credentials)
  * [Questions](#questions)
  * [IBM Watson Services](#ibm-watson-services)
    * [Alchemy Language](#alchemy-language)
    * [Alchemy Vision](#alchemy-vision)
    * [Alchemy Data News](#alchemy-data-news)
    * [Concept Insights](#concept-insights)
    * [Conversation](#conversation)
    * [Dialog](#dialog)
    * [Document Conversion](#document-conversion)
    * [Language Translation](#language-translation)
    * [Natural Language Classifier](#natural-language-classifier)
    * [Personality Insights](#personality-insights)
    * [Retrieve and Rank](#retrieve-and-rank)
    * [Speech to Text](#speech-to-text)
    * [Text to Speech](#text-to-speech)
    * [Tone Analyzer](#tone-analyzer)
    * [Tradeoff Analytics](#tradeoff-analytics)
    * [Visual Recognition](#visual-recognition)
  * [Android](#android)
  * [Running in Bluemix](#running-in-bluemix)
  * [Eclipse and Intellij](#working-with-eclipse-and-intellij-idea)
  * [License](#license)
  * [Contributing](#contributing)

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

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>java-sdk</artifactId>
	<version>3.3.1</version>
</dependency>
```
##### Gradle

```gradle
'com.ibm.watson.developer_cloud:java-sdk:3.3.1'
```

Snapshots of the development version are available in [Sonatype's snapshots repository][sonatype_snapshots].


##### JAR

Download the jar with dependencies [here][jar].

Now, you are ready to see some [examples](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/java/com/ibm/watson/developer_cloud).


## Usage

The examples below assume that you already have service credentials. If not,
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


## IBM Watson Services
The Watson Developer Cloud offers a variety of services for building cognitive
applications.

### Alchemy Language
[Alchemy Language][alchemy_language] offers 12 API functions as part of its text analysis service, each of which uses sophisticated natural language processing techniques to analyze your content and add high-level semantic information.

Use the [Sentiment Analysis][sentiment_analysis] endpoint to identify positive/negative sentiment within a sample text document.

```java
AlchemyLanguage service = new AlchemyLanguage();
service.setApiKey("<api_key>");

Map<String,Object> params = new HashMap<String, Object>();
params.put(AlchemyLanguage.TEXT, "IBM Watson won the Jeopardy television show hosted by Alex Trebek");
DocumentSentiment sentiment = service.getSentiment(params).execute();

System.out.println(sentiment);
```

### Alchemy Vision
[Alchemy Vision][alchemy_vision] uses deep learning innovations to understand a picture's content and context. It sees complex visual scenes in their entirety —without needing any textual clues— leveraging a holistic approach to understand the objects, faces, and words in an image.

Example: Extract keywords from an image.

```java
AlchemyVision service = new AlchemyVision();
service.setApiKey("<api_key>");

File image = new File("src/test/resources/alchemy/obama.jpg");
Boolean forceShowAll = false;
Boolean knowledgeGraph = false;
ImageKeywords keywords =  service.getImageKeywords(image, forceShowAll, knowledgeGraph).execute();

System.out.println(keywords);
```

### Alchemy Data News
[Alchemy Data News][alchemy_data_news] indexes 250k to 300k English language news and
blog articles every day with historical search available for the past 60 days.  
Example: Get 7 documents between Friday 28th August 2015 and Friday 4th September 2015.

```java
AlchemyDataNews service = new AlchemyDataNews();
service.setApiKey("<api_key>");

Map<String, Object> params = new HashMap<String, Object>();

String[] fields =
    new String[] {"enriched.url.title", "enriched.url.url", "enriched.url.author",
        "enriched.url.publicationDate", "enriched.url.enrichedTitle.entities",
        "enriched.url.enrichedTitle.docSentiment"};
params.put(AlchemyDataNews.RETURN, StringUtils.join(fields, ","));
params.put(AlchemyDataNews.START, "1440720000");
params.put(AlchemyDataNews.END, "1441407600");
params.put(AlchemyDataNews.COUNT, 7);

DocumentsResult result = service.getNewsDocuments(params).execute();

System.out.println(result);
```

### Conversation
Use the [Conversation][conversation] service to identify intents, entities, and conduct conversations.

```java
ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_07_11);
service.setUsernameAndPassword("<username>", "<password>");

MessageRequest newMessage = new MessageRequest.Builder().inputText("Hi").build();
MessageResponse response = service.message("<workspace-id>", newMessage).execute();
System.out.println(response);
```

### Concept Insights

The [Concept Insights][concept_insights] has been deprecated, AlchemyLanguage's concept function can be used as a replacement for most Concept Insights use cases; therefore, we encourage existing Concept Insights service users to migrate to AlchemyLanguage.

### Dialog
The [Dialog service][dialog] was deprecated on August 15, 2016, existing instances of the service will continue to function until August 9, 2017. Users of the Dialog service should migrate their applications to use the Conversation service. See the [migration documentation][dialog_migration] to learn how to migrate your dialogs to the [Conversation service][conversation].

### Document Conversion
The [Document Conversion][document_conversion] service allows to convert pdf, word, and html documents into formats useful to other Watson Cognitive services. Target formats include normalized html, plain text, and sets of potential answers for Watson question answering. You can convert documents synchronously one at a time, or asynchronously in batches

Returns the document list using the [Document Conversion][document_conversion] service.

```java
DocumentConversion service = new DocumentConversion("2015-12-01");
service.setUsernameAndPassword("<username>", "<password>");

File doc = new File("src/test/resources/document_conversion/word-document-heading-input.doc");
Answers htmlToAnswers = service.convertDocumentToAnswer(doc).execute();
System.out.println(htmlToAnswers);
```

### Language Translation
Select a domain, then identify or select the language of text, and then translate the text from one supported language to another.  
Example: Translate 'hello' from English to Spanish using the [Language Translator][language_translation] service.

```java
LanguageTranslator service = new LanguageTranslation();
service.setUsernameAndPassword("<username>", "<password>");

TranslationResult translationResult = service.translate(
  "hello", Language.ENGLISH, Language.SPANISH)
  .execute();

System.out.println(translationResult);
```

### Natural Language Classifier
Use [Natural Language Classifier](http://www.ibm.com/watson/developercloud/doc/nl-classifier/) service to create a classifier instance by providing a set of representative strings and a set of one or more correct classes for each as training. Then use the trained classifier to classify your new question for best matching answers or to retrieve next actions for your application.

```java
NaturalLanguageClassifier service = new NaturalLanguageClassifier();
service.setUsernameAndPassword("<username>", "<password>");

Classification classification = service.classify("<classifier-id>", "Is it sunny?").execute();
System.out.println(classification);
```

**Note:** You will need to create and train a classifier in order to be able to classify phrases.


### Personality Insights
Use linguistic analytics to infer personality and social characteristics, including Big Five, Needs, and Values, from text.  
Example: Analyze text and get a personality profile using the [Personality Insights][personality_insights] service.

```java
PersonalityInsights service = new PersonalityInsights();
service.setUsernameAndPassword("<username>", "<password>");

// Demo content from Moby Dick by Hermann Melville (Chapter 1)
String text = "Call me Ishmael. Some years ago-never mind how long precisely-having "
    + "little or no money in my purse, and nothing particular to interest me on shore, "
    + "I thought I would sail about a little and see the watery part of the world. "
    + "It is a way I have of driving off the spleen and regulating the circulation. "
    + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
    + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
    + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
    + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
    + "principle to prevent me from deliberately stepping into the street, and methodically "
    + "knocking people's hats off-then, I account it high time to get to sea as soon as I can. "
    + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
    + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
    + "If they but knew it, almost all men in their degree, some time or other, cherish "
    + "very nearly the same feelings towards the ocean with me. There now is your insular "
    + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds "
    + "it with her surf. Right and left, the streets take you waterward.";

Profile profile = service.getProfile(text).execute();
System.out.println(profile);
```

**Note:** Don't forget to update the `text` variable! Also, if you experience
authentication errors, remember that the Personality Insights service is not
a free service.


### Retrieve and Rank
The [Retrieve and Rank][retrieve_and_rank] service helps users find the most
relevant information for their query by using a  combination of search and
machine learning to find "signals" in the data.


```java
RetrieveAndRank service = new RetrieveAndRank();
service.setUsernameAndPassword("<username>", "<password>");

// 1 create the Solr Cluster
SolrClusterOptions options = new SolrClusterOptions("my-cluster-name", 1);
SolrCluster cluster = service.createSolrCluster(options).execute();
System.out.println("Solr cluster: " + cluster);

// 2 wait until the Solr Cluster is available
while (cluster.getStatus() == Status.NOT_AVAILABLE) {
  Thread.sleep(10000); // sleep 10 seconds
  cluster = service.getSolrCluster(cluster.getId()).execute();
  System.out.println("Solr cluster status: " + cluster.getStatus());
}

// 3 list Solr Clusters
System.out.println("Solr clusters: " + service.getSolrClusters().execute());
```

Retrieve and Rank is built on top of Apache Solr.
Look at [this](https://github.com/watson-developer-cloud/java-sdk/tree/master/examples/retrieve-and-rank-solrj) example to learn how to use Solrj.

### Speech to Text
Use the [Speech to Text][speech_to_text] service to recognize the text from a .wav file.

```java
SpeechToText service = new SpeechToText();
service.setUsernameAndPassword("<username>", "<password>");

File audio = new File("src/test/resources/sample1.wav");

SpeechResults transcript = service.recognize(audio, HttpMediaType.AUDIO_WAV).execute();
System.out.println(transcript);
```

#### WebSocket support

Speech to Text supports WebSocket, the url is:  
  `wss://stream.watsonplatform.net/speech-to-text/api/v1/recognize`  

  ```java
SpeechToText service = new SpeechToText();
service.setUsernameAndPassword("<username>", "<password>");

File audio = new File("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
  .continuous(true)
  .interimResults(true)
  .contentType(HttpMediaType.AUDIO_WAV)
  .build();

  service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
    @Override
    public void onTranscription(SpeechResults speechResults) {
      System.out.println(speechResults);
    }
  );
  // wait 20 seconds for the asynchronous response
  Thread.sleep(20000);
```

### Text to Speech
Use the [Text to Speech][text_to_speech] service to get the available voices to synthesize.

```java
TextToSpeech service = new TextToSpeech();
service.setUsernameAndPassword("<username>", "<password>");

List<Voice> voices = service.getVoices().execute();
System.out.println(voices);
```

### Tone Analyzer
Use the [Tone Analyzer][tone_analyzer] service to get the tone of your email.

```java
ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
service.setUsernameAndPassword("<username>", "<password>");

String text =
  "I know the times are difficult! Our sales have been "
      + "disappointing for the past three quarters for our data analytics "
      + "product suite. We have a competitive data analytics product "
      + "suite in the industry. But we need to do our job selling it! "
      + "We need to acknowledge and fix our sales challenges. "
      + "We can’t blame the economy for our lack of execution! "
      + "We are missing critical sales opportunities. "
      + "Our product is in no way inferior to the competitor products. "
      + "Our clients are hungry for analytical tools to improve their "
      + "business outcomes. Economy has nothing to do with it.";

// Call the service and get the tone
ToneAnalysis tone = service.getTone(text, null).execute();
System.out.println(tone);
```


### Tradeoff Analytics
Use the [Tradeoff Analytics][tradeoff_analytics] service to find the best
phone that minimizes price and weight and maximizes screen size.

```java
TradeoffAnalytics service = new TradeoffAnalytics();
service.setUsernameAndPassword("<username>", "<password>");

Problem problem = new Problem("phone");

String price = "price";
String ram = "ram";
String screen = "screen";

// Define the objectives
List<Column> columns = new ArrayList<Column>();
problem.setColumns(columns);

columns.add(new NumericColumn().withRange(0, 100).withKey(price).withGoal(Goal.MIN).withObjective(true));
columns.add(new NumericColumn().withKey(screen).withGoal(Goal.MAX).withObjective(true));
columns.add(new NumericColumn().withKey(ram).withGoal(Goal.MAX));

// Define the options to choose
List<Option> options = new ArrayList<Option>();
problem.setOptions(options);

HashMap<String, Object> galaxySpecs = new HashMap<String, Object>();
galaxySpecs.put(price, 50);
galaxySpecs.put(ram, 45);
galaxySpecs.put(screen, 5);
options.add(new Option("1", "Galaxy S4").withValues(galaxySpecs));

HashMap<String, Object> iphoneSpecs = new HashMap<String, Object>();
iphoneSpecs.put(price, 99);
iphoneSpecs.put(ram, 40);
iphoneSpecs.put(screen, 4);
options.add(new Option("2", "iPhone 5").withValues(iphoneSpecs));

HashMap<String, Object> optimusSpecs = new HashMap<String, Object>();
optimusSpecs.put(price, 10);
optimusSpecs.put(ram, 300);
optimusSpecs.put(screen, 5);
options.add(new Option("3", "LG Optimus G").withValues(optimusSpecs));

// Call the service and get the resolution
Dilemma dilemma = service.dilemmas(problem).execute();
System.out.println(dilemma);
```

### Visual Recognition
Use the [Visual Recognition][visual_recognition] service to recognize the
following picture.

![Car](https://visual-recognition-demo.mybluemix.net/images/samples/5.jpg)

```java
VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
service.setApiKey("<api-key>");

System.out.println("Classify an image");
ClassifyImagesOptions options = new ClassifyImagesOptions.Builder()
    .images(new File("src/test/resources/visual_recognition/car.png"))
    .build();
VisualClassification result = service.classify(options).execute();
System.out.println(result);
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
  $ gradle jar  # build jar file (build/libs/watson-developer-cloud-3.3.1.jar)
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

[personality_insights]: http://www.ibm.com/watson/developercloud/doc/personality-insights/
[document_conversion]: http://www.ibm.com/watson/developercloud/doc/document-conversion/
[language_translation]: http://www.ibm.com/watson/developercloud/doc/language-translation/
[visual_recognition]: http://www.ibm.com/watson/developercloud/doc/visual-recognition/
[tradeoff_analytics]: http://www.ibm.com/watson/developercloud/doc/tradeoff-analytics/
[text_to_speech]: http://www.ibm.com/watson/developercloud/doc/text-to-speech/
[speech_to_text]: http://www.ibm.com/watson/developercloud/doc/speech-to-text/
[tone_analyzer]: http://www.ibm.com/watson/developercloud/doc/tone-analyzer/
[dialog]: http://www.ibm.com/watson/developercloud/doc/dialog/
[concept_insights]: https://www.ibm.com/watson/developercloud/doc/concept-insights/
[conversation]: https://www.ibm.com/watson/developercloud/doc/conversation/
[retrieve_and_rank]: http://www.ibm.com/watson/developercloud/doc/retrieve-rank/
[dialog_migration]: https://www.ibm.com/watson/developercloud/doc/conversation/migration.shtml

[alchemy_language]: http://www.alchemyapi.com/products/alchemylanguage
[sentiment_analysis]: http://www.alchemyapi.com/products/alchemylanguage/sentiment-analysis
[alchemy_vision]: http://www.alchemyapi.com/products/alchemyvision
[alchemy_data_news]: http://www.alchemyapi.com/products/alchemydata-news

[wdc]: http://www.ibm.com/watson/developercloud/
[bluemix]: https://console.ng.bluemix.net
[Gradle]: http://www.gradle.org/
[OkHttp]: http://square.github.io/okhttp/
[gson]: https://github.com/google/gson
[apache_maven]: http://maven.apache.org/
[sonatype_snapshots]: https://oss.sonatype.org/content/repositories/snapshots/com/ibm/watson/developer_cloud/java-sdk/

[jar]: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-3.3.1/java-sdk-3.3.1-jar-with-dependencies.jar
