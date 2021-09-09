/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.watson.natural_language_understanding.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.natural_language_understanding.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the EntitiesOptions model. */
public class EntitiesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEntitiesOptions() throws Throwable {
    EntitiesOptions entitiesOptionsModel =
        new EntitiesOptions.Builder()
            .limit(Long.valueOf("250"))
            .mentions(false)
            .model("testString")
            .sentiment(false)
            .emotion(false)
            .build();
    assertEquals(entitiesOptionsModel.limit(), Long.valueOf("250"));
    assertEquals(entitiesOptionsModel.mentions(), Boolean.valueOf(false));
    assertEquals(entitiesOptionsModel.model(), "testString");
    assertEquals(entitiesOptionsModel.sentiment(), Boolean.valueOf(false));
    assertEquals(entitiesOptionsModel.emotion(), Boolean.valueOf(false));

    String json = TestUtilities.serialize(entitiesOptionsModel);

    EntitiesOptions entitiesOptionsModelNew =
        TestUtilities.deserialize(json, EntitiesOptions.class);
    assertTrue(entitiesOptionsModelNew instanceof EntitiesOptions);
    assertEquals(entitiesOptionsModelNew.limit(), Long.valueOf("250"));
    assertEquals(entitiesOptionsModelNew.mentions(), Boolean.valueOf(false));
    assertEquals(entitiesOptionsModelNew.model(), "testString");
    assertEquals(entitiesOptionsModelNew.sentiment(), Boolean.valueOf(false));
    assertEquals(entitiesOptionsModelNew.emotion(), Boolean.valueOf(false));
  }
}
