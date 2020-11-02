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

package com.ibm.watson.compare_comply.v1.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.compare_comply.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the CreateBatchOptions model. */
public class CreateBatchOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateBatchOptions() throws Throwable {
    CreateBatchOptions createBatchOptionsModel =
        new CreateBatchOptions.Builder()
            .function("html_conversion")
            .inputCredentialsFile(TestUtilities.createMockStream("This is a mock file."))
            .inputBucketLocation("testString")
            .inputBucketName("testString")
            .outputCredentialsFile(TestUtilities.createMockStream("This is a mock file."))
            .outputBucketLocation("testString")
            .outputBucketName("testString")
            .model("contracts")
            .build();
    assertEquals(createBatchOptionsModel.function(), "html_conversion");
    assertEquals(
        IOUtils.toString(createBatchOptionsModel.inputCredentialsFile()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createBatchOptionsModel.inputBucketLocation(), "testString");
    assertEquals(createBatchOptionsModel.inputBucketName(), "testString");
    assertEquals(
        IOUtils.toString(createBatchOptionsModel.outputCredentialsFile()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
    assertEquals(createBatchOptionsModel.outputBucketLocation(), "testString");
    assertEquals(createBatchOptionsModel.outputBucketName(), "testString");
    assertEquals(createBatchOptionsModel.model(), "contracts");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateBatchOptionsError() throws Throwable {
    new CreateBatchOptions.Builder().build();
  }
}
