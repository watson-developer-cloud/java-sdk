/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.watson.speech_to_text.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.speech_to_text.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the TrainLanguageModelOptions model. */
public class TrainLanguageModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTrainLanguageModelOptions() throws Throwable {
    TrainLanguageModelOptions trainLanguageModelOptionsModel =
        new TrainLanguageModelOptions.Builder()
            .customizationId("testString")
            .wordTypeToAdd("all")
            .customizationWeight(Double.valueOf("72.5"))
            .strict(true)
            .force(false)
            .build();
    assertEquals(trainLanguageModelOptionsModel.customizationId(), "testString");
    assertEquals(trainLanguageModelOptionsModel.wordTypeToAdd(), "all");
    assertEquals(trainLanguageModelOptionsModel.customizationWeight(), Double.valueOf("72.5"));
    assertEquals(trainLanguageModelOptionsModel.strict(), Boolean.valueOf(true));
    assertEquals(trainLanguageModelOptionsModel.force(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrainLanguageModelOptionsError() throws Throwable {
    new TrainLanguageModelOptions.Builder().build();
  }
}
