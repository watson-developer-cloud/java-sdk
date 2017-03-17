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
package com.ibm.watson.developer_cloud.document_conversion.v1.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

/**
 * The utilities required for processing the documents in the service.
 *
 * @see DocumentConversion
 */
public final class ConversionUtils {

  private static final Map<String, String> MEDIA_TYPES;

  static {
    MEDIA_TYPES = new HashMap<String, String>();

    MEDIA_TYPES.put(".htm", HttpMediaType.TEXT_HTML);
    MEDIA_TYPES.put(".html", HttpMediaType.TEXT_HTML);
    MEDIA_TYPES.put(".dot", HttpMediaType.APPLICATION_MS_WORD);
    MEDIA_TYPES.put(".doc", HttpMediaType.APPLICATION_MS_WORD);
    MEDIA_TYPES.put(".docx", HttpMediaType.APPLICATION_MS_WORD_DOCX);
    MEDIA_TYPES.put(".xml", HttpMediaType.APPLICATION_XHTML_XML);
    MEDIA_TYPES.put(".xhtml", HttpMediaType.APPLICATION_XHTML_XML);
    MEDIA_TYPES.put(".pdf", HttpMediaType.APPLICATION_PDF);
  }

  /**
   * Returns the media type for a given file.
   *
   * @param file the file object for which media type needs to be provided
   * @return Internet media type for the file, or null if none found
   */
  public static String getMediaTypeFromFile(final File file) {
    if (file == null) {
      return null;
    }

    final String fileName = file.getName();
    final int i = fileName.lastIndexOf('.');

    if (i == -1) {
      return null;
    }

    return MEDIA_TYPES.get(fileName.substring(i).toLowerCase());
  }

  /**
   * Checks if the media type is supported by the service.
   *
   * @param mediaType Internet media type for the file
   * @return true if it is supported, false if not.
   */
  public static boolean isValidMediaType(final String mediaType) {
    return (mediaType != null) && MEDIA_TYPES.values().contains(mediaType.toLowerCase());

  }

  /**
   * Loads a custom configuration from the input stream specified.
   *
   * @param customConfig input stream for the custom configuration
   * @return the custom configuration as a JsonObject
   */
  public static JsonObject loadCustomConfig(InputStream customConfig) {
    final Reader reader = new InputStreamReader(customConfig);
    return new JsonParser().parse(reader).getAsJsonObject();
  }

  /**
   * Write input stream to output stream.
   *
   * @param is the input stream
   * @return String
   */
  public static String writeInputStreamToString(InputStream is) {
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    try {
      while ((length = is.read(buffer)) != -1) {
        result.write(buffer, 0, length);
      }
      return result.toString("UTF-8");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private ConversionUtils() {
    // This is a utility class - no instantiation allowed.
  }

}
