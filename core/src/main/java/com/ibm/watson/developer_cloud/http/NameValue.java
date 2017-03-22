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
package com.ibm.watson.developer_cloud.http;

import com.ibm.watson.developer_cloud.util.Validator;

/**
 * A name / value pair parameter used as an element of HTTP messages.
 *
 * <pre>
 * parameter = attribute "=" value
 * attribute = token
 * value     = token | quoted-string
 * </pre>
 *
 */
public class NameValue {

  /** The name. */
  private final String name;

  /** The value. */
  private final String value;

  /**
   * Default Constructor taking a name and a value. The value may be null.
   *
   * @param name The name.
   * @param value The value.
   */
  public NameValue(final String name, final String value) {
    super();
    Validator.notNull(name, "name cannot be null");

    this.name = name;
    this.value = value;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    NameValue nameValue = (NameValue) o;

    if (!name.equals(nameValue.name)) {
      return false;
    }
    return value != null ? value.equals(nameValue.value) : nameValue.value == null;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + name.hashCode();
    result = (prime * result) + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {

    if (value == null) {
      return name;
    } else {
      return name + "=" + value;
    }
  }

}
