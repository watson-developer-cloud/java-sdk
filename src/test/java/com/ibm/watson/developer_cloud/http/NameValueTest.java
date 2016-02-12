package com.ibm.watson.developer_cloud.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NameValueTest {

  @Before
  public void setUp() throws Exception {}

  @Test(expected = IllegalArgumentException.class)
  public void testNameNull() {
    new NameValue(null, null);
  }

  public void testNameEquals() {
    NameValue name1 = new NameValue("foo", "bar");
    NameValue name2 = new NameValue("foo", "bar");

    assertEquals(name1, name2);
    assertEquals(name1.toString(), name2.toString());
    assertEquals(name1.hashCode(), name2.hashCode());
    assertTrue(name1.equals(name2));
    
  }

  public void testValueNull() {
    NameValue name1 = new NameValue("foo", null);
    assertEquals(name1, "foo");
  }

}
