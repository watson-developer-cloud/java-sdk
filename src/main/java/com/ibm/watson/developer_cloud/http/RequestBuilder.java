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
package com.ibm.watson.developer_cloud.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.util.RequestUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;

/**
 * Convenience class for constructing HTTP/HTTPS requests.
 * 
 */
public class RequestBuilder {

  private enum HTTPMethod {
    DELETE, GET, POST, PUT
  }


  /**
   * The DELETE method requests that the origin server delete the resource identified by the
   * Request-URI.
   * 
   * @param url the URL
   * 
   * @return this
   */
  public static RequestBuilder delete(String url) {
    return new RequestBuilder(HTTPMethod.DELETE, url);
  }

  /**
   * The GET method means retrieve whatever information (in the form of an entity) is identified by
   * the Request-URI.
   * 
   * @param url the URL
   * 
   * @return this
   */
  public static RequestBuilder get(String url) {
    return new RequestBuilder(HTTPMethod.GET, url);
  }

  /**
   * The POST request method is designed to request that a web server accept the data enclosed in
   * the request message's body for storage. It is often used when uploading a file or submitting a
   * completed web form.
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

  /** The body. */
  private RequestBody body;

  /** The form params. */
  private final List<NameValue> formParams = new ArrayList<NameValue>();

  /** The headers. */
  private final List<NameValue> headers = new ArrayList<NameValue>();

  /** The url. */
  private HttpUrl httpUrl;

  /** The method. */
  private final HTTPMethod method;

  /** The query params. */
  private final List<NameValue> queryParams = new ArrayList<NameValue>();

  /**
   * Instantiates a new request.
   * 
   * @param method the method, PUT, POST, GET or DELETE
   * @param url the request URL
   */
  private RequestBuilder(HTTPMethod method, String url) {
    this.method = method;
    if (url == null)
      throw new IllegalArgumentException("url cannot be null");

    // Since HttpUrl requires requires a http/s full url, add a default endpoint
    httpUrl = HttpUrl.parse(url);
    if (httpUrl == null)
      this.httpUrl = HttpUrl.parse(RequestUtil.DEFAULT_ENDPOINT + url);

  }

  /**
   * Adds a key/value pair.
   * 
   * <pre>
   * <code>
   * Request r = new Request.get("https://foo.bar").add("singleParam", "value")
   * 		.add("multiParam", new String[] { "1", "2", "3" })
   * 		.add("singleParamWithOutValue", null);
   * </code>
   * </pre>
   * 
   * @param params the parameters
   * @param name the parameter name
   * @param value the value to set, will be obtained via {@link String#valueOf(boolean)}. If null,
   *        only the parameter is set. It can also be a collection or array, in which case all
   *        elements are added as query parameters
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
   * Builds a request with the given set of parameters and files.
   * 
   * 
   * @return HTTP request, prepared to be executed
   */
  public Request build() {
    final Builder builder = new Request.Builder();
    // URL
    builder.url(toUrl());

    // POST/PUT require a body so send an empty body if the actual is null
    RequestBody requestBody = body;
    if (body == null)
      requestBody = RequestBody.create(null, new byte[0]);

    if (!formParams.isEmpty()) {
      final FormEncodingBuilder formBody = new FormEncodingBuilder();
      for (final NameValue param : formParams) {
        final String value = param.getValue() != null ? param.getValue() : "";
        formBody.add(param.getName(), value);
      }
      requestBody = formBody.build();
    }

    // accept application/json by default
    builder.addHeader(HttpHeaders.ACCEPT, HttpMediaType.APPLICATION_JSON);

    if (!headers.isEmpty()) {
      for (final NameValue header : headers) {
        builder.addHeader(header.getName(), header.getValue());
      }
    }

    switch (method) {
      case GET:
        builder.get();
        break;
      case POST:
        builder.post(requestBody);
        break;
      case PUT:
        builder.put(requestBody);
        break;
      case DELETE:
        builder.delete(requestBody);
        break;
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
    return "RequestBuilder [method=" + method + ", formParams=" + formParams + ", headers="
        + headers + ", queryParams=" + queryParams + ", httpUrl=" + httpUrl + "]";
  }

  /**
   * Create and return the URL being used in the request.
   * 
   * 
   * @return the URL as string
   */
  public String toUrl() {
    final HttpUrl.Builder builder = httpUrl.newBuilder();
    for (final NameValue param : queryParams) {
      // TODO: we should not be manually encoding the query parameters.
      builder.addEncodedQueryParameter(RequestUtil.encode(param.getName()),
          RequestUtil.encode(param.getValue()));
    }
    return builder.build().url().toString();
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
      if (args.length % 2 != 0)
        throw new IllegalArgumentException("need even number of arguments");
      for (int i = 0; i < args.length; i += 2) {
        add(params, args[i].toString(), args[i + 1]);
      }
    }
    return this;
  }

  /**
   * Adds an arbitrary entity to the request (used with POST/PUT).
   * 
   * @param body the request body to POST/PUT
   * 
   * @return this
   */
  public RequestBuilder withBody(RequestBody body) {
    this.body = body;
    return this;
  }

  /**
   * Adds string content to the request (used with POST/PUT). This will encapsulate the string into
   * a {@link RequestBody} encoded with UTF-8
   * 
   * @param content the content to POST/PUT
   * @param contentType the HTTP contentType to use.
   * 
   * @return this
   */
  public RequestBuilder withBodyContent(String content, String contentType) {
    body = RequestBody.create(MediaType.parse(contentType), content);
    return this;
  }

  /**
   * Adds a JSON content to the request (used with POST/PUT). This will encapsulate the json into a
   * {@link RequestBody} encoded with UTF-8 and use "application/json" as Content-Type
   * 
   * @param json the JsonObject json
   * 
   * @return this
   */
  public RequestBuilder withBodyJson(JsonObject json) {
    return withBodyContent(json.toString(), HttpMediaType.APPLICATION_JSON);
  }

  /**
   * Adds form parameters.
   * 
   * @param args a list of name-value form parameters
   * 
   * @return this
   */
  public RequestBuilder withForm(Object... args) {
    return with(formParams, args);
  }

  /**
   * Adds form parameters.
   * 
   * @param parameters a list of name-value form parameters
   * 
   * @return this
   */
  public RequestBuilder withFormMap(Map<String, Object> parameters) {
    for (final Map.Entry<String, Object> entry : parameters.entrySet()) {
      withForm(entry.getKey(), entry.getValue());
    }
    return this;
  }

  /**
   * Adds header parameters.
   * 
   * @param args a list of name-value headers
   * 
   * @return this
   */
  public RequestBuilder withHeader(Object... args) {
    return with(headers, args);
  }

  /**
   * Adds query parameters.
   * 
   * @param args a list of name-value query parameters
   * 
   * @return this
   */
  public RequestBuilder withQuery(Object... args) {
    return with(queryParams, args);
  }

  /**
   * Adds query parameters.
   * 
   * @param parameters a list of name-value query parameters
   * 
   * @return this
   */
  public RequestBuilder withQueryMap(Map<String, Object> parameters) {
    for (final Map.Entry<String, Object> entry : parameters.entrySet()) {
      withQuery(entry.getKey(), entry.getValue());
    }
    return this;
  }


}
