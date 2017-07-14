/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.personality_insights.v3;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

/**
 * Personality Insights Integration Tests.
 * @version v3
 */
public class PersonalityInsightsIT extends WatsonServiceTest {

  private static final String RESOURCE = "src/test/resources/personality_insights/";

  private PersonalityInsights service;
  private static final String VERSION_DATE_2016_10_19 = "2016-10-19";

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("personality_insights.username");
    String password = getProperty("personality_insights.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new PersonalityInsights(VERSION_DATE_2016_10_19);
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("personality_insights.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Gets the profile with text.
   *
   * @throws Exception the exception
   */
  @Test
  public void getProfileWithText() throws Exception {
    File file = new File(RESOURCE + "en.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    ProfileOptions options = new ProfileOptions.Builder().text(englishText).build();
    Profile profile = service.profile(options).execute();

    Assert.assertNotNull(profile);
    Assert.assertNotNull(profile.getProcessedLanguage());
    Assert.assertNotNull(profile.getValues());
    Assert.assertNotNull(profile.getNeeds());
    Assert.assertNotNull(profile.getPersonality());
}

  /**
   * Assert profile.
   *
   * @param profile the profile
   */
  private void assertProfile(Profile profile) {
    Assert.assertNotNull(profile);
    Assert.assertNotNull(profile.getProcessedLanguage());
    Assert.assertNotNull(profile.getConsumptionPreferences());
    Assert.assertNotNull(profile.getValues());
    Assert.assertNotNull(profile.getNeeds());
    Assert.assertNotNull(profile.getPersonality());
    Assert.assertNotNull(profile.getPersonality().get(0).getRawScore());
    Assert.assertNotNull(profile.getWarnings());
    Assert.assertTrue(profile.getWordCount() > 0);
  }

  /**
   * Gets the profile from a single content item.
   *
   * @throws Exception the exception
   */
  @Test
  public void getProfileWithASingleContentItem() throws Exception {
    File file = new File(RESOURCE + "en.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    ContentItem cItem = new ContentItem.Builder(englishText).build();
    Content content = new Content.Builder()
        .addContentItem(cItem)
        .build();
    ProfileOptions options = new ProfileOptions.Builder()
        .content(content)
        .consumptionPreferences(true)
        .rawScores(true)
        .build();
    Profile profile = service.profile(options).execute();

    assertProfile(profile);
  }

  /**
   * Gets the profile from a list of content items.
   *
   * @throws Exception the exception
   */
  @Test
  public void getProfileWithContentItems() throws Exception {
    final Content content = loadFixture(RESOURCE + "v3-contentItems.json", Content.class);
    ProfileOptions options = new ProfileOptions.Builder()
        .content(content)
        .consumptionPreferences(true)
        .rawScores(true)
        .build();

    Profile profile = service.profile(options).execute();
    assertProfile(profile);
  }
}
