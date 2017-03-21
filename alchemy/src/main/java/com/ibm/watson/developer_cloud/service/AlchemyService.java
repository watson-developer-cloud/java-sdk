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

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpStatus;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;
import com.ibm.watson.developer_cloud.service.exception.TooManyRequestsException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseUtils;

import okhttp3.HttpUrl;
import okhttp3.Request.Builder;
import okhttp3.Response;

/**
 * Abstract class which has functionality for the different Alchemy services.
 */
public abstract class AlchemyService extends WatsonService {
  private static final String SERVICE_NAME = "alchemy_api";
  private static final String DAILY_TRANSACTION_LIMIT_EXCEEDED = "daily-transaction-limit-exceeded";
  private static final String INVALID_API_KEY = "invalid-api-key";
  private static final String PARAM_APIKEY = "apikey";
  private static final String STATUS_ERROR = "ERROR";
  private static final String X_ALCHEMY_API_ERROR_MSG = "X-AlchemyAPI-Error-Msg";
  private static final String X_ALCHEMY_API_STATUS = "X-AlchemyAPI-Status";
  private static final Logger LOG = Logger.getLogger(AlchemyService.class.getName());

  /** The Constant ENDPOINT. */
  protected static final String ENDPOINT = "https://gateway-a.watsonplatform.net/calls";

  /** The Constant JSONP. */
  protected static final String JSONP = "jsonp";

  /** The Constant OUTPUT_MODE. */
  protected static final String OUTPUT_MODE = "outputMode";

  /**
   * Instantiates a new alchemy service.
   */
  public AlchemyService() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(ENDPOINT);
    }
  }

  /**
   * Instantiates a new alchemy service by apiKey.
   *
   * @param apiKey The API key
   */
  public AlchemyService(String apiKey) {
    this();
    setApiKey(apiKey);
  }

  /**
   * Adds the Alchemy API key to HTTP request.
   *
   * @param builder the builder
   * @param apiKey the API key token
   */
  private void addApiKeyToRequest(Builder builder, String apiKey) {
    final HttpUrl url = HttpUrl.parse(builder.build().url().toString());
    if ((url.query() == null) || url.query().isEmpty()) {
      builder.url(builder.build().url() + "?" + apiKey);
    } else {
      builder.url(builder.build().url() + "&" + apiKey);
    }
  }

  /**
   * Detect the error code based on the error message.
   *
   * @param errorMessage the error message
   * @return the int
   */
  private int detectErrorCode(String errorMessage) {
    final String error = errorMessage != null ? errorMessage : null;
    if (error == null) {
      return 400;
    }
    if (error.equals(DAILY_TRANSACTION_LIMIT_EXCEEDED)) {
      return 429;
    } else if (error.equals(INVALID_API_KEY)) {
      return 401;
    } else {
      return 400;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.service.WatsonService#processServiceCall(com.ibm.watson.
   * watson.developer_cloud.service.ResponseConverter, okhttp3.Response)
   */
  @Override
  protected <T> T processServiceCall(ResponseConverter<T> converter, Response response) {
    final JsonObject error = getErrorMessage(response);

    if (response.isSuccessful() && (error == null)) {
      return converter.convert(response);
    }

    // There was a Client Error 4xx or a Server Error 5xx
    // Get the error message and create the exception
    final String errorMessage;
    final int code;
    if (error != null) {
      errorMessage = error.get(MESSAGE_ERROR).getAsString();
      code = error.get(MESSAGE_CODE).getAsInt();
    } else {
      errorMessage = null;
      code = -1;
    }

    LOG.log(Level.SEVERE, response.request().method() + " " + response.request().url().toString() + ", API status: "
        + response.code() + ", error: " + errorMessage);

    switch (code) {
      case HttpStatus.BAD_REQUEST: // HTTP 400
        throw new BadRequestException(errorMessage, response);
      case HttpStatus.UNAUTHORIZED: // HTTP 401
        throw new UnauthorizedException("Unauthorized: Access is denied due to invalid credentials", response);
      case HttpStatus.TOO_MANY_REQUESTS: // HTTP 429
        throw new TooManyRequestsException(errorMessage, response);
      default: // other errors
        throw new ServiceResponseException(code, errorMessage, response);
    }
  }


  /**
   * Gets the error message from the {@link Response} by looking at the headers returned by the Alchemy service
   * <code>X-AlchemyAPI-Status</code> and <code>X-AlchemyAPI-Error-Msg</code>
   *
   * <pre>
   * {
   *   code: 400
   *   error: 'bad request'
   * }
   * </pre>
   *
   * .
   *
   * @param response the HTTP response
   * @return the error message from the json object, or null if none found
   */
  private JsonObject getErrorMessage(Response response) {

    final String status = response.header(X_ALCHEMY_API_STATUS);
    final String errorMessage = response.header(X_ALCHEMY_API_ERROR_MSG);

    if (STATUS_ERROR.equals(status)) {
      final int code = detectErrorCode(errorMessage);
      final JsonObject error = new JsonObject();
      error.addProperty(MESSAGE_ERROR, errorMessage != null ? errorMessage : "Unknown error");
      error.addProperty(MESSAGE_CODE, code);

      // #242: Close the request body to prevent a connection leak
      ResponseUtils.getString(response);

      return error;
    }
    return null; // no error
  }

  /**
   * Returns the first non-null accepted format from the parameter map.
   *
   * @param params the request parameters
   * @param acceptedFormats the accepted formats
   * @return the first accepted format found in the map
   */
  protected String getInputFormat(Map<String, Object> params, String... acceptedFormats) {
    int i = 0;
    while ((i < acceptedFormats.length) && (params != null) && !params.containsKey(acceptedFormats[i])) {
      i++;
    }

    if ((params == null) || (i == acceptedFormats.length)) {
      throw new IllegalArgumentException(RequestUtils.join(acceptedFormats, ",") + " should be specified");
    }
    return acceptedFormats[i];
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.service.WatsonService#setAuthentication(okhttp3.Request. Builder)
   */
  @Override
  protected void setAuthentication(Builder builder) {
    if (getApiKey() == null) {
      throw new IllegalArgumentException("apiKey not specified");
    }
    addApiKeyToRequest(builder, PARAM_APIKEY + "=" + getApiKey());
  }
}
