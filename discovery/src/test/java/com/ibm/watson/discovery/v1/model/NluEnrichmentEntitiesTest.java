/*
 * (C) Copyright IBM Corp. 2020.
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

/** Unit test class for the NluEnrichmentEntities model. */
public class NluEnrichmentEntitiesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testNluEnrichmentEntities() throws Throwable {
    NluEnrichmentEntities nluEnrichmentEntitiesModel =
        new NluEnrichmentEntities.Builder()
            .sentiment(true)
            .emotion(true)
            .limit(Long.valueOf("26"))
            .mentions(true)
            .mentionTypes(true)
            .sentenceLocations(true)
            .model("testString")
            .build();
    assertEquals(nluEnrichmentEntitiesModel.sentiment(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.emotion(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.limit(), Long.valueOf("26"));
    assertEquals(nluEnrichmentEntitiesModel.mentions(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.mentionTypes(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.sentenceLocations(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.model(), "testString");

    String json = TestUtilities.serialize(nluEnrichmentEntitiesModel);

    NluEnrichmentEntities nluEnrichmentEntitiesModelNew =
        TestUtilities.deserialize(json, NluEnrichmentEntities.class);
    assertTrue(nluEnrichmentEntitiesModelNew instanceof NluEnrichmentEntities);
    assertEquals(nluEnrichmentEntitiesModelNew.sentiment(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModelNew.emotion(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModelNew.limit(), Long.valueOf("26"));
    assertEquals(nluEnrichmentEntitiesModelNew.mentions(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModelNew.mentionTypes(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModelNew.sentenceLocations(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModelNew.model(), "testString");
  }
}
