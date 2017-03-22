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

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * This TypeAdapter converts "yes", "no", "true", and "false" to Booleans and vice versa.
 */
public class BooleanToStringTypeAdapter extends TypeAdapter<Boolean> {

  private static final String YES = "yes";

  private static final String TRUE = "true";

  private static final String NO = "no";

  private static final String FALSE = "false";

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter out, Boolean value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.value(value ? YES : NO);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public Boolean read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    } else {
      final String value = in.nextString();

      if (YES.equals(value) || TRUE.equals(value)) {
        return Boolean.TRUE;
      } else if (NO.equals(value) || FALSE.equals(value)) {
        return Boolean.FALSE;
      } else if (value.isEmpty()) {
        return null;
      }

      throw new IllegalArgumentException("Cannot parse JSON value '" + value + "' to Boolean.");
    }
  }
}
