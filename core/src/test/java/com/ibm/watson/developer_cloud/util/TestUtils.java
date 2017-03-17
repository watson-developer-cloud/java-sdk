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

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.junit.Ignore;

import junit.framework.AssertionFailedError;

/**
 * The Class TestUtils.
 */
@Ignore
public final class TestUtils {

  /**
   * Test that a collection is not null or empty.
   *
   * @param objs the collection of objects
   * @throws Exception any exception
   */
  @SuppressWarnings("rawtypes")
  public static void assertIsEmpty(final Collection objs) throws Exception {
    if ((objs != null) && !objs.isEmpty()) {
      throw new AssertionFailedError("Collection is empty");
    }
  }

  /**
   * Test that collection iteration does not generate exceptions.
   *
   * @param objs the collection of objects
   * @throws Exception any exception
   */
  @SuppressWarnings("rawtypes")
  public static void assertNoExceptionsOnCollectionIteration(final Collection objs) throws Exception {
    for (final Object obj : objs) {
      assertNoExceptionsOnGetters(obj);
    }
  }

  /**
   * Test access to the properties of an object through its accessors.
   *
   * @param obj the object to test
   * @throws Exception any exception
   */
  public static void assertNoExceptionsOnGetters(final Object obj) throws Exception {

    final Class<?> clazz = obj.getClass();
    final BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
    final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

    for (final PropertyDescriptor propertyDescriptor : propertyDescriptors) {
      final Method readMethod = propertyDescriptor.getReadMethod();

      if (readMethod != null) {
        try {
          readMethod.invoke(obj, new Object[] { });
        } catch (final InvocationTargetException e) {
          final StringBuffer msg = new StringBuffer();
          msg.append("Failure: " + propertyDescriptor.getName());
          msg.append(" Exception: " + e.getCause().getClass());
          msg.append(" Msg: " + e.getCause().getMessage());
          throw new AssertionFailedError(msg.toString());
        }
      }
    }

  }

  /**
   * Test that a collection is not null or empty.
   *
   * @param objs the collection of objects
   * @throws Exception any exception
   */
  @SuppressWarnings({ "rawtypes" })
  public static void assertNotEmpty(final Collection objs) throws Exception {
    if (objs == null) {
      throw new AssertionFailedError("Collection is null");
    }
    if (objs.isEmpty()) {
      throw new AssertionFailedError("Collection is empty");
    }
  }

  /**
   * Checks if both InputStreams have the same content and length. The streams are closed after reading.
   *
   * @param s1 the s1
   * @param s2 the s2
   * @return true, if the InputStreams are equal
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static boolean streamContentEquals(InputStream s1, InputStream s2) throws IOException {
    try {
      int b1, b2;

      do { // read while both stream contents are equal and s1 still has more bytes
        b1 = s1.read();
        b2 = s2.read();
      } while ((b1 == b2) && (b1 != -1));

      // this is true iff both streams are equally long and have the same content
      return b1 == b2;
    } finally {
      try {
        s1.close();
        s2.close();
      } catch (Exception e) {
        // Exceptions during closing seem to be ok!
      }
    }
  }

  /**
   * Private constructor.
   */
  private TestUtils() {

  }

}
