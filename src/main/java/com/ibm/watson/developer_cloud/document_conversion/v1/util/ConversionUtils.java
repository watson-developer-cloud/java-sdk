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
package com.ibm.watson.developer_cloud.document_conversion.v1.util;

import java.io.File;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

/**
 * The utilities required for processing the documents in the service.
 * 
 * @see DocumentConversion
 */
public class ConversionUtils {

  /**
   * Returns the media type for a given file.
   * 
   * @param file the file object for which media type needs to be provided
   * @return Internet media type for the file
   */
  public static String getMediaTypeFromFile(final File file) {
    if (file != null) {
      final String fileName = file.getName().toLowerCase();
      final String[] supportedExtensions =
          {".htm", ".html", ".dot", ".doc", ".docx", ".xml", ".xhtml", ".pdf"};
      final String[] supportedMediaTypes =
          {HttpMediaType.TEXT_HTML, HttpMediaType.TEXT_HTML, HttpMediaType.APPLICATION_MS_WORD,
              HttpMediaType.APPLICATION_MS_WORD, HttpMediaType.APPLICATION_MS_WORD_DOCX,
              HttpMediaType.APPLICATION_XHTML_XML, HttpMediaType.APPLICATION_XHTML_XML,
              HttpMediaType.APPLICATION_PDF};

      for (int i = 0; i < supportedMediaTypes.length; i++) {
        if (fileName.endsWith(supportedExtensions[i])) {
          return supportedMediaTypes[i];
        }
      }
    }
    return null;
  }

  /**
   * Checks if the media type is supported by the service.
   * 
   * @param mediaType Internet media type for the file
   * @return true if it is supported, false if not.
   */
  public static Boolean isValidMediaType(final String mediaType) {
    if (mediaType != null) {
      final String[] supportedMediaTypes =
          {HttpMediaType.TEXT_HTML, HttpMediaType.APPLICATION_MS_WORD,
              HttpMediaType.APPLICATION_MS_WORD_DOCX, HttpMediaType.APPLICATION_XHTML_XML,
              HttpMediaType.APPLICATION_PDF};

      for (final String supportedMediaType : supportedMediaTypes) {
        if (mediaType.equalsIgnoreCase(supportedMediaType)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Write input stream to output stream.
   * 
   * @param is the input stream
   * @return String
   */
  public static String writeInputStreamToString(InputStream is) {
    final java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
    try {
      return s.hasNext() ? s.next() : "";
    } finally {
      s.close();
    }
  }
}
