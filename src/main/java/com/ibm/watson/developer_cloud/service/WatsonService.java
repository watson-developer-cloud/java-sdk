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

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpStatus;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.CredentialUtils;
import com.ibm.watson.developer_cloud.util.RequestUtil;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;

/**
 * Watson service abstract common functionality of various Watson Services. It handle authentication
 * and default url
 * 
 * @see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/"> IBM Watson
 *      Developer Cloud</a>
 */
public abstract class WatsonService {

  private static final String BASIC = "Basic ";
  private static final Logger log = Logger.getLogger(WatsonService.class.getName());
  private String apiKey;
  private final OkHttpClient client;
  private String endPoint;
  private final String name;
  private Headers defaultHeaders = null;

  protected static final String VERSION = "version";

  /**
   * Instantiates a new Watson service.
   * 
   * @param name the service name
   */
  public WatsonService(String name) {
    this.name = name;
    this.apiKey = CredentialUtils.getAPIKey(name);
    this.client = configureHttpClient();
  }


  /**
   * Configures the HTTP client.
   * 
   * @return the HTTP client
   */
  protected OkHttpClient configureHttpClient() {
    final OkHttpClient client = new OkHttpClient();
    final CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    client.setCookieHandler(cookieManager);

    client.setConnectTimeout(60, TimeUnit.SECONDS);
    client.setWriteTimeout(60, TimeUnit.SECONDS);
    client.setReadTimeout(90, TimeUnit.SECONDS);
    return client;
  }


  /**
   * Execute the HTTP request.
   * 
   * @param request the HTTP request
   * 
   * @return the HTTP response
   */
  protected Response execute(Request request) {
    final Builder builder = request.newBuilder();

    // Set service endpoint for relative paths
    if (RequestUtil.isRelative(request)) {
      builder.url(RequestUtil.replaceEndPoint(request.urlString(), getEndPoint()));
    }

    // Set default headers
    if (defaultHeaders != null) {
      for(String key: defaultHeaders.names())
        builder.header(key, defaultHeaders.get(key));
    }

    // Set User-Agent
    builder.header(HttpHeaders.USER_AGENT, getUserAgent());

    // Set Authentication
    setAuthentication(builder);

    final Request newRequest = builder.build();
    Response response;
    log.log(Level.FINEST, "Request to: " + newRequest.urlString());
    try {
      response = client.newCall(newRequest).execute();
    } catch (final IOException e) {
      log.log(Level.SEVERE, "IOException", e);
      throw new RuntimeException(e);
    }

    if (response.isSuccessful()) {
      return response;
    }

    final int status = response.code();

    // There was a Client Error 4xx or a Server Error 5xx
    // Get the error message and create the exception
    final String error = getErrorMessage(response);
    log.log(Level.SEVERE, newRequest.urlString() + ", status: " + status + ", error: " + error);

    switch (status) {
      case HttpStatus.BAD_REQUEST: // HTTP 400
        throw new BadRequestException(error != null ? error : "Bad Request", response);
      case HttpStatus.UNAUTHORIZED: // HTTP 401
        throw new UnauthorizedException(
            "Unauthorized: Access is denied due to invalid credentials", response);
      case HttpStatus.FORBIDDEN: // HTTP 403
        throw new ForbiddenException(error != null ? error
            : "Forbidden: Service refuse the request", response);
      case HttpStatus.NOT_FOUND: // HTTP 404
        throw new NotFoundException(error != null ? error : "Not found", response);
      case HttpStatus.NOT_ACCEPTABLE: // HTTP 406
        throw new ForbiddenException(error != null ? error
            : "Forbidden: Service refuse the request", response);
      case HttpStatus.CONFLICT: // HTTP 409
        throw new ConflictException(error != null ? error : "", response);
      case HttpStatus.REQUEST_TOO_LONG: // HTTP 413
        throw new RequestTooLargeException(error != null ? error
            : "Request too large: The request entity is larger than the server is able to process",
            response);
      case HttpStatus.UNSUPPORTED_MEDIA_TYPE: // HTTP 415
        throw new UnsupportedException(error != null ? error : "Unsupported Media Type", response);
      case HttpStatus.TOO_MANY_REQUESTS: // HTTP 429
        throw new TooManyRequestsException(error != null ? error : "Too many requests", response);
      case HttpStatus.INTERNAL_SERVER_ERROR: // HTTP 500
        throw new InternalServerErrorException(error != null ? error : "Internal Server Error",
            response);
      case HttpStatus.SERVICE_UNAVAILABLE: // HTTP 503
        throw new ServiceUnavailableException(error != null ? error : "Service Unavailable",
            response);
      default: // other errors
        throw new ServiceResponseException(status, error, response);
    }
  }

  /**
   * Executes the HTTP Request, reads and parses the HTTP Response.
   * 
   * @param <T> the POJO class that represents the response
   * @param request the request
   * @param returnType the return type
   * @return the POJO object
   */
  protected <T extends GenericModel> T executeRequest(Request request, Class<T> returnType) {
    final Response response = execute(request);
    return ResponseUtil.getObject(response, returnType);
  }

  /**
   * Execute the HTTP request and discard the response. Use this when you don't want to get the
   * response but you want to make sure we read it so that the underline connection is released
   * 
   * @param request the request
   */
  protected void executeWithoutResponse(Request request) {
    final Response response = execute(request);

    // close the response
    try {
      response.body().close();
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Gets the API key.
   * 
   * 
   * @return the API key
   */
  protected String getApiKey() {
    return apiKey;
  }

  /**
   * Gets the API end point.
   * 
   * 
   * @return the API end point
   */
  public String getEndPoint() {
    return endPoint;
  }

  /**
   * Gets an authorization token that can be use to authorize API calls.
   * 
   * 
   * @return the token
   */
  public String getToken() {
    HttpUrl url =
        HttpUrl.parse(getEndPoint()).newBuilder().setPathSegment(0, "authorization").build();
    Request request = RequestBuilder.get(url + "/v1/token").withQuery("url", getEndPoint()).build();
    Response response = execute(request);
    return ResponseUtil.getJsonObject(response).get("token").getAsString();
  }

  /**
   * Gets the error message from a JSON response
   * 
   * <pre>
   * {
   *   code: 400
   *   error: 'bad request'
   * }
   * </pre>
   * 
   * @param response the HTTP response
   * @return the error message from the JSON object
   */
  private String getErrorMessage(Response response) {
    String error = ResponseUtil.getString(response);
    try {

      final JsonObject jsonObject = ResponseUtil.getJsonObject(error);
      if (jsonObject.has("error")) {
        error = jsonObject.get("error").getAsString();
      } else if (jsonObject.has("error_message")) {
        error = jsonObject.get("error_message").getAsString();
      } else if (jsonObject.has("message")) {
        error = jsonObject.get("message").getAsString();
      }
    } catch (final JsonIOException e) {
      // Ignore JsonIOException and use fallback String version of response
    } catch (final JsonSyntaxException e) {
      // Ignore JsonSyntaxException and use fallback String version of response
    }

    return error;
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }


  /**
   * Gets the user agent.
   * 
   * 
   * @return the user agent
   */
  private String getUserAgent() {
    return "watson-developer-cloud-java-sdk-2.9.0";
  }

  /**
   * Sets the API key.
   * 
   * @param apiKey the new API key
   */
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  /**
   * Sets the authentication.
   * 
   * @param builder the new authentication
   */
  protected void setAuthentication(Builder builder) {
    if (getApiKey() == null) {
      throw new IllegalArgumentException("apiKey or username and password were not specified");
    }
    builder
        .addHeader(HttpHeaders.AUTHORIZATION, apiKey.startsWith(BASIC) ? apiKey : BASIC + apiKey);
  }

  /**
   * Sets the end point.
   * 
   * @param endPoint the new end point
   */
  public void setEndPoint(String endPoint) {
    this.endPoint = endPoint;
  }

  /**
   * Sets the username and password.
   * 
   * @param username the username
   * @param password the password
   */
  public void setUsernameAndPassword(String username, String password) {
    apiKey = Credentials.basic(username, password);
  }

  /**
   * Set the default headers to be used on every HTTP request.
   * 
   * @param headers name value pairs of headers
   */
  public void setDefaultHeaders(Map<String, String> headers) {
    defaultHeaders = Headers.of(headers);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append(name);
    builder.append(" [");
    if (endPoint != null) {
      builder.append("endPoint=");
      builder.append(endPoint);
    }
    builder.append("]");
    return builder.toString();
  }
}
