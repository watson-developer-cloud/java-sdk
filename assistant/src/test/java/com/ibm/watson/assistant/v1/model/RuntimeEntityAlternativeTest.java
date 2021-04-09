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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the RuntimeEntityAlternative model. */
public class RuntimeEntityAlternativeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuntimeEntityAlternative() throws Throwable {
    RuntimeEntityAlternative runtimeEntityAlternativeModel =
        new RuntimeEntityAlternative.Builder()
            .value("testString")
            .confidence(Double.valueOf("72.5"))
            .build();
    assertEquals(runtimeEntityAlternativeModel.value(), "testString");
    assertEquals(runtimeEntityAlternativeModel.confidence(), Double.valueOf("72.5"));

    String json = TestUtilities.serialize(runtimeEntityAlternativeModel);

    RuntimeEntityAlternative runtimeEntityAlternativeModelNew =
        TestUtilities.deserialize(json, RuntimeEntityAlternative.class);
    assertTrue(runtimeEntityAlternativeModelNew instanceof RuntimeEntityAlternative);
    assertEquals(runtimeEntityAlternativeModelNew.value(), "testString");
    assertEquals(runtimeEntityAlternativeModelNew.confidence(), Double.valueOf("72.5"));
  }
}
