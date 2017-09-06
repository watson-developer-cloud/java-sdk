/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Ignore;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.ibm.watson.developer_cloud.service.exception.TooManyRequestsException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;

/**
 * Junit Runner that retry tests. Useful when tests could fail due to network issues.
 */
public class RetryRunner extends BlockJUnit4ClassRunner {
  private static final Logger LOG = Logger.getLogger(RetryRunner.class.getName());

  private static final int RETRY_COUNT = 3;

  /**
   * Delay factor when tests are failing.
   */
  private static final int RETRY_DELAY_FACTOR = 2000;

  /**
   * Instantiates a new retry runner.
   *
   * @param clazz the class
   * @throws InitializationError the initialization error
   */
  public RetryRunner(Class<?> clazz) throws InitializationError {
    super(clazz);
  }

  /*
   * (non-Javadoc)
   *
   * @see org.junit.runners.ParentRunner#run(org.junit.runner.notification.RunNotifier)
   */
  @Override
  public void run(final RunNotifier notifier) {
    EachTestNotifier testNotifier = new EachTestNotifier(notifier, getDescription());
    Statement statement = classBlock(notifier);
    try {
      statement.evaluate();
    } catch (AssumptionViolatedException ave) {
      testNotifier.fireTestIgnored();
    } catch (StoppedByUserException sbue) {
      throw sbue;
    } catch (Throwable t) {
      LOG.warning("Retry class: " + getDescription().getDisplayName());
      retry(testNotifier, statement, t, getDescription());
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see org.junit.runners.BlockJUnit4ClassRunner#runChild(org.junit.runners.model.FrameworkMethod,
   * org.junit.runner.notification.RunNotifier)
   */
  @Override
  protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
    Description description = describeChild(method);
    if (method.getAnnotation(Ignore.class) != null) {
      notifier.fireTestIgnored(description);
    } else {
      runTest(methodBlock(method), description, notifier);
    }
  }

  private void runTest(Statement statement, Description description, RunNotifier notifier) {
    EachTestNotifier eachNotifier = new EachTestNotifier(notifier, description);
    eachNotifier.fireTestStarted();
    try {
      statement.evaluate();
    } catch (AssumptionViolatedException e) {
      eachNotifier.addFailedAssumption(e);
    } catch (Throwable e) {
      LOG.warning("Retry test: " + description.getDisplayName());
      retry(eachNotifier, statement, e, description);
    } finally {
      eachNotifier.fireTestFinished();
    }
  }

  private void retry(EachTestNotifier notifier, Statement statement, Throwable currentThrowable, Description info) {
    int failedAttempts = 0;
    Throwable caughtThrowable = currentThrowable;
    while (RETRY_COUNT > failedAttempts) {
      try {
        LOG.warning("Retry attempt " + (failedAttempts + 1) + " for " + info.getDisplayName());
        statement.evaluate();
        return;
      } catch (UnauthorizedException ue) {
        LOG.log(Level.WARNING, "Do not retry test failures due to UnauthorizedException", ue);
        failedAttempts = RETRY_COUNT;
      } catch (TooManyRequestsException e) {
        LOG.log(Level.WARNING, "Ignoring test failures due to rate limitation", e);
        return;
      } catch (Throwable t) {
        failedAttempts++;
        try {
          // GERMAN: Delay test failures to prevent network/service hiccups
          Thread.sleep(RETRY_DELAY_FACTOR * failedAttempts);
        } catch (InterruptedException e) {
          LOG.log(Level.WARNING, "The thread used by JUnit was interrupted", e);
        }
        caughtThrowable = t;
      }
    }
    notifier.addFailure(caughtThrowable);
  }
}
