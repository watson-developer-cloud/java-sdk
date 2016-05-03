/* ***************************************************************** */
/*                                                                   */
/* IBM Confidential                                                  */
/* OCO Source Materials                                              */
/*                                                                   */
/* (C) Copyright IBM Corp. 2015, 2016                                */
/*                                                                   */
/* The source code for this program is not published or otherwise    */
/* divested of its trade secrets, irrespective of what has been      */
/* deposited with the U.S. Copyright Office.                         */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.developer_cloud.conversation;

import java.util.Map;

/**
 * Request for {@link ConversationService#message(String, ConversationRequest)}.
 */
public class ConversationRequest {
  private final Input input;
  private final Map<String, Object> state;

  /**
   * Creates a {@code ConversationRequest} for the given {@code text} and {@code state}.
   *
   * @param text Text message for communicating with Dialogs v2 Service API.
   * @param state State from a previous {@link ConversationResponse} with the Dialog v2 Service API.
   * Pass an empty map (e.g. {@code Collections.emptyMap()}) if no prior state exists.
   */
  public ConversationRequest(String text, Map<String, Object> state) {
    input = new Input(text);
    this.state = state;
  }

  private static class Input {
    String text;

    Input(String text) {
      this.text = text;
    }
  }
}
