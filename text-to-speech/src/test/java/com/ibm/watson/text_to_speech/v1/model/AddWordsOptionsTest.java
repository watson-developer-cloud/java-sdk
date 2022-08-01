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

package com.ibm.watson.text_to_speech.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.text_to_speech.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the AddWordsOptions model. */
public class AddWordsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddWordsOptions() throws Throwable {
    Word wordModel =
        new Word.Builder()
            .word("testString")
            .translation("testString")
            .partOfSpeech("Dosi")
            .build();
    assertEquals(wordModel.word(), "testString");
    assertEquals(wordModel.translation(), "testString");
    assertEquals(wordModel.partOfSpeech(), "Dosi");

    AddWordsOptions addWordsOptionsModel =
        new AddWordsOptions.Builder()
            .customizationId("testString")
            .words(java.util.Arrays.asList(wordModel))
            .build();
    assertEquals(addWordsOptionsModel.customizationId(), "testString");
    assertEquals(addWordsOptionsModel.words(), java.util.Arrays.asList(wordModel));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWordsOptionsError() throws Throwable {
    new AddWordsOptions.Builder().build();
  }
}
