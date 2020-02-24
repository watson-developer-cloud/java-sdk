/*
 * (C) Copyright IBM Corp. 2019, 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A webhook that can be used by dialog nodes to make programmatic calls to an external function.
 *
 * **Note:** Currently, only a single webhook named `main_webhook` is supported.
 */
public class Webhook extends GenericModel {

  protected String url;
  protected String name;
  protected List<WebhookHeader> headers;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String name;
    private List<WebhookHeader> headers;

    private Builder(Webhook webhook) {
      this.url = webhook.url;
      this.name = webhook.name;
      this.headers = webhook.headers;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     * @param name the name
     */
    public Builder(String url, String name) {
      this.url = url;
      this.name = name;
    }

    /**
     * Builds a Webhook.
     *
     * @return the webhook
     */
    public Webhook build() {
      return new Webhook(this);
    }

    /**
     * Adds an headers to headers.
     *
     * @param headers the new headers
     * @return the Webhook builder
     */
    public Builder addHeaders(WebhookHeader headers) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(headers,
          "headers cannot be null");
      if (this.headers == null) {
        this.headers = new ArrayList<WebhookHeader>();
      }
      this.headers.add(headers);
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the Webhook builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Webhook builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the headers.
     * Existing headers will be replaced.
     *
     * @param headers the headers
     * @return the Webhook builder
     */
    public Builder headers(List<WebhookHeader> headers) {
      this.headers = headers;
      return this;
    }
  }

  protected Webhook(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url,
        "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
        "name cannot be null");
    url = builder.url;
    name = builder.name;
    headers = builder.headers;
  }

  /**
   * New builder.
   *
   * @return a Webhook builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * The URL for the external service or application to which you want to send HTTP POST requests.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the name.
   *
   * The name of the webhook. Currently, `main_webhook` is the only supported value.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the headers.
   *
   * An optional array of HTTP headers to pass with the HTTP request.
   *
   * @return the headers
   */
  public List<WebhookHeader> headers() {
    return headers;
  }
}
