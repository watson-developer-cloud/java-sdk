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

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpStatus;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;

/**
 * Abstract class which has functionality for the different Alchemy services.
 * 
 */
public abstract class AlchemyService extends WatsonService {
  /**
   * The Alchemy endpoint. (value is "https://gateway-a.watsonplatform.net/calls")
   */
  protected final static String ENDPOINT = "https://gateway-a.watsonplatform.net/calls";
  protected static final String JSONP = "jsonp";

  private static final String DAILY_TRANSACTION_LIMIT_EXCEEDED = "daily-transaction-limit-exceeded";
  private static final String INVALID_API_KEY = "invalid-api-key";
  private static final Logger log = Logger.getLogger(AlchemyService.class.getName());
  private static final String MESSAGE_CODE = "code";
  private static final String MESSAGE_ERROR = "error";

  // Output mode will be always json and jsonp should not be used
  protected static final String OUTPUT_MODE = "outputMode";

  private static final String PARAM_APIKEY = "apikey";
  private static final String STATUS_ERROR = "ERROR";
  private static final String X_ALCHEMY_API_ERROR_MSG = "X-AlchemyAPI-Error-Msg";
  private static final String X_ALCHEMY_API_STATUS = "X-AlchemyAPI-Status";

  /**
   * Instantiates a new alchemy service.
   */
  public AlchemyService() {
    super("alchemy_api");
    setEndPoint(ENDPOINT);
  }

  /**
   * Adds the Alchemy API key to HTTP request.
   * 
   * @param builder the builder
   * @param apiKey the API key token
   */
  private void addApiKeyToRequest(Builder builder, String apiKey) {
    final HttpUrl url = HttpUrl.parse(builder.build().urlString());
    if (url.query() == null || url.query().isEmpty()) {
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
   * @see com.ibm.watson.developer_cloud.service.WatsonService#execute(com.squareup.okhttp .Request)
   */
  @Override
  protected Response execute(Request request) {
    final Response response = super.execute(request);
    final JsonObject error = getErrorMessage(response);
    if (error == null) {
      return response;
    }
    log.log(Level.SEVERE, error.toString());
    final int code = error.get(MESSAGE_CODE).getAsInt();
    switch (code) {
      case HttpStatus.BAD_REQUEST: // HTTP 400
        throw new BadRequestException(error.toString(), response);
      case HttpStatus.UNAUTHORIZED: // HTTP 401
        throw new UnauthorizedException(
            "Unauthorized: Access is denied due to invalid credentials", response);
      case HttpStatus.TOO_MANY_REQUESTS: // HTTP 429
        throw new TooManyRequestsException(error.toString(), response);
      default: // other errors
        throw new ServiceResponseException(code, error.toString(), response);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.ibm.watson.developer_cloud.service.WatsonService#executeRequest(com.squareup.okhttp.Request
   * , java.lang.Class)
   */
  @Override
  protected <T extends GenericModel> T executeRequest(Request request, Class<T> returnType) {
    final Response response = this.execute(request);
    return ResponseUtil.getObject(response, returnType);
  }

  /**
   * Gets the error message from the {@link Response} by looking at the headers returned by the
   * Alchemy service <code>X-AlchemyAPI-Status</code> and <code>X-AlchemyAPI-Error-Msg</code>
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
   * @return the error message from the json object
   */
  private JsonObject getErrorMessage(Response response) {

    final String status = response.header(X_ALCHEMY_API_STATUS);
    final String errorMessage = response.header(X_ALCHEMY_API_ERROR_MSG);

    if (status != null && status.equals(STATUS_ERROR)) {
      final int code = detectErrorCode(errorMessage);
      final JsonObject error = new JsonObject();
      error.addProperty(MESSAGE_ERROR, errorMessage != null ? errorMessage : "Unknown error");
      error.addProperty(MESSAGE_CODE, code);
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
    while (i < acceptedFormats.length && params != null && !params.containsKey(acceptedFormats[i])) {
      i++;
    }

    if (params == null || i == acceptedFormats.length) {
      throw new IllegalArgumentException(StringUtils.join(acceptedFormats, ",")
          + " should be specified");
    }
    return acceptedFormats[i];
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.service.WatsonService#setAuthentication(com.squareup
   * .okhttp.Request.Builder)
   */
  @Override
  protected void setAuthentication(Builder builder) {
    if (getApiKey() == null) {
      throw new IllegalArgumentException("apiKey not specified");
    }
    addApiKeyToRequest(builder, PARAM_APIKEY + "=" + getApiKey());
  }
}
