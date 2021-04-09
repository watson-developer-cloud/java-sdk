/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the Webhook model. */
public class WebhookTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testWebhook() throws Throwable {
    WebhookHeader webhookHeaderModel =
        new WebhookHeader.Builder().name("testString").value("testString").build();
    assertEquals(webhookHeaderModel.name(), "testString");
    assertEquals(webhookHeaderModel.value(), "testString");

    Webhook webhookModel =
        new Webhook.Builder()
            .url("testString")
            .name("testString")
            .headers(
                new java.util.ArrayList<WebhookHeader>(java.util.Arrays.asList(webhookHeaderModel)))
            .build();
    assertEquals(webhookModel.url(), "testString");
    assertEquals(webhookModel.name(), "testString");
    assertEquals(
        webhookModel.headers(),
        new java.util.ArrayList<WebhookHeader>(java.util.Arrays.asList(webhookHeaderModel)));

    String json = TestUtilities.serialize(webhookModel);

    Webhook webhookModelNew = TestUtilities.deserialize(json, Webhook.class);
    assertTrue(webhookModelNew instanceof Webhook);
    assertEquals(webhookModelNew.url(), "testString");
    assertEquals(webhookModelNew.name(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testWebhookError() throws Throwable {
    new Webhook.Builder().build();
  }
}
