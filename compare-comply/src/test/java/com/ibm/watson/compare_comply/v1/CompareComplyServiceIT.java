package com.ibm.watson.compare_comply.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.compare_comply.v1.model.AddFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.BatchStatus;
import com.ibm.watson.compare_comply.v1.model.Batches;
import com.ibm.watson.compare_comply.v1.model.Category;
import com.ibm.watson.compare_comply.v1.model.ClassifyElementsOptions;
import com.ibm.watson.compare_comply.v1.model.ClassifyReturn;
import com.ibm.watson.compare_comply.v1.model.CompareDocumentsOptions;
import com.ibm.watson.compare_comply.v1.model.CompareReturn;
import com.ibm.watson.compare_comply.v1.model.ConvertToHtmlOptions;
import com.ibm.watson.compare_comply.v1.model.CreateBatchOptions;
import com.ibm.watson.compare_comply.v1.model.DeleteFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.ExtractTablesOptions;
import com.ibm.watson.compare_comply.v1.model.FeedbackDataInput;
import com.ibm.watson.compare_comply.v1.model.FeedbackList;
import com.ibm.watson.compare_comply.v1.model.FeedbackReturn;
import com.ibm.watson.compare_comply.v1.model.GetBatchOptions;
import com.ibm.watson.compare_comply.v1.model.GetFeedback;
import com.ibm.watson.compare_comply.v1.model.GetFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.HTMLReturn;
import com.ibm.watson.compare_comply.v1.model.Label;
import com.ibm.watson.compare_comply.v1.model.Location;
import com.ibm.watson.compare_comply.v1.model.OriginalLabelsIn;
import com.ibm.watson.compare_comply.v1.model.ShortDoc;
import com.ibm.watson.compare_comply.v1.model.TableReturn;
import com.ibm.watson.compare_comply.v1.model.TypeLabel;
import com.ibm.watson.compare_comply.v1.model.UpdateBatchOptions;
import com.ibm.watson.compare_comply.v1.model.UpdatedLabelsIn;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Integration tests for Compare and Comply. */
@RunWith(RetryRunner.class)
public class CompareComplyServiceIT extends CompareComplyServiceTest {
  private static final String RESOURCE = "src/test/resources/compare_comply/";
  private static final File CONTRACT_A = new File(RESOURCE + "contract-a.pdf");
  private static final File CONTRACT_B = new File(RESOURCE + "contract-b.pdf");
  private static final File TABLE_FILE = new File(RESOURCE + "test-table.png");
  private static final File INPUT_CREDENTIALS_FILE =
      new File(RESOURCE + "cloud-object-storage-credentials-input.json");
  private static final File OUTPUT_CREDENTIALS_FILE =
      new File(RESOURCE + "cloud-object-storage-credentials-output.json");

  private CompareComply service;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.service = getService();
  }

  @Test
  public void testConvertToHtml() throws FileNotFoundException {
    ConvertToHtmlOptions convertToHtmlOptions =
        new ConvertToHtmlOptions.Builder()
            .file(CONTRACT_A)
            .fileContentType(HttpMediaType.APPLICATION_PDF)
            .build();
    HTMLReturn response = service.convertToHtml(convertToHtmlOptions).execute().getResult();

    System.out.println(response);
  }

  @Test
  public void testClassifyElements() throws FileNotFoundException {
    ClassifyElementsOptions classifyElementsOptions =
        new ClassifyElementsOptions.Builder()
            .file(CONTRACT_A)
            .fileContentType(HttpMediaType.APPLICATION_PDF)
            .build();
    ClassifyReturn response =
        service.classifyElements(classifyElementsOptions).execute().getResult();

    System.out.println(response);
  }

  @Test
  public void testExtractTables() throws FileNotFoundException {
    ExtractTablesOptions extractTablesOptions =
        new ExtractTablesOptions.Builder().file(TABLE_FILE).fileContentType("image/png").build();
    TableReturn response = service.extractTables(extractTablesOptions).execute().getResult();

    System.out.println(response);
  }

  @Test
  public void testCompareDocuments() throws FileNotFoundException {
    CompareDocumentsOptions compareDocumentsOptions =
        new CompareDocumentsOptions.Builder()
            .file1(CONTRACT_A)
            .file1ContentType(HttpMediaType.APPLICATION_PDF)
            .file2(CONTRACT_B)
            .file2ContentType(HttpMediaType.APPLICATION_PDF)
            .build();
    CompareReturn response =
        service.compareDocuments(compareDocumentsOptions).execute().getResult();

    System.out.println(response);
  }

  @Test
  public void testFeedbackOperations() {
    String userId = "lp_java";
    String comment = "could be better";
    String text =
        "1. IBM will provide a Senior Managing Consultant / expert resource, for up to 80 hours, to assist "
            + "Florida Power & Light (FPL) with the creation of an IT infrastructure unit cost model for existing "
            + "infrastructure.";
    ShortDoc shortDoc = new ShortDoc.Builder().title("doc title").hash("").build();
    Location location = new Location.Builder().begin(241).end(237).build();
    OriginalLabelsIn.Builder originalLabelsInBuilder = new OriginalLabelsIn.Builder();
    Label label1 = new Label.Builder().nature("Obligation").party("IBM").build();
    List<String> ids1 =
        Arrays.asList(
            "85f5981a-ba91-44f5-9efa-0bd22e64b7bc", "ce0480a1-5ef1-4c3e-9861-3743b5610795");
    TypeLabel typeLabel1 = new TypeLabel.Builder().label(label1).provenanceIds(ids1).build();
    Label label2 = new Label.Builder().nature("End User").party("Exclusion").build();
    List<String> ids2 =
        Arrays.asList(
            "85f5981a-ba91-44f5-9efa-0bd22e64b7bc", "ce0480a1-5ef1-4c3e-9861-3743b5610795");
    TypeLabel typeLabel2 = new TypeLabel.Builder().label(label2).provenanceIds(ids2).build();
    List<TypeLabel> types = Arrays.asList(typeLabel1, typeLabel2);
    originalLabelsInBuilder.types(types);
    Category category1 =
        new Category.Builder()
            .label(Category.Label.RESPONSIBILITIES)
            .provenanceIds(new ArrayList<String>())
            .build();
    Category category2 =
        new Category.Builder()
            .label(Category.Label.AMENDMENTS)
            .provenanceIds(new ArrayList<String>())
            .build();
    originalLabelsInBuilder.categories(Arrays.asList(category1, category2));
    UpdatedLabelsIn.Builder updatedLabelsInBuilder = new UpdatedLabelsIn.Builder();
    Label label3 = new Label.Builder().nature("Disclaimer").party("buyer").build();
    TypeLabel typeLabel3 = new TypeLabel.Builder().label(label3).build();
    updatedLabelsInBuilder.types(Arrays.asList(typeLabel1, typeLabel3));
    updatedLabelsInBuilder.categories(Arrays.asList(category1, category2));
    FeedbackDataInput feedbackDataInput =
        new FeedbackDataInput.Builder()
            .document(shortDoc)
            .location(location)
            .text(text)
            .originalLabels(originalLabelsInBuilder.build())
            .updatedLabels(updatedLabelsInBuilder.build())
            .feedbackType("element_classification")
            .modelId("contracts")
            .modelVersion("11.00")
            .build();

    AddFeedbackOptions addFeedbackOptions =
        new AddFeedbackOptions.Builder()
            .userId(userId)
            .comment(comment)
            .feedbackData(feedbackDataInput)
            .build();
    FeedbackReturn feedbackReturn = service.addFeedback(addFeedbackOptions).execute().getResult();
    String feedbackId = feedbackReturn.getFeedbackId();

    GetFeedbackOptions getFeedbackOptions =
        new GetFeedbackOptions.Builder().feedbackId(feedbackId).build();
    GetFeedback getFeedback =
        service
            .getFeedback(getFeedbackOptions)
            .addHeader("x-watson-metadata", "customer_id=sdk-test-customer-id")
            .execute()
            .getResult();
    assertEquals(text, getFeedback.getFeedbackData().getText());

    DeleteFeedbackOptions deleteFeedbackOptions =
        new DeleteFeedbackOptions.Builder().feedbackId(feedbackId).build();
    service.deleteFeedback(deleteFeedbackOptions).execute();

    FeedbackList feedbackList = service.listFeedback().execute().getResult();
    List<GetFeedback> allFeedback = feedbackList.getFeedback();
    boolean successfullyDeleted = true;
    for (GetFeedback feedback : allFeedback) {
      if (feedback.getFeedbackId().equals(feedbackId)) {
        successfullyDeleted = false;
        break;
      }
    }
    assertTrue(successfullyDeleted);
  }

  @Test
  @Ignore
  public void testBatchOperations() throws FileNotFoundException {
    String bucketLocation = "us-south";
    String inputBucketName = "compare-comply-integration-test-bucket-input";
    String outputBucketName = "compare-comply-integration-test-bucket-output";

    CreateBatchOptions createBatchOptions =
        new CreateBatchOptions.Builder()
            .function(CreateBatchOptions.Function.ELEMENT_CLASSIFICATION)
            .inputBucketLocation(bucketLocation)
            .inputBucketName(inputBucketName)
            .inputCredentialsFile(INPUT_CREDENTIALS_FILE)
            .outputBucketLocation(bucketLocation)
            .outputBucketName(outputBucketName)
            .outputCredentialsFile(OUTPUT_CREDENTIALS_FILE)
            .build();
    BatchStatus createBatchResponse = service.createBatch(createBatchOptions).execute().getResult();
    String batchId = createBatchResponse.getBatchId();

    GetBatchOptions getBatchOptions = new GetBatchOptions.Builder().batchId(batchId).build();
    BatchStatus getBatchResponse = service.getBatch(getBatchOptions).execute().getResult();
    assertNotNull(getBatchResponse);

    UpdateBatchOptions updateBatchOptions =
        new UpdateBatchOptions.Builder()
            .batchId(batchId)
            .action(UpdateBatchOptions.Action.RESCAN)
            .build();
    BatchStatus updateBatchResponse = service.updateBatch(updateBatchOptions).execute().getResult();
    assertTrue(updateBatchResponse.getCreated().before(updateBatchResponse.getUpdated()));

    Batches listBatchesResponse = service.listBatches().execute().getResult();
    List<BatchStatus> batches = listBatchesResponse.getBatches();
    boolean batchFound = false;
    for (BatchStatus batch : batches) {
      if (batch.getBatchId().equals(batchId)) {
        batchFound = true;
        break;
      }
    }
    assertTrue(batchFound);
  }
}
