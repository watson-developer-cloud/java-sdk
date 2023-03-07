/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the SearchSettingsSchemaMapping model. */
public class SearchSettingsSchemaMappingTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchSettingsSchemaMapping() throws Throwable {
    SearchSettingsSchemaMapping searchSettingsSchemaMappingModel =
        new SearchSettingsSchemaMapping.Builder()
            .url("testString")
            .body("testString")
            .title("testString")
            .build();
    assertEquals(searchSettingsSchemaMappingModel.url(), "testString");
    assertEquals(searchSettingsSchemaMappingModel.body(), "testString");
    assertEquals(searchSettingsSchemaMappingModel.title(), "testString");

    String json = TestUtilities.serialize(searchSettingsSchemaMappingModel);

    SearchSettingsSchemaMapping searchSettingsSchemaMappingModelNew =
        TestUtilities.deserialize(json, SearchSettingsSchemaMapping.class);
    assertTrue(searchSettingsSchemaMappingModelNew instanceof SearchSettingsSchemaMapping);
    assertEquals(searchSettingsSchemaMappingModelNew.url(), "testString");
    assertEquals(searchSettingsSchemaMappingModelNew.body(), "testString");
    assertEquals(searchSettingsSchemaMappingModelNew.title(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchSettingsSchemaMappingError() throws Throwable {
    new SearchSettingsSchemaMapping.Builder().build();
  }
}
