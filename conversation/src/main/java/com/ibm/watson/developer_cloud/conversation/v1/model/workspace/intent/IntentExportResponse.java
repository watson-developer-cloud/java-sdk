/*
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
package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent;

import java.util.Date;
import java.util.List;

public class IntentExportResponse extends IntentResponse {

  private List<ExampleResponse> examples;

  /**
   * Instantiates a new intent.
   *
   * @param intent
   *          name
   * @param created
   *          created time-stamp
   * @param updated
   *          last updated time-stamp
   * @param description
   *          intent description
   * @param examples
   *          list of utterances
   */
  public IntentExportResponse(String intent, Date created, Date updated, String description,
      List<ExampleResponse> examples) {
    this.intent = intent;
    this.created = created;
    this.updated = updated;
    this.description = description;
    this.examples = examples;
  }

  /**
   * Returns an optional list of examples that could be used to trigger an
   * intent.
   *
   * @return the examples list
   */
  public List<ExampleResponse> getExamples() {
    return examples;
  }
}
