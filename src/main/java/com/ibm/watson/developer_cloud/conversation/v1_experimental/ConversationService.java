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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.Message;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.NewMessageOptions;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Thin wrapper around the Conversation Service REST API.
 */
public final class ConversationService extends WatsonService {

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
    if (getEndPoint() == null)
      setEndPoint(URL);

    Validator.isTrue(versionDate != null && !versionDate.isEmpty(),
        "'version cannot be null. Use " + VERSION_DATE_2016_05_19);
    this.versionDate = versionDate;
  }

  /**
   * Sends a message to the service through a {@link NewMessageOptions}.
   *
   * @return The response for the given message.
   */
  public ServiceCall<Message> message(NewMessageOptions options) {
    Validator.notNull(options, "'options' cannot be null");
    
    RequestBuilder builder = RequestBuilder.post(String.format(PATH_MESSAGE, options.workspaceId()));
    builder.query(VERSION_PARAM, this.versionDate);
    builder.bodyJson(getMessageAsJson(options));
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Message.class));
  }

  /**
   * Gets the message as json.
   *
   * @param options the options
   * @return the message as json
   */
  private JsonObject getMessageAsJson(NewMessageOptions options) {
    JsonObject json = new JsonObject();
    
    JsonObject input = new JsonObject();
    input.addProperty("text", options.inputText() != null ? options.inputText() : "");
    
    json.add("input", input);
    if (options.context() != null) {
      json.add("context", new Gson().toJsonTree(options.context()));
    }
    return json;
  }
}
