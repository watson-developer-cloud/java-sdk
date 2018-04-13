package com.ibm.watson.developer_cloud.http;

import java.util.List;
import java.util.Set;

/**
 * Wrapper class for the internal HTTP headers class.
 */
public class Headers {

  private okhttp3.Headers headers;

  public Headers(okhttp3.Headers headers) {
    this.headers = headers;
  }

  /**
   * Returns true if other is a Headers object with the same headers, with the same casing, in the same order.
   *
   * @param other the other object to compare
   * @return whether the two objects are equal or not
   */
  public boolean equals(Object other) {
    return this.headers.equals(other);
  }

  public int hashCode() {
    return this.headers.hashCode();
  }

  public String toString() {
    return this.headers.toString();
  }

  /**
   * Returns an immutable, case-insensitive set of header names.
   *
   * @return the list of header names
   */
  public Set<String> names() {
    return this.headers.names();
  }

  /**
   * Returns an immutable list of the header values for the specified name.
   *
   * @param name the name of the specified header
   * @return the values associated with the name
   */
  public List<String> values(String name) {
    return this.headers.values(name);
  }
}
