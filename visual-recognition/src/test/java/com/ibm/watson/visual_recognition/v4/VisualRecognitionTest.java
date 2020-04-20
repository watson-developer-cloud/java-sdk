package com.ibm.watson.visual_recognition.v4;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import com.google.common.io.Files;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.visual_recognition.v4.model.AddImageTrainingDataOptions;
import com.ibm.watson.visual_recognition.v4.model.AddImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeResponse;
import com.ibm.watson.visual_recognition.v4.model.Collection;
import com.ibm.watson.visual_recognition.v4.model.CollectionsList;
import com.ibm.watson.visual_recognition.v4.model.CreateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteImageOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteObjectOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.GetImageDetailsOptions;
import com.ibm.watson.visual_recognition.v4.model.GetJpegImageOptions;
import com.ibm.watson.visual_recognition.v4.model.GetObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetTrainingUsageOptions;
import com.ibm.watson.visual_recognition.v4.model.ImageDetails;
import com.ibm.watson.visual_recognition.v4.model.ImageDetailsList;
import com.ibm.watson.visual_recognition.v4.model.ImageSummaryList;
import com.ibm.watson.visual_recognition.v4.model.ListCollectionsOptions;
import com.ibm.watson.visual_recognition.v4.model.ListImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.ListObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.model.Location;
import com.ibm.watson.visual_recognition.v4.model.ObjectMetadata;
import com.ibm.watson.visual_recognition.v4.model.ObjectMetadataList;
import com.ibm.watson.visual_recognition.v4.model.ObjectTrainingStatus;
import com.ibm.watson.visual_recognition.v4.model.TrainOptions;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObject;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObjects;
import com.ibm.watson.visual_recognition.v4.model.TrainingEvents;
import com.ibm.watson.visual_recognition.v4.model.TrainingStatus;
import com.ibm.watson.visual_recognition.v4.model.UpdateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.UpdateObjectMetadata;
import com.ibm.watson.visual_recognition.v4.model.UpdateObjectMetadataOptions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

/** Unit tests for the {@link VisualRecognition} service. */
public class VisualRecognitionTest extends WatsonServiceUnitTest {
  private static final String VERSION = "2019-02-11";
  private static final String RESOURCE = "src/test/resources/visual_recognition/v4/";

  private static final String COLLECTION_ID = "123456789";
  private static final String IMAGE_URL = "www.image.jpg";
  private static final String TRAINING_DATA = "training_data";
  private static final String OBJECT = "object";
  private static final Long TOP = 0L;
  private static final Long LEFT = 10L;
  private static final Long WIDTH = 100L;
  private static final Long HEIGHT = 200L;
  private static final String IMAGE_ID = "image_id";
  private static final Float THRESHOLD = 12f;
  private static final String NAME = "name";
  private static final String DESCRIPTION = "description";
  private static final Long IMAGE_COUNT = 50L;
  private static final String CUSTOMER_ID = "customer_id";
  private static final String IMAGE_TYPE = "file";
  private static final String FILENAME = "filename";
  private static final String ARCHIVE_FILENAME = "archive_filename";
  private static final String SOURCE_URL = "source_url";
  private static final String RESOLVED_URL = "resolved_url";
  private static final Float SCORE = 5.0f;
  private static final String CODE = "code";
  private static final String MESSAGE = "message";
  private static final String MORE_INFO = "more_info";
  private static final String ERROR_TYPE = "field";
  private static final String TRACE = "trace";
  private static final Long COMPLETED_EVENTS = 7L;
  private static final Long TRAINED_IMAGES = 15L;
  private static final String TYPE = "objects";
  private static final String STATUS = "succeeded";
  private static final String START_TIME = "1995-06-12";
  private static final String END_TIME = "2019-11-19";

  private FileWithMetadata fileWithMetadata;
  private TrainingDataObject trainingDataObject;
  private ObjectTrainingStatus objectTrainingStatus;
  private Date testDate;

  private AnalyzeResponse analyzeResponse;
  private Collection collection;
  private CollectionsList collectionsList;
  private ImageDetailsList imageDetailsList;
  private ImageSummaryList imageSummaryList;
  private ImageDetails imageDetails;
  private File imageFile;
  private TrainingDataObjects trainingDataObjects;
  private TrainingEvents trainingEvents;
  private ObjectMetadataList objectMetadataList;
  private ObjectMetadata objectName;

  private VisualRecognition service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.common.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new VisualRecognition(VERSION, new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());

    // create test models
    fileWithMetadata =
        new FileWithMetadata.Builder()
            .data(new File("src/test/resources/visual_recognition/v4/giraffe_to_classify.jpg"))
            .build();
    new Location.Builder().top(TOP).left(LEFT).height(HEIGHT).width(WIDTH).build();
    trainingDataObject = new TrainingDataObject.Builder().build();
    objectTrainingStatus =
        new ObjectTrainingStatus.Builder()
            .ready(true)
            .inProgress(true)
            .dataChanged(true)
            .latestFailed(true)
            .description(DESCRIPTION)
            .build();
    new TrainingStatus.Builder().objects(objectTrainingStatus).build();
    String dateString = "1995-06-12T01:11:11.111+0000";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
    testDate = dateFormat.parse(dateString);

    // load mock responses
    analyzeResponse = loadFixture(RESOURCE + "analyze-response.json", AnalyzeResponse.class);
    collection = loadFixture(RESOURCE + "collection.json", Collection.class);
    collectionsList = loadFixture(RESOURCE + "collections-list.json", CollectionsList.class);
    imageDetailsList = loadFixture(RESOURCE + "image-details-list.json", ImageDetailsList.class);
    imageSummaryList = loadFixture(RESOURCE + "image-summary-list.json", ImageSummaryList.class);
    imageDetails = loadFixture(RESOURCE + "image-details.json", ImageDetails.class);
    imageFile = new File(RESOURCE + "giraffe_to_classify.jpg");
    trainingDataObjects =
        loadFixture(RESOURCE + "training-data-objects.json", TrainingDataObjects.class);
    trainingEvents = loadFixture(RESOURCE + "training-events.json", TrainingEvents.class);
    objectMetadataList =
        loadFixture(RESOURCE + "object-metadata-list.json", ObjectMetadataList.class);
    objectName = loadFixture(RESOURCE + "object-name.json", ObjectMetadata.class);
  }

  @Test
  public void testConfigBasedConstructor() {
    VisualRecognition service = new VisualRecognition(VERSION);
    assertEquals(Authenticator.AUTHTYPE_BASIC, service.getAuthenticator().authenticationType());
  }

  @Test
  public void testAddImagesOptions() {
    List<FileWithMetadata> imageList = new ArrayList<>();
    imageList.add(fileWithMetadata);
    List<String> imageUrlList = new ArrayList<>();
    imageUrlList.add(IMAGE_URL);

    AddImagesOptions options =
        new AddImagesOptions.Builder()
            .imagesFile(imageList)
            .addImagesFile(fileWithMetadata)
            .imageUrl(imageUrlList)
            .addImageUrl(IMAGE_URL)
            .collectionId(COLLECTION_ID)
            .trainingData(TRAINING_DATA)
            .build();
    options = options.newBuilder().build();

    assertEquals(2, options.imagesFile().size());
    assertEquals(fileWithMetadata, options.imagesFile().get(0));
    assertEquals(2, options.imageUrl().size());
    assertEquals(IMAGE_URL, options.imageUrl().get(0));
    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(TRAINING_DATA, options.trainingData());
  }

  @Test
  public void testAddImageTrainingDataOptions() {
    List<TrainingDataObject> objectList = new ArrayList<>();
    objectList.add(trainingDataObject);

    AddImageTrainingDataOptions options =
        new AddImageTrainingDataOptions.Builder()
            .collectionId(COLLECTION_ID)
            .imageId(IMAGE_ID)
            .objects(objectList)
            .addObjects(trainingDataObject)
            .build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(IMAGE_ID, options.imageId());
    assertEquals(2, options.objects().size());
    assertEquals(trainingDataObject, options.objects().get(0));
  }

  @Test
  public void testAnalyzeOptions() {
    List<String> collectionIdList = new ArrayList<>();
    collectionIdList.add(COLLECTION_ID);
    List<String> featureList = new ArrayList<>();
    featureList.add(AnalyzeOptions.Features.OBJECTS);
    List<FileWithMetadata> imageList = new ArrayList<>();
    imageList.add(fileWithMetadata);
    List<String> imageUrlList = new ArrayList<>();
    imageUrlList.add(IMAGE_URL);

    AnalyzeOptions options =
        new AnalyzeOptions.Builder()
            .collectionIds(collectionIdList)
            .addCollectionIds(COLLECTION_ID)
            .features(featureList)
            .addFeatures(AnalyzeOptions.Features.OBJECTS)
            .imagesFile(imageList)
            .addImagesFile(fileWithMetadata)
            .imageUrl(imageUrlList)
            .addImageUrl(IMAGE_URL)
            .threshold(THRESHOLD)
            .build();
    options = options.newBuilder().build();

    assertEquals(2, options.collectionIds().size());
    assertEquals(COLLECTION_ID, options.collectionIds().get(0));
    assertEquals(2, options.features().size());
    assertEquals(AnalyzeOptions.Features.OBJECTS, options.features().get(0));
    assertEquals(2, options.imagesFile().size());
    assertEquals(fileWithMetadata, options.imagesFile().get(0));
    assertEquals(2, options.imageUrl().size());
    assertEquals(IMAGE_URL, options.imageUrl().get(0));
    assertEquals(THRESHOLD, options.threshold());
  }

  @Test
  public void testCreateCollectionOptions() {
    CreateCollectionOptions options =
        new CreateCollectionOptions.Builder().name(NAME).description(DESCRIPTION).build();
    options = options.newBuilder().build();

    assertEquals(NAME, options.name());
    assertEquals(DESCRIPTION, options.description());
  }

  @Test
  public void testDeleteCollectionOptions() {
    DeleteCollectionOptions options =
        new DeleteCollectionOptions.Builder().collectionId(COLLECTION_ID).build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
  }

  @Test
  public void testDeleteImageOptions() {
    DeleteImageOptions options =
        new DeleteImageOptions.Builder().collectionId(COLLECTION_ID).imageId(IMAGE_ID).build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(IMAGE_ID, options.imageId());
  }

  @Test
  public void testDeleteUserDataOptions() {
    DeleteUserDataOptions options =
        new DeleteUserDataOptions.Builder().customerId(CUSTOMER_ID).build();
    options = options.newBuilder().build();

    assertEquals(CUSTOMER_ID, options.customerId());
  }

  @Test
  public void testGetCollectionOptions() {
    GetCollectionOptions options =
        new GetCollectionOptions.Builder().collectionId(COLLECTION_ID).build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
  }

  @Test
  public void testGetImageDetailsOptions() {
    GetImageDetailsOptions options =
        new GetImageDetailsOptions.Builder().collectionId(COLLECTION_ID).imageId(IMAGE_ID).build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(IMAGE_ID, options.imageId());
  }

  @Test
  public void testGetJpegImageOptions() {
    GetJpegImageOptions options =
        new GetJpegImageOptions.Builder()
            .collectionId(COLLECTION_ID)
            .imageId(IMAGE_ID)
            .size(GetJpegImageOptions.Size.FULL)
            .build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(IMAGE_ID, options.imageId());
    assertEquals(GetJpegImageOptions.Size.FULL, options.size());
  }

  @Test
  public void testListCollectionsOptions() {
    ListCollectionsOptions options = new ListCollectionsOptions.Builder().build();
    options = options.newBuilder().build();

    assertNotNull(options);
  }

  @Test
  public void testListImagesOptions() {
    ListImagesOptions options = new ListImagesOptions.Builder().collectionId(COLLECTION_ID).build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
  }

  @Test
  public void testLocation() {
    Location location =
        new Location.Builder().top(TOP).left(LEFT).width(WIDTH).height(HEIGHT).build();
    location = location.newBuilder().build();

    assertEquals(TOP, location.top());
    assertEquals(LEFT, location.left());
    assertEquals(WIDTH, location.width());
    assertEquals(HEIGHT, location.height());
  }

  @Test
  public void testObjectTrainingStatus() {
    ObjectTrainingStatus trainingStatus =
        new ObjectTrainingStatus.Builder()
            .ready(true)
            .inProgress(true)
            .dataChanged(true)
            .latestFailed(true)
            .description(DESCRIPTION)
            .build();
    trainingStatus = trainingStatus.newBuilder().build();

    assertTrue(trainingStatus.ready());
    assertTrue(trainingStatus.inProgress());
    assertTrue(trainingStatus.dataChanged());
    assertTrue(trainingStatus.latestFailed());
    assertEquals(DESCRIPTION, trainingStatus.description());
  }

  @Test
  public void testTrainingStatus() {
    TrainingStatus trainingStatus =
        new TrainingStatus.Builder().objects(objectTrainingStatus).build();
    trainingStatus = trainingStatus.newBuilder().build();

    assertEquals(objectTrainingStatus, trainingStatus.objects());
  }

  @Test
  public void testTrainOptions() {
    TrainOptions options = new TrainOptions.Builder().collectionId(COLLECTION_ID).build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
  }

  @Test
  public void testUpdateCollectionOptions() {
    UpdateCollectionOptions options =
        new UpdateCollectionOptions.Builder()
            .collectionId(COLLECTION_ID)
            .name(NAME)
            .description(DESCRIPTION)
            .build();
    options = options.newBuilder().build();

    assertEquals(COLLECTION_ID, options.collectionId());
    assertEquals(NAME, options.name());
    assertEquals(DESCRIPTION, options.description());
  }

  @Test
  public void testGetTrainingUsageOptions() {
    GetTrainingUsageOptions options =
        new GetTrainingUsageOptions.Builder().startTime(START_TIME).endTime(END_TIME).build();
    options = options.newBuilder().build();

    assertEquals(START_TIME, options.startTime());
    assertEquals(END_TIME, options.endTime());
  }

  @Test
  public void testAnalyze() {
    server.enqueue(jsonResponse(analyzeResponse));

    AnalyzeOptions options =
        new AnalyzeOptions.Builder()
            .addCollectionIds(COLLECTION_ID)
            .addFeatures(AnalyzeOptions.Features.OBJECTS)
            .addImagesFile(fileWithMetadata)
            .addImageUrl(IMAGE_URL)
            .threshold(THRESHOLD)
            .build();
    AnalyzeResponse response = service.analyze(options).execute().getResult();

    assertEquals(IMAGE_TYPE, response.getImages().get(0).getSource().getType());
    assertEquals(FILENAME, response.getImages().get(0).getSource().getFilename());
    assertEquals(ARCHIVE_FILENAME, response.getImages().get(0).getSource().getArchiveFilename());
    assertEquals(SOURCE_URL, response.getImages().get(0).getSource().getSourceUrl());
    assertEquals(RESOLVED_URL, response.getImages().get(0).getSource().getResolvedUrl());
    assertEquals(HEIGHT, response.getImages().get(0).getDimensions().getHeight());
    assertEquals(WIDTH, response.getImages().get(0).getDimensions().getWidth());
    assertEquals(
        COLLECTION_ID,
        response.getImages().get(0).getObjects().getCollections().get(0).getCollectionId());
    assertEquals(
        OBJECT,
        response
            .getImages()
            .get(0)
            .getObjects()
            .getCollections()
            .get(0)
            .getObjects()
            .get(0)
            .getObject());
    assertEquals(
        TOP,
        response
            .getImages()
            .get(0)
            .getObjects()
            .getCollections()
            .get(0)
            .getObjects()
            .get(0)
            .getLocation()
            .top());
    assertEquals(
        LEFT,
        response
            .getImages()
            .get(0)
            .getObjects()
            .getCollections()
            .get(0)
            .getObjects()
            .get(0)
            .getLocation()
            .left());
    assertEquals(
        WIDTH,
        response
            .getImages()
            .get(0)
            .getObjects()
            .getCollections()
            .get(0)
            .getObjects()
            .get(0)
            .getLocation()
            .width());
    assertEquals(
        HEIGHT,
        response
            .getImages()
            .get(0)
            .getObjects()
            .getCollections()
            .get(0)
            .getObjects()
            .get(0)
            .getLocation()
            .height());
    assertEquals(
        SCORE,
        response
            .getImages()
            .get(0)
            .getObjects()
            .getCollections()
            .get(0)
            .getObjects()
            .get(0)
            .getScore());
    assertEquals(CODE, response.getImages().get(0).getErrors().get(0).getCode());
    assertEquals(MESSAGE, response.getImages().get(0).getErrors().get(0).getMessage());
    assertEquals(MORE_INFO, response.getImages().get(0).getErrors().get(0).getMoreInfo());
    assertEquals(ERROR_TYPE, response.getImages().get(0).getErrors().get(0).getTarget().getType());
    assertEquals(NAME, response.getImages().get(0).getErrors().get(0).getTarget().getName());
    assertEquals(CODE, response.getWarnings().get(0).getCode());
    assertEquals(MESSAGE, response.getWarnings().get(0).getMessage());
    assertEquals(MORE_INFO, response.getWarnings().get(0).getMoreInfo());
    assertEquals(TRACE, response.getTrace());
  }

  private void assertCollection(Collection response) {
    assertEquals(COLLECTION_ID, response.getCollectionId());
    assertEquals(NAME, response.getName());
    assertEquals(DESCRIPTION, response.getDescription());
    assertEquals(testDate, response.getCreated());
    assertEquals(testDate, response.getUpdated());
    assertEquals(IMAGE_COUNT, response.getImageCount());
    assertTrue(response.getTrainingStatus().objects().ready());
    assertTrue(response.getTrainingStatus().objects().inProgress());
    assertTrue(response.getTrainingStatus().objects().dataChanged());
    assertTrue(response.getTrainingStatus().objects().latestFailed());
    assertEquals(DESCRIPTION, response.getTrainingStatus().objects().description());
  }

  @Test
  public void testCreateCollection() {
    server.enqueue(jsonResponse(collection));

    CreateCollectionOptions options =
        new CreateCollectionOptions.Builder().name(NAME).description(DESCRIPTION).build();
    Collection response = service.createCollection(options).execute().getResult();

    assertCollection(response);
  }

  private void assertCollectionsList(CollectionsList response) {
    assertEquals(COLLECTION_ID, response.getCollections().get(0).getCollectionId());
    assertEquals(NAME, response.getCollections().get(0).getName());
    assertEquals(DESCRIPTION, response.getCollections().get(0).getDescription());
    assertEquals(testDate, response.getCollections().get(0).getCreated());
    assertEquals(testDate, response.getCollections().get(0).getUpdated());
    assertEquals(IMAGE_COUNT, response.getCollections().get(0).getImageCount());
    assertTrue(response.getCollections().get(0).getTrainingStatus().objects().ready());
    assertTrue(response.getCollections().get(0).getTrainingStatus().objects().inProgress());
    assertTrue(response.getCollections().get(0).getTrainingStatus().objects().dataChanged());
    assertTrue(response.getCollections().get(0).getTrainingStatus().objects().latestFailed());
    assertEquals(
        DESCRIPTION, response.getCollections().get(0).getTrainingStatus().objects().description());
  }

  @Test
  public void testListCollections() {
    server.enqueue(jsonResponse(collectionsList));

    ListCollectionsOptions options = new ListCollectionsOptions.Builder().build();
    CollectionsList response = service.listCollections(options).execute().getResult();

    assertCollectionsList(response);
  }

  @Test
  public void testListCollectionsNoOptions() {
    server.enqueue(jsonResponse(collectionsList));

    CollectionsList response = service.listCollections().execute().getResult();

    assertCollectionsList(response);
  }

  @Test
  public void testGetCollection() {
    server.enqueue(jsonResponse(collection));

    GetCollectionOptions options =
        new GetCollectionOptions.Builder().collectionId(COLLECTION_ID).build();
    Collection response = service.getCollection(options).execute().getResult();

    assertCollection(response);
  }

  @Test
  public void testUpdateCollection() {
    server.enqueue(jsonResponse(collection));

    UpdateCollectionOptions options =
        new UpdateCollectionOptions.Builder()
            .collectionId(COLLECTION_ID)
            .name(NAME)
            .description(DESCRIPTION)
            .build();
    Collection response = service.updateCollection(options).execute().getResult();

    assertCollection(response);
  }

  @Test
  public void testDeleteCollection() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteCollectionOptions options =
        new DeleteCollectionOptions.Builder().collectionId(COLLECTION_ID).build();
    service.deleteCollection(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
  }

  private void assertImageDetails(ImageDetails response) {
    assertEquals(IMAGE_ID, response.getImageId());
    assertEquals(testDate, response.getCreated());
    assertEquals(testDate, response.getUpdated());
    assertEquals(IMAGE_TYPE, response.getSource().getType());
    assertEquals(FILENAME, response.getSource().getFilename());
    assertEquals(ARCHIVE_FILENAME, response.getSource().getArchiveFilename());
    assertEquals(SOURCE_URL, response.getSource().getSourceUrl());
    assertEquals(RESOLVED_URL, response.getSource().getResolvedUrl());
    assertEquals(HEIGHT, response.getDimensions().getHeight());
    assertEquals(WIDTH, response.getDimensions().getWidth());
    assertEquals(CODE, response.getErrors().get(0).getCode());
    assertEquals(MESSAGE, response.getErrors().get(0).getMessage());
    assertEquals(MORE_INFO, response.getErrors().get(0).getMoreInfo());
    assertEquals(ERROR_TYPE, response.getErrors().get(0).getTarget().getType());
    assertEquals(NAME, response.getErrors().get(0).getTarget().getName());
    assertEquals(OBJECT, response.getTrainingData().getObjects().get(0).object());
    assertEquals(TOP, response.getTrainingData().getObjects().get(0).location().top());
    assertEquals(LEFT, response.getTrainingData().getObjects().get(0).location().left());
    assertEquals(WIDTH, response.getTrainingData().getObjects().get(0).location().width());
    assertEquals(HEIGHT, response.getTrainingData().getObjects().get(0).location().height());
  }

  @Test
  public void testAddImages() {
    server.enqueue(jsonResponse(imageDetailsList));

    AddImagesOptions options =
        new AddImagesOptions.Builder()
            .addImagesFile(fileWithMetadata)
            .addImageUrl(IMAGE_URL)
            .collectionId(COLLECTION_ID)
            .trainingData(TRAINING_DATA)
            .build();
    ImageDetailsList response = service.addImages(options).execute().getResult();

    assertImageDetails(response.getImages().get(0));
    assertEquals(CODE, response.getWarnings().get(0).getCode());
    assertEquals(MESSAGE, response.getWarnings().get(0).getMessage());
    assertEquals(MORE_INFO, response.getWarnings().get(0).getMoreInfo());
    assertEquals(TRACE, response.getTrace());
  }

  @Test
  public void testListImages() {
    server.enqueue(jsonResponse(imageSummaryList));

    ListImagesOptions options = new ListImagesOptions.Builder().collectionId(COLLECTION_ID).build();
    ImageSummaryList response = service.listImages(options).execute().getResult();

    assertEquals(IMAGE_ID, response.getImages().get(0).getImageId());
    assertEquals(testDate, response.getImages().get(0).getUpdated());
  }

  @Test
  public void testGetImageDetails() {
    server.enqueue(jsonResponse(imageDetails));

    GetImageDetailsOptions options =
        new GetImageDetailsOptions.Builder().collectionId(COLLECTION_ID).imageId(IMAGE_ID).build();
    ImageDetails response = service.getImageDetails(options).execute().getResult();

    assertImageDetails(response);
  }

  @Test
  public void testDeleteImage() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteImageOptions options =
        new DeleteImageOptions.Builder().collectionId(COLLECTION_ID).imageId(IMAGE_ID).build();
    service.deleteImage(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
  }

  @Test
  public void testGetJpegImage() throws IOException, InterruptedException {
    @SuppressWarnings("resource")
    Buffer buffer = new Buffer().write(Files.toByteArray(imageFile));
    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, "image/jpeg").setBody(buffer));

    GetJpegImageOptions options =
        new GetJpegImageOptions.Builder()
            .collectionId(COLLECTION_ID)
            .imageId(IMAGE_ID)
            .size(GetJpegImageOptions.Size.FULL)
            .build();
    InputStream response = service.getJpegImage(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertNotNull(response);
    response.close();
  }

  @Test
  public void testTrain() {
    server.enqueue(jsonResponse(collection));

    TrainOptions options = new TrainOptions.Builder().collectionId(COLLECTION_ID).build();
    Collection response = service.train(options).execute().getResult();

    assertCollection(response);
  }

  @Test
  public void testAddImageTrainingData() {
    server.enqueue(jsonResponse(trainingDataObjects));

    AddImageTrainingDataOptions options =
        new AddImageTrainingDataOptions.Builder()
            .collectionId(COLLECTION_ID)
            .imageId(IMAGE_ID)
            .addObjects(trainingDataObject)
            .build();
    TrainingDataObjects response = service.addImageTrainingData(options).execute().getResult();

    assertEquals(OBJECT, response.getObjects().get(0).object());
    assertEquals(TOP, response.getObjects().get(0).location().top());
    assertEquals(LEFT, response.getObjects().get(0).location().left());
    assertEquals(WIDTH, response.getObjects().get(0).location().width());
    assertEquals(HEIGHT, response.getObjects().get(0).location().height());
  }

  @Test
  public void testDeleteUserData() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteUserDataOptions options =
        new DeleteUserDataOptions.Builder().customerId(CUSTOMER_ID).build();
    service.deleteUserData(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
  }

  @Test
  public void testGetTrainingUsage() throws InterruptedException {
    server.enqueue(jsonResponse(trainingEvents));

    GetTrainingUsageOptions options = new GetTrainingUsageOptions.Builder().build();
    TrainingEvents response = service.getTrainingUsage(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(testDate, response.getStartTime());
    assertEquals(testDate, response.getEndTime());
    assertEquals(COMPLETED_EVENTS, response.getCompletedEvents());
    assertEquals(TRAINED_IMAGES, response.getTrainedImages());
    assertEquals(TYPE, response.getEvents().get(0).getType());
    assertEquals(COLLECTION_ID, response.getEvents().get(0).getCollectionId());
    assertEquals(testDate, response.getEvents().get(0).getCompletionTime());
    assertEquals(STATUS, response.getEvents().get(0).getStatus());
    assertEquals(IMAGE_COUNT, response.getEvents().get(0).getImageCount());
  }

  @Test
  public void testListObjectMetadata() throws InterruptedException {
    server.enqueue(jsonResponse(objectMetadataList));

    ListObjectMetadataOptions options =
        new ListObjectMetadataOptions.Builder().collectionId(COLLECTION_ID).build();
    ObjectMetadataList response = service.listObjectMetadata(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(objectMetadataList.getObjects(), response.getObjects());
    assertEquals(objectMetadataList.getObjectCount(), response.getObjectCount());
  }

  @Test
  public void testUpdateObjectName() throws InterruptedException {
    server.enqueue(jsonResponse(objectName));

    UpdateObjectMetadataOptions options =
        new UpdateObjectMetadataOptions.Builder()
            .collectionId(COLLECTION_ID)
            .object(NAME)
            .newObject(MESSAGE)
            .build();
    UpdateObjectMetadata response = service.updateObjectMetadata(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(objectName.getObject(), response.object());
    assertEquals(objectName.getCount(), response.count());
  }

  @Test
  public void testGetObjectMetadata() throws InterruptedException {
    server.enqueue(jsonResponse(objectName));

    GetObjectMetadataOptions options =
        new GetObjectMetadataOptions.Builder().collectionId(COLLECTION_ID).object(NAME).build();
    ObjectMetadata response = service.getObjectMetadata(options).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals("GET", request.getMethod());
    assertEquals(objectName.getObject(), response.getObject());
    assertEquals(objectName.getCount(), response.getCount());
  }

  @Test
  public void testDeleteObject() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteObjectOptions options =
        new DeleteObjectOptions.Builder().collectionId(COLLECTION_ID).object(NAME).build();

    service.deleteObject(options).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals("DELETE", request.getMethod());
  }
}
