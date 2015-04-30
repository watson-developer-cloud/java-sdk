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

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility class to manage service responses
 * 
 * @author German Attanasio Ruiz <germanatt@us.ibm.com>
 * @see org.apache.http.HttpResponse HttpResponse
 */
public class ResponseUtil {
	private static final Logger log = Logger.getLogger(ResponseUtil.class
			.getName());
	public static final int BUFFER_SIZE = 8192; // 8 kb

	/**
	 * Returns a JSON {@link String} in human-readable form.
	 * 
	 * @param json
	 *            the JSON string
	 * @return the humar-readable string
	 */
	public static String formatJSON(String json) {
		try {
			return new JSONObject(json).toString(4);
		} catch (JSONException e) {
			log.log(Level.SEVERE,json + " is not a JSONObject", e);
			try {
				return new JSONArray(json).toString(4);
			} catch (JSONException e2) {
				log.log(Level.SEVERE,json + " is not a JSONArray", e2);
				return json;
			}
		}
	}

	/**
	 * Return a JSON representation of the response.
	 * 
	 * @param response
	 *            the HttpResponse
	 * @return the content body as JSON
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static JSONObject getJSON(HttpResponse response) throws IOException {
		final String json = getString(response);
		if (json == null || json.length() == 0)
			throw new IOException("JSON response is empty");
		try {
			return new JSONObject(json);
		} catch (JSONException e) {
			log.log(Level.SEVERE,json + " is not a JSONObject", e);
			throw new IOException("could not parse JSON document: "+ e.getMessage());
		}
	}

	/**
	 * Returns a JSONArray representation of the response.
	 * 
	 * @param response
	 *            an HTTP response
	 * @return the content body as JSONArray
	 * @throws IOException
	 *             network error
	 */
	public static JSONArray getJSONArray(HttpResponse response)
			throws IOException {
		final String json = getString(response);
		if (json == null || json.length() == 0)
			throw new IOException("JSON response is empty");
		try {
			return new JSONArray(json);
		} catch (JSONException e) {
			log.log(Level.SEVERE,json + " is not a JSONObject", e);
			throw new IOException("could not parse JSON document: "
					+ e.getMessage()+ " "
					+ (json.length() > 80 ? json.substring(0, 79) + "...": json));
		}
	}

	/**
	 * Returns a String representation of the response.
	 * 
	 * @param response
	 *            an HTTP response
	 * @return the content body as String
	 * @throws IOException
	 *             network error
	 * */
	public static String getString(HttpResponse response) throws IOException {
		InputStream is;
		try {
			is = response.getEntity().getContent();
			if (is == null)
				return null;

			int length = BUFFER_SIZE;
			Header contentLength = response.getFirstHeader(HTTP.CONTENT_LEN);

			if (contentLength != null) {
				try {
					length = Integer.parseInt(contentLength.getValue());
				} catch (NumberFormatException e) {
					log.log(Level.SEVERE,contentLength.getValue() + " is not a number", e);
					throw new RuntimeException(e);
				}
			}

			final StringBuilder sb = new StringBuilder(length);
			int n;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((n = is.read(buffer)) != -1) {
				sb.append(new String(buffer, 0, n));
			}
			return sb.toString();
		} catch (IOException e) {
			log.log(Level.SEVERE,"Could not read service response", e);
			throw new IOException("Could not read service response:"
					+ e.getMessage());
		}
	}
	/**
	 * Returns a String representation of the response.
	 * 
	 * @param response
	 *            an HTTP response
	 * @return the content body as String
	 * @throws IOException
	 *             network error
	 * */
	public static InputStream getInputStream(HttpResponse response) throws IOException {
		InputStream is;
		try {
			is = response.getEntity().getContent();
			if (is == null)
				return null;
		} catch (IOException e) {
			log.log(Level.SEVERE,"Could not read service response", e);
			throw new IOException("Could not read service response:"
					+ e.getMessage());
		}
		return is;
	}
}
