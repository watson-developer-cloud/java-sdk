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

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson singleton to be use when transforming from JSON to Java Objects and vise versa. It handles date formatting and
 * pretty print the result
 */
public final class GsonSingleton {

  private static Gson gson;
  private static Gson gsonWithoutPrinting;

  private GsonSingleton() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Creates a {@link com.google.gson.Gson} object that can be use to serialize and deserialize Java objects.
   *
   * @param prettyPrint if true the JSON will be pretty printed
   * @return the {@link Gson}
   */
  private static Gson createGson(Boolean prettyPrint) {
    GsonBuilder builder = new GsonBuilder();

    registerTypeAdapters(builder);

    if (prettyPrint) {
      builder.setPrettyPrinting();
    }
    builder.disableHtmlEscaping();
    return builder.create();
  }

  private static void registerTypeAdapters(GsonBuilder builder) {
    // Date serializer and deserializer
    builder.registerTypeAdapter(Date.class, new DateDeserializer());
    builder.registerTypeAdapter(Date.class, new DateSerializer());
  }

  /**
   * Gets the Gson instance.
   *
   * @return the Gson
   */
  public static synchronized Gson getGson() {
    if (gson == null) {
      gson = createGson(true);
    }
    return gson;
  }

  /**
   * Gets the Gson instance.
   *
   * @return the Gson
   */
  public static synchronized Gson getGsonWithoutPrettyPrinting() {
    if (gsonWithoutPrinting == null) {
      gsonWithoutPrinting = createGson(false);
    }
    return gsonWithoutPrinting;
  }
}
