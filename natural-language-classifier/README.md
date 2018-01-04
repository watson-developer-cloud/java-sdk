# Natural Language Classifier

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>natural-language-classifier</artifactId>
	<version>4.2.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:natural-language-classifier:4.2.1'
```

## Usage
Use [Natural Language Classifier](https://console.bluemix.net/docs/services/natural-language-classifier/getting-started.html) service to create a classifier instance by providing a set of representative strings and a set of one or more correct classes for each as training. Then use the trained classifier to classify your new question for best matching answers or to retrieve next actions for your application.

```java
NaturalLanguageClassifier service = new NaturalLanguageClassifier();
service.setUsernameAndPassword("<username>", "<password>");

Classification classification = service.classify("<classifier-id>", "Is it sunny?").execute();
System.out.println(classification);
```

**Note:** You will need to create and train a classifier in order to be able to classify phrases.
