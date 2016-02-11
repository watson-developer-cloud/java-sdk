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

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;

/**
 * Generic Service Test.
 */
public class GenericServiceTest extends WatsonServiceUnitTest {
  private final static String GET_PROFILE_PATH = "/v2/profile";
  private final String sampleText = "this is a test";
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
   * Mock a successful PersonalityInsights call.
   */
  private void mockAPICall() {
    mockServer.when(request().withMethod(POST).withPath(GET_PROFILE_PATH)).respond(
        response().withStatusCode(200).withBody("{}"));
  }

  /**
   * Service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void ServiceUnavailableException() {
    mockAPICallWithError(503, "ServiceUnavailableException");
    service.getProfile(sampleText);
  }

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new PersonalityInsights();
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);
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
   * Test service conflict exception.
   */
  @Test(expected = ConflictException.class)
  public void testConflictException() {
    mockAPICallWithError(409, "Conflict Exception");
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

  @Test
  public void testUserAgentIsSet() {
    mockAPICall();
    service.getProfile(sampleText);
    mockServer.verify(new HttpRequest().withMethod("POST").withHeader(
        new Header(HttpHeaders.USER_AGENT, "watson-developer-cloud-java-sdk-2.8.0")));
  }

  @Test
  public void testDefaultHeadersAreSet() {
    final Map<String, String> headers = new HashMap<String, String>();
    headers.put("name1", "value1");
    headers.put("name2", "value2");

    final Header expectedHeader1 = new Header("name1", "value1");
    final Header expectedHeader2 = new Header("name2", "value2");

    service.setDefaultHeaders(headers);
    mockAPICall();
    service.getProfile(sampleText);
    mockServer.verify(new HttpRequest().withMethod(POST).withHeader(expectedHeader1)
        .withHeader(expectedHeader2));
  }
}
