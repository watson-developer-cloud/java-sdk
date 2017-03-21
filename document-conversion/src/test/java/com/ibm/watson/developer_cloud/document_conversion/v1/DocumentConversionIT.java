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

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexConfiguration;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexDocumentOptions;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.IndexFields;

/**
 * The Class DocumentConversionIntegrationTest.
 */
public class DocumentConversionIT extends WatsonServiceTest {

  /** The service. */
  private DocumentConversion service;
  private File[] files;
  private Map<String, String> metadata;
  private JsonObject convertDocumentConfig;
  private IndexConfiguration indexConfiguration;
  private Boolean dryRun;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
    String username = getProperty("document_conversion.username");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals("SERVICE_USERNAME"));

    service.setUsernameAndPassword(username, getProperty("document_conversion.password"));
    service.setEndPoint(getProperty("document_conversion.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    files = new File[] { new File("src/test/resources/document_conversion/word-docx-heading-input.docx"),
        new File("src/test/resources/document_conversion/word-document-heading-input.doc"),
        new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf"),
        new File("src/test/resources/document_conversion/html-with-extra-content-input.htm") };
    metadata = new HashMap<String, String>();
    metadata.put("SomeMetadataName", "SomeMetadataValue");
    String convertDocumentConfigAsString = "{ \"normalized_html\" : { \"exclude_tags_completely\":[\"a\"] } }";
    convertDocumentConfig = new JsonParser().parse(convertDocumentConfigAsString).getAsJsonObject();
    IndexFields fields = new IndexFields.Builder().mappings("Author", "Created By")
        .mappings("Date Created", "Created On").include("SomeMetadataName").include("id").include("Created By")
        .include("Created On").exclude("Category").build();
    indexConfiguration = new IndexConfiguration(null, null, null, fields);
    dryRun = true;
  }

  /**
   * Test Convert to answers unit.
   */
  @Test
  public void testConvertToAnswers() {
    for (final File file : files) {
      final Answers answers = service.convertDocumentToAnswer(file).execute();
      assertNotNull(answers);
      assertNotNull(answers.getAnswerUnits());
      assertTrue(!answers.getAnswerUnits().isEmpty());
    }
  }

  /**
   * Test convert to HTML.
   */
  @Test
  public void testConvertToHtml() {
    for (final File file : files) {
      final String html = service.convertDocumentToHTML(file).execute();
      assertNotNull(html);
      assertNotEquals(html, "");
    }
  }

  /**
   * Test convert to Text.
   */
  @Test
  public void testConvertToText() {
    for (final File file : files) {
      final String text = service.convertDocumentToText(file).execute();
      assertNotNull(text);
      assertNotEquals(text, "");
    }
  }

  /**
   * Test a dry run of the index document api with document only.
   */
  @Test
  public void testIndexDocumentDryRun() {
    for (final File file : files) {
      IndexDocumentOptions indexDocumentOptions =
          new IndexDocumentOptions.Builder().document(file).dryRun(dryRun).build();
      final String response = service.indexDocument(indexDocumentOptions).execute();
      assertNotNull(response);
      assertNotEquals(response, "");
    }
  }

  /**
   * Test a dry run of the index document api with metadata only.
   */
  @Test
  public void testIndexMetadataDryRun() {
    IndexDocumentOptions indexDocumentOptions =
        new IndexDocumentOptions.Builder().metadata(metadata).dryRun(dryRun).build();
    final String response = service.indexDocument(indexDocumentOptions).execute();
    assertNotNull(response);
    assertNotEquals(response, "");
    assertTrue(response.contains("SomeMetadataName"));
    assertTrue(response.contains("SomeMetadataValue"));
  }

  /**
   * Test a dry run of the index document api with document and metadata.
   */
  @Test
  public void testIndexDocumentAndMetadataDryRun() {
    for (final File file : files) {
      IndexDocumentOptions indexDocumentOptions =
          new IndexDocumentOptions.Builder().document(file).metadata(metadata).dryRun(dryRun).build();
      final String response = service.indexDocument(indexDocumentOptions).execute();
      assertNotNull(response);
      assertNotEquals(response, "");
      assertTrue(response.contains("SomeMetadataName"));
      assertTrue(response.contains("SomeMetadataValue"));
    }
  }

  /**
   * Test a dry run of the index document api with document, metadata, and convert document config.
   */
  @Test
  public void testIndexDocumentAndMetadataAndConvertDocConfig() {
    for (final File file : files) {
      IndexDocumentOptions indexDocumentOptions = new IndexDocumentOptions.Builder().document(file).metadata(metadata)
          .dryRun(dryRun).convertDocumentConfig(convertDocumentConfig).build();
      final String response = service.indexDocument(indexDocumentOptions).execute();
      assertNotNull(response);
      assertNotEquals(response, "");
      assertTrue(response.contains("SomeMetadataName"));
      assertTrue(response.contains("SomeMetadataValue"));
    }
  }

  /**
   * Test a dry run of the index document api with document, metadata, convert document config, and index config.
   */
  @Test
  public void testIndexDocumentAndMetadataConvertDocConfigAndIndexConfig() {
    for (final File file : files) {
      IndexDocumentOptions indexDocumentOptions = new IndexDocumentOptions.Builder().document(file).metadata(metadata)
          .dryRun(dryRun).convertDocumentConfig(convertDocumentConfig).indexConfiguration(indexConfiguration).build();
      final String response = service.indexDocument(indexDocumentOptions).execute();
      assertNotNull(response);
      assertNotEquals(response, "");
      assertTrue(response.contains("SomeMetadataName"));
      assertTrue(response.contains("SomeMetadataValue"));
    }
  }
}
