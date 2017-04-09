/*
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

package com.ibm.watson.developer_cloud.discovery.v1.model.collection.field;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Override default enum handling for poorly formed JSON field types schema.
 */
public class FieldAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (!Field.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        return (TypeAdapter<T>) new FieldAdapter();
    }

    private class FieldAdapter extends TypeAdapter<Field> {
        @Override
        public void write(JsonWriter out, Field value) throws IOException {
            out.beginObject();
            out.name("field");
            out.value(value.getField());
            out.name("type");
            out.value(value.getType().toString());
            out.endObject();
        }

        @Override
        public Field read(JsonReader in) throws IOException {
            String fieldName = null;
            Field.Type type = Field.Type.UNKNOWN;
            in.beginObject();
            while (in.hasNext()) {
                String name = in.nextName();
                if (name.equals("field")) {
                    fieldName = in.nextString();
                } else if (name.equals("type")) {
                    JsonToken token = in.peek();

                    if (token.equals(JsonToken.STRING)) {
                        try {
                            type = Field.Type.valueOf(in.nextString().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            //invalid field type
                        }
                    } else {
                        in.skipValue();
                    }
                }
            }
            in.endObject();
            return new Field(fieldName, type);
        }
    }
}
