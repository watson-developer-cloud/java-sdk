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
package com.ibm.watson.developer_cloud.personality_insights.v2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Date;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * Personality Insights Integration Tests.
 */
public class PersonalityInsightsIT extends WatsonServiceTest {

  private PersonalityInsights service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("personality_insights.username");
    String password = getProperty("personality_insights.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new PersonalityInsights();
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
    File file = new File("src/test/resources/personality_insights/en.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    Profile profile = service.getProfile(englishText).execute();

    assertProfile(profile);
  }

  private void assertProfile(Profile profile) {
    Assert.assertNotNull(profile);
    Assert.assertNotNull(profile.getTree());
  }

  /**
   * Gets the profile from a single content item.
   *
   * @throws Exception the exception
   */
  @Test
  public void getProfileWithASingleContentItem() throws Exception {
    File file = new File("src/test/resources/personality_insights/en.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    ContentItem cItem = new ContentItem();
    cItem.setContent(englishText);
    cItem.setCreated(new Date());
    ProfileOptions options = new ProfileOptions.Builder().contentItems(Collections.singletonList(cItem)).build();
    Profile profile = service.getProfile(options).execute();

    assertProfile(profile);
  }


  /**
   * Gets the profile from a list of content items.
   *
   * @throws Exception the exception
   */
  @Test
  public void getProfileWithContentItems() throws Exception {
    File file = new File("src/test/resources/personality_insights/contentItems.json");
    String contentItems = getStringFromInputStream(new FileInputStream(file));
    Content content = GsonSingleton.getGson().fromJson(contentItems, Content.class);
    ProfileOptions options = new ProfileOptions.Builder().contentItems(content.getContentItems()).build();
    Profile profile = service.getProfile(options).execute();

    assertProfile(profile);
  }
}
