# Visual Recognition

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>visual-recognition</artifactId>
  <version>9.3.0</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:visual-recognition:9.3.0'
```

## Usage

Use the [Visual Recognition][visual_recognition] service to analyze image data. Use either v3 or v4 to analyze the following image:

![Dog](https://visual-recognition-demo.ng.bluemix.net/images/samples/5.jpg)

### Using Visual Recognition v3

```java
// make sure to use the Visual Recognition v3 import!
import com.ibm.watson.visual_recognition.v3.VisualRecognition;

Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
VisualRecognition service = new VisualRecognition("2018-03-19", authenticator);

System.out.println("Classify an image");
ClassifyOptions options = new ClassifyOptions.Builder()
  .imagesFile(new File(IMAGE_FILE)) // replace with path to file
  .build();
ClassifiedImages result = service.classify(options).execute().getResult();
System.out.println(result);
```

### Using Visual Recognition v4

```java
// make sure to use the Visual Recognition v4 import!
import com.ibm.watson.visual_recognition.v4.VisualRecognition;

Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
VisualRecognition service = new VisualRecognition("2019-02-11", authenticator);

// create a new collection
CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions.Builder()
    .name("example-collection")
    .build();
Collection exampleCollection = service.createCollection(createCollectionOptions).execute().getResult();
String exampleCollectionId = exampleCollection.getCollectionId();

// add the above image to your collection
String imageUrl = "https://visual-recognition-demo.ng.bluemix.net/images/samples/5.jpg";
AddImagesOptions addImagesOptions = new AddImagesOptions.Builder()
    .addImageUrl(imageUrl)
    .collectionId(exampleCollectionId)
    .build();
ImageDetailsList imageDetailsList = service.addImages(addImagesOptions).execute().getResult();
String testImageId = imageDetailsList.getImages().get(0).getImageId();

// .
// .
// add more images to fill up your collection for training
// .
// .

// train the collection on your first image
Location location = new Location.Builder()
    .top(25L)
    .left(35L)
    .width(105L)
    .height(215L)
    .build();
TrainingDataObject trainingDataObject = new TrainingDataObject.Builder()
    .object("dog")
    .location(location)
    .build();
AddImageTrainingDataOptions addTrainingDataOptions = new AddImageTrainingDataOptions.Builder()
    .collectionId(exampleCollectionId)
    .addObjects(trainingDataObject)
    .imageId(testImageId)
    .build();
service.addImageTrainingData(addTrainingDataOptions).execute();
TrainOptions trainOptions = new TrainOptions.Builder()
    .collectionId(exampleCollectionId)
    .build();
service.train(trainOptions).execute().getResult();

// analyze the image!
AnalyzeOptions options = new AnalyzeOptions.Builder()
    .addImageUrl(imageUrl)
    .addCollectionIds(exampleCollectionId)
    .addFeatures(AnalyzeOptions.Features.OBJECTS)
    .build();
AnalyzeResponse response = service.analyze(options).execute().getResult();

System.out.println(response);
```

[visual_recognition]: https://cloud.ibm.com/docs/visual-recognition?topic=visual-recognition-getting-started-tutorial
