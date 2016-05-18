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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

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

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    service.setUsernameAndPassword(getValidProperty("tone_analyzer.v3.username"),
        getValidProperty("tone_analyzer.v3.password"));
    service.setEndPoint(getValidProperty("tone_analyzer.v3.url"));
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
   * Test get tone from html
   */
  @Test
  public void testGetToneFromHtml() {
    ToneOptions options = new ToneOptions.Builder().html(true).build();
    ToneAnalysis tone = service.getTone(text, options).execute();
    assertToneAnalysis(tone);
  }

  private void assertToneAnalysis(ToneAnalysis tone) {
    assertNotNull(tone);
    assertNotNull(tone.getDocumentTone());
    assertEquals(3, tone.getDocumentTone().getTones().size());
    assertNotNull(tone.getSentencesTone());
    assertEquals(4, tone.getSentencesTone().size());
    assertEquals("I know the times are difficult!", tone.getSentencesTone().get(0).getText());
  }
}
