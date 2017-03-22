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

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;

/**
 * The response payload from the Conversation service's intents API call
 * {@link ConversationService#createIntent(String, CreateIntent)}.
 * {@link ConversationService#getIntent(String, String)}.
 * {@link ConversationService#updateIntent(String, String, CreateIntent)}.
 *
 * @see <a href="http://www.ibm.com/watson/developercloud/conversation.html"> http://www.ibm.com/
 *      watson/developercloud/conversation.html</a>
 */
public class IntentResponse extends Intent {
	protected String created;
    protected String updated;

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


}
