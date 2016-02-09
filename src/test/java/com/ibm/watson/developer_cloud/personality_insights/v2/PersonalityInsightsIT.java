/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.personality_insights.v2;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;

/**
 * Personality Insights Integration Tests
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
    service = new PersonalityInsights();
    service.setUsernameAndPassword(getValidProperty("personality_insights.username"),
        getValidProperty("personality_insights.password"));
    service.setEndPoint(getValidProperty("personality_insights.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  @Test
  public void getProfileWithText() throws Exception {
    File file = new File("src/test/resources/personality_insights/en.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    Profile profile = service.getProfile(englishText);

    assertProfile(profile);
  }

  private void assertProfile(Profile profile) {
    assertNotNull(profile);
    assertNotNull(profile.getTree());
  }

  @Test
  public void getProfileWithContentItems() throws Exception {
    File file = new File("src/test/resources/personality_insights/en.txt");
    String englishText = getStringFromInputStream(new FileInputStream(file));

    ContentItem cItem = new ContentItem().content(englishText).created(new Date());
    ProfileOptions options = new ProfileOptions().contentItems(Arrays.asList(cItem));
    Profile profile = service.getProfile(options);

    assertProfile(profile);
  }


}
