/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * The Class RequestUtilsTest.
 *
 */
public class RequestUtilsTest {

  /**
   * Creates the map.
   *
   * @return the map
   */
  private Map<String, Object> createMap() {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("A", 1);
    params.put("B", 2);
    params.put("C", 3);
    params.put("D", 4);
    return params;
  }

  /**
   * Test omit.
   */
  @Test
  public void testOmit() {
    final Map<String, Object> params = createMap();


    Map<String, Object> omitted = RequestUtils.omit(params, "A");

    Assert.assertTrue(omitted.keySet().containsAll(Lists.newArrayList("B", "C", "D")));
    Assert.assertTrue(omitted.values().containsAll(Lists.newArrayList(2, 3, 4)));

    omitted = RequestUtils.omit(params, "F");
    Assert.assertTrue(omitted.keySet().containsAll(Lists.newArrayList("A", "B", "C", "D")));
    Assert.assertTrue(omitted.values().containsAll(Lists.newArrayList(1, 2, 3, 4)));
  }

  /**
   * Test omit with nulls.
   */
  @Test
  public void testOmitWithNulls() {
    final Map<String, Object> params = createMap();

    Assert.assertArrayEquals(params.keySet().toArray(), RequestUtils.omit(params).keySet().toArray());
    Assert.assertArrayEquals(params.values().toArray(), RequestUtils.omit(params).values().toArray());

    Assert.assertNull(RequestUtils.omit(null));
  }

  /**
   * Test pick.
   */
  @Test
  public void testPick() {
    final Map<String, Object> params = createMap();

    Map<String, Object> picked = RequestUtils.pick(params, "A");
    Assert.assertArrayEquals(picked.keySet().toArray(), new String[] { "A" });
    Assert.assertArrayEquals(picked.values().toArray(), new Integer[] { 1 });

    picked = RequestUtils.pick(params, "F");
    Assert.assertArrayEquals(picked.keySet().toArray(), new String[] { });
    Assert.assertArrayEquals(picked.values().toArray(), new Integer[] { });
  }

  /**
   * Test pick with nulls.
   */
  @Test
  public void testPickWithNulls() {
    final Map<String, Object> params = createMap();

    Assert.assertArrayEquals(params.keySet().toArray(), RequestUtils.pick(params).keySet().toArray());
    Assert.assertArrayEquals(params.values().toArray(), RequestUtils.pick(params).values().toArray());

    Assert.assertNull(RequestUtils.pick(null));
  }

}
