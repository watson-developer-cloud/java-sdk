/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.service;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
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
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ErrorResponseTest extends WatsonServiceUnitTest {

  public class TestService extends WatsonService {

    private static final String SERVICE_NAME = "test";

    public TestService() {
      super(SERVICE_NAME);
    }

    public ServiceCall<GenericModel> testMethod() {
      RequestBuilder builder = RequestBuilder.get("/v1/test");
      return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GenericModel.class));
    }
  }

  TestService service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new TestService();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test HTTP status code 400 (Bad Request) error response.
   */
  @Test
  public void testBadRequest() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(400)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof BadRequestException);
      BadRequestException ex = (BadRequestException) e;
      assertEquals(400, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 401 (Unauthorized) error response.
   */
  @Test
  public void testUnauthorized() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(401)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof UnauthorizedException);
      UnauthorizedException ex = (UnauthorizedException) e;
      assertEquals(401, ex.getStatusCode());
      assertTrue(ex.getMessage().startsWith("Unauthorized: Access is denied due to invalid credentials."));
    }
  }

  /**
   * Test HTTP status code 403 (Forbidden) error response.
   */
  @Test
  public void testForbidden() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(403)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof ForbiddenException);
      ForbiddenException ex = (ForbiddenException) e;
      assertEquals(403, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 404 (NotFound) error response.
   */
  @Test
  public void testNotFound() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(404)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof NotFoundException);
      NotFoundException ex = (NotFoundException) e;
      assertEquals(404, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 409 (Conflict) error response.
   */
  @Test
  public void testConflict() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(409)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof ConflictException);
      ConflictException ex = (ConflictException) e;
      assertEquals(409, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 413 (RequestTooLarge) error response.
   */
  @Test
  public void testRequestTooLarge() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(413)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof RequestTooLargeException);
      RequestTooLargeException ex = (RequestTooLargeException) e;
      assertEquals(413, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 415 (Unsupported Media Type) error response.
   */
  @Test
  public void testUnsupported() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(415)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof UnsupportedException);
      UnsupportedException ex = (UnsupportedException) e;
      assertEquals(415, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 429 (TooManyRequests) error response.
   */
  @Test
  public void testTooManyRequests() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(429)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof TooManyRequestsException);
      TooManyRequestsException ex = (TooManyRequestsException) e;
      assertEquals(429, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 500 (InternalServerError) error response.
   */
  @Test
  public void testInternalServerError() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(500)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof InternalServerErrorException);
      InternalServerErrorException ex = (InternalServerErrorException) e;
      assertEquals(500, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }

  /**
   * Test HTTP status code 503 (ServiceUnavailable) error response.
   */
  @Test
  public void testServiceUnavailable() {

    String message = "The request failed because the moon is full.";
    server.enqueue(new MockResponse()
        .setResponseCode(503)
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody("{\"error\": \"" + message + "\"}"));

    try {
      GenericModel response = service.testMethod().execute();
    } catch (Exception e) {
      assertTrue(e instanceof ServiceUnavailableException);
      ServiceUnavailableException ex = (ServiceUnavailableException) e;
      assertEquals(503, ex.getStatusCode());
      assertEquals(message, ex.getMessage());
    }
  }
}
