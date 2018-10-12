/**
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 *
 */
public class StringHelperTest {

  @Test
  public void testToInputStream() throws IOException {
    assertEquals("",
      inputStreamToString(StringHelper.toInputStream("")));
    assertEquals("this is a test",
      inputStreamToString(StringHelper.toInputStream("this is a test")));
    assertEquals("this is a slightly longer test... hope it still works",
      inputStreamToString(StringHelper.toInputStream("this is a slightly longer test... hope it still works")));
  }

  private String inputStreamToString(InputStream is) throws IOException {
    String result = null;
    int numBytes = is.available();
    byte[] bytes = new byte[numBytes];
    is.read(bytes, 0, numBytes);
    result = new String(bytes);

    return result;
  }

  @Test
  public void testCreatePartName() {
    assertEquals("class1_positive_examples",
      StringHelper.createFormPartName("{classname}_positive_examples", "classname", "class1"));
    assertEquals("class2_positive_examples",
      StringHelper.createFormPartName("{classname}_positive_examples", "classname", "class2"));
    assertEquals("this_is_a_test",
      StringHelper.createFormPartName("this_is_{word}_test", "word", "a"));
    assertEquals("this_is_not_a_test",
      StringHelper.createFormPartName("this_is_{word}_test", "word", "not_a"));
  }
}
