
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

package com.ibm.watson.developer_cloud.conversation.v1_experimental;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.ConversationResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtils;

import okhttp3.Response;

/**
 * Thin wrapper around the Conversation Service REST API.
 */
public final class Conversation extends WatsonService {
  //An enum to provide easy access to the version names of the Conversation service
  public static enum API_VERSION {
    V2016_01_24("2016_01_24");
    private String version;

    API_VERSION(String value) {
      this.version = value;
    }

    public String value() {
      return this.version;
    }
  }

  // TODO As API updates occur - update this var!
  private static API_VERSION LATEST_VERSION = API_VERSION.V2016_01_24;

  private static final String URL = "https://gateway.watsonplatform.net/conversation/conversation-experimental/api";
  private static final String SERVICE_NAME = "conversation";
  private static final String MESSAGE_PATH = "/v1/workspaces/{id}/message";
  private static final String VERSION_PARAM = "version";
  private final String version;

  /**
   * Returns an instance of the Conversation Service using the service's default endpoint (URL).
   * 
   * @param version Version of the API which is to be invoked by the REST client.
   */
  public Conversation(API_VERSION version) {
    this(version.value());
  }

  /**
   * Returns an instance of the Conversation Service using the service's default endpoint (URL).
   * 
   * @param version Version of the API which is to be invoked by the REST client.
   */
  public Conversation(String version) {
    super(SERVICE_NAME);
    if (getEndPoint() == null)
      setEndPoint(URL);

    if (version != null && !version.isEmpty())
      this.version = version;
    else
      throw new IllegalArgumentException(
          String.format("The version must be specified. %s is the latest version.", LATEST_VERSION.value()));

  }

  /**
   * Sends a message to the service through a {@link ConversationRequest} for the given
   * {@code workspaceId}. This call is blocking and performs networking on the thread it's invoked
   * from.
   *
   * @param workspaceId Workspace ID for the Conversation Service API.
   * @param body Body request parameter containing an embedded message
   *
   * @return Response for the given {@code workspaceId} and {@link ConversationRequest}.
   */

  public ServiceCall<ConversationResponse> message(String workspaceId, ConversationRequest body) {
    if (workspaceId == null || body == null)
      throw new IllegalArgumentException(
          String.format("The %s argument may not be null", workspaceId == null ? "workspaceId" : "body"));
    RequestBuilder builder =
        RequestBuilder.post(MESSAGE_PATH.replace("{id}", workspaceId)).query(VERSION_PARAM, this.version);
    JsonElement json = new Gson().toJsonTree(body, ConversationRequest.class);
    builder.bodyJson(json.getAsJsonObject());
    return createServiceCall(builder.build(), new ResponseConverter<ConversationResponse>() {

      @Override public ConversationResponse convert(Response response) {
        return ResponseUtils.getObject(response, ConversationResponse.class);
      }
    });
  }
}
