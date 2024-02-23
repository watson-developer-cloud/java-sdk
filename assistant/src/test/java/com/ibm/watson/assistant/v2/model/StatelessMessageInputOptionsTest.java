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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the StatelessMessageInputOptions model. */
public class StatelessMessageInputOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testStatelessMessageInputOptions() throws Throwable {
    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();
    assertEquals(messageInputOptionsSpellingModel.suggestions(), Boolean.valueOf(true));
    assertEquals(messageInputOptionsSpellingModel.autoCorrect(), Boolean.valueOf(true));

    StatelessMessageInputOptions statelessMessageInputOptionsModel =
        new StatelessMessageInputOptions.Builder()
            .restart(false)
            .alternateIntents(false)
            .asyncCallout(false)
            .spelling(messageInputOptionsSpellingModel)
            .debug(false)
            .build();
    assertEquals(statelessMessageInputOptionsModel.restart(), Boolean.valueOf(false));
    assertEquals(statelessMessageInputOptionsModel.alternateIntents(), Boolean.valueOf(false));
    assertEquals(statelessMessageInputOptionsModel.asyncCallout(), Boolean.valueOf(false));
    assertEquals(statelessMessageInputOptionsModel.spelling(), messageInputOptionsSpellingModel);
    assertEquals(statelessMessageInputOptionsModel.debug(), Boolean.valueOf(false));

    String json = TestUtilities.serialize(statelessMessageInputOptionsModel);

    StatelessMessageInputOptions statelessMessageInputOptionsModelNew =
        TestUtilities.deserialize(json, StatelessMessageInputOptions.class);
    assertTrue(statelessMessageInputOptionsModelNew instanceof StatelessMessageInputOptions);
    assertEquals(statelessMessageInputOptionsModelNew.restart(), Boolean.valueOf(false));
    assertEquals(statelessMessageInputOptionsModelNew.alternateIntents(), Boolean.valueOf(false));
    assertEquals(statelessMessageInputOptionsModelNew.asyncCallout(), Boolean.valueOf(false));
    assertEquals(
        statelessMessageInputOptionsModelNew.spelling().toString(),
        messageInputOptionsSpellingModel.toString());
    assertEquals(statelessMessageInputOptionsModelNew.debug(), Boolean.valueOf(false));
  }
}
