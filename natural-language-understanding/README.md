# Natural Language Understanding

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>natural-language-understanding</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:natural-language-understanding:4.1.0'
```

## Usage
Use [Natural Language Understanding](http://www.ibm.com/watson/developercloud/doc/natural-language-understanding/index.html)
to analyze various features of text content at scale. Provide text, raw HTML, or a public URL, and IBM Watson Natural
Language Understanding will give you results for the features you request. The service cleans HTML content before
analysis by default, so the results can ignore most advertisements and other unwanted content.

```java
NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
  NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
  "username",
  "password"
);

EntitiesOptions entities = new EntitiesOptions.Builder().sentiment(true).limit(1).build();
Features features = new Features.Builder().entities(entities).build();
AnalyzeOptions parameters = new AnalyzeOptions.Builder().url("www.cnn.com").features(features).build();
AnalysisResults results = service.analyze(parameters).execute();
```

We also offer a cognitive client which makes use of this API to provide enhanced features for applications using our natural language understanding services:
https://github.com/watson-developer-cloud/cognitive-client-java
