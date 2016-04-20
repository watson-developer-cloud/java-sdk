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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * The Class DateDeserializer.
 */
public class DateDeserializer implements JsonDeserializer<Date> {
  private static final String DATE_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS";
  private static final String DATE_WITHOUT_SECONDS = "yyyy-MM-dd'T'HH:mm:ssZ";
  private static final String DATE_FROM_DIALOG = "yyyy-MM-dd HH:mm:ss";
  private static final String DATE_FROM_ALCHEMY = "yyyyMMdd'T'HHmmss";

  private static final SimpleDateFormat utc = new SimpleDateFormat(DATE_UTC);
  private static final SimpleDateFormat utcWithoutSec = new SimpleDateFormat(DATE_WITHOUT_SECONDS);
  private static final SimpleDateFormat dialogDate = new SimpleDateFormat(DATE_FROM_DIALOG);
  private static final SimpleDateFormat alchemyDate = new SimpleDateFormat(DATE_FROM_ALCHEMY);

  private static final Logger log = Logger.getLogger(DateDeserializer.class.getName());

  /* (non-Javadoc)
   * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
   */
  @Override
  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    String dateAsString = json.getAsJsonPrimitive().getAsString();
    dateAsString = dateAsString.replaceAll("Z$", "+0000");
    try {
      return utc.parse(dateAsString);
    } catch (Exception e1) {
      try {
        return utcWithoutSec.parse(dateAsString);
      } catch (ParseException e2) {
        try {
          return dialogDate.parse(dateAsString);
        } catch (ParseException e3) {
          try {
            return alchemyDate.parse(dateAsString);
          } catch (ParseException e4) {
            log.log(Level.SEVERE, "Error parsing: " + dateAsString, e4);
          }
        }
      }
    }
    return null;
  }

}
