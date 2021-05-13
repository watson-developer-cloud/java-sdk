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
            .model("ar-AR_BroadbandModel")
            .callbackUrl("testString")
            .events("recognitions.started")
            .userToken("testString")
            .resultsTtl(Long.valueOf("26"))
            .languageCustomizationId("testString")
            .acousticCustomizationId("testString")
            .baseModelVersion("testString")
            .customizationWeight(Double.valueOf("72.5"))
            .inactivityTimeout(Long.valueOf("26"))
            .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .keywordsThreshold(Float.valueOf("36.0"))
            .maxAlternatives(Long.valueOf("26"))
            .wordAlternativesThreshold(Float.valueOf("36.0"))
            .wordConfidence(true)
            .timestamps(true)
            .profanityFilter(true)
            .smartFormatting(true)
            .speakerLabels(true)
            .customizationId("testString")
            .grammarName("testString")
            .redaction(true)
            .processingMetrics(true)
            .processingMetricsInterval(Float.valueOf("36.0"))
            .audioMetrics(true)
            .endOfPhraseSilenceTime(Double.valueOf("72.5"))
            .splitTranscriptAtPhraseEnd(true)
            .speechDetectorSensitivity(Float.valueOf("36.0"))
            .backgroundAudioSuppression(Float.valueOf("36.0"))
            .lowLatency(true)
            .build();
    assertEquals(
        IOUtils.toString(createJobOptionsModel.audio()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createJobOptionsModel.contentType(), "application/octet-stream");
    assertEquals(createJobOptionsModel.model(), "ar-AR_BroadbandModel");
    assertEquals(createJobOptionsModel.callbackUrl(), "testString");
    assertEquals(createJobOptionsModel.events(), "recognitions.started");
    assertEquals(createJobOptionsModel.userToken(), "testString");
    assertEquals(createJobOptionsModel.resultsTtl(), Long.valueOf("26"));
    assertEquals(createJobOptionsModel.languageCustomizationId(), "testString");
    assertEquals(createJobOptionsModel.acousticCustomizationId(), "testString");
    assertEquals(createJobOptionsModel.baseModelVersion(), "testString");
    assertEquals(createJobOptionsModel.customizationWeight(), Double.valueOf("72.5"));
    assertEquals(createJobOptionsModel.inactivityTimeout(), Long.valueOf("26"));
    assertEquals(
        createJobOptionsModel.keywords(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(createJobOptionsModel.keywordsThreshold(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.maxAlternatives(), Long.valueOf("26"));
    assertEquals(createJobOptionsModel.wordAlternativesThreshold(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.wordConfidence(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.timestamps(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.profanityFilter(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.smartFormatting(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.speakerLabels(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.customizationId(), "testString");
    assertEquals(createJobOptionsModel.grammarName(), "testString");
    assertEquals(createJobOptionsModel.redaction(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.processingMetrics(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.processingMetricsInterval(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.audioMetrics(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.endOfPhraseSilenceTime(), Double.valueOf("72.5"));
    assertEquals(createJobOptionsModel.splitTranscriptAtPhraseEnd(), Boolean.valueOf(true));
    assertEquals(createJobOptionsModel.speechDetectorSensitivity(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.backgroundAudioSuppression(), Float.valueOf("36.0"));
    assertEquals(createJobOptionsModel.lowLatency(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateJobOptionsError() throws Throwable {
    new CreateJobOptions.Builder().build();
  }
}
