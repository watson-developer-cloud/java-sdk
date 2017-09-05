/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.conversation.v1.model.Pagination;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class PaginationTypeAdapterTest.
 */
public class PaginationTypeAdapterTest extends WatsonServiceUnitTest {
  private static final String FIXTURE = "src/test/resources/conversation/pagination.json";

  /* (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  public void setUp() throws Exception {
  }

  /* (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceUnitTest#tearDown()
   */
  @Override
  public void tearDown() throws IOException {
  }

  /**
   * Test parse type adapter.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testParseTypeAdapter() throws FileNotFoundException {
    Pagination pagination = loadFixture(FIXTURE, Pagination.class);
    assertEquals(pagination.getCursor(), "batman");
  }

  /**
   * Test write type adapter.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testWriteTypeAdapter() throws FileNotFoundException {
    Pagination pagination = loadFixture(FIXTURE, Pagination.class);
    assertNotNull(GsonSingleton.getGson().toJson(pagination), pagination.toString());
  }
}
