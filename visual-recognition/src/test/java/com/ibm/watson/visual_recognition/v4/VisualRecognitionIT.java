package com.ibm.watson.visual_recognition.v4;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.visual_recognition.v4.model.AddImageTrainingDataOptions;
import com.ibm.watson.visual_recognition.v4.model.AddImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeResponse;
import com.ibm.watson.visual_recognition.v4.model.Collection;
import com.ibm.watson.visual_recognition.v4.model.CollectionsList;
import com.ibm.watson.visual_recognition.v4.model.CreateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteImageOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.GetImageDetailsOptions;
import com.ibm.watson.visual_recognition.v4.model.GetJpegImageOptions;
import com.ibm.watson.visual_recognition.v4.model.ImageDetails;
import com.ibm.watson.visual_recognition.v4.model.ImageDetailsList;
import com.ibm.watson.visual_recognition.v4.model.ImageSummary;
import com.ibm.watson.visual_recognition.v4.model.ImageSummaryList;
import com.ibm.watson.visual_recognition.v4.model.ListImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.Location;
import com.ibm.watson.visual_recognition.v4.model.TrainOptions;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObject;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObjects;
import com.ibm.watson.visual_recognition.v4.model.UpdateCollectionOptions;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Visual Recognition Integration test.
 *
 * @version v3
 */
@RunWith(RetryRunner.class)
public class VisualRecognitionIT extends WatsonServiceTest {
  private static final String VERSION = "2019-02-11";
  private static final String RESOURCE = "src/test/resources/visual_recognition/v4/";

  private static final String COLLECTION_ID = "684777e5-1f2d-40e3-987f-72d36557ef46";
  private static final String GIRAFFE_CLASSNAME = "giraffe";
  private static final String SINGLE_GIRAFFE_IMAGE_PATH = RESOURCE + "giraffe_to_classify.jpg";
  private static final String GIRAFFE_POSITIVE_EXAMPLES_PATH = RESOURCE + "giraffe_positive_examples.zip";
  private static final String SINGLE_TURTLE_IMAGE_PATH = RESOURCE + "turtle_to_classify.jpg";
  private static final String DOG_IMAGE_URL = "https://upload.wikimedia"
      + ".org/wikipedia/commons/thumb/4/47/American_Eskimo_Dog.jpg/1280px-American_Eskimo_Dog.jpg";
  private static final String CAT_IMAGE_URL = "https://upload.wikimedia"
      + ".org/wikipedia/commons/thumb/4/4f/Felis_silvestris_catus_lying_on_rice_straw"
      + ".jpg/1280px-Felis_silvestris_catus_lying_on_rice_straw.jpg";

  private VisualRecognition service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String iamApiKey = getProperty("visual_recognition.apikey");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (iamApiKey == null) || iamApiKey.equals("API_KEY"));

    Authenticator authenticator = new IamAuthenticator(iamApiKey);
    service = new VisualRecognition(VERSION, authenticator);
    service.setDefaultHeaders(getDefaultHeaders());
  }

  private String createTestCollection() {
    String testCollectionName = "java-sdk-test-collection";
    String testCollectionDescription = "Collection for integration testing of the Visual Recognition v4 service in "
        + "the Java SDK";
    CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions.Builder()
        .name(testCollectionName)
        .description(testCollectionDescription)
        .build();
    Collection newCollection = service.createCollection(createCollectionOptions).execute().getResult();
    String testCollectionId = newCollection.getCollectionId();

    return testCollectionId;
  }

  private void deleteTestCollection(String collectionId) {
    DeleteCollectionOptions deleteCollectionOptions = new DeleteCollectionOptions.Builder()
        .collectionId(collectionId)
        .build();
    service.deleteCollection(deleteCollectionOptions).execute();
  }

  @Test
  public void testAnalyzeWithFiles() throws FileNotFoundException {
    FileWithMetadata giraffeImage = new FileWithMetadata.Builder()
        .data(new File(SINGLE_GIRAFFE_IMAGE_PATH))
        .contentType("image/jpeg")
        .build();
    FileWithMetadata turtleImage = new FileWithMetadata.Builder()
        .data(new File(SINGLE_TURTLE_IMAGE_PATH))
        .contentType("image/jpeg")
        .build();
    List<FileWithMetadata> filesToAnalyze = Arrays.asList(giraffeImage, turtleImage);
    List<String> collectionIds = Collections.singletonList(COLLECTION_ID);

    AnalyzeOptions options = new AnalyzeOptions.Builder()
        .imagesFile(filesToAnalyze)
        .collectionIds(collectionIds)
        .addFeatures(AnalyzeOptions.Features.OBJECTS)
        .threshold(.5f)
        .build();
    AnalyzeResponse response = service.analyze(options).execute().getResult();

    assertNotNull(response);
    assertEquals(2, response.getImages().size());
  }

  @Test
  public void testAnalyzeWithUrl() throws FileNotFoundException {
    AnalyzeOptions options = new AnalyzeOptions.Builder()
        .addImageUrl(DOG_IMAGE_URL)
        .addCollectionIds(COLLECTION_ID)
        .addFeatures(AnalyzeOptions.Features.OBJECTS)
        .build();
    AnalyzeResponse response = service.analyze(options).execute().getResult();

    assertNotNull(response);
    assertEquals(1, response.getImages().size());
  }

  @Test
  public void testCollectionOperations() {
    String testCollectionId = null;

    try {
      // test create
      String newCollectionName = "java-sdk-test-collection";
      String newCollectionDescription = "Collection for integration testing of the Visual Recognition v4 service in"
          + " the Java SDK";
      CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions.Builder()
          .name(newCollectionName)
          .description(newCollectionDescription)
          .build();
      Collection newCollection = service.createCollection(createCollectionOptions).execute().getResult();

      assertNotNull(newCollection);
      assertEquals(newCollectionName, newCollection.getName());
      assertEquals(newCollectionDescription, newCollection.getDescription());

      // test get
      testCollectionId = newCollection.getCollectionId();
      GetCollectionOptions getCollectionOptions = new GetCollectionOptions.Builder()
          .collectionId(testCollectionId)
          .build();
      Collection retrievedCollection = service.getCollection(getCollectionOptions).execute().getResult();

      assertNotNull(retrievedCollection);
      assertEquals(newCollection.getCollectionId(), retrievedCollection.getCollectionId());

      // test update
      String updatedDescription = "Collection with an updated description, still for testing in the Java SDK.";
      UpdateCollectionOptions updateCollectionOptions = new UpdateCollectionOptions.Builder()
          .collectionId(testCollectionId)
          .description(updatedDescription)
          .build();
      Collection updatedCollection = service.updateCollection(updateCollectionOptions).execute().getResult();

      assertNotNull(updatedCollection);
      assertEquals(updatedDescription, updatedCollection.getDescription());
    } finally {
      if (testCollectionId != null) {
        // test delete
        DeleteCollectionOptions deleteCollectionOptions = new DeleteCollectionOptions.Builder()
            .collectionId(testCollectionId)
            .build();
        service.deleteCollection(deleteCollectionOptions).execute();

        // test list
        CollectionsList collectionsList = service.listCollections().execute().getResult();

        assertNotNull(collectionsList);
        for (Collection collection : collectionsList.getCollections()) {
          assertFalse(collection.getCollectionId().equals(testCollectionId));
        }
      }
    }
  }

  @Test
  public void testImageOperations() throws IOException {
    // create new collection so we don't run into duplicate image issues
    String testCollectionId = createTestCollection();

    List<String> imageUrlList = Arrays.asList(CAT_IMAGE_URL, DOG_IMAGE_URL);
    FileWithMetadata turtleFile = new FileWithMetadata.Builder()
        .data(new File(SINGLE_TURTLE_IMAGE_PATH))
        .contentType("image/jpeg")
        .build();

    AddImagesOptions addImagesOptions = new AddImagesOptions.Builder()
        .imageUrl(imageUrlList)
        .addImagesFile(turtleFile)
        .collectionId(testCollectionId)
        .build();
    ImageDetailsList imageDetailsList = service.addImages(addImagesOptions).execute().getResult();

    assertNotNull(imageDetailsList);
    String singleImageId = null;
    Set<String> addedImageIds = new HashSet<>();
    for (ImageDetails imageDetails : imageDetailsList.getImages()) {
      addedImageIds.add(imageDetails.getImageId());
      if (singleImageId == null) {
        singleImageId = imageDetails.getImageId();
      }
    }

    try {
      // test get
      GetImageDetailsOptions getImageDetailsOptions = new GetImageDetailsOptions.Builder()
          .collectionId(testCollectionId)
          .imageId(singleImageId)
          .build();
      ImageDetails imageDetails = service.getImageDetails(getImageDetailsOptions).execute().getResult();

      assertNotNull(imageDetails);
      assertEquals(singleImageId, imageDetails.getImageId());

      // test get JPEG
      GetJpegImageOptions getJpegImageOptions = new GetJpegImageOptions.Builder()
          .collectionId(testCollectionId)
          .imageId(singleImageId)
          .size(GetJpegImageOptions.Size.FULL)
          .build();
      InputStream imageStream = service.getJpegImage(getJpegImageOptions).execute().getResult();

      assertNotNull(imageStream);
      imageStream.close();
    } finally {
      // delete images
      for (String imageId : addedImageIds) {
        DeleteImageOptions deleteImageOptions = new DeleteImageOptions.Builder()
            .imageId(imageId)
            .collectionId(testCollectionId)
            .build();
        service.deleteImage(deleteImageOptions).execute();
      }

      // test list and delete
      ListImagesOptions listImagesOptions = new ListImagesOptions.Builder()
          .collectionId(testCollectionId)
          .build();
      ImageSummaryList imageSummaryList = service.listImages(listImagesOptions).execute().getResult();

      assertNotNull(imageSummaryList);
      for (ImageSummary imageSummary : imageSummaryList.getImages()) {
        assertFalse(addedImageIds.contains(imageSummary.getImageId()));
      }

      // remove test collection
      deleteTestCollection(testCollectionId);
    }
  }

  @Test
  public void testTrainingOperations() throws FileNotFoundException {
    String testCollectionId = createTestCollection();

    // start by adding images for training
    FileWithMetadata giraffeFileZip = new FileWithMetadata.Builder()
        .data(new File(GIRAFFE_POSITIVE_EXAMPLES_PATH))
        .contentType(HttpMediaType.APPLICATION_ZIP)
        .build();

    AddImagesOptions addImagesOptions = new AddImagesOptions.Builder()
        .addImagesFile(giraffeFileZip)
        .collectionId(testCollectionId)
        .build();
    ImageDetailsList imageDetailsList = service.addImages(addImagesOptions).execute().getResult();

    String imageIdForTraining = null;
    Set<String> addedImageIds = new HashSet<>();
    for (ImageDetails imageDetails : imageDetailsList.getImages()) {
      addedImageIds.add(imageDetails.getImageId());
      if (imageIdForTraining == null) {
        imageIdForTraining = imageDetails.getImageId();
      }
    }

    try {
      Long top = 64L;
      Long left = 270L;
      Long width = 755L;
      Long height = 784L;
      Location testLocation = new Location.Builder()
          .top(top)
          .left(left)
          .width(width)
          .height(height)
          .build();
      TrainingDataObject trainingDataObject = new TrainingDataObject.Builder()
          .object(GIRAFFE_CLASSNAME)
          .location(testLocation)
          .build();

      // test adding training data
      AddImageTrainingDataOptions addTrainingDataOptions = new AddImageTrainingDataOptions.Builder()
          .collectionId(testCollectionId)
          .addObjects(trainingDataObject)
          .imageId(imageIdForTraining)
          .build();
      TrainingDataObjects trainingDataObjects = service.addImageTrainingData(addTrainingDataOptions).execute()
          .getResult();

      assertNotNull(trainingDataObjects);
      assertEquals(GIRAFFE_CLASSNAME, trainingDataObjects.getObjects().get(0).object());
      assertEquals(top, trainingDataObjects.getObjects().get(0).location().top());
      assertEquals(left, trainingDataObjects.getObjects().get(0).location().left());
      assertEquals(width, trainingDataObjects.getObjects().get(0).location().width());
      assertEquals(height, trainingDataObjects.getObjects().get(0).location().height());

      // test train
      TrainOptions trainOptions = new TrainOptions.Builder()
          .collectionId(testCollectionId)
          .build();
      Collection trainingCollection = service.train(trainOptions).execute().getResult();

      assertNotNull(trainingCollection);
      assertTrue(
          trainingCollection.getTrainingStatus().objects().inProgress()
              || trainingCollection.getTrainingStatus().objects().ready()
      );
    } finally {
      // delete images we added earlier
      for (String imageId : addedImageIds) {
        DeleteImageOptions deleteImageOptions = new DeleteImageOptions.Builder()
            .collectionId(testCollectionId)
            .imageId(imageId)
            .build();
        service.deleteImage(deleteImageOptions).execute();
      }

      deleteTestCollection(testCollectionId);
    }
  }

  @Test
  public void testDeleteUserData() {
    DeleteUserDataOptions deleteUserDataOptions = new DeleteUserDataOptions.Builder()
        .customerId("test_customer_id")
        .build();
    int statusCode = service.deleteUserData(deleteUserDataOptions).execute().getStatusCode();

    assertEquals(202, statusCode);
  }
}
