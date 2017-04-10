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

package com.ibm.watson.developer_cloud.discovery.v1.model.query;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Adapts the abstract {@link Aggregation} to its concrete implementations.
 */
public class AggregationAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() != Aggregation.class) {
            return null;
        }
        return (TypeAdapter<T>) new QueryAggregationTypeAdapter(gson);
    }

    private class QueryAggregationTypeAdapter extends TypeAdapter<Aggregation> {
        private final Gson gson;
        private final TypeAdapter<JsonElement> jsonElementTypeAdapter;

        QueryAggregationTypeAdapter(Gson gson) {
            this.gson = gson;
            this.jsonElementTypeAdapter = gson.getAdapter(JsonElement.class);
        }

        @Override
        public void write(JsonWriter out, Aggregation value) throws IOException {
            JsonElement tree = null;
            if (value instanceof Term) {
                //order of keys not guaranteed
                tree = gson.toJsonTree(value, Term.class);
            } else if (value instanceof Histogram) {
                tree = gson.toJsonTree(value, Histogram.class);
            } else if (value instanceof Calculation) {
                tree = gson.toJsonTree(value, Calculation.class);
            }

            if (tree == null) {
                out.nullValue();
            } else {
                jsonElementTypeAdapter.write(out, tree);
            }
        }

        @Override
        public Aggregation read(JsonReader in) throws IOException {
            JsonElement tree = jsonElementTypeAdapter.read(in);

            if (tree.isJsonObject()) {
                JsonObject object = tree.getAsJsonObject();
                JsonElement typeElement = object.get(QueryManager.TYPE);
                if (typeElement.isJsonPrimitive()) {
                    try {
                        AggregationType type = AggregationType.valueOfIgnoreCase(typeElement.getAsString());
                        switch (type) {
                        case TERM:
                            return gson.fromJson(tree, Term.class);
                        case HISTOGRAM:
                            return gson.fromJson(tree, Histogram.class);
                        case MAX:
                        case MIN:
                        case SUM:
                        case AVERAGE:
                            return gson.fromJson(tree, Calculation.class);
                        }
                    } catch (IllegalArgumentException e) {

                    }
                }
            }
            return null;
        }
    }
}
