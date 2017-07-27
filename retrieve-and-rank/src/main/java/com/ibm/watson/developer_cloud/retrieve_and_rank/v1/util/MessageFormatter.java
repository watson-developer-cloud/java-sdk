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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Class MessageFormatter.
 */
public class MessageFormatter {
  private final ResourceBundle rb;

  /**
   * Instantiates a new message formatter.
   *
   * @param bundleName the bundle name
   */
  public MessageFormatter(String bundleName) {
    rb = ResourceBundle.getBundle(bundleName, Locale.getDefault());
  }

  /**
   * Format.
   *
   * @param key the key
   * @param args the args
   * @return the string
   */
  public String format(BundleKey key, Object... args) {
    return MessageFormat.format(rb.getString(key.toString()), args);
  }
}
