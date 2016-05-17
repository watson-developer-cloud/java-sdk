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
package com.ibm.watson.developer_cloud.tone_analyzer.v3_beta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.tone_analyzer.v3_beta.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3_beta.model.ToneAnalysis;

/**
 * Tone Analyzer Integration tests.
 */
public class ToneAnalyzerIT extends WatsonServiceTest {

  /** The service. */
  private ToneAnalyzer service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_02_11);
    service.setUsernameAndPassword(getValidProperty("tone_analyzer.v3_beta.username"),
        getValidProperty("tone_analyzer.v3_beta.password"));
    service.setEndPoint(getValidProperty("tone_analyzer.v3_beta.url"));
    service.setDefaultHeaders(getDefaultHeaders());

  }

  /**
   * Test get tone.
   */
  @Test
  public void testGetTone() {
    final String text =
        "I know the times are difficult! Our sales have been "
            + "disappointing for the past three quarters for our data analytics "
            + "product suite. We have a competitive data analytics product "
            + "suite in the industry. But we need to do our job selling it! ";


    // Call the service and get the tone
    final ToneAnalysis tone = service.getTone(text).execute();
    Assert.assertNotNull(tone);
    Assert.assertNotNull(tone.getDocumentTone());
    Assert.assertEquals(3, tone.getDocumentTone().getTones().size());
    Assert.assertNotNull(tone.getSentencesTone());
    Assert.assertEquals(4, tone.getSentencesTone().size());
    Assert.assertEquals("I know the times are difficult!", tone.getSentencesTone().get(0).getText());
  }

}
