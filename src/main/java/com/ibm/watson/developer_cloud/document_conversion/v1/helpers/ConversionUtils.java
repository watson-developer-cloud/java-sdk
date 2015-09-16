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
package com.ibm.watson.developer_cloud.document_conversion.v1.helpers;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * The utilities required for processing the documents in the service.
 *
 * @see DocumentConversion
 */
public class ConversionUtils {
    
    /**
     * Returns the media type for a given file.
     *
     * @param file the file object for which media type needs to be provided
     * @return Internet media type for the file
     */
    public static String getMediaTypeFromFile(final File file) {
        if (file != null) {
            String fileName = file.getName().toLowerCase();
            String[] supportedExtensions = {".htm", ".html", ".dot", ".doc", ".docx", ".xml", ".xhtml", ".pdf"};
            String[] supportedMediaTypes = {MediaType.TEXT_HTML, MediaType.TEXT_HTML,
                    MediaType.APPLICATION_MS_WORD, MediaType.APPLICATION_MS_WORD,
                    MediaType.APPLICATION_MS_WORD_DOCX, MediaType.APPLICATION_XHTML_XML,
                    MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_PDF};

            for (int i = 0; i < supportedMediaTypes.length; i++) {
                if (fileName.endsWith(supportedExtensions[i])) {
                    return supportedMediaTypes[i];
                }
            }
        }
        return null;
    }

    /**
     * Checks if the media type is supported by the service.
     *
     * @param mediaType  Internet media type for the file
     * @return true if it is supported, false if not.
     */
    public static Boolean isValidMediaType(final String mediaType) {
        if(mediaType != null) {
            String[] supportedMediaTypes = {MediaType.TEXT_HTML, MediaType.APPLICATION_MS_WORD,
                    MediaType.APPLICATION_MS_WORD_DOCX,MediaType.APPLICATION_XHTML_XML,
                    MediaType.APPLICATION_PDF};

            for (int i = 0; i < supportedMediaTypes.length; i++) {
                if (mediaType.equalsIgnoreCase(supportedMediaTypes[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Converts the date to ISO 8601 format.
     *
     * @param date the date to be converted to DateTime
     * @return the date time string for a given date
     */
    public static String convertToISO(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String dtAsISO = df.format(date);
        return dtAsISO;
    }

    /**
     * Write input stream to output stream.
     *
     * @param is the input stream
     * @return String
     */
    public static String writeInputStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Gson singleton with an ISO 8601 Date Deserializer.
     *
     * @return Gson
     */
    public static Gson getGsonWithIso8601DateDeserializer() {
        if (gsonWithIso8601DateDeserializer == null) {
            gsonWithIso8601DateDeserializer = new GsonBuilder()
                    .registerTypeAdapter(Date.class, iso8601DateDeserializer).create();
        }
        return gsonWithIso8601DateDeserializer;
    }

    /** Gson singleton with an ISO 8601 Date Deserializer. */
    private static Gson gsonWithIso8601DateDeserializer;

    /** JSON deserializer for ISO 8601 dates into Java Date objects. */
    private static JsonDeserializer<Date> iso8601DateDeserializer = new JsonDeserializer<Date>() {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            if (json == null) {
                return null;
            }
            String date = json.getAsString();
            SimpleDateFormat iso8601DateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            try {
                return iso8601DateTimeFormat.parse(date);
            } catch (Exception e) {
                throw new JsonParseException("Unable to parse date " + date, e);
            }
        }
    };

}
