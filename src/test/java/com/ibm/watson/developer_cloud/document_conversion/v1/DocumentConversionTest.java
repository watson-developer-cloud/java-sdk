/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1;

import static com.ibm.watson.developer_cloud.http.HttpMediaType.TEXT_HTML;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;

/**
 * Document Conversion unit tests.
 */
@SuppressWarnings("resource")
public class DocumentConversionTest extends WatsonServiceUnitTest {

  private static final String VERSION = "version";
  private static final String CONVERT_DOCUMENT_PATH = "/v1/convert_document";
  private static final String RESOURCE = "src/test/resources/document_conversion/";

  private DocumentConversion service;

  private final File html;
  private InputStream expAnswer;

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
  }

  private RecordedRequest checkRequest() throws InterruptedException {
    final RecordedRequest request = server.takeRequest();
    final HttpUrl url = HttpUrl.parse(getMockWebServerUrl() + request.getPath());

    assertEquals(CONVERT_DOCUMENT_PATH, url.encodedPath());
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
    checkRequest();
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
    Answers convertedDoc = service.convertDocumentToAnswer(html, TEXT_HTML).execute();
    checkRequest();
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
    checkRequest();
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
    checkRequest();
  }
}
