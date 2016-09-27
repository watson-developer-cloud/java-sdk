/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Date deserializer for different date format across all the Watson APIs.
 */
public class DateDeserializer implements JsonDeserializer<Date> {
  private static final String DATE_FROM_ALCHEMY = "yyyyMMdd'T'HHmmss";
  private static final String DATE_FROM_DIALOG = "yyyy-MM-dd HH:mm:ss";
  protected static final String DATE_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS";
  private static final String DATE_WITHOUT_SECONDS = "yyyy-MM-dd'T'HH:mm:ssZ";

  // SimpleDateFormat is NOT thread safe - they require private visibility and synchronized access
  private final SimpleDateFormat alchemyDateFormatter = new SimpleDateFormat(DATE_FROM_ALCHEMY);
  private final SimpleDateFormat dialogDateFormatter = new SimpleDateFormat(DATE_FROM_DIALOG);
  private final SimpleDateFormat utcDateFormatter = new SimpleDateFormat(DATE_UTC);
  private final SimpleDateFormat utcWithoutSecondsDateFormatter = new SimpleDateFormat(DATE_WITHOUT_SECONDS);

  private final List<SimpleDateFormat> FORMATS = Arrays.asList(
    utcDateFormatter, utcWithoutSecondsDateFormatter, dialogDateFormatter, alchemyDateFormatter);

  private static final Logger LOG = Logger.getLogger(DateDeserializer.class.getName());
  
  /*
   * (non-Javadoc)
   * 
   * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
   * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
   */
  @Override
  // DateSerializer.deserialize() is NOT thread safe because of the underlying SimpleDateFormats.
  public synchronized Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    if(json.isJsonNull() || json.getAsString().isEmpty()) {
      return null;
    }

    String dateAsString = json.getAsJsonPrimitive().getAsString().replaceAll("Z$", "+0000");
    ParseException e = null;

    for(SimpleDateFormat format : FORMATS) {
      try {
        return format.parse(dateAsString);
      } catch (ParseException e1) {
        e = e1;
      }
    }

    LOG.log(Level.SEVERE, "Error parsing: " + dateAsString, e);
    return null;
  }

}
