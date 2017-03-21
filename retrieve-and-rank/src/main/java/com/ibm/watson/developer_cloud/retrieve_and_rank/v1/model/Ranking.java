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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * {@link Ranking} used by the {@link RetrieveAndRank} class.
 *
 * @version v1
 */
public class Ranking extends GenericModel {

  /** The id. */
  @SerializedName("ranker_id")
  private String id;

  /** The name. */
  @SerializedName("name")
  private String name;

  /** The url. */
  @SerializedName("url")
  private String url;

  /** The top answer. */
  @SerializedName("top_answer")
  private String topAnswer;

  /** The ranked answers. */
  @SerializedName("answers")
  private List<RankedAnswer> answers;

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the top answer.
   *
   * @param topAnswer the new top answer
   */
  public void setTopAnswer(String topAnswer) {
    this.topAnswer = topAnswer;
  }

  /**
   * Sets the answers.
   *
   * @param answers the new answers
   */
  public void setAnswers(List<RankedAnswer> answers) {
    this.answers = answers;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
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
   * Gets the top answer.
   *
   * @return the top answer
   */
  public String getTopAnswer() {
    return topAnswer;
  }

  /**
   * Gets the answers.
   *
   * @return the answers
   */
  public List<RankedAnswer> getAnswers() {
    return answers;
  }
}
