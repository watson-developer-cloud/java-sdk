/*
 * (C) Copyright IBM Corp. 2020, 2026.
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

/** Unit test class for the CreateJobOptions model. */
public class CreateJobOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateJobOptions() throws Throwable {
    CreateJobOptions createJobOptionsModel =
        new CreateJobOptions.Builder()
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/octet-stream")
            .model("en-US_BroadbandModel")
            .callbackUrl("testString")
            .events("recognitions.started")
            .userToken("testString")
            .resultsTtl(Long.valueOf("26"))
            .speechBeginEvent(false)
            .enrichments("testString")
            .languageCustomizationId("testString")
            .acousticCustomizationId("testString")
            .baseModelVersion("testString")
            .customizationWeight(Double.valueOf("72.5"))
            .inactivityTimeout(Long.valueOf("30"))
            .keywords(java.util.Arrays.asList("testString"))
            .keywordsThreshold(Float.valueOf("36.0"))
            .maxAlternatives(Long.valueOf("1"))
            .wordAlternativesThreshold(Float.valueOf("36.0"))
            .wordConfidence(false)
            .timestamps(false)
            .profanityFilter(true)
            .smartFormatting(false)
            .smartFormattingVersion(Long.valueOf("0"))
            .speakerLabels(false)
            .grammarName("testString")
            .redaction(false)
            .processingMetrics(false)
            .processingMetricsInterval(Float.valueOf("1.0"))
            .audioMetrics(false)
            .endOfPhraseSilenceTime(Double.valueOf("0.8"))
            .splitTranscriptAtPhraseEnd(false)
            .speechDetectorSensitivity(Float.valueOf("0.5"))
            .sadModule(Long.valueOf("1"))
            .backgroundAudioSuppression(Float.valueOf("0.0"))
            .lowLatency(false)
            .characterInsertionBias(Float.valueOf("0.0"))
            .build();
    assertEquals(
        IOUtils.toString(createJobOptionsModel.audio()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createJobOptionsModel.contentType(), "application/octet-stream");
    assertEquals(createJobOptionsModel.model(), "en-US_BroadbandModel");
    assertEquals(createJobOptionsModel.callbackUrl(), "testString");
    assertEquals(createJobOptionsModel.events(), "recognitions.started");
    assertEquals(createJobOptionsModel.userToken(), "testString");
    assertEquals(createJobOptionsModel.resultsTtl(), Long.valueOf("26"));
    assertEquals(createJobOptionsModel.speechBeginEvent(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.enrichments(), "testString");
    assertEquals(createJobOptionsModel.languageCustomizationId(), "testString");
    assertEquals(createJobOptionsModel.acousticCustomizationId(), "testString");
    assertEquals(createJobOptionsModel.baseModelVersion(), "testString");
    assertEquals(createJobOptionsModel.customizationWeight(), Double.valueOf("72.5"));
    assertEquals(createJobOptionsModel.inactivityTimeout(), Long.valueOf("30"));
    assertEquals(createJobOptionsModel.keywords(), java.util.Arrays.asList("testString"));
    assertEquals(createJobOptionsModel.keywordsThreshold(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.maxAlternatives(), Long.valueOf("1"));
    assertEquals(createJobOptionsModel.wordAlternativesThreshold(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.wordConfidence(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.timestamps(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.profanityFilter(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.smartFormatting(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.smartFormattingVersion(), Long.valueOf("0"));
    assertEquals(createJobOptionsModel.speakerLabels(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.grammarName(), "testString");
    assertEquals(createJobOptionsModel.redaction(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.processingMetrics(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.processingMetricsInterval(), Float.valueOf("1.0"));
    assertEquals(createJobOptionsModel.audioMetrics(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.endOfPhraseSilenceTime(), Double.valueOf("0.8"));
    assertEquals(createJobOptionsModel.splitTranscriptAtPhraseEnd(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.speechDetectorSensitivity(), Float.valueOf("0.5"));
    assertEquals(createJobOptionsModel.sadModule(), Long.valueOf("1"));
    assertEquals(createJobOptionsModel.backgroundAudioSuppression(), Float.valueOf("0.0"));
    assertEquals(createJobOptionsModel.lowLatency(), Boolean.valueOf(false));
    assertEquals(createJobOptionsModel.characterInsertionBias(), Float.valueOf("0.0"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateJobOptionsError() throws Throwable {
    new CreateJobOptions.Builder().build();
  }
}
