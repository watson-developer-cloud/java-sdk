/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.conversation.v1_experimental;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Thin wrapper around the Conversation Service REST API.
 *
 * @version v1-experimental
 * @see <a href=
 *      "http://www.ibm.com/watson/developercloud/conversation.html">
 *      Conversation</a>
 * @api.version_date 2016-05-19
 */
public final class ConversationService extends WatsonService {

  /** The Constant VERSION_DATE_2016_05_19. */
  public static final String VERSION_DATE_2016_05_19 = "2016-05-19";
  private static final String URL = "https://gateway.watsonplatform.net/conversation-experimental/api";
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
    if (getEndPoint() == null || getEndPoint().isEmpty())
      setEndPoint(URL);

    Validator.isTrue(versionDate != null && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2016_05_19);
    this.versionDate = versionDate;
  }

  /**
   * Returns an instance of the Conversation Service using the service's default endpoint (URL), username and password.
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
    Validator.isTrue(workspaceId != null && !workspaceId.isEmpty(), "'workspaceId' cannot be null or empty");
    Validator.notNull(request, "'request' cannot be null");
    Validator.isTrue(request.input() != null && !request.input().isEmpty(), "'request.input' cannot be null or empty");

    RequestBuilder builder = RequestBuilder.post(String.format(PATH_MESSAGE, workspaceId));
    builder.query(VERSION_PARAM, this.versionDate);
    builder.bodyJson(GsonSingleton.getGson().toJsonTree(request).getAsJsonObject());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MessageResponse.class));
  }

}
