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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the DefaultQueryParamsPassages model. */
public class DefaultQueryParamsPassagesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDefaultQueryParamsPassages() throws Throwable {
    DefaultQueryParamsPassages defaultQueryParamsPassagesModel =
        new DefaultQueryParamsPassages.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .fields(java.util.Arrays.asList("testString"))
            .characters(Long.valueOf("26"))
            .perDocument(true)
            .maxPerDocument(Long.valueOf("26"))
            .build();
    assertEquals(defaultQueryParamsPassagesModel.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsPassagesModel.count(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsPassagesModel.fields(), java.util.Arrays.asList("testString"));
    assertEquals(defaultQueryParamsPassagesModel.characters(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsPassagesModel.perDocument(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsPassagesModel.maxPerDocument(), Long.valueOf("26"));

    String json = TestUtilities.serialize(defaultQueryParamsPassagesModel);

    DefaultQueryParamsPassages defaultQueryParamsPassagesModelNew =
        TestUtilities.deserialize(json, DefaultQueryParamsPassages.class);
    assertTrue(defaultQueryParamsPassagesModelNew instanceof DefaultQueryParamsPassages);
    assertEquals(defaultQueryParamsPassagesModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsPassagesModelNew.count(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsPassagesModelNew.characters(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsPassagesModelNew.perDocument(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsPassagesModelNew.maxPerDocument(), Long.valueOf("26"));
  }
}
