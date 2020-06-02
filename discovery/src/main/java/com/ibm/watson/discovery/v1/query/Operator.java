/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.discovery.v1.query;

/**
 * Query Language Operator Syntax.
 *
 * @deprecated This class has been replaced by the top-level version in
 *     com.ibm.watson.discovery.query.
 */
public enum Operator {

  /** The field separator. */
  FIELD_SEPARATOR("."),

  /** The equals. */
  EQUALS("::"),

  /** The contains. */
  CONTAINS(":"),

  /** The escape. */
  ESCAPE("\\"),

  /** The fuzzy. */
  FUZZY("~"),

  /** The or. */
  OR("|"),

  /** The and. */
  AND(","),

  /** The not. */
  NOT("!"),

  /** The nest aggregation. */
  NEST_AGGREGATION("."),

  /** The less than. */
  LESS_THAN("<"),

  /** The less than or equal to. */
  LESS_THAN_OR_EQUAL_TO("<="),

  /** The greater than. */
  GREATER_THAN(">"),

  /** The greater than or equal to. */
  GREATER_THAN_OR_EQUAL_TO(">="),

  /** The boost. */
  BOOST("^"),

  /** The wildcard. */
  WILDCARD("*", false),

  /** The opening grouping. */
  OPENING_GROUPING("("),

  /** The closing grouping. */
  CLOSING_GROUPING(")"),

  /** The opening array. */
  OPENING_ARRAY("["),

  /** The closing array. */
  CLOSING_ARRAY("]"),

  /** The double quote. */
  DOUBLE_QUOTE("\"");

  private final String symbol;
  private final boolean escape;

  /**
   * Instantiates a new operator.
   *
   * @param symbol the symbol
   */
  Operator(String symbol) {
    this(symbol, true);
  }

  /**
   * Instantiates a new operator.
   *
   * @param symbol the symbol
   * @param escape the escape
   */
  Operator(String symbol, boolean escape) {
    this.symbol = symbol;
    this.escape = escape;
  }

  /**
   * Gets the symbol.
   *
   * @return the symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Should escape.
   *
   * @return true, if successful
   */
  public boolean shouldEscape() {
    return escape;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return symbol;
  }
}
