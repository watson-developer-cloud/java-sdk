/*
 * (C) Copyright IBM Corp. 2022.
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

/** Unit test class for the CreateEntity model. */
public class CreateEntityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateEntity() throws Throwable {
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
            .synonyms(java.util.Arrays.asList("testString"))
            .patterns(java.util.Arrays.asList("testString"))
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
    assertEquals(createValueModel.synonyms(), java.util.Arrays.asList("testString"));
    assertEquals(createValueModel.patterns(), java.util.Arrays.asList("testString"));

    CreateEntity createEntityModel =
        new CreateEntity.Builder()
            .entity("testString")
            .description("testString")
            .metadata(
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                })
            .fuzzyMatch(true)
            .values(java.util.Arrays.asList(createValueModel))
            .build();
    assertEquals(createEntityModel.entity(), "testString");
    assertEquals(createEntityModel.description(), "testString");
    assertEquals(
        createEntityModel.metadata(),
        new java.util.HashMap<String, Object>() {
          {
            put("foo", "testString");
          }
        });
    assertEquals(createEntityModel.fuzzyMatch(), Boolean.valueOf(true));
    assertEquals(createEntityModel.values(), java.util.Arrays.asList(createValueModel));

    String json = TestUtilities.serialize(createEntityModel);

    CreateEntity createEntityModelNew = TestUtilities.deserialize(json, CreateEntity.class);
    assertTrue(createEntityModelNew instanceof CreateEntity);
    assertEquals(createEntityModelNew.entity(), "testString");
    assertEquals(createEntityModelNew.description(), "testString");
    assertEquals(createEntityModelNew.fuzzyMatch(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEntityError() throws Throwable {
    new CreateEntity.Builder().build();
  }
}
