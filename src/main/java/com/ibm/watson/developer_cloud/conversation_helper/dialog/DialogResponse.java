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
 * Response for {@link DialogService#message(String, DialogRequest)}.
 */
public class DialogResponse {
  private Map<String, Object> output;
  private Map<String, Object> state;

  /**
   * @return 'output' field from response.
   */
  public Map<String, Object> getOutput() {
    return output;
  }

  /**
   * @return 'state' field from response.
   */
  public Map<String, Object> getState() {
    return state;
  }
}
