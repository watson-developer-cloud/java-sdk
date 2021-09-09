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
import org.testng.annotations.Test;

/** Unit test class for the CreateLanguageModelOptions model. */
public class CreateLanguageModelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateLanguageModelOptions() throws Throwable {
    CreateLanguageModelOptions createLanguageModelOptionsModel =
        new CreateLanguageModelOptions.Builder()
            .name("testString")
            .baseModelName("ar-MS_Telephony")
            .dialect("testString")
            .description("testString")
            .build();
    assertEquals(createLanguageModelOptionsModel.name(), "testString");
    assertEquals(createLanguageModelOptionsModel.baseModelName(), "ar-MS_Telephony");
    assertEquals(createLanguageModelOptionsModel.dialect(), "testString");
    assertEquals(createLanguageModelOptionsModel.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateLanguageModelOptionsError() throws Throwable {
    new CreateLanguageModelOptions.Builder().build();
  }
}
