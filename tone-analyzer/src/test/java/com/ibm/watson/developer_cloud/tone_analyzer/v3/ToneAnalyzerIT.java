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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneChatRequest;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Utterance;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.UtterancesTone;

/**
 * Tone Analyzer Integration tests.
 */
public class ToneAnalyzerIT extends WatsonServiceTest {

  /** The service. */
  private ToneAnalyzer service;
  private String text = "I know the times are difficult! Our sales have been "
      + "disappointing for the past three quarters for our data analytics "
      + "product suite. We have a competitive data analytics product "
      + "suite in the industry. But we need to do our job selling it! ";

  private String[] users = { "customer", "agent", "customer", "agent" };
  private String[] texts =
      { "My charger isn't working.", "Thanks for reaching out. Can you give me some more detail about the issue?",
          "I put my charger in my tablet to charge it up last night and it keeps saying it isn't"
              + " charging. The charging icon comes on, but it stays on even when I take the charger out. "
              + "Which is ridiculous, it's brand new.",
          "I'm sorry you're having issues with charging. What kind of charger are you using?" };

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    String username = getProperty("tone_analyzer.v3.username");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    service.setUsernameAndPassword(username, getProperty("tone_analyzer.v3.password"));
    service.setEndPoint(getProperty("tone_analyzer.v3.url"));
    service.setDefaultHeaders(getDefaultHeaders());

  }

  /**
   * Test get tone from text.
   */
  @Test
  public void testGetToneFromText() {
    ToneOptions options =
        new ToneOptions.Builder().addTone(Tone.EMOTION).addTone(Tone.LANGUAGE).addTone(Tone.SOCIAL).build();

    ToneAnalysis tone = service.getTone(text, options).execute();
    assertToneAnalysis(tone);
  }

  /**
   * Test get tone from html.
   */
  @Test
  public void testGetToneFromHtml() {
    ToneOptions options = new ToneOptions.Builder().html(true).build();
    ToneAnalysis tone = service.getTone(text, options).execute();
    assertToneAnalysis(tone);
  }

  private void assertToneAnalysis(ToneAnalysis tone) {
    Assert.assertNotNull(tone);
    Assert.assertNotNull(tone.getDocumentTone());
    Assert.assertEquals(3, tone.getDocumentTone().getTones().size());
    Assert.assertNotNull(tone.getSentencesTone());
    Assert.assertEquals(4, tone.getSentencesTone().size());
    Assert.assertEquals("I know the times are difficult!", tone.getSentencesTone().get(0).getText());
  }

  /**
   * Test to get chat tones from jsonText.
   */
  @Test
  public void testGetChatTone() {
    List<Utterance> utterances = new ArrayList<>();
    for (int i = 0; i < texts.length; i++) {
      Utterance utterance = new Utterance.Builder()
          .text(texts[i])
          .user(users[i])
          .build();
      utterances.add(utterance);
    }
    ToneChatRequest toneChatInput = new ToneChatRequest.Builder()
        .utterances(utterances)
        .build();


    UtterancesTone utterancesTone = service.getChatTone(toneChatInput).execute();

    Assert.assertNotNull(utterancesTone);
    Assert.assertNotNull(utterancesTone.getUtterancesTone());
    Assert.assertEquals(4, utterancesTone.getUtterancesTone().size());
    Assert.assertEquals("My charger isn't working.", utterancesTone.getUtterancesTone().get(0).getText());
  }
}
