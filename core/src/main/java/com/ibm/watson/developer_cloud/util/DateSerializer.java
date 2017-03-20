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
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Date serializer.
 */
public class DateSerializer implements JsonSerializer<Date> {

  // SimpleDateFormat is NOT thread safe - they require private visibility and synchronized access
  private final SimpleDateFormat utc = new SimpleDateFormat(DateDeserializer.DATE_UTC);

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
   * com.google.gson.JsonSerializationContext)
   */
  @Override
  // DateSerializer.serialize() is NOT thread safe because of the underlying SimpleDateFormats.
  public synchronized JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    return src == null ? JsonNull.INSTANCE : new JsonPrimitive(utc.format(src));
  }
}
