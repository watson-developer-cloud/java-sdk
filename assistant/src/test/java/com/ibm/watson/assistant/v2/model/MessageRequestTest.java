/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

/** Unit test class for the MessageRequest model. */
public class MessageRequestTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageRequest() throws Throwable {
    RuntimeIntent runtimeIntentModel =
        new RuntimeIntent.Builder()
            .intent("testString")
            .confidence(Double.valueOf("72.5"))
            .skill("testString")
            .build();
    assertEquals(runtimeIntentModel.intent(), "testString");
    assertEquals(runtimeIntentModel.confidence(), Double.valueOf("72.5"));
    assertEquals(runtimeIntentModel.skill(), "testString");

    CaptureGroup captureGroupModel =
        new CaptureGroup.Builder()
            .group("testString")
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .build();
    assertEquals(captureGroupModel.group(), "testString");
    assertEquals(captureGroupModel.location(), java.util.Arrays.asList(Long.valueOf("26")));

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
            .location(java.util.Arrays.asList(Long.valueOf("26")))
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .groups(java.util.Arrays.asList(captureGroupModel))
            .interpretation(runtimeEntityInterpretationModel)
            .alternatives(java.util.Arrays.asList(runtimeEntityAlternativeModel))
            .role(runtimeEntityRoleModel)
            .skill("testString")
            .build();
    assertEquals(runtimeEntityModel.entity(), "testString");
    assertEquals(runtimeEntityModel.location(), java.util.Arrays.asList(Long.valueOf("26")));
    assertEquals(runtimeEntityModel.value(), "testString");
    assertEquals(runtimeEntityModel.confidence(), Double.valueOf("72.5"));
    assertEquals(runtimeEntityModel.groups(), java.util.Arrays.asList(captureGroupModel));
    assertEquals(runtimeEntityModel.interpretation(), runtimeEntityInterpretationModel);
    assertEquals(
        runtimeEntityModel.alternatives(), java.util.Arrays.asList(runtimeEntityAlternativeModel));
    assertEquals(runtimeEntityModel.role(), runtimeEntityRoleModel);
    assertEquals(runtimeEntityModel.skill(), "testString");

    MessageInputAttachment messageInputAttachmentModel =
        new MessageInputAttachment.Builder().url("testString").mediaType("testString").build();
    assertEquals(messageInputAttachmentModel.url(), "testString");
    assertEquals(messageInputAttachmentModel.mediaType(), "testString");

    RequestAnalytics requestAnalyticsModel =
        new RequestAnalytics.Builder()
            .browser("testString")
            .device("testString")
            .pageUrl("testString")
            .build();
    assertEquals(requestAnalyticsModel.browser(), "testString");
    assertEquals(requestAnalyticsModel.device(), "testString");
    assertEquals(requestAnalyticsModel.pageUrl(), "testString");

    MessageInputOptionsSpelling messageInputOptionsSpellingModel =
        new MessageInputOptionsSpelling.Builder().suggestions(true).autoCorrect(true).build();
    assertEquals(messageInputOptionsSpellingModel.suggestions(), Boolean.valueOf(true));
    assertEquals(messageInputOptionsSpellingModel.autoCorrect(), Boolean.valueOf(true));

    MessageInputOptions messageInputOptionsModel =
        new MessageInputOptions.Builder()
            .restart(false)
            .alternateIntents(false)
            .spelling(messageInputOptionsSpellingModel)
            .debug(false)
            .returnContext(true)
            .export(true)
            .build();
    assertEquals(messageInputOptionsModel.restart(), Boolean.valueOf(false));
    assertEquals(messageInputOptionsModel.alternateIntents(), Boolean.valueOf(false));
    assertEquals(messageInputOptionsModel.spelling(), messageInputOptionsSpellingModel);
    assertEquals(messageInputOptionsModel.debug(), Boolean.valueOf(false));
    assertEquals(messageInputOptionsModel.returnContext(), Boolean.valueOf(true));
    assertEquals(messageInputOptionsModel.export(), Boolean.valueOf(true));

    MessageInput messageInputModel =
        new MessageInput.Builder()
            .messageType("text")
            .text("Hello")
            .intents(java.util.Arrays.asList(runtimeIntentModel))
            .entities(java.util.Arrays.asList(runtimeEntityModel))
            .suggestionId("testString")
            .attachments(java.util.Arrays.asList(messageInputAttachmentModel))
            .analytics(requestAnalyticsModel)
            .options(messageInputOptionsModel)
            .build();
    assertEquals(messageInputModel.messageType(), "text");
    assertEquals(messageInputModel.text(), "Hello");
    assertEquals(messageInputModel.intents(), java.util.Arrays.asList(runtimeIntentModel));
    assertEquals(messageInputModel.entities(), java.util.Arrays.asList(runtimeEntityModel));
    assertEquals(messageInputModel.suggestionId(), "testString");
    assertEquals(
        messageInputModel.attachments(), java.util.Arrays.asList(messageInputAttachmentModel));
    assertEquals(messageInputModel.analytics(), requestAnalyticsModel);
    assertEquals(messageInputModel.options(), messageInputOptionsModel);

    MessageContextGlobalSystem messageContextGlobalSystemModel =
        new MessageContextGlobalSystem.Builder()
            .timezone("testString")
            .userId("my_user_id")
            .turnCount(Long.valueOf("26"))
            .locale("en-us")
            .referenceTime("testString")
            .sessionStartTime("testString")
            .state("testString")
            .skipUserInput(true)
            .build();
    assertEquals(messageContextGlobalSystemModel.timezone(), "testString");
    assertEquals(messageContextGlobalSystemModel.userId(), "my_user_id");
    assertEquals(messageContextGlobalSystemModel.turnCount(), Long.valueOf("26"));
    assertEquals(messageContextGlobalSystemModel.locale(), "en-us");
    assertEquals(messageContextGlobalSystemModel.referenceTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.sessionStartTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.state(), "testString");
    assertEquals(messageContextGlobalSystemModel.skipUserInput(), Boolean.valueOf(true));

    MessageContextGlobal messageContextGlobalModel =
        new MessageContextGlobal.Builder().system(messageContextGlobalSystemModel).build();
    assertEquals(messageContextGlobalModel.system(), messageContextGlobalSystemModel);

    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

    MessageContextSkillDialog messageContextSkillDialogModel =
        new MessageContextSkillDialog.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .build();
    assertEquals(
        messageContextSkillDialogModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(messageContextSkillDialogModel.system(), messageContextSkillSystemModel);

    MessageContextSkillAction messageContextSkillActionModel =
        new MessageContextSkillAction.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .actionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .skillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(
        messageContextSkillActionModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(messageContextSkillActionModel.system(), messageContextSkillSystemModel);
    assertEquals(
        messageContextSkillActionModel.actionVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        messageContextSkillActionModel.skillVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    MessageContextSkills messageContextSkillsModel =
        new MessageContextSkills.Builder()
            .mainSkill(messageContextSkillDialogModel)
            .actionsSkill(messageContextSkillActionModel)
            .build();
    assertEquals(messageContextSkillsModel.mainSkill(), messageContextSkillDialogModel);
    assertEquals(messageContextSkillsModel.actionsSkill(), messageContextSkillActionModel);

    MessageContext messageContextModel =
        new MessageContext.Builder()
            .global(messageContextGlobalModel)
            .skills(messageContextSkillsModel)
            .integrations(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(messageContextModel.global(), messageContextGlobalModel);
    assertEquals(messageContextModel.skills(), messageContextSkillsModel);
    assertEquals(
        messageContextModel.integrations(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    MessageRequest messageRequestModel =
        new MessageRequest.Builder()
            .input(messageInputModel)
            .context(messageContextModel)
            .userId("testString")
            .build();
    assertEquals(messageRequestModel.input(), messageInputModel);
    assertEquals(messageRequestModel.context(), messageContextModel);
    assertEquals(messageRequestModel.userId(), "testString");

    String json = TestUtilities.serialize(messageRequestModel);

    MessageRequest messageRequestModelNew = TestUtilities.deserialize(json, MessageRequest.class);
    assertTrue(messageRequestModelNew instanceof MessageRequest);
    assertEquals(messageRequestModelNew.input().toString(), messageInputModel.toString());
    assertEquals(messageRequestModelNew.context().toString(), messageContextModel.toString());
    assertEquals(messageRequestModelNew.userId(), "testString");
  }
}
