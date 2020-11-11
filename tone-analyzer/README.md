# Tone Analyzer

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>tone-analyzer</artifactId>
  <version>9.0.0-rc.1</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:tone-analyzer:9.0.0-rc.1'
```

## Usage

Use the [Tone Analyzer][tone_analyzer] service to get the tone of your email.

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
ToneAnalyzer service = new ToneAnalyzer("2017-09-21", authenticator);

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
ToneOptions toneOptions = new ToneOptions.Builder()
  .text(text)
  .build();

ToneAnalysis tone = service.tone(toneOptions).execute().getResult();
System.out.println(tone);
```

[tone_analyzer]: https://cloud.ibm.com/docs/tone-analyzer?topic=tone-analyzer-about
