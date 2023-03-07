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

/** Unit test class for the ReleaseSkill model. */
public class ReleaseSkillTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReleaseSkill() throws Throwable {
    ReleaseSkill releaseSkillModel =
        new ReleaseSkill.Builder()
            .skillId("testString")
            .type("dialog")
            .snapshot("testString")
            .build();
    assertEquals(releaseSkillModel.skillId(), "testString");
    assertEquals(releaseSkillModel.type(), "dialog");
    assertEquals(releaseSkillModel.snapshot(), "testString");

    String json = TestUtilities.serialize(releaseSkillModel);

    ReleaseSkill releaseSkillModelNew = TestUtilities.deserialize(json, ReleaseSkill.class);
    assertTrue(releaseSkillModelNew instanceof ReleaseSkill);
    assertEquals(releaseSkillModelNew.skillId(), "testString");
    assertEquals(releaseSkillModelNew.type(), "dialog");
    assertEquals(releaseSkillModelNew.snapshot(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReleaseSkillError() throws Throwable {
    new ReleaseSkill.Builder().build();
  }
}
