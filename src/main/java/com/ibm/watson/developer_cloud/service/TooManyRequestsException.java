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
 * 429 Too Many Requests (HTTP/1.1 - RFC 6585)
 */
public class TooManyRequestsException extends ServiceResponseException {

	/** The Constant TOO_MANY_REQUESTS. */
	private static final int TOO_MANY_REQUESTS = 429;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Too Many Requests Exception.
	 * 
	 * @param message
	 *            the error message
	 */
	public TooManyRequestsException(String message) {
		super(TOO_MANY_REQUESTS, message);
	}

}
