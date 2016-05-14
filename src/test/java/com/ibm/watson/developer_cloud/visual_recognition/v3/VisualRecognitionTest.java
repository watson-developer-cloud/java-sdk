/*
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
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class VisualRecognitionTest extends WatsonServiceUnitTest {

  private static final String EMPTY = "";
  private static final String FIXTURE = "src/test/resources/visual_recognition/visual_classification.json";
  private static final String IMAGE_FACE_FILE = "src/test/resources/visual_recognition/faces.zip";
  private static final String IMAGE_FACE_URL = "https://watson-test-resources.mybluemix.net/resources/obama.jpg";
  private static final String IMAGE_FILE = "src/test/resources/visual_recognition/test.zip";
  private static final String IMAGE_TEXT_FILE = "src/test/resources/visual_recognition/open.png";
  private static final String IMAGE_TEXT_URL = "https://watson-test-resources.mybluemix.net/resources/open.png";
  private static final String IMAGE_URL = "https://watson-test-resources.mybluemix.net/resources/car.png";
  private static final String PATH_CLASSIFY = "/v3/classify";
  private static final String VERSION_DATE = "version";


  /**
   * Test classify with file.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testClassifyWithFile() throws IOException, InterruptedException {
    MockWebServer server = new MockWebServer();

    VisualClassification mockResponse = loadFixture(FIXTURE, VisualClassification.class);
    server.enqueue(new MockResponse().setBody(mockResponse.toString()));

    server.start();

    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey(EMPTY);
    service.setEndPoint(getMockWebServerUrl(server));

    // execute request
    File images = new File(IMAGE_FILE);
    ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(images).build();
    VisualClassification serviceResponse = service.classify(options).execute();

    // first request
    RecordedRequest request = server.takeRequest();

    String path = StringUtils.join(PATH_CLASSIFY, "?", VERSION_DATE, "=", VisualRecognition.VERSION_DATE_2016_05_19);
    assertEquals(path, request.getPath());
    assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
    assertEquals(serviceResponse, mockResponse);
    assertEquals(HttpMediaType.APPLICATION_JSON, request.getHeader(HttpHeaders.ACCEPT));

    // Shut down the server.
    server.shutdown();
  }

  @Test
  public void testCreateClassifier() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testDeleteClassifier() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testDetectFaces() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testGetClassifier() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testGetClassifiers() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testRecognizeText() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testSetUsernameAndPassword() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testVisualRecognition() {
    fail("Not yet implemented"); // TODO
  }

}
