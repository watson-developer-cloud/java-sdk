# Natural Language Understanding

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>natural-language-understanding</artifactId>
  <version>7.2.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:natural-language-understanding:7.2.0'
```

## Usage
Use [Natural Language Understanding](https://cloud.ibm.com/docs/services/natural-language-understanding?topic=natural-language-understanding-about)
to analyze various features of text content at scale. Provide text, raw HTML, or a public URL, and IBM Watson Natural
Language Understanding will give you results for the features you request. The service cleans HTML content before
analysis by default, so the results can ignore most advertisements and other unwanted content.

```java
NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding("2017-02-27");
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

EntitiesOptions entities = new EntitiesOptions.Builder()
  .sentiment(true)
  .limit(1)
  .build();
Features features = new Features.Builder()
  .entities(entities)
  .build();
AnalyzeOptions parameters = new AnalyzeOptions.Builder()
  .url("www.cnn.com")
  .features(features)
  .build();

AnalysisResults results = service.analyze(parameters).execute().getResul();
System.out.println(results);
```
