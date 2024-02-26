/*
 * (C) Copyright IBM Corp. 2019, 2024.
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
package com.ibm.watson.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;

/** The Class WatsonServiceUnitTest. */
public class WatsonServiceUnitTest extends WatsonServiceTest {
  /** The Constant DELETE. */
  protected static final String DELETE = "DELETE";

  /** The Constant GET. */
  protected static final String GET = "GET";

  /** The Constant POST. */
  protected static final String POST = "POST";

  /** The Constant PUT. */
  protected static final String PUT = "PUT";

  private static final Gson GSON = GsonSingleton.getGson();

  /** The server. */
  protected MockWebServer server;

  /**
   * Setups and starts the mock server.
   *
   * @throws Exception the exception
   */
  @Override
  public void setUp() throws Exception {
    server = new MockWebServer();
    server.start();
  }

  /**
   * Tear down.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @After
  public void tearDown() throws IOException {
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
   * Create a MockResponse with JSON content type and the object serialized to JSON as body.
   *
   * @param body the body
   * @return the mock response
   */
  protected static MockResponse jsonResponse(Object body) {
    return new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(body));
  }

  /**
   * Create a MockResponse with JSON content type and the object serialized to JSON as body. For
   * HashMaps
   *
   * @param body the body
   * @return the mock response
   */
  protected static MockResponse hashmapToJsonResponse(Object body) {
    Type typeObject = new TypeToken<HashMap>() {}.getType();
    return new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(body, typeObject));
  }
}
