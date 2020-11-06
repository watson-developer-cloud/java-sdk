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

package com.ibm.watson.visual_recognition.v3.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.visual_recognition.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the GetClassifierOptions model. */
public class GetClassifierOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetClassifierOptions() throws Throwable {
    GetClassifierOptions getClassifierOptionsModel =
        new GetClassifierOptions.Builder().classifierId("testString").build();
    assertEquals(getClassifierOptionsModel.classifierId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClassifierOptionsError() throws Throwable {
    new GetClassifierOptions.Builder().build();
  }
}
