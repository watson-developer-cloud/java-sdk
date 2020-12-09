/*
 * (C) Copyright IBM Corp. 2020.
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

/** An object that describes a response with response type `search`. */
public class RuntimeResponseGenericRuntimeResponseTypeSearch extends RuntimeResponseGeneric {

  /**
   * The type of response returned by the dialog node. The specified response type must be supported
   * by the client application or channel.
   */
  public interface ResponseType {
    /** search. */
    String SEARCH = "search";
  }
}
