package com.ibm.watson.developer_cloud.util;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * DateSerializer
 */
public class DateSerializer implements JsonSerializer<Date> {
  private static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

  /*
   * (non-Javadoc)
   * 
   * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
   * com.google.gson.JsonSerializationContext)
   */
  @Override
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_UTC);

    return src == null ? null : new JsonPrimitive(sdf.format(src));
  }

}
