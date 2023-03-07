/*
 * (C) Copyright IBM Corp. 2023.
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

/** Unit test class for the OutputData model. */
public class OutputDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testOutputData() throws Throwable {
    DialogNodeVisitedDetails dialogNodeVisitedDetailsModel =
        new DialogNodeVisitedDetails.Builder()
            .dialogNode("testString")
            .title("testString")
            .conditions("testString")
            .build();
    assertEquals(dialogNodeVisitedDetailsModel.dialogNode(), "testString");
    assertEquals(dialogNodeVisitedDetailsModel.title(), "testString");
    assertEquals(dialogNodeVisitedDetailsModel.conditions(), "testString");

    LogMessageSource logMessageSourceModel =
        new LogMessageSource.Builder().type("dialog_node").dialogNode("testString").build();
    assertEquals(logMessageSourceModel.type(), "dialog_node");
    assertEquals(logMessageSourceModel.dialogNode(), "testString");

    LogMessage logMessageModel =
        new LogMessage.Builder()
            .level("info")
            .msg("testString")
            .code("testString")
            .source(logMessageSourceModel)
            .build();
    assertEquals(logMessageModel.level(), "info");
    assertEquals(logMessageModel.msg(), "testString");
    assertEquals(logMessageModel.code(), "testString");
    assertEquals(logMessageModel.source(), logMessageSourceModel);

    ResponseGenericChannel responseGenericChannelModel =
        new ResponseGenericChannel.Builder().channel("chat").build();
    assertEquals(responseGenericChannelModel.channel(), "chat");

    RuntimeResponseGenericRuntimeResponseTypeText runtimeResponseGenericModel =
        new RuntimeResponseGenericRuntimeResponseTypeText.Builder()
            .responseType("text")
            .text("testString")
            .channels(java.util.Arrays.asList(responseGenericChannelModel))
            .build();
    assertEquals(runtimeResponseGenericModel.responseType(), "text");
    assertEquals(runtimeResponseGenericModel.text(), "testString");
    assertEquals(
        runtimeResponseGenericModel.channels(),
        java.util.Arrays.asList(responseGenericChannelModel));

    OutputData outputDataModel =
        new OutputData.Builder()
            .nodesVisited(java.util.Arrays.asList("testString"))
            .nodesVisitedDetails(java.util.Arrays.asList(dialogNodeVisitedDetailsModel))
            .logMessages(java.util.Arrays.asList(logMessageModel))
            .generic(java.util.Arrays.asList(runtimeResponseGenericModel))
            .add("foo", "testString")
            .build();
    assertEquals(outputDataModel.getNodesVisited(), java.util.Arrays.asList("testString"));
    assertEquals(
        outputDataModel.getNodesVisitedDetails(),
        java.util.Arrays.asList(dialogNodeVisitedDetailsModel));
    assertEquals(outputDataModel.getLogMessages(), java.util.Arrays.asList(logMessageModel));
    assertEquals(
        outputDataModel.getGeneric(), java.util.Arrays.asList(runtimeResponseGenericModel));
    assertEquals(outputDataModel.get("foo"), "testString");

    String json = TestUtilities.serialize(outputDataModel);

    OutputData outputDataModelNew = TestUtilities.deserialize(json, OutputData.class);
    assertTrue(outputDataModelNew instanceof OutputData);
    assertEquals(outputDataModelNew.get("foo"), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testOutputDataError() throws Throwable {
    new OutputData.Builder().build();
  }
}
