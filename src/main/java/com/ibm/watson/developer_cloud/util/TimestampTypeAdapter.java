package com.ibm.watson.developer_cloud.util;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Type adapter to convert a {@link Date} to the Long timestamp representation
 * 
 */
public class TimestampTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

  /*
   * (non-Javadoc)
   * 
   * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
   * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
   */
  @Override
  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (!(json instanceof JsonPrimitive)) {
      throw new JsonParseException("The date should be a string value");
    }
    try {
      return new Timestamp(json.getAsNumber().longValue());
    } catch (Exception e) {
      throw new JsonParseException(e);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
   * com.google.gson.JsonSerializationContext)
   */
  @Override
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.getTime());
  }
}
