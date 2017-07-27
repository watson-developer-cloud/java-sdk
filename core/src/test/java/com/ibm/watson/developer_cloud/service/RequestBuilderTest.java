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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.util.RequestUtils;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

/**
 * The Class RequestBuilderTest.
 */
public class RequestBuilderTest {

  private static final String X_TOKEN = "x-token";

  /** The url. */
  private final String url = "http://www.example.com/";

  /** The url with query. */
  private final String urlWithQuery = url + "?foo=bar&p2=p2";

  /**
   * Test build.
   */
  @Test
  public void testBuild() {
    final String xToken = X_TOKEN;
    final RequestBuilder builder =
        RequestBuilder.post(urlWithQuery).bodyContent("body1", HttpMediaType.TEXT_PLAIN).header(X_TOKEN, "token1");
    final Request request = builder.build();

    assertEquals("POST", request.method());
    assertEquals("token1", request.header(xToken));
    assertNotNull(builder.toString());
  }

  /**
   * Test request with null url.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUrlNull() {
    RequestBuilder.get(null);
  }

  /**
   * Test delete.
   */
  @Test
  public void testDelete() {
    final Request request = RequestBuilder.delete(urlWithQuery).build();
    assertEquals("DELETE", request.method());
    assertEquals(urlWithQuery, request.url().toString());
  }

  /**
   * Test get.
   */
  @Test
  public void testGet() {
    final Request request = RequestBuilder.get(urlWithQuery).build();
    assertEquals("GET", request.method());
    assertEquals(urlWithQuery, request.url().toString());
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
    RequestBuilder.put(url).form("1", "2", "3").build();
  }


  /**
   * Test post.
   */
  @Test
  public void testPost() {
    final Request request = RequestBuilder.post(url).build();
    assertEquals("POST", request.method());
    assertEquals(url, request.url().toString());
  }

  /**
   * Test put.
   */
  @Test
  public void testPut() {
    final Request request = RequestBuilder.put(urlWithQuery).build();
    assertEquals("PUT", request.method());
    assertEquals(urlWithQuery, request.url().toString());
  }

  /**
   * Test using path url.
   */
  @Test
  public void testUsingPathUrl() {
    final String url = "/v1/ping";
    final Request request = RequestBuilder.get(url).build();
    assertEquals("GET", request.method());
    assertTrue(RequestUtils.isRelative(request));
    assertEquals(url, HttpUrl.parse(request.url().toString()).encodedPath());
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
        RequestBuilder.post(urlWithQuery).body(RequestBody.create(HttpMediaType.BINARY_FILE, test)).build();

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
    final Request request = RequestBuilder.post(urlWithQuery).bodyJson(json).build();

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
    final Request request = RequestBuilder.post(urlWithQuery).bodyContent(body, HttpMediaType.TEXT_PLAIN).build();

    final RequestBody requestedBody = request.body();
    final Buffer buffer = new Buffer();
    requestedBody.writeTo(buffer);

    assertEquals(body, buffer.readUtf8());
    assertEquals(HttpMediaType.TEXT, requestedBody.contentType());

  }

  /**
   * Test with form object array.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testWithFormObjectArray() throws IOException {
    final String body = "foo=bar&test1=test2";
    final Request request = RequestBuilder.post(urlWithQuery).form("foo", "bar", "test1", "test2").build();

    final RequestBody requestedBody = request.body();

    final Buffer buffer = new Buffer();
    requestedBody.writeTo(buffer);

    assertEquals(body, buffer.readUtf8());
    assertEquals(MediaType.parse(HttpMediaType.APPLICATION_FORM_URLENCODED), requestedBody.contentType());
  }

  /**
   * Test with query object array.
   */
  @Test
  public void testWithQueryObjectArray() {
    final Request request = RequestBuilder.post(url).query("foo", "bar", "p2", "p2").build();
    assertEquals(urlWithQuery, request.url().toString());
  }

  /**
   * Test with nested arrays.
   */
  @Test
  public void testWithNestedArray() {
    Request request = RequestBuilder.post(url).query("foo", new String[] { "bar", "bar2" }).build();
    assertEquals(url + "?foo=bar&foo=bar2", request.url().toString());

    request = RequestBuilder.post(url).query("foo", Arrays.asList("bar", "bar2")).build();
    assertEquals(url + "?foo=bar&foo=bar2", request.url().toString());
  }

  /**
   * Test requests with special characters in the query string.
   */
  @Test
  public void testSpecialCharacterQuery() {
    final Request request = RequestBuilder.get(url).query("ä&ö", "ö=ü").build();
    assertEquals(url + "?%C3%A4%26%C3%B6=%C3%B6%3D%C3%BC", request.url().toString());
  }

  /**
   * Test user agent.
   */
  @Test
  public void testUserAgent() {
    assertNotNull(RequestUtils.getUserAgent());
    assertTrue(RequestUtils.getUserAgent().startsWith("watson-apis-java-sdk/"));
  }

}
