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
package com.ibm.watson.developer_cloud.http;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Convenience class for constructing HTTP/HTTPS requests.
 */
public class RequestBuilder {

  private enum HTTPMethod {
    DELETE, GET, POST, PUT
  }

  /**
   * The DELETE method requests that the origin server delete the resource identified by the Request-URI.
   *
   * @param url the URL
   *
   * @return this
   */
  public static RequestBuilder delete(String url) {
    return new RequestBuilder(HTTPMethod.DELETE, url);
  }

  /**
   * The GET method means retrieve whatever information (in the form of an entity) is identified by the Request-URI.
   *
   * @param url the URL
   *
   * @return this
   */
  public static RequestBuilder get(String url) {
    return new RequestBuilder(HTTPMethod.GET, url);
  }

  /**
   * The POST request method is designed to request that a web server accept the data enclosed in the request message's
   * body for storage. It is often used when uploading a file or submitting a completed web form.
   *
   * @param url the URL
   *
   * @return this
   */
  public static RequestBuilder post(String url) {
    return new RequestBuilder(HTTPMethod.POST, url);
  }

  /**
   * The PUT method requests that the enclosed entity be stored under the supplied Request-URI.
   *
   * @param url the URL
   *
   * @return this
   */
  public static RequestBuilder put(String url) {
    return new RequestBuilder(HTTPMethod.PUT, url);
  }

  private RequestBody body;
  private HttpUrl httpUrl;
  private final List<NameValue> formParams = new ArrayList<NameValue>();
  private final List<NameValue> headers = new ArrayList<NameValue>();
  private final HTTPMethod method;
  private final List<NameValue> queryParams = new ArrayList<NameValue>();

  /**
   * Instantiates a new request.
   *
   * @param method the method, PUT, POST, GET or DELETE
   * @param url the request URL
   */
  private RequestBuilder(HTTPMethod method, String url) {
    this.method = method;
    if (url == null) {
      throw new IllegalArgumentException("url cannot be null");
    }

    // Since HttpUrl requires requires a http/s full url, add a default endpoint
    httpUrl = HttpUrl.parse(url);
    if (httpUrl == null) {
      httpUrl = HttpUrl.parse(RequestUtils.DEFAULT_ENDPOINT + url);
    }
  }

  /**
   * Adds a key/value pair.
   *
   * <pre>
   * <code>
   * Request r = new Request.get("https://foo.bar").add("singleParam", "value")
   *   .add("multiParam", new String[] { "1", "2", "3" })
   *   .add("singleParamWithOutValue", null);
   * </code>
   * </pre>
   *
   * @param params the parameters
   * @param name the parameter name
   * @param value the value to set, will be obtained via {@link String#valueOf(boolean)}. If null, only the parameter is
   *        set. It can also be a collection or array, in which case all elements are added as query parameters
   *
   * @return this
   */
  private RequestBuilder add(List<NameValue> params, String name, Object value) {
    if (value instanceof Iterable) {
      for (final Object o : (Iterable<?>) value) {
        addParam(params, name, o);
      }
    } else if (value instanceof Object[]) {
      for (final Object o : (Object[]) value) {
        addParam(params, name, o);
      }
    } else {
      addParam(params, name, value);
    }
    return this;
  }

  /**
   * Adds the name, value par to the parameter list as <b>BasicNameValue</b>.
   *
   * @param params the parameter list
   * @param name the parameter name
   * @param value the parameter value
   */
  private void addParam(List<NameValue> params, String name, Object value) {
    params.add(new NameValue(name, value == null ? null : String.valueOf(value)));
  }

  /**
   * Builds the.
   *
   * @return the request
   */
  public Request build() {
    final Request.Builder builder = new Request.Builder();
    // URL
    builder.url(toUrl());


    if (method == HTTPMethod.GET) {
      Validator.isNull(body, "cannot send a RequestBody in a GET request");
    } else if (!formParams.isEmpty()) {
      // The current behaviour of the RequestBuilder is to replace the body when formParams is
      // present
      final FormBody.Builder formBody = new FormBody.Builder();
      for (final NameValue param : formParams) {
        final String value = param.getValue() != null ? param.getValue() : "";
        formBody.add(param.getName(), value);
      }
      body = formBody.build();
    } else if (body == null) {
      // POST/PUT require a body so send an empty body if the actual is null
      // DELETE allows an empty request body
      body = RequestBody.create(null, new byte[0]);
    }
    builder.method(method.name(), body);

    // accept application/json by default
    builder.header(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_JSON);

    for (final NameValue header : headers) {
      builder.header(header.getName(), header.getValue());
    }

    return builder.build();
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "RequestBuilder [method=" + method + ", formParams=" + formParams + ", headers=" + headers + ", queryParams="
        + queryParams + ", httpUrl=" + httpUrl.toString() + "]";
  }

  /**
   * Return the request url including query parameters.
   *
   * @return the string
   */
  private String toUrl() {
    final HttpUrl.Builder builder = httpUrl.newBuilder();
    for (final NameValue param : queryParams) {
      builder.addQueryParameter(param.getName(), param.getValue());
    }
    return builder.build().uri().toString();
  }

  /**
   * Adds a name-value par to a given list.
   *
   * @param params a list of parameters
   * @param args a list of arguments
   *
   * @return this
   */
  private RequestBuilder with(List<NameValue> params, Object... args) {
    if (args != null) {
      Validator.isTrue((args.length % 2) == 0, "need even number of arguments");
      for (int i = 0; i < args.length; i += 2) {
        add(params, args[i].toString(), args[i + 1]);
      }
    }
    return this;
  }

  /**
   * Sets the body.
   *
   * @param body the body
   * @return the request builder
   */
  public RequestBuilder body(RequestBody body) {
    this.body = body;
    return this;
  }

  /**
   * Sets the string content to the request (used with POST/PUT). This will encapsulate the string into a
   * {@link RequestBody} encoded with UTF-8
   *
   * @param content the content to POST/PUT
   * @param contentType the HTTP contentType to use.
   *
   * @return this
   */
  public RequestBuilder bodyContent(String content, String contentType) {
    body = RequestBody.create(MediaType.parse(contentType), content);
    return this;
  }

  /**
   * Adds a JSON content to the request (used with POST/PUT). This will encapsulate the json into a {@link RequestBody}
   * encoded with UTF-8 and use {@code "application/json"} as Content-Type
   *
   * @param json the JsonObject json
   *
   * @return this
   */
  public RequestBuilder bodyJson(JsonObject json) {
    return bodyContent(json.toString(), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Adds form parameters.
   *
   * @param args a list of name-value form parameters
   *
   * @return this
   */
  public RequestBuilder form(Object... args) {
    return with(formParams, args);
  }

  /**
   * Adds header parameters.
   *
   * @param args a list of name-value headers
   *
   * @return this
   */
  public RequestBuilder header(Object... args) {
    return with(headers, args);
  }

  /**
   * Adds query parameters.
   *
   * @param args a list of name-value query parameters
   *
   * @return this
   */
  public RequestBuilder query(Object... args) {
    return with(queryParams, args);
  }

}
