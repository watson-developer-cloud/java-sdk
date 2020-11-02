/*
 * (C) Copyright IBM Corp. 2020.
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

/** Unit test class for the DeleteAudioOptions model. */
public class DeleteAudioOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteAudioOptions() throws Throwable {
    DeleteAudioOptions deleteAudioOptionsModel =
        new DeleteAudioOptions.Builder()
            .customizationId("testString")
            .audioName("testString")
            .build();
    assertEquals(deleteAudioOptionsModel.customizationId(), "testString");
    assertEquals(deleteAudioOptionsModel.audioName(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAudioOptionsError() throws Throwable {
    new DeleteAudioOptions.Builder().build();
  }
}
