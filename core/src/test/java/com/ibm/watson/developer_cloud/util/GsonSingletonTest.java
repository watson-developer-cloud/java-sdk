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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

/**
 * Test the {@link GsonSingleton} class used to transform from and to JSON.
 */
public class GsonSingletonTest {

  /** The list type. */
  Type listType = new TypeToken<ArrayList<Date>>() { }.getType();

  /**
   * Test the date serializer and deserializer.
   */
  @Test
  public void testDateSerializer() {
    String dateAsJson = "[\"2014-06-04T15:38:07Z\"," + "\"2015-08-24T18:42:25.324Z\"," + "\"2015-08-24T18:42:25.324Z\","
        + "\"2015-08-31T00:49:27.77Z\"," + "\"2015-09-01T16:05:30.058-0400\"," + "\"2015-09-01T16:05:30.058-0400\","
        + "\"2015-09-01T16:05:30.058-0400\"," + "\"2015-09-01T16:05:30.058-0400\"," + "\"2015-10-08T17:59:39.609Z\","
        + "\"2016-03-12 20:31:58\"]";

    List<Date> dates = GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(dateAsJson, listType);
    Assert.assertNotNull(dates);

    String datesAsString = GsonSingleton.getGsonWithoutPrettyPrinting().toJson(dates);
    Assert.assertNotNull(datesAsString);

    Assert.assertNotEquals(GsonSingleton.getGson().toJson(dates),
        GsonSingleton.getGsonWithoutPrettyPrinting().toJson(dates));
  }

}
