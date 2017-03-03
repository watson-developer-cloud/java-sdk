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

import java.util.ArrayList;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The response payload from the Conversation service's intents API call
 * {@link ConversationService#createIntent(String, MessageRequest)}.
 * {@link ConversationService#getIntent(String, String)}.
 * {@link ConversationService#updateIntent(String, String, IntentRequest)}.
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html"> http://www.ibm.com/
 *      watson/developercloud/conversation.html</a>
 */
public class IntentResponse extends GenericModel {
    private String intent;
    private String created;
    private String updated;
    private String description;
    private ArrayList<IntentExample> examples;

  /**
   * Returns the intent name as returned by the service.
   *
   * @return a string representing intent name
   */
  public String getIntent() {
    return intent;
  }

  /**
   * Returns the time stamp that the intent was created.
   *
   * @return a string representation of a date
   */
  public String getCreated() {
    return created;
  }

  /**
   * Returns the time stamp that the intent was last updated.
   *
   * @return a string representation of a date
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Returns an explanation of the intent.
   *
   * @return a string representing the description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns a list of examples that can be used to trigger an intent.
   *
   * @return an array of {@link IntentRequest} the provided examples that can trigger an intent.
   */
  public ArrayList<IntentExample> getExamples() {
    return examples;
  }

  /**
   * Sets the intent name.
   *
   * @param string of the intent name.
   */
  public void setIntent(String intent) {
    this.intent = intent;
  }

  /**
   * Sets the time of intent creation as determined by the service.
   *
   * @param string of the creation time stamp
   */
  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * Sets a list of entities as detected by the service.
   *
   * @param string of the update time stamp
   */
  public void setUpdated(String updated) {
    this.updated = updated;
  }

  /**
   * Sets the description.
   *
   * @param string of the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets the list of examples.
   *
   * @param an array of {@link IntentRequest}
   */
  public ArrayList<IntentExample> setExamples() {
    return examples;
  }
}
