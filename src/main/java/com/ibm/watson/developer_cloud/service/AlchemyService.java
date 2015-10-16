/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.service;

import java.net.URI;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonObject;

/**
 * Abstract class which has functionality for the different Alchemy services.
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public abstract class AlchemyService extends WatsonService {

	/** The Constant X_ALCHEMY_API_ERROR_MSG. */
	private static final String X_ALCHEMY_API_ERROR_MSG = "X-AlchemyAPI-Error-Msg";

	/** The Constant X_ALCHEMY_API_STATUS. */
	private static final String X_ALCHEMY_API_STATUS = "X-AlchemyAPI-Status";

	/** The Constant MESSAGE_CODE. */
	private static final String MESSAGE_CODE = "code";

	/** The Constant MESSAGE_ERROR. */
	private static final String MESSAGE_ERROR = "error";

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(AlchemyService.class.getName());

	/** The Constant PARAM_APIKEY. */
	private static final String PARAM_APIKEY = "apikey";

	/** The Constant INVALID_API_KEY. */
	private static final String INVALID_API_KEY = "invalid-api-key";

	/** The Constant DAILY_TRANSACTION_LIMIT_EXCEEDED. */
	private static final String DAILY_TRANSACTION_LIMIT_EXCEEDED = "daily-transaction-limit-exceeded";

	/**
	 * The Alchemy endpoint. (value is "https://access.alchemyapi.com/calls")
	 */
	protected final static String ENDPOINT = "https://access.alchemyapi.com/calls";

	/** The Constant OUTPUT_MODE. */
	// Output mode will be always json and jsonp should not be used
	protected static final String OUTPUT_MODE = "outputMode";

	/** The Constant JSONP. */
	protected static final String JSONP = "jsonp";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ibm.watson.developer_cloud.service.WatsonService#setAuthentication(org.apache
	 * .http.client.methods.HttpRequestBase)
	 */
	@Override
	protected void setAuthentication(HttpRequestBase request) {
		if (getApiKey() == null)
			throw new IllegalArgumentException("apiKey not specified");
		else {
			StringBuilder apiKeyToken = new StringBuilder();
			apiKeyToken.append(PARAM_APIKEY).append("=").append(getApiKey());
			addApiKeyToHttpRequest(request, apiKeyToken.toString());

		}

	}

	/**
	 * Adds the Alchemy api key to http request.
	 * 
	 * @param request
	 *            the http request
	 * @param apiKey
	 *            the api key token
	 */
	private void addApiKeyToHttpRequest(HttpRequestBase request, String apiKey) {
		String query = request.getURI().getQuery();
		if (query == null || query.length() == 0) {
			request.setURI(URI.create(request.getURI() + "?" + apiKey));
		} else {
			request.setURI(URI.create(request.getURI() + "&" + apiKey));
		}
	}

	/**
	 * Returns the first non-null accepted format from the parameter map.
	 * 
	 * @param params
	 *            the request parameters
	 * @param acceptedFormats
	 *            the accepted formats
	 * @return the first accepted format found in the map
	 */
	protected String getInputFormat(Map<String, Object> params, String... acceptedFormats) {
		int i = 0;
		while (i < acceptedFormats.length && params != null && !params.containsKey(acceptedFormats[i]))
			i++;

		if (params == null || i == acceptedFormats.length)
			throw new IllegalArgumentException(StringUtils.join(acceptedFormats, ",") + " should be specified");
		return acceptedFormats[i];
	}

	/**
	 * Instantiates a new alchemy service.
	 */
	public AlchemyService() {
		super("alchemy_api");
		setEndPoint(ENDPOINT);
	}

	/**
	 * Gets the error message from the {@link HttpResponse} by looking at the headers
	 * returned by the Alchemy service <code>X-AlchemyAPI-Status</code> and
	 * <code>X-AlchemyAPI-Error-Msg</code>
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
	 * @param response
	 *            the HTTP response
	 * @return the error message from the json object
	 */
	private String getErrorMessage(HttpResponse response) {

		Header status = response.getFirstHeader(X_ALCHEMY_API_STATUS);
		Header errorMessage = response.getFirstHeader(X_ALCHEMY_API_ERROR_MSG);

		if (status != null && status.getValue().equals("ERROR")) {
			
			int code = detectErrorCode(errorMessage);

			JsonObject error = new JsonObject();
			error.addProperty(MESSAGE_ERROR, errorMessage != null ? errorMessage.getValue() : "Unknown error");
			error.addProperty(MESSAGE_CODE, code);
			return error.toString();
		} else
			return null;
	}

	/**
	 * Detect the error code based on the error message.
	 * 
	 * @param errorMessage
	 *            the error message
	 * @return the int
	 */
	private int detectErrorCode(Header errorMessage) {
		String error = errorMessage != null ? errorMessage.getValue() : null;
		if (error == null)
			return 400;

		if (error.equals(DAILY_TRANSACTION_LIMIT_EXCEEDED)) {
			return 429;
		} else if (error.equals(INVALID_API_KEY)) {
			return 401;
		} else
			return 400;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ibm.watson.developer_cloud.service.WatsonService#execute(org.apache.http.client
	 * .methods.HttpRequestBase)
	 */
	@Override
	protected HttpResponse execute(HttpRequestBase request) {
		HttpResponse response = super.execute(request);
		String error = getErrorMessage(response);
		if (error == null)
			return response;
		else {
			log.log(Level.SEVERE, error);
			throw new BadRequestException(error);
		}
	}
}
