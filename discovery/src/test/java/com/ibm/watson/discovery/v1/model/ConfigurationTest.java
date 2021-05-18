/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

/** Unit test class for the Configuration model. */
public class ConfigurationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConfiguration() throws Throwable {
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
        new PdfHeadingDetection.Builder()
            .fonts(new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)))
            .build();
    assertEquals(
        pdfHeadingDetectionModel.fonts(),
        new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)));

    PdfSettings pdfSettingsModel =
        new PdfSettings.Builder().heading(pdfHeadingDetectionModel).build();
    assertEquals(pdfSettingsModel.heading(), pdfHeadingDetectionModel);

    WordStyle wordStyleModel =
        new WordStyle.Builder()
            .level(Long.valueOf("26"))
            .names(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(wordStyleModel.level(), Long.valueOf("26"));
    assertEquals(
        wordStyleModel.names(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    WordHeadingDetection wordHeadingDetectionModel =
        new WordHeadingDetection.Builder()
            .fonts(new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)))
            .styles(new java.util.ArrayList<WordStyle>(java.util.Arrays.asList(wordStyleModel)))
            .build();
    assertEquals(
        wordHeadingDetectionModel.fonts(),
        new java.util.ArrayList<FontSetting>(java.util.Arrays.asList(fontSettingModel)));
    assertEquals(
        wordHeadingDetectionModel.styles(),
        new java.util.ArrayList<WordStyle>(java.util.Arrays.asList(wordStyleModel)));

    WordSettings wordSettingsModel =
        new WordSettings.Builder().heading(wordHeadingDetectionModel).build();
    assertEquals(wordSettingsModel.heading(), wordHeadingDetectionModel);

    XPathPatterns xPathPatternsModel =
        new XPathPatterns.Builder()
            .xpaths(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(
        xPathPatternsModel.xpaths(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    HtmlSettings htmlSettingsModel =
        new HtmlSettings.Builder()
            .excludeTagsCompletely(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .excludeTagsKeepContent(
                new java.util.ArrayList<String>(java.util.Arrays.asList("span")))
            .keepContent(xPathPatternsModel)
            .excludeContent(xPathPatternsModel)
            .keepTagAttributes(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .excludeTagAttributes(
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(
        htmlSettingsModel.excludeTagsCompletely(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        htmlSettingsModel.excludeTagsKeepContent(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("span")));
    assertEquals(htmlSettingsModel.keepContent(), xPathPatternsModel);
    assertEquals(htmlSettingsModel.excludeContent(), xPathPatternsModel);
    assertEquals(
        htmlSettingsModel.keepTagAttributes(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        htmlSettingsModel.excludeTagAttributes(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    SegmentSettings segmentSettingsModel =
        new SegmentSettings.Builder()
            .enabled(true)
            .selectorTags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .annotatedFields(
                new java.util.ArrayList<String>(
                    java.util.Arrays.asList("custom-field-1", "custom-field-2")))
            .build();
    assertEquals(segmentSettingsModel.enabled(), Boolean.valueOf(true));
    assertEquals(
        segmentSettingsModel.selectorTags(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        segmentSettingsModel.annotatedFields(),
        new java.util.ArrayList<String>(
            java.util.Arrays.asList("custom-field-1", "custom-field-2")));

    NormalizationOperation normalizationOperationModel =
        new NormalizationOperation.Builder()
            .operation("move")
            .sourceField("extracted_metadata.title")
            .destinationField("metadata.title")
            .build();
    assertEquals(normalizationOperationModel.operation(), "move");
    assertEquals(normalizationOperationModel.sourceField(), "extracted_metadata.title");
    assertEquals(normalizationOperationModel.destinationField(), "metadata.title");

    Conversions conversionsModel =
        new Conversions.Builder()
            .pdf(pdfSettingsModel)
            .word(wordSettingsModel)
            .html(htmlSettingsModel)
            .segment(segmentSettingsModel)
            .jsonNormalizations(
                new java.util.ArrayList<NormalizationOperation>(
                    java.util.Arrays.asList(normalizationOperationModel)))
            .imageTextRecognition(true)
            .build();
    assertEquals(conversionsModel.pdf(), pdfSettingsModel);
    assertEquals(conversionsModel.word(), wordSettingsModel);
    assertEquals(conversionsModel.html(), htmlSettingsModel);
    assertEquals(conversionsModel.segment(), segmentSettingsModel);
    assertEquals(
        conversionsModel.jsonNormalizations(),
        new java.util.ArrayList<NormalizationOperation>(
            java.util.Arrays.asList(normalizationOperationModel)));
    assertEquals(conversionsModel.imageTextRecognition(), Boolean.valueOf(true));

    NluEnrichmentKeywords nluEnrichmentKeywordsModel =
        new NluEnrichmentKeywords.Builder()
            .sentiment(true)
            .emotion(false)
            .limit(Long.valueOf("50"))
            .build();
    assertEquals(nluEnrichmentKeywordsModel.sentiment(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentKeywordsModel.emotion(), Boolean.valueOf(false));
    assertEquals(nluEnrichmentKeywordsModel.limit(), Long.valueOf("50"));

    NluEnrichmentEntities nluEnrichmentEntitiesModel =
        new NluEnrichmentEntities.Builder()
            .sentiment(true)
            .emotion(false)
            .limit(Long.valueOf("50"))
            .mentions(true)
            .mentionTypes(true)
            .sentenceLocations(true)
            .model("WKS-model-id")
            .build();
    assertEquals(nluEnrichmentEntitiesModel.sentiment(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.emotion(), Boolean.valueOf(false));
    assertEquals(nluEnrichmentEntitiesModel.limit(), Long.valueOf("50"));
    assertEquals(nluEnrichmentEntitiesModel.mentions(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.mentionTypes(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.sentenceLocations(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentEntitiesModel.model(), "WKS-model-id");

    NluEnrichmentSentiment nluEnrichmentSentimentModel =
        new NluEnrichmentSentiment.Builder()
            .document(true)
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("IBM", "Watson")))
            .build();
    assertEquals(nluEnrichmentSentimentModel.document(), Boolean.valueOf(true));
    assertEquals(
        nluEnrichmentSentimentModel.targets(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("IBM", "Watson")));

    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("IBM", "Watson")))
            .build();
    assertEquals(nluEnrichmentEmotionModel.document(), Boolean.valueOf(true));
    assertEquals(
        nluEnrichmentEmotionModel.targets(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("IBM", "Watson")));

    NluEnrichmentSemanticRoles nluEnrichmentSemanticRolesModel =
        new NluEnrichmentSemanticRoles.Builder()
            .entities(true)
            .keywords(true)
            .limit(Long.valueOf("50"))
            .build();
    assertEquals(nluEnrichmentSemanticRolesModel.entities(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentSemanticRolesModel.keywords(), Boolean.valueOf(true));
    assertEquals(nluEnrichmentSemanticRolesModel.limit(), Long.valueOf("50"));

    NluEnrichmentRelations nluEnrichmentRelationsModel =
        new NluEnrichmentRelations.Builder().model("WKS-model-id").build();
    assertEquals(nluEnrichmentRelationsModel.model(), "WKS-model-id");

    NluEnrichmentConcepts nluEnrichmentConceptsModel =
        new NluEnrichmentConcepts.Builder().limit(Long.valueOf("8")).build();
    assertEquals(nluEnrichmentConceptsModel.limit(), Long.valueOf("8"));

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
            .destinationField("enriched_title")
            .sourceField("title")
            .overwrite(true)
            .enrichment("natural_language_understanding")
            .ignoreDownstreamErrors(true)
            .options(enrichmentOptionsModel)
            .build();
    assertEquals(enrichmentModel.description(), "testString");
    assertEquals(enrichmentModel.destinationField(), "enriched_title");
    assertEquals(enrichmentModel.sourceField(), "title");
    assertEquals(enrichmentModel.overwrite(), Boolean.valueOf(true));
    assertEquals(enrichmentModel.enrichment(), "natural_language_understanding");
    assertEquals(enrichmentModel.ignoreDownstreamErrors(), Boolean.valueOf(true));
    assertEquals(enrichmentModel.options(), enrichmentOptionsModel);

    SourceSchedule sourceScheduleModel =
        new SourceSchedule.Builder()
            .enabled(true)
            .timeZone("America/New_York")
            .frequency("weekly")
            .build();
    assertEquals(sourceScheduleModel.enabled(), Boolean.valueOf(true));
    assertEquals(sourceScheduleModel.timeZone(), "America/New_York");
    assertEquals(sourceScheduleModel.frequency(), "weekly");

    SourceOptionsFolder sourceOptionsFolderModel =
        new SourceOptionsFolder.Builder()
            .ownerUserId("testString")
            .folderId("testString")
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(sourceOptionsFolderModel.ownerUserId(), "testString");
    assertEquals(sourceOptionsFolderModel.folderId(), "testString");
    assertEquals(sourceOptionsFolderModel.limit(), Long.valueOf("26"));

    SourceOptionsObject sourceOptionsObjectModel =
        new SourceOptionsObject.Builder().name("testString").limit(Long.valueOf("26")).build();
    assertEquals(sourceOptionsObjectModel.name(), "testString");
    assertEquals(sourceOptionsObjectModel.limit(), Long.valueOf("26"));

    SourceOptionsSiteColl sourceOptionsSiteCollModel =
        new SourceOptionsSiteColl.Builder()
            .siteCollectionPath("/sites/TestSiteA")
            .limit(Long.valueOf("10"))
            .build();
    assertEquals(sourceOptionsSiteCollModel.siteCollectionPath(), "/sites/TestSiteA");
    assertEquals(sourceOptionsSiteCollModel.limit(), Long.valueOf("10"));

    SourceOptionsWebCrawl sourceOptionsWebCrawlModel =
        new SourceOptionsWebCrawl.Builder()
            .url("testString")
            .limitToStartingHosts(true)
            .crawlSpeed("gentle")
            .allowUntrustedCertificate(true)
            .maximumHops(Long.valueOf("26"))
            .requestTimeout(Long.valueOf("26"))
            .overrideRobotsTxt(true)
            .blacklist(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(sourceOptionsWebCrawlModel.url(), "testString");
    assertEquals(sourceOptionsWebCrawlModel.limitToStartingHosts(), Boolean.valueOf(true));
    assertEquals(sourceOptionsWebCrawlModel.crawlSpeed(), "gentle");
    assertEquals(sourceOptionsWebCrawlModel.allowUntrustedCertificate(), Boolean.valueOf(true));
    assertEquals(sourceOptionsWebCrawlModel.maximumHops(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModel.requestTimeout(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModel.overrideRobotsTxt(), Boolean.valueOf(true));
    assertEquals(
        sourceOptionsWebCrawlModel.blacklist(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    SourceOptionsBuckets sourceOptionsBucketsModel =
        new SourceOptionsBuckets.Builder().name("testString").limit(Long.valueOf("26")).build();
    assertEquals(sourceOptionsBucketsModel.name(), "testString");
    assertEquals(sourceOptionsBucketsModel.limit(), Long.valueOf("26"));

    SourceOptions sourceOptionsModel =
        new SourceOptions.Builder()
            .folders(
                new java.util.ArrayList<SourceOptionsFolder>(
                    java.util.Arrays.asList(sourceOptionsFolderModel)))
            .objects(
                new java.util.ArrayList<SourceOptionsObject>(
                    java.util.Arrays.asList(sourceOptionsObjectModel)))
            .siteCollections(
                new java.util.ArrayList<SourceOptionsSiteColl>(
                    java.util.Arrays.asList(sourceOptionsSiteCollModel)))
            .urls(
                new java.util.ArrayList<SourceOptionsWebCrawl>(
                    java.util.Arrays.asList(sourceOptionsWebCrawlModel)))
            .buckets(
                new java.util.ArrayList<SourceOptionsBuckets>(
                    java.util.Arrays.asList(sourceOptionsBucketsModel)))
            .crawlAllBuckets(true)
            .build();
    assertEquals(
        sourceOptionsModel.folders(),
        new java.util.ArrayList<SourceOptionsFolder>(
            java.util.Arrays.asList(sourceOptionsFolderModel)));
    assertEquals(
        sourceOptionsModel.objects(),
        new java.util.ArrayList<SourceOptionsObject>(
            java.util.Arrays.asList(sourceOptionsObjectModel)));
    assertEquals(
        sourceOptionsModel.siteCollections(),
        new java.util.ArrayList<SourceOptionsSiteColl>(
            java.util.Arrays.asList(sourceOptionsSiteCollModel)));
    assertEquals(
        sourceOptionsModel.urls(),
        new java.util.ArrayList<SourceOptionsWebCrawl>(
            java.util.Arrays.asList(sourceOptionsWebCrawlModel)));
    assertEquals(
        sourceOptionsModel.buckets(),
        new java.util.ArrayList<SourceOptionsBuckets>(
            java.util.Arrays.asList(sourceOptionsBucketsModel)));
    assertEquals(sourceOptionsModel.crawlAllBuckets(), Boolean.valueOf(true));

    Source sourceModel =
        new Source.Builder()
            .type("salesforce")
            .credentialId("00ad0000-0000-11e8-ba89-0ed5f00f718b")
            .schedule(sourceScheduleModel)
            .options(sourceOptionsModel)
            .build();
    assertEquals(sourceModel.type(), "salesforce");
    assertEquals(sourceModel.credentialId(), "00ad0000-0000-11e8-ba89-0ed5f00f718b");
    assertEquals(sourceModel.schedule(), sourceScheduleModel);
    assertEquals(sourceModel.options(), sourceOptionsModel);

    Configuration configurationModel =
        new Configuration.Builder()
            .name("testString")
            .description("testString")
            .conversions(conversionsModel)
            .enrichments(
                new java.util.ArrayList<Enrichment>(java.util.Arrays.asList(enrichmentModel)))
            .normalizations(
                new java.util.ArrayList<NormalizationOperation>(
                    java.util.Arrays.asList(normalizationOperationModel)))
            .source(sourceModel)
            .build();
    assertEquals(configurationModel.name(), "testString");
    assertEquals(configurationModel.description(), "testString");
    assertEquals(configurationModel.conversions(), conversionsModel);
    assertEquals(
        configurationModel.enrichments(),
        new java.util.ArrayList<Enrichment>(java.util.Arrays.asList(enrichmentModel)));
    assertEquals(
        configurationModel.normalizations(),
        new java.util.ArrayList<NormalizationOperation>(
            java.util.Arrays.asList(normalizationOperationModel)));
    assertEquals(configurationModel.source(), sourceModel);

    String json = TestUtilities.serialize(configurationModel);

    Configuration configurationModelNew = TestUtilities.deserialize(json, Configuration.class);
    assertTrue(configurationModelNew instanceof Configuration);
    assertEquals(configurationModelNew.name(), "testString");
    assertEquals(configurationModelNew.description(), "testString");
    assertEquals(configurationModelNew.conversions().toString(), conversionsModel.toString());
    assertEquals(configurationModelNew.source().toString(), sourceModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConfigurationError() throws Throwable {
    new Configuration.Builder().build();
  }
}
