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
package com.ibm.watson.developer_cloud.discovery.v1.query;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.ibm.watson.developer_cloud.discovery.v1.model.Calculation;
import com.ibm.watson.developer_cloud.discovery.v1.model.Histogram;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryAggregation;
import com.ibm.watson.developer_cloud.discovery.v1.model.Term;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Deserializer to transform JSON into a {@link QueryAggregation}.
 */
public class AggregationDeserializer implements JsonDeserializer<QueryAggregation> {

  private static final String TYPE = "type";

  /**
   * Deserializes JSON and converts it to the appropriate {@link QueryAggregation} subclass.
   *
   * @param json the JSON data being deserialized
   * @param typeOfT the type to deserialize to, which should be {@link QueryAggregation}
   * @param context additional information about the deserialization state
   * @return the appropriate {@link QueryAggregation} subclass
   * @throws JsonParseException signals that there has been an issue parsing the JSON
   */
  @Override
  public QueryAggregation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonReader in = new JsonReader(new StringReader(GsonSingleton.getGson().toJson(json)));
    HashMap<String, Object> aggregationMap = null;

    try {
      aggregationMap = getAggregationMap(in);
    } catch (IOException e) {
      e.printStackTrace();
    }

    QueryAggregation aggregation;
    String aggregationType = (String) aggregationMap.get(TYPE);

    if (aggregationType.equals(AggregationType.HISTOGRAM.getName())) {
      aggregation = GsonSerializationHelper.serializeDynamicModelProperty(aggregationMap, Histogram.class);
    } else if (aggregationType.equals(AggregationType.MAX.getName())
        || aggregationType.equals(AggregationType.MIN.getName())
        || aggregationType.equals(AggregationType.AVERAGE.getName())
        || aggregationType.equals(AggregationType.SUM.getName())) {
      aggregation = GsonSerializationHelper.serializeDynamicModelProperty(aggregationMap, Calculation.class);
    } else if (aggregationType.equals(AggregationType.TERM.getName())) {
      aggregation = GsonSerializationHelper.serializeDynamicModelProperty(aggregationMap, Term.class);
    } else {
      aggregation = GsonSerializationHelper.serializeDynamicModelProperty(aggregationMap, QueryAggregation.class);
    }

    return aggregation;
  }

  /**
   * Converts JSON into a Map representing a {@link QueryAggregation} object.
   *
   * @param in {@link JsonReader} object used for parsing
   * @return Map representing the {@link QueryAggregation} object
   * @throws IOException signals that there has been an IO exception
   */
  private HashMap<String, Object> getAggregationMap(JsonReader in) throws IOException {
    HashMap<String, Object> objMap = new HashMap<>();
    while (in.peek() != JsonToken.END_DOCUMENT) {
      parseNext(in, objMap);
    }
    return objMap;
  }

  /**
   * Checks the next {@link JsonToken} to decide the next appropriate parsing method.
   *
   * @param in {@link JsonReader} object used for parsing
   * @param objMap Map used to build the structure for the resulting {@link QueryAggregation} object
   * @throws IOException signals that there has been an IO exception
   */
  private void parseNext(JsonReader in, HashMap<String, Object> objMap) throws IOException {
    JsonToken token = in.peek();

    String lastName = "";
    if (token == JsonToken.NAME) {
      lastName = in.nextName();
      token = in.peek();
    }

    switch (token) {
      case BEGIN_ARRAY:
        parseArray(in, objMap, lastName);
        break;
      case BEGIN_OBJECT:
        parseObject(in, objMap, lastName);
        break;
      case STRING:
        objMap.put(lastName, in.nextString());
        break;
      case NUMBER:
        objMap.put(lastName, in.nextDouble());
        break;
      case BOOLEAN:
        objMap.put(lastName, in.nextBoolean());
        break;
      default:
        throw new IOException("Unexpected JSON token encountered");
    }

    collapseMap(objMap);
  }

  /**
   * Parses a JSON array and adds it to the main object map.
   *
   * @param in {@link JsonReader} object used for parsing
   * @param objMap Map used to build the structure for the resulting {@link QueryAggregation} object
   * @param name key value to go with the resulting value of this method pass
   * @throws IOException signals that there has been an IO exception
   */
  private void parseArray(JsonReader in, HashMap<String, Object> objMap, String name) throws IOException {
    List<HashMap<String, Object>> array = new ArrayList<>();
    in.beginArray();

    while (in.peek() != JsonToken.END_ARRAY) {
      HashMap<String, Object> arrayItem = new HashMap<>();
      parseNext(in, arrayItem);
      array.add(arrayItem);
    }

    in.endArray();
    objMap.put(name, array);
  }

  /**
   * Parses a JSON object and adds it to the main object map.
   *
   * @param in {@link JsonReader} object used for parsing
   * @param objMap Map used to build the structure for the resulting {@link QueryAggregation} object
   * @param name key value to go with the resulting value of this method pass
   * @throws IOException signals that there has been an IO exception
   */
  private void parseObject(JsonReader in, HashMap<String, Object> objMap, String name) throws IOException {
    HashMap<String, Object> innerObject = new HashMap<>();
    in.beginObject();

    while (in.peek() != JsonToken.END_OBJECT) {
      parseNext(in, innerObject);
    }

    in.endObject();
    objMap.put(name, innerObject);
  }

  /**
   * Condenses the main object map to eliminate unnecessary nesting and allow for proper type conversion when the map
   * is complete.
   *
   * @param objMap Map used to build the structure for the resulting {@link QueryAggregation} object
   */
  private void collapseMap(HashMap<String, Object> objMap) {
    while (objMap.keySet().size() == 1 && objMap.keySet().contains("")) {
      HashMap<String, Object> innerMap = (HashMap<String, Object>) objMap.get("");
      objMap.clear();
      objMap.putAll(innerMap);
    }
  }
}
