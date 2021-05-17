# Natural Language Classifier

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>natural-language-classifier</artifactId>
  <version>9.1.1</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:natural-language-classifier:9.1.1'
```

## Usage

Use [Natural Language Classifier](https://cloud.ibm.com/docs/natural-language-classifier?topic=natural-language-classifier-natural-language-classifier) service to create a classifier instance by providing a set of representative strings and a set of one or more correct classes for each as training. Then use the trained classifier to classify your new question for best matching answers or to retrieve next actions for your application.

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
NaturalLanguageClassifier service = new NaturalLanguageClassifier(authenticator);

ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
  .classifierId("<classifier-id>")
  .text("Is it sunny?")
  .build();

Classification classification = service.classify(classifyOptions).execute().getResult();
System.out.println(classification);
```

**Note:** You will need to create and train a classifier in order to be able to classify phrases.
