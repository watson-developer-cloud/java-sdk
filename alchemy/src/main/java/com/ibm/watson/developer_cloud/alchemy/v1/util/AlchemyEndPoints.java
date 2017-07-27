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

package com.ibm.watson.developer_cloud.alchemy.v1.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/**
 * The Class AlchemyEndPoints.
 *
 */
public final class AlchemyEndPoints {

  /**
   * The AlchemyOperations.
   */
  public enum AlchemyAPI {

    /** The authors. */
    AUTHORS,

    /** The combined. */
    COMBINED,

    /** The concepts. */
    CONCEPTS,

    /** dates. */
    DATES,

    /** emotion. */
    EMOTION,

    /** The entities. */
    ENTITIES,

    /** The feeds. */
    FEEDS,

    /** The image_keywords. */
    IMAGE_KEYWORDS,

    /** The image_link. */
    IMAGE_LINK,

    /** The image_recognition. */
    IMAGE_RECOGNITION,

    /** The image_scene_text. */
    IMAGE_SCENE_TEXT,

    /** The keywords. */
    KEYWORDS,

    /** The language. */
    LANGUAGE,

    /** The microformats. */
    MICROFORMATS,

    /** The publication date. */
    PUBLICATION_DATE,

    /** The relations. */
    RELATIONS,

    /** The sentiment. */
    SENTIMENT,

    /** The sentiment_targeted. */
    SENTIMENT_TARGETED,

    /** The taxonomy. */
    TAXONOMY,

    /** The text. */
    TEXT,

    /** The text_raw. */
    TEXT_RAW,

    /** The title. */
    TITLE,

    /** The typed. */
    TYPED
  }

  private static final String FILE_PATH = "/alchemy_endpoints.json";
  private static final Logger LOG = Logger.getLogger(AlchemyEndPoints.class.getName());
  private static Map<String, Map<String, String>> operationsByEndpoint;

  static {
    loadEndPointsFromJsonFile();
  }

  private AlchemyEndPoints() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Load the endpoints from json file.
   */
  private static void loadEndPointsFromJsonFile() {
    LOG.log(Level.FINE, "Parsing End Points JSON file ");
    operationsByEndpoint = new HashMap<String, Map<String, String>>();
    final JsonParser parser = new JsonParser();

    Reader fileReader = null;
    try {
      final InputStream is = AlchemyEndPoints.class.getResourceAsStream(FILE_PATH);
      if (null != is) {
        fileReader = new InputStreamReader(is);
      }
      final Object obj = parser.parse(fileReader);
      final JsonObject jsonObject = (JsonObject) obj;
      for (final AlchemyAPI object : AlchemyAPI.values()) {
        if (jsonObject.get(object.name()) == null) {
          continue;
        }
        final JsonElement elt = jsonObject.get(object.name()).getAsJsonObject();
        if (elt.isJsonObject()) {
          final Map<String, String> records = new HashMap<String, String>();
          for (final Map.Entry<String, JsonElement> e : elt.getAsJsonObject().entrySet()) {
            records.put(e.getKey(), e.getValue().getAsString());
          }
          operationsByEndpoint.put(object.name(), records);
        }
      }
    } catch (final JsonParseException e) {
      LOG.log(Level.SEVERE, "Could not parse json file: " + FILE_PATH, e);
    } catch (final NullPointerException e) {
      LOG.log(Level.SEVERE, "Not able to locate the end points json file: " + FILE_PATH, e);
    } finally {
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (final IOException e) {
          LOG.log(Level.SEVERE, "Could not close file reader: " + FILE_PATH, e);
        }
      }
    }
  }

  /**
   * Gets the path based on the operation and input type.
   *
   * @param operation the operation
   * @param inputType the input type
   * @return the string that represent the path based on the operation and input type
   */
  public static String getPath(AlchemyAPI operation, String inputType) {
    if ((operationsByEndpoint.get(operation.name()) != null)
        && (operationsByEndpoint.get(operation.name()).get(inputType) != null)) {
      return operationsByEndpoint.get(operation.name()).get(inputType);
    } else {
      final String error = "Operation: " + operation + ", inputType: " + inputType + " not found";
      LOG.log(Level.SEVERE, error);
      throw new IllegalArgumentException(error);
    }
  }

}
