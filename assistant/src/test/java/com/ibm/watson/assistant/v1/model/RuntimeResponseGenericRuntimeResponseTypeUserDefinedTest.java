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

/** Unit test class for the RuntimeResponseGenericRuntimeResponseTypeUserDefined model. */
public class RuntimeResponseGenericRuntimeResponseTypeUserDefinedTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeResponseGenericRuntimeResponseTypeUserDefined() throws Throwable {
    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeUserDefined
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModel =
            new RuntimeResponseGenericRuntimeResponseTypeUserDefined.Builder()
                .responseType("user_defined")
                .userDefined(
                    new java.util.HashMap<String, Object>() {
                      {
                        put("foo", "testString");
                      }
                    })
                .channels(
                    new java.util.ArrayList<ResponseGenericChannel>(
                        java.util.Arrays.asList(responseGenericChannelModel)))
                .build();
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModel.responseType(), "user_defined");
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModel.userDefined(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModel.channels(),
        new java.util.ArrayList<ResponseGenericChannel>(
            java.util.Arrays.asList(responseGenericChannelModel)));

    String json =
        TestUtilities.serialize(runtimeResponseGenericRuntimeResponseTypeUserDefinedModel);

    RuntimeResponseGenericRuntimeResponseTypeUserDefined
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModelNew =
            TestUtilities.deserialize(
                json, RuntimeResponseGenericRuntimeResponseTypeUserDefined.class);
    assertTrue(
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModelNew
            instanceof RuntimeResponseGenericRuntimeResponseTypeUserDefined);
    assertEquals(
        runtimeResponseGenericRuntimeResponseTypeUserDefinedModelNew.responseType(),
        "user_defined");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuntimeResponseGenericRuntimeResponseTypeUserDefinedError() throws Throwable {
    new RuntimeResponseGenericRuntimeResponseTypeUserDefined.Builder().build();
  }
}
