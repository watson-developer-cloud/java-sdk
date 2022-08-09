/*
 * (C) Copyright IBM Corp. 2020, 2022.
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

/** Unit test class for the WordHeadingDetection model. */
public class WordHeadingDetectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testWordHeadingDetection() throws Throwable {
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

    String json = TestUtilities.serialize(wordHeadingDetectionModel);

    WordHeadingDetection wordHeadingDetectionModelNew =
        TestUtilities.deserialize(json, WordHeadingDetection.class);
    assertTrue(wordHeadingDetectionModelNew instanceof WordHeadingDetection);
  }
}
