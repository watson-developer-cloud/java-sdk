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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test the Date deserializer.
 */
public class DateDeserializerTest {

    /**
     * Test date deserializer.
     */
    @Test
    public void testDeserialize() {
        DateDeserializer deserializer = new DateDeserializer();
        JsonParser parser = new JsonParser();


        // Date with MS and 3 digit and Z
        try {
            String dateString = "2017-04-23T19:09:46.712Z";
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertNotNull(deserializer.deserialize(element, null, null));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // Date with MS and 3 digit TZ
        try {
            String dateString = "2016-06-20T04:25:16.218+000";
            JsonElement element = parser.parse("\"" + dateString + "\"");
            // I have no idea what the actual value should be, so just check not null
            assertNotNull(deserializer.deserialize(element, null, null));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // Date without MS or TZ
        try {
            String dateString = "2016-06-20T04:25:16";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date dateVal = dateFormat.parse(dateString);
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertEquals(deserializer.deserialize(element, null, null), dateVal);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // ISO 8601 date / time with MS and 'Z' TZ
        try {
            String dateString = "2016-06-20T04:25:16.218Z";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            Date dateVal = dateFormat.parse(dateString);
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertEquals(deserializer.deserialize(element, null, null), dateVal);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // ISO 8601 date /time with 'Z' TZ but no MS
        try {
            String dateString = "2015-05-28T18:01:57Z";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            Date dateVal = dateFormat.parse(dateString);
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertEquals(deserializer.deserialize(element, null, null), dateVal);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // Date with MS but no TZ (SpeechToText)
        try {
            String dateString = "2016-09-30T16:51:47.558";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Date dateVal = dateFormat.parse(dateString);
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertEquals(deserializer.deserialize(element, null, null), dateVal);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // Seconds since epoch
        try {
            String dateString = "1478097789";
            Date dateVal = new Date(Long.parseLong(dateString) * 1000);
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertEquals(deserializer.deserialize(element, null, null), dateVal);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

        // MS since epoch
        try {
            String dateString = "1478097789000";
            Date dateVal = new Date(Long.parseLong(dateString));
            JsonElement element = parser.parse("\"" + dateString + "\"");
            assertEquals(deserializer.deserialize(element, null, null), dateVal);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
