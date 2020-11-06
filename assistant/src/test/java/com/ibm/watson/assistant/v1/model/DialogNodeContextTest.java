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
import java.util.Map;
import org.testng.annotations.Test;

/** Unit test class for the DialogNodeContext model. */
public class DialogNodeContextTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDialogNodeContext() throws Throwable {
    DialogNodeContext dialogNodeContextModel =
        new DialogNodeContext.Builder()
            .integrations(
                new java.util.HashMap<String, Map<String, Object>>() {
                  {
                    put(
                        "foo",
                        new java.util.HashMap<String, Object>() {
                          {
                            put("foo", "testString");
                          }
                        });
                  }
                })
            .add("foo", "testString")
            .build();
    assertEquals(
        dialogNodeContextModel.getIntegrations(),
        new java.util.HashMap<String, Map<String, Object>>() {
          {
            put(
                "foo",
                new java.util.HashMap<String, Object>() {
                  {
                    put("foo", "testString");
                  }
                });
          }
        });
    assertEquals(dialogNodeContextModel.get("foo"), "testString");

    String json = TestUtilities.serialize(dialogNodeContextModel);

    DialogNodeContext dialogNodeContextModelNew =
        TestUtilities.deserialize(json, DialogNodeContext.class);
    assertTrue(dialogNodeContextModelNew instanceof DialogNodeContext);
    assertEquals(dialogNodeContextModelNew.get("foo"), "testString");
  }
}
