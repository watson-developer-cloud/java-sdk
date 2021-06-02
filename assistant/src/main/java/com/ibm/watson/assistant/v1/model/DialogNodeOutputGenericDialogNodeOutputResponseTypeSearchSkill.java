/*
 * (C) Copyright IBM Corp. 2020, 2021.
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
package com.ibm.watson.assistant.v1.model;

import java.util.ArrayList;
import java.util.List;

/** DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill. */
public class DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill
    extends DialogNodeOutputGeneric {

  /** The type of the search query. */
  public interface QueryType {
    /** natural_language. */
    String NATURAL_LANGUAGE = "natural_language";
    /** discovery_query_language. */
    String DISCOVERY_QUERY_LANGUAGE = "discovery_query_language";
  }

  /** Builder. */
  public static class Builder {
    private String responseType;
    private String query;
    private String queryType;
    private String filter;
    private String discoveryVersion;
    private List<ResponseGenericChannel> channels;

    public Builder(
        DialogNodeOutputGeneric dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill) {
      this.responseType =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.responseType;
      this.query = dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.query;
      this.queryType = dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.queryType;
      this.filter = dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.filter;
      this.discoveryVersion =
          dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.discoveryVersion;
      this.channels = dialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.channels;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param responseType the responseType
     * @param query the query
     * @param queryType the queryType
     */
    public Builder(String responseType, String query, String queryType) {
      this.responseType = responseType;
      this.query = query;
      this.queryType = queryType;
    }

    /**
     * Builds a DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.
     *
     * @return the new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill instance
     */
    public DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill build() {
      return new DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill(this);
    }

    /**
     * Adds an channels to channels.
     *
     * @param channels the new channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder addChannels(ResponseGenericChannel channels) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(channels, "channels cannot be null");
      if (this.channels == null) {
        this.channels = new ArrayList<ResponseGenericChannel>();
      }
      this.channels.add(channels);
      return this;
    }

    /**
     * Set the responseType.
     *
     * @param responseType the responseType
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder responseType(String responseType) {
      this.responseType = responseType;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the queryType.
     *
     * @param queryType the queryType
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder queryType(String queryType) {
      this.queryType = queryType;
      return this;
    }

    /**
     * Set the filter.
     *
     * @param filter the filter
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder filter(String filter) {
      this.filter = filter;
      return this;
    }

    /**
     * Set the discoveryVersion.
     *
     * @param discoveryVersion the discoveryVersion
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder discoveryVersion(String discoveryVersion) {
      this.discoveryVersion = discoveryVersion;
      return this;
    }

    /**
     * Set the channels. Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
     */
    public Builder channels(List<ResponseGenericChannel> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.responseType, "responseType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.query, "query cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.queryType, "queryType cannot be null");
    responseType = builder.responseType;
    query = builder.query;
    queryType = builder.queryType;
    filter = builder.filter;
    discoveryVersion = builder.discoveryVersion;
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
