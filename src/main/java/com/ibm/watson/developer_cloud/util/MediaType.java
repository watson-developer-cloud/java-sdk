/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.util;

/**
 * An abstraction for a media type. Instances are immutable.
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.7">HTTP/1.1
 *      section 3.7</a>
 */
public interface MediaType {

	/**
	 * Field APPLICATION_ATOM_XML. (value is "application/atom+xml")
	 */
	public final static String APPLICATION_ATOM_XML = "application/atom+xml";
	/**
	 * Field APPLICATION_FORM_URLENCODED. (value is "application/x-www-form-urlencoded")
	 */
	public final static String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
	/**
	 * Field APPLICATION_JSON. (value is "application/json")
	 */
	public final static String APPLICATION_JSON = "application/json";
	/**
	 * Field APPLICATION_OCTET_STREAM. (value is "application/octet-stream")
	 */
	public final static String APPLICATION_OCTET_STREAM = "application/octet-stream";

	/**
	 * Field BINARY_OCTET_STREAM. (value is "binary/octet-stream")
	 */
	public final static String BINARY_OCTET_STREAM = "binary/octet-stream";

	/**
	 * Field APPLICATION_SVG_XML. (value is "application/svg+xml")
	 */
	public final static String APPLICATION_SVG_XML = "application/svg+xml";
	/**
	 * Field APPLICATION_XHTML_XML. (value is "application/xhtml+xml")
	 */
	public final static String APPLICATION_XHTML_XML = "application/xhtml+xml";
	/**
	 * Field APPLICATION_XML. (value is "application/xml")
	 */
	public final static String APPLICATION_XML = "application/xml";
	/**
	 * Field AUDIO_OGG. (value is "audio/ogg; codecs=opus")
	 */
	public final static String AUDIO_OGG = "audio/ogg; codecs=opus";
	/**
	 * Field AUDIO_WAV. (value is "audio/wav")
	 */
	public final static String AUDIO_WAV = "audio/wav";
	/**
	 * Field MEDIA_TYPE_WILDCARD. (value is "*")
	 */
	public static final String MEDIA_TYPE_WILDCARD = "*";
	/**
	 * Field MULTIPART_FORM_DATA. (value is "multipart/form-data")
	 */
	public final static String MULTIPART_FORM_DATA = "multipart/form-data";
	/**
	 * Field TEXT_HTML. (value is "text/html")
	 */
	public final static String TEXT_HTML = "text/html";
	/**
	 * Field TEXT_PLAIN. (value is "text/plain")
	 */
	public final static String TEXT_PLAIN = "text/plain";
	/**
	 * Field TEXT_XML. (value is "text/xml")
	 */
	public final static String TEXT_XML = "text/xml";
	/**
	 * Field WILDCARD. (value is "*\/*")
	 */
	public final static String WILDCARD = "*/*";
	/**
	 * Field APPLICATION_PDF. (value is "application/pdf")
	 */
	public final static String APPLICATION_PDF = "application/pdf";
	/**
	 * Field APPLICATION_MS_WORD. (value is "application/msword")
	 */
	public final static String APPLICATION_MS_WORD = "application/msword";
	/**
	 * Field APPLICATION_MS_WORD_DOCX. (value is
	 * "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
	 */
	public final static String APPLICATION_MS_WORD_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

	/**
	 * Field TEXT_CSV. (value is "text/csv")
	 */
	public static final String TEXT_CSV = "text/csv";

}