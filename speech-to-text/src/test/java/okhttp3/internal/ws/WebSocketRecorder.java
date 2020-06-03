/*
 * Copyright (C) 2016 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okhttp3.internal.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.ByteString;

/** The Class WebSocketRecorder. */
public final class WebSocketRecorder extends WebSocketListener {
  private final String name;
  private final BlockingQueue<Object> events = new LinkedBlockingQueue<>();
  private WebSocketListener delegate;

  /**
   * Instantiates a new web socket recorder.
   *
   * @param name the name
   */
  public WebSocketRecorder(String name) {
    this.name = name;
  }

  /**
   * Sets a delegate for handling the next callback to this listener. Cleared after invoked.
   *
   * @param delegate the delegate to be set
   */
  public void setNextEventDelegate(WebSocketListener delegate) {
    this.delegate = delegate;
  }

  /**
   * On open.
   *
   * @param webSocket the web socket
   * @param response the response
   */
  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    Platform.get().log(Platform.INFO, "[WS " + name + "] onOpen", null);

    WebSocketListener delegate = this.delegate;
    if (delegate != null) {
      this.delegate = null;
      delegate.onOpen(webSocket, response);
    } else {
      events.add(new Open(webSocket, response));
    }
  }

  /**
   * On message.
   *
   * @param webSocket the web socket
   * @param bytes the bytes
   */
  @Override
  public void onMessage(WebSocket webSocket, ByteString bytes) {
    Platform.get().log(Platform.INFO, "[WS " + name + "] onMessage", null);

    WebSocketListener delegate = this.delegate;
    if (delegate != null) {
      this.delegate = null;
      delegate.onMessage(webSocket, bytes);
    } else {
      Message event = new Message(bytes);
      events.add(event);
    }
  }

  /**
   * On message.
   *
   * @param webSocket the web socket
   * @param text the text
   */
  @Override
  public void onMessage(WebSocket webSocket, String text) {
    Platform.get().log(Platform.INFO, "[WS " + name + "] onMessage", null);

    WebSocketListener delegate = this.delegate;
    if (delegate != null) {
      this.delegate = null;
      delegate.onMessage(webSocket, text);
    } else {
      Message event = new Message(text);
      events.add(event);
    }
  }

  /**
   * On closing.
   *
   * @param webSocket the web socket
   * @param code the code
   * @param reason the reason
   */
  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    Platform.get().log(Platform.INFO, "[WS " + name + "] onClose " + code, null);

    WebSocketListener delegate = this.delegate;
    if (delegate != null) {
      this.delegate = null;
      delegate.onClosing(webSocket, code, reason);
    } else {
      events.add(new Closing(code, reason));
    }
  }

  /**
   * On closed.
   *
   * @param webSocket the web socket
   * @param code the code
   * @param reason the reason
   */
  @Override
  public void onClosed(WebSocket webSocket, int code, String reason) {
    Platform.get().log(Platform.INFO, "[WS " + name + "] onClose " + code, null);

    WebSocketListener delegate = this.delegate;
    if (delegate != null) {
      this.delegate = null;
      delegate.onClosed(webSocket, code, reason);
    } else {
      events.add(new Closed(code, reason));
    }
  }

  /**
   * On failure.
   *
   * @param webSocket the web socket
   * @param t the t
   * @param response the response
   */
  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    Platform.get().log(Platform.INFO, "[WS " + name + "] onFailure", t);

    WebSocketListener delegate = this.delegate;
    if (delegate != null) {
      this.delegate = null;
      delegate.onFailure(webSocket, t, response);
    } else {
      events.add(new Failure(t, response));
    }
  }

  private Object nextEvent() {
    try {
      Object event = events.poll(10, TimeUnit.SECONDS);
      if (event == null) {
        throw new AssertionError("Timed out waiting for event.");
      }
      return event;
    } catch (InterruptedException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * Assert text message.
   *
   * @param payload the payload
   */
  public void assertTextMessage(String payload) {
    Object actual = nextEvent();
    assertEquals(new Message(payload), actual);
  }

  /**
   * Assert binary message.
   *
   * @param payload the payload
   */
  public void assertBinaryMessage(ByteString payload) {
    Object actual = nextEvent();
    assertEquals(new Message(payload), actual);
  }

  /**
   * Assert ping.
   *
   * @param payload the payload
   */
  public void assertPing(ByteString payload) {
    Object actual = nextEvent();
    assertEquals(new Ping(payload), actual);
  }

  /**
   * Assert pong.
   *
   * @param payload the payload
   */
  public void assertPong(ByteString payload) {
    Object actual = nextEvent();
    assertEquals(new Pong(payload), actual);
  }

  /**
   * Assert closing.
   *
   * @param code the code
   * @param reason the reason
   */
  public void assertClosing(int code, String reason) {
    Object actual = nextEvent();
    assertEquals(new Closing(code, reason), actual);
  }

  /**
   * Assert closed.
   *
   * @param code the code
   * @param reason the reason
   */
  public void assertClosed(int code, String reason) {
    Object actual = nextEvent();
    assertEquals(new Closed(code, reason), actual);
  }

  /** Assert exhausted. */
  public void assertExhausted() {
    assertTrue("Remaining events: " + events, events.isEmpty());
  }

  /**
   * Assert open.
   *
   * @return the web socket
   */
  public WebSocket assertOpen() {
    Object event = nextEvent();
    if (!(event instanceof Open)) {
      throw new AssertionError("Expected Open but was " + event);
    }
    return ((Open) event).webSocket;
  }

  /**
   * Assert failure.
   *
   * @param t the t
   */
  public void assertFailure(Throwable t) {
    Object event = nextEvent();
    if (!(event instanceof Failure)) {
      throw new AssertionError("Expected Failure but was " + event);
    }
    Failure failure = (Failure) event;
    assertNull(failure.response);
    assertSame(t, failure.t);
  }

  /**
   * Assert failure.
   *
   * @param cls the cls
   * @param message the message
   */
  public void assertFailure(Class<? extends IOException> cls, String message) {
    Object event = nextEvent();
    if (!(event instanceof Failure)) {
      throw new AssertionError("Expected Failure but was " + event);
    }
    Failure failure = (Failure) event;
    assertNull(failure.response);
    assertEquals(cls, failure.t.getClass());
    assertEquals(message, failure.t.getMessage());
  }

  /** Assert failure. */
  public void assertFailure() {
    Object event = nextEvent();
    if (!(event instanceof Failure)) {
      throw new AssertionError("Expected Failure but was " + event);
    }
  }

  /**
   * Assert failure.
   *
   * @param code the code
   * @param body the body
   * @param cls the cls
   * @param message the message
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public void assertFailure(int code, String body, Class<? extends IOException> cls, String message)
      throws IOException {
    Object event = nextEvent();
    if (!(event instanceof Failure)) {
      throw new AssertionError("Expected Failure but was " + event);
    }
    Failure failure = (Failure) event;
    assertEquals(code, failure.response.code());
    if (body != null) {
      assertEquals(body, failure.responseBody);
    }
    assertEquals(cls, failure.t.getClass());
    assertEquals(message, failure.t.getMessage());
  }

  /**
   * Expose this recorder as a frame callback and shim in "ping" events.
   *
   * @return the frame callback for the WebSocket reader
   */
  public WebSocketReader.FrameCallback asFrameCallback() {
    return new WebSocketReader.FrameCallback() {
      @Override
      public void onReadMessage(String text) throws IOException {
        onMessage(null, text);
      }

      @Override
      public void onReadMessage(ByteString bytes) throws IOException {
        onMessage(null, bytes);
      }

      @Override
      public void onReadPing(ByteString payload) {
        events.add(new Ping(payload));
      }

      @Override
      public void onReadPong(ByteString payload) {
        events.add(new Pong(payload));
      }

      @Override
      public void onReadClose(int code, String reason) {
        onClosing(null, code, reason);
      }
    };
  }

  /** The Class Open. */
  static final class Open {

    /** The web socket. */
    final WebSocket webSocket;

    /** The response. */
    final Response response;

    /**
     * Instantiates a new open.
     *
     * @param webSocket the web socket
     * @param response the response
     */
    Open(WebSocket webSocket, Response response) {
      this.webSocket = webSocket;
      this.response = response;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "Open[" + response + "]";
    }
  }

  /** The Class Failure. */
  static final class Failure {

    /** The t. */
    final Throwable t;

    /** The response. */
    final Response response;

    /** The response body. */
    final String responseBody;

    /**
     * Instantiates a new failure.
     *
     * @param t the t
     * @param response the response
     */
    Failure(Throwable t, Response response) {
      this.t = t;
      this.response = response;
      String responseBody = null;
      if (response != null) {
        try {
          responseBody = response.body().string();
        } catch (IOException ignored) {
        }
      }
      this.responseBody = responseBody;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      if (response == null) {
        return "Failure[" + t + "]";
      }
      return "Failure[" + response + "]";
    }
  }

  /** The Class Message. */
  static final class Message {

    /** The bytes. */
    public final ByteString bytes;

    /** The string. */
    public final String string;

    /**
     * Instantiates a new message.
     *
     * @param bytes the bytes
     */
    Message(ByteString bytes) {
      this.bytes = bytes;
      this.string = null;
    }

    /**
     * Instantiates a new message.
     *
     * @param string the string
     */
    Message(String string) {
      this.bytes = null;
      this.string = string;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "Message[" + (bytes != null ? bytes : string) + "]";
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
      return (bytes != null ? bytes : string).hashCode();
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true, if successful
     */
    @Override
    public boolean equals(Object other) {
      return other instanceof Message
          && Util.equal(((Message) other).bytes, bytes)
          && Util.equal(((Message) other).string, string);
    }
  }

  /** The Class Ping. */
  static final class Ping {

    /** The payload. */
    public final ByteString payload;

    /**
     * Instantiates a new ping.
     *
     * @param payload the payload
     */
    Ping(ByteString payload) {
      this.payload = payload;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "Ping[" + payload + "]";
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
      return payload.hashCode();
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true, if successful
     */
    @Override
    public boolean equals(Object other) {
      return other instanceof Ping && ((Ping) other).payload.equals(payload);
    }
  }

  /** The Class Pong. */
  static final class Pong {

    /** The payload. */
    public final ByteString payload;

    /**
     * Instantiates a new pong.
     *
     * @param payload the payload
     */
    Pong(ByteString payload) {
      this.payload = payload;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "Pong[" + payload + "]";
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
      return payload.hashCode();
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true, if successful
     */
    @Override
    public boolean equals(Object other) {
      return other instanceof Pong && ((Pong) other).payload.equals(payload);
    }
  }

  /** The Class Closing. */
  static final class Closing {

    /** The code. */
    public final int code;

    /** The reason. */
    public final String reason;

    /**
     * Instantiates a new closing.
     *
     * @param code the code
     * @param reason the reason
     */
    Closing(int code, String reason) {
      this.code = code;
      this.reason = reason;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "Closing[" + code + " " + reason + "]";
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
      return code * 37 + reason.hashCode();
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true, if successful
     */
    @Override
    public boolean equals(Object other) {
      return other instanceof Closing
          && ((Closing) other).code == code
          && ((Closing) other).reason.equals(reason);
    }
  }

  /** The Class Closed. */
  static final class Closed {

    /** The code. */
    public final int code;

    /** The reason. */
    public final String reason;

    /**
     * Instantiates a new closed.
     *
     * @param code the code
     * @param reason the reason
     */
    Closed(int code, String reason) {
      this.code = code;
      this.reason = reason;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "Closed[" + code + " " + reason + "]";
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
      return code * 37 + reason.hashCode();
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true, if successful
     */
    @Override
    public boolean equals(Object other) {
      return other instanceof Closed
          && ((Closed) other).code == code
          && ((Closed) other).reason.equals(reason);
    }
  }
}
