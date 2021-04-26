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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CreateEnrichment model. */
public class CreateEnrichmentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateEnrichment() throws Throwable {
    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .languages(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .entityType("testString")
            .regularExpression("testString")
            .resultField("testString")
            .build();
    assertEquals(
        enrichmentOptionsModel.languages(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(enrichmentOptionsModel.entityType(), "testString");
    assertEquals(enrichmentOptionsModel.regularExpression(), "testString");
    assertEquals(enrichmentOptionsModel.resultField(), "testString");

    CreateEnrichment createEnrichmentModel =
        new CreateEnrichment.Builder()
            .name("testString")
            .description("testString")
            .type("dictionary")
            .options(enrichmentOptionsModel)
            .build();
    assertEquals(createEnrichmentModel.name(), "testString");
    assertEquals(createEnrichmentModel.description(), "testString");
    assertEquals(createEnrichmentModel.type(), "dictionary");
    assertEquals(createEnrichmentModel.options(), enrichmentOptionsModel);

    String json = TestUtilities.serialize(createEnrichmentModel);

    CreateEnrichment createEnrichmentModelNew =
        TestUtilities.deserialize(json, CreateEnrichment.class);
    assertTrue(createEnrichmentModelNew instanceof CreateEnrichment);
    assertEquals(createEnrichmentModelNew.name(), "testString");
    assertEquals(createEnrichmentModelNew.description(), "testString");
    assertEquals(createEnrichmentModelNew.type(), "dictionary");
    assertEquals(createEnrichmentModelNew.options().toString(), enrichmentOptionsModel.toString());
  }
}
