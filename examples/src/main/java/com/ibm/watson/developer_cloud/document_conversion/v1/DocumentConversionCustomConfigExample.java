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
package com.ibm.watson.developer_cloud.document_conversion.v1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

public class DocumentConversionCustomConfigExample {
  public static void main(String[] args) {
    final String versionDate = "2015-12-14";
    DocumentConversion service = new DocumentConversion(versionDate);
    service.setUsernameAndPassword("<username>", "<password>");

    final File html = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");

    // Run a conversion with no configuration specified. The Document Conversion service will use
    // its default configuration when no configuration is specified. For this example, the
    // Document Conversion service will section a HTML document by h1, h2, h3, h4, h5, and h6 tags.
    // Those sections will be returned as Answers
    System.out.println("Convert html document to Answer Units using default configuration");
    final Answers htmlToAnswersWithDefaultConfig =
        service.convertDocumentToAnswer(html, HttpMediaType.TEXT_HTML).execute();
    System.out.println(htmlToAnswersWithDefaultConfig);

    System.out.println("==================================================");

    // Run a conversion with a custom configuration. The next example shows how to convert this same
    // document with a custom configuration. Instead of sectioning by the default settings (h1, h2,
    // h3, h4, h5, and h6), the following example shows how to section a HTML document by only the
    // h1 tag. This will result in Answers that are sectioned by h1 tags.
    String configAsString =
        "{\n" + "    \"answer_units\": {\n" + "        \"selector_tags\": [\"h1\"]\n" + "    }\n" + "}";
    JsonParser jsonParser = new JsonParser();
    JsonObject customConfig = jsonParser.parse(configAsString).getAsJsonObject();

    System.out.println("Convert html document to Answer Units using custom configuration");
    final Answers htmlToAnswersWithCustomConfig =
        service.convertDocumentToAnswer(html, HttpMediaType.TEXT_HTML, customConfig).execute();
    System.out.println(htmlToAnswersWithCustomConfig);

    System.out.println("==================================================");

    // Run a conversion with a custom configuration that is loaded from a file. This example is
    // similar
    // to the previous one above. The custom configuration from the file will section a HTML
    // document
    // by only the h2 tag. This will result in Answers that are sectioned by h2 tags.
    System.out.println("Convert html document to Answer Units using custom configuration loaded from a file");
    String customConfigFilePath = "src/test/resources/document_conversion/answer_unit_config_selector_h2.json";
    JsonObject customConfigFromFile = null;
    try {
      customConfigFromFile = ConversionUtils.loadCustomConfig(new FileInputStream(customConfigFilePath));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    if (customConfigFromFile == null) {
      System.err.println("ERROR - Unable to load custom config from file " + customConfigFilePath);
      return;
    }

    final Answers htmlToAnswersWithCustomConfigFromFile =
        service.convertDocumentToAnswer(html, HttpMediaType.TEXT_HTML, customConfigFromFile).execute();
    System.out.println(htmlToAnswersWithCustomConfigFromFile);
  }
}
