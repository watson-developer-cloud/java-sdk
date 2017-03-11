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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;

/**
 * The Class NaturalLanguageunderstandingTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturalLanguageUnderstandingIT extends WatsonServiceTest {

  /** The service. */
  private NaturalLanguageUnderstanding service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("natural_language_understanding.username");
    String password = getProperty("natural_language_understanding.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("natural_language_understanding.url"));
  }

  /**
   * .
   *
   * @throws Exception the exception
   */
  @Test
  public void aCreate() throws Exception {

    String text = "In remote corners of the world, citizens are demanding respect for the dignity of all people no matter their gender, or race, or religion, or disability, or sexual orientation, and those who deny others dignity are subject to public reproach. An explosion of social media has given ordinary people more ways to express themselves, and has raised people's expectations for those of us in power. Indeed, our international order has been so successful that we take it as a given that great powers no longer fight world wars; that the end of the Cold War lifted the shadow of nuclear Armageddon; that the battlefields of Europe have been replaced by peaceful union; that China and India remain on a path of remarkable growth.";
    ConceptsOptions concepts = new ConceptsOptions();
    concepts.setLimit(5);
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
    assertNotNull(results.getConcepts());

  }

}
