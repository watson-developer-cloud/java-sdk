/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.dialog.v1;

import java.io.File;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
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
public class DialogServiceTest extends WatsonServiceTest {

	/** The service. */
	private DialogService service;
	
	/** The dialog id. */
	private String dialogId;

	
	/* (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new DialogService();
		service.setUsernameAndPassword(
				prop.getProperty("dialog.username"),
				prop.getProperty("dialog.password"));
		service.setEndPoint(prop.getProperty("dialog.url"));

		dialogId = prop.getProperty("dialog.dialog_id");
	}

	/**
	 * Test create conversation.
	 *
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testConverseAndGetConversationData() throws ParseException {
		Conversation c = service.createConversation(dialogId);
		testConversation(c);

		Map<String, Object> params = new HashMap<String,Object>();
		params.put(DialogService.DIALOG_ID, dialogId);
		params.put(DialogService.CLIENT_ID, c.getClientId());
		params.put(DialogService.CONVERSATION_ID, c.getId());
		params.put(DialogService.INPUT, "large");
		c = service.converse(params);
		testConversation(c);
		
		params.put(DialogService.INPUT, "onions, pepperoni, cheese");
		c = service.converse(params);
		
		params.put(DialogService.INPUT, "pickup");
		c = service.converse(params);
		
		params.put(DialogService.INPUT, "yes");
		c = service.converse(params);
				
		List<DialogContent> dialogContent = service.getContent(dialogId);
		Assert.assertNotNull(dialogContent);
		Assert.assertFalse(dialogContent.isEmpty());
		Assert.assertNotNull(dialogContent.get(0));

		List<NameValue> profile = service.getProfile(dialogId, c.getClientId());
		profile.get(0).setValue("foo");
		service.updateProfile(dialogId, c.getClientId(), profile);
	}

	/**
	 * Test conversation.
	 *
	 * @param c the c
	 */
	private void testConversation(Conversation c) {
		Assert.assertNotNull(c);
		Assert.assertNotNull(c.getClientId());
		Assert.assertNotNull(c.getId());
		Assert.assertNotNull(c.getResponse());
		Assert.assertFalse(c.getResponse().isEmpty());
	}
	
	/**
	 * Test get dialogs.
	 */
	@Test
	public void testGetDialogs(){
		List<Dialog> dialogs = service.getDialogs();
		Assert.assertNotNull(dialogs);
		Assert.assertFalse(dialogs.isEmpty());
	}

	/**
	 * Test create, update and delete dialogs.
	 *
	 * @throws URISyntaxException the URI syntax exception
	 */
	@Test
	public void testCreateDialog() throws URISyntaxException {
		File dialogFile = new File("src/test/resources/pizza_sample.xml");
		String dialogName = ""+UUID.randomUUID().toString().substring(0, 15);
		Dialog newDialog = service.createDialog(dialogName, dialogFile);
		System.out.println(newDialog);
		Assert.assertNotNull(newDialog.getId());
		newDialog = service.updateDialog(newDialog.getId(), dialogFile);
		Assert.assertNotNull(newDialog.getId());
		service.deleteDialog(newDialog.getId());
	}
}
