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

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the DefaultQueryParamsTableResults model. */
public class DefaultQueryParamsTableResultsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDefaultQueryParamsTableResults() throws Throwable {
    DefaultQueryParamsTableResults defaultQueryParamsTableResultsModel =
        new DefaultQueryParamsTableResults.Builder()
            .enabled(true)
            .count(Long.valueOf("26"))
            .perDocument(Long.valueOf("26"))
            .build();
    assertEquals(defaultQueryParamsTableResultsModel.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsTableResultsModel.count(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsTableResultsModel.perDocument(), Long.valueOf("26"));

    String json = TestUtilities.serialize(defaultQueryParamsTableResultsModel);

    DefaultQueryParamsTableResults defaultQueryParamsTableResultsModelNew =
        TestUtilities.deserialize(json, DefaultQueryParamsTableResults.class);
    assertTrue(defaultQueryParamsTableResultsModelNew instanceof DefaultQueryParamsTableResults);
    assertEquals(defaultQueryParamsTableResultsModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(defaultQueryParamsTableResultsModelNew.count(), Long.valueOf("26"));
    assertEquals(defaultQueryParamsTableResultsModelNew.perDocument(), Long.valueOf("26"));
  }
}
