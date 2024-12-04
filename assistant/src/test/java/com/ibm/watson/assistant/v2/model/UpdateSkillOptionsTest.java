/*
 * (C) Copyright IBM Corp. 2023, 2024.
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

/** Unit test class for the UpdateSkillOptions model. */
public class UpdateSkillOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateSkillOptions() throws Throwable {
    SearchSettingsDiscoveryAuthentication searchSettingsDiscoveryAuthenticationModel =
        new SearchSettingsDiscoveryAuthentication.Builder()
            .basic("testString")
            .bearer("testString")
            .build();
    assertEquals(searchSettingsDiscoveryAuthenticationModel.basic(), "testString");
    assertEquals(searchSettingsDiscoveryAuthenticationModel.bearer(), "testString");

    SearchSettingsDiscovery searchSettingsDiscoveryModel =
        new SearchSettingsDiscovery.Builder()
            .instanceId("testString")
            .projectId("testString")
            .url("testString")
            .maxPrimaryResults(Long.valueOf("10000"))
            .maxTotalResults(Long.valueOf("10000"))
            .confidenceThreshold(Double.valueOf("0.0"))
            .highlight(true)
            .findAnswers(true)
            .authentication(searchSettingsDiscoveryAuthenticationModel)
            .build();
    assertEquals(searchSettingsDiscoveryModel.instanceId(), "testString");
    assertEquals(searchSettingsDiscoveryModel.projectId(), "testString");
    assertEquals(searchSettingsDiscoveryModel.url(), "testString");
    assertEquals(searchSettingsDiscoveryModel.maxPrimaryResults(), Long.valueOf("10000"));
    assertEquals(searchSettingsDiscoveryModel.maxTotalResults(), Long.valueOf("10000"));
    assertEquals(searchSettingsDiscoveryModel.confidenceThreshold(), Double.valueOf("0.0"));
    assertEquals(searchSettingsDiscoveryModel.highlight(), Boolean.valueOf(true));
    assertEquals(searchSettingsDiscoveryModel.findAnswers(), Boolean.valueOf(true));
    assertEquals(
        searchSettingsDiscoveryModel.authentication(), searchSettingsDiscoveryAuthenticationModel);

    SearchSettingsMessages searchSettingsMessagesModel =
        new SearchSettingsMessages.Builder()
            .success("testString")
            .error("testString")
            .noResult("testString")
            .build();
    assertEquals(searchSettingsMessagesModel.success(), "testString");
    assertEquals(searchSettingsMessagesModel.error(), "testString");
    assertEquals(searchSettingsMessagesModel.noResult(), "testString");

    SearchSettingsSchemaMapping searchSettingsSchemaMappingModel =
        new SearchSettingsSchemaMapping.Builder()
            .url("testString")
            .body("testString")
            .title("testString")
            .build();
    assertEquals(searchSettingsSchemaMappingModel.url(), "testString");
    assertEquals(searchSettingsSchemaMappingModel.body(), "testString");
    assertEquals(searchSettingsSchemaMappingModel.title(), "testString");

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

    SearchSettingsConversationalSearchResponseLength
        searchSettingsConversationalSearchResponseLengthModel =
            new SearchSettingsConversationalSearchResponseLength.Builder()
                .option("moderate")
                .build();
    assertEquals(searchSettingsConversationalSearchResponseLengthModel.option(), "moderate");

    SearchSettingsConversationalSearchSearchConfidence
        searchSettingsConversationalSearchSearchConfidenceModel =
            new SearchSettingsConversationalSearchSearchConfidence.Builder()
                .threshold("less_often")
                .build();
    assertEquals(searchSettingsConversationalSearchSearchConfidenceModel.threshold(), "less_often");

    SearchSettingsConversationalSearch searchSettingsConversationalSearchModel =
        new SearchSettingsConversationalSearch.Builder()
            .enabled(true)
            .responseLength(searchSettingsConversationalSearchResponseLengthModel)
            .searchConfidence(searchSettingsConversationalSearchSearchConfidenceModel)
            .build();
    assertEquals(searchSettingsConversationalSearchModel.enabled(), Boolean.valueOf(true));
    assertEquals(
        searchSettingsConversationalSearchModel.responseLength(),
        searchSettingsConversationalSearchResponseLengthModel);
    assertEquals(
        searchSettingsConversationalSearchModel.searchConfidence(),
        searchSettingsConversationalSearchSearchConfidenceModel);

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

    SearchSettingsClientSideSearch searchSettingsClientSideSearchModel =
        new SearchSettingsClientSideSearch.Builder()
            .filter("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(searchSettingsClientSideSearchModel.filter(), "testString");
    assertEquals(
        searchSettingsClientSideSearchModel.metadata(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    SearchSettings searchSettingsModel =
        new SearchSettings.Builder()
            .discovery(searchSettingsDiscoveryModel)
            .messages(searchSettingsMessagesModel)
            .schemaMapping(searchSettingsSchemaMappingModel)
            .elasticSearch(searchSettingsElasticSearchModel)
            .conversationalSearch(searchSettingsConversationalSearchModel)
            .serverSideSearch(searchSettingsServerSideSearchModel)
            .clientSideSearch(searchSettingsClientSideSearchModel)
            .build();
    assertEquals(searchSettingsModel.discovery(), searchSettingsDiscoveryModel);
    assertEquals(searchSettingsModel.messages(), searchSettingsMessagesModel);
    assertEquals(searchSettingsModel.schemaMapping(), searchSettingsSchemaMappingModel);
    assertEquals(searchSettingsModel.elasticSearch(), searchSettingsElasticSearchModel);
    assertEquals(
        searchSettingsModel.conversationalSearch(), searchSettingsConversationalSearchModel);
    assertEquals(searchSettingsModel.serverSideSearch(), searchSettingsServerSideSearchModel);
    assertEquals(searchSettingsModel.clientSideSearch(), searchSettingsClientSideSearchModel);

    UpdateSkillOptions updateSkillOptionsModel =
        new UpdateSkillOptions.Builder()
            .assistantId("testString")
            .skillId("testString")
            .name("testString")
            .description("testString")
            .workspace(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .dialogSettings(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .searchSettings(searchSettingsModel)
            .build();
    assertEquals(updateSkillOptionsModel.assistantId(), "testString");
    assertEquals(updateSkillOptionsModel.skillId(), "testString");
    assertEquals(updateSkillOptionsModel.name(), "testString");
    assertEquals(updateSkillOptionsModel.description(), "testString");
    assertEquals(
        updateSkillOptionsModel.workspace(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        updateSkillOptionsModel.dialogSettings(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(updateSkillOptionsModel.searchSettings(), searchSettingsModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSkillOptionsError() throws Throwable {
    new UpdateSkillOptions.Builder().build();
  }
}
