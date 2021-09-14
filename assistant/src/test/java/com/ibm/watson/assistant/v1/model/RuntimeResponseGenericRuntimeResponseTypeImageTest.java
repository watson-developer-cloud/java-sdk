/*
 * (C) Copyright IBM Corp. 2020, 2021.
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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeImage model. */
public class RuntimeResponseGenericRuntimeResponseTypeImageTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeImage() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeImage
        runtimeResponseGenericRuntimeResponseTypeImageModel =
            new RuntimeResponseGenericRuntimeResponseTypeImage.Builder()
                .responseType("image")
                .source("testString")
                .title("testString")
                .description("testString")
                .channels(
                    new java.util.ArrayList<ResponseGenericChannel>(
                        java.util.Arrays.asList(responseGenericChannelModel)))
                .altText("testString")
                .build();
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModel.responseType(), "image");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModel.source(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModel.title(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModel.description(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeImageModel.channels(),
        new java.util.ArrayList<ResponseGenericChannel>(
            java.util.Arrays.asList(responseGenericChannelModel)));
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModel.altText(), "testString");

    String json = TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeImageModel);

    RuntimeResponseGenericRuntimeResponseTypeImage
        runtimeResponseGenericRuntimeResponseTypeImageModelNew =
            TestUtilities.deserialize(json, RuntimeResponseGenericRuntimeResponseTypeImage.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeImageModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeImage);
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModelNew.responseType(), "image");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModelNew.source(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModelNew.title(), "testString");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeImageModelNew.description(), "testString");
    assertEquals(runtimeResponseGenericRuntimeResponseTypeImageModelNew.altText(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeImageError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeImage.Builder().build();
  }
}
