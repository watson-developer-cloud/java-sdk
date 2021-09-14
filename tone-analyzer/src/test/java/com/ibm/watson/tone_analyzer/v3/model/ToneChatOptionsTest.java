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

package com.ibm.watson.tone_analyzer.v3.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.tone_analyzer.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the ToneChatOptions model. */
public class ToneChatOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToneChatOptions() throws Throwable {
    Utterance utteranceModel =
        new Utterance.Builder().text("testString").user("testString").build();
    assertEquals(utteranceModel.text(), "testString");
    assertEquals(utteranceModel.user(), "testString");

    ToneChatOptions toneChatOptionsModel =
        new ToneChatOptions.Builder()
            .utterances(new java.util.ArrayList<Utterance>(java.util.Arrays.asList(utteranceModel)))
            .contentLanguage("en")
            .acceptLanguage("en")
            .build();
    assertEquals(
        toneChatOptionsModel.utterances(),
        new java.util.ArrayList<Utterance>(java.util.Arrays.asList(utteranceModel)));
    assertEquals(toneChatOptionsModel.contentLanguage(), "en");
    assertEquals(toneChatOptionsModel.acceptLanguage(), "en");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testToneChatOptionsError() throws Throwable {
    new ToneChatOptions.Builder().build();
  }
}
