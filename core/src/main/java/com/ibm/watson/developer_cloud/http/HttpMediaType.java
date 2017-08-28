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
package com.ibm.watson.developer_cloud.http;

import okhttp3.MediaType;

/**
 * An abstraction for a media type. Instances are immutable.
 *
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.7">HTTP/1.1 section 3.7</a>
 */
public final class HttpMediaType {

  private HttpMediaType() {
    // This is a utility class - no instantiation allowed.
  }

  /**
   * Field APPLICATION_ATOM_XML. (value is "application/atom+xml")
   */
  public static final String APPLICATION_ATOM_XML = "application/atom+xml";
  /**
   * Field APPLICATION_FORM_URLENCODED. (value is "application/x-www-form-urlencoded")
   */
  public static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
  /**
   * Field APPLICATION_JSON. (value is "application/json")
   */
  public static final String APPLICATION_JSON = "application/json";
  /**
   * Field APPLICATION_MS_WORD. (value is "application/msword")
   */
  public static final String APPLICATION_MS_WORD = "application/msword";

  /**
   * Field APPLICATION_MS_WORD_DOCX. (value is
   * "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
   */
  public static final String APPLICATION_MS_WORD_DOCX =
      "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

  /**
   * Field APPLICATION_OCTET_STREAM. (value is "application/octet-stream")
   */
  public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
  /**
   * Field APPLICATION_PDF. (value is "application/pdf")
   */
  public static final String APPLICATION_PDF = "application/pdf";
  /**
   * Field APPLICATION_SVG_XML. (value is "application/svg+xml")
   */
  public static final String APPLICATION_SVG_XML = "application/svg+xml";
  /**
   * Field APPLICATION_XHTML_XML. (value is "application/xhtml+xml")
   */
  public static final String APPLICATION_XHTML_XML = "application/xhtml+xml";
  /**
   * Field APPLICATION_ZIP. (value is "application/zip")
   */
  public static final String APPLICATION_ZIP = "application/zip";

  /**
   * Field APPLICATION_XML. (value is "application/xml")
   */
  public static final String APPLICATION_XML = "application/xml";
  /**
   * Field AUDIO_OGG. (value is "audio/ogg; codecs=opus")
   */
  public static final String AUDIO_OGG = "audio/ogg; codecs=opus";

  /**
   * Field AUDIO_OGG_VORBIS. (value is "audio/ogg; codecs=vorbis")
   */
  public static final String AUDIO_OGG_VORBIS = "audio/ogg; codecs=vorbis";

  /**
   * Field AUDIO_WAV. (value is "audio/wav")
   */
  public static final String AUDIO_WAV = "audio/wav";

  /**
   * Field AUDIO_WEBM. (value is "audio/webm")
   */
  public static final String AUDIO_WEBM = "audio/webm";

  /**
   * Field AUDIO_WEBM_VORBIS. (value is "audio/webm; codecs=vorbis")
   */
  public static final String AUDIO_WEBM_VORBIS = "audio/webm; codecs=vorbis";

  /**
   * Field AUDIO_WEBM_OPUS. (value is "audio/webm; codecs=opus")
   */
  public static final String AUDIO_WEBM_OPUS = "audio/webm; codecs=opus";

  /**
   * Field AUDIO_PCM. (value is "audio/l16")
   */
  public static final String AUDIO_PCM = "audio/l16";

  /**
   * Field AUDIO_BASIC. (value is "audio/basic")
   */
  public static final String AUDIO_BASIC = "audio/basic";

  /**
   * Field AUDIO_FLAC. (value is "audio/flac")
   */
  public static final String AUDIO_FLAC = "audio/flac";

  /**
   * Field AUDIO_MULAW. (value is "audio/mulaw")
   */
  public static final String AUDIO_MULAW = "audio/mulaw";

  /**
   * Field AUDIO_MP3. (value is "audio/mp3")
   */
  public static final String AUDIO_MP3 = "audio/mp3";

  /**
   * Field AUDIO_MPEG. (value is "audio/mpeg")
   */
  public static final String AUDIO_MPEG = "audio/mpeg";

   /**
   * Field AUDIO_RAW. (value is "audio/l16") <br>
   * When using in Speech to Text a sample rate must be provided
   */
  public static final String AUDIO_RAW = "audio/l16";

  /**
   * Creates an <code>audio/l16</code> media type that includes sample rate.
   *
   * @param rate The sample rate
   * @return <code>audio/l16; rate={rate}</code>
   */
  public static String createAudioRaw(int rate) {
    return AUDIO_RAW + "; rate=" + rate;
  };

  /**
   * Field BINARY_FILE. (value is "application/octet-stream")
   */
  public static final MediaType BINARY_FILE = MediaType.parse(APPLICATION_OCTET_STREAM);

  /**
   * Field BINARY_OCTET_STREAM. (value is "binary/octet-stream")
   */
  public static final String BINARY_OCTET_STREAM = "binary/octet-stream";

  /**
   * Field JSON. (value is "application/json; charset=utf-8")
   */
  public static final MediaType JSON = MediaType.parse(APPLICATION_JSON + "; charset=utf-8");
  /**
   * Field MEDIA_TYPE_WILDCARD. (value is "*")
   */
  public static final String MEDIA_TYPE_WILDCARD = "*";
  /**
   * Field MULTIPART_FORM_DATA. (value is "multipart/form-data")
   */
  public static final String MULTIPART_FORM_DATA = "multipart/form-data";
  /**
   * Field TEXT_CSV. (value is "text/csv")
   */
  public static final String TEXT_CSV = "text/csv";

  /**
   * Field TEXT_HTML. (value is "text/html")
   */
  public static final String TEXT_HTML = "text/html";

  /**
   * Field TEXT_PLAIN. (value is "text/plain")
   */
  public static final String TEXT_PLAIN = "text/plain";

  /**
   * Field TEXT. (value is "text/plain; charset=utf-8")
   */
  public static final MediaType TEXT = MediaType.parse(TEXT_PLAIN + "; charset=utf-8");

  /**
   * Field TEXT_XML. (value is "text/xml")
   */
  public static final String TEXT_XML = "text/xml";

  /**
   * Field WILDCARD. (value is "*\/*")
   */
  public static final String WILDCARD = "*/*";

}
