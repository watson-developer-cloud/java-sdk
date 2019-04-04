/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.assistant.v2;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageResponse;
import com.ibm.watson.developer_cloud.assistant.v2.model.SessionResponse;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The IBM Watson&trade; Assistant service combines machine learning, natural language understanding, and integrated
 * dialog tools to create conversation flows between your apps and your users.
 *
 * @version v2
 * @see <a href="http://www.ibm.com/watson/developercloud/assistant.html">Assistant</a>
 * @deprecated For v7.x.x and beyond, the Java SDK will be available at com.ibm.watson:ibm-watson. To get updates,
 * please use this new location. See the SDK GitHub repository for more information:
 * https://github.com/watson-developer-cloud/java-sdk
 */
@Deprecated
public class Assistant extends WatsonService {

  private static final String SERVICE_NAME = "assistant";
  private static final String URL = "https://gateway.watsonplatform.net/assistant/api";

  private String versionDate;

  /**
   * Instantiates a new `Assistant`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public Assistant(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `Assistant` with username and password.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param username the username
   * @param password the password
   */
  public Assistant(String versionDate, String username, String password) {
    this(versionDate);
    setUsernameAndPassword(username, password);
  }

  /**
   * Instantiates a new `Assistant` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param iamOptions the options for authenticating through IAM
   */
  public Assistant(String versionDate, IamOptions iamOptions) {
    this(versionDate);
    setIamCredentials(iamOptions);
  }

  /**
   * Create a session.
   *
   * Create a new session. A session is used to send user input to a skill and receive responses. It also maintains the
   * state of the conversation.
   *
   * @param createSessionOptions the {@link CreateSessionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link SessionResponse}
   */
  public ServiceCall<SessionResponse> createSession(CreateSessionOptions createSessionOptions) {
    Validator.notNull(createSessionOptions, "createSessionOptions cannot be null");
    String[] pathSegments = { "v2/assistants", "sessions" };
    String[] pathParameters = { createSessionOptions.assistantId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=conversation;service_version=v2;operation_id=createSession");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SessionResponse.class));
  }

  /**
   * Delete session.
   *
   * Deletes a session explicitly before it times out.
   *
   * @param deleteSessionOptions the {@link DeleteSessionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteSession(DeleteSessionOptions deleteSessionOptions) {
    Validator.notNull(deleteSessionOptions, "deleteSessionOptions cannot be null");
    String[] pathSegments = { "v2/assistants", "sessions" };
    String[] pathParameters = { deleteSessionOptions.assistantId(), deleteSessionOptions.sessionId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=conversation;service_version=v2;operation_id=deleteSession");
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * Send user input to assistant.
   *
   * Send user input to an assistant and receive a response.
   *
   * There is no rate limit for this operation.
   *
   * @param messageOptions the {@link MessageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link MessageResponse}
   */
  public ServiceCall<MessageResponse> message(MessageOptions messageOptions) {
    Validator.notNull(messageOptions, "messageOptions cannot be null");
    String[] pathSegments = { "v2/assistants", "sessions", "message" };
    String[] pathParameters = { messageOptions.assistantId(), messageOptions.sessionId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=conversation;service_version=v2;operation_id=message");
    final JsonObject contentJson = new JsonObject();
    if (messageOptions.input() != null) {
      contentJson.add("input", GsonSingleton.getGson().toJsonTree(messageOptions.input()));
    }
    if (messageOptions.context() != null) {
      contentJson.add("context", GsonSingleton.getGson().toJsonTree(messageOptions.context()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MessageResponse.class));
  }

}
