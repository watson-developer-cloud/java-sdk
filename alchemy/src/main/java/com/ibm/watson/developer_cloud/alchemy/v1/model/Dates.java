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
package com.ibm.watson.developer_cloud.alchemy.v1.model;

import java.util.Date;
import java.util.List;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Extracted dates by the {@link AlchemyLanguage#getDates(java.util.Map)} method.
 */
public class Dates extends AlchemyLanguageGenericModel {

  /**
   * The date along with the text from where the date was extracted.
   */
  public static class ExtractedDate extends GenericModel {

    private Date date;
    private String text;

    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
      return date;
    }

    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
      return text;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
      this.date = date;
    }

    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text) {
      this.text = text;
    }

  }

  private List<ExtractedDate> dates;

  private String text;

  /**
   * Gets the dates.
   *
   * @return the dates
   */
  public List<ExtractedDate> getDates() {
    return dates;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the dates.
   *
   * @param dates the new dates
   */
  public void setDates(List<ExtractedDate> dates) {
    this.dates = dates;
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

}
