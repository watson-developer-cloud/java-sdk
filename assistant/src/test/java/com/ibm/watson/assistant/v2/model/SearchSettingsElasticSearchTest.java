/*
 * (C) Copyright IBM Corp. 2024.
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

/** Unit test class for the SearchSettingsElasticSearch model. */
public class SearchSettingsElasticSearchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchSettingsElasticSearch() throws Throwable {
    SearchSettingsElasticSearch searchSettingsElasticSearchModel =
        new SearchSettingsElasticSearch.Builder()
            .url("testString")
            .port("testString")
            .username("testString")
            .password("testString")
            .index("testString")
            .filter(java.util.Arrays.asList("testString"))
            .queryBody(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .managedIndex("testString")
            .apikey("testString")
            .build();
    assertEquals(searchSettingsElasticSearchModel.url(), "testString");
    assertEquals(searchSettingsElasticSearchModel.port(), "testString");
    assertEquals(searchSettingsElasticSearchModel.username(), "testString");
    assertEquals(searchSettingsElasticSearchModel.password(), "testString");
    assertEquals(searchSettingsElasticSearchModel.index(), "testString");
    assertEquals(searchSettingsElasticSearchModel.filter(), java.util.Arrays.asList("testString"));
    assertEquals(
        searchSettingsElasticSearchModel.queryBody(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(searchSettingsElasticSearchModel.managedIndex(), "testString");
    assertEquals(searchSettingsElasticSearchModel.apikey(), "testString");

    String json = TestUtilities.serialize(searchSettingsElasticSearchModel);

    SearchSettingsElasticSearch searchSettingsElasticSearchModelNew =
        TestUtilities.deserialize(json, SearchSettingsElasticSearch.class);
    assertTrue(searchSettingsElasticSearchModelNew instanceof SearchSettingsElasticSearch);
    assertEquals(searchSettingsElasticSearchModelNew.url(), "testString");
    assertEquals(searchSettingsElasticSearchModelNew.port(), "testString");
    assertEquals(searchSettingsElasticSearchModelNew.username(), "testString");
    assertEquals(searchSettingsElasticSearchModelNew.password(), "testString");
    assertEquals(searchSettingsElasticSearchModelNew.index(), "testString");
    assertEquals(
        searchSettingsElasticSearchModelNew.queryBody().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(searchSettingsElasticSearchModelNew.managedIndex(), "testString");
    assertEquals(searchSettingsElasticSearchModelNew.apikey(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchSettingsElasticSearchError() throws Throwable {
    new SearchSettingsElasticSearch.Builder().build();
  }
}
