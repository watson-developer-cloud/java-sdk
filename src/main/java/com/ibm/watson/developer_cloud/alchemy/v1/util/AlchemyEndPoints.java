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
public class AlchemyEndPoints {

  /**
   * The AlchemyOperations.
   */
  public enum AlchemyAPI {

    /** The authors. */
    authors,

    /** The combined. */
    combined,

    /** The concepts. */
    concepts,

    /** The entities. */
    entities,

    /** The feeds. */
    feeds,

    /** The image_keywords. */
    image_keywords,

    /** The image_link. */
    image_link,

    /** The image_recognition. */
    image_recognition,

    /** The image_scene_text. */
    image_scene_text,

    /** The keywords. */
    keywords,

    /** The language. */
    language,

    /** The microformats. */
    microformats,

    /** The relations. */
    relations,

    /** The sentiment. */
    sentiment,

    /** The sentiment_targeted. */
    sentiment_targeted,

    /** The taxonomy. */
    taxonomy,

    /** The text. */
    text,

    /** The text_raw. */
    text_raw,

    /** The title. */
    title,

    /** The publication date */
    publication_date,

    /** dates */
    dates,

    /** emotion */
    emotion
  }

  /** The file where alchemy endpoints are described. */
  private static final String filePath = "/alchemy_endpoints.json";

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(AlchemyEndPoints.class.getName());

  /** The alchemy operations. */
  private static Map<String, Map<String, String>> operations;

  static {
    loadEndPointsFromJsonFile();
  }

  /**
   * Gets the path based on the operation and input type.
   * 
   * @param operation the operation
   * @param inputType the input type
   * @return the string that represent the path based on the operation and input type
   */
  public static String getPath(AlchemyAPI operation, String inputType) {
    if ((operations.get(operation.name()) != null)
        && operations.get(operation.name()).get(inputType) != null) {
      return operations.get(operation.name()).get(inputType);
    } else {
      final String error = "Operation: " + operation + ", inputType: " + inputType + " not found";
      log.log(Level.SEVERE, error);
      throw new IllegalArgumentException(error);
    }
  }

  /**
   * Load the endpoints from json file.
   */
  private static void loadEndPointsFromJsonFile() {
    log.log(Level.FINE, "Parsing End Points JSON file ");
    operations = new HashMap<String, Map<String, String>>();
    final JsonParser parser = new JsonParser();

    Reader fileReader = null;
    try {
      final InputStream is = AlchemyEndPoints.class.getResourceAsStream(filePath);
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
          operations.put(object.name(), records);
        }
      }
    } catch (final JsonParseException e) {
      log.log(Level.SEVERE, "Could not parse json file: " + filePath, e);
    } catch (final NullPointerException e) {
      log.log(Level.SEVERE, "Not able to locate the end points json file: " + filePath, e);
    } finally {
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (final IOException e) {
          log.log(Level.SEVERE, "Could not close file reader: " + filePath, e);
        }
      }
    }
  }

}
