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

import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.logging.LDLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class InputStreamConnectStrategy extends ConnectStrategy {

  protected InputStream inputStream;

  /** Builder. */
  public static class Builder {
    private InputStream inputStream;

    /**
     * Instantiates a new Builder from an existing InputStreamConnectStrategy instance.
     *
     * @param inputStreamConnectStrategy the instance to initialize the Builder with
     */
    private Builder(InputStreamConnectStrategy inputStreamConnectStrategy) {
      this.inputStream = inputStreamConnectStrategy.inputStream;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param inputStream the inputStream
     */
    public Builder(InputStream inputStream) {
      this.inputStream = inputStream;
    }

    /**
     * Builds a InputStreamConnectStrategy.
     *
     * @return the new InputStreamConnectStrategy instance
     */
    public InputStreamConnectStrategy build() {
      return new InputStreamConnectStrategy(this);
    }

    /**
     * Set the inputStream.
     *
     * @param inputStream the inputStream
     * @return the InputStreamConnectStrategy builder
     */
    public Builder inputStream(InputStream inputStream) {
      this.inputStream = inputStream;
      return this;
    }
  }

  protected InputStreamConnectStrategy() {}

  protected InputStreamConnectStrategy(Builder builder) {
    inputStream = builder.inputStream;
  }

  /**
   * New builder.
   *
   * @return a InputStreamConnectStrategy builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the inputStream.
   *
   * @return the inputStream
   */
  public InputStream inputStream() {
    return inputStream;
  }

  @Override
  public Client createClient(LDLogger ldLogger) {
    Client client =
        new Client() {
          @Override
          public Result connect(String s) throws StreamException {
            Result result = new Result(inputStream, null, inputStream);
            return result;
          }

          @Override
          public boolean awaitClosed(long l) throws InterruptedException {
            return false;
          }

          @Override
          public URI getOrigin() {
            return null;
          }

          @Override
          public void close() throws IOException {
            inputStream.close();
          }
        };
    return client;
  }
}
