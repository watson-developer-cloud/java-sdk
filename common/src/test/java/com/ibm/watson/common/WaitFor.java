package com.ibm.watson.common;

import java.util.concurrent.TimeUnit;

/**
 * Wait for a certain condition to be true or for a timeout to expire.
 *
 */

public class WaitFor {

  private WaitFor() {

  }

  /**
   * Static method used to wait for a specific condition to be satisfied.
   *
   * @param condition The condition to check
   * @param time The maximum time to wait for the condition to become true
   * @param unit The time unit of the {@code time} argument
   * @param sleepMs The time to wait between checks
   *
   * @return true if the condition was true before the timeout, false if it wasn't.
   */
  public static boolean waitFor(Condition condition, long time, TimeUnit unit, long sleepMs) {
    long waitMs = unit.toMillis(time);
    long startMs = System.currentTimeMillis();
    while (System.currentTimeMillis() - startMs < waitMs) {
      if (condition.isSatisfied()) {
        return true;
      }
      try {
        Thread.sleep(sleepMs);
      } catch (InterruptedException e) {
        throw new RuntimeException("WaitFor aborted", e);
      }
    }
    return false;
  }

  /**
   * The Interface Condition.
   */
  public interface Condition {
    /**
     * @return true/false indicating whether or not the condition has been met.
     */
    boolean isSatisfied();
  }
}
