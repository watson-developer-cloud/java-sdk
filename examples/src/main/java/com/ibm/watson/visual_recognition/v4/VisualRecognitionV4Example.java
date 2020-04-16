import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v4.VisualRecognition;
import com.ibm.watson.visual_recognition.v4.model.AddImageTrainingDataOptions;
import com.ibm.watson.visual_recognition.v4.model.AddImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeResponse;
import com.ibm.watson.visual_recognition.v4.model.BaseObject;
import com.ibm.watson.visual_recognition.v4.model.Collection;
import com.ibm.watson.visual_recognition.v4.model.CreateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.GetCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.ImageDetailsList;
import com.ibm.watson.visual_recognition.v4.model.Location;
import com.ibm.watson.visual_recognition.v4.model.TrainOptions;

public class VisualRecognitionExample {

  public static void main(String[] args) throws FileNotFoundException {
    Authenticator authenticator = new IamAuthenticator("{iam_api_key}");
    VisualRecognition service = new VisualRecognition("2019-02-11", authenticator);

    // create a new collection
    CreateCollectionOptions createCollectionOptions =
        new CreateCollectionOptions.Builder().name("example-collection").build();
    Collection exampleCollection =
        service.createCollection(createCollectionOptions).execute().getResult();
    String exampleCollectionId = exampleCollection.getCollectionId();

    // add some images to the new collection
    AddImagesOptions addImagesOptions =
        new AddImagesOptions.Builder()
            .addImagesFile("{zip_file_of_images}")
            .collectionId(exampleCollectionId)
            .build();
    ImageDetailsList imageDetailsList = service.addImages(addImagesOptions).execute().getResult();

    // get image ID of one of your uploaded images for later
    String imageId = imageDetailsList.getImages().get(0).getImageId();

    // add some training data with the location of the object you want to identify
    // replace these location values with something that makes sense for your image
    Location location = new Location.Builder().top(0L).left(1L).width(2L).height(3L).build();
    BaseObject baseObject =
        new BaseObject.Builder().object("{training_object_name}").location(location).build();
    AddImageTrainingDataOptions addTrainingDataOptions =
        new AddImageTrainingDataOptions.Builder()
            .collectionId(exampleCollectionId)
            .addObjects(baseObject)
            .imageId(imageId)
            .build();
    service.addImageTrainingData(addTrainingDataOptions).execute();

    // train the collection
    TrainOptions trainOptions =
        new TrainOptions.Builder().collectionId(exampleCollectionId).build();
    service.train(trainOptions).execute().getResult();

    // wait until the collection is trained to test it out
    GetCollectionOptions getCollectionOptions =
        new GetCollectionOptions.Builder().collectionId(exampleCollectionId).build();
    Collection retrievedCollection =
        service.getCollection(getCollectionOptions).execute().getResult();
    while (!retrievedCollection.getTrainingStatus().objects().ready()) {
      Thread.sleep(5000);
      retrievedCollection = service.getCollection(getCollectionOptions).execute().getResult();
    }

    // analyze an image at a URL
    String imageUrl =
        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/American_Eskimo_Dog"
            + ".jpg/1280px-American_Eskimo_Dog.jpg";
    AnalyzeOptions options =
        new AnalyzeOptions.Builder()
            .addImageUrl(imageUrl)
            .addColectionId(exampleCollectionId)
            .addFeature(AnalyzeOptions.Features.OBJECTS)
            .build();
    AnalyzeResponse response = service.analyze(options).execute().getResult();

    // print out results!
    System.out.println(response);

    // clean up collection
    DeleteCollectionOptions deleteCollectionOptions =
        new DeleteCollectionOptions.Builder().collectionId(exampleCollectionId).build();
    service.deleteCollection(deleteCollectionOptions).execute();
  }
}
