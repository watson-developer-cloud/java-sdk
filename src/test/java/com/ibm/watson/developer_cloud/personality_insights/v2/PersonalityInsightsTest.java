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

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions.Language;

/**
 * The Class PersonalityInsightsTest.
 * 
 */
public class PersonalityInsightsTest extends WatsonServiceUnitTest {

  private static final String RESOURCE = "src/test/resources/personality_insights/";
  private final static String PROFILE_PATH = "/v2/profile";
  private String text;
  private PersonalityInsights service;
  private Profile profile;
  private ContentItem contentItem;

  /**
   * Instantiates a new personality insights test.
   *
   * @throws FileNotFoundException the file not found exception
   */
  public PersonalityInsightsTest() throws FileNotFoundException {
    profile = loadFixture(RESOURCE + "profile.json", Profile.class);
    text = "foo-bar-text";
    contentItem = new ContentItem().content(text);
  }


  /* (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new PersonalityInsights();
    service.setEndPoint(MOCK_SERVER_URL);
    service.setApiKey("");
  }

  /**
   * Test get profile with content.
   */
  @Test
  public void testGetProfileWithContent() {
    Content content = new Content();
    content.addContentItem(contentItem);

    // mock
    mockServer.when(
        request().withMethod(POST).withPath(PROFILE_PATH).withBody(new Gson().toJson(content)))
        .respond(response().withHeaders(APPLICATION_JSON).withBody(profile.toString()));

    // test
    ProfileOptions options = new ProfileOptions().addContentItem(contentItem);
    Profile profile = service.getProfile(options).execute();
    Assert.assertNotNull(profile);
    Assert.assertEquals(profile, this.profile);
  }

  /**
   * Test get profile with english text.
   */
  @Test
  public void testGetProfileWithEnglishText() {
    mockServer.when(
        request().withMethod(POST).withPath(PROFILE_PATH).withHeader(TEXT_PLAIN)
            .withHeader(HttpHeaders.CONTENT_LANGUAGE, "en").withBody(text)).respond(
        response().withHeaders(APPLICATION_JSON).withBody(profile.toString()));

    ProfileOptions options = new ProfileOptions().text(text).language(Language.ENGLISH);
    Profile profile = service.getProfile(options).execute();

    Assert.assertNotNull(profile);
    Assert.assertEquals(profile, this.profile);
  }

  /**
   * Test get profile with spanish text.
   */
  @Test
  public void testGetProfileWithSpanishText() {
    mockServer.when(
        request().withMethod(POST).withPath(PROFILE_PATH).withHeader(TEXT_PLAIN)
            .withHeader(HttpHeaders.CONTENT_LANGUAGE, "es").withBody(text)).respond(
        response().withHeaders(APPLICATION_JSON).withBody(profile.toString()));


    ProfileOptions options = new ProfileOptions().text(text).language(Language.SPANISH);
    Profile profile = service.getProfile(options).execute();

    Assert.assertNotNull(profile);
    Assert.assertEquals(profile, this.profile);

  }
}
