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

package com.ibm.watson.developer_cloud.tone_analyzer.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.ToneAnalyzer;

/**
 * Synonym Options when using the {@link ToneAnalyzer#getSynonyms(SynonymOptions)} method
 */
public class SynonymOptions extends GenericModel {

  private List<String> words;

  private List<String> traits;

  private Integer limit;

  private Integer hops;

  private List<String> context;

  private Integer index;

  /**
   * 
   * <pre>
   * new words(&quot;dog&quot;, &quot;cat&quot;, &quot;cow&quot;)
   * </pre>
   * 
   * @param words A list of words for which related words are to be looked up. Normally only one
   *        word is given, but multiple words can be passed.
   * @return the synonym options
   */
  public SynonymOptions words(String... words) {
    this.words = new ArrayList<String>();
    for (final String word : words) {
      this.words.add(word);
    }
    return this;
  }

  /**
   * Gets the words.
   * 
   * @return The words
   */
  public List<String> getWords() {
    return words;
  }

  /**
   * With words list
   * 
   * @param words the words
   * @return the synonym options
   */
  public SynonymOptions wordList(List<String> words) {
    this.words = words;
    return this;
  }

  /**
   * Gets the traits.
   * 
   * @return The traits
   */
  public List<String> getTraits() {
    return traits;
  }

  /**
   * With traits.
   * 
   * @param traits the traits
   * @return the synonym options
   */
  public SynonymOptions traits(List<String> traits) {
    this.traits = traits;
    return this;
  }

  /**
   * Gets the limit.
   * 
   * @return The limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * With limit.
   * 
   * @param limit the limit
   * @return the synonym options
   */
  public SynonymOptions limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Gets the hops.
   * 
   * @return The hops
   */
  public Integer getHops() {
    return hops;
  }

  /**
   * With hops.
   * 
   * @param hops the hops
   * @return the synonym options
   */
  public SynonymOptions hops(Integer hops) {
    this.hops = hops;
    return this;
  }

  /**
   * Gets the context.
   * 
   * @return The context
   */
  public List<String> getContext() {
    return context;
  }

  /**
   * With context.
   * 
   * @param context the context
   * @return the synonym options
   */
  public SynonymOptions context(List<String> context) {
    this.context = context;
    return this;
  }

  /**
   * Gets the index.
   * 
   * @return The index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * With index.
   * 
   * @param index the index
   * @return the synonym options
   */
  public SynonymOptions index(Integer index) {
    this.index = index;
    return this;
  }

}
