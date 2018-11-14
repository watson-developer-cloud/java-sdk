# Visual Recognition

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>visual-recognition</artifactId>
  <version>6.9.2</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:visual-recognition:6.9.2'
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
ClassifiedImages result = service.classify(options).execute();
System.out.println(result);
```

[visual_recognition]: https://console.bluemix.net/docs/services/visual-recognition/getting-started.html