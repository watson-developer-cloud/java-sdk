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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Utility class to manage service responses.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @see org.apache.http.HttpResponse HttpResponse
 */
public class ResponseUtil {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(ResponseUtil.class
			.getName());
	
	/** The Constant BUFFER_SIZE. */
	public static final int BUFFER_SIZE = 8192; // 8 kb

	/**
	 * Return a {@link JsonElement} representation of the response.
	 * 
	 * @param response
	 *            the HttpResponse
	 * @return the content body as JSON
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static JsonElement getJsonElement(HttpResponse response) throws IOException {
		final String json = getString(response);
		if (json == null || json.length() == 0)
			throw new IOException("JSON response is empty");

		JsonElement element = new JsonParser().parse(json);
		return element;
	}

	/**
	 * Returns a {@link JsonObject} representation of the response.
	 *
	 * @param response            an HTTP response
	 * @return the content body as JSONArray
	 * @throws IOException  If an input or output
	 * 						exception occurred
	 */
	public static JsonObject getJsonObject(HttpResponse response) throws IOException {
		return getJsonElement(response).getAsJsonObject();
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
		HttpEntity entity;
		try {
			entity = response.getEntity();
			if (entity == null)
				return null;
			else
				return EntityUtils.toString(entity, "UTF-8");
		} catch (ParseException e) {
			log.log(Level.SEVERE,"Could not parse service response", e);
			throw new IOException("Could not parse service response:" + e.getMessage());
		}  catch (IOException e) {
			log.log(Level.SEVERE,"Could not read service response", e);
			throw new IOException("Could not read service response:" + e.getMessage());
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
	
	
	/**
	 * Returns <T> after parsing the string response.
	 *
	 * @param <T> the generic type to use when parsing the response
	 * @param response the http response
	 * @param type the type of the response 
	 * @return the object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static <T> T getObject(HttpResponse response, Class<T> type) throws IOException {
		String jsonString = getString(response);
		
		T pojo = (T) GsonSingleton.getGson().fromJson(jsonString, type);
		return pojo;
	}

}
