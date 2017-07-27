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

package com.ibm.watson.developer_cloud.discovery.v1.query;

/**
 * Query Language Operator Syntax.
 */
public enum Operator {
  FIELD_SEPARATOR("."), EQUALS("::"), CONTAINS(":"), ESCAPE("\\"), FUZZY("~"), OR("|"), AND(","), NOT(
      "!"), NEST_AGGREGATION("."), LESS_THAN("<"), LESS_THAN_OR_EQUAL_TO("<="), GREATER_THAN(
          ">"), GREATER_THAN_OR_EQUAL_TO(">="), BOOST("^"), WILDCARD("*", false), OPENING_GROUPING(
              "("), CLOSING_GROUPING(")"), OPENING_ARRAY("["), CLOSING_ARRAY("]"), DOUBLE_QUOTE("\"");

  private final String symbol;
  private final boolean escape;

  Operator(String symbol) {
    this(symbol, true);
  }

  Operator(String symbol, boolean escape) {
    this.symbol = symbol;
    this.escape = escape;
  }

  public String getSymbol() {
    return symbol;
  }

  public boolean shouldEscape() {
    return escape;
  }

  @Override
  public String toString() {
    return symbol;
  }
}
