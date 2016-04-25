/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class NameValueTest.
 */
public class NameValueTest {

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {}

  /**
   * Test name null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNameNull() {
    new NameValue(null, null);
  }

  /**
   * Test name equals.
   */
  public void testNameEquals() {
    NameValue name1 = new NameValue("foo", "bar");
    NameValue name2 = new NameValue("foo", "bar");

    assertEquals(name1, name2);
    assertEquals(name1.toString(), name2.toString());
    assertEquals(name1.hashCode(), name2.hashCode());
    assertTrue(name1.equals(name2));
    
  }

  /**
   * Test value null.
   */
  public void testValueNull() {
    NameValue name1 = new NameValue("foo", null);
    assertEquals(name1, "foo");
  }

}
