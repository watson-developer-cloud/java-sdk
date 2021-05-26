/*
 * (C) Copyright IBM Corp. 2018, 2021.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DialogNodeOutputGeneric.
 *
 * <p>Classes which extend this class: - DialogNodeOutputGenericDialogNodeOutputResponseTypeText -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypePause -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeImage -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeOption -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer -
 * DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined
 */
public class DialogNodeOutputGeneric extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "response_type";

  protected static java.util.Map<String, Class<?>> discriminatorMapping;

  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put(
        "channel_transfer",
        DialogNodeOutputGenericDialogNodeOutputResponseTypeChannelTransfer.class);
    discriminatorMapping.put(
        "connect_to_agent",
        DialogNodeOutputGenericDialogNodeOutputResponseTypeConnectToAgent.class);
    discriminatorMapping.put(
        "image", DialogNodeOutputGenericDialogNodeOutputResponseTypeImage.class);
    discriminatorMapping.put(
        "option", DialogNodeOutputGenericDialogNodeOutputResponseTypeOption.class);
    discriminatorMapping.put(
        "pause", DialogNodeOutputGenericDialogNodeOutputResponseTypePause.class);
    discriminatorMapping.put(
        "search_skill", DialogNodeOutputGenericDialogNodeOutputResponseTypeSearchSkill.class);
    discriminatorMapping.put("text", DialogNodeOutputGenericDialogNodeOutputResponseTypeText.class);
    discriminatorMapping.put(
        "user_defined", DialogNodeOutputGenericDialogNodeOutputResponseTypeUserDefined.class);
  }

  /** How a response is selected from the list, if more than one response is specified. */
  public interface SelectionPolicy {
    /** sequential. */
    String SEQUENTIAL = "sequential";
    /** random. */
    String RANDOM = "random";
    /** multiline. */
    String MULTILINE = "multiline";
  }

  /** The preferred type of control to display, if supported by the channel. */
  public interface Preference {
    /** dropdown. */
    String DROPDOWN = "dropdown";
    /** button. */
    String BUTTON = "button";
  }

  /** The type of the search query. */
  public interface QueryType {
    /** natural_language. */
    String NATURAL_LANGUAGE = "natural_language";
    /** discovery_query_language. */
    String DISCOVERY_QUERY_LANGUAGE = "discovery_query_language";
  }

  protected DialogNodeOutputGeneric() {}
}
