/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.util;

import java.io.InputStream;
import java.lang.reflect.Type;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.ResponseConverter;

import com.ibm.watson.developer_cloud.service.model.ObjectModel;
import okhttp3.Response;

/**
 * Utility class to convert service responses into a {@link ResponseConverter}.
 *
 * @see ResponseConverter
 */
public final class ResponseConverterUtils {

  private ResponseConverterUtils() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Creates a generic {@link ResponseConverter} for a generic class.
   *
   * @param <T> the generic type
   * @param type the type
   * @param property the property
   * @return the object converter
   */
  public static <T> ResponseConverter<T> getGenericObject(final Type type, final String property) {
    return new ResponseConverter<T>() {
      @Override
      public T convert(Response response) {
        JsonObject json = ResponseUtils.getJsonObject(response);
        return GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(json.get(property), type);
      }
    };
  }

  /**
   * Creates an {@link InputStream} converter.
   *
   * @return the input stream converter
   */
  public static ResponseConverter<InputStream> getInputStream() {
    return new ResponseConverter<InputStream>() {
      @Override
      public InputStream convert(Response response) {
        return ResponseUtils.getInputStream(response);
      }
    };
  }

  /**
   * Creates a generic {@link ResponseConverter} for a POJO class. <br>
   * It should extend {@link ObjectModel}
   *
   * @param <T> the generic type
   * @param type the type
   * @return the response converter
   */
  public static <T extends ObjectModel> ResponseConverter<T> getObject(final Class<? extends T> type) {
    return new ResponseConverter<T>() {
      @Override
      public T convert(Response response) {
        return ResponseUtils.getObject(response, type);
      }
    };
  }

  /**
   * Creates a generic {@link ResponseConverter} for a String response.
   *
   * @return the string
   */
  public static ResponseConverter<String> getString() {
    return new ResponseConverter<String>() {
      @Override
      public String convert(Response response) {
        return ResponseUtils.getString(response);
      }
    };
  }

  /**
   * Gets the void converter.
   *
   * @return the void converter
   */
  public static ResponseConverter<Void> getVoid() {
    return new ResponseConverter<Void>() {
      @Override
      public Void convert(Response response) {
        ResponseUtils.getString(response); // read the response to prevent a connection leak
        return null;
      }
    };
  }
}
