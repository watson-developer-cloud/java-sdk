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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.dialog.v1.model.DialogContent;
import com.ibm.watson.developer_cloud.dialog.v1.model.NameValue;

/**
 * The Class DialogServiceTest.
 */
public class DialogServiceIntegrationTest extends WatsonServiceTest {

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
    service = new DialogService();
    service.setUsernameAndPassword(getValidProperty("dialog.username"),
        getValidProperty("dialog.password"));
    service.setEndPoint(getValidProperty("dialog.url"));

    dialogId = getValidProperty("dialog.dialog_id");
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
    Conversation c = service.createConversation(dialogId);
    testConversation(c);

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(DialogService.DIALOG_ID, dialogId);
    params.put(DialogService.CLIENT_ID, c.getClientId());
    params.put(DialogService.CONVERSATION_ID, c.getId());
    params.put(DialogService.INPUT, "large");
    c = service.converse(params);
    testConversation(c);

    params.put(DialogService.INPUT, "onions, pepperoni, cheese");
    c = service.converse(params);
    Thread.sleep(500);
    params.put(DialogService.INPUT, "pickup");
    c = service.converse(params);
    Thread.sleep(500);
    params.put(DialogService.INPUT, "yes");
    c = service.converse(params);

    final List<DialogContent> dialogContent = service.getContent(dialogId);
    assertNotNull(dialogContent);
    assertFalse(dialogContent.isEmpty());
    assertNotNull(dialogContent.get(0));

    final List<NameValue> profile = service.getProfile(dialogId, c.getClientId());
    profile.get(0).setValue("foo");
    service.updateProfile(dialogId, c.getClientId(), profile);
  }

  /**
   * Test converse with nulls.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConverseWithNulls() {
    final Map<String, Object> params = new HashMap<String, Object>();
    service.converse(params);
  }

  /**
   * Test create conversation with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateConversationWithNull() {
    service.createConversation(null);
  }


  /**
   * Test create, update and delete dialogs.
   * 
   * @throws URISyntaxException the URI syntax exception
   */
  @Test
  public void testCreateDialog() throws URISyntaxException {
    final File dialogFile = new File("src/test/resources/pizza_sample.xml");
    final String dialogName = "" + UUID.randomUUID().toString().substring(0, 15);
    Dialog newDialog = service.createDialog(dialogName, dialogFile);

    assertNotNull(newDialog.getId());
    newDialog = service.updateDialog(newDialog.getId(), dialogFile);
    assertNotNull(newDialog.getId());
    service.deleteDialog(newDialog.getId());
  }

  /**
   * Test create dialog with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateDialogWithNull() {
    service.createDialog(null, null);
  }

  /**
   * Test delete dialog with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteDialogWithNull() {
    service.deleteDialog(null);
  }

  /**
   * Test get content with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetContentWithNull() {
    service.getContent(null);
  }

  /**
   * Test get conversation data.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetConversationData() {
    final Map<String, Object> params = new HashMap<String, Object>();
    service.getConversationData(params);
  }

  /**
   * Test get dialogs.
   */
  @Test
  public void testGetDialogs() {
    final List<Dialog> dialogs = service.getDialogs();
    assertNotNull(dialogs);
    assertFalse(dialogs.isEmpty());
  }

  /**
   * Test get profile.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetProfile() {
    service.getProfile(null, null);
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
