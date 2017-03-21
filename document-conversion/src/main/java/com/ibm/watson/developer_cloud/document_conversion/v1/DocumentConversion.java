/*
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
package com.ibm.watson.developer_cloud.document_conversion.v1;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexConfiguration;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexDocumentOptions;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionTarget;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * The IBM Watson Document Conversion service converts provided source documents (HTML, Word, PDF) into JSON Answer
 * Units, Normalized HTML, or Normalized Text.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/document-conversion.html"> Document Conversion</a>
 */
public class DocumentConversion extends WatsonService {

  private static final String CONVERSION_TARGET = "conversion_target";
  private static final String DRY_RUN = "dry_run";
  private static final String SERVICE_INSTANCE_ID = "service_instance_id";
  private static final String CLUSTER_ID = "cluster_id";
  private static final String SEARCH_COLLECTION = "search_collection";
  private static final String RETRIEVE_AND_RANK_FIELDS = "fields";
  private static final String RETRIEVE_AND_RANK = "retrieve_and_rank";
  private static final String CONVERT_DOCUMENT = "convert_document";
  private static final String CONVERT_DOCUMENT_PATH = "/v1/" + CONVERT_DOCUMENT;
  private static final String INDEX_DOCUMENT_PATH = "/v1/index_document";
  private static final JsonObject EMPTY_CONFIG = new JsonParser().parse("{ }").getAsJsonObject();
  private static final String SERVICE_NAME = "document_conversion";
  private static final String URL = "https://gateway.watsonplatform.net/document-conversion/api";

  /** The Constant VERSION_DATE_2015_12_01. */
  public static final String VERSION_DATE_2015_12_01 = "2015-12-01";

  private final String versionDate;

  /**
   * Instantiates a new document conversion.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   */
  public DocumentConversion(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new document conversion by username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *        calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public DocumentConversion(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Converts a document and returns an {@link InputStream}.
   *
   * @param document The file to convert
   * @param mediaType Internet media type of the file
   * @param conversionTarget The conversion target to use
   * @param customConfig The configuration parameters
   * @return Converted document in the specified format
   * @see HttpMediaType HttpMediaType for available media types
   */
  private Request createConversionRequest(final File document, final String mediaType,
      final ConversionTarget conversionTarget, final JsonObject customConfig) {

    if ((document == null) || !document.exists()) {
      throw new IllegalArgumentException("document cannot be null and must exist");
    }

    JsonObject config = null;

    if (customConfig != null) {
      config = customConfig;
    } else {
      config = EMPTY_CONFIG;
    }

    final JsonObject configJson = new JsonObject();
    // Do this since we shouldn't mutate customConfig
    for (Map.Entry<String, JsonElement> entry : config.entrySet()) {
      configJson.add(entry.getKey(), entry.getValue());
    }
    // Add or override the conversion target
    configJson.addProperty(CONVERSION_TARGET, conversionTarget.toString());

    final MediaType mType = parseMediaType(document, mediaType);
    final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
        .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"config\""),
            RequestBody.create(HttpMediaType.JSON, configJson.toString()))
        .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"file\""),
            RequestBody.create(mType, document))
        .build();

    return RequestBuilder.post(CONVERT_DOCUMENT_PATH).query(VERSION, versionDate).body(body).build();
  }

  /**
   * Converts a document to Answer Units. <br>
   * Use {@link DocumentConversion#convertDocumentToAnswer(File, String)} if you want to specify the media type
   *
   * @param document the document
   * @return Converted document as {@link Answers}
   *
   */
  public ServiceCall<Answers> convertDocumentToAnswer(File document) {
    Request request = createConversionRequest(document, null, ConversionTarget.ANSWER_UNITS, null);
    return createServiceCall(request, ResponseConverterUtils.getObject(Answers.class));
  }

  /**
   * Converts a document to Answer Units.
   *
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided
   * @return Converted document as {@link Answers}
   * @see HttpMediaType HttpMediaType for available media types
   */
  public ServiceCall<Answers> convertDocumentToAnswer(File document, String mediaType) {
    Request request = createConversionRequest(document, mediaType, ConversionTarget.ANSWER_UNITS, null);
    return createServiceCall(request, ResponseConverterUtils.getObject(Answers.class));
  }

  /**
   * Converts a document to Answer Units using a custom configuration.
   *
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided.
   * @param customConfig the configuration parameters to customize the conversion
   * @return converted document as {@link String}
   */
  public ServiceCall<Answers> convertDocumentToAnswer(File document, String mediaType, JsonObject customConfig) {
    Request request = createConversionRequest(document, mediaType, ConversionTarget.ANSWER_UNITS, customConfig);
    return createServiceCall(request, ResponseConverterUtils.getObject(Answers.class));
  }

  /**
   * Converts a document to HTML. <br>
   * Use {@link DocumentConversion#convertDocumentToHTML(File, String)} if you want to specify the media type.
   *
   * @param document the document
   * @return Converted document as {@link String}
   */
  public ServiceCall<String> convertDocumentToHTML(File document) {
    Request request = createConversionRequest(document, null, ConversionTarget.NORMALIZED_HTML, null);
    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Converts a document to HTML.
   *
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided.
   * @return Converted document as {@link String}
   * @see HttpMediaType for available media types
   */
  public ServiceCall<String> convertDocumentToHTML(File document, String mediaType) {
    Request request = createConversionRequest(document, mediaType, ConversionTarget.NORMALIZED_HTML, null);
    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Converts a document to HTML using a custom configuration.
   *
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided.
   * @param customConfig the configuration parameters to customize the conversion
   * @return converted document as {@link String}
   */
  public ServiceCall<String> convertDocumentToHTML(File document, String mediaType, JsonObject customConfig) {
    Request request = createConversionRequest(document, mediaType, ConversionTarget.NORMALIZED_HTML, customConfig);
    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Converts a document to Text. <br>
   * Use {@link DocumentConversion#convertDocumentToText(File, String)} if you want to specify the media type.
   *
   * @param document the document
   * @return Converted document as {@link String}
   */
  public ServiceCall<String> convertDocumentToText(File document) {
    Request request = createConversionRequest(document, null, ConversionTarget.NORMALIZED_TEXT, null);
    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Converts a document to Text.
   *
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided.
   * @return Converted document as {@link String}
   * @see HttpMediaType for available media types
   */
  public ServiceCall<String> convertDocumentToText(File document, String mediaType) {
    Request request = createConversionRequest(document, mediaType, ConversionTarget.NORMALIZED_TEXT, null);
    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Converts a document to Text using a custom configuration.
   *
   * @param document the document
   * @param mediaType the document media type. It will use the file extension if not provided.
   * @param customConfig the configuration parameters to customize the conversion
   * @return converted document as {@link String}
   */
  public ServiceCall<String> convertDocumentToText(File document, String mediaType, JsonObject customConfig) {
    Request request = createConversionRequest(document, null, ConversionTarget.NORMALIZED_TEXT, customConfig);
    return createServiceCall(request, ResponseConverterUtils.getString());
  }

  /**
   * Converts and indexes the document and metadata provided.
   *
   * @param indexDocumentOptions Specifies the options for indexing the document
   * @return index document response as {@link String}
   */
  public ServiceCall<String> indexDocument(final IndexDocumentOptions indexDocumentOptions) {
    if (indexDocumentOptions != null) {
      File document = indexDocumentOptions.document();
      InputStream documentInputStream = indexDocumentOptions.getDocumentInputStream();
      Boolean dryRun = indexDocumentOptions.dryRun();
      String mediaType = indexDocumentOptions.mediaType();
      JsonObject convertDocumentConfig = indexDocumentOptions.convertDocumentConfig();
      IndexConfiguration indexConfiguration = indexDocumentOptions.indexConfiguration();

      if ((document == null) && (documentInputStream == null) && (indexDocumentOptions.metadata() == null)) {
        throw new IllegalArgumentException(
            "The request does not contain a document or metadata. At least one of those is required.");
      }
      if ((document != null) && (documentInputStream != null)) {
        throw new IllegalArgumentException("Both a document File and InputStream were provided, only one is allowed.");
      }
      if (!dryRun && (indexConfiguration == null)) {
        throw new IllegalArgumentException("A configuration is required for indexing.");
      }
      // Build the configuration for the index document request
      final JsonObject config = new JsonObject();
      JsonObject retrieveAndRankConfig = new JsonObject();
      if (dryRun) {
        retrieveAndRankConfig.addProperty(DRY_RUN, true);
      } else {
        retrieveAndRankConfig.addProperty(DRY_RUN, false);
        retrieveAndRankConfig.addProperty(SERVICE_INSTANCE_ID, indexConfiguration.getServiceInstanceId());
        retrieveAndRankConfig.addProperty(CLUSTER_ID, indexConfiguration.getClusterId());
        retrieveAndRankConfig.addProperty(SEARCH_COLLECTION, indexConfiguration.getSearchCollectionName());
      }
      if ((indexConfiguration != null) && (indexConfiguration.getFields() != null)) {
        retrieveAndRankConfig.add(RETRIEVE_AND_RANK_FIELDS,
            new JsonParser().parse(indexConfiguration.getFields().toString()));
      }
      config.add(RETRIEVE_AND_RANK, retrieveAndRankConfig);
      if (convertDocumentConfig != null) {
        config.add(CONVERT_DOCUMENT, convertDocumentConfig);
      }
      // Create the request for the index document API call
      final MultipartBody.Builder multiPartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM)
          .addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"config\""),
              RequestBody.create(HttpMediaType.JSON, config.toString()));
      if (documentInputStream != null) {
        final MediaType mType = parseMediaType(document, mediaType);
        byte[] documentContent = ConversionUtils.writeInputStreamToString(documentInputStream).getBytes();
        multiPartBodyBuilder.addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"file\""),
            RequestBody.create(mType, documentContent));
      }
      if (document != null) {
        final MediaType mType = parseMediaType(document, mediaType);
        multiPartBodyBuilder.addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"file\""),
            RequestBody.create(mType, document));
      }
      if (indexDocumentOptions.metadata() != null) {
        JsonObject metadataJson = metadataToJsonObject(indexDocumentOptions.metadata());
        multiPartBodyBuilder.addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"metadata\""),
            RequestBody.create(HttpMediaType.JSON, metadataJson.toString()));
      }
      final RequestBody body = multiPartBodyBuilder.build();

      Request request = RequestBuilder.post(INDEX_DOCUMENT_PATH).query(VERSION, versionDate).body(body).build();
      return createServiceCall(request, ResponseConverterUtils.getString());
    } else {
      throw new IllegalArgumentException(
          "The request does not contain a file or metadata. At least one of those is required.");
    }
  }

  /**
   * Format the metadata Map into the json object the API expects.
   *
   * @param metadata the metadata map
   * @return the json object that
   */
  private JsonObject metadataToJsonObject(Map<String, String> metadata) {
    JsonObject root = new JsonObject();
    JsonArray array = new JsonArray();
    root.add("metadata", array);

    for (String key : metadata.keySet()) {
      JsonObject entry = new JsonObject();
      entry.addProperty("name", key);
      entry.addProperty("value", metadata.get(key));
      array.add(entry);
    }
    return root;
  }

  /**
   * Parses the provided media type or auto-detects it from the document.
   *
   * @param document The document that is being converted
   * @param mediaType The media type of the document to be converted
   * @return MediaType of the document
   */
  private MediaType parseMediaType(final File document, final String mediaType) {
    final String type = mediaType != null ? mediaType : ConversionUtils.getMediaTypeFromFile(document);
    if (type == null) {
      throw new RuntimeException("mediaType cannot be null or empty");
    } else if (!ConversionUtils.isValidMediaType(type)) {
      throw new IllegalArgumentException("file with the given media type is not supported");
    }
    return MediaType.parse(type);
  }

}
