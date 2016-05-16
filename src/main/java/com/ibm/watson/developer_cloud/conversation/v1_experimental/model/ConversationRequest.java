/* ***************************************************************** */
/*                                                                   */
/* IBM Confidential */
/* OCO Source Materials */
/*                                                                   */
/* (C) Copyright IBM Corp. 2015, 2016 */
/*                                                                   */
/* The source code for this program is not published or otherwise */
/* divested of its trade secrets, irrespective of what has been */
/* deposited with the U.S. Copyright Office. */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.Conversation;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Request for {@link Conversation#message(String, ConversationRequest)}.
 */
public class ConversationRequest extends GenericModel {
  private static class Input {
    String text;

    Input(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }
  }

  private final Input input;
  private final Map<String, Object> context;

  /**
   * Creates a {@code ConversationRequest} for the given {@code text} and {@code context}.
   *
   * @param text Text message for communicating with Conversation Service API.
   * @param context Context from a previous {@link ConversationResponse} with the Conversation
   *        Service API. Pass an empty map (e.g. {@code Collections.emptyMap()}) if no prior state
   *        exists.
   */
  public ConversationRequest(String text, Map<String, Object> context) {
    input = new Input(text);
    this.context = context;
  }

  public Input getInput() {
    return input;
  }

  /**
   * Returns a map that represents the state which must be sent to the Conversation service. Context
   * must be passed in with each request, thus the context from the previous response must be
   * maintained by the client and passed in as a part of the subsequent requests. A client may
   * modify context between API calls in order to generate certain results in the runtime.
   * 
   * @return A map representing a JSON object.
   */
  public Map<String, Object> getContext() {
    return context;
  }
}
