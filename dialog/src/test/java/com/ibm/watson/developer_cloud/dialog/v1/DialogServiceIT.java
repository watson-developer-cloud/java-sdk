/**
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
package com.ibm.watson.developer_cloud.dialog.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationData;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationDataOptions;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.dialog.v1.model.DialogContent;

/**
 * The Class DialogServiceTest.
 */
public class DialogServiceIT extends WatsonServiceTest {

  private static final String DIALOG_FILE_SAMPLE = "src/test/resources/dialog/pizza_sample.xml";

  /** The dialog id. */
  private String dialogId;

  /** The service. */
  private DialogService service;


  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("dialog.username");
    String password = getProperty("dialog.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new DialogService();
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("dialog.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    dialogId = getProperty("dialog.dialog_id");
  }

  /**
   * Test conversation.
   *
   * @param c the c
   */
  private void testConversation(Conversation c) {
    assertNotNull(c);
    assertNotNull(c.getClientId());
    assertNotNull(c.getId());
    assertNotNull(c.getResponse());
    assertFalse(c.getResponse().isEmpty());
  }

  /**
   * Test create conversation.
   *
   * @throws ParseException the parse exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testConverseAndGetConversationData() throws ParseException, InterruptedException {
    Conversation c = service.createConversation(dialogId).execute();
    testConversation(c);
    final String[] messages = new String[] { "large", "onions, pepperoni, cheese", "pickup", "yes" };
    for (final String message : messages) {
      c = service.converse(c, message).execute();
      testConversation(c);
      Thread.sleep(500);
    }

    final List<DialogContent> dialogContent = service.getContent(dialogId).execute();
    assertNotNull(dialogContent);
    assertFalse(dialogContent.isEmpty());
    assertNotNull(dialogContent.get(0));

    Map<String, String> profile = service.getProfile(dialogId, c.getClientId()).execute();

    // update profile
    String variable = profile.keySet().iterator().next();
    profile.put(variable, "foo");
    service.updateProfile(dialogId, c.getClientId(), profile).execute();

    assertEquals(service.getProfile(dialogId, c.getClientId()).execute().get(variable), "foo");
    assertEquals(service.getProfile(dialogId, c.getClientId(), variable).execute().get(variable), "foo");

    ConversationDataOptions options = new ConversationDataOptions.Builder().from(DateUtils.addDays(new Date(), -10))
        .to(DateUtils.addDays(new Date(), 1)).dialogId(dialogId).offset(0).limit(10).build();

    List<ConversationData> data = service.getConversationData(options).execute();
    assertNotNull(data);
    assertFalse(data.isEmpty());
  }


  /**
   * Test get content.
   */
  @Test
  public void testGetContent() {
    List<DialogContent> content = service.getContent(dialogId).execute();
    assertNotNull(content);
  }

  /**
   * Test profile variable encoding.
   */
  @Test
  @Ignore
  public void testProfileVariableEncoding() {
    String variable = "size", value = "Germán";

    // start a conversation
    Conversation c = service.createConversation(dialogId).execute();

    // update profile with a non-ascii value
    Map<String, String> profile = new HashMap<String, String>();
    profile.put(variable, value);
    service.updateProfile(dialogId, c.getClientId(), profile);

    // verify that value is equal to the one in the profile
    profile = service.getProfile(c, variable).execute();
    assertEquals(profile.get(variable), value);
  }

  /**
   * Test converse with nulls.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConverseWithNulls() {
    service.converse(null, null).execute();
  }

  /**
   * Test create conversation with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateConversationWithNull() {
    service.createConversation(null).execute();
  }


  /**
   * Test create, update and delete dialogs.
   *
   * @throws URISyntaxException the URI syntax exception
   */
  @Test
  public void testCreateDialog() throws URISyntaxException {
    final File dialogFile = new File(DIALOG_FILE_SAMPLE);
    final String dialogName = "" + UUID.randomUUID().toString().substring(0, 15);
    Dialog newDialog = service.createDialog(dialogName, dialogFile).execute();

    try {
      assertNotNull(newDialog.getId());
      service.updateDialog(newDialog.getId(), dialogFile).execute();
    } finally {
      service.deleteDialog(newDialog.getId()).execute();
    }
  }

  /**
   * Test create dialog with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateDialogWithNull() {
    service.createDialog(null, null).execute();
  }

  /**
   * Test delete dialog with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteDialogWithNull() {
    service.deleteDialog(null).execute();
  }

  /**
   * Test get content with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetContentWithNull() {
    service.getContent(null).execute();
  }

  /**
   * Test get conversation data.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetConversationData() {
    service.getConversationData(null).execute();
  }

  /**
   * Test get dialogs.
   */
  @Test
  public void testGetDialogs() {
    final List<Dialog> dialogs = service.getDialogs().execute();
    assertNotNull(dialogs);
    assertFalse(dialogs.isEmpty());
  }

  /**
   * Test get profile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetProfile() {
    service.getProfile(null).execute();
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertNotNull(service.toString());
  }

  /**
   * Test update dialog.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateDialog() {
    service.updateDialog(null, null);
  }

  /**
   * Test update profile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateProfile() {
    service.updateProfile(null, null, null);
  }
}
