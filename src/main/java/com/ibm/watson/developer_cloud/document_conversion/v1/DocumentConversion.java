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
package com.ibm.watson.developer_cloud.document_conversion.v1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionTarget;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * The IBM Watson Document Conversion service converts provided source documents (HTML, Word, PDF)
 * into JSON Answer Units, Normalized HTML, or Normalized Text.
 * 
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/document-conversion.html">
 *      Document Conversion</a>
 */
public class DocumentConversion extends WatsonService {
  private static final Logger LOG = Logger.getLogger(DocumentConversion.class.getName());

  /** The Constant CONVERSION_TARGET. */
  private static final String CONVERSION_TARGET = "conversion_target";

  /**
   * The CONVERT_DOCUMENT_PATH. (value is "/v1/convert_document")
   **/
  private static final String CONVERT_DOCUMENT_PATH = "/v1/convert_document";

  /** The default URL for the service. */
  private static final String URL =
      "https://gateway.watsonplatform.net/document-conversion-experimental/api";

  /**
   * Sets the endpoint url for the service.
   */
  public DocumentConversion() {
    super("document_conversion");
    setEndPoint(URL);
  }

  /**
   * Converts a document and returns an {@link InputStream}.
   * 
   * @param document The file to convert
   * @param mediaType Internet media type of the file
   * @param conversionTarget The conversion target to use
   * @return Converted document in the specified format
   * @See {@link HttpMediaType} for available media types
   */
  private InputStream convertDocument(final File document, final String mediaType,
      final ConversionTarget conversionTarget) {

    if (document == null || !document.exists()) {
      throw new IllegalArgumentException("document cannot be null and must exist");
    }

    final String type =
        mediaType != null ? mediaType : ConversionUtils.getMediaTypeFromFile(document);
    if (type == null) {
      throw new RuntimeException("mediaType cannot be null or empty");
    } else if (!ConversionUtils.isValidMediaType(type)) {
      throw new IllegalArgumentException("file with the given media type is not supported");
    }

    final JsonObject configJson = new JsonObject();
    configJson.addProperty(CONVERSION_TARGET, conversionTarget.toString());

    final MediaType mType = MediaType.parse(type);
    final RequestBody body =
        new MultipartBuilder()
            .type(MultipartBuilder.FORM)
            .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"config\""),
                RequestBody.create(HttpMediaType.JSON, configJson.toString()))
            .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"file\""),
                RequestBody.create(mType, document)).build();

    final Request request = RequestBuilder.post(CONVERT_DOCUMENT_PATH).withBody(body).build();

    final Response response = execute(request);
    return ResponseUtil.getInputStream(response);
  }

  /**
   * Converts a document to Answer Units. <br>
   * Use {@link DocumentConversion#convertDocumentToAnswer(File, String)} if you want to specify the
   * media type
   * 
   * @param document the document
   * @return Converted document as {@link Answers}
   * 
   */
  public Answers convertDocumentToAnswer(File document) {
    return convertDocumentToAnswer(document, null);
  }

  /**
   * Converts a document to Answer Units.
   * 
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided
   * @return Converted document as {@link Answers}
   * @See {@link HttpMediaType} for available media types
   */
  public Answers convertDocumentToAnswer(File document, String mediaType) {
    final InputStream is = convertDocument(document, mediaType, ConversionTarget.ANSWER_UNITS);
    final String convertedDocument = ConversionUtils.writeInputStreamToString(is);
    try {
      is.close();
    } catch (final IOException e) {
      LOG.log(Level.WARNING, "Unable to close document input stream", e);
    }
    return GsonSingleton.getGson().fromJson(convertedDocument, Answers.class);
  }

  /**
   * Converts a document to HTML. <br>
   * Use {@link DocumentConversion#convertDocumentToHTML(File, String)} if you want to specify the
   * media type.
   * 
   * @param document the document
   * @return Converted document as {@link String}
   */
  public String convertDocumentToHTML(File document) {
    return convertDocumentToHTML(document, null);
  }

  /**
   * Converts a document to HTML.
   * 
   * @param document the document
   * @param mediaType document the document media type. It will use the file extension if not
   *        provided
   * @return Converted document as {@link String}
   * @See {@link HttpMediaType} for available media types
   */
  public String convertDocumentToHTML(File document, String mediaType) {
    final InputStream is = convertDocument(document, mediaType, ConversionTarget.NORMALIZED_HTML);
    try {
      return ConversionUtils.writeInputStreamToString(is);
    } finally {
      try {
        is.close();
      } catch (final IOException e) {
        LOG.log(Level.WARNING, "Unable to close document input stream", e);
      }
    }
  }

  /**
   * Converts a document to Text. <br>
   * Use {@link DocumentConversion#convertDocumentToText(File, String)} if you want to specify the
   * media type.
   * 
   * @param document the document
   * @return Converted document as {@link String}
   */
  public String convertDocumentToText(File document) {
    return convertDocumentToText(document, null);
  }

  /**
   * Converts a document to Text.
   * 
   * @param document the document
   * @param mediaType document the document media type. It will use the file extension if not
   *        provided
   * @return Converted document as {@link String}
   * @See {@link HttpMediaType} for available media types
   */
  public String convertDocumentToText(File document, String mediaType) {
    final InputStream is = convertDocument(document, mediaType, ConversionTarget.NORMALIZED_TEXT);
    try {
      return ConversionUtils.writeInputStreamToString(is);
    } finally {
      try {
        is.close();
      } catch (final IOException e) {
        LOG.log(Level.WARNING, "Unable to close document input stream", e);
      }
    }
  }
}
