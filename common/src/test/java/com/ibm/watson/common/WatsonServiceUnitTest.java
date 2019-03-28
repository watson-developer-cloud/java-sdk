package com.ibm.watson.common;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;

import java.io.IOException;

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
    return new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(body));
  }
}
