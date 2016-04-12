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
