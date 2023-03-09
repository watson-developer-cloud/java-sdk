/*
 * (C) Copyright IBM Corp. 2022, 2023.
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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeAudio model. */
public class RuntimeResponseGenericRuntimeResponseTypeAudioTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeAudio() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeAudio
        runtimeResponseGenericRuntimeResponseTypeAudioModel =
            new RuntimeResponseGenericRuntimeResponseTypeAudio.Builder()
                .responseType("audio")
                .source("testString")
                .title("testString")
                .description("testString")
                .channels(java.util.Arrays.asList(responseGenericChannelModel))
                .channelOptions(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .altText("testString")
                .build();
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModel.responseType(), "audio");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModel.source(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModel.title(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModel.description(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeAudioModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeAudioModel.channelOptions(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModel.altText(), "testString");

    String json = TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeAudioModel);

    RuntimeResponseGenericRuntimeResponseTypeAudio
        runtimeResponseGenericRuntimeResponseTypeAudioModelNew =
            TestUtilities.deserialize(json, RuntimeResponseGenericRuntimeResponseTypeAudio.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeAudioModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeAudio);
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModelNew.responseType(), "audio");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModelNew.source(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModelNew.title(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeAudioModelNew.description(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeAudioModelNew.channelOptions().toString(),
        java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    assertEquals(runtimeResponseGenericRuntimeResponseTypeAudioModelNew.altText(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeAudioError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeAudio.Builder().build();
  }
}
