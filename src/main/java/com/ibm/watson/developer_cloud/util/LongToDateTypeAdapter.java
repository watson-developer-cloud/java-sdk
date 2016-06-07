/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

/**
 * This TypeAdapter converts unix timestamps (in numeric or String form) to Java Dates and vice versa.
 */
public class LongToDateTypeAdapter extends TypeAdapter<Date> {
  @Override
  public void write(JsonWriter out, Date value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.value(value.getTime());
    }
  }

  @Override
  public Date read(JsonReader in) throws IOException {
    if (in.peek() == null) {
      return null;
    } else {
      // nextLong() tries to parse Strings to Longs as well
      return new Date(in.nextLong());
    }
  }
}
