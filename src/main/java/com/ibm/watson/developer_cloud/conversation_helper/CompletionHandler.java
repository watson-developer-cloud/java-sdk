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

package com.ibm.watson.developer_cloud.conversation_helper;

import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;

/**
 * For receiving a response once a request for an action performed in {@link ConversationHelper} has
 * completed.
 *
 * @param <T> Type of response; this is dictated by the method signature in {@link ConversationHelper}.
 */
public interface CompletionHandler<T> {
  /**
   * Called when a network request has completed in {@link ConversationHelper} with either a response or
   * error.
   *
   * @param response Successful response from the associated request.
   * @param e Error from the associated request.
   */
  void onComplete(T response, ServiceResponseException e);
}
