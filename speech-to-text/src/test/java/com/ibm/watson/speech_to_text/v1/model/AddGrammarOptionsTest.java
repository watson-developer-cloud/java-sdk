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

package com.ibm.watson.speech_to_text.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.speech_to_text.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the AddGrammarOptions model. */
public class AddGrammarOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddGrammarOptions() throws Throwable {
    AddGrammarOptions addGrammarOptionsModel =
        new AddGrammarOptions.Builder()
            .customizationId("testString")
            .grammarName("testString")
            .grammarFile(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/srgs")
            .allowOverwrite(false)
            .build();
    assertEquals(addGrammarOptionsModel.customizationId(), "testString");
    assertEquals(addGrammarOptionsModel.grammarName(), "testString");
    assertEquals(
        IOUtils.toString(addGrammarOptionsModel.grammarFile()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(addGrammarOptionsModel.contentType(), "application/srgs");
    assertEquals(addGrammarOptionsModel.allowOverwrite(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddGrammarOptionsError() throws Throwable {
    new AddGrammarOptions.Builder().build();
  }
}
