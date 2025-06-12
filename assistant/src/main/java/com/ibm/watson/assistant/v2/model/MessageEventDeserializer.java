/*
 * (C) Copyright IBM Corp. 2024, 2025.
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

import com.google.gson.Gson;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.MessageEvent;
import java.io.InputStream;
import java.util.Iterator;

public class MessageEventDeserializer extends MessageStreamResponse {

  protected EventSource eventSource;

  /** Builder. */
  public static class Builder {
    private EventSource eventSource;

    /**
     * Instantiates a new Builder from an existing MessageEventDeserializer instance.
     *
     * @param messageEventDeserializer the instance to initialize the Builder with
     */
    private Builder(MessageEventDeserializer messageEventDeserializer) {
      this.eventSource = messageEventDeserializer.eventSource;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param inputStream the inputStream
     */
    public Builder(InputStream inputStream) {
      InputStreamConnectStrategy inputStreamConnectStrategy =
          new InputStreamConnectStrategy.Builder().inputStream(inputStream).build();
      this.eventSource = new EventSource.Builder(inputStreamConnectStrategy).build();
    }

    /**
     * Builds a MessageEventDeserializer.
     *
     * @return the new MessageEventDeserializer instance
     */
    public MessageEventDeserializer build() {
      return new MessageEventDeserializer(this);
    }

    /**
     * Set the inputStream.
     *
     * @param inputStream the inputStream
     * @return the MessageEventDeserializer builder
     */
    public MessageEventDeserializer.Builder inputStream(InputStream inputStream) {
      InputStreamConnectStrategy inputStreamConnectStrategy =
          new InputStreamConnectStrategy.Builder().inputStream(inputStream).build();
      this.eventSource = new EventSource.Builder(inputStreamConnectStrategy).build();
      return this;
    }
  }

  protected MessageEventDeserializer() {}

  protected MessageEventDeserializer(MessageEventDeserializer.Builder builder) {
    eventSource = builder.eventSource;
  }

  /**
   * New builder.
   *
   * @return a MessageEventDeserializer builder
   */
  public MessageEventDeserializer.Builder newBuilder() {
    return new MessageEventDeserializer.Builder(this);
  }

  public Iterable<MessageStreamResponse> messages() {
    return () -> new IteratorImpl<>(eventSource.messages());
  }

  public Iterable<StatelessMessageStreamResponse> statelessMessages() {
    return () -> new StatelessIteratorImpl<>(eventSource.messages());
  }

  private class IteratorImpl<T extends MessageStreamResponse> implements Iterator<T> {
    private final Iterable<MessageEvent> messageEvents;

    IteratorImpl(Iterable<MessageEvent> messageEvents) {
      this.messageEvents = messageEvents;
    }

    public boolean hasNext() {
      return messageEvents.iterator().hasNext();
    }

    public T next() {
      Gson gson = new Gson();
      MessageEvent messageEvent = messageEvents.iterator().next();
      T item = (T) gson.fromJson(messageEvent.getData(), MessageStreamResponse.class);
      return item;
    }
  }

  private class StatelessIteratorImpl<T extends StatelessMessageStreamResponse>
      implements Iterator<T> {
    private final Iterable<MessageEvent> messageEvents;

    StatelessIteratorImpl(Iterable<MessageEvent> messageEvents) {
      this.messageEvents = messageEvents;
    }

    public boolean hasNext() {
      return messageEvents.iterator().hasNext();
    }

    public T next() {
      Gson gson = new Gson();
      MessageEvent messageEvent = messageEvents.iterator().next();
      T item = (T) gson.fromJson(messageEvent.getData(), StatelessMessageStreamResponse.class);
      return item;
    }
  }
}
