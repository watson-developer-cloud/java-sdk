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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationData;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.dialog.v1.model.DialogContent;
import com.ibm.watson.developer_cloud.dialog.v1.model.NameValue;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

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

  /** The Constant CLIENT_ID. */
  public static final String CLIENT_ID = "client_id";

  /** The Constant CONVERSATION_ID. */
  public static final String CONVERSATION_ID = "conversation_id";

  /** The Constant DATE_FROM. */
  public static final String DATE_FROM = "date_from";

  /** The Constant DATE_TO. */
  public static final String DATE_TO = "date_to";

  /** The Constant DIALOG_ID. */
  public static final String DIALOG_ID = "dialog_id";

  /** The Constant FILE. */
  private static final String FILE = "file";

  /** The Constant INPUT. */
  public static final String INPUT = "input";

  /** The Constant LIMIT. */
  public static final String LIMIT = "limit";

  /** The list conversation data type. */
  private static final Type listConversationDataType = new TypeToken<List<ConversationData>>() {}
      .getType();

  /** The list dialog content type. */
  private static final Type listDialogContentType = new TypeToken<List<DialogContent>>() {}
      .getType();

  /** The list dialog type. */
  private static final Type listDialogType = new TypeToken<List<Dialog>>() {}.getType();

  /** The list name value type. */
  private static Type listNameValueType = new TypeToken<List<NameValue>>() {}.getType();

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(DialogService.class.getName());

  /** The Constant NAME. */
  private static final String NAME = "name";

  /** The Constant NAME_VALUES. */
  public static final String NAME_VALUES = "name_values";

  /** The Constant OFFSET. */
  public static final String OFFSET = "offset";

  /** The Constant PATH_DIALOGS. */
  private static final String PATH_DIALOGS = "/v1/dialogs";

  /** The Constant sdfDate. */
  private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /** The Constant URL. */
  private static final String URL = "https://gateway.watsonplatform.net/dialog-beta/api";

  /**
   * Instantiates a new Dialog service with the default url.
   */
  public DialogService() {
    super("dialog");
    setEndPoint(URL);
  }

  /**
   * Starts or continue conversations.
   * 
   * @param params the params
   * @return the {@link Conversation} with the response
   */
  public Conversation converse(final Map<String, Object> params) {

    final String dialogId = (String) params.get(DIALOG_ID);
    final String input = (String) params.get(INPUT);
    final Integer clientId = (Integer) params.get(CLIENT_ID);
    final Integer conversationId = (Integer) params.get(CONVERSATION_ID);

    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException("dialog_id cannot be null or empty");

    if (conversationId == null)
      log.info("Creating a new conversation with for dialog: " + dialogId);

    if (clientId == null) {
      log.info("Creating a new client id with for dialog: " + dialogId);
    }

    final String path = String.format("/v1/dialogs/%s/conversation", dialogId);

    final Request request =
        RequestBuilder.post(path)
            .withForm(CONVERSATION_ID, conversationId, CLIENT_ID, clientId, INPUT, input).build();

    return executeRequest(request, Conversation.class);
  }

  /**
   * Starts or continue conversations.
   * 
   * @param dialogId the dialog identifier
   * @return a new {@link Conversation}
   */
  public Conversation createConversation(final String dialogId) {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(DIALOG_ID, dialogId);
    return converse(params);
  }

  /**
   * Creates a dialog.
   * 
   * @param name The dialog name
   * @param dialogFile The dialog file created by using the Dialog service Applet.
   * @return The created dialog
   * @see Dialog
   */
  public Dialog createDialog(final String name, final File dialogFile) {
    if (name == null || name.isEmpty())
      throw new IllegalArgumentException("name cannot be null or empty");

    if (dialogFile == null || !dialogFile.exists())
      throw new IllegalArgumentException("dialogFile cannot be null or empty");

    final RequestBody body =
        new MultipartBuilder()
            .type(MultipartBuilder.FORM)
            .addFormDataPart(FILE, dialogFile.getName(),
                RequestBody.create(HttpMediaType.BINARY_FILE, dialogFile))
            .addFormDataPart(NAME, name).build();

    final Request request = RequestBuilder.post(PATH_DIALOGS).withBody(body).build();

    return executeRequest(request, Dialog.class);
  }

  /**
   * Deletes a dialog.
   * 
   * @param dialogId The dialog identifier
   * @see DialogService
   */
  public void deleteDialog(final String dialogId) {
    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException("dialogId cannot be null or empty");

    final Request request = RequestBuilder.delete("/v1/dialogs/" + dialogId).build();
    executeWithoutResponse(request);
  }

  /**
   * Gets content for nodes.
   * 
   * @param dialogId the dialog identifier
   * @return The {@link DialogContent} for nodes
   */
  public List<DialogContent> getContent(final String dialogId) {
    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException("dialogId cannot be null or empty");

    final Request request = RequestBuilder.get("/v1/dialogs/" + dialogId + "/content").build();

    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    final List<DialogContent> content =
        GsonSingleton.getGson().fromJson(jsonObject.get("items"), listDialogContentType);
    return content;
  }

  /**
   * Returns chat session data dump for a given date rage.
   * 
   * @param params the params
   * @return A list of {@link ConversationData}
   */
  public List<ConversationData> getConversationData(final Map<String, Object> params) {
    final String dialogId = (String) params.get(DIALOG_ID);

    final Date from = (Date) params.get(DATE_FROM);
    final Date to = (Date) params.get(DATE_TO);

    final Integer offset = (Integer) params.get(OFFSET);
    final Integer limit = (Integer) params.get(LIMIT);

    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException(DIALOG_ID + " cannot be null or empty");

    if (from == null)
      throw new IllegalArgumentException(DATE_FROM + " cannot be null");

    if (to == null)
      throw new IllegalArgumentException(DATE_TO + " cannot be null");

    if (from.after(to))
      throw new IllegalArgumentException("'" + DATE_FROM + "' is greater than '" + DATE_TO + "'");

    final String fromString = sdfDate.format(from);
    final String toString = sdfDate.format(to);

    final String path = String.format("/v1/dialogs/%s/conversation", dialogId);

    final RequestBuilder requestBuilder =
        RequestBuilder.get(path).withQuery(DATE_FROM, fromString, DATE_TO, toString);

    if (offset != null)
      requestBuilder.withQuery(OFFSET, offset);
    if (limit != null)
      requestBuilder.withQuery(LIMIT, limit);

    final Request request = requestBuilder.build();

    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    final List<ConversationData> conversationDataList =
        GsonSingleton.getGson().fromJson(jsonObject.get("conversations"), listConversationDataType);
    return conversationDataList;
  }

  /**
   * Retrieves the list of Dialogs for the user.
   * 
   * @return the {@link Dialog} list
   */
  public List<Dialog> getDialogs() {
    final Request request = RequestBuilder.get(PATH_DIALOGS).build();

    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    final List<Dialog> dialogs =
        GsonSingleton.getGson().fromJson(jsonObject.get("dialogs"), listDialogType);
    return dialogs;
  }

  /**
   * Returns a list of name-value pars associated with a client id.
   * 
   * @param dialogId The dialog identifier
   * @param clientId the client id
   * @return the created dialog
   * @see NameValue
   */
  public List<NameValue> getProfile(String dialogId, Integer clientId) {
    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException("dialogId cannot be null or empty");

    if (clientId == null)
      throw new IllegalArgumentException("clientId cannot be null");

    final Request request =
        RequestBuilder.get("/v1/dialogs/" + dialogId + "/profile").withQuery(CLIENT_ID, clientId)
            .build();
    final Response response = execute(request);
    final JsonObject jsonObject = ResponseUtil.getJsonObject(response);
    final List<NameValue> content =
        GsonSingleton.getGson().fromJson(jsonObject.get(NAME_VALUES), listNameValueType);
    return content;
  }

  /**
   * Updates a dialog.
   * 
   * @param dialogId The dialog identifier
   * @param dialogFile The dialog file
   * @return the created dialog
   * @see Dialog
   */
  public Dialog updateDialog(final String dialogId, final File dialogFile) {
    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException("dialogId cannot be null or empty");

    if (dialogFile == null || !dialogFile.exists())
      throw new IllegalArgumentException("dialogFile cannot be null or empty");

    final RequestBody body =
        new MultipartBuilder()
            .type(MultipartBuilder.FORM)
            .addFormDataPart(FILE, dialogFile.getName(),
                RequestBody.create(HttpMediaType.BINARY_FILE, dialogFile)).build();

    final Request request = RequestBuilder.put("/v1/dialogs/" + dialogId).withBody(body).build();

    executeWithoutResponse(request);
    final Dialog dialog = new Dialog().withDialogId(dialogId);
    return dialog;
  }

  /**
   * Updates a dialog profile with a list of {@link NameValue} properties. If clientId is not
   * specified a new clientId is generated. Profile variables are case sensitive.
   * 
   * @param dialogId The dialog identifier
   * @param clientId the client identifier
   * @param nameValues The name value list to update
   * @see Dialog
   */
  public void updateProfile(final String dialogId, final Integer clientId,
      final List<NameValue> nameValues) {
    if (dialogId == null || dialogId.isEmpty())
      throw new IllegalArgumentException("dialogId cannot be null or empty");

    if (clientId == null)
      throw new IllegalArgumentException("clientId cannot be null");

    if (nameValues == null || nameValues.isEmpty())
      throw new IllegalArgumentException("nameValues cannot be null or empty");

    final JsonObject contentJson = new JsonObject();

    contentJson.addProperty(CLIENT_ID, clientId);
    contentJson.add(NAME_VALUES, GsonSingleton.getGson().toJsonTree(nameValues));

    final Request request =
        RequestBuilder.put("/v1/dialogs/" + dialogId + "/profile").withBodyJson(contentJson)
            .build();
    executeWithoutResponse(request);
  }

}
