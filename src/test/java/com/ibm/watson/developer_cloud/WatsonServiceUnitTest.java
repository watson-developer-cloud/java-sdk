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
package com.ibm.watson.developer_cloud;

import static com.ibm.watson.developer_cloud.http.HttpHeaders.CONTENT_TYPE;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Utility class to Mock the Watson Services.
 * 
 */
public abstract class WatsonServiceUnitTest extends WatsonServiceTest {

  /** The Constant APPLICATION_JSON. */
  protected static final Header APPLICATION_JSON = new Header(CONTENT_TYPE,
      HttpMediaType.APPLICATION_JSON);
  
  /** The Constant TEXT_PLAIN. */
  protected static final Header TEXT_PLAIN = new Header(CONTENT_TYPE,
      HttpMediaType.TEXT.toString());

  /** The Constant DELETE. */
  protected static final String DELETE = "DELETE";
  
  /** The Constant GET. */
  protected static final String GET = "GET";
  
  /** The Constant POST. */
  protected static final String POST = "POST";
  
  /** The Constant PUT. */
  protected static final String PUT = "PUT";

  /** The Constant MOCK_SERVER_PORT. */
  protected static final int MOCK_SERVER_PORT = 9898;
  
  /** The Constant MOCK_SERVER_URL. */
  protected static final String MOCK_SERVER_URL = "http://localhost:" + MOCK_SERVER_PORT;

  private static final Gson GSON = GsonSingleton.getGson();

  protected MockWebServer server;

  @Deprecated // use OkHttp's MockWebServer instead (see #316)
  protected ClientAndServer mockServer;

  /**
   * Setups and starts the mock server.
   * 
   * @throws Exception the exception
   */
  @Override
  public void setUp() throws Exception {
    mockServer = ClientAndServer.startClientAndServer(MOCK_SERVER_PORT);

    server = new MockWebServer();
    server.start();
  }

  @After
  public void tearDown() throws IOException {
    if (mockServer != null)
      mockServer.stop();

    server.shutdown();
  }

  /**
   * Gets the mock web server url.
   *
   * @return the server url
   */
  protected String getMockWebServerUrl() {
    return StringUtils.chop(server.url("/").toString());
  }

  /**
   * Create a MockResponse with JSON content type and the object serialized to JSON as body
   *
   * @param body
   * @return
   */
  protected static MockResponse jsonResponse(Object body) {
    return new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(body));
  }

}
