package com.ibm.watson.developer_cloud.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class ValidateTest {

	private final String error = "error message";

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanStringObject() {
		Validate.isTrue(false, error, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanStringLong() {
		Validate.isTrue(false, error, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanStringDouble() {
		Validate.isTrue(false, error, 0.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBooleanString() {
		Validate.isTrue(false, error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueBoolean() {
		Validate.isTrue(false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotNullObject() {
		Validate.notNull(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotNullObjectString() {
		Validate.notNull(null, error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyObjectArrayString() {
		Validate.notEmpty(new String[] {}, error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyObjectArray() {
		Validate.notEmpty(new String[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyCollectionString() {
		Validate.notEmpty(new ArrayList<>(), error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyCollection() {
		Validate.notEmpty(new ArrayList<>());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyMapString() {
		Validate.notEmpty(new HashMap<String, String>(), error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyMap() {
		Validate.notEmpty(new HashMap<String, String>());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyStringString() {
		Validate.notEmpty("", error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotEmptyString() {
		Validate.notEmpty("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsObjectArrayString() {
		Object[] objects = new Object[] { "", null };
		Validate.noNullElements(objects, error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsObjectArray() {
		Object[] objects = new Object[] { "", null };
		Validate.noNullElements(objects);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsCollectionString() {
		Object[] objects = new Object[] { "", null };
		Validate.noNullElements(objects, error);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoNullElementsCollection() {
		Object[] objects = new Object[] { "", null };
		Validate.noNullElements(objects);
	}

}
