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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the MessageInputStateless model. */
public class MessageInputStatelessTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageInputStateless() throws Throwable {
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder().intent("testString").confidence(Double.valueOf("72.5")).build();
    assertEquals(runtimeIntentModel.intent(), "testString");
    assertEquals(runtimeIntentModel.confidence(), Double.valueOf("72.5"));

    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .build();
    assertEquals(captureGroupModel.group(), "testString");
    assertEquals(
        captureGroupModel.location(),
        new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))));

    RuntimeEntityInterpretation runtimeEntityInterpretationModel =
        new RuntimeEntityInterpretation.Builder()
            .calendarType("testString")
            .datetimeLink("testString")
            .festival("testString")
            .granularity("day")
            .rangeLink("testString")
            .rangeModifier("testString")
            .relativeDay(Double.valueOf("72.5"))
            .relativeMonth(Double.valueOf("72.5"))
            .relativeWeek(Double.valueOf("72.5"))
            .relativeWeekend(Double.valueOf("72.5"))
            .relativeYear(Double.valueOf("72.5"))
            .specificDay(Double.valueOf("72.5"))
            .specificDayOfWeek("testString")
            .specificMonth(Double.valueOf("72.5"))
            .specificQuarter(Double.valueOf("72.5"))
            .specificYear(Double.valueOf("72.5"))
            .numericValue(Double.valueOf("72.5"))
            .subtype("testString")
            .partOfDay("testString")
            .relativeHour(Double.valueOf("72.5"))
            .relativeMinute(Double.valueOf("72.5"))
            .relativeSecond(Double.valueOf("72.5"))
            .specificHour(Double.valueOf("72.5"))
            .specificMinute(Double.valueOf("72.5"))
            .specificSecond(Double.valueOf("72.5"))
            .timezone("testString")
            .build();
    assertEquals(runtimeEntityInterpretationModel.calendarType(), "testString");
    assertEquals(runtimeEntityInterpretationModel.datetimeLink(), "testString");
    assertEquals(runtimeEntityInterpretationModel.festival(), "testString");
    assertEquals(runtimeEntityInterpretationModel.granularity(), "day");
    assertEquals(runtimeEntityInterpretationModel.rangeLink(), "testString");
    assertEquals(runtimeEntityInterpretationModel.rangeModifier(), "testString");
    assertEquals(runtimeEntityInterpretationModel.relativeDay(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeMonth(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeWeek(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeWeekend(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeYear(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificDay(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificDayOfWeek(), "testString");
    assertEquals(runtimeEntityInterpretationModel.specificMonth(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificQuarter(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificYear(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.numericValue(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.subtype(), "testString");
    assertEquals(runtimeEntityInterpretationModel.partOfDay(), "testString");
    assertEquals(runtimeEntityInterpretationModel.relativeHour(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeMinute(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.relativeSecond(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificHour(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificMinute(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.specificSecond(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityInterpretationModel.timezone(), "testString");

    RuntimeEntityAlternative runtimeEntityAlternativeModel =
        new RuntimeEntityAlternative.Builder()
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .build();
    assertEquals(runtimeEntityAlternativeModel.value(), "testString");
    assertEquals(runtimeEntityAlternativeModel.confidence(), Double.valueOf("72.5"));

    RuntimeEntityRole runtimeEntityRoleModel =
        new RuntimeEntityRole.Builder().type("date_from").build();
    assertEquals(runtimeEntityRoleModel.type(), "date_from");

    RuntimeEntity runtimeEntityModel =
        new RuntimeEntity.Builder()
            .entity("testString")
            .location(new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))))
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .groups(
                new java.util.ArrayList<CaptureGroup>(java.util.Arrays.asList(captureGroupModel)))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(
                new java.util.ArrayList<RuntimeEntityAlternative>(
                    java.util.Arrays.asList(runtimeEntityAlternativeModel)))
            .role(runtimeEntityRoleModel)
            .build();
    assertEquals(runtimeEntityModel.entity(), "testString");
    assertEquals(
        runtimeEntityModel.location(),
        new java.util.ArrayList<Long>(java.util.Arrays.asList(Long.valueOf("26"))));
    assertEquals(runtimeEntityModel.value(), "testString");
    assertEquals(runtimeEntityModel.confidence(), Double.valueOf("72.5"));
    assertEquals(
        runtimeEntityModel.groups(),
        new java.util.ArrayList<CaptureGroup>(java.util.Arrays.asList(captureGroupModel)));
    assertEquals(runtimeEntityModel.interpretation(), runtimeEntityInterpretationModel);
    assertEquals(
        runtimeEntityModel.alternatives(),
        new java.util.ArrayList<RuntimeEntityAlternative>(
            java.util.Arrays.asList(runtimeEntityAlternativeModel)));
    assertEquals(runtimeEntityModel.role(), runtimeEntityRoleModel);

    MessageInputAttachment messageInputAttachmentModel =
        new MessageInputAttachment.Builder().url("testString").mediaType("testString").build();
    assertEquals(messageInputAttachmentModel.url(), "testString");
    assertEquals(messageInputAttachmentModel.mediaType(), "testString");

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

    MessageInputStateless messageInputStatelessModel =
        new MessageInputStateless.Builder()
            .messageType("text")
            .text("testString")
            .intents(
                new java.util.ArrayList<RuntimeIntent>(java.util.Arrays.asList(runtimeIntentModel)))
            .entities(
                new java.util.ArrayList<RuntimeEntity>(java.util.Arrays.asList(runtimeEntityModel)))
            .suggestionId("testString")
            .attachments(
                new java.util.ArrayList<MessageInputAttachment>(
                    java.util.Arrays.asList(messageInputAttachmentModel)))
            .options(messageInputOptionsStatelessModel)
            .build();
    assertEquals(messageInputStatelessModel.messageType(), "text");
    assertEquals(messageInputStatelessModel.text(), "testString");
    assertEquals(
        messageInputStatelessModel.intents(),
        new java.util.ArrayList<RuntimeIntent>(java.util.Arrays.asList(runtimeIntentModel)));
    assertEquals(
        messageInputStatelessModel.entities(),
        new java.util.ArrayList<RuntimeEntity>(java.util.Arrays.asList(runtimeEntityModel)));
    assertEquals(messageInputStatelessModel.suggestionId(), "testString");
    assertEquals(
        messageInputStatelessModel.attachments(),
        new java.util.ArrayList<MessageInputAttachment>(
            java.util.Arrays.asList(messageInputAttachmentModel)));
    assertEquals(messageInputStatelessModel.options(), messageInputOptionsStatelessModel);

    String json = TestUtilities.serialize(messageInputStatelessModel);

    MessageInputStateless messageInputStatelessModelNew =
        TestUtilities.deserialize(json, MessageInputStateless.class);
    assertTrue(messageInputStatelessModelNew instanceof MessageInputStateless);
    assertEquals(messageInputStatelessModelNew.messageType(), "text");
    assertEquals(messageInputStatelessModelNew.text(), "testString");
    assertEquals(messageInputStatelessModelNew.suggestionId(), "testString");
    assertEquals(
        messageInputStatelessModelNew.options().toString(),
        messageInputOptionsStatelessModel.toString());
  }
}
