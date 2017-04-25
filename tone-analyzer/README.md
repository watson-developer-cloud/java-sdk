# Tone Analyzer

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>tone-analyzer</artifactId>
	<version>3.8.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:tone-analyzer:3.8.0'
```

## Usage
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

[tone_analyzer]: https://www.ibm.com/watson/developercloud/doc/tone-analyzer/index.html