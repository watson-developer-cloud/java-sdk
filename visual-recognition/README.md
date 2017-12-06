# Visual Recognition

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>visual-recognition</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:visual-recognition:4.1.0'
```

## Usage
Use the [Visual Recognition][visual_recognition] service to recognize the
following picture.

![Car](https://visual-recognition-demo.mybluemix.net/images/samples/5.jpg)

```java
VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
service.setApiKey("<api-key>");

System.out.println("Classify an image");
ClassifyOptions options = new ClassifyOptions.Builder()
    .imagesFile(new File(SINGLE_IMAGE_FILE))
    .build();
ClassifiedImages result = service.classify(options).execute();
System.out.println(result);
```

[visual_recognition]: http://www.ibm.com/watson/developercloud/doc/visual-recognition/