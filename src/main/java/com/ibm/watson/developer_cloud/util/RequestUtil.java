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
package com.ibm.watson.developer_cloud.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.NameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * Utility functions to use when creating a {@link com.ibm.watson.developer_cloud.service.Request }
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class RequestUtil {
	private static final Logger log = Logger.getLogger(RequestUtil.class
			.getName());
	
	/**
	 * Encode the <code>content</code> with the given <code>encoding</code>.
	 * 
	 * @param content
	 *            the string content to encode
	 * @param encoding
	 *            the character encoding
	 * @return the string encoded
	 */
	private static String encode(final String content, final String encoding) {
		try {
			return URLEncoder.encode(content, encoding != null ? encoding
					: HTTP.DEFAULT_CONTENT_CHARSET);
		} catch (UnsupportedEncodingException e) {
			log.log(Level.SEVERE, encoding + " is not supported", e);
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Returns a String that is suitable for use as an
	 * <code>application/x-www-form-urlencoded</code> list of parameters in an
	 * HTTP PUT or HTTP POST. It can also be used as query string in a GET
	 * request
	 * 
	 * @param parameters
	 *            The parameters to include.
	 * @param encoding
	 *            The encoding to use.
	 * 
	 * @return the formated string
	 */
	public static String formatQueryString(
			final List<? extends NameValuePair> parameters,
			final String encoding) {
		final StringBuilder result = new StringBuilder();
		for (final NameValuePair parameter : parameters) {
			final String encodedName = encode(parameter.getName(), encoding);
			final String value = parameter.getValue();
			final String encodedValue = value != null ? encode(value, encoding)
					: "";
			if (result.length() > 0) {
				result.append("&");
			}
			result.append(encodedName);
			if (value != null) {
				result.append("=");
				result.append(encodedValue);
			}
		}
		return result.toString();
	}
}