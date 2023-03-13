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

/** Unit test class for the UpdateEntityOptions model. */
public class UpdateEntityOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateEntityOptions() throws Throwable {
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .type("synonyms")
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
            .build();
    assertEquals(createValueModel.value(), "testString");
    assertEquals(
        createValueModel.metadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createValueModel.type(), "synonyms");
    assertEquals(createValueModel.synonyms(), java.util.Arrays.asList("testString"));
    assertEquals(createValueModel.patterns(), java.util.Arrays.asList("testString"));

    UpdateEntityOptions updateEntityOptionsModel =
        new UpdateEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .newEntity("testString")
            .newDescription("testString")
            .newMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
            .newFuzzyMatch(true)
            .newValues(java.util.Arrays.asList(createValueModel))
            .append(false)
            .includeAudit(false)
            .build();
    assertEquals(updateEntityOptionsModel.workspaceId(), "testString");
    assertEquals(updateEntityOptionsModel.entity(), "testString");
    assertEquals(updateEntityOptionsModel.newEntity(), "testString");
    assertEquals(updateEntityOptionsModel.newDescription(), "testString");
    assertEquals(
        updateEntityOptionsModel.newMetadata(),
        java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(updateEntityOptionsModel.newFuzzyMatch(), Boolean.valueOf(true));
    assertEquals(updateEntityOptionsModel.newValues(), java.util.Arrays.asList(createValueModel));
    assertEquals(updateEntityOptionsModel.append(), Boolean.valueOf(false));
    assertEquals(updateEntityOptionsModel.includeAudit(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEntityOptionsError() throws Throwable {
    new UpdateEntityOptions.Builder().build();
  }
}
