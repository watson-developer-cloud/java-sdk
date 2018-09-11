/**
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.Response;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallbackWithDetails;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import jersey.repackaged.jsr166e.CompletableFuture;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;

public class ResponseTest extends WatsonServiceUnitTest {

  private class TestModel extends GenericModel { }

  public class TestService extends WatsonService {

    private static final String SERVICE_NAME = "test";

    public TestService() {
      super(SERVICE_NAME);
    }

    public ServiceCall<TestModel> testMethod() {
      RequestBuilder builder = RequestBuilder.get(HttpUrl.parse(getEndPoint() + "/v1/test"));
      return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TestModel.class));
    }
  }

  private TestService service;

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
    service.setUsernameAndPassword("", "");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test that all fields are populated when calling executeWithDetails().
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testExecuteWithDetails() throws InterruptedException {
    server.enqueue(new MockResponse().setBody("{\"test_key\": \"test_value\"}"));

    Response<TestModel> response = service.testMethod().executeWithDetails();
    assertNotNull(response.getResult());
    assertNotNull(response.getHeaders());
  }

  /**
   * Test that all fields are populated when calling enqueueWithDetails().
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testEnqueueWithDetails() throws InterruptedException {
    server.enqueue(new MockResponse().setBody("{\"test_key\": \"test_value\"}"));

    service.testMethod().enqueueWithDetails(new ServiceCallbackWithDetails<TestModel>() {
      @Override
      public void onResponse(Response<TestModel> response) {
        assertNotNull(response.getResult());
        assertNotNull(response.getHeaders());
      }

      @Override
      public void onFailure(Exception e) { }
    });
  }

  /**
   * Test that all fields are populated when calling rxWithDetails() using a callback.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRxWithDetailsCallback() throws InterruptedException {
    server.enqueue(new MockResponse().setBody("{\"test_key\": \"test_value\"}"));

    service.testMethod().rxWithDetails().thenAccept(new CompletableFuture.Action<Response<TestModel>>() {
      @Override
      public void accept(Response<TestModel> response) {
        assertNotNull(response.getResult());
        assertNotNull(response.getHeaders());
      }
    });
  }

  /**
   * Test that all fields are populated when calling rxWithDetails() using an asynchronous callback.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRxWithDetailsAsync() throws InterruptedException {
    server.enqueue(new MockResponse().setBody("{\"test_key\": \"test_value\"}"));

    service.testMethod().rxWithDetails().thenAcceptAsync(new CompletableFuture.Action<Response<TestModel>>() {
      @Override
      public void accept(Response<TestModel> response) {
        assertNotNull(response.getResult());
        assertNotNull(response.getHeaders());
      }
    });
  }

  /**
   * Test that all fields are populated when calling rxWjthDetails() synchronously.
   *
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  @Test
  public void testRxWithDetailsSync() throws InterruptedException, ExecutionException {
    server.enqueue(new MockResponse().setBody("{\"test_key\": \"test_value\"}"));

    Response<TestModel> response = service.testMethod().rxWithDetails().get();
    assertNotNull(response.getResult());
    assertNotNull(response.getHeaders());
  }
}
