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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The Class StatusCause.
 */
public class StatusCause extends GenericModel {

	/** The error code. */
	@SerializedName("error_code")
	private String errorCode;

	/** The message. */
	private String message;

	/** The tokens. */
	private List<String> tokens;

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the tokens.
	 * 
	 * @return the tokens
	 */
	public List<String> getTokens() {
		return tokens;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode
	 *            the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the tokens.
	 * 
	 * @param tokens
	 *            the new tokens
	 */
	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
}
