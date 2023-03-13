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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CreateValueOptions model. */
public class CreateValueOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateValueOptions() throws Throwable {
    CreateValueOptions createValueOptionsModel =
        new CreateValueOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .includeAudit(false)
            .build();
    assertEquals(createValueOptionsModel.workspaceId(), "testString");
    assertEquals(createValueOptionsModel.entity(), "testString");
    assertEquals(createValueOptionsModel.value(), "testString");
    assertEquals(
        createValueOptionsModel.metadata(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createValueOptionsModel.type(), "synonyms");
    assertEquals(createValueOptionsModel.synonyms(), java.util.Arrays.asList("testString"));
    assertEquals(createValueOptionsModel.patterns(), java.util.Arrays.asList("testString"));
    assertEquals(createValueOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateValueOptionsError() throws Throwable {
    new CreateValueOptions.Builder().build();
  }
}
