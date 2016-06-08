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

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.service.exception.ConflictException;
import com.ibm.watson.developer_cloud.service.exception.ForbiddenException;
import com.ibm.watson.developer_cloud.service.exception.InternalServerErrorException;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.service.exception.RequestTooLargeException;
import com.ibm.watson.developer_cloud.service.exception.ServiceUnavailableException;
import com.ibm.watson.developer_cloud.service.exception.TooManyRequestsException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.service.exception.UnsupportedException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Generic Service Test.
 */
public class GenericServiceTest extends WatsonServiceUnitTest {
  private final static String GET_PROFILE_PATH = "/v2/profile";
  private final String sampleText = "this is a test";
  private PersonalityInsights service;

  private MockResponse errorResponse(int code, String errorMessage) {
    return jsonResponse(ImmutableMap.of("code", code, "error", errorMessage)).setResponseCode(code);
  }

  private RecordedRequest checkRequest() throws InterruptedException {
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(GET_PROFILE_PATH, request.getPath());
    return request;
  }

  /**
   * Service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void ServiceUnavailableException() {
    server.enqueue(errorResponse(503, "ServiceUnavailableException"));
    service.getProfile(sampleText).execute();
  }

  /* (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new PersonalityInsights();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test bad request exception.
   */
  @Test(expected = BadRequestException.class)
  public void testBadRequestException() {
    server.enqueue(errorResponse(400, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test service conflict exception.
   */
  @Test(expected = ConflictException.class)
  public void testConflictException() {
    server.enqueue(errorResponse(409, "Conflict Exception"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test default headers are set.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDefaultHeadersAreSet() throws InterruptedException {
    final Map<String, String> headers = new HashMap<String, String>();
    headers.put("name1", "value1");
    headers.put("name2", "value2");

    service.setDefaultHeaders(headers);

    server.enqueue(jsonResponse(Collections.emptyMap()));
    service.getProfile(sampleText).execute();
    final RecordedRequest request = checkRequest();

    assertEquals("value1", request.getHeader("name1"));
    assertEquals("value2", request.getHeader("name2"));
  }

  /**
   * Test forbidden exception.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = ForbiddenException.class)
  public void testForbiddenException() throws InterruptedException {
    server.enqueue(errorResponse(403, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test illegal argument exception.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() throws InterruptedException {
    final PersonalityInsights service = new PersonalityInsights();
    service.setEndPoint(null);
    service.getProfile(sampleText).execute();
  }

  /**
   * Test internal server error exception.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = InternalServerErrorException.class)
  public void testInternalServerErrorException() throws InterruptedException {
    server.enqueue(errorResponse(500, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test not found exception.
   */
  @Test(expected = NotFoundException.class)
  public void testNotFoundException() {
    server.enqueue(errorResponse(404, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test request too large exception.
   */
  @Test(expected = RequestTooLargeException.class)
  public void testRequestTooLargeException() {
    server.enqueue(errorResponse(413, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void testServiceUnavailableException() {
    server.enqueue(errorResponse(503, "Service Unavailable"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test too many requests exception.
   */
  @Test(expected = TooManyRequestsException.class)
  public void testTooManyRequestsException() {
    server.enqueue(errorResponse(429, "TooManyRequestsException"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test unauthorized exception.
   */
  @Test(expected = UnauthorizedException.class)
  public void testUnauthorizedException() {
    server.enqueue(errorResponse(401, "UnauthorizedException"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test unsupported exception.
   */
  @Test(expected = UnsupportedException.class)
  public void testUnsupportedException() {
    server.enqueue(errorResponse(415, "UnsupportedException"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test user agent is set.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUserAgentIsSet() throws InterruptedException {
    server.enqueue(jsonResponse(Collections.emptyMap()));
    service.getProfile(sampleText).execute();
    final RecordedRequest request = checkRequest();
    assertEquals("watson-apis-java-sdk/3.0.0-RC1", request.getHeader(HttpHeaders.USER_AGENT));
  }
  
  /**
   * Test custom user agent.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCustomUserAgent() throws InterruptedException {
    server.enqueue(jsonResponse(Collections.emptyMap()));
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(HttpHeaders.USER_AGENT, "foo-bar");
    service.setDefaultHeaders(headers);
    service.getProfile(sampleText).execute();
    final RecordedRequest request = checkRequest();
    assertEquals("watson-apis-java-sdk/3.0.0-RC1 foo-bar", request.getHeader(HttpHeaders.USER_AGENT));
    service.setDefaultHeaders(null);
  }
  
}