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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class NaturalLanguageClassifierExample {

  public static void main(String[] args) {
    NaturalLanguageClassifier service = new NaturalLanguageClassifier();
    service.setUsernameAndPassword("<username>", "<password>");

    Classification classification = service.classify("<classifier-id>", "Is it sunny?").execute();

    System.out.println(classification);
  }

}
