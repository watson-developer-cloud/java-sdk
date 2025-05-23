/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.watson.assistant.v2.model;

/** MessageOutputDebugTurnEventTurnEventGenerativeAICalled. */
public class MessageOutputDebugTurnEventTurnEventGenerativeAICalled
    extends MessageOutputDebugTurnEvent {

  protected Object source;

  protected TurnEventGenerativeAICalledCallout callout;

  protected MessageOutputDebugTurnEventTurnEventGenerativeAICalled() {}

  /**
  * Gets the source.
  *
  * @return the source
  */
  public Object getSource() {
    return source;
  }

  /**
   * Gets the callout.
   *
   * @return the callout
   */
  public TurnEventGenerativeAICalledCallout getCallout() {
    return callout;
  }
}
