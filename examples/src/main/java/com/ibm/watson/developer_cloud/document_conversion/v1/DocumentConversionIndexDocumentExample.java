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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexConfiguration;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexDocumentOptions;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexFields;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

/**
 * Example class that shows the index document usage of the Document Conversion service.
 */
public class DocumentConversionIndexDocumentExample {

  public static void main(String[] args) {
    DocumentConversion service = new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
    service.setUsernameAndPassword("<username>", "<password>");

    // ----- Global Values -----
    IndexConfiguration indexConfiguration =
        new IndexConfiguration("<serviceInstanceId>", "<clusterId>", "<searchCollectionName>");

    // Create an index configuration with the fields object (field mappings, fields to include, fields to exclude)
    IndexFields fields = new IndexFields.Builder().mappings("Author", "Created By")
        .mappings("Date Created", "Created On").include("SomeMetadataName").include("id").include("Created By")
        .include("Created On").exclude("Category").build();
    IndexConfiguration indexConfigurationWithFields =
        new IndexConfiguration("<serviceInstanceId>", "<clusterId>", "<searchCollectionName>", fields);

    // Create some metadata for indexing
    final Map<String, String> metadata = new HashMap<String, String>();
    metadata.put("id", "1");
    metadata.put("SomeMetadataName", "SomeMetadataValue");

    // Create a convert document configuration that will exclude all anchor tags (<a>) from the input HTML file
    String convertDocumentConfigAsString = "{ \"normalized_html\" : { \"exclude_tags_completely\":[\"a\"] } }";
    JsonParser jsonParser = new JsonParser();
    JsonObject convertDocumentConfig = jsonParser.parse(convertDocumentConfigAsString).getAsJsonObject();

    // Sample file to index
    File document = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
    String html = "<html><head><title>Sample HTML</title></head><body><h1>Intro</h1><p>Some content!</p></body></html>";
    InputStream documentInputStream = new ByteArrayInputStream(html.getBytes());

    // ----- Examples for performing a dry run of the index document API -----
    printHeaderForExample("Dry run for indexing a document");
    IndexDocumentOptions indexDocumentOptions1 =
        new IndexDocumentOptions.Builder().document(document).dryRun(true).build();
    String indexDocumentDryRun = service.indexDocument(indexDocumentOptions1).execute();
    System.out.println(indexDocumentDryRun);

    printHeaderForExample("Dry run for indexing a document (using input stream)");
    IndexDocumentOptions indexDocumentOptions2 =
        new IndexDocumentOptions.Builder().document(documentInputStream, HttpMediaType.TEXT_HTML).dryRun(true).build();
    String indexDocumentInputStreamDryRun = service.indexDocument(indexDocumentOptions2).execute();
    System.out.println(indexDocumentInputStreamDryRun);

    printHeaderForExample("Dry run for indexing metadata");
    IndexDocumentOptions indexDocumentOptions3 =
        new IndexDocumentOptions.Builder().metadata(metadata).dryRun(true).build();
    String indexMetadataDryRun = service.indexDocument(indexDocumentOptions3).execute();
    System.out.println(indexMetadataDryRun);

    printHeaderForExample("Dry run for indexing document and metadata");
    IndexDocumentOptions indexDocumentOptions4 =
        new IndexDocumentOptions.Builder().document(document).metadata(metadata).dryRun(true).build();
    String indexDocumentAndMetadataDryRun = service.indexDocument(indexDocumentOptions4).execute();
    System.out.println(indexDocumentAndMetadataDryRun);

    printHeaderForExample("Dry run for indexing document with provided media type and metadata");
    IndexDocumentOptions indexDocumentOptions5 = new IndexDocumentOptions.Builder().document(document)
        .metadata(metadata).mediaType(HttpMediaType.TEXT_HTML).dryRun(true).build();
    String indexDocumentWithMediaTypeAndMetadataDryRun = service.indexDocument(indexDocumentOptions5).execute();
    System.out.println(indexDocumentWithMediaTypeAndMetadataDryRun);

    printHeaderForExample(
        "Dry run for indexing document with provided media type, metadata, and convert document config");
    IndexDocumentOptions indexDocumentOptions6 =
        new IndexDocumentOptions.Builder().document(document).metadata(metadata).mediaType(HttpMediaType.TEXT_HTML)
            .convertDocumentConfig(convertDocumentConfig).dryRun(true).build();
    String indexDocumentWithMediaTypeAndMetadataAndConfigDryRun =
        service.indexDocument(indexDocumentOptions6).execute();
    System.out.println(indexDocumentWithMediaTypeAndMetadataAndConfigDryRun);

    printHeaderForExample("Index metadata");
    IndexDocumentOptions indexDocumentOptions7 = new IndexDocumentOptions.Builder().metadata(metadata)
        .indexConfiguration(indexConfiguration).dryRun(false).build();
    String indexMetadata = service.indexDocument(indexDocumentOptions7).execute();
    System.out.println(indexMetadata);

    printHeaderForExample("Index a document and metadata");
    IndexDocumentOptions indexDocumentOptions8 = new IndexDocumentOptions.Builder().document(document)
        .metadata(metadata).indexConfiguration(indexConfiguration).dryRun(false).build();
    String indexDocumentAndMetadata = service.indexDocument(indexDocumentOptions8).execute();
    System.out.println(indexDocumentAndMetadata);

    printHeaderForExample("Index document with provided media type and metadata");
    IndexDocumentOptions indexDocumentOptions9 = new IndexDocumentOptions.Builder().document(document)
        .metadata(metadata).mediaType(HttpMediaType.TEXT_HTML).indexConfiguration(indexConfiguration).build();
    String indexDocumentWithMediaTypeAndMetadata = service.indexDocument(indexDocumentOptions9).execute();
    System.out.println(indexDocumentWithMediaTypeAndMetadata);

    printHeaderForExample("Index document with provided media type, metadata, and convert document config");
    IndexDocumentOptions indexDocumentOptions10 =
        new IndexDocumentOptions.Builder().document(document).metadata(metadata).mediaType(HttpMediaType.TEXT_HTML)
            .convertDocumentConfig(convertDocumentConfig).indexConfiguration(indexConfiguration).dryRun(false).build();
    String indexDocumentWithMediaTypeAndMetadataAndConfig = service.indexDocument(indexDocumentOptions10).execute();
    System.out.println(indexDocumentWithMediaTypeAndMetadataAndConfig);

    printHeaderForExample("Index document with provided media type, metadata, convert document config, and fields");
    IndexDocumentOptions indexDocumentOptions11 = new IndexDocumentOptions.Builder().document(document)
        .metadata(metadata).mediaType(HttpMediaType.TEXT_HTML).convertDocumentConfig(convertDocumentConfig)
        .indexConfiguration(indexConfigurationWithFields).dryRun(false).build();
    String indexDocumentWithMediaTypeAndMetadataConfigAndFields =
        service.indexDocument(indexDocumentOptions11).execute();
    System.out.println(indexDocumentWithMediaTypeAndMetadataConfigAndFields);
  }

  private static void printHeaderForExample(String message) {
    System.out.println("\n================================================================================\n" + message
        + "\n================================================================================\n");
  }
}
