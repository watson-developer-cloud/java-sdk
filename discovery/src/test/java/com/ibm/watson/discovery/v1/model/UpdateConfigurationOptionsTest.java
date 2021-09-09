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

/** Unit test class for the UpdateConfigurationOptions model. */
public class UpdateConfigurationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateConfigurationOptions() throws Throwable {
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
                new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
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
            .enabled(false)
            .selectorTags(new java.util.ArrayList<String>(java.util.Arrays.asList("h1", "h2")))
            .annotatedFields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(segmentSettingsModel.enabled(), Boolean.valueOf(false));
    assertEquals(
        segmentSettingsModel.selectorTags(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("h1", "h2")));
    assertEquals(
        segmentSettingsModel.annotatedFields(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    NormalizationOperation normalizationOperationModel =
        new NormalizationOperation.Builder()
            .operation("copy")
            .sourceField("testString")
            .destinationField("testString")
            .build();
    assertEquals(normalizationOperationModel.operation(), "copy");
    assertEquals(normalizationOperationModel.sourceField(), "testString");
    assertEquals(normalizationOperationModel.destinationField(), "testString");

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
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(nluEnrichmentSentimentModel.document(), Boolean.valueOf(true));
    assertEquals(
        nluEnrichmentSentimentModel.targets(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    NluEnrichmentEmotion nluEnrichmentEmotionModel =
        new NluEnrichmentEmotion.Builder()
            .document(true)
            .targets(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(nluEnrichmentEmotionModel.document(), Boolean.valueOf(true));
    assertEquals(
        nluEnrichmentEmotionModel.targets(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

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

    SourceSchedule sourceScheduleModel =
        new SourceSchedule.Builder()
            .enabled(true)
            .timeZone("America/New_York")
            .frequency("daily")
            .build();
    assertEquals(sourceScheduleModel.enabled(), Boolean.valueOf(true));
    assertEquals(sourceScheduleModel.timeZone(), "America/New_York");
    assertEquals(sourceScheduleModel.frequency(), "daily");

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
            .siteCollectionPath("testString")
            .limit(Long.valueOf("26"))
            .build();
    assertEquals(sourceOptionsSiteCollModel.siteCollectionPath(), "testString");
    assertEquals(sourceOptionsSiteCollModel.limit(), Long.valueOf("26"));

    SourceOptionsWebCrawl sourceOptionsWebCrawlModel =
        new SourceOptionsWebCrawl.Builder()
            .url("testString")
            .limitToStartingHosts(true)
            .crawlSpeed("normal")
            .allowUntrustedCertificate(false)
            .maximumHops(Long.valueOf("26"))
            .requestTimeout(Long.valueOf("26"))
            .overrideRobotsTxt(false)
            .blacklist(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(sourceOptionsWebCrawlModel.url(), "testString");
    assertEquals(sourceOptionsWebCrawlModel.limitToStartingHosts(), Boolean.valueOf(true));
    assertEquals(sourceOptionsWebCrawlModel.crawlSpeed(), "normal");
    assertEquals(sourceOptionsWebCrawlModel.allowUntrustedCertificate(), Boolean.valueOf(false));
    assertEquals(sourceOptionsWebCrawlModel.maximumHops(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModel.requestTimeout(), Long.valueOf("26"));
    assertEquals(sourceOptionsWebCrawlModel.overrideRobotsTxt(), Boolean.valueOf(false));
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
            .type("box")
            .credentialId("testString")
            .schedule(sourceScheduleModel)
            .options(sourceOptionsModel)
            .build();
    assertEquals(sourceModel.type(), "box");
    assertEquals(sourceModel.credentialId(), "testString");
    assertEquals(sourceModel.schedule(), sourceScheduleModel);
    assertEquals(sourceModel.options(), sourceOptionsModel);

    UpdateConfigurationOptions updateConfigurationOptionsModel =
        new UpdateConfigurationOptions.Builder()
            .environmentId("testString")
            .configurationId("testString")
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
    assertEquals(updateConfigurationOptionsModel.environmentId(), "testString");
    assertEquals(updateConfigurationOptionsModel.configurationId(), "testString");
    assertEquals(updateConfigurationOptionsModel.name(), "testString");
    assertEquals(updateConfigurationOptionsModel.description(), "testString");
    assertEquals(updateConfigurationOptionsModel.conversions(), conversionsModel);
    assertEquals(
        updateConfigurationOptionsModel.enrichments(),
        new java.util.ArrayList<Enrichment>(java.util.Arrays.asList(enrichmentModel)));
    assertEquals(
        updateConfigurationOptionsModel.normalizations(),
        new java.util.ArrayList<NormalizationOperation>(
            java.util.Arrays.asList(normalizationOperationModel)));
    assertEquals(updateConfigurationOptionsModel.source(), sourceModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateConfigurationOptionsError() throws Throwable {
    new UpdateConfigurationOptions.Builder().build();
  }
}
