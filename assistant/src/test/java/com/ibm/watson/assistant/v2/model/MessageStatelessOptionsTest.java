/*
 * (C) Copyright IBM Corp. 2020, 2024.
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

/** Unit test class for the MessageStatelessOptions model. */
public class MessageStatelessOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMessageStatelessOptions() throws Throwable {
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

    StatelessMessageInput statelessMessageInputModel =
        new StatelessMessageInput.Builder()
            .messageType("text")
            .text("testString")
            .intents(java.util.Arrays.asList(runtimeIntentModel))
            .entities(java.util.Arrays.asList(runtimeEntityModel))
            .suggestionId("testString")
            .attachments(java.util.Arrays.asList(messageInputAttachmentModel))
            .analytics(requestAnalyticsModel)
            .options(statelessMessageInputOptionsModel)
            .build();
    assertEquals(statelessMessageInputModel.messageType(), "text");
    assertEquals(statelessMessageInputModel.text(), "testString");
    assertEquals(statelessMessageInputModel.intents(), java.util.Arrays.asList(runtimeIntentModel));
    assertEquals(
        statelessMessageInputModel.entities(), java.util.Arrays.asList(runtimeEntityModel));
    assertEquals(statelessMessageInputModel.suggestionId(), "testString");
    assertEquals(
        statelessMessageInputModel.attachments(),
        java.util.Arrays.asList(messageInputAttachmentModel));
    assertEquals(statelessMessageInputModel.analytics(), requestAnalyticsModel);
    assertEquals(statelessMessageInputModel.options(), statelessMessageInputOptionsModel);

    MessageContextGlobalSystem messageContextGlobalSystemModel =
        new MessageContextGlobalSystem.Builder()
            .timezone("testString")
            .userId("testString")
            .turnCount(Long.valueOf("26"))
            .locale("en-us")
            .referenceTime("testString")
            .sessionStartTime("testString")
            .state("testString")
            .skipUserInput(true)
            .build();
    assertEquals(messageContextGlobalSystemModel.timezone(), "testString");
    assertEquals(messageContextGlobalSystemModel.userId(), "testString");
    assertEquals(messageContextGlobalSystemModel.turnCount(), Long.valueOf("26"));
    assertEquals(messageContextGlobalSystemModel.locale(), "en-us");
    assertEquals(messageContextGlobalSystemModel.referenceTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.sessionStartTime(), "testString");
    assertEquals(messageContextGlobalSystemModel.state(), "testString");
    assertEquals(messageContextGlobalSystemModel.skipUserInput(), Boolean.valueOf(true));

    StatelessMessageContextGlobal statelessMessageContextGlobalModel =
        new StatelessMessageContextGlobal.Builder()
            .system(messageContextGlobalSystemModel)
            .sessionId("testString")
            .build();
    assertEquals(statelessMessageContextGlobalModel.system(), messageContextGlobalSystemModel);
    assertEquals(statelessMessageContextGlobalModel.sessionId(), "testString");

    MessageContextSkillSystem messageContextSkillSystemModel =
        new MessageContextSkillSystem.Builder()
            .state("testString")
            .add("foo", "testString")
            .build();
    assertEquals(messageContextSkillSystemModel.getState(), "testString");
    assertEquals(messageContextSkillSystemModel.get("foo"), "testString");

    MessageContextDialogSkill messageContextDialogSkillModel =
        new MessageContextDialogSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .build();
    assertEquals(
        messageContextDialogSkillModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(messageContextDialogSkillModel.system(), messageContextSkillSystemModel);

    StatelessMessageContextSkillsActionsSkill statelessMessageContextSkillsActionsSkillModel =
        new StatelessMessageContextSkillsActionsSkill.Builder()
            .userDefined(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .system(messageContextSkillSystemModel)
            .actionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .skillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .privateActionVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .privateSkillVariables(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.userDefined(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.system(), messageContextSkillSystemModel);
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.actionVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.skillVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.privateActionVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(
        statelessMessageContextSkillsActionsSkillModel.privateSkillVariables(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    StatelessMessageContextSkills statelessMessageContextSkillsModel =
        new StatelessMessageContextSkills.Builder()
            .mainSkill(messageContextDialogSkillModel)
            .actionsSkill(statelessMessageContextSkillsActionsSkillModel)
            .build();
    assertEquals(statelessMessageContextSkillsModel.mainSkill(), messageContextDialogSkillModel);
    assertEquals(
        statelessMessageContextSkillsModel.actionsSkill(),
        statelessMessageContextSkillsActionsSkillModel);

    StatelessMessageContext statelessMessageContextModel =
        new StatelessMessageContext.Builder()
            .global(statelessMessageContextGlobalModel)
            .skills(statelessMessageContextSkillsModel)
            .integrations(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .build();
    assertEquals(statelessMessageContextModel.global(), statelessMessageContextGlobalModel);
    assertEquals(statelessMessageContextModel.skills(), statelessMessageContextSkillsModel);
    assertEquals(
        statelessMessageContextModel.integrations(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));

    MessageStatelessOptions messageStatelessOptionsModel =
        new MessageStatelessOptions.Builder()
            .assistantId("testString")
            .environmentId("testString")
            .input(statelessMessageInputModel)
            .context(statelessMessageContextModel)
            .userId("testString")
            .build();
    assertEquals(messageStatelessOptionsModel.assistantId(), "testString");
    assertEquals(messageStatelessOptionsModel.environmentId(), "testString");
    assertEquals(messageStatelessOptionsModel.input(), statelessMessageInputModel);
    assertEquals(messageStatelessOptionsModel.context(), statelessMessageContextModel);
    assertEquals(messageStatelessOptionsModel.userId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMessageStatelessOptionsError() throws Throwable {
    new MessageStatelessOptions.Builder().build();
  }
}
