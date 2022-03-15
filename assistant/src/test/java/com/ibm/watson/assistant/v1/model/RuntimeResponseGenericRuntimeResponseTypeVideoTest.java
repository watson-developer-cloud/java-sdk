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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeVideo model. */
public class RuntimeResponseGenericRuntimeResponseTypeVideoTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeVideo() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeVideo
        runtimeResponseGenericRuntimeResponseTypeVideoModel =
            new RuntimeResponseGenericRuntimeResponseTypeVideo.Builder()
                .responseType("video")
                .source("testString")
                .title("testString")
                .description("testString")
                .channels(
                    new java.util.ArrayList<ResponseGenericChannel>(
                        java.util.Arrays.asList(responseGenericChannelModel)))
                .channelOptions(
                    new java.util.HashMap<String, Object>() {
                      {
                        put("foo", "testString");
                      }
                    })
                .altText("testString")
                .build();
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModel.responseType(), "video");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModel.source(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModel.title(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModel.description(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeVideoModel.channels(),
        new java.util.ArrayList<ResponseGenericChannel>(
            java.util.Arrays.asList(responseGenericChannelModel)));
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeVideoModel.channelOptions(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModel.altText(), "testString");

    String json = TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeVideoModel);

    RuntimeResponseGenericRuntimeResponseTypeVideo
        runtimeResponseGenericRuntimeResponseTypeVideoModelNew =
            TestUtilities.deserialize(json, RuntimeResponseGenericRuntimeResponseTypeVideo.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeVideoModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeVideo);
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModelNew.responseType(), "video");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModelNew.source(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModelNew.title(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeVideoModelNew.description(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeVideoModelNew.channelOptions().toString(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        }.toString());
    assertEquals(runtimeResponseGenericRuntimeResponseTypeVideoModelNew.altText(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeVideoError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeVideo.Builder().build();
  }
}
