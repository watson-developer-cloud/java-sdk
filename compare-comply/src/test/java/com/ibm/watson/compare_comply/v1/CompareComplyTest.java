/*
 * (C) Copyright IBM Corp. 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.compare_comply.v1;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
import com.ibm.watson.compare_comply.v1.model.FeedbackDeleted;
import com.ibm.watson.compare_comply.v1.model.FeedbackList;
import com.ibm.watson.compare_comply.v1.model.FeedbackReturn;
import com.ibm.watson.compare_comply.v1.model.GetBatchOptions;
import com.ibm.watson.compare_comply.v1.model.GetFeedback;
import com.ibm.watson.compare_comply.v1.model.GetFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.HTMLReturn;
import com.ibm.watson.compare_comply.v1.model.Label;
import com.ibm.watson.compare_comply.v1.model.ListBatchesOptions;
import com.ibm.watson.compare_comply.v1.model.ListFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.Location;
import com.ibm.watson.compare_comply.v1.model.OriginalLabelsIn;
import com.ibm.watson.compare_comply.v1.model.ShortDoc;
import com.ibm.watson.compare_comply.v1.model.TableReturn;
import com.ibm.watson.compare_comply.v1.model.TypeLabel;
import com.ibm.watson.compare_comply.v1.model.UpdateBatchOptions;
import com.ibm.watson.compare_comply.v1.model.UpdatedLabelsIn;
import com.ibm.watson.compare_comply.v1.utils.TestUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Unit test class for the CompareComply service. */
public class CompareComplyTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected CompareComply compareComplyService;

  public void constructClientService() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    final Authenticator authenticator = new NoAuthAuthenticator();

    compareComplyService = new CompareComply(version, serviceName, authenticator);
    String url = server.url("/").toString();
    compareComplyService.setServiceUrl(url);
  }

  /** Negative Test - construct the service with a null authenticator. */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    // set mock values for global params
    String version = "testString";

    new CompareComply(version, serviceName, null);
  }

  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(compareComplyService.getVersion(), "testString");
  }

  @Test
  public void testConvertToHtmlWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"num_pages\": \"numPages\", \"author\": \"author\", \"publication_date\": \"publicationDate\", \"title\": \"title\", \"html\": \"html\"}";
    String convertToHtmlPath = "/v1/html_conversion";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ConvertToHtmlOptions model
    ConvertToHtmlOptions convertToHtmlOptionsModel =
        new ConvertToHtmlOptions.Builder()
            .file(TestUtilities.createMockStream("This is a mock file."))
            .fileContentType("application/pdf")
            .model("contracts")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<HTMLReturn> response =
        compareComplyService.convertToHtml(convertToHtmlOptionsModel).execute();
    assertNotNull(response);
    HTMLReturn responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, convertToHtmlPath);
  }

  // Test the convertToHtml operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConvertToHtmlNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.convertToHtml(null).execute();
  }

  @Test
  public void testClassifyElementsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document\": {\"title\": \"title\", \"html\": \"html\", \"hash\": \"hash\", \"label\": \"label\"}, \"model_id\": \"modelId\", \"model_version\": \"modelVersion\", \"elements\": [{\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"attributes\": [{\"type\": \"Currency\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}], \"effective_dates\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"contract_amounts\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"interpretation\": {\"value\": \"value\", \"numeric_value\": 12, \"unit\": \"unit\"}, \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"termination_dates\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"contract_types\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"contract_terms\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"interpretation\": {\"value\": \"value\", \"numeric_value\": 12, \"unit\": \"unit\"}, \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"payment_terms\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"interpretation\": {\"value\": \"value\", \"numeric_value\": 12, \"unit\": \"unit\"}, \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"contract_currencies\": [{\"confidence_level\": \"High\", \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"provenance_ids\": [\"provenanceIds\"], \"location\": {\"begin\": 5, \"end\": 3}}], \"tables\": [{\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"section_title\": {\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}, \"title\": {\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}, \"table_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"mapKey\": \"anyValue\"}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"row_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"column_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"mapKey\": \"anyValue\"}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"body_cells\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14, \"row_header_ids\": [\"rowHeaderIds\"], \"row_header_texts\": [\"rowHeaderTexts\"], \"row_header_texts_normalized\": [\"rowHeaderTextsNormalized\"], \"column_header_ids\": [\"columnHeaderIds\"], \"column_header_texts\": [\"columnHeaderTexts\"], \"column_header_texts_normalized\": [\"columnHeaderTextsNormalized\"], \"attributes\": [{\"type\": \"Currency\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}], \"contexts\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}], \"key_value_pairs\": [{\"key\": {\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}, \"value\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}]}]}], \"document_structure\": {\"section_titles\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}, \"level\": 5, \"element_locations\": [{\"begin\": 5, \"end\": 3}]}], \"leading_sentences\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}, \"element_locations\": [{\"begin\": 5, \"end\": 3}]}], \"paragraphs\": [{\"location\": {\"begin\": 5, \"end\": 3}}]}, \"parties\": [{\"party\": \"party\", \"role\": \"role\", \"importance\": \"Primary\", \"addresses\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}], \"contacts\": [{\"name\": \"name\", \"role\": \"role\"}], \"mentions\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}]}";
    String classifyElementsPath = "/v1/element_classification";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ClassifyElementsOptions model
    ClassifyElementsOptions classifyElementsOptionsModel =
        new ClassifyElementsOptions.Builder()
            .file(TestUtilities.createMockStream("This is a mock file."))
            .fileContentType("application/pdf")
            .model("contracts")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<ClassifyReturn> response =
        compareComplyService.classifyElements(classifyElementsOptionsModel).execute();
    assertNotNull(response);
    ClassifyReturn responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, classifyElementsPath);
  }

  // Test the classifyElements operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testClassifyElementsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.classifyElements(null).execute();
  }

  @Test
  public void testExtractTablesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"document\": {\"html\": \"html\", \"title\": \"title\", \"hash\": \"hash\"}, \"model_id\": \"modelId\", \"model_version\": \"modelVersion\", \"tables\": [{\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"section_title\": {\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}, \"title\": {\"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}, \"table_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"mapKey\": \"anyValue\"}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"row_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"column_headers\": [{\"cell_id\": \"cellId\", \"location\": {\"mapKey\": \"anyValue\"}, \"text\": \"text\", \"text_normalized\": \"textNormalized\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14}], \"body_cells\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"row_index_begin\": 13, \"row_index_end\": 11, \"column_index_begin\": 16, \"column_index_end\": 14, \"row_header_ids\": [\"rowHeaderIds\"], \"row_header_texts\": [\"rowHeaderTexts\"], \"row_header_texts_normalized\": [\"rowHeaderTextsNormalized\"], \"column_header_ids\": [\"columnHeaderIds\"], \"column_header_texts\": [\"columnHeaderTexts\"], \"column_header_texts_normalized\": [\"columnHeaderTextsNormalized\"], \"attributes\": [{\"type\": \"Currency\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}], \"contexts\": [{\"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}], \"key_value_pairs\": [{\"key\": {\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}, \"value\": [{\"cell_id\": \"cellId\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\"}]}]}]}";
    String extractTablesPath = "/v1/tables";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ExtractTablesOptions model
    ExtractTablesOptions extractTablesOptionsModel =
        new ExtractTablesOptions.Builder()
            .file(TestUtilities.createMockStream("This is a mock file."))
            .fileContentType("application/pdf")
            .model("contracts")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<TableReturn> response =
        compareComplyService.extractTables(extractTablesOptionsModel).execute();
    assertNotNull(response);
    TableReturn responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, extractTablesPath);
  }

  // Test the extractTables operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testExtractTablesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.extractTables(null).execute();
  }

  @Test
  public void testCompareDocumentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"model_id\": \"modelId\", \"model_version\": \"modelVersion\", \"documents\": [{\"title\": \"title\", \"html\": \"html\", \"hash\": \"hash\", \"label\": \"label\"}], \"aligned_elements\": [{\"element_pair\": [{\"document_label\": \"documentLabel\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}, \"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}}], \"categories\": [{\"label\": \"Amendments\"}], \"attributes\": [{\"type\": \"Currency\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}], \"identical_text\": false, \"provenance_ids\": [\"provenanceIds\"], \"significant_elements\": false}], \"unaligned_elements\": [{\"document_label\": \"documentLabel\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}}], \"categories\": [{\"label\": \"Amendments\"}], \"attributes\": [{\"type\": \"Currency\", \"text\": \"text\", \"location\": {\"begin\": 5, \"end\": 3}}]}]}";
    String compareDocumentsPath = "/v1/comparison";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CompareDocumentsOptions model
    CompareDocumentsOptions compareDocumentsOptionsModel =
        new CompareDocumentsOptions.Builder()
            .file1(TestUtilities.createMockStream("This is a mock file."))
            .file2(TestUtilities.createMockStream("This is a mock file."))
            .file1ContentType("application/pdf")
            .file2ContentType("application/pdf")
            .file1Label("file_1")
            .file2Label("file_2")
            .model("contracts")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<CompareReturn> response =
        compareComplyService.compareDocuments(compareDocumentsOptionsModel).execute();
    assertNotNull(response);
    CompareReturn responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("file_1_label"), "file_1");
    assertEquals(query.get("file_2_label"), "file_2");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, compareDocumentsPath);
  }

  // Test the compareDocuments operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCompareDocumentsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.compareDocuments(null).execute();
  }

  @Test
  public void testAddFeedbackWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"feedback_id\": \"feedbackId\", \"user_id\": \"userId\", \"comment\": \"comment\", \"created\": \"2019-01-01T12:00:00.000Z\", \"feedback_data\": {\"feedback_type\": \"feedbackType\", \"document\": {\"title\": \"title\", \"hash\": \"hash\"}, \"model_id\": \"modelId\", \"model_version\": \"modelVersion\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"original_labels\": {\"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}]}, \"updated_labels\": {\"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}]}, \"pagination\": {\"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\", \"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5}}}";
    String addFeedbackPath = "/v1/feedback";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ShortDoc model
    ShortDoc shortDocModel = new ShortDoc.Builder().title("testString").hash("testString").build();

    // Construct an instance of the Location model
    Location locationModel =
        new Location.Builder().begin(Long.valueOf("26")).end(Long.valueOf("26")).build();

    // Construct an instance of the Label model
    Label labelModel = new Label.Builder().nature("testString").party("testString").build();

    // Construct an instance of the TypeLabel model
    TypeLabel typeLabelModel =
        new TypeLabel.Builder()
            .label(labelModel)
            .provenanceIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .modification("added")
            .build();

    // Construct an instance of the Category model
    Category categoryModel =
        new Category.Builder()
            .label("Amendments")
            .provenanceIds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .modification("added")
            .build();

    // Construct an instance of the OriginalLabelsIn model
    OriginalLabelsIn originalLabelsInModel =
        new OriginalLabelsIn.Builder()
            .types(new java.util.ArrayList<TypeLabel>(java.util.Arrays.asList(typeLabelModel)))
            .categories(new java.util.ArrayList<Category>(java.util.Arrays.asList(categoryModel)))
            .build();

    // Construct an instance of the UpdatedLabelsIn model
    UpdatedLabelsIn updatedLabelsInModel =
        new UpdatedLabelsIn.Builder()
            .types(new java.util.ArrayList<TypeLabel>(java.util.Arrays.asList(typeLabelModel)))
            .categories(new java.util.ArrayList<Category>(java.util.Arrays.asList(categoryModel)))
            .build();

    // Construct an instance of the FeedbackDataInput model
    FeedbackDataInput feedbackDataInputModel =
        new FeedbackDataInput.Builder()
            .feedbackType("testString")
            .document(shortDocModel)
            .modelId("testString")
            .modelVersion("testString")
            .location(locationModel)
            .text("testString")
            .originalLabels(originalLabelsInModel)
            .updatedLabels(updatedLabelsInModel)
            .build();

    // Construct an instance of the AddFeedbackOptions model
    AddFeedbackOptions addFeedbackOptionsModel =
        new AddFeedbackOptions.Builder()
            .feedbackData(feedbackDataInputModel)
            .userId("testString")
            .comment("testString")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<FeedbackReturn> response =
        compareComplyService.addFeedback(addFeedbackOptionsModel).execute();
    assertNotNull(response);
    FeedbackReturn responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addFeedbackPath);
  }

  // Test the addFeedback operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddFeedbackNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.addFeedback(null).execute();
  }

  @Test
  public void testListFeedbackWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"feedback\": [{\"feedback_id\": \"feedbackId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"comment\": \"comment\", \"feedback_data\": {\"feedback_type\": \"feedbackType\", \"document\": {\"title\": \"title\", \"hash\": \"hash\"}, \"model_id\": \"modelId\", \"model_version\": \"modelVersion\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"original_labels\": {\"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}]}, \"updated_labels\": {\"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}]}, \"pagination\": {\"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\", \"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5}}}]}";
    String listFeedbackPath = "/v1/feedback";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListFeedbackOptions model
    ListFeedbackOptions listFeedbackOptionsModel =
        new ListFeedbackOptions.Builder()
            .feedbackType("testString")
            .documentTitle("testString")
            .modelId("testString")
            .modelVersion("testString")
            .categoryRemoved("testString")
            .categoryAdded("testString")
            .categoryNotChanged("testString")
            .typeRemoved("testString")
            .typeAdded("testString")
            .typeNotChanged("testString")
            .pageLimit(Long.valueOf("100"))
            .cursor("testString")
            .sort("testString")
            .includeTotal(true)
            .build();

    // Invoke operation with valid options model (positive test)
    Response<FeedbackList> response =
        compareComplyService.listFeedback(listFeedbackOptionsModel).execute();
    assertNotNull(response);
    FeedbackList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("feedback_type"), "testString");
    assertEquals(query.get("document_title"), "testString");
    assertEquals(query.get("model_id"), "testString");
    assertEquals(query.get("model_version"), "testString");
    assertEquals(query.get("category_removed"), "testString");
    assertEquals(query.get("category_added"), "testString");
    assertEquals(query.get("category_not_changed"), "testString");
    assertEquals(query.get("type_removed"), "testString");
    assertEquals(query.get("type_added"), "testString");
    assertEquals(query.get("type_not_changed"), "testString");
    assertEquals(Long.valueOf(query.get("page_limit")), Long.valueOf("100"));
    assertEquals(query.get("cursor"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(Boolean.valueOf(query.get("include_total")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listFeedbackPath);
  }

  @Test
  public void testGetFeedbackWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"feedback_id\": \"feedbackId\", \"created\": \"2019-01-01T12:00:00.000Z\", \"comment\": \"comment\", \"feedback_data\": {\"feedback_type\": \"feedbackType\", \"document\": {\"title\": \"title\", \"hash\": \"hash\"}, \"model_id\": \"modelId\", \"model_version\": \"modelVersion\", \"location\": {\"begin\": 5, \"end\": 3}, \"text\": \"text\", \"original_labels\": {\"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}]}, \"updated_labels\": {\"types\": [{\"label\": {\"nature\": \"nature\", \"party\": \"party\"}, \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}], \"categories\": [{\"label\": \"Amendments\", \"provenance_ids\": [\"provenanceIds\"], \"modification\": \"added\"}]}, \"pagination\": {\"refresh_cursor\": \"refreshCursor\", \"next_cursor\": \"nextCursor\", \"refresh_url\": \"refreshUrl\", \"next_url\": \"nextUrl\", \"total\": 5}}}";
    String getFeedbackPath = "/v1/feedback/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetFeedbackOptions model
    GetFeedbackOptions getFeedbackOptionsModel =
        new GetFeedbackOptions.Builder().feedbackId("testString").model("contracts").build();

    // Invoke operation with valid options model (positive test)
    Response<GetFeedback> response =
        compareComplyService.getFeedback(getFeedbackOptionsModel).execute();
    assertNotNull(response);
    GetFeedback responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getFeedbackPath);
  }

  // Test the getFeedback operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetFeedbackNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.getFeedback(null).execute();
  }

  @Test
  public void testDeleteFeedbackWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"status\": 6, \"message\": \"message\"}";
    String deleteFeedbackPath = "/v1/feedback/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteFeedbackOptions model
    DeleteFeedbackOptions deleteFeedbackOptionsModel =
        new DeleteFeedbackOptions.Builder().feedbackId("testString").model("contracts").build();

    // Invoke operation with valid options model (positive test)
    Response<FeedbackDeleted> response =
        compareComplyService.deleteFeedback(deleteFeedbackOptionsModel).execute();
    assertNotNull(response);
    FeedbackDeleted responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteFeedbackPath);
  }

  // Test the deleteFeedback operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteFeedbackNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.deleteFeedback(null).execute();
  }

  @Test
  public void testCreateBatchWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"function\": \"element_classification\", \"input_bucket_location\": \"inputBucketLocation\", \"input_bucket_name\": \"inputBucketName\", \"output_bucket_location\": \"outputBucketLocation\", \"output_bucket_name\": \"outputBucketName\", \"batch_id\": \"batchId\", \"document_counts\": {\"total\": 5, \"pending\": 7, \"successful\": 10, \"failed\": 6}, \"status\": \"status\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createBatchPath = "/v1/batches";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateBatchOptions model
    CreateBatchOptions createBatchOptionsModel =
        new CreateBatchOptions.Builder()
            .function("html_conversion")
            .inputCredentialsFile(TestUtilities.createMockStream("This is a mock file."))
            .inputBucketLocation("testString")
            .inputBucketName("testString")
            .outputCredentialsFile(TestUtilities.createMockStream("This is a mock file."))
            .outputBucketLocation("testString")
            .outputBucketName("testString")
            .model("contracts")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<BatchStatus> response =
        compareComplyService.createBatch(createBatchOptionsModel).execute();
    assertNotNull(response);
    BatchStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("function"), "html_conversion");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createBatchPath);
  }

  // Test the createBatch operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateBatchNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.createBatch(null).execute();
  }

  @Test
  public void testListBatchesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"batches\": [{\"function\": \"element_classification\", \"input_bucket_location\": \"inputBucketLocation\", \"input_bucket_name\": \"inputBucketName\", \"output_bucket_location\": \"outputBucketLocation\", \"output_bucket_name\": \"outputBucketName\", \"batch_id\": \"batchId\", \"document_counts\": {\"total\": 5, \"pending\": 7, \"successful\": 10, \"failed\": 6}, \"status\": \"status\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listBatchesPath = "/v1/batches";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListBatchesOptions model
    ListBatchesOptions listBatchesOptionsModel = new ListBatchesOptions();

    // Invoke operation with valid options model (positive test)
    Response<Batches> response =
        compareComplyService.listBatches(listBatchesOptionsModel).execute();
    assertNotNull(response);
    Batches responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listBatchesPath);
  }

  @Test
  public void testGetBatchWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"function\": \"element_classification\", \"input_bucket_location\": \"inputBucketLocation\", \"input_bucket_name\": \"inputBucketName\", \"output_bucket_location\": \"outputBucketLocation\", \"output_bucket_name\": \"outputBucketName\", \"batch_id\": \"batchId\", \"document_counts\": {\"total\": 5, \"pending\": 7, \"successful\": 10, \"failed\": 6}, \"status\": \"status\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getBatchPath = "/v1/batches/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetBatchOptions model
    GetBatchOptions getBatchOptionsModel =
        new GetBatchOptions.Builder().batchId("testString").build();

    // Invoke operation with valid options model (positive test)
    Response<BatchStatus> response = compareComplyService.getBatch(getBatchOptionsModel).execute();
    assertNotNull(response);
    BatchStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getBatchPath);
  }

  // Test the getBatch operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetBatchNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.getBatch(null).execute();
  }

  @Test
  public void testUpdateBatchWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody =
        "{\"function\": \"element_classification\", \"input_bucket_location\": \"inputBucketLocation\", \"input_bucket_name\": \"inputBucketName\", \"output_bucket_location\": \"outputBucketLocation\", \"output_bucket_name\": \"outputBucketName\", \"batch_id\": \"batchId\", \"document_counts\": {\"total\": 5, \"pending\": 7, \"successful\": 10, \"failed\": 6}, \"status\": \"status\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateBatchPath = "/v1/batches/testString";

    server.enqueue(
        new MockResponse()
            .setHeader("Content-type", "application/json")
            .setResponseCode(200)
            .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateBatchOptions model
    UpdateBatchOptions updateBatchOptionsModel =
        new UpdateBatchOptions.Builder()
            .batchId("testString")
            .action("rescan")
            .model("contracts")
            .build();

    // Invoke operation with valid options model (positive test)
    Response<BatchStatus> response =
        compareComplyService.updateBatch(updateBatchOptionsModel).execute();
    assertNotNull(response);
    BatchStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("action"), "rescan");
    assertEquals(query.get("model"), "contracts");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateBatchPath);
  }

  // Test the updateBatch operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateBatchNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    compareComplyService.updateBatch(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
      server = new MockWebServer();
      // register handler
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    compareComplyService = null;
  }
}
