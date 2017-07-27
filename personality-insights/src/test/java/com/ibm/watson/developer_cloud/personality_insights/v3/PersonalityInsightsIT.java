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
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import com.ibm.watson.developer_cloud.personality_insights.v3.model.ConsumptionPreferences;
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
   * Test example in Readme.
   */
  @Test
  public void testReadme() {
//    PersonalityInsights service = new PersonalityInsights("2016-10-19");
//    service.setUsernameAndPassword("<username>", "<password>");

    // Demo content from Moby Dick by Hermann Melville (Chapter 1)
    String text = "Call me Ishmael. Some years ago-never mind how long precisely-having "
        + "little or no money in my purse, and nothing particular to interest me on shore, "
        + "I thought I would sail about a little and see the watery part of the world. "
        + "It is a way I have of driving off the spleen and regulating the circulation. "
        + "Whenever I find myself growing grim about the mouth; whenever it is a damp, "
        + "drizzly November in my soul; whenever I find myself involuntarily pausing before "
        + "coffin warehouses, and bringing up the rear of every funeral I meet; and especially "
        + "whenever my hypos get such an upper hand of me, that it requires a strong moral "
        + "principle to prevent me from deliberately stepping into the street, and methodically "
        + "knocking people's hats off-then, I account it high time to get to sea as soon as I can. "
        + "This is my substitute for pistol and ball. With a philosophical flourish Cato throws himself "
        + "upon his sword; I quietly take to the ship. There is nothing surprising in this. "
        + "If they but knew it, almost all men in their degree, some time or other, cherish "
        + "very nearly the same feelings towards the ocean with me. There now is your insular "
        + "city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds "
        + "it with her surf. Right and left, the streets take you waterward.";

    ProfileOptions options = new ProfileOptions.Builder().text(text).build();
    Profile profile = service.profile(options).execute();
    System.out.println(profile);
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

    Long now = new Date().getTime();
    ContentItem cItem = new ContentItem.Builder(englishText)
        .language(ContentItem.Language.EN)
        .contenttype("text/plain")
        .created(now)
        .updated(now)
        .id(UUID.randomUUID().toString())
        .forward(false)
        .reply(false)
        .parentid(null)
        .build();
    Content content = new Content.Builder(Arrays.asList(cItem)).build();
    ProfileOptions options = new ProfileOptions.Builder()
        .content(content)
        .consumptionPreferences(true)
        .acceptLanguage(ProfileOptions.AcceptLanguage.EN)
        .rawScores(true)
        .build();
    Profile profile = service.profile(options).execute();

    assertProfile(profile);

    Assert.assertTrue(profile.getValues().size() > 0);
    Assert.assertNotNull(profile.getValues().get(0).getCategory());
    Assert.assertNotNull(profile.getValues().get(0).getName());
    Assert.assertNotNull(profile.getValues().get(0).getTraitId());
    //Assert.assertNotNull(profile.getValues().get(0).getChildren());
    Assert.assertNotNull(profile.getValues().get(0).getPercentile());
    Assert.assertNotNull(profile.getValues().get(0).getRawScore());

    Assert.assertNotNull(profile.getBehavior());
    Assert.assertTrue(profile.getBehavior().size() > 0);
    Assert.assertNotNull(profile.getBehavior().get(0).getCategory());
    Assert.assertNotNull(profile.getBehavior().get(0).getName());
    Assert.assertNotNull(profile.getBehavior().get(0).getTraitId());
    Assert.assertNotNull(profile.getBehavior().get(0).getPercentage());

    Assert.assertTrue(profile.getConsumptionPreferences().size() > 0);
    Assert.assertNotNull(profile.getConsumptionPreferences().get(0).getName());
    Assert.assertNotNull(profile.getConsumptionPreferences().get(0).getConsumptionPreferenceCategoryId());
    Assert.assertNotNull(profile.getConsumptionPreferences().get(0).getConsumptionPreferences());
    Assert.assertTrue(profile.getConsumptionPreferences().get(0).getConsumptionPreferences().size() > 0);
    ConsumptionPreferences preference = profile.getConsumptionPreferences().get(0).getConsumptionPreferences().get(0);
    Assert.assertNotNull(preference.getConsumptionPreferenceId());
    Assert.assertNotNull(preference.getName());
    Assert.assertNotNull(preference.getScore());
  }

  /**
   * Gets the profile from a single content item in Spanish.
   *
   * @throws Exception the exception
   */
  @Test
  public void getProfileWithASingleSpanishContentItem() throws Exception {
    File file = new File(RESOURCE + "es.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    ContentItem cItem = new ContentItem.Builder(englishText)
        .language(ContentItem.Language.ES)
        .build();
    Content content = new Content.Builder()
        .contentItems(Arrays.asList(cItem))
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
