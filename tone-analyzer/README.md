# Tone Analyzer

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>tone-analyzer</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:tone-analyzer:4.1.0'
```

## Usage
Use the [Tone Analyzer][tone_analyzer] service to get the tone of your email.

```java
final String VERSION_DATE = "2016-05-19";
ToneAnalyzer service = new ToneAnalyzer(VERSION_DATE);
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
ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
ToneAnalysis tone = service.tone(toneOptions).execute();
System.out.println(tone);
```

[tone_analyzer]: https://console.bluemix.net/docs/services/tone-analyzer/index.html
