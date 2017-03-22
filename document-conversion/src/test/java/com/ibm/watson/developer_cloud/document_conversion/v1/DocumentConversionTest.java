/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.document_conversion.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexConfiguration;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexDocumentOptions;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexFields;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;

/**
 * Document Conversion unit tests.
 */
@SuppressWarnings("resource")
public class DocumentConversionTest extends WatsonServiceUnitTest {

  private static final String VERSION = "version";
  private static final String CONVERT_DOCUMENT_PATH = "/v1/convert_document";
  private static final String INDEX_DOCUMENT_PATH = "/v1/index_document";
  private static final String RESOURCE = "src/test/resources/document_conversion/";

  private DocumentConversion service;

  private final File html;
  private InputStream expAnswer;
  private InputStream expIndexResponse;
  private InputStream expIndexDryRunResponse;
  private IndexConfiguration indexConfiguration;
  private IndexConfiguration indexConfigWithFields;
  private IndexConfiguration indexConfigWithFieldsForDryRun;

  /**
   * Instantiates a new document conversion test.
   *
   * @throws Exception the exception
   */
  public DocumentConversionTest() throws Exception {
    html = new File(RESOURCE + "html-with-extra-content-input.htm");

  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());

    expAnswer = new FileInputStream(RESOURCE + "html-with-extra-content-input-to-answer.json");
    expIndexResponse = new ByteArrayInputStream("{\"status\": \"success\"}".getBytes());
    expIndexDryRunResponse = new FileInputStream(RESOURCE + "html-with-extra-content-input-index-dry-run.json");
    indexConfiguration = new IndexConfiguration("serviceInstanceId", "clusterId", "searchCollectionName");
    IndexFields fields = new IndexFields.Builder().mappings("Author", "Created By")
        .mappings("Date Created", "Created On").include("SomeMetadataName").include("id").include("Created By")
        .include("Created On").exclude("Category").build();
    indexConfigWithFields = new IndexConfiguration("serviceInstanceId", "clusterId", "searchCollectionName", fields);
    indexConfigWithFieldsForDryRun = new IndexConfiguration(null, null, null, fields);
  }

  private RecordedRequest checkRequest(String requestPath) throws InterruptedException {
    final RecordedRequest request = server.takeRequest();
    final HttpUrl url = HttpUrl.parse(getMockWebServerUrl() + request.getPath());

    assertEquals(requestPath, url.encodedPath());
    assertEquals(DocumentConversion.VERSION_DATE_2015_12_01, url.queryParameter(VERSION));
    assertEquals(POST, request.getMethod());

    return request;
  }

  /**
   * Test convert document.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testConvertDocument() throws URISyntaxException, IOException, InterruptedException {
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expAnswer)));
    Answers convertedDoc = service.convertDocumentToAnswer(html, null).execute();
    checkRequest(CONVERT_DOCUMENT_PATH);
    assertNotNull(convertedDoc);
  }

  /**
   * Test convert document.
   *
   * @throws URISyntaxException the URI syntax exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testConvertDocumentWithMediaType() throws URISyntaxException, IOException, InterruptedException {
    // Convert document with a specified media type
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expAnswer)));
    Answers convertedDoc = service.convertDocumentToAnswer(html, HttpMediaType.TEXT_HTML).execute();
    checkRequest(CONVERT_DOCUMENT_PATH);
    assertNotNull(convertedDoc);
  }

  /**
   * Test convert document_with_custom_config.
   *
   * @throws Exception the exception
   */
  @Test
  public void testConvertDocumentWithCustomConfig() throws Exception {
    JsonObject customConfig = ConversionUtils.loadCustomConfig(new FileInputStream(RESOURCE + "custom_config.json"));
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expAnswer)));
    service.convertDocumentToAnswer(html, null, customConfig).execute();
    checkRequest(CONVERT_DOCUMENT_PATH);
  }

  /**
   * Test convert document_with_version_date.
   *
   * @throws Exception the exception
   */
  @Test
  public void testConvertDocumentWithVersionDate() throws Exception {
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expAnswer)));
    service.convertDocumentToAnswer(html).execute();
    checkRequest(CONVERT_DOCUMENT_PATH);
  }

  /**
   * Test index document.
   *
   * @throws Exception the exception
   */
  @Test
  public void testIndexDocument() throws Exception {
    IndexDocumentOptions indexDocumentOptions =
        new IndexDocumentOptions.Builder().document(html).dryRun(false).indexConfiguration(indexConfiguration).build();
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expIndexResponse)));
    service.indexDocument(indexDocumentOptions).execute();
    checkRequest(INDEX_DOCUMENT_PATH);
  }

  /**
   * Test index document with fields.
   *
   * @throws Exception the exception
   */
  @Test
  public void testIndexDocumentWithFields() throws Exception {
    IndexDocumentOptions indexDocumentOptions = new IndexDocumentOptions.Builder().document(html).dryRun(false)
        .indexConfiguration(indexConfigWithFields).build();
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expIndexResponse)));
    service.indexDocument(indexDocumentOptions).execute();
    checkRequest(INDEX_DOCUMENT_PATH);
  }

  /**
   * Test a dry run of index document with metadata.
   *
   * @throws Exception the exception
   */
  @Test
  public void testIndexDocumentDryRun() throws Exception {
    Map<String, String> metadata = new HashMap<String, String>();
    metadata.put("id", "123");
    metadata.put("SomeMetadataName", "SomeMetadataValue");
    IndexDocumentOptions indexDocumentOptions =
        new IndexDocumentOptions.Builder().document(html).metadata(metadata).dryRun(true).build();
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expIndexDryRunResponse)));
    service.indexDocument(indexDocumentOptions).execute();
    checkRequest(INDEX_DOCUMENT_PATH);
  }

  /**
   * Test a dry run of index document with metadata and index fields.
   *
   * @throws Exception the exception
   */
  @Test
  public void testIndexDocumentWithFieldsDryRun() throws Exception {
    Map<String, String> metadata = new HashMap<String, String>();
    metadata.put("id", "123");
    metadata.put("SomeMetadataName", "SomeMetadataValue");
    IndexDocumentOptions indexDocumentOptions = new IndexDocumentOptions.Builder().document(html).metadata(metadata)
        .dryRun(true).indexConfiguration(indexConfigWithFieldsForDryRun).build();
    server.enqueue(new MockResponse().setBody(new Buffer().readFrom(expIndexDryRunResponse)));
    service.indexDocument(indexDocumentOptions).execute();
    RecordedRequest request = checkRequest(INDEX_DOCUMENT_PATH);
    String body = request.getBody().readUtf8();

    // config
    assertTrue(body.contains("Content-Disposition: form-data; name=\"config\""));
    assertTrue(body.contains("{\"retrieve_and_rank\":{\"dry_run\":true,\"fields\":{\"include\":"
        + "[\"SomeMetadataName\",\"id\",\"Created By\",\"Created On\"]}}}"));

    // file
    assertTrue(body.contains("Content-Disposition: form-data; name=\"file\""));
    assertTrue(body.contains("Content-Type: text/html"));

    // metadata
    assertTrue(body.contains("Content-Disposition: form-data; name=\"metadata\""));
    assertTrue(body.contains("{\"metadata\""));
    assertTrue(body.contains("{\"name\":\"id\",\"value\":\"123\"}"));
    assertTrue(body.contains("{\"name\":\"SomeMetadataName\",\"value\":\"SomeMetadataValue\"}"));
  }
}
