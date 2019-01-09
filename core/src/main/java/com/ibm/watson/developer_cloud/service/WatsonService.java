/*
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

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpClientSingleton;
import com.ibm.watson.developer_cloud.http.HttpConfigOptions;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.HttpStatus;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.http.ServiceCallbackWithDetails;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.service.exception.ConflictException;
import com.ibm.watson.developer_cloud.service.exception.ForbiddenException;
import com.ibm.watson.developer_cloud.service.exception.InternalServerErrorException;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.service.exception.RequestTooLargeException;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;
import com.ibm.watson.developer_cloud.service.exception.ServiceUnavailableException;
import com.ibm.watson.developer_cloud.service.exception.TooManyRequestsException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.service.exception.UnsupportedException;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.service.security.IamTokenManager;
import com.ibm.watson.developer_cloud.util.CredentialUtils;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.ResponseUtils;
import jersey.repackaged.jsr166e.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Watson service abstract common functionality of various Watson Services. It handle authentication and default url.
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/"> IBM Watson Developer Cloud</a>
 */
public abstract class WatsonService {

  private static final String URL = "url";
  private static final String PATH_AUTHORIZATION_V1_TOKEN = "/v1/token";
  private static final String AUTHORIZATION = "authorization";
  private static final String MESSAGE_ERROR_3 = "message";
  private static final String MESSAGE_ERROR_2 = "error_message";
  private static final String BASIC = "Basic ";
  private static final String BEARER = "Bearer ";
  private static final String APIKEY_AS_USERNAME = "apikey";
  private static final String ICP_PREFIX = "icp-";
  private static final Logger LOG = Logger.getLogger(WatsonService.class.getName());
  private static final String AUTH_HEADER_DEPRECATION_MESSAGE = "Authenticating with the X-Watson-Authorization-Token"
      + "header is deprecated. The token continues to work with Cloud Foundry services, but is not supported for "
      + "services that use Identity and Access Management (IAM) authentication. For details see the IAM "
      + "authentication section in the README.";
  private String apiKey;
  private String username;
  private String password;
  private String endPoint;
  private String defaultEndPoint;
  private final String name;
  private IamTokenManager tokenManager;

  private OkHttpClient client;

  /** The default headers. */
  protected Headers defaultHeaders = null;

  /** The skip authentication. */
  protected boolean skipAuthentication = false;

  /** The Constant MESSAGE_CODE. */
  protected static final String MESSAGE_CODE = "code";

  /** The Constant MESSAGE_ERROR. */
  protected static final String MESSAGE_ERROR = "error";

  /** The Constant VERSION. */
  protected static final String VERSION = "version";


  // Regular expression for JSON-related mimetypes.
  protected static final Pattern JSON_MIME_PATTERN =
    Pattern.compile("(?i)application\\/((json)|(merge\\-patch\\+json))(;.*)?");
  protected static final Pattern JSON_PATCH_MIME_PATTERN =
    Pattern.compile("(?i)application\\/json\\-patch\\+json(;.*)?");

  /**
   * Instantiates a new Watson service.
   *
   * @param name the service name
   */
  public WatsonService(final String name) {
    this.name = name;
    setCredentialFields(CredentialUtils.getCredentialsFromVcap(name));
    setCredentialFields(CredentialUtils.getFileCredentials(name));
    client = configureHttpClient();
  }

  /**
   * Calls appropriate methods to set credential values based on parsed ServiceCredentials object.
   *
   * @param serviceCredentials object containing parsed credential values
   */
  private void setCredentialFields(CredentialUtils.ServiceCredentials serviceCredentials) {
    setEndPoint(serviceCredentials.getUrl());

    if ((serviceCredentials.getUsername() != null) && (serviceCredentials.getPassword() != null)) {
      setUsernameAndPassword(serviceCredentials.getUsername(), serviceCredentials.getPassword());
    } else if (serviceCredentials.getOldApiKey() != null) {
      setApiKey(serviceCredentials.getOldApiKey());
    }

    if (serviceCredentials.getIamApiKey() != null) {
      IamOptions iamOptions = new IamOptions.Builder()
          .apiKey(serviceCredentials.getIamApiKey())
          .url(serviceCredentials.getIamUrl())
          .build();
      this.tokenManager = new IamTokenManager(iamOptions);
    }
  }

  /**
   * Returns true iff the specified mimeType indicates a JSON-related content type.
   * (e.g. application/json, application/json-patch+json, application/merge-patch+json, etc.).
   * @param mimeType the mimetype to consider
   * @return true if the mimeType indicates a JSON-related content type
   */
  public static boolean isJsonMimeType(String mimeType) {
    return mimeType != null && JSON_MIME_PATTERN.matcher(mimeType).matches();
  }

  /**
   * Returns true iff the specified mimeType indicates a "Json Patch"-related content type.
   * (e.g. application/json-patch+json)).
   * @param mimeType the mimetype to consider
   * @return true if the mimeType indicates a JSON-related content type
   */
  public static boolean isJsonPatchMimeType(String mimeType) {
    return mimeType != null && JSON_PATCH_MIME_PATTERN.matcher(mimeType).matches();
  }

  /**
   * Configure the {@link OkHttpClient}. This method will be called by the constructor and can be used to customize the
   * client that the service will use to perform the http calls.
   *
   * @return the {@link OkHttpClient}
   */
  protected OkHttpClient configureHttpClient() {
    return HttpClientSingleton.getInstance().createHttpClient();
  }

  /**
   * Configures the {@link OkHttpClient} based on the passed-in options.
   *
   * @param options the {@link HttpConfigOptions} object for modifying the client
   */
  public void configureClient(HttpConfigOptions options) {
    client = HttpClientSingleton.getInstance().configureClient(options);
  }

  /**
   * Execute the HTTP request. Okhttp3 compliant.
   *
   * @param request the HTTP request
   *
   * @return the HTTP response
   */
  private Call createCall(final Request request) {
    final Request.Builder builder = request.newBuilder();

    setDefaultHeaders(builder);

    setAuthentication(builder);

    final Request newRequest = builder.build();
    return client.newCall(newRequest);
  }

  /**
   * Sets the default headers including User-Agent.
   *
   * @param builder the new default headers
   */
  protected void setDefaultHeaders(final Request.Builder builder) {
    String userAgent = RequestUtils.getUserAgent();

    if (defaultHeaders != null) {
      for (String key : defaultHeaders.names()) {
        builder.header(key, defaultHeaders.get(key));
      }
      if (defaultHeaders.get(HttpHeaders.USER_AGENT) != null) {
        userAgent += " " + defaultHeaders.get(HttpHeaders.USER_AGENT);
      }
    }
    builder.header(HttpHeaders.USER_AGENT, userAgent);
  }

  /**
   * Creates the service call.
   *
   * @param <T> the generic type
   * @param request the request
   * @param converter the converter
   * @return the service call
   */
  protected final <T> ServiceCall<T> createServiceCall(final Request request, final ResponseConverter<T> converter) {
    final Call call = createCall(request);
    return new WatsonServiceCall<>(call, converter);
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
   * Gets the username.
   *
   *
   * @return the username
   */
  protected String getUsername() {
    return username;
  }

  /**
   * Gets the password.
   *
   *
   * @return the password
   */
  protected String getPassword() {
    return password;
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
  public ServiceCall<String> getToken() {
    HttpUrl url = HttpUrl.parse(getEndPoint()).newBuilder()
        .setPathSegment(0, AUTHORIZATION)
        .addPathSegment(PATH_AUTHORIZATION_V1_TOKEN)
        .build();
    Request request = RequestBuilder.get(url)
        .header(HttpHeaders.ACCEPT, HttpMediaType.TEXT_PLAIN).query(URL, getEndPoint()).build();

    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Checks the status of the tokenManager.
   *
   * @return true if the tokenManager has been set
   */
  protected boolean isTokenManagerSet() {
    return tokenManager != null;
  }

  /**
   * Gets the error message from a JSON response.
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
    String error = ResponseUtils.getString(response);
    try {

      final JsonObject jsonObject = ResponseUtils.getJsonObject(error);
      if (jsonObject.has(MESSAGE_ERROR)) {
        error = jsonObject.get(MESSAGE_ERROR).getAsString();
      } else if (jsonObject.has(MESSAGE_ERROR_2)) {
        error = jsonObject.get(MESSAGE_ERROR_2).getAsString();
      } else if (jsonObject.has(MESSAGE_ERROR_3)) {
        error = jsonObject.get(MESSAGE_ERROR_3).getAsString();
      }
    } catch (final Exception e) {
      // Ignore any kind of exception parsing the json and use fallback String version of response
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
   * Sets the API key.
   *
   * @param apiKey the new API key
   */
  public void setApiKey(String apiKey) {
    if (CredentialUtils.hasBadStartOrEndChar(apiKey)) {
      throw new IllegalArgumentException("The API key shouldn't start or end with curly brackets or quotes. Please "
          + "remove any surrounding {, }, or \" characters.");
    }

    if (this.endPoint.equals(this.defaultEndPoint)) {
      this.endPoint = "https://gateway-a.watsonplatform.net/visual-recognition/api";
    }
    this.apiKey = apiKey;
  }

  /**
   * Sets the authentication. Okhttp3 compliant.
   *
   * @param builder the new authentication
   */
  protected void setAuthentication(final Builder builder) {
    if (tokenManager != null) {
      String accessToken = tokenManager.getToken();
      builder.addHeader(HttpHeaders.AUTHORIZATION, BEARER + accessToken);
    } else if (getApiKey() == null) {
      if (skipAuthentication) {
        Headers currentHeaders = builder.build().headers();
        if (currentHeaders.get(HttpHeaders.X_WATSON_AUTHORIZATION_TOKEN) != null) {
          LOG.warning(AUTH_HEADER_DEPRECATION_MESSAGE);
        }
        return;
      }
      throw new IllegalArgumentException("apiKey or username and password were not specified");
    } else {
      builder.addHeader(HttpHeaders.AUTHORIZATION, apiKey.startsWith(BASIC) ? apiKey : BASIC + apiKey);
    }
  }

  /**
   * Sets the end point.
   *
   * @param endPoint the new end point. Will be ignored if empty or null
   */
  public void setEndPoint(final String endPoint) {
    if (CredentialUtils.hasBadStartOrEndChar(endPoint)) {
      throw new IllegalArgumentException("The URL shouldn't start or end with curly brackets or quotes. Please "
          + "remove any surrounding {, }, or \" characters.");
    }

    if ((endPoint != null) && !endPoint.isEmpty()) {
      String newEndPoint = endPoint.endsWith("/") ? endPoint.substring(0, endPoint.length() - 1) : endPoint;
      if (this.endPoint == null) {
        this.defaultEndPoint = newEndPoint;
      }
      this.endPoint = newEndPoint;
    }
  }

  /**
   * Sets the username and password.
   *
   * @param username the username
   * @param password the password
   */
  public void setUsernameAndPassword(final String username, final String password) {
    if (CredentialUtils.hasBadStartOrEndChar(username) || CredentialUtils.hasBadStartOrEndChar(password)) {
      throw new IllegalArgumentException("The username and password shouldn't start or end with curly brackets or "
          + "quotes. Please remove any surrounding {, }, or \" characters.");
    }

    // we'll perform the token exchange for users UNLESS they're on ICP
    if (username.equals(APIKEY_AS_USERNAME) && !password.startsWith(ICP_PREFIX)) {
      IamOptions iamOptions = new IamOptions.Builder()
          .apiKey(password)
          .build();
      setIamCredentials(iamOptions);
    } else {
      this.username = username;
      this.password = password;
      apiKey = Credentials.basic(username, password);
    }
  }

  /**
   * Set the default headers to be used on every HTTP request.
   *
   * @param headers name value pairs of headers
   */
  public void setDefaultHeaders(final Map<String, String> headers) {
    if (headers == null) {
      defaultHeaders = null;
    } else {
      defaultHeaders = Headers.of(headers);
    }
  }

  /**
   * Sets IAM information.
   *
   * Be aware that if you pass in an access token using this method, you accept responsibility for managing the access
   * token yourself. You must set a new access token before this one expires. Failing to do so will result in
   * authentication errors after this token expires.
   *
   * @param iamOptions object containing values to be used for authenticating with IAM
   */
  public void setIamCredentials(IamOptions iamOptions) {
    this.tokenManager = new IamTokenManager(iamOptions);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder().append(name).append(" [");

    if (endPoint != null) {
      builder.append("endPoint=").append(endPoint);
    }

    return builder.append(']').toString();
  }


  /**
   * Process service call.
   *
   * @param <T> the generic type
   * @param converter the converter
   * @param response the response
   * @return the t
   */
  protected <T> T processServiceCall(final ResponseConverter<T> converter, final Response response) {
    if (response.isSuccessful()) {
      return converter.convert(response);
    }

    // There was a Client Error 4xx or a Server Error 5xx
    // Get the error message and create the exception
    final String error = getErrorMessage(response);
    LOG.log(Level.SEVERE, response.request().method() + " " + response.request().url().toString() + ", status: "
        + response.code() + ", error: " + error);

    switch (response.code()) {
      case HttpStatus.BAD_REQUEST: // HTTP 400
        throw new BadRequestException(error != null ? error : "Bad Request", response);
      case HttpStatus.UNAUTHORIZED: // HTTP 401
        throw new UnauthorizedException("Unauthorized: Access is denied due to invalid credentials. "
                                        + "Tip: Did you set the Endpoint?", response);
      case HttpStatus.FORBIDDEN: // HTTP 403
        throw new ForbiddenException(error != null ? error : "Forbidden: Service refuse the request", response);
      case HttpStatus.NOT_FOUND: // HTTP 404
        throw new NotFoundException(error != null ? error : "Not found", response);
      case HttpStatus.NOT_ACCEPTABLE: // HTTP 406
        throw new ForbiddenException(error != null ? error : "Forbidden: Service refuse the request", response);
      case HttpStatus.CONFLICT: // HTTP 409
        throw new ConflictException(error != null ? error : "", response);
      case HttpStatus.REQUEST_TOO_LONG: // HTTP 413
        throw new RequestTooLargeException(error != null ? error
            : "Request too large: " + "The request entity is larger than the server is able to process", response);
      case HttpStatus.UNSUPPORTED_MEDIA_TYPE: // HTTP 415
        throw new UnsupportedException(error != null ? error : "Unsupported Media Type", response);
      case HttpStatus.TOO_MANY_REQUESTS: // HTTP 429
        throw new TooManyRequestsException(error != null ? error : "Too many requests", response);
      case HttpStatus.INTERNAL_SERVER_ERROR: // HTTP 500
        throw new InternalServerErrorException(error != null ? error : "Internal Server Error", response);
      case HttpStatus.SERVICE_UNAVAILABLE: // HTTP 503
        throw new ServiceUnavailableException(error != null ? error : "Service Unavailable", response);
      default: // other errors
        throw new ServiceResponseException(response.code(), error, response);
    }
  }

  /**
   * Sets the skip authentication.
   *
   * @param skipAuthentication the new skip authentication
   */
  public void setSkipAuthentication(final boolean skipAuthentication) {
    this.skipAuthentication = skipAuthentication;
  }

  /**
   * Defines implementation for modifying and executing service calls.
   *
   * @param <T> the generic type
   */
  class WatsonServiceCall<T> implements ServiceCall<T> {
    private Call call;
    private ResponseConverter<T> converter;

    WatsonServiceCall(Call call, ResponseConverter<T> converter) {
      this.call = call;
      this.converter = converter;
    }

    @Override
    public ServiceCall<T> addHeader(String name, String value) {
      Request.Builder builder = call.request().newBuilder();
      builder.header(name, value);
      call = client.newCall(builder.build());
      return this;
    }

    @Override
    public T execute() {
      try {
        Response response = call.execute();
        return processServiceCall(converter, response);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public com.ibm.watson.developer_cloud.http.Response<T> executeWithDetails() throws RuntimeException {
      try {
        Response httpResponse = call.execute();
        T responseModel = processServiceCall(converter, httpResponse);
        return new com.ibm.watson.developer_cloud.http.Response<>(responseModel, httpResponse);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void enqueue(final ServiceCallback<? super T> callback) {
      call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
          callback.onFailure(e);
        }

        @Override
        public void onResponse(Call call, Response response) {
          try {
            callback.onResponse(processServiceCall(converter, response));
          } catch (Exception e) {
            callback.onFailure(e);
          }
        }
      });
    }

    @Override
    public void enqueueWithDetails(final ServiceCallbackWithDetails<T> callback) {
      call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
          callback.onFailure(e);
        }

        @Override
        public void onResponse(Call call, Response response) {
          try {
            T responseModel = processServiceCall(converter, response);
            callback.onResponse(new com.ibm.watson.developer_cloud.http.Response<>(responseModel, response));
          } catch (Exception e) {
            callback.onFailure(e);
          }
        }
      });
    }

    @Override
    public CompletableFuture<T> rx() {
      final CompletableFuture<T> completableFuture = new CompletableFuture<T>();

      call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
          completableFuture.completeExceptionally(e);
        }

        @Override
        public void onResponse(Call call, Response response) {
          try {
            completableFuture.complete(processServiceCall(converter, response));
          } catch (Exception e) {
            completableFuture.completeExceptionally(e);
          }
        }
      });

      return completableFuture;
    }

    @Override
    public CompletableFuture<com.ibm.watson.developer_cloud.http.Response<T>> rxWithDetails() {
      final CompletableFuture<com.ibm.watson.developer_cloud.http.Response<T>> completableFuture
          = new CompletableFuture<>();

      call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
          completableFuture.completeExceptionally(e);
        }

        @Override
        public void onResponse(Call call, Response response) {
          try {
            T responseModel = processServiceCall(converter, response);
            completableFuture.complete(new com.ibm.watson.developer_cloud.http.Response<>(responseModel, response));
          } catch (Exception e) {
            completableFuture.completeExceptionally(e);
          }
        }
      });

      return completableFuture;
    }

    @Override
    protected void finalize() throws Throwable {
      super.finalize();

      if (!call.isExecuted()) {
        final Request r = call.request();
        LOG.warning(r.method() + " request to " + r.url() + " has not been sent. Did you forget to call execute()?");
      }
    }
  }
}
