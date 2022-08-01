/*
 * (C) Copyright IBM Corp. 2022.
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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeText model. */
public class RuntimeResponseGenericRuntimeResponseTypeTextTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeText() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeText
        runtimeResponseGenericRuntimeResponseTypeTextModel =
            new RuntimeResponseGenericRuntimeResponseTypeText.Builder()
                .responseType("text")
                .text("testString")
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .build();
    assertEquals(runtimeResponseGenericRuntimeResponseTypeTextModel.responseType(), "text");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeTextModel.text(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeTextModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    String json = TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeTextModel);

    RuntimeResponseGenericRuntimeResponseTypeText
        runtimeResponseGenericRuntimeResponseTypeTextModelNew =
            TestUtilities.deserialize(json, RuntimeResponseGenericRuntimeResponseTypeText.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeTextModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeText);
    assertEquals(runtimeResponseGenericRuntimeResponseTypeTextModelNew.responseType(), "text");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeTextModelNew.text(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeTextError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeText.Builder().build();
  }
}
