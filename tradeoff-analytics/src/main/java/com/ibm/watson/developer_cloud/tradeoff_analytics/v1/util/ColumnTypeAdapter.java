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
package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.CategoricalColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column.ColumnType;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column.Goal;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.DateColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.NumericColumn;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.TextColumn;

/**
 * Type adapter to transform JSON into a {@link Column} and vice versa.
 */
public class ColumnTypeAdapter extends TypeAdapter<Column> {

  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  private static final String DESCRIPTION = "description";
  private static final String FORMAT = "format";
  private static final String FULL_NAME = "full_name";
  private static final String GOAL = "goal";
  private static final String HIGH = "high";
  private static final String INSIGNIFICANT_LOSS = "insignificant_loss";
  private static final String IS_OBJECTIVE = "is_objective";
  private static final String KEY = "key";
  private static final Logger LOG = Logger.getLogger(ColumnTypeAdapter.class.getName());
  private static final String LOW = "low";
  private static final String RANGE = "range";
  private static final String PREFERENCE = "preference";
  private static final String SIGNIFICANT_GAIN = "significant_gain";
  private static final String SIGNIFICANT_LOSS = "significant_loss";
  private static final String TYPE2 = "type";
  private static final DateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);

  /**
   * Write categorical column.
   *
   * @param catCol the cat col
   * @param writer the writer
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void writeCategoricalColumn(CategoricalColumn catCol, JsonWriter writer) throws IOException {
    if (catCol.getPreference() != null) {
      writer.name(PREFERENCE);
      writer.beginArray();
      for (final String pref : catCol.getPreference()) {
        writer.value(pref);
      }
      writer.endArray();
    }

    // range
    if (catCol.getRange() != null) {
      writer.name(RANGE);
      writer.beginArray();
      for (final String value : catCol.getRange()) {
        writer.value(value);
      }
      writer.endArray();
    }
  }

  /**
   * Write date column.
   *
   * @param dateCol the date col
   * @param writer the writer
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void writeDateColumn(DateColumn dateCol, JsonWriter writer) throws IOException {
    if (dateCol.getLow() != null) {
      writer.name(RANGE).beginObject();
      writer.name(LOW).value(DATE_FORMATTER.format(dateCol.getLow()));
      writer.name(HIGH).value(DATE_FORMATTER.format(dateCol.getHigh()));
      writer.endObject();
    }
  }

  /**
   * Write numerical column.
   *
   * @param numCol the num col
   * @param writer the writer
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void writeNumericalColumn(NumericColumn numCol, JsonWriter writer) throws IOException {
    if (numCol.getLow() != null) {
      writer.name(RANGE);
      writer.beginObject();
      writer.name(LOW).value(numCol.getLow());
      writer.name(HIGH).value(numCol.getHigh());
      writer.endObject();
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
   */
  @Override
  public Column read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    ColumnType type = ColumnType.TEXT;
    Goal goal = null;
    Boolean objective = null;

    String key = null, format = null, description = null, fullName = null, low = null, high = null;
    Double significantGain = null, significantLoss = null, insignificantLoss = null;

    List<String> categoricalRange = null, categoricalPreference = null;

    reader.beginObject();

    while (reader.hasNext()) {
      String name = reader.nextName();

      if (name.equals(TYPE2)) {
        type = ColumnType.fromString(reader.nextString());
      } else if (name.equals(KEY)) {
        key = reader.nextString();
      } else if (name.equals(GOAL)) {
        goal = Goal.fromString(reader.nextString());
      } else if (name.equals(IS_OBJECTIVE)) {
        objective = reader.nextBoolean();
      } else if (name.equals(FORMAT)) {
        format = reader.nextString();
      } else if (name.equals(DESCRIPTION)) {
        description = reader.nextString();
      } else if (name.equals(FULL_NAME)) {
        fullName = reader.nextString();
      } else if (name.equals(SIGNIFICANT_GAIN)) {
        significantGain = reader.nextDouble();
      } else if (name.equals(SIGNIFICANT_LOSS)) {
        significantLoss = reader.nextDouble();
      } else if (name.equals(INSIGNIFICANT_LOSS)) {
        insignificantLoss = reader.nextDouble();
      } else if (name.equals("preference")) {
        reader.beginArray();
        categoricalPreference = new ArrayList<String>();
        while (reader.hasNext()) {
          categoricalPreference.add(reader.nextString());
        }
        reader.endArray();
      } else if (name.equals(RANGE)) {
        if (reader.peek().equals(JsonToken.BEGIN_ARRAY)) {
          reader.beginArray();
          categoricalRange = new ArrayList<String>();
          while (reader.hasNext()) {
            categoricalRange.add(reader.nextString());
          }
          reader.endArray();
        } else {
          reader.beginObject();
          while (reader.hasNext()) {
            name = reader.nextName();
            if (name.equals(LOW)) {
              low = reader.nextString();
            } else if (name.equals(HIGH)) {
              high = reader.nextString();
            } else {
              reader.skipValue();
            }
          }
          reader.endObject();
        }
      } else {
        reader.skipValue();
      }
    }
    reader.endObject();

    Column column;
    if (type == ColumnType.CATEGORICAL) {
      column = new CategoricalColumn();
      if (categoricalRange != null) {
        ((CategoricalColumn) column).setRange(categoricalRange);
      }
      if (categoricalPreference != null) {
        ((CategoricalColumn) column).setRange(categoricalPreference);
      }
    } else if (type == ColumnType.DATETIME) {
      column = new DateColumn();
      if (low != null) {
        try {
          ((DateColumn) column).withRange(DATE_FORMATTER.parse(low), DATE_FORMATTER.parse(high));
        } catch (final ParseException e) {
          LOG.log(Level.SEVERE, "Error parsing the date", e);
        }
      }
    } else if (type == ColumnType.NUMERIC) {
      column = new NumericColumn();
      if (low != null) {
        ((NumericColumn) column).range(Double.valueOf(low), Double.valueOf(high));
      }
    } else {
      column = new TextColumn();
    }

    column.setKey(key);

    if (description != null) {
      column.setDescription(description);
    }

    if (format != null) {
      column.setFormat(format);
    }

    if (objective != null) {
      column.setObjective(objective);
    }

    if (fullName != null) {
      column.setFullName(fullName);
    }

    if (goal != null) {
      column.setGoal(goal);
    }

    if (key != null) {
      column.setKey(key);
    }

    if (significantGain != null) {
      column.setSignificantGain(significantGain);
    }

    if (significantLoss != null) {
      column.setSignificantLoss(insignificantLoss);
    }

    if (insignificantLoss != null) {
      column.setInsignificantLoss(insignificantLoss);
    }

    return column;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
   */
  @Override
  public void write(JsonWriter writer, Column column) throws IOException {
    writer.beginObject();

    writer.name(KEY).value(column.getKey());
    writer.name(TYPE2).value(column.getType().toString());

    if (column.getGoal() != null) {
      writer.name(GOAL).value(column.getGoal().toString());
    }

    if (column.isObjective() != null) {
      writer.name(IS_OBJECTIVE).value(column.isObjective());
    }

    if (column.getFormat() != null) {
      writer.name(FORMAT).value(column.getFormat());
    }

    if (column.getDescription() != null) {
      writer.name(DESCRIPTION).value(column.getDescription());
    }

    if (column.getFullName() != null) {
      writer.name(FULL_NAME).value(column.getFullName());
    }

    if (column.getSignificantGain() != null) {
      writer.name(SIGNIFICANT_GAIN).value(column.getSignificantGain());
    }

    if (column.getSignificantLoss() != null) {
      writer.name(SIGNIFICANT_LOSS).value(column.getSignificantLoss());
    }

    if (column.getInsignificantLoss() != null) {
      writer.name(INSIGNIFICANT_LOSS).value(column.getInsignificantLoss());
    }

    final ColumnType type = column.getType();

    // Categorical column
    switch (type) {
      case CATEGORICAL:
        writeCategoricalColumn((CategoricalColumn) column, writer);
        break;
      case NUMERIC:
        writeNumericalColumn((NumericColumn) column, writer);
        break;
      case DATETIME:
        writeDateColumn((DateColumn) column, writer);
        break;
      default:
        // text
        break;
    }

    writer.endObject();
    writer.flush();
  }
}
