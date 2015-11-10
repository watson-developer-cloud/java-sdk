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
package com.ibm.watson.developer_cloud.tone_analyzer.v1;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;

/**
 * The Class ToneAnalyzerTest.
 */
public class ToneAnalyzerIntegrationTest extends WatsonServiceTest {

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
    service = new ToneAnalyzer();
    service.setUsernameAndPassword(getValidProperty("tone_analyzer.username"),
        getValidProperty("tone_analyzer.password"));
    service.setEndPoint(getValidProperty("tone_analyzer.url"));

  }

  /**
   * Test get synonyms.
   */
  @Test
  public void testGetSynonyms() {
    // Call the service and get the synonym for 'difficult' and 'inderior'
    SynonymOptions options = new SynonymOptions().words("difficult", "inferior").limit(3).hops(3);

    List<SynonymResult> synonyms = service.getSynonyms(options);

    Assert.assertNotNull(synonyms);
    Assert.assertFalse(synonyms.isEmpty());
  }

  @Test
  public void testGetTone() {
    final String text =
        "I know the times are difficult! Our sales have been "
            + "disappointing for the past three quarters for our data analytics "
            + "product suite. We have a competitive data analytics product "
            + "suite in the industry. But we need to do our job selling it! ";


    // Call the service and get the tone
    final Tone tone = service.getTone(text, Scorecard.EMAIL);
    Assert.assertNotNull(tone);
    Assert.assertNotNull(tone.getChildren());
    Assert.assertNotNull(tone.getChildren().get(0));
    Assert.assertNotNull(tone.getChildren().get(0).getChildren());
    Assert.assertNotNull(tone.getChildren().get(0).getChildren().get(0));
    Assert.assertNotNull(tone.getScorecard());
  }

  /**
   * Test get the list of scorecards.
   */
  @Test
  public void testGetScorecards() {
    List<Scorecard> scorecards = service.getScorecards();

    Assert.assertNotNull(scorecards);
    Assert.assertFalse(scorecards.isEmpty());
  }
}
