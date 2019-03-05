package com.ibm.watson.developer_cloud.compare_comply.v1;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.test.util.RetryRunner;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.AddFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.BatchStatus;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.Batches;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ClassifyElementsOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ClassifyReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.CompareDocumentsOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.CompareReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ConvertToHtmlOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.CreateBatchOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.DeleteFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ExtractTablesOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.FeedbackDataInput;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.FeedbackList;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.FeedbackReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.GetBatchOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.GetFeedback;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.GetFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.HTMLReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.Location;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.OriginalLabelsIn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ShortDoc;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.TableReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.UpdateBatchOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.UpdatedLabelsIn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for Compare and Comply.
 */
@RunWith(RetryRunner.class)
public class CompareComplyServiceIT extends CompareComplyServiceTest {
  private static final String RESOURCE = "src/test/resources/compare_comply/";
  private static final File CONTRACT_A = new File(RESOURCE + "contract-a.pdf");
  private static final File CONTRACT_B = new File(RESOURCE + "contract-b.pdf");
  private static final File TABLE_FILE = new File(RESOURCE + "test-table.pdf");
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
    ConvertToHtmlOptions convertToHtmlOptions = new ConvertToHtmlOptions.Builder()
        .file(CONTRACT_A)
        .fileContentType(HttpMediaType.APPLICATION_PDF)
        .build();
    HTMLReturn response = service.convertToHtml(convertToHtmlOptions).execute();

    System.out.println(response);
  }

  @Test
  public void testClassifyElements() throws FileNotFoundException {
    ClassifyElementsOptions classifyElementsOptions = new ClassifyElementsOptions.Builder()
        .file(CONTRACT_A)
        .build();
    ClassifyReturn response = service.classifyElements(classifyElementsOptions).execute();

    System.out.println(response);
  }

  @Test
  public void testExtractTables() throws FileNotFoundException {
    ExtractTablesOptions extractTablesOptions = new ExtractTablesOptions.Builder()
        .file(TABLE_FILE)
        .build();
    TableReturn response = service.extractTables(extractTablesOptions).execute();

    System.out.println(response);
  }

  @Test
  public void testCompareDocuments() throws FileNotFoundException {
    CompareDocumentsOptions compareDocumentsOptions = new CompareDocumentsOptions.Builder()
        .file1(CONTRACT_A)
        .file1ContentType(HttpMediaType.APPLICATION_PDF)
        .file2(CONTRACT_B)
        .file2ContentType(HttpMediaType.APPLICATION_PDF)
        .build();
    CompareReturn response = service.compareDocuments(compareDocumentsOptions).execute();

    System.out.println(response);
  }

  @Test
  public void testFeedbackOperations() {
    String userId = "lp_java";
    String comment = "could be better";
    String text = "This is some text from a contract about something.";
    ShortDoc shortDoc = new ShortDoc();
    Location location = new Location();
    location.setBegin(0L);
    location.setEnd(1L);
    OriginalLabelsIn originalLabelsIn = new OriginalLabelsIn();
    UpdatedLabelsIn updatedLabelsIn = new UpdatedLabelsIn();
    FeedbackDataInput feedbackDataInput = new FeedbackDataInput();
    feedbackDataInput.setDocument(shortDoc);
    feedbackDataInput.setLocation(location);
    feedbackDataInput.setText(text);
    feedbackDataInput.setOriginalLabels(originalLabelsIn);
    feedbackDataInput.setUpdatedLabels(updatedLabelsIn);
    feedbackDataInput.setFeedbackType("element_classification");

    AddFeedbackOptions addFeedbackOptions = new AddFeedbackOptions.Builder()
        .userId(userId)
        .comment(comment)
        .feedbackData(feedbackDataInput)
        .build();
    FeedbackReturn feedbackReturn = service.addFeedback(addFeedbackOptions).execute();
    String feedbackId = feedbackReturn.getFeedbackId();

    GetFeedbackOptions getFeedbackOptions = new GetFeedbackOptions.Builder()
        .feedbackId(feedbackId)
        .build();
    GetFeedback getFeedback = service
        .getFeedback(getFeedbackOptions)
        .addHeader("x-watson-metadata", "customer_id=sdk-test-customer-id")
        .execute();
    assertEquals(comment, getFeedback.getComment());

    DeleteFeedbackOptions deleteFeedbackOptions = new DeleteFeedbackOptions.Builder()
        .feedbackId(feedbackId)
        .build();
    service.deleteFeedback(deleteFeedbackOptions).execute();

    FeedbackList feedbackList = service.listFeedback().execute();
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
  public void testBatchOperations() throws FileNotFoundException {
    String bucketLocation = "us-south";
    String inputBucketName = "compare-comply-integration-test-bucket-input";
    String outputBucketName = "compare-comply-integration-test-bucket-output";

    CreateBatchOptions createBatchOptions = new CreateBatchOptions.Builder()
        .function(CreateBatchOptions.Function.ELEMENT_CLASSIFICATION)
        .inputBucketLocation(bucketLocation)
        .inputBucketName(inputBucketName)
        .inputCredentialsFile(INPUT_CREDENTIALS_FILE)
        .outputBucketLocation(bucketLocation)
        .outputBucketName(outputBucketName)
        .outputCredentialsFile(OUTPUT_CREDENTIALS_FILE)
        .build();
    BatchStatus createBatchResponse = service.createBatch(createBatchOptions).execute();
    String batchId = createBatchResponse.getBatchId();

    GetBatchOptions getBatchOptions = new GetBatchOptions.Builder()
        .batchId(batchId)
        .build();
    BatchStatus getBatchResponse = service.getBatch(getBatchOptions).execute();
    assertNotNull(getBatchResponse);

    UpdateBatchOptions updateBatchOptions = new UpdateBatchOptions.Builder()
        .batchId(batchId)
        .action(UpdateBatchOptions.Action.RESCAN)
        .build();
    BatchStatus updateBatchResponse = service.updateBatch(updateBatchOptions).execute();
    assertTrue(updateBatchResponse.getCreated().before(updateBatchResponse.getUpdated()));

    Batches listBatchesResponse = service.listBatches().execute();
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
