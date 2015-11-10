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
package com.ibm.watson.developer_cloud.service;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsightsTest;

/**
 * The Class GenericServiceTest.
 */
public class GenericServiceTest extends WatsonServiceTest {

  /** The Constant GET_PROFILE_PATH. */
  private final static String GET_PROFILE_PATH = "/v2/profile";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(PersonalityInsightsTest.class.getName());

  /** The Constant POST. */
  private static final String POST = "POST";

  /** Mock Server *. */
  private ClientAndServer mockServer;

  /** The sample text. */
  private final String sampleText = "this is a test";

  /** The service. */
  private PersonalityInsights service;

  /**
   * Mock an API call and return an error.
   * 
   * @param code the code
   * @param errorMessage the error message
   */
  private void mockAPICallWithError(int code, String errorMessage) {
    mockServer.when(request().withMethod(POST).withPath(GET_PROFILE_PATH)).respond(
        response().withStatusCode(code).withBody(
            "{\"code\":" + code + ", \"error\":\"" + errorMessage + "\"}"));
  }

  /**
   * Service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void ServiceUnavailableException() {
    mockAPICallWithError(503, "ServiceUnavailableException");
    service.getProfile(sampleText);
  }

  /**
   * Start mock server.
   */
  @Before
  public void startMockServer() {
    try {
      mockServer = startClientAndServer(Integer.parseInt(getValidProperty("mock.server.port")));
      service = new PersonalityInsights();
      service.setApiKey("");
      service.setEndPoint("http://" + getValidProperty("mock.server.host") + ":"
          + getValidProperty("mock.server.port"));
    } catch (final NumberFormatException e) {
      log.log(Level.SEVERE, "Error mocking the service", e);
    }
  }

  /**
   * Stop mock server.
   */
  @After
  public void stopMockServer() {
    mockServer.stop();
  }

  /**
   * Test bad request exception.
   */
  @Test(expected = BadRequestException.class)
  public void testBadRequestException() {
    mockAPICallWithError(400, "Bad request");
    service.getProfile(sampleText);
  }

  /**
   * Test forbidden exception.
   */
  @Test(expected = ForbiddenException.class)
  public void testForbiddenException() {
    mockAPICallWithError(403, "Bad request");
    service.getProfile(sampleText);
  }

  /**
   * Test illegal argument exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    final PersonalityInsights service = new PersonalityInsights();
    service.setEndPoint(null);
    service.getProfile(sampleText);
  }

  /**
   * Test internal server error exception.
   */
  @Test(expected = InternalServerErrorException.class)
  public void testInternalServerErrorException() {
    mockAPICallWithError(500, "Bad request");
    service.getProfile(sampleText);
  }

  /**
   * Test not found exception.
   */
  @Test(expected = NotFoundException.class)
  public void testNotFoundException() {
    mockAPICallWithError(404, "Bad request");
    service.getProfile(sampleText);
  }

  /**
   * Test request too large exception.
   */
  @Test(expected = RequestTooLargeException.class)
  public void testRequestTooLargeException() {
    mockAPICallWithError(413, "Bad request");
    service.getProfile(sampleText);
  }

  /**
   * Test service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void testServiceUnavailableException() {
    mockAPICallWithError(503, "Service Unavailable");
    service.getProfile(sampleText);
  }

  /**
   * Test too many requests exception.
   */
  @Test(expected = TooManyRequestsException.class)
  public void testTooManyRequestsException() {
    mockAPICallWithError(429, "TooManyRequestsException");
    service.getProfile(sampleText);
  }

  /**
   * Test unauthorized exception.
   */
  @Test(expected = UnauthorizedException.class)
  public void testUnauthorizedException() {
    mockAPICallWithError(401, "UnauthorizedException");
    service.getProfile(sampleText);
  }

  /**
   * Test unsupported exception.
   */
  @Test(expected = UnsupportedException.class)
  public void testUnsupportedException() {
    mockAPICallWithError(415, "UnsupportedException");
    service.getProfile(sampleText);
  }

}
