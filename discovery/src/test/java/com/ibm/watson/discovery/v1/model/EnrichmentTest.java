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

/** Unit test class for the Enrichment model. */
public class EnrichmentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEnrichment() throws Throwable {
    NluEnrichmentKeywords nluEnrichmentKeywordsModel =
        new NluEnrichmentKeywords.Builder()
            .sentiment(true)
            .emotion(true)
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(nluEnrichmentKeywordsModel.sentiment(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentKeywordsModel.emotion(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentKeywordsModel.limit(), Long.valueOf("26"));

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

    NluEnrichmentSentiment nluEnrichmentSentimentModel =
        new NluEnrichmentSentiment.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(nluEnrichmentSentimentModel.document(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentSentimentModel.targets(), java.util.Arrays.asList("testString"));

    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(nluEnrichmentEmotionModel.document(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEmotionModel.targets(), java.util.Arrays.asList("testString"));

    NluEnrichmentSemanticRoles nluEnrichmentSemanticRolesModel =
        new NluEnrichmentSemanticRoles.Builder()
            .entities(true)
            .keywords(true)
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(nluEnrichmentSemanticRolesModel.entities(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentSemanticRolesModel.keywords(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentSemanticRolesModel.limit(), Long.valueOf("26"));

    NluEnrichmentRelations nluEnrichmentRelationsModel =
        new NluEnrichmentRelations.Builder().model("testString").build();
    assertEquals(nluEnrichmentRelationsModel.model(), "testString");

    NluEnrichmentConcepts nluEnrichmentConceptsModel =
        new NluEnrichmentConcepts.Builder().limit(Long.valueOf("26")).build();
    assertEquals(nluEnrichmentConceptsModel.limit(), Long.valueOf("26"));

    NluEnrichmentFeatures nluEnrichmentFeaturesModel =
        new NluEnrichmentFeatures.Builder()
            .keywords(nluEnrichmentKeywordsModel)
            .entities(nluEnrichmentEntitiesModel)
            .sentiment(nluEnrichmentSentimentModel)
            .emotion(nluEnrichmentEmotionModel)
            .categories(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .semanticRoles(nluEnrichmentSemanticRolesModel)
            .relations(nluEnrichmentRelationsModel)
            .concepts(nluEnrichmentConceptsModel)
            .build();
    assertEquals(nluEnrichmentFeaturesModel.keywords(), nluEnrichmentKeywordsModel);
    assertEquals(nluEnrichmentFeaturesModel.entities(), nluEnrichmentEntitiesModel);
    assertEquals(nluEnrichmentFeaturesModel.sentiment(), nluEnrichmentSentimentModel);
    assertEquals(nluEnrichmentFeaturesModel.emotion(), nluEnrichmentEmotionModel);
    assertEquals(
        nluEnrichmentFeaturesModel.categories(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(nluEnrichmentFeaturesModel.semanticRoles(), nluEnrichmentSemanticRolesModel);
    assertEquals(nluEnrichmentFeaturesModel.relations(), nluEnrichmentRelationsModel);
    assertEquals(nluEnrichmentFeaturesModel.concepts(), nluEnrichmentConceptsModel);

    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .features(nluEnrichmentFeaturesModel)
            .language("ar")
            .model("testString")
            .build();
    assertEquals(enrichmentOptionsModel.features(), nluEnrichmentFeaturesModel);
    assertEquals(enrichmentOptionsModel.language(), "ar");
    assertEquals(enrichmentOptionsModel.model(), "testString");

    Enrichment enrichmentModel =
        new Enrichment.Builder()
            .description("testString")
            .destinationField("testString")
            .sourceField("testString")
            .overwrite(false)
            .enrichment("testString")
            .ignoreDownstreamErrors(false)
            .options(enrichmentOptionsModel)
            .build();
    assertEquals(enrichmentModel.description(), "testString");
    assertEquals(enrichmentModel.destinationField(), "testString");
    assertEquals(enrichmentModel.sourceField(), "testString");
    assertEquals(enrichmentModel.overwrite(), Boolean.valueOf(false));
    assertEquals(enrichmentModel.enrichment(), "testString");
    assertEquals(enrichmentModel.ignoreDownstreamErrors(), Boolean.valueOf(false));
    assertEquals(enrichmentModel.options(), enrichmentOptionsModel);

    String json = TestUtilities.serialize(enrichmentModel);

    Enrichment enrichmentModelNew = TestUtilities.deserialize(json, Enrichment.class);
    assertTrue(enrichmentModelNew instanceof Enrichment);
    assertEquals(enrichmentModelNew.description(), "testString");
    assertEquals(enrichmentModelNew.destinationField(), "testString");
    assertEquals(enrichmentModelNew.sourceField(), "testString");
    assertEquals(enrichmentModelNew.overwrite(), Boolean.valueOf(false));
    assertEquals(enrichmentModelNew.enrichment(), "testString");
    assertEquals(enrichmentModelNew.ignoreDownstreamErrors(), Boolean.valueOf(false));
    assertEquals(enrichmentModelNew.options().toString(), enrichmentOptionsModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnrichmentError() throws Throwable {
    new Enrichment.Builder().build();
  }
}
