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
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.squareup.okhttp.Response;

/**
 * Utility class to manage service responses.
 * 
 * @see Response
 */
public class ResponseUtils {

  /** The Constant ERROR_MESSAGE. */
  private static final String ERROR_MESSAGE = "Error reading the http response";

  /** The Constant LOG. */
  private static final Logger LOG = Logger.getLogger(ResponseUtils.class.getName());

  /**
   * Returns the HTTP Response {@link InputStream}.
   * 
   * @param response an HTTP response
   * @return the content body as an InputStream
   */
  public static InputStream getInputStream(Response response) {
    try {
      return response.body().byteStream();
    } catch (final IOException e) {
      LOG.log(Level.SEVERE, ERROR_MESSAGE, e);
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
      LOG.log(Level.SEVERE, ERROR_MESSAGE, e);
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
   * Returns a {@link JsonObject} representation of the provided JSON.
   * 
   * @param jsonString the JSON String
   * @return the content body as a JsonObject
   */
  public static JsonObject getJsonObject(String jsonString) {
    return new JsonParser().parse(jsonString).getAsJsonObject();
  }

  /**
   * Parses the response into the POJO representation
   * 
   * @param <T> the generic type to use when parsing the response
   * @param response the HTTP response
   * @param type the type of the response
   * @return the POJO
   */
  public static <T extends GenericModel> T getObject(Response response, Class<T> type) {
    JsonReader reader;
    try {
      Reader stream = response.body().charStream();
      reader = new JsonReader(stream);
      final T model = GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(reader, type);
      stream.close();
      return model;
    } catch (IOException e) {
      LOG.log(Level.SEVERE, ERROR_MESSAGE, e);
      throw new RuntimeException(ERROR_MESSAGE, e);
    } finally {
      try {
        response.body().close();
      } catch (IOException e) {
        LOG.log(Level.SEVERE, "Error closing the HTTP Response", e);
      }
    }
  }


  /**
   * Returns a String representation of the response.
   * 
   * @param response an HTTP response
   * @return the content body as String
   */
  public static String getString(Response response) {
    try {
      return response.body().string();
    } catch (final IOException e) {
      LOG.log(Level.SEVERE, ERROR_MESSAGE, e);
      throw new RuntimeException(ERROR_MESSAGE, e);
    }
  }

}
