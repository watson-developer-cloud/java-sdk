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
package com.ibm.watson.developer_cloud.http;

import com.squareup.okhttp.MediaType;

/**
 * An abstraction for a media type. Instances are immutable.
 * 
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.7">HTTP/1.1 section
 *      3.7</a>
 */
public interface HttpMediaType {

  /**
   * Field APPLICATION_ATOM_XML. (value is "application/atom+xml")
   */
  String APPLICATION_ATOM_XML = "application/atom+xml";
  /**
   * Field APPLICATION_FORM_URLENCODED. (value is "application/x-www-form-urlencoded")
   */
  String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
  /**
   * Field APPLICATION_JSON. (value is "application/json")
   */
  String APPLICATION_JSON = "application/json";
  /**
   * Field APPLICATION_MS_WORD. (value is "application/msword")
   */
  String APPLICATION_MS_WORD = "application/msword";

  /**
   * Field APPLICATION_MS_WORD_DOCX. (value is
   * "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
   */
  String APPLICATION_MS_WORD_DOCX =
      "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

  /**
   * Field APPLICATION_OCTET_STREAM. (value is "application/octet-stream")
   */
  String APPLICATION_OCTET_STREAM = "application/octet-stream";
  /**
   * Field APPLICATION_PDF. (value is "application/pdf")
   */
  String APPLICATION_PDF = "application/pdf";
  /**
   * Field APPLICATION_SVG_XML. (value is "application/svg+xml")
   */
  String APPLICATION_SVG_XML = "application/svg+xml";
  /**
   * Field APPLICATION_XHTML_XML. (value is "application/xhtml+xml")
   */
  String APPLICATION_XHTML_XML = "application/xhtml+xml";
  /**
   * Field APPLICATION_ZIP. (value is "application/zip")
   */
  String APPLICATION_ZIP = "application/zip";

  /**
   * Field APPLICATION_XML. (value is "application/xml")
   */
  String APPLICATION_XML = "application/xml";
  /**
   * Field AUDIO_OGG. (value is "audio/ogg; codecs=opus")
   */
  String AUDIO_OGG = "audio/ogg; codecs=opus";
  /**
   * Field AUDIO_WAV. (value is "audio/wav")
   */
  String AUDIO_WAV = "audio/wav";

  /**
   * Field AUDIO_FLAC. (value is "audio/flac")
   */
  String AUDIO_FLAC = "audio/flac";

  /**
   * Field AUDIO_RAW. (value is "audio/l16")
   */
  String AUDIO_RAW = "audio/l16";

  /**
   * Field BINARY_FILE. (value is "application/octet-stream")
   */
  MediaType BINARY_FILE = MediaType.parse(APPLICATION_OCTET_STREAM);
  /**
   * Field BINARY_OCTET_STREAM. (value is "binary/octet-stream")
   */
  String BINARY_OCTET_STREAM = "binary/octet-stream";
  /**
   * Field JSON. (value is "application/json; charset=utf-8")
   */
  MediaType JSON = MediaType.parse(APPLICATION_JSON + "; charset=utf-8");
  /**
   * Field MEDIA_TYPE_WILDCARD. (value is "*")
   */
  String MEDIA_TYPE_WILDCARD = "*";
  /**
   * Field MULTIPART_FORM_DATA. (value is "multipart/form-data")
   */
  String MULTIPART_FORM_DATA = "multipart/form-data";
  /**
   * Field TEXT_CSV. (value is "text/csv")
   */
  String TEXT_CSV = "text/csv";

  /**
   * Field TEXT_HTML. (value is "text/html")
   */
  String TEXT_HTML = "text/html";

  /**
   * Field TEXT_PLAIN. (value is "text/plain")
   */
  String TEXT_PLAIN = "text/plain";

  /**
   * Field TEXT. (value is "text/plain; charset=utf-8")
   */
  MediaType TEXT = MediaType.parse(TEXT_PLAIN + "; charset=utf-8");

  /**
   * Field TEXT_XML. (value is "text/xml")
   */
  String TEXT_XML = "text/xml";

  /**
   * Field WILDCARD. (value is "*\/*")
   */
  String WILDCARD = "*/*";
}
