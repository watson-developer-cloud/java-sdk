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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nastacio on 7/2/2016
 */
public class TypedEntitiesAdapter extends TypeAdapter<List<TypedEntity>> {

    @Override
    public void write(JsonWriter writer, List<TypedEntity> value) throws IOException {
        // No coding the serialization as there is no code relying on this
        // type to serialize payloads
    }

    @Override
    public List<TypedEntity> read(JsonReader reader) throws IOException {
        List<TypedEntity> es = new ArrayList<TypedEntity>();

        reader.beginArray(); // arguments
        while (reader.hasNext()) {
            reader.beginObject(); // argument
            while (reader.hasNext()) {
                String name = reader.nextName();
                if ("entities".equals(name)) {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        TypedEntity e = new TypedEntity();
                        reader.beginObject();
                        while (reader.hasNext()) {
                            String name1 = reader.nextName();
                            if ("text".equals(name1)) {
                                e.setText(reader.nextString());
                            } else if ("type".equals(name1)) {
                                e.setType(reader.nextString());
                            } else if ("id".equals(name1)) {
                                e.setId(reader.nextString());
                            } else {
                                reader.skipValue();
                            }
                        }
                        reader.endObject();
                        es.add(e);
                    }
                    reader.endArray();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        }
        reader.endArray();

        return es;
    }

}
