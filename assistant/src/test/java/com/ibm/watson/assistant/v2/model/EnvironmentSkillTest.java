/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the EnvironmentSkill model. */
public class EnvironmentSkillTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEnvironmentSkill() throws Throwable {
    EnvironmentSkill environmentSkillModel =
        new EnvironmentSkill.Builder()
            .skillId("testString")
            .type("dialog")
            .disabled(true)
            .snapshot("testString")
            .skillReference("testString")
            .build();
    assertEquals(environmentSkillModel.skillId(), "testString");
    assertEquals(environmentSkillModel.type(), "dialog");
    assertEquals(environmentSkillModel.disabled(), Boolean.valueOf(true));
    assertEquals(environmentSkillModel.snapshot(), "testString");
    assertEquals(environmentSkillModel.skillReference(), "testString");

    String json = TestUtilities.serialize(environmentSkillModel);

    EnvironmentSkill environmentSkillModelNew =
        TestUtilities.deserialize(json, EnvironmentSkill.class);
    assertTrue(environmentSkillModelNew instanceof EnvironmentSkill);
    assertEquals(environmentSkillModelNew.skillId(), "testString");
    assertEquals(environmentSkillModelNew.type(), "dialog");
    assertEquals(environmentSkillModelNew.disabled(), Boolean.valueOf(true));
    assertEquals(environmentSkillModelNew.snapshot(), "testString");
    assertEquals(environmentSkillModelNew.skillReference(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnvironmentSkillError() throws Throwable {
    new EnvironmentSkill.Builder().build();
  }
}
