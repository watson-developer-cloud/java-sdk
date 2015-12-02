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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.ibm.watson.developer_cloud.http.HttpMediaType.TEXT_HTML;
import static org.apache.commons.io.IOUtils.toByteArray;
import static org.junit.Assert.*;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * The Class DocumentConversionTest.
 */
public class DocumentConversionTest extends WatsonServiceTest {

  /** The CONVERT_DOCUMENT_PATH. (value is "/v1/convert_document") */
  private static final String CONVERT_DOCUMENT_PATH = "/v1/convert_document";

  private static final Logger log = Logger.getLogger(DocumentConversionTest.class.getName());

  private ClientAndServer mockServer;
  private DocumentConversion service;

  private final File html;
  private final byte[] expAnswer;

  public DocumentConversionTest() throws Exception {
    html = new File(getClass().getResource("/document_conversion/html-with-extra-content-input.htm").toURI());
    expAnswer = toByteArray(getClass().getResourceAsStream("/document_conversion/html-with-extra-content-input-to-answer.json"));
  }

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
  }

  @Before
  public void startMockServer() {
    try {
      mockServer = startClientAndServer(Integer.parseInt(getValidProperty("mock.server.port")));
      service = new DocumentConversion();
      configureService();
    } catch (final NumberFormatException e) {
      log.log(Level.SEVERE, "Error mocking the service", e);
    }

    mockServer.when(request().withMethod("POST").withPath(CONVERT_DOCUMENT_PATH))
            .respond(response().withBody(expAnswer));
  }

  private void configureService() {
    service.setApiKey("");
    service.setEndPoint("http://" + getValidProperty("mock.server.host") + ":"
        + getValidProperty("mock.server.port"));
  }

  @After
  public void stopMockServer() {
    mockServer.stop();
  }

  @Test
  public void testConvertDocument() throws URISyntaxException, IOException {
    Answers convertedDoc = service.convertDocumentToAnswer(html, null);
    assertNotNull(convertedDoc);

    // Convert document with a specified media type
    convertedDoc = service.convertDocumentToAnswer(html, TEXT_HTML);
    assertNotNull(convertedDoc);
  }

  @Test
  public void testConvertDocument_with_custom_config() throws Exception {
    JsonObject customConfig = loadCustomConfig();
    service.convertDocumentToAnswer(html, null, customConfig);

    String entity = getRequestEntity();
    assertTrue(entity.contains("\"word\":"));
    assertTrue(entity.contains("\"conversion_target\":"));
  }

  @Test
  public void testConvertDocument_with_version_date() throws Exception {
    service = new DocumentConversion("2015-11-01");
    configureService();

    service.convertDocumentToAnswer(html);

    mockServer.verify(request()
            .withMethod("POST")
            .withPath(CONVERT_DOCUMENT_PATH)
            .withQueryStringParameter("version", "2015-11-01"));
  }

  private String getRequestEntity() {
    String request = mockServer.retrieveAsJSON(request().withMethod("POST").withPath(CONVERT_DOCUMENT_PATH));
    JsonObject requestAsJson = new JsonParser().parse(request).getAsJsonArray().get(0).getAsJsonObject();
    return requestAsJson.getAsJsonObject("httpRequest").getAsJsonPrimitive("body").getAsString();
  }

  private JsonObject loadCustomConfig() {
    Reader reader = new InputStreamReader(getClass().getResourceAsStream("/document_conversion/custom_config.json"));
    return new JsonParser().parse(reader).getAsJsonObject();
  }
}
