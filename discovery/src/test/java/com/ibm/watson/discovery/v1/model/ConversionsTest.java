/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.watson.discovery.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the Conversions model. */
public class ConversionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConversions() throws Throwable {
    FontSetting fontSettingModel =
        new FontSetting.Builder()
            .level(Long.valueOf("26"))
            .minSize(Long.valueOf("26"))
            .maxSize(Long.valueOf("26"))
            .bold(true)
            .italic(true)
            .name("testString")
            .build();
    assertEquals(fontSettingModel.level(), Long.valueOf("26"));
    assertEquals(fontSettingModel.minSize(), Long.valueOf("26"));
    assertEquals(fontSettingModel.maxSize(), Long.valueOf("26"));
    assertEquals(fontSettingModel.bold(), Boolean.valueOf(true));
    assertEquals(fontSettingModel.italic(), Boolean.valueOf(true));
    assertEquals(fontSettingModel.name(), "testString");

    PdfHeadingDetection pdfHeadingDetectionModel =
        new PdfHeadingDetection.Builder().fonts(java.util.Arrays.asList(fontSettingModel)).build();
    assertEquals(pdfHeadingDetectionModel.fonts(), java.util.Arrays.asList(fontSettingModel));

    PdfSettings pdfSettingsModel =
        new PdfSettings.Builder().heading(pdfHeadingDetectionModel).build();
    assertEquals(pdfSettingsModel.heading(), pdfHeadingDetectionModel);

    WordStyle wordStyleModel =
        new WordStyle.Builder()
            .level(Long.valueOf("26"))
            .names(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(wordStyleModel.level(), Long.valueOf("26"));
    assertEquals(wordStyleModel.names(), java.util.Arrays.asList("testString"));

    WordHeadingDetection wordHeadingDetectionModel =
        new WordHeadingDetection.Builder()
            .fonts(java.util.Arrays.asList(fontSettingModel))
            .styles(java.util.Arrays.asList(wordStyleModel))
            .build();
    assertEquals(wordHeadingDetectionModel.fonts(), java.util.Arrays.asList(fontSettingModel));
    assertEquals(wordHeadingDetectionModel.styles(), java.util.Arrays.asList(wordStyleModel));

    WordSettings wordSettingsModel =
        new WordSettings.Builder().heading(wordHeadingDetectionModel).build();
    assertEquals(wordSettingsModel.heading(), wordHeadingDetectionModel);

    XPathPatterns xPathPatternsModel =
        new XPathPatterns.Builder().xpaths(java.util.Arrays.asList("testString")).build();
    assertEquals(xPathPatternsModel.xpaths(), java.util.Arrays.asList("testString"));

    HtmlSettings htmlSettingsModel =
        new HtmlSettings.Builder()
            .excludeTagsCompletely(java.util.Arrays.asList("testString"))
            .excludeTagsKeepContent(java.util.Arrays.asList("testString"))
            .keepContent(xPathPatternsModel)
            .excludeContent(xPathPatternsModel)
            .keepTagAttributes(java.util.Arrays.asList("testString"))
            .excludeTagAttributes(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(htmlSettingsModel.excludeTagsCompletely(), java.util.Arrays.asList("testString"));
    assertEquals(htmlSettingsModel.excludeTagsKeepContent(), java.util.Arrays.asList("testString"));
    assertEquals(htmlSettingsModel.keepContent(), xPathPatternsModel);
    assertEquals(htmlSettingsModel.excludeContent(), xPathPatternsModel);
    assertEquals(htmlSettingsModel.keepTagAttributes(), java.util.Arrays.asList("testString"));
    assertEquals(htmlSettingsModel.excludeTagAttributes(), java.util.Arrays.asList("testString"));

    SegmentSettings segmentSettingsModel =
        new SegmentSettings.Builder()
            .enabled(false)
            .selectorTags(java.util.Arrays.asList("h1", "h2"))
            .annotatedFields(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(segmentSettingsModel.enabled(), Boolean.valueOf(false));
    assertEquals(segmentSettingsModel.selectorTags(), java.util.Arrays.asList("h1", "h2"));
    assertEquals(segmentSettingsModel.annotatedFields(), java.util.Arrays.asList("testString"));

    NormalizationOperation normalizationOperationModel =
        new NormalizationOperation.Builder()
            .operation("copy")
            .sourceField("testString")
            .destinationField("testString")
            .build();
    assertEquals(normalizationOperationModel.operation(), "copy");
    assertEquals(normalizationOperationModel.sourceField(), "testString");
    assertEquals(normalizationOperationModel.destinationField(), "testString");

    Conversions conversionsModel =
        new Conversions.Builder()
            .pdf(pdfSettingsModel)
            .word(wordSettingsModel)
            .html(htmlSettingsModel)
            .segment(segmentSettingsModel)
            .jsonNormalizations(java.util.Arrays.asList(normalizationOperationModel))
            .imageTextRecognition(true)
            .build();
    assertEquals(conversionsModel.pdf(), pdfSettingsModel);
    assertEquals(conversionsModel.word(), wordSettingsModel);
    assertEquals(conversionsModel.html(), htmlSettingsModel);
    assertEquals(conversionsModel.segment(), segmentSettingsModel);
    assertEquals(
        conversionsModel.jsonNormalizations(),
        java.util.Arrays.asList(normalizationOperationModel));
    assertEquals(conversionsModel.imageTextRecognition(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(conversionsModel);

    Conversions conversionsModelNew = TestUtilities.deserialize(json, Conversions.class);
    assertTrue(conversionsModelNew instanceof Conversions);
    assertEquals(conversionsModelNew.pdf().toString(), pdfSettingsModel.toString());
    assertEquals(conversionsModelNew.word().toString(), wordSettingsModel.toString());
    assertEquals(conversionsModelNew.html().toString(), htmlSettingsModel.toString());
    assertEquals(conversionsModelNew.segment().toString(), segmentSettingsModel.toString());
    assertEquals(conversionsModelNew.imageTextRecognition(), Boolean.valueOf(true));
  }
}
