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

package com.ibm.watson.speech_to_text.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.speech_to_text.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the RecognizeOptions model. */
public class RecognizeOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRecognizeOptions() throws Throwable {
    RecognizeOptions recognizeOptionsModel =
        new RecognizeOptions.Builder()
            .audio(TestUtilities.createMockStream("This is a mock file."))
            .contentType("application/octet-stream")
            .model("en-US_BroadbandModel")
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
            .smartFormattingVersion(false)
            .speakerLabels(false)
            .grammarName("testString")
            .redaction(false)
            .audioMetrics(false)
            .endOfPhraseSilenceTime(Double.valueOf("0.8"))
            .splitTranscriptAtPhraseEnd(false)
            .speechDetectorSensitivity(Float.valueOf("0.5"))
            .backgroundAudioSuppression(Float.valueOf("0.0"))
            .lowLatency(false)
            .characterInsertionBias(Float.valueOf("0.0"))
            .build();
    assertEquals(
        IOUtils.toString(recognizeOptionsModel.audio()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(recognizeOptionsModel.contentType(), "application/octet-stream");
    assertEquals(recognizeOptionsModel.model(), "en-US_BroadbandModel");
    assertEquals(recognizeOptionsModel.languageCustomizationId(), "testString");
    assertEquals(recognizeOptionsModel.acousticCustomizationId(), "testString");
    assertEquals(recognizeOptionsModel.baseModelVersion(), "testString");
    assertEquals(recognizeOptionsModel.customizationWeight(), Double.valueOf("72.5"));
    assertEquals(recognizeOptionsModel.inactivityTimeout(), Long.valueOf("30"));
    assertEquals(recognizeOptionsModel.keywords(), java.util.Arrays.asList("testString"));
    assertEquals(recognizeOptionsModel.keywordsThreshold(), Float.valueOf("36.0"));
    assertEquals(recognizeOptionsModel.maxAlternatives(), Long.valueOf("1"));
    assertEquals(recognizeOptionsModel.wordAlternativesThreshold(), Float.valueOf("36.0"));
    assertEquals(recognizeOptionsModel.wordConfidence(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.timestamps(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.profanityFilter(), Boolean.valueOf(true));
    assertEquals(recognizeOptionsModel.smartFormatting(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.smartFormattingVersion(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.speakerLabels(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.grammarName(), "testString");
    assertEquals(recognizeOptionsModel.redaction(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.audioMetrics(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.endOfPhraseSilenceTime(), Double.valueOf("0.8"));
    assertEquals(recognizeOptionsModel.splitTranscriptAtPhraseEnd(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.speechDetectorSensitivity(), Float.valueOf("0.5"));
    assertEquals(recognizeOptionsModel.backgroundAudioSuppression(), Float.valueOf("0.0"));
    assertEquals(recognizeOptionsModel.lowLatency(), Boolean.valueOf(false));
    assertEquals(recognizeOptionsModel.characterInsertionBias(), Float.valueOf("0.0"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRecognizeOptionsError() throws Throwable {
    new RecognizeOptions.Builder().build();
  }
}
