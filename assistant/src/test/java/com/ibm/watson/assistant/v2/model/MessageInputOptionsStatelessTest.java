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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the MessageInputOptionsStateless model. */
public class MessageInputOptionsStatelessTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageInputOptionsStateless() throws Throwable {
    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();
    assertEquals(messageInputOptionsSpellingModel.suggestions(), Boolean.valueOf(true));
    assertEquals(messageInputOptionsSpellingModel.autoCorrect(), Boolean.valueOf(true));

    MessageInputOptionsStateless messageInputOptionsStatelessModel =
        new MessageInputOptionsStateless.Builder()
            .restart(false)
            .alternateIntents(false)
            .spelling(messageInputOptionsSpellingModel)
            .debug(false)
            .build();
    assertEquals(messageInputOptionsStatelessModel.restart(), Boolean.valueOf(false));
    assertEquals(messageInputOptionsStatelessModel.alternateIntents(), Boolean.valueOf(false));
    assertEquals(messageInputOptionsStatelessModel.spelling(), messageInputOptionsSpellingModel);
    assertEquals(messageInputOptionsStatelessModel.debug(), Boolean.valueOf(false));

    String json = TestUtilities.serialize(messageInputOptionsStatelessModel);

    MessageInputOptionsStateless messageInputOptionsStatelessModelNew =
        TestUtilities.deserialize(json, MessageInputOptionsStateless.class);
    assertTrue(messageInputOptionsStatelessModelNew instanceof MessageInputOptionsStateless);
    assertEquals(messageInputOptionsStatelessModelNew.restart(), Boolean.valueOf(false));
    assertEquals(messageInputOptionsStatelessModelNew.alternateIntents(), Boolean.valueOf(false));
    assertEquals(
        messageInputOptionsStatelessModelNew.spelling().toString(),
        messageInputOptionsSpellingModel.toString());
    assertEquals(messageInputOptionsStatelessModelNew.debug(), Boolean.valueOf(false));
  }
}
