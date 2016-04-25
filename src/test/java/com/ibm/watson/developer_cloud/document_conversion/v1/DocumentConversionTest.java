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
import static org.apache.commons.io.IOUtils.toByteArray;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;

/**
 * Document Conversion unit tests.
 */
public class DocumentConversionTest extends WatsonServiceUnitTest {

  private static final String VERSION = "version";
  private static final String CONVERT_DOCUMENT_PATH = "/v1/convert_document";
  private static final String RESOURCE = "src/test/resources/document_conversion/";

  private DocumentConversion service;

  private final File html;
  private final byte[] expAnswer;

  /**
   * Instantiates a new document conversion test.
   * 
   * @throws Exception the exception
   */
  public DocumentConversionTest() throws Exception {
    html = new File(RESOURCE + "html-with-extra-content-input.htm");
    expAnswer =
        toByteArray(new FileInputStream(RESOURCE + "html-with-extra-content-input-to-answer.json"));
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
    service.setEndPoint(MOCK_SERVER_URL);

    // mock the convert request for all the tests methods
    mockServer.when(
        request().withMethod(POST).withPath(CONVERT_DOCUMENT_PATH)
            .withQueryStringParameter(VERSION, DocumentConversion.VERSION_DATE_2015_12_01))
        .respond(response().withBody(expAnswer));
  }

  /**
   * Test convert document.
   * 
   * @throws URISyntaxException the URI syntax exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testConvertDocument() throws URISyntaxException, IOException {
    Answers convertedDoc = service.convertDocumentToAnswer(html, null).execute();
    assertNotNull(convertedDoc);

    // Convert document with a specified media type
    convertedDoc = service.convertDocumentToAnswer(html, TEXT_HTML).execute();
    assertNotNull(convertedDoc);
  }

  /**
   * Test convert document_with_custom_config.
   * 
   * @throws Exception the exception
   */
  @Test
  public void testConvertDocument_with_custom_config() throws Exception {
    JsonObject customConfig = ConversionUtils.loadCustomConfig(new FileInputStream(RESOURCE + "custom_config.json"));
    service.convertDocumentToAnswer(html, null, customConfig).execute();

    String entity = getRequestEntity();
    assertTrue(entity.contains("\"word\":"));
    assertTrue(entity.contains("\"conversion_target\":"));
  }

  /**
   * Test convert document_with_version_date.
   * 
   * @throws Exception the exception
   */
  @Test
  public void testConvertDocument_with_version_date() throws Exception {
    service.convertDocumentToAnswer(html).execute();
    mockServer.verify(request().withMethod(POST).withPath(CONVERT_DOCUMENT_PATH)
        .withQueryStringParameter(VERSION, DocumentConversion.VERSION_DATE_2015_12_01));
  }

  private String getRequestEntity() {
    String request =
        mockServer.retrieveAsJSON(request().withMethod(POST).withPath(CONVERT_DOCUMENT_PATH));
    JsonObject requestAsJson =
        new JsonParser().parse(request).getAsJsonArray().get(0).getAsJsonObject();
    return requestAsJson.getAsJsonObject("httpRequest").getAsJsonPrimitive("body").getAsString();
  }
}
