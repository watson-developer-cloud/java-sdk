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

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

public class ToneAnalyzerExample {


  public static void main(String[] args) {
    ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_02_11);
    service.setUsernameAndPassword("<username>", "<password>");

    String text =
      "I know the times are difficult! Our sales have been "
          + "disappointing for the past three quarters for our data analytics "
          + "product suite. We have a competitive data analytics product "
          + "suite in the industry. But we need to do our job selling it! "
          + "We need to acknowledge and fix our sales challenges. "
          + "We can’t blame the economy for our lack of execution! "
          + "We are missing critical sales opportunities. "
          + "Our product is in no way inferior to the competitor products. "
          + "Our clients are hungry for analytical tools to improve their "
          + "business outcomes. Economy has nothing to do with it.";

    // Call the service and get the tone
    ToneAnalysis tone = service.getTone(text);
    System.out.println(tone);

  }
}
