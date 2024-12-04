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

/** Unit test class for the SearchSettingsServerSideSearch model. */
public class SearchSettingsServerSideSearchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchSettingsServerSideSearch() throws Throwable {
    SearchSettingsServerSideSearch searchSettingsServerSideSearchModel =
        new SearchSettingsServerSideSearch.Builder()
            .url("testString")
            .port("testString")
            .username("testString")
            .password("testString")
            .filter("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .apikey("testString")
            .noAuth(true)
            .authType("basic")
            .build();
    assertEquals(searchSettingsServerSideSearchModel.url(), "testString");
    assertEquals(searchSettingsServerSideSearchModel.port(), "testString");
    assertEquals(searchSettingsServerSideSearchModel.username(), "testString");
    assertEquals(searchSettingsServerSideSearchModel.password(), "testString");
    assertEquals(searchSettingsServerSideSearchModel.filter(), "testString");
    assertEquals(
        searchSettingsServerSideSearchModel.metadata(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(searchSettingsServerSideSearchModel.apikey(), "testString");
    assertEquals(searchSettingsServerSideSearchModel.noAuth(), Boolean.valueOf(true));
    assertEquals(searchSettingsServerSideSearchModel.authType(), "basic");

    String json = TestUtilities.serialize(searchSettingsServerSideSearchModel);

    SearchSettingsServerSideSearch searchSettingsServerSideSearchModelNew =
        TestUtilities.deserialize(json, SearchSettingsServerSideSearch.class);
    assertTrue(searchSettingsServerSideSearchModelNew instanceof SearchSettingsServerSideSearch);
    assertEquals(searchSettingsServerSideSearchModelNew.url(), "testString");
    assertEquals(searchSettingsServerSideSearchModelNew.port(), "testString");
    assertEquals(searchSettingsServerSideSearchModelNew.username(), "testString");
    assertEquals(searchSettingsServerSideSearchModelNew.password(), "testString");
    assertEquals(searchSettingsServerSideSearchModelNew.filter(), "testString");
    assertEquals(
        searchSettingsServerSideSearchModelNew.metadata().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(searchSettingsServerSideSearchModelNew.apikey(), "testString");
    assertEquals(searchSettingsServerSideSearchModelNew.noAuth(), Boolean.valueOf(true));
    assertEquals(searchSettingsServerSideSearchModelNew.authType(), "basic");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchSettingsServerSideSearchError() throws Throwable {
    new SearchSettingsServerSideSearch.Builder().build();
  }
}
