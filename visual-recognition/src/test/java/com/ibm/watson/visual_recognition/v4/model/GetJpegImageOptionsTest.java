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

package com.ibm.watson.visual_recognition.v4.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.visual_recognition.v4.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the GetJpegImageOptions model. */
public class GetJpegImageOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetJpegImageOptions() throws Throwable {
    GetJpegImageOptions getJpegImageOptionsModel =
        new GetJpegImageOptions.Builder()
            .collectionId("testString")
            .imageId("testString")
            .size("full")
            .build();
    assertEquals(getJpegImageOptionsModel.collectionId(), "testString");
    assertEquals(getJpegImageOptionsModel.imageId(), "testString");
    assertEquals(getJpegImageOptionsModel.size(), "full");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetJpegImageOptionsError() throws Throwable {
    new GetJpegImageOptions.Builder().build();
  }
}
