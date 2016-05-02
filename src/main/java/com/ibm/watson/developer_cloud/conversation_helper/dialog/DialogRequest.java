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

package com.ibm.watson.developer_cloud.conversation_helper.dialog;

import java.util.Map;

/**
 * Request for {@link DialogService#message(String, DialogRequest)}.
 */
public class DialogRequest {
  private final Input input;
  private final Map<String, Object> state;

  /**
   * Creates a {@code DialogRequest} for the given {@code text} and {@code state}.
   *
   * @param text Text message for communicating with Dialogs v2 Service API.
   * @param state State from a previous {@link DialogResponse} with the Dialog v2 Service API.
   * Pass an empty map (e.g. {@code Collections.emptyMap()}) if no prior state exists.
   */
  public DialogRequest(String text, Map<String, Object> state) {
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
