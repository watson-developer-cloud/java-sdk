/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.natural_language_understanding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The Class NaturalLanguageUnderstandingTest.
 */
public class NaturalLanguageUnderstandingTest  {
  private static final String TEXT = "text";
  private static final String CLASSIFIERS_PATH = "/v1/classifiers";
  private static final String CLASSIFY_PATH = "/v1/classifiers/%s/classify";
  private static final String RESOURCE = "src/test/resources/natural_language_classifier/";

  @Test
  public void testTest() {
    assertTrue(String.valueOf(true), true);
  }

}
