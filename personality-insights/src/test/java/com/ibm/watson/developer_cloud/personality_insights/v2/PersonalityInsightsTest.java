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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Language;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * The Class PersonalityInsightsTest.
 *
 */
public class PersonalityInsightsTest extends WatsonServiceUnitTest {

  private static final String RESOURCE = "src/test/resources/personality_insights/";
  private static final String PROFILE_PATH = "/v2/profile";
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
    contentItem = new ContentItem();
    contentItem.setContent(text);
  }


  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new PersonalityInsights();
    service.setEndPoint(getMockWebServerUrl());
    service.setApiKey("");
  }

  /**
   * Test get profile with content.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetProfileWithContent() throws InterruptedException {
    final Content content = new Content();
    content.addContentItem(contentItem);
    final ProfileOptions options = new ProfileOptions.Builder().addContentItem(contentItem).build();

    server.enqueue(jsonResponse(profile));
    final Profile profile = service.getProfile(options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PROFILE_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertNotNull(profile);
    assertEquals(this.profile, profile);
  }

  /**
   * Test get profile with english text.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetProfileWithEnglishText() throws InterruptedException {
    final ProfileOptions options = new ProfileOptions.Builder().text(text).language(Language.ENGLISH).build();

    server.enqueue(jsonResponse(profile));
    final Profile profile = service.getProfile(options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PROFILE_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("en", request.getHeader(HttpHeaders.CONTENT_LANGUAGE));
    assertEquals(HttpMediaType.TEXT.toString(), request.getHeader(HttpHeaders.CONTENT_TYPE));
    assertEquals(text, request.getBody().readUtf8());
    assertNotNull(profile);
    assertEquals(this.profile, profile);
  }

  /**
   * Test get profile with spanish text.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetProfileWithSpanishText() throws InterruptedException {
    final ProfileOptions options = new ProfileOptions.Builder().text(text).language(Language.SPANISH).build();

    server.enqueue(jsonResponse(profile));
    final Profile profile = service.getProfile(options).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(PROFILE_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals("es", request.getHeader(HttpHeaders.CONTENT_LANGUAGE));
    assertEquals(HttpMediaType.TEXT.toString(), request.getHeader(HttpHeaders.CONTENT_TYPE));
    assertEquals(text, request.getBody().readUtf8());
    assertNotNull(profile);
    assertEquals(profile, this.profile);
  }
}
