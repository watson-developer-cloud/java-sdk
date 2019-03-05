/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.test.WatsonServiceUnitTest;
import com.ibm.watson.compare_comply.v1.model.AddFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.ClassifyElementsOptions;
import com.ibm.watson.compare_comply.v1.model.ClassifyReturn;
import com.ibm.watson.compare_comply.v1.model.CompareReturn;
import com.ibm.watson.compare_comply.v1.model.ConvertToHtmlOptions;
import com.ibm.watson.compare_comply.v1.model.DeleteFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.FeedbackList;
import com.ibm.watson.compare_comply.v1.model.GetBatchOptions;
import com.ibm.watson.compare_comply.v1.model.GetFeedback;
import com.ibm.watson.compare_comply.v1.model.HTMLReturn;
import com.ibm.watson.compare_comply.v1.model.ListBatchesOptions;
import com.ibm.watson.compare_comply.v1.model.ListFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.OriginalLabelsIn;
import com.ibm.watson.compare_comply.v1.model.ShortDoc;
import com.ibm.watson.compare_comply.v1.model.UpdateBatchOptions;
import com.ibm.watson.compare_comply.v1.model.UpdatedLabelsIn;
import com.ibm.watson.compare_comply.v1.model.BatchStatus;
import com.ibm.watson.compare_comply.v1.model.Batches;
import com.ibm.watson.compare_comply.v1.model.Category;
import com.ibm.watson.compare_comply.v1.model.CompareDocumentsOptions;
import com.ibm.watson.compare_comply.v1.model.ContractAmts;
import com.ibm.watson.compare_comply.v1.model.CreateBatchOptions;
import com.ibm.watson.compare_comply.v1.model.EffectiveDates;
import com.ibm.watson.compare_comply.v1.model.ExtractTablesOptions;
import com.ibm.watson.compare_comply.v1.model.FeedbackDataInput;
import com.ibm.watson.compare_comply.v1.model.FeedbackReturn;
import com.ibm.watson.compare_comply.v1.model.GetFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.Label;
import com.ibm.watson.compare_comply.v1.model.Location;
import com.ibm.watson.compare_comply.v1.model.OriginalLabelsOut;
import com.ibm.watson.compare_comply.v1.model.Parties;
import com.ibm.watson.compare_comply.v1.model.TableReturn;
import com.ibm.watson.compare_comply.v1.model.TerminationDates;
import com.ibm.watson.compare_comply.v1.model.TypeLabel;
import com.ibm.watson.compare_comply.v1.model.UpdatedLabelsOut;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompareComplyTest extends WatsonServiceUnitTest {
  private static final String VERSION = "2018-10-15";
  private static final String RESOURCE = "src/test/resources/compare_comply/";

  private static final String COMMENT = "comment";
  private static final String USER_ID = "user_id";
  private static final String PROVENANCE_ID = "provenance_id";
  private static final File SAMPLE_PDF = new File(RESOURCE + "test-pdf.pdf");
  private static final String FILENAME = "filename";
  private static final String CONTENT_TYPE_PDF = "application/pdf";
  private static final String LABEL = "label";
  private static final String BUCKET_LOCATION = "bucket_location";
  private static final String BUCKET_NAME = "bucket_name";
  private static final File CREDENTIALS_FILE = new File(RESOURCE + "credentials.json");
  private static final String FEEDBACK_ID = "feedback_id";
  private static final String FEEDBACK_TYPE = "feedback_type";
  private static final String MODEL_ID = "model_id";
  private static final String MODEL_VERSION = "model_version";
  private static final String TEXT = "text";
  private static final String BATCH_ID = "batch_id";
  private static final String NATURE = "nature";
  private static final String PARTY = "party";
  private static final Date DATE = new Date();
  private static final String CATEGORY_ADDED = "category_added";
  private static final String CATEGORY_REMOVED = "category_removed";
  private static final String CATEGORY_NOT_CHANGED = "category_not_changed";
  private static final String DOCUMENT_TITLE = "document_title";
  private static final String SORT = "sort";
  private static final String TYPE_ADDED = "type_added";
  private static final String TYPE_REMOVED = "type_removed";
  private static final String TYPE_NOT_CHANGED = "type_not_changed";
  private static final Long BEGIN = 0L;
  private static final Long END = 1L;
  private static final Double BEGIN_DOUBLE = 0.0;
  private static final Double END_DOUBLE = 1.0;
  private static final String HASH = "hash";
  private static final String TITLE = "title";
  private static final String NUM_PAGES = "20";
  private static final String AUTHOR = "author";
  private static final String PUBLICATION_DATE = "06-12-1995";
  private static final String HTML = "html";
  private static final String DOCUMENT_LABEL = "document_label";
  private static final String TYPE = "type";
  private static final String REFRESH_CURSOR = "refresh_cursor";
  private static final String NEXT_CURSOR = "next_cursor";
  private static final String REFRESH_URL = "refresh_url";
  private static final String NEXT_URL = "next_url";
  private static final Long TOTAL = 1000L;
  private static final Long PENDING = 300L;
  private static final Long SUCCESSFUL = 400L;
  private static final Long FAILED = 500L;
  private static final String STATUS = "status";
  private static final String CELL_ID = "cell_id";
  private static final Long ROW_INDEX_BEGIN = 2000L;
  private static final Long ROW_INDEX_END = 3000L;
  private static final Long COLUMN_INDEX_BEGIN = 4000L;
  private static final Long COLUMN_INDEX_END = 5000L;
  private static final String ID = "id";
  private static final String TEXT_NORMALIZED = "text_normalized";
  private static final Long LEVEL = 12L;
  private static final String ROLE = "role";
  private static final String NAME = "name";
  private static final Long PAGE_LIMIT = 7L;
  private static final String CURSOR = "cursor";

  private static final String CONVERT_TO_HTML_PATH = String.format(
      "/v1/html_conversion?version=%s",
      VERSION
  );
  private static final String CLASSIFY_ELEMENTS_PATH = String.format(
      "/v1/element_classification?version=%s",
      VERSION
  );
  private static final String EXTRACT_TABLES_PATH = String.format(
      "/v1/tables?version=%s",
      VERSION
  );
  private static final String COMPARE_DOCUMENTS_PATH = String.format(
      "/v1/comparison?version=%s",
      VERSION
  );
  private static final String FEEDBACK_PATH = String.format(
      "/v1/feedback?version=%s",
      VERSION
  );
  private static final String SPECIFIC_FEEDBACK_PATH = String.format(
      "/v1/feedback/%s?version=%s",
      FEEDBACK_ID,
      VERSION
  );
  private static final String CREATE_BATCH_PATH = String.format(
      "/v1/batches?version=%s&function=%s",
      VERSION,
      CreateBatchOptions.Function.ELEMENT_CLASSIFICATION
  );
  private static final String GET_BATCH_PATH = String.format(
      "/v1/batches/%s?version=%s",
      BATCH_ID,
      VERSION
  );
  private static final String LIST_BATCHES_PATH = String.format(
      "/v1/batches?version=%s",
      VERSION
  );
  private static final String UPDATE_BATCH_PATH = String.format(
      "/v1/batches/%s?version=%s&action=%s",
      BATCH_ID,
      VERSION,
      UpdateBatchOptions.Action.CANCEL
  );

  private CompareComply service;
  private Date testDateValue;
  private DateFormat dateFormat;
  private HTMLReturn convertToHtmlResponse;
  private ClassifyReturn classifyElementsResponse;
  private TableReturn extractTablesResponse;
  private CompareReturn compareDocumentsResponse;
  private FeedbackReturn addFeedbackResponse;
  private GetFeedback getFeedbackResponse;
  private FeedbackList listFeedbackResponse;
  private BatchStatus batchStatusResponse;
  private Batches batchesResponse;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    String dateString = "1995-06-12T01:11:11.111+0000";
    dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
    testDateValue = dateFormat.parse(dateString);

    convertToHtmlResponse = loadFixture(RESOURCE + "html-return.json", HTMLReturn.class);
    classifyElementsResponse = loadFixture(RESOURCE + "classify-return.json", ClassifyReturn.class);
    extractTablesResponse = loadFixture(RESOURCE + "table-return.json", TableReturn.class);
    compareDocumentsResponse = loadFixture(RESOURCE + "compare-return.json", CompareReturn.class);
    addFeedbackResponse = loadFixture(RESOURCE + "feedback-return.json", FeedbackReturn.class);
    getFeedbackResponse = loadFixture(RESOURCE + "get-feedback.json", GetFeedback.class);
    listFeedbackResponse = loadFixture(RESOURCE + "feedback-list.json", FeedbackList.class);
    batchStatusResponse = loadFixture(RESOURCE + "batch-status.json", BatchStatus.class);
    batchesResponse = loadFixture(RESOURCE + "batches.json", Batches.class);

    IamOptions iamOptions = new IamOptions.Builder()
        .apiKey("12345")
        .build();
    service = new CompareComply(VERSION, iamOptions);
    service.setEndPoint(getMockWebServerUrl());
  }

  @Test
  public void testAddFeedbackOptions() {
    FeedbackDataInput feedbackDataInput = new FeedbackDataInput();

    AddFeedbackOptions addFeedbackOptions = new AddFeedbackOptions.Builder()
        .comment(COMMENT)
        .feedbackData(feedbackDataInput)
        .userId(USER_ID)
        .build();
    addFeedbackOptions = addFeedbackOptions.newBuilder().build();

    assertEquals(COMMENT, addFeedbackOptions.comment());
    assertEquals(feedbackDataInput, addFeedbackOptions.feedbackData());
    assertEquals(USER_ID, addFeedbackOptions.userId());
  }

  @Test
  public void testCategory() {
    Category category = new Category();
    category.setLabel(Category.Label.AMENDMENTS);
    category.setProvenanceIds(Collections.singletonList(PROVENANCE_ID));

    assertEquals(Category.Label.AMENDMENTS, category.getLabel());
    assertEquals(PROVENANCE_ID, category.getProvenanceIds().get(0));
  }

  @Test
  public void testClassifyElementsOptions() throws FileNotFoundException {
    InputStream fileInputStream = new FileInputStream(SAMPLE_PDF);
    ClassifyElementsOptions classifyElementsOptions = new ClassifyElementsOptions.Builder()
        .file(fileInputStream)
        .filename(FILENAME)
        .fileContentType(HttpMediaType.APPLICATION_PDF)
        .modelId(ClassifyElementsOptions.ModelId.CONTRACTS)
        .build();
    classifyElementsOptions = classifyElementsOptions.newBuilder().build();

    assertEquals(fileInputStream, classifyElementsOptions.file());
    assertEquals(FILENAME, classifyElementsOptions.filename());
    assertEquals(HttpMediaType.APPLICATION_PDF, classifyElementsOptions.fileContentType());
    assertEquals(ClassifyElementsOptions.ModelId.CONTRACTS, classifyElementsOptions.modelId());
  }

  @Test
  public void testCompareDocumentsOptions() throws FileNotFoundException {
    InputStream fileInputStream = new FileInputStream(SAMPLE_PDF);
    CompareDocumentsOptions compareDocumentsOptions = new CompareDocumentsOptions.Builder()
        .file1(fileInputStream)
        .file1ContentType(CONTENT_TYPE_PDF)
        .file1Filename(FILENAME)
        .file1Label(LABEL)
        .file2(fileInputStream)
        .file2ContentType(CONTENT_TYPE_PDF)
        .file2Filename(FILENAME)
        .file2Label(LABEL)
        .modelId(CompareDocumentsOptions.ModelId.CONTRACTS)
        .build();
    compareDocumentsOptions = compareDocumentsOptions.newBuilder().build();

    assertEquals(fileInputStream, compareDocumentsOptions.file1());
    assertEquals(CONTENT_TYPE_PDF, compareDocumentsOptions.file1ContentType());
    assertEquals(FILENAME, compareDocumentsOptions.file1Filename());
    assertEquals(LABEL, compareDocumentsOptions.file1Label());
    assertEquals(fileInputStream, compareDocumentsOptions.file2());
    assertEquals(CONTENT_TYPE_PDF, compareDocumentsOptions.file2ContentType());
    assertEquals(FILENAME, compareDocumentsOptions.file2Filename());
    assertEquals(LABEL, compareDocumentsOptions.file2Label());
    assertEquals(CompareDocumentsOptions.ModelId.CONTRACTS, compareDocumentsOptions.modelId());
  }

  @Test
  public void testConvertToHtmlOptions() throws FileNotFoundException {
    InputStream fileInputStream = new FileInputStream(SAMPLE_PDF);
    ConvertToHtmlOptions convertToHtmlOptions = new ConvertToHtmlOptions.Builder()
        .file(fileInputStream)
        .fileContentType(CONTENT_TYPE_PDF)
        .filename(FILENAME)
        .modelId(ConvertToHtmlOptions.ModelId.CONTRACTS)
        .build();
    convertToHtmlOptions = convertToHtmlOptions.newBuilder().build();

    assertEquals(fileInputStream, convertToHtmlOptions.file());
    assertEquals(CONTENT_TYPE_PDF, convertToHtmlOptions.fileContentType());
    assertEquals(FILENAME, convertToHtmlOptions.filename());
    assertEquals(ConvertToHtmlOptions.ModelId.CONTRACTS, convertToHtmlOptions.modelId());
  }

  @Test
  public void testCreateBatchOptions() throws FileNotFoundException {
    InputStream fileInputStream = new FileInputStream(CREDENTIALS_FILE);
    CreateBatchOptions createBatchOptions = new CreateBatchOptions.Builder()
        .function(CreateBatchOptions.Function.ELEMENT_CLASSIFICATION)
        .inputBucketLocation(BUCKET_LOCATION)
        .inputBucketName(BUCKET_NAME)
        .inputCredentialsFile(fileInputStream)
        .inputCredentialsFilename(FILENAME)
        .modelId(CreateBatchOptions.ModelId.CONTRACTS)
        .outputBucketLocation(BUCKET_LOCATION)
        .outputBucketName(BUCKET_NAME)
        .outputCredentialsFile(fileInputStream)
        .outputCredentialsFilename(FILENAME)
        .build();
    createBatchOptions = createBatchOptions.newBuilder().build();

    assertEquals(CreateBatchOptions.Function.ELEMENT_CLASSIFICATION, createBatchOptions.function());
    assertEquals(BUCKET_LOCATION, createBatchOptions.inputBucketLocation());
    assertEquals(BUCKET_NAME, createBatchOptions.inputBucketName());
    assertEquals(fileInputStream, createBatchOptions.inputCredentialsFile());
    assertEquals(FILENAME, createBatchOptions.inputCredentialsFilename());
    assertEquals(CreateBatchOptions.ModelId.CONTRACTS, createBatchOptions.modelId());
    assertEquals(BUCKET_LOCATION, createBatchOptions.outputBucketLocation());
    assertEquals(BUCKET_NAME, createBatchOptions.outputBucketName());
    assertEquals(fileInputStream, createBatchOptions.outputCredentialsFile());
    assertEquals(FILENAME, createBatchOptions.outputCredentialsFilename());
  }

  @Test
  public void testDeleteFeedbackOptions() {
    DeleteFeedbackOptions deleteFeedbackOptions = new DeleteFeedbackOptions.Builder()
        .feedbackId(FEEDBACK_ID)
        .modelId(DeleteFeedbackOptions.ModelId.CONTRACTS)
        .build();
    deleteFeedbackOptions = deleteFeedbackOptions.newBuilder().build();

    assertEquals(FEEDBACK_ID, deleteFeedbackOptions.feedbackId());
    assertEquals(DeleteFeedbackOptions.ModelId.CONTRACTS, deleteFeedbackOptions.modelId());
  }

  @Test
  public void testExtractTablesOptions() throws FileNotFoundException {
    InputStream fileInputStream = new FileInputStream(SAMPLE_PDF);
    ExtractTablesOptions extractTablesOptions = new ExtractTablesOptions.Builder()
        .file(fileInputStream)
        .filename(FILENAME)
        .fileContentType(HttpMediaType.APPLICATION_PDF)
        .modelId(ExtractTablesOptions.ModelId.TABLES)
        .build();
    extractTablesOptions = extractTablesOptions.newBuilder().build();

    assertEquals(fileInputStream, extractTablesOptions.file());
    assertEquals(FILENAME, extractTablesOptions.filename());
    assertEquals(HttpMediaType.APPLICATION_PDF, extractTablesOptions.fileContentType());
    assertEquals(ExtractTablesOptions.ModelId.TABLES, extractTablesOptions.modelId());
  }

  @Test
  public void testFeedbackDataInput() {
    ShortDoc shortDoc = new ShortDoc();
    Location location = new Location();
    OriginalLabelsIn originalLabelsIn = new OriginalLabelsIn();
    UpdatedLabelsIn updatedLabelsIn = new UpdatedLabelsIn();

    FeedbackDataInput feedbackDataInput = new FeedbackDataInput();
    feedbackDataInput.setDocument(shortDoc);
    feedbackDataInput.setFeedbackType(FEEDBACK_TYPE);
    feedbackDataInput.setLocation(location);
    feedbackDataInput.setModelId(MODEL_ID);
    feedbackDataInput.setModelVersion(MODEL_VERSION);
    feedbackDataInput.setOriginalLabels(originalLabelsIn);
    feedbackDataInput.setText(TEXT);
    feedbackDataInput.setUpdatedLabels(updatedLabelsIn);

    assertEquals(shortDoc, feedbackDataInput.getDocument());
    assertEquals(FEEDBACK_TYPE, feedbackDataInput.getFeedbackType());
    assertEquals(location, feedbackDataInput.getLocation());
    assertEquals(MODEL_ID, feedbackDataInput.getModelId());
    assertEquals(MODEL_VERSION, feedbackDataInput.getModelVersion());
    assertEquals(originalLabelsIn, feedbackDataInput.getOriginalLabels());
    assertEquals(TEXT, feedbackDataInput.getText());
    assertEquals(updatedLabelsIn, feedbackDataInput.getUpdatedLabels());
  }

  @Test
  public void testListBatchesOptions() {
    ListBatchesOptions listBatchesOptions = new ListBatchesOptions.Builder().build();
    ListBatchesOptions newListBatchesOptions = listBatchesOptions.newBuilder().build();

    assertEquals(listBatchesOptions, newListBatchesOptions);
  }

  @Test
  public void testGetBatchOptions() {
    GetBatchOptions getBatchOptions = new GetBatchOptions.Builder()
        .batchId(BATCH_ID)
        .build();
    getBatchOptions = getBatchOptions.newBuilder().build();

    assertEquals(BATCH_ID, getBatchOptions.batchId());
  }

  @Test
  public void testGetFeedbackOptions() {
    GetFeedbackOptions getFeedbackOptions = new GetFeedbackOptions.Builder()
        .feedbackId(FEEDBACK_ID)
        .modelId(GetFeedbackOptions.ModelId.CONTRACTS)
        .build();
    getFeedbackOptions = getFeedbackOptions.newBuilder().build();

    assertEquals(FEEDBACK_ID, getFeedbackOptions.feedbackId());
    assertEquals(GetFeedbackOptions.ModelId.CONTRACTS, getFeedbackOptions.modelId());
  }

  @Test
  public void testLabel() {
    Label label = new Label();
    label.setNature(NATURE);
    label.setParty(PARTY);

    assertEquals(NATURE, label.getNature());
    assertEquals(PARTY, label.getParty());
  }

  @Test
  public void testListFeedbackOptions() {
    ListFeedbackOptions listFeedbackOptions = new ListFeedbackOptions.Builder()
        .after(DATE)
        .before(DATE)
        .categoryAdded(CATEGORY_ADDED)
        .categoryRemoved(CATEGORY_REMOVED)
        .categoryNotChanged(CATEGORY_NOT_CHANGED)
        .pageLimit(PAGE_LIMIT)
        .documentTitle(DOCUMENT_TITLE)
        .feedbackType(FEEDBACK_TYPE)
        .includeTotal(true)
        .modelId(MODEL_ID)
        .modelVersion(MODEL_VERSION)
        .cursor(CURSOR)
        .sort(SORT)
        .typeAdded(TYPE_ADDED)
        .typeRemoved(TYPE_REMOVED)
        .typeNotChanged(TYPE_NOT_CHANGED)
        .build();
    listFeedbackOptions = listFeedbackOptions.newBuilder().build();

    assertEquals(DATE, listFeedbackOptions.after());
    assertEquals(DATE, listFeedbackOptions.before());
    assertEquals(CATEGORY_ADDED, listFeedbackOptions.categoryAdded());
    assertEquals(CATEGORY_REMOVED, listFeedbackOptions.categoryRemoved());
    assertEquals(CATEGORY_NOT_CHANGED, listFeedbackOptions.categoryNotChanged());
    assertEquals(PAGE_LIMIT, listFeedbackOptions.pageLimit());
    assertEquals(DOCUMENT_TITLE, listFeedbackOptions.documentTitle());
    assertEquals(FEEDBACK_TYPE, listFeedbackOptions.feedbackType());
    assertEquals(MODEL_ID, listFeedbackOptions.modelId());
    assertEquals(MODEL_VERSION, listFeedbackOptions.modelVersion());
    assertEquals(CURSOR, listFeedbackOptions.cursor());
    assertEquals(TYPE_ADDED, listFeedbackOptions.typeAdded());
    assertEquals(TYPE_REMOVED, listFeedbackOptions.typeRemoved());
    assertEquals(TYPE_NOT_CHANGED, listFeedbackOptions.typeNotChanged());
    assertEquals(true, listFeedbackOptions.includeTotal());
  }

  @Test
  public void testLocation() {
    Location location = new Location();
    location.setBegin(BEGIN);
    location.setEnd(END);

    assertEquals(BEGIN, location.getBegin());
    assertEquals(END, location.getEnd());
  }

  @Test
  public void testOriginalLabelsIn() {
    Category category = new Category();
    TypeLabel typeLabel = new TypeLabel();
    OriginalLabelsIn originalLabelsIn = new OriginalLabelsIn();
    originalLabelsIn.setCategories(Collections.singletonList(category));
    originalLabelsIn.setTypes(Collections.singletonList(typeLabel));

    assertEquals(category, originalLabelsIn.getCategories().get(0));
    assertEquals(typeLabel, originalLabelsIn.getTypes().get(0));
  }

  @Test
  public void testShortDoc() {
    ShortDoc shortDoc = new ShortDoc();
    shortDoc.setHash(HASH);
    shortDoc.setTitle(TITLE);

    assertEquals(HASH, shortDoc.getHash());
    assertEquals(TITLE, shortDoc.getTitle());
  }

  @Test
  public void testTypeLabel() {
    Label label = new Label();
    TypeLabel typeLabel = new TypeLabel();
    typeLabel.setLabel(label);
    typeLabel.setProvenanceIds(Collections.singletonList(PROVENANCE_ID));

    assertEquals(label, typeLabel.getLabel());
    assertEquals(PROVENANCE_ID, typeLabel.getProvenanceIds().get(0));
  }

  @Test
  public void testUpdateBatchOptions() {
    UpdateBatchOptions updateBatchOptions = new UpdateBatchOptions.Builder()
        .action(UpdateBatchOptions.Action.CANCEL)
        .batchId(BATCH_ID)
        .modelId(UpdateBatchOptions.ModelId.CONTRACTS)
        .build();
    updateBatchOptions = updateBatchOptions.newBuilder().build();

    assertEquals(UpdateBatchOptions.Action.CANCEL, updateBatchOptions.action());
    assertEquals(BATCH_ID, updateBatchOptions.batchId());
    assertEquals(UpdateBatchOptions.ModelId.CONTRACTS, updateBatchOptions.modelId());
  }

  @Test
  public void testUpdatedLabelsIn() {
    Category category = new Category();
    TypeLabel typeLabel = new TypeLabel();
    UpdatedLabelsIn updatedLabelsIn = new UpdatedLabelsIn();
    updatedLabelsIn.setCategories(Collections.singletonList(category));
    updatedLabelsIn.setTypes(Collections.singletonList(typeLabel));

    assertEquals(category, updatedLabelsIn.getCategories().get(0));
    assertEquals(typeLabel, updatedLabelsIn.getTypes().get(0));
  }

  @Test
  public void testConvertToHtml() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(convertToHtmlResponse));

    ConvertToHtmlOptions convertToHtmlOptions = new ConvertToHtmlOptions.Builder()
        .file(SAMPLE_PDF)
        .filename(FILENAME)
        .build();
    HTMLReturn response = service.convertToHtml(convertToHtmlOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CONVERT_TO_HTML_PATH, request.getPath());
    assertEquals(NUM_PAGES, response.getNumPages());
    assertEquals(AUTHOR, response.getAuthor());
    assertEquals(PUBLICATION_DATE, response.getPublicationDate());
    assertEquals(TITLE, response.getTitle());
    assertEquals(HTML, response.getHtml());
  }

  @Test
  public void testClassifyElements() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(classifyElementsResponse));

    ClassifyElementsOptions classifyElementsOptions = new ClassifyElementsOptions.Builder()
        .file(SAMPLE_PDF)
        .build();
    ClassifyReturn response = service.classifyElements(classifyElementsOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CLASSIFY_ELEMENTS_PATH, request.getPath());
    assertEquals(TITLE, response.getDocument().getTitle());
    assertEquals(HTML, response.getDocument().getHtml());
    assertEquals(HASH, response.getDocument().getHash());
    assertEquals(LABEL, response.getDocument().getLabel());
    assertEquals(MODEL_ID, response.getModelId());
    assertEquals(MODEL_VERSION, response.getModelVersion());
    assertEquals(BEGIN, response.getElements().get(0).getLocation().getBegin());
    assertEquals(END, response.getElements().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getElements().get(0).getText());
    assertEquals(NATURE, response.getElements().get(0).getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY, response.getElements().get(0).getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID, response.getElements().get(0).getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL, response.getElements().get(0).getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID, response.getElements().get(0).getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(TYPE, response.getElements().get(0).getAttributes().get(0).getType());
    assertEquals(TEXT, response.getElements().get(0).getAttributes().get(0).getText());
    assertEquals(BEGIN, response.getElements().get(0).getAttributes().get(0).getLocation().getBegin());
    assertEquals(END, response.getElements().get(0).getAttributes().get(0).getLocation().getEnd());
    assertEquals(BEGIN, response.getTables().get(0).getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getTables().get(0).getText());
    assertEquals(BEGIN, response.getTables().get(0).getSectionTitle().getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getSectionTitle().getLocation().getEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getTableHeaders().get(0).getCellId());
    assertEquals(BEGIN_DOUBLE, response.getTables().get(0).getTableHeaders().get(0).getLocation().get("begin"));
    assertEquals(END_DOUBLE, response.getTables().get(0).getTableHeaders().get(0).getLocation().get("end"));
    assertEquals(TEXT, response.getTables().get(0).getTableHeaders().get(0).getText());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getTableHeaders().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getTableHeaders().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getTableHeaders().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getTableHeaders().get(0).getColumnIndexEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getColumnHeaders().get(0).getCellId());
    assertEquals(BEGIN_DOUBLE, response.getTables().get(0).getColumnHeaders().get(0).getLocation().get("begin"));
    assertEquals(END_DOUBLE, response.getTables().get(0).getColumnHeaders().get(0).getLocation().get("end"));
    assertEquals(TEXT, response.getTables().get(0).getColumnHeaders().get(0).getText());
    assertEquals(TEXT_NORMALIZED, response.getTables().get(0).getColumnHeaders().get(0).getTextNormalized());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getColumnHeaders().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getColumnHeaders().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getColumnHeaders().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getColumnHeaders().get(0).getColumnIndexEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getRowHeaders().get(0).getCellId());
    assertEquals(BEGIN, response.getTables().get(0).getRowHeaders().get(0).getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getRowHeaders().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getTables().get(0).getRowHeaders().get(0).getText());
    assertEquals(TEXT_NORMALIZED, response.getTables().get(0).getRowHeaders().get(0).getTextNormalized());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getRowHeaders().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getRowHeaders().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getRowHeaders().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getRowHeaders().get(0).getColumnIndexEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getBodyCells().get(0).getCellId());
    assertEquals(BEGIN, response.getTables().get(0).getBodyCells().get(0).getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getBodyCells().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getText());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getBodyCells().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getBodyCells().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getBodyCells().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getBodyCells().get(0).getColumnIndexEnd());
    assertEquals(ID, response.getTables().get(0).getBodyCells().get(0).getRowHeaderIds().get(0));
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getRowHeaderTexts().get(0));
    assertEquals(TEXT_NORMALIZED,
        response.getTables().get(0).getBodyCells().get(0).getRowHeaderTextsNormalized().get(0));
    assertEquals(ID, response.getTables().get(0).getBodyCells().get(0).getColumnHeaderIds().get(0));
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getColumnHeaderTexts().get(0));
    assertEquals(TEXT_NORMALIZED,
        response.getTables().get(0).getBodyCells().get(0).getColumnHeaderTextsNormalized().get(0));
    assertEquals(TYPE, response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getType());
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getText());
    assertEquals(BEGIN,
        response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getLocation().getBegin());
    assertEquals(END,
        response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getDocumentStructure().getSectionTitles().get(0).getText());
    assertEquals(BEGIN, response.getDocumentStructure().getSectionTitles().get(0).getLocation().getBegin());
    assertEquals(END, response.getDocumentStructure().getSectionTitles().get(0).getLocation().getEnd());
    assertEquals(LEVEL, response.getDocumentStructure().getSectionTitles().get(0).getLevel());
    assertEquals(BEGIN,
        response.getDocumentStructure().getSectionTitles().get(0).getElementLocations().get(0).getBegin());
    assertEquals(END,
        response.getDocumentStructure().getSectionTitles().get(0).getElementLocations().get(0).getEnd());
    assertEquals(TEXT, response.getDocumentStructure().getLeadingSentences().get(0).getText());
    assertEquals(BEGIN, response.getDocumentStructure().getLeadingSentences().get(0).getLocation().getBegin());
    assertEquals(END, response.getDocumentStructure().getLeadingSentences().get(0).getLocation().getEnd());
    assertEquals(BEGIN,
        response.getDocumentStructure().getLeadingSentences().get(0).getElementLocations().get(0).getBegin());
    assertEquals(END,
        response.getDocumentStructure().getLeadingSentences().get(0).getElementLocations().get(0).getEnd());
    assertEquals(PARTY, response.getParties().get(0).getParty());
    assertEquals(Parties.Importance.UNKNOWN, response.getParties().get(0).getImportance());
    assertEquals(ROLE, response.getParties().get(0).getRole());
    assertEquals(TEXT, response.getParties().get(0).getAddresses().get(0).getText());
    assertEquals(BEGIN, response.getParties().get(0).getAddresses().get(0).getLocation().getBegin());
    assertEquals(END, response.getParties().get(0).getAddresses().get(0).getLocation().getEnd());
    assertEquals(NAME, response.getParties().get(0).getContacts().get(0).getName());
    assertEquals(ROLE, response.getParties().get(0).getContacts().get(0).getRole());
    assertEquals(TEXT, response.getEffectiveDates().get(0).getText());
    assertEquals(BEGIN, response.getEffectiveDates().get(0).getLocation().getBegin());
    assertEquals(END, response.getEffectiveDates().get(0).getLocation().getEnd());
    assertEquals(EffectiveDates.ConfidenceLevel.HIGH, response.getEffectiveDates().get(0).getConfidenceLevel());
    assertEquals(TEXT, response.getContractAmounts().get(0).getText());
    assertEquals(BEGIN, response.getContractAmounts().get(0).getLocation().getBegin());
    assertEquals(END, response.getContractAmounts().get(0).getLocation().getEnd());
    assertEquals(ContractAmts.ConfidenceLevel.HIGH, response.getContractAmounts().get(0).getConfidenceLevel());
    assertEquals(TEXT, response.getTerminationDates().get(0).getText());
    assertEquals(BEGIN, response.getTerminationDates().get(0).getLocation().getBegin());
    assertEquals(END, response.getTerminationDates().get(0).getLocation().getEnd());
    assertEquals(TerminationDates.ConfidenceLevel.HIGH, response.getTerminationDates().get(0).getConfidenceLevel());
  }

  @Test
  public void testExtractTables() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(extractTablesResponse));

    ExtractTablesOptions extractTablesOptions = new ExtractTablesOptions.Builder()
        .file(SAMPLE_PDF)
        .build();
    TableReturn response = service.extractTables(extractTablesOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(EXTRACT_TABLES_PATH, request.getPath());
    assertEquals(HTML, response.getDocument().getHtml());
    assertEquals(TITLE, response.getDocument().getTitle());
    assertEquals(HASH, response.getDocument().getHash());
    assertEquals(MODEL_ID, response.getModelId());
    assertEquals(MODEL_VERSION, response.getModelVersion());
    assertEquals(BEGIN, response.getTables().get(0).getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getTables().get(0).getText());
    assertEquals(BEGIN, response.getTables().get(0).getSectionTitle().getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getSectionTitle().getLocation().getEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getTableHeaders().get(0).getCellId());
    assertEquals(BEGIN_DOUBLE, response.getTables().get(0).getTableHeaders().get(0).getLocation().get("begin"));
    assertEquals(END_DOUBLE, response.getTables().get(0).getTableHeaders().get(0).getLocation().get("end"));
    assertEquals(TEXT, response.getTables().get(0).getTableHeaders().get(0).getText());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getTableHeaders().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getTableHeaders().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getTableHeaders().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getTableHeaders().get(0).getColumnIndexEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getColumnHeaders().get(0).getCellId());
    assertEquals(BEGIN_DOUBLE, response.getTables().get(0).getColumnHeaders().get(0).getLocation().get("begin"));
    assertEquals(END_DOUBLE, response.getTables().get(0).getColumnHeaders().get(0).getLocation().get("end"));
    assertEquals(TEXT, response.getTables().get(0).getColumnHeaders().get(0).getText());
    assertEquals(TEXT_NORMALIZED, response.getTables().get(0).getColumnHeaders().get(0).getTextNormalized());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getColumnHeaders().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getColumnHeaders().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getColumnHeaders().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getColumnHeaders().get(0).getColumnIndexEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getRowHeaders().get(0).getCellId());
    assertEquals(BEGIN, response.getTables().get(0).getRowHeaders().get(0).getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getRowHeaders().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getTables().get(0).getRowHeaders().get(0).getText());
    assertEquals(TEXT_NORMALIZED, response.getTables().get(0).getRowHeaders().get(0).getTextNormalized());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getRowHeaders().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getRowHeaders().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getRowHeaders().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getRowHeaders().get(0).getColumnIndexEnd());
    assertEquals(CELL_ID, response.getTables().get(0).getBodyCells().get(0).getCellId());
    assertEquals(BEGIN, response.getTables().get(0).getBodyCells().get(0).getLocation().getBegin());
    assertEquals(END, response.getTables().get(0).getBodyCells().get(0).getLocation().getEnd());
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getText());
    assertEquals(ROW_INDEX_BEGIN, response.getTables().get(0).getBodyCells().get(0).getRowIndexBegin());
    assertEquals(ROW_INDEX_END, response.getTables().get(0).getBodyCells().get(0).getRowIndexEnd());
    assertEquals(COLUMN_INDEX_BEGIN, response.getTables().get(0).getBodyCells().get(0).getColumnIndexBegin());
    assertEquals(COLUMN_INDEX_END, response.getTables().get(0).getBodyCells().get(0).getColumnIndexEnd());
    assertEquals(ID, response.getTables().get(0).getBodyCells().get(0).getRowHeaderIds().get(0));
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getRowHeaderTexts().get(0));
    assertEquals(TEXT_NORMALIZED,
        response.getTables().get(0).getBodyCells().get(0).getRowHeaderTextsNormalized().get(0));
    assertEquals(ID, response.getTables().get(0).getBodyCells().get(0).getColumnHeaderIds().get(0));
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getColumnHeaderTexts().get(0));
    assertEquals(TEXT_NORMALIZED,
        response.getTables().get(0).getBodyCells().get(0).getColumnHeaderTextsNormalized().get(0));
    assertEquals(TYPE, response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getType());
    assertEquals(TEXT, response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getText());
    assertEquals(BEGIN,
        response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getLocation().getBegin());
    assertEquals(END,
        response.getTables().get(0).getBodyCells().get(0).getAttributes().get(0).getLocation().getEnd());
  }

  @Test
  public void testCompareDocuments() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(compareDocumentsResponse));

    CompareDocumentsOptions compareDocumentsOptions = new CompareDocumentsOptions.Builder()
        .file1(SAMPLE_PDF)
        .file2(SAMPLE_PDF)
        .build();
    CompareReturn response = service.compareDocuments(compareDocumentsOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(COMPARE_DOCUMENTS_PATH, request.getPath());
    assertEquals(TITLE, response.getDocuments().get(0).getTitle());
    assertEquals(HTML, response.getDocuments().get(0).getHtml());
    assertEquals(HASH, response.getDocuments().get(0).getHash());
    assertEquals(LABEL, response.getDocuments().get(0).getLabel());
    assertEquals(DOCUMENT_LABEL, response.getAlignedElements().get(0).getElementPair().get(0).getDocumentLabel());
    assertEquals(TEXT, response.getAlignedElements().get(0).getElementPair().get(0).getText());
    assertEquals(BEGIN, response.getAlignedElements().get(0).getElementPair().get(0).getLocation().getBegin());
    assertEquals(END, response.getAlignedElements().get(0).getElementPair().get(0).getLocation().getEnd());
    assertEquals(NATURE,
        response.getAlignedElements().get(0).getElementPair().get(0).getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY,
        response.getAlignedElements().get(0).getElementPair().get(0).getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getAlignedElements().get(0).getElementPair().get(0).getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL, response.getAlignedElements().get(0).getElementPair().get(0).getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getAlignedElements().get(0).getElementPair().get(0).getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(TYPE, response.getAlignedElements().get(0).getElementPair().get(0).getAttributes().get(0).getType());
    assertEquals(TEXT, response.getAlignedElements().get(0).getElementPair().get(0).getAttributes().get(0).getText());
    assertEquals(BEGIN,
        response.getAlignedElements().get(0).getElementPair().get(0).getAttributes().get(0).getLocation().getBegin());
    assertEquals(END,
        response.getAlignedElements().get(0).getElementPair().get(0).getAttributes().get(0).getLocation().getEnd());
    assertEquals(true, response.getAlignedElements().get(0).isIdenticalText());
    assertEquals(PROVENANCE_ID, response.getAlignedElements().get(0).getProvenanceIds().get(0));
    assertTrue(response.getAlignedElements().get(0).isSignificantElements());
    assertEquals(DOCUMENT_LABEL, response.getUnalignedElements().get(0).getDocumentLabel());
    assertEquals(TEXT, response.getUnalignedElements().get(0).getText());
    assertEquals(BEGIN, response.getUnalignedElements().get(0).getLocation().getBegin());
    assertEquals(END, response.getUnalignedElements().get(0).getLocation().getEnd());
    assertEquals(NATURE, response.getUnalignedElements().get(0).getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY, response.getUnalignedElements().get(0).getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID, response.getUnalignedElements().get(0).getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL, response.getUnalignedElements().get(0).getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getUnalignedElements().get(0).getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(TYPE, response.getUnalignedElements().get(0).getAttributes().get(0).getType());
    assertEquals(TEXT, response.getUnalignedElements().get(0).getAttributes().get(0).getText());
    assertEquals(BEGIN, response.getUnalignedElements().get(0).getAttributes().get(0).getLocation().getBegin());
    assertEquals(END, response.getUnalignedElements().get(0).getAttributes().get(0).getLocation().getEnd());
    assertEquals(MODEL_ID, response.getModelId());
    assertEquals(MODEL_VERSION, response.getModelVersion());
  }

  @Test
  public void testAddFeedback() throws InterruptedException {
    server.enqueue(jsonResponse(addFeedbackResponse));

    FeedbackDataInput feedbackDataInput = new FeedbackDataInput();
    AddFeedbackOptions addFeedbackOptions = new AddFeedbackOptions.Builder()
        .feedbackData(feedbackDataInput)
        .build();
    FeedbackReturn response = service.addFeedback(addFeedbackOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(FEEDBACK_PATH, request.getPath());
    assertEquals(FEEDBACK_ID, response.getFeedbackId());
    assertEquals(USER_ID, response.getUserId());
    assertEquals(COMMENT, response.getComment());
    assertEquals(testDateValue, response.getCreated());
    assertEquals(FEEDBACK_TYPE, response.getFeedbackData().getFeedbackType());
    assertEquals(TITLE, response.getFeedbackData().getDocument().getTitle());
    assertEquals(HASH, response.getFeedbackData().getDocument().getHash());
    assertEquals(MODEL_ID, response.getFeedbackData().getModelId());
    assertEquals(MODEL_VERSION, response.getFeedbackData().getModelVersion());
    assertEquals(BEGIN, response.getFeedbackData().getLocation().getBegin());
    assertEquals(END, response.getFeedbackData().getLocation().getEnd());
    assertEquals(TEXT, response.getFeedbackData().getText());
    assertEquals(NATURE, response.getFeedbackData().getOriginalLabels().getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY, response.getFeedbackData().getOriginalLabels().getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getOriginalLabels().getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL, response.getFeedbackData().getOriginalLabels().getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getOriginalLabels().getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(OriginalLabelsOut.Modification.ADDED,
        response.getFeedbackData().getOriginalLabels().getModification());
    assertEquals(NATURE, response.getFeedbackData().getUpdatedLabels().getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY, response.getFeedbackData().getUpdatedLabels().getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getUpdatedLabels().getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL,
        response.getFeedbackData().getUpdatedLabels().getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getUpdatedLabels().getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(UpdatedLabelsOut.Modification.ADDED,
        response.getFeedbackData().getUpdatedLabels().getModification());
    assertEquals(REFRESH_CURSOR, response.getFeedbackData().getPagination().getRefreshCursor());
    assertEquals(NEXT_CURSOR, response.getFeedbackData().getPagination().getNextCursor());
    assertEquals(REFRESH_URL, response.getFeedbackData().getPagination().getRefreshUrl());
    assertEquals(NEXT_URL, response.getFeedbackData().getPagination().getNextUrl());
    assertEquals(TOTAL, response.getFeedbackData().getPagination().getTotal());
  }

  @Test
  public void testDeleteFeedback() throws InterruptedException {
    server.enqueue(new MockResponse());

    DeleteFeedbackOptions deleteFeedbackOptions = new DeleteFeedbackOptions.Builder()
        .feedbackId(FEEDBACK_ID)
        .build();
    service.deleteFeedback(deleteFeedbackOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SPECIFIC_FEEDBACK_PATH, request.getPath());
  }

  @Test
  public void testGetFeedback() throws InterruptedException {
    server.enqueue(jsonResponse(getFeedbackResponse));

    GetFeedbackOptions getFeedbackOptions = new GetFeedbackOptions.Builder()
        .feedbackId(FEEDBACK_ID)
        .build();
    GetFeedback response = service.getFeedback(getFeedbackOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(SPECIFIC_FEEDBACK_PATH, request.getPath());
    assertEquals(FEEDBACK_ID, response.getFeedbackId());
    assertEquals(COMMENT, response.getComment());
    assertEquals(testDateValue, response.getCreated());
    assertEquals(FEEDBACK_TYPE, response.getFeedbackData().getFeedbackType());
    assertEquals(TITLE, response.getFeedbackData().getDocument().getTitle());
    assertEquals(HASH, response.getFeedbackData().getDocument().getHash());
    assertEquals(MODEL_ID, response.getFeedbackData().getModelId());
    assertEquals(MODEL_VERSION, response.getFeedbackData().getModelVersion());
    assertEquals(BEGIN, response.getFeedbackData().getLocation().getBegin());
    assertEquals(END, response.getFeedbackData().getLocation().getEnd());
    assertEquals(TEXT, response.getFeedbackData().getText());
    assertEquals(NATURE, response.getFeedbackData().getOriginalLabels().getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY, response.getFeedbackData().getOriginalLabels().getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getOriginalLabels().getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL, response.getFeedbackData().getOriginalLabels().getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getOriginalLabels().getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(OriginalLabelsOut.Modification.ADDED,
        response.getFeedbackData().getOriginalLabels().getModification());
    assertEquals(NATURE, response.getFeedbackData().getUpdatedLabels().getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY, response.getFeedbackData().getUpdatedLabels().getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getUpdatedLabels().getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL, response.getFeedbackData().getUpdatedLabels().getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getFeedbackData().getUpdatedLabels().getCategories().get(0).getProvenanceIds().get(0));
    assertEquals(UpdatedLabelsOut.Modification.ADDED,
        response.getFeedbackData().getUpdatedLabels().getModification());
    assertEquals(REFRESH_CURSOR, response.getFeedbackData().getPagination().getRefreshCursor());
    assertEquals(NEXT_CURSOR, response.getFeedbackData().getPagination().getNextCursor());
    assertEquals(REFRESH_URL, response.getFeedbackData().getPagination().getRefreshUrl());
    assertEquals(NEXT_URL, response.getFeedbackData().getPagination().getNextUrl());
    assertEquals(TOTAL, response.getFeedbackData().getPagination().getTotal());
  }

  @Test
  public void testListFeedbackWithOptions() throws InterruptedException {
    server.enqueue(jsonResponse(listFeedbackResponse));

    ListFeedbackOptions listFeedbackOptions = new ListFeedbackOptions.Builder().build();
    FeedbackList response = service.listFeedback(listFeedbackOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertFeedbackListResponse(request, response);
  }

  @Test
  public void testListFeedbackWithoutOptions() throws InterruptedException {
    server.enqueue(jsonResponse(listFeedbackResponse));

    FeedbackList response = service.listFeedback().execute();
    RecordedRequest request = server.takeRequest();

    assertFeedbackListResponse(request, response);
  }

  @Test
  public void testCreateBatch() throws FileNotFoundException, InterruptedException {
    server.enqueue(jsonResponse(batchStatusResponse));

    CreateBatchOptions createBatchOptions = new CreateBatchOptions.Builder()
        .function(CreateBatchOptions.Function.ELEMENT_CLASSIFICATION)
        .inputCredentialsFile(CREDENTIALS_FILE)
        .inputBucketLocation(BUCKET_LOCATION)
        .inputBucketName(BUCKET_NAME)
        .outputCredentialsFile(CREDENTIALS_FILE)
        .outputBucketLocation(BUCKET_LOCATION)
        .outputBucketName(BUCKET_NAME)
        .build();
    BatchStatus response = service.createBatch(createBatchOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(CREATE_BATCH_PATH, request.getPath());
    assertBatchStatusResponse(response);
  }

  @Test
  public void testGetBatch() throws InterruptedException {
    server.enqueue(jsonResponse(batchStatusResponse));

    GetBatchOptions getBatchOptions = new GetBatchOptions.Builder()
        .batchId(BATCH_ID)
        .build();
    BatchStatus response = service.getBatch(getBatchOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(GET_BATCH_PATH, request.getPath());
    assertBatchStatusResponse(response);
  }

  @Test
  public void testListBatchesWithOptions() throws InterruptedException {
    server.enqueue(jsonResponse(batchesResponse));

    ListBatchesOptions listBatchesOptions = new ListBatchesOptions.Builder().build();
    Batches response = service.listBatches(listBatchesOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertBatchesResponse(request, response);
  }

  @Test
  public void testListBatchesWithoutOptions() throws InterruptedException {
    server.enqueue(jsonResponse(batchesResponse));

    Batches response = service.listBatches().execute();
    RecordedRequest request = server.takeRequest();

    assertBatchesResponse(request, response);
  }

  @Test
  public void testUpdateBatch() throws InterruptedException {
    server.enqueue(jsonResponse(batchStatusResponse));

    UpdateBatchOptions updateBatchOptions = new UpdateBatchOptions.Builder()
        .action(UpdateBatchOptions.Action.CANCEL)
        .batchId(BATCH_ID)
        .build();
    BatchStatus response = service.updateBatch(updateBatchOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(UPDATE_BATCH_PATH, request.getPath());
    assertBatchStatusResponse(response);
  }

  private void assertFeedbackListResponse(RecordedRequest request, FeedbackList response) {
    assertEquals(FEEDBACK_PATH, request.getPath());
    assertEquals(FEEDBACK_ID, response.getFeedback().get(0).getFeedbackId());
    assertEquals(COMMENT, response.getFeedback().get(0).getComment());
    assertEquals(testDateValue, response.getFeedback().get(0).getCreated());
    assertEquals(FEEDBACK_TYPE, response.getFeedback().get(0).getFeedbackData().getFeedbackType());
    assertEquals(TITLE, response.getFeedback().get(0).getFeedbackData().getDocument().getTitle());
    assertEquals(HASH, response.getFeedback().get(0).getFeedbackData().getDocument().getHash());
    assertEquals(MODEL_ID, response.getFeedback().get(0).getFeedbackData().getModelId());
    assertEquals(MODEL_VERSION, response.getFeedback().get(0).getFeedbackData().getModelVersion());
    assertEquals(BEGIN, response.getFeedback().get(0).getFeedbackData().getLocation().getBegin());
    assertEquals(END, response.getFeedback().get(0).getFeedbackData().getLocation().getEnd());
    assertEquals(TEXT, response.getFeedback().get(0).getFeedbackData().getText());
    assertEquals(NATURE,
        response.getFeedback().get(0).getFeedbackData().getOriginalLabels().getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY,
        response.getFeedback().get(0).getFeedbackData().getOriginalLabels().getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getFeedback().get(0).getFeedbackData().getOriginalLabels().getTypes().get(0).getProvenanceIds()
            .get(0));
    assertEquals(LABEL,
        response.getFeedback().get(0).getFeedbackData().getOriginalLabels().getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getFeedback().get(0).getFeedbackData().getOriginalLabels().getCategories().get(0).getProvenanceIds()
            .get(0));
    assertEquals(OriginalLabelsOut.Modification.ADDED,
        response.getFeedback().get(0).getFeedbackData().getOriginalLabels().getModification());
    assertEquals(NATURE,
        response.getFeedback().get(0).getFeedbackData().getUpdatedLabels().getTypes().get(0).getLabel().getNature());
    assertEquals(PARTY,
        response.getFeedback().get(0).getFeedbackData().getUpdatedLabels().getTypes().get(0).getLabel().getParty());
    assertEquals(PROVENANCE_ID,
        response.getFeedback().get(0).getFeedbackData().getUpdatedLabels().getTypes().get(0).getProvenanceIds().get(0));
    assertEquals(LABEL,
        response.getFeedback().get(0).getFeedbackData().getUpdatedLabels().getCategories().get(0).getLabel());
    assertEquals(PROVENANCE_ID,
        response.getFeedback().get(0).getFeedbackData().getUpdatedLabels().getCategories().get(0).getProvenanceIds()
            .get(0));
    assertEquals(UpdatedLabelsOut.Modification.ADDED,
        response.getFeedback().get(0).getFeedbackData().getUpdatedLabels().getModification());
    assertEquals(REFRESH_CURSOR, response.getFeedback().get(0).getFeedbackData().getPagination().getRefreshCursor());
    assertEquals(NEXT_CURSOR, response.getFeedback().get(0).getFeedbackData().getPagination().getNextCursor());
    assertEquals(REFRESH_URL, response.getFeedback().get(0).getFeedbackData().getPagination().getRefreshUrl());
    assertEquals(NEXT_URL, response.getFeedback().get(0).getFeedbackData().getPagination().getNextUrl());
    assertEquals(TOTAL, response.getFeedback().get(0).getFeedbackData().getPagination().getTotal());
  }

  private void assertBatchStatusResponse(BatchStatus response) {
    assertEquals(BatchStatus.Function.ELEMENT_CLASSIFICATION, response.getFunction());
    assertEquals(BUCKET_LOCATION, response.getInputBucketLocation());
    assertEquals(BUCKET_NAME, response.getInputBucketName());
    assertEquals(BUCKET_LOCATION, response.getOutputBucketLocation());
    assertEquals(BUCKET_NAME, response.getOutputBucketName());
    assertEquals(BATCH_ID, response.getBatchId());
    assertEquals(TOTAL, response.getDocumentCounts().getTotal());
    assertEquals(PENDING, response.getDocumentCounts().getPending());
    assertEquals(SUCCESSFUL, response.getDocumentCounts().getSuccessful());
    assertEquals(FAILED, response.getDocumentCounts().getFailed());
    assertEquals(STATUS, response.getStatus());
    assertEquals(testDateValue, response.getCreated());
    assertEquals(testDateValue, response.getUpdated());
  }

  private void assertBatchesResponse(RecordedRequest request, Batches response) {
    assertEquals(LIST_BATCHES_PATH, request.getPath());
    assertBatchStatusResponse(response.getBatches().get(0));
  }
}
