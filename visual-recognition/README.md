# Visual Recognition

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>visual-recognition</artifactId>
  <version>7.0.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:visual-recognition:7.0.0'
```

## Usage
Use the [Visual Recognition][visual_recognition] service to recognize the
following picture.

![Car](https://visual-recognition-demo.ng.bluemix.net/images/samples/5.jpg)

```java
VisualRecognition service = new VisualRecognition("2016-05-20");
IamOptions iamOptions = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(iamOptions);

System.out.println("Classify an image");
ClassifyOptions options = new ClassifyOptions.Builder()
  .imagesFile(new File(SINGLE_IMAGE_FILE))
  .build();
ClassifiedImages result = service.classify(options).execute().getResult();
System.out.println(result);
```

[visual_recognition]: https://cloud.ibm.com/docs/services/visual-recognition?topic=visual-recognition-getting-started-tutorial
