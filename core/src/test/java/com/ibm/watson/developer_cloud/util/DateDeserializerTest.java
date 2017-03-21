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
package com.ibm.watson.developer_cloud.util;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * The Class DateDeserializerTest.
 */
public class DateDeserializerTest {

    /**
     * Test deserialize.
     */
    @Test
    public void testDeserialize() {
        String[] dateStrings = {
            "2016-06-20T04:25:16.218+0000",
            "2016-06-20T04:25:16",
            "2016-06-20T04:25:16.218Z",
            "2015-05-28T18:01:57Z",
            "2016-06-20T04:25:16.218+0000",
            "1478097789",
            "1478097789000"
        };

        String jsonStr = "[\"" + StringUtils.join(dateStrings, "\",\"") + "\"]";
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonStr);
        DateDeserializer deserializer = new DateDeserializer();
        for (int i = 0; i < dateStrings.length; i++) {
          System.out.println(deserializer.deserialize(element.getAsJsonArray().get(i), null, null));
            assertTrue(deserializer.deserialize(element.getAsJsonArray().get(i), null, null) != null);
        }
    }
}
