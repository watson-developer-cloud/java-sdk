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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okio.Buffer;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.util.RequestUtil;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

/**
 * The Class RequestBuilderTest.
 */
public class RequestBuilderTest {

  /** The url. */
  private final String url = "http://www.example.com/";

  /** The url with query. */
  private final String urlWithQuery = url + "?foo=bar&p2=p2";

  /**
   * Test build.
   */
  @Test
  public void testBuild() {
    final String xToken = "x-token";
    final Request request =
        RequestBuilder.post(urlWithQuery).withBodyContent("body1", HttpMediaType.TEXT_PLAIN)
            .withHeader("x-token", "token1").build();

    assertEquals("POST", request.method());
    assertEquals("token1", request.header(xToken));
  }

  /**
   * Test delete.
   */
  @Test
  public void testDelete() {
    final Request request = RequestBuilder.delete(urlWithQuery).build();
    assertEquals("DELETE", request.method());
    assertEquals(urlWithQuery, request.urlString());
  }

  /**
   * Test get.
   */
  @Test
  public void testGet() {
    final Request request = RequestBuilder.get(urlWithQuery).build();
    assertEquals("GET", request.method());
    assertEquals(urlWithQuery, request.urlString());
  }

  /**
   * Test illegal argument exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    RequestBuilder.delete(null);
  }

  /**
   * Test illegal argument exception even numbers.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentExceptionEvenNumbers() {
    RequestBuilder.put(url).withForm("1", "2", "3").build();
  }


  /**
   * Test post.
   */
  @Test
  public void testPost() {
    final Request request = RequestBuilder.post(url).build();
    assertEquals("POST", request.method());
    assertEquals(url, request.urlString());
  }

  /**
   * Test put.
   */
  @Test
  public void testPut() {
    final Request request = RequestBuilder.put(urlWithQuery).build();
    assertEquals("PUT", request.method());
    assertEquals(urlWithQuery, request.urlString());
  }

  /**
   * Test using path url.
   */
  @Test
  public void testUsingPathUrl() {
    final String url = "/v1/ping";
    final Request request = RequestBuilder.get(url).build();
    assertEquals("GET", request.method());
    assertTrue(RequestUtil.isRelative(request));
    assertEquals(url, HttpUrl.parse(request.urlString()).encodedPath());
  }

  /**
   * Test with body.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testWithBody() throws IOException {
    final File test = new File("src/test/resources/car.png");

    final Request request =
        RequestBuilder.post(urlWithQuery)
            .withBody(RequestBody.create(HttpMediaType.BINARY_FILE, test)).build();

    final RequestBody requestedBody = request.body();

    assertEquals(test.length(), requestedBody.contentLength());
    assertEquals(HttpMediaType.BINARY_FILE, requestedBody.contentType());
  }

  /**
   * Test with body JSON object.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testWithBodyJsonJsonObject() throws IOException {
    final JsonObject json = new JsonObject();
    json.addProperty("status", "ok");
    final Request request = RequestBuilder.post(urlWithQuery).withBodyJson(json).build();

    final RequestBody requestedBody = request.body();
    final Buffer buffer = new Buffer();
    requestedBody.writeTo(buffer);

    assertEquals(json.toString(), buffer.readUtf8());
    assertEquals(HttpMediaType.JSON, requestedBody.contentType());
  }

  /**
   * Test with content string.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testWithContentString() throws IOException {
    final String body = "test2";
    final Request request =
        RequestBuilder.post(urlWithQuery).withBodyContent(body, HttpMediaType.TEXT_PLAIN).build();

    final RequestBody requestedBody = request.body();
    final Buffer buffer = new Buffer();
    requestedBody.writeTo(buffer);

    assertEquals(body, buffer.readUtf8());
    assertEquals(HttpMediaType.TEXT, requestedBody.contentType());

  }

  /**
   * Test with form map of string object.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testWithFormMapOfStringObject() throws IOException {
    final String body = "p2=p2&foo=bar";

    final Map<String, Object> formParams = new HashMap<String, Object>();
    formParams.put("p2", "p2");
    formParams.put("foo", "bar");

    final Request request = RequestBuilder.post(url).withFormMap(formParams).build();
    final RequestBody requestedBody = request.body();
    final Buffer buffer = new Buffer();
    requestedBody.writeTo(buffer);

    assertEquals(body, buffer.readUtf8());
    assertEquals(MediaType.parse(HttpMediaType.APPLICATION_FORM_URLENCODED),
        requestedBody.contentType());

  }

  /**
   * Test with form object array.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testWithFormObjectArray() throws IOException {
    final String body = "foo=bar&test1=test2";
    final Request request =
        RequestBuilder.post(urlWithQuery).withForm("foo", "bar", "test1", "test2").build();

    final RequestBody requestedBody = request.body();

    final Buffer buffer = new Buffer();
    requestedBody.writeTo(buffer);

    assertEquals(body, buffer.readUtf8());
    assertEquals(MediaType.parse(HttpMediaType.APPLICATION_FORM_URLENCODED),
        requestedBody.contentType());
  }

  /**
   * Test with query map of string object.
   */
  @Test
  public void testWithQueryMapOfStringObject() {
    final Map<String, Object> queryParams = new HashMap<String, Object>();
    queryParams.put("p2", "p2");
    queryParams.put("foo", "bar");


    final Request request = RequestBuilder.post(url).withQueryMap(queryParams).build();

    assertEquals("p2=p2&foo=bar", request.httpUrl().query());
  }

  /**
   * Test with query object array.
   */
  @Test
  public void testWithQueryObjectArray() {
    final Request request = RequestBuilder.post(url).withQuery("foo", "bar", "p2", "p2").build();
    assertEquals(urlWithQuery, request.urlString());
  }

}
