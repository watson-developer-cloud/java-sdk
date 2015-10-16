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

/**
 * Generic Service Response Exception.
 */
public class ServiceResponseException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The status code. */
	private int statusCode;

	/**
	 * Instantiates a new Service Response Exception.
	 * 
	 * @param statusCode
	 *            the status code
	 * @param message
	 *            the error message
	 */
	public ServiceResponseException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	/**
	 * Gets the HTTP status code.
	 * 
	 * @return the http status code
	 */
	public int getStatusCode() {
		return statusCode;
	}
}
