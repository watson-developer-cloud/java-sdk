/**
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
package com.ibm.watson.developer_cloud.dialog.v1;

import java.io.File;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationData;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationDataOptions;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.dialog.v1.model.DialogContent;
import com.ibm.watson.developer_cloud.dialog.v1.model.NameValue;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.ResponseConverter;
import com.ibm.watson.developer_cloud.service.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.ResponseUtils;
import com.ibm.watson.developer_cloud.util.Validator;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * The IBM Watson Dialog service Dialogs enhances application by providing chitchat for topics
 * outside of a corpus and for giving context to a user's questions. You can create various virtual
 * agent (VA) applications. Users can have natural, free-flowing, and human-like conversations with
 * VAs that answer questions, show personality, decide, provide guidance, and even perform tasks.
 * 
 * @version v1
 * @see <a href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/dialog.html">
 *      Dialog</a>
 */
public class DialogService extends WatsonService {

  private static final String CLIENT_ID = "client_id";
  private static final String CONVERSATION_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final String CONVERSATION_ID = "conversation_id";
  private static final String CONVERSATIONS = "conversations";
  private static final String DATE_FROM = "date_from";
  private static final String DATE_TO = "date_to";
  private static final String DIALOGS = "dialogs";
  private static final String FILE = "file";
  private static final Gson gson = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final String INPUT = "input";
  private static final String ITEMS = "items";
  private static final String LIMIT = "limit";
  private static final Type listConversationDataType = new TypeToken<List<ConversationData>>() {}.getType();
  private static final Type listDialogContentType = new TypeToken<List<DialogContent>>() {}.getType();
  private static final Type listDialogType = new TypeToken<List<Dialog>>() {}.getType();
  private static final Type listNameValueType = new TypeToken<List<NameValue>>() {}.getType();
  private static final String NAME = "name";
  private static final String NAME_VALUES = "name_values";
  private static final String OFFSET = "offset";
  private static final String PATH_DIALOG = "/v1/dialogs/%s";
  private static final String PATH_DIALOG_CONTENT = "/v1/dialogs/%s/content";
  private static final String PATH_DIALOG_CONVERSATION = "/v1/dialogs/%s/conversation";
  private static final String PATH_DIALOGS = "/v1/dialogs";
  private static final String PATH_PROFILE = "/v1/dialogs/%s/profile";
  private static final SimpleDateFormat sdfDate = new SimpleDateFormat(CONVERSATION_DATE_FORMAT);
  private static final String SERVICE_NAME = "dialog";
  private static final String URL = "https://gateway.watsonplatform.net/dialog/api";

  /**
   * Instantiates a new Dialog service with the default URL.
   */
  public DialogService() {
    super(SERVICE_NAME);
    setEndPoint(URL);
  }


  /**
   * Starts or continue conversations.
   * 
   * @param conversation the current conversation
   * @param newMessage the new message
   * @return the {@link Conversation} with the response
   */
  public ServiceCall<Conversation> converse(final Conversation conversation, String newMessage) {
    Validator.notNull(conversation, "conversation cannot be null");
    Validator.isTrue(conversation.getDialogId() != null && !conversation.getDialogId().isEmpty(),
        "conversation.dialogId cannot be null or empty");

    final String path = String.format(PATH_DIALOG_CONVERSATION, conversation.getDialogId());

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    requestBuilder.withForm(CONVERSATION_ID, conversation.getId());
    requestBuilder.withForm(CLIENT_ID, conversation.getClientId());
    requestBuilder.withForm(INPUT, newMessage);

    return createServiceCall(requestBuilder.build(), new ResponseConverter<Conversation>() {
      @Override
      public Conversation convert(Response response) {
        Conversation newConversation = ResponseUtils.getObject(response, Conversation.class);
        newConversation.setDialogId(conversation.getDialogId());
        return newConversation;
      }
    });
  }

  /**
   * Starts or continue conversations.
   * 
   * @param dialogId the dialog identifier
   * @return a new {@link Conversation}
   */
  public ServiceCall<Conversation> createConversation(final String dialogId) {
    Conversation conversation = new Conversation();
    conversation.setDialogId(dialogId);
    return converse(conversation, null);
  }

  /**
   * Creates a dialog.
   * 
   * @param name The dialog name
   * @param dialogFile The dialog script file
   * @return The created dialog
   * @see Dialog
   */
  public ServiceCall<Dialog> createDialog(final String name, final File dialogFile) {
    Validator.isTrue(name != null && !name.isEmpty(), "name cannot be null or empty");
    Validator.isTrue(dialogFile != null && dialogFile.exists(), "dialogFile cannot be null or inexistent");

    final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
        .addFormDataPart(FILE, dialogFile.getName(), RequestBody.create(HttpMediaType.BINARY_FILE, dialogFile))
        .addFormDataPart(NAME, name).build();

    final Request request = RequestBuilder.post(PATH_DIALOGS).withBody(body).build();

    return createServiceCall(request, ResponseConverterUtils.getObject(Dialog.class));
  }

  /**
   * Deletes a dialog.
   *
   * @param dialogId The dialog identifier
   * @return the service call
   * @see DialogService
   */
  public ServiceCall<Void> deleteDialog(final String dialogId) {
    Validator.isTrue(dialogId != null && !dialogId.isEmpty(), "dialogId cannot be null or empty");

    final Request request = RequestBuilder.delete(String.format(PATH_DIALOG, dialogId)).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Returns a Map from a {@link NameValue} list.
   * 
   * @param nameValues the {@link NameValue} list
   * @return the map
   */
  private Map<String, String> fromNameValues(List<NameValue> nameValues) {
    final Map<String, String> profile = new HashMap<String, String>();
    for (final NameValue nameValue : nameValues) {
      profile.put(nameValue.getName(), nameValue.getValue());
    }
    return profile;
  }

  /**
   * Gets content for nodes.
   * 
   * @param dialogId the dialog identifier
   * @return The {@link DialogContent} for nodes
   */
  public ServiceCall<List<DialogContent>> getContent(final String dialogId) {
    Validator.isTrue(dialogId != null && !dialogId.isEmpty(), "dialogId cannot be null or empty");

    final Request request = RequestBuilder.get(String.format(PATH_DIALOG_CONTENT, dialogId)).build();
    final ResponseConverter<List<DialogContent>> converter =
        ResponseConverterUtils.getGenericObject(listDialogContentType, ITEMS);
    return createServiceCall(request, converter);
  }

  /**
   * Returns chat session data dump for a given date rage.
   *
   * @param options the options
   * @return A list of {@link ConversationData}
   */
  public ServiceCall<List<ConversationData>> getConversationData(ConversationDataOptions options) {
    Validator.notNull(options, "options cannot be null");
    Validator.isTrue(options.getDialogId() != null && !options.getDialogId().isEmpty(),
        "options.dialogId cannot be null or empty");

    Validator.notNull(options.getFrom(), "options.from cannot be null");
    Validator.notNull(options.getTo(), "options.to cannot be null");

    if (options.getFrom().after(options.getTo()))
      throw new IllegalArgumentException("options.from is greater than options.to");

    final String fromString = sdfDate.format(options.getFrom());
    final String toString = sdfDate.format(options.getTo());

    final String path = String.format(PATH_DIALOG_CONVERSATION, options.getDialogId());

    final RequestBuilder requestBuilder = RequestBuilder.get(path).withQuery(DATE_FROM, fromString, DATE_TO, toString);

    if (options.getOffset() != null)
      requestBuilder.withQuery(OFFSET, options.getOffset());
    if (options.getLimit() != null)
      requestBuilder.withQuery(LIMIT, options.getLimit());

    final Request request = requestBuilder.build();
    ResponseConverter<List<ConversationData>> converter =
        ResponseConverterUtils.getGenericObject(listConversationDataType, CONVERSATIONS);
    return createServiceCall(request, converter);
  }

  /**
   * Retrieves the list of Dialogs for the user.
   * 
   * @return the {@link Dialog} list
   */
  public ServiceCall<List<Dialog>> getDialogs() {
    final Request request = RequestBuilder.get(PATH_DIALOGS).build();

    ResponseConverter<List<Dialog>> converter = ResponseConverterUtils.getGenericObject(listDialogType, DIALOGS);
    return createServiceCall(request, converter);
  }

  /**
   * Returns a list of name-value pars associated with a client id.
   * 
   * @param conversation The current conversation
   * @param names the profile variables to return
   * @return the profile
   */
  public ServiceCall<Map<String, String>> getProfile(final Conversation conversation, String... names) {
    Validator.notNull(conversation, "conversation cannot be null");
    return getProfile(conversation.getDialogId(), conversation.getClientId(), names);
  }

  /**
   * Returns a list of name-value pars associated with a client id.
   * 
   * @param dialogId The dialog identifier
   * @param clientId the client id
   * @param names the profile variables to return
   * @return the profile
   */
  public ServiceCall<Map<String, String>> getProfile(String dialogId, Integer clientId, String... names) {
    Validator.isTrue(dialogId != null && !dialogId.isEmpty(), "dialogId cannot be null or empty");
    Validator.notNull(clientId, "clientId cannot be null");

    final RequestBuilder requestBuilder =
        RequestBuilder.get(String.format(PATH_PROFILE, dialogId)).withQuery(CLIENT_ID, clientId);

    if (names != null) {
      for (final String name : names) {
        requestBuilder.withQuery(NAME, name);
      }
    }

    return createServiceCall(requestBuilder.build(), new ResponseConverter<Map<String, String>>() {
      @Override
      public Map<String, String> convert(Response response) {
        JsonObject jsonObject = ResponseUtils.getJsonObject(response);
        final List<NameValue> nameValues = gson.fromJson(jsonObject.get(NAME_VALUES), listNameValueType);
        return fromNameValues(nameValues);
      }
    });
  }


  /**
   * Converts the profile map into a {@link NameValue} list.
   * 
   * @param profile the profile
   * @return the {@link NameValue} list.
   */
  private List<NameValue> toNameValue(Map<String, String> profile) {
    final List<NameValue> nameValues = new ArrayList<NameValue>();
    for (final String key : profile.keySet()) {
      nameValues.add(new NameValue(key, profile.get(key)));
    }
    return nameValues;
  }

  /**
   * Updates an existing {@link Dialog}.
   *
   * @param dialogId The dialog identifier
   * @param dialogFile The dialog file
   * @return the service call
   * @see Dialog
   */
  public ServiceCall<Void> updateDialog(final String dialogId, final File dialogFile) {
    Validator.isTrue(dialogId != null && !dialogId.isEmpty(), "dialogId cannot be null or empty");
    Validator.isTrue(dialogFile != null && dialogFile.exists(), "dialogFile cannot be null or inexistent");

    final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
        .addFormDataPart(FILE, dialogFile.getName(), RequestBody.create(HttpMediaType.BINARY_FILE, dialogFile)).build();

    final Request request = RequestBuilder.put(String.format(PATH_DIALOG, dialogId)).withBody(body).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

  /**
   * Updates a profile with a Map of key-value variables.<br>
   * Profile variables are case sensitive.
   *
   * @param conversation the conversation
   * @param profile the profile
   * @return the service call
   */
  public ServiceCall<Void> updateProfile(final Conversation conversation, final Map<String, String> profile) {
    Validator.notNull(conversation, "conversation cannot be null");

    return updateProfile(conversation.getDialogId(), conversation.getClientId(), profile);
  }

  /**
   * Updates a dialog profile with a profile.<br>
   * Profile variables are case sensitive.
   *
   * @param dialogId The dialog identifier
   * @param clientId the client identifier
   * @param profile the profile variables
   * @return the service call
   */
  public ServiceCall<Void> updateProfile(final String dialogId, final Integer clientId,
      final Map<String, String> profile) {
    Validator.isTrue(dialogId != null && !dialogId.isEmpty(), "dialogId cannot be null or empty");
    Validator.isTrue(profile != null && !profile.isEmpty(), "profile cannot be null or empty");

    final JsonObject contentJson = new JsonObject();
    if (clientId != null)
      contentJson.addProperty(CLIENT_ID, clientId);

    contentJson.add(NAME_VALUES, gson.toJsonTree(toNameValue(profile)));

    final Request request = RequestBuilder.put(String.format(PATH_PROFILE, dialogId)).withBodyJson(contentJson).build();
    return createServiceCall(request, ResponseConverterUtils.getVoid());
  }

}
