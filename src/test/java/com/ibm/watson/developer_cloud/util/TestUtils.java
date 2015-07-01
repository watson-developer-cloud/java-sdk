/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.AssertionFailedError;

import org.junit.Ignore;

/**
 * The Class TestUtils.
 */
@Ignore
public final class TestUtils {

	/**
	 * Private constructor.
	 */
	private TestUtils() {

	}

	/**
	 * Test access to the properties of an object through its accessors.
	 * 
	 * @param obj
	 *            the object to test
	 * @throws Exception
	 *             any exception
	 */
	public static void assertNoExceptionsOnGetters(final Object obj)
			throws Exception {

		Class<?> clazz = obj.getClass();
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();

		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Method readMethod = propertyDescriptor.getReadMethod();

			if (readMethod != null) {
				try {
					readMethod.invoke(obj, new Object[] {});
				} catch (InvocationTargetException e) {
					StringBuffer msg = new StringBuffer();
					msg.append("Failure: " + propertyDescriptor.getName());
					msg.append(" Exception: " + e.getCause().getClass());
					msg.append(" Msg: " + e.getCause().getMessage());
					throw new AssertionFailedError(msg.toString());
				}
			}
		}

	}

	/**
	 * Test that collection iteration does not generate exceptions.
	 * 
	 * @param objs
	 *            the collection of objects
	 * @throws Exception
	 *             any exception
	 */
	@SuppressWarnings("rawtypes")
	public static void assertNoExceptionsOnCollectionIteration(
			final Collection objs) throws Exception {
		for (Iterator iter = objs.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			assertNoExceptionsOnGetters(obj);
		}
	}

	/**
	 * Test that a collection is not null or empty.
	 * 
	 * @param objs
	 *            the collection of objects
	 * @throws Exception
	 *             any exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void assertNotEmpty(final Collection objs) throws Exception {
		if (objs == null)
			throw new AssertionFailedError("Collection is null");
		if (objs.isEmpty())
			throw new AssertionFailedError("Collection is empty");
	}

	/**
	 * Test that a collection is not null or empty.
	 * 
	 * @param objs
	 *            the collection of objects
	 * @throws Exception
	 *             any exception
	 */
	@SuppressWarnings("rawtypes")
	public static void assertIsEmpty(final Collection objs) throws Exception {
		if (objs != null && !objs.isEmpty())
			throw new AssertionFailedError("Collection is empty");
	}

}
