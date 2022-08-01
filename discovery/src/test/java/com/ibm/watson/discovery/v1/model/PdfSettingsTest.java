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

/** Unit test class for the PdfSettings model. */
public class PdfSettingsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPdfSettings() throws Throwable {
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

    String json = TestUtilities.serialize(pdfSettingsModel);

    PdfSettings pdfSettingsModelNew = TestUtilities.deserialize(json, PdfSettings.class);
    assertTrue(pdfSettingsModelNew instanceof PdfSettings);
    assertEquals(pdfSettingsModelNew.heading().toString(), pdfHeadingDetectionModel.toString());
  }
}
