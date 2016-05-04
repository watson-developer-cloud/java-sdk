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

package com.ibm.watson.developer_cloud.conversation.v1;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.ibm.watson.developer_cloud.conversation.v1.model.ConversationRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.ConversationResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtils;

import okhttp3.Response;

/**
 * Thin wrapper around the Dialog v2 Service REST API.
 */
public final class ConversationService extends WatsonService{
  private static final String URL = "https://gateway.watsonplatform.net/conversation/conversation-experimental/api";
  private static final String SERVICE_NAME = "conversation";
  private final static String MESSAGE_PATH = "/v1/workspaces/{id}/message";

  /**
   * Returns an instance of the Dialog v2 Service using the service's default endpoint (URL).
   */
  public ConversationService() {
	  super(SERVICE_NAME);
    setEndPoint(URL);
  }

  /**
   * Sends a message to the service through a {@link ConversationRequest} for the given
   * {@code workspaceId}. This call is blocking and performs networking on the thread it's invoked
   * from.
   *
   * @param workspaceId Workspace ID for the Dialogs v2 Service API.
   * @param body Body request parameter containing an embedded message
   *
   * @return Response for the given {@code workspaceId} and {@link ConversationRequest}.
   */
  public ServiceCall<ConversationResponse> message(String workspaceId, ConversationRequest body) {
		  RequestBuilder builder = RequestBuilder.post(MESSAGE_PATH.replace("{id}", workspaceId));
		  JsonElement  json = new Gson().toJsonTree(body, ConversationRequest.class);
		  builder.bodyJson(json.getAsJsonObject());
		  return createServiceCall(builder.build(), new ResponseConverter<ConversationResponse>() {

			@Override
			public ConversationResponse convert(Response response) {
				return ResponseUtils.getObject(response, ConversationResponse.class);
			}
		});

	  
  }
}
