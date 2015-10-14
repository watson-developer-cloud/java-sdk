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
	 * Test is true boolean string object.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanStringObject() {
		Validate.isTrue(false, error, null);
	}

	/**
	 * Test is true boolean string long.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanStringLong() {
		Validate.isTrue(false, error, 1);
	}

	/**
	 * Test is true boolean string double.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanStringDouble() {
		Validate.isTrue(false, error, 0.0);
	}

	/**
	 * Test is true boolean string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanString() {
		Validate.isTrue(false, error);
	}

	/**
	 * Test is true boolean.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBoolean() {
		Validate.isTrue(false);
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

	/**
	 * Test not empty object array string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyObjectArrayString() {
		Validate.notEmpty(new String[] {}, error);
	}

	/**
	 * Test not empty object array.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyObjectArray() {
		Validate.notEmpty(new String[] {});
	}

	/**
	 * Test not empty collection string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyCollectionString() {
		Validate.notEmpty(new ArrayList<>(), error);
	}

	/**
	 * Test not empty collection.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyCollection() {
		Validate.notEmpty(new ArrayList<>());
	}

	/**
	 * Test not empty map string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyMapString() {
		Validate.notEmpty(new HashMap<String, String>(), error);
	}

	/**
	 * Test not empty map.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyMap() {
		Validate.notEmpty(new HashMap<String, String>());
	}

	/**
	 * Test not empty string string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyStringString() {
		Validate.notEmpty("", error);
	}

	/**
	 * Test not empty string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyString() {
		Validate.notEmpty("");
	}

	/**
	 * Test no null elements object array string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsObjectArrayString() {
		Object[] objects = new Object[] { "", null };
		Validate.noNullElements(objects, error);
	}

	/**
	 * Test no null elements object array.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsObjectArray() {
		Object[] objects = new Object[] { "", null };
		Validate.noNullElements(objects);
	}

	/**
	 * Test no null elements collection string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsCollectionString() {
		@SuppressWarnings("rawtypes")
		List objects = Lists.newArrayList("", null);
		Validate.noNullElements(objects, error);
	}

	/**
	 * Test no null elements collection.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsCollection() {
		@SuppressWarnings("rawtypes")
		List objects = Lists.newArrayList("", null);
		Validate.noNullElements(objects);
	}

	/**
	 * Test all elements of type collection string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAllElementsOfTypeCollectionString() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List objects = Lists.newArrayList(1,true);
		Validate.allElementsOfType(objects, Integer.class, error);
	}

	/**
	 * Test all elements of type collection.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAllElementsOfTypeCollection() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List objects = Lists.newArrayList(1, true);
		Validate.allElementsOfType(objects, Integer.class);
	}
}
