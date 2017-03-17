/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Thin wrapper around the Conversation Service REST API.
 *
 * @version v1
 * @see <a href= "http://www.ibm.com/watson/developercloud/conversation.html"> Conversation</a>
 */
public final class ConversationService extends WatsonService {

  /** The Constant VERSION_DATE_2017-02-03. */
  public static final String VERSION_DATE_2017_02_03 = "2017-02-03";
  /** The Constant VERSION_DATE_2016-09-20. */
  public static final String VERSION_DATE_2016_09_20 = "2016-09-20";
  /** The Constant VERSION_DATE_2016-07-11. */
  public static final String VERSION_DATE_2016_07_11 = "2016-07-11";
  private static final String URL = "https://gateway.watsonplatform.net/conversation/api";
  private static final String SERVICE_NAME = "conversation";
  private static final String PATH_MESSAGE = "/v1/workspaces/%s/message";
  private static final String VERSION_PARAM = "version";
  private final String versionDate;


  /**
   * Returns an instance of the Conversation Service using the service's default endpoint (URL).
   *
   * @param versionDate Version of the API which is to be invoked by the REST client.
   */
  public ConversationService(final String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2017_02_03);
    this.versionDate = versionDate;
  }

  /**
   * Returns an instance of the Conversation Service using the service's default endpoint (URL), username and password.
   *
   * @param versionDate Version of the API which is to be invoked by the REST client.
   * @param username the username
   * @param password the password
   */
  public ConversationService(final String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Sends a message to the service through a {@link MessageRequest}.
   *
   * @param workspaceId the workspace id
   * @param request the request
   * @return The response for the given message.
   */
  public ServiceCall<MessageResponse> message(String workspaceId, MessageRequest request) {
    Validator.isTrue((workspaceId != null) && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.post(String.format(PATH_MESSAGE, workspaceId));
    builder.query(VERSION_PARAM, versionDate);
    if (request != null) {
      builder.bodyJson(GsonSingleton.getGson().toJsonTree(request).getAsJsonObject());
    } else {
      builder.bodyJson(new JsonObject());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MessageResponse.class));
  }

}
