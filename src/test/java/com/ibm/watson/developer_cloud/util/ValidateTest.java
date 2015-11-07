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
package com.ibm.watson.developer_cloud.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * The Class ValidateTest.
 */
public class ValidateTest {

  /** The error. */
  private final String error = "error message";

  /**
   * Test all elements of type collection.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAllElementsOfTypeCollection() {
    @SuppressWarnings({"unchecked", "rawtypes"})
    final List objects = Lists.newArrayList(1, true);
    Validate.allElementsOfType(objects, Integer.class);
  }

  /**
   * Test all elements of type collection string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAllElementsOfTypeCollectionString() {
    @SuppressWarnings({"rawtypes", "unchecked"})
    final List objects = Lists.newArrayList(1, true);
    Validate.allElementsOfType(objects, Integer.class, error);
  }

  /**
   * Test is true boolean.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIsTrueBoolean() {
    Validate.isTrue(false);
  }

  /**
   * Test is true boolean string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIsTrueBooleanString() {
    Validate.isTrue(false, error);
  }

  /**
   * Test is true boolean string double.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIsTrueBooleanStringDouble() {
    Validate.isTrue(false, error, 0.0);
  }

  /**
   * Test is true boolean string long.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIsTrueBooleanStringLong() {
    Validate.isTrue(false, error, 1);
  }

  /**
   * Test is true boolean string object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIsTrueBooleanStringObject() {
    Validate.isTrue(false, error, null);
  }

  /**
   * Test no null elements collection.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoNullElementsCollection() {
    @SuppressWarnings("rawtypes")
    final List objects = Lists.newArrayList("", null);
    Validate.noNullElements(objects);
  }

  /**
   * Test no null elements collection string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoNullElementsCollectionString() {
    @SuppressWarnings("rawtypes")
    final List objects = Lists.newArrayList("", null);
    Validate.noNullElements(objects, error);
  }

  /**
   * Test no null elements object array.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoNullElementsObjectArray() {
    final Object[] objects = new Object[] {"", null};
    Validate.noNullElements(objects);
  }

  /**
   * Test no null elements object array string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoNullElementsObjectArrayString() {
    final Object[] objects = new Object[] {"", null};
    Validate.noNullElements(objects, error);
  }

  /**
   * Test not empty collection.
   */
  @SuppressWarnings("rawtypes")
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyCollection() {
    Validate.notEmpty(new ArrayList());
  }

  /**
   * Test not empty collection string.
   */
  @SuppressWarnings("rawtypes")
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyCollectionString() {
    Validate.notEmpty(new ArrayList(), error);
  }

  /**
   * Test not empty map.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyMap() {
    Validate.notEmpty(new HashMap<String, String>());
  }

  /**
   * Test not empty map string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyMapString() {
    Validate.notEmpty(new HashMap<String, String>(), error);
  }

  /**
   * Test not empty object array.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyObjectArray() {
    Validate.notEmpty(new String[] {});
  }

  /**
   * Test not empty object array string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyObjectArrayString() {
    Validate.notEmpty(new String[] {}, error);
  }

  /**
   * Test not empty string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyString() {
    Validate.notEmpty("");
  }

  /**
   * Test not empty string string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotEmptyStringString() {
    Validate.notEmpty("", error);
  }

  /**
   * Test not null object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotNullObject() {
    Validate.notNull(null);
  }

  /**
   * Test not null object string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotNullObjectString() {
    Validate.notNull(null, error);
  }
}
