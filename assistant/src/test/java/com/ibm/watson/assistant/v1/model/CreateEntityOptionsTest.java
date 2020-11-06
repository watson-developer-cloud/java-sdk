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

package com.ibm.watson.assistant.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the CreateEntityOptions model. */
public class CreateEntityOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateEntityOptions() throws Throwable {
    CreateValue createValueModel =
        new CreateValue.Builder()
            .value("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .type("synonyms")
            .synonyms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .patterns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
            .build();
    assertEquals(createValueModel.value(), "testString");
    assertEquals(
        createValueModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(createValueModel.type(), "synonyms");
    assertEquals(
        createValueModel.synonyms(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(
        createValueModel.patterns(),
        new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CreateEntityOptions createEntityOptionsModel =
        new CreateEntityOptions.Builder()
            .workspaceId("testString")
            .entity("testString")
            .description("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .fuzzyMatch(true)
            .values(new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)))
            .includeAudit(true)
            .build();
    assertEquals(createEntityOptionsModel.workspaceId(), "testString");
    assertEquals(createEntityOptionsModel.entity(), "testString");
    assertEquals(createEntityOptionsModel.description(), "testString");
    assertEquals(
        createEntityOptionsModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(createEntityOptionsModel.fuzzyMatch(), Boolean.valueOf(true));
    assertEquals(
        createEntityOptionsModel.values(),
        new java.util.ArrayList<CreateValue>(java.util.Arrays.asList(createValueModel)));
    assertEquals(createEntityOptionsModel.includeAudit(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEntityOptionsError() throws Throwable {
    new CreateEntityOptions.Builder().build();
  }
}
