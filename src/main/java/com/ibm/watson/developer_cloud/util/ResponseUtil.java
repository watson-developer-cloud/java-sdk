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
package com.ibm.watson.developer_cloud.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.Response;

/**
 * Utility class to manage service responses.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @see Response
 */
public class ResponseUtil {

  /** The Constant ERROR_MESSAGE. */
  private static final String ERROR_MESSAGE = "Error reading the http response";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(ResponseUtil.class.getName());

  /**
   * Returns the HTTP Response {@link InputStream}.
   * 
   * @param response an HTTP response
   * @return the content body as String
   * */
  public static InputStream getInputStream(Response response) {
    try {
      return response.body().byteStream();
    } catch (final IOException e) {
      log.log(Level.SEVERE, ERROR_MESSAGE, e);
      throw new RuntimeException(ERROR_MESSAGE, e);
    }
  }

  /**
   * Return a {@link JsonElement} representation of the response.
   * 
   * @param response the Response
   * @return the content body as JSON
   */
  public static JsonElement getJsonElement(Response response) {
    try {
      return new JsonParser().parse(response.body().charStream());
    } catch (final IOException e) {
      log.log(Level.SEVERE, ERROR_MESSAGE, e);
      throw new RuntimeException(ERROR_MESSAGE, e);
    }
  }

  /**
   * Returns a {@link JsonObject} representation of the response.
   * 
   * @param response an HTTP response
   * @return the content body as JSONArray
   */
  public static JsonObject getJsonObject(Response response) {
    return getJsonElement(response).getAsJsonObject();
  }

  /**
   * Returns <T> after parsing the string response.
   * 
   * @param <T> the generic type to use when parsing the response
   * @param response the HTTP response
   * @param type the type of the response
   * @return the object
   */
  public static <T> T getObject(Response response, Class<T> type) {
    final String jsonString = getString(response);
    return GsonSingleton.getGson().fromJson(jsonString, type);
  }


  /**
   * Returns a String representation of the response.
   * 
   * @param response an HTTP response
   * @return the content body as String
   * */
  public static String getString(Response response) {
    try {
      return response.body().string();
    } catch (final IOException e) {
      log.log(Level.SEVERE, ERROR_MESSAGE, e);
      throw new RuntimeException(ERROR_MESSAGE, e);
    }
  }

}
