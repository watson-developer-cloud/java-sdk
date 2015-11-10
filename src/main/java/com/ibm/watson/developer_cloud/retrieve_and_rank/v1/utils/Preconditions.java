/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import static org.apache.commons.lang3.StringUtils.*;

import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Reusable general-purpose precondition checks.
 */

public final class Preconditions {
    private static final MessageFormatter MSGS = new MessageFormatter(bundleName());

    private Preconditions() {
        // Should not be instantiated
    }

    /**
     * Ensures that the object passed as a parameter to the calling method is not null.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentNotNull(Object argument, String argumentName) {
        checkArgument(argument != null, MSGS.format(NOT_NULL_1, argumentName));
    }

    /**
     * Ensures that the string passed as a parameter to the calling method is neither null nor empty.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentNotEmpty(CharSequence argument, String argumentName) {
        checkArgument(isNotEmpty(argument), MSGS.format(NOT_EMPTY_1, argumentName));
    }

    /**
     * Ensures that the string passed as a parameter to the calling method is not null, empty and not only whitespace.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentNotBlank(CharSequence argument, String argumentName) {
        checkArgument(isNotBlank(argument), MSGS.format(NOT_BLANK_1, argumentName));
    }

    /**
     * Ensures that the string passed as a parameter to the calling method does not contain the given character.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param argumentName
     *            the name of the argument, used for reporting errors
     * @param charToNotContain
     *            the name of the character to not contain
     */
    public static void checkArgumentDoesNotContain(CharSequence argument, String argumentName, char charToNotContain) {
        checkArgument(!StringUtils.contains(argument, charToNotContain),
                MSGS.format(CANNOT_CONTAIN_2, argumentName, charToNotContain));
    }

    /**
     * Ensures that the collection passed as a parameter to the calling method is neither null nor empty.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentNotEmpty(Collection<?> argument, String argumentName) {
        checkArgumentNotNull(argument, argumentName);
        checkArgument(!argument.isEmpty(), MSGS.format(NOT_EMPTY_1, argumentName));
    }

    /**
     * Ensures that the integer passed as a parameter to the calling method is at least a minimum value.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param atLeast
     *            the minimum value allowed for {@code argument}
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentIsAtLeast(int argument, int atLeast, String argumentName) {
        checkArgument(argument >= atLeast, MSGS.format(AT_LEAST_3, argumentName, argument, atLeast));
    }

    /**
     * Ensures that the long passed as a parameter to the calling method is at least a minimum value.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param atLeast
     *            the minimum value allowed for {@code argument}
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentIsAtLeast(long argument, long atLeast, String argumentName) {
        checkArgument(argument >= atLeast, MSGS.format(AT_LEAST_3, argumentName, argument, atLeast));
    }

    /**
     * Ensures that the integer passed as a parameter to the calling method is in the specified range, where both ends
     * are inclusive.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param atLeast
     *            the minimum (inclusive) value allowed for {@code argument}
     * @param atMost
     *            the maximum (inclusive) value allowed for {@code argument}
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentIsInRange(double argument, double atLeast, double atMost, String argumentName) {
        checkArgument(argument >= atLeast && argument <= atMost,
                MSGS.format(IN_RANGE_4, argumentName, argument, atLeast, atMost));
    }

    /**
     * Ensures that the double passed as a parameter to the calling method is at least a minimum value.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param atLeast
     *            the minimum value allowed for {@code argument}
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArgumentIsAtLeast(double argument, double atLeast, String argumentName) {
        checkArgument(argument >= atLeast, MSGS.format(AT_LEAST_3, argumentName, argument, atLeast));
    }

    /**
     * Ensures that the array passed as a parameter to the calling method is not null and not empty.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkArrayArgumentNotEmpty(Object[] argument, String argumentName) {
        checkArgumentNotNull(argument, argumentName);
        checkArgument(argument.length > 0, MSGS.format(NOT_EMPTY_1, argumentName));
    }

    /**
     * Ensures that the date passed as a parameter is not null and is before the provided date.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param afterDate
     *            the provided date to be checked against
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkDateArgumentIsBefore(Date argument, Date afterDate, String argumentName) {
        checkArgumentNotNull(argument, argumentName);
        checkArgumentNotNull(afterDate, "afterDate");

        checkArgument(argument.before(afterDate),
                MSGS.format(BEFORE_DATE_3, argumentName, argument, afterDate));
    }

    /**
     * Ensures that the date passed as a parameter is not null and is after the provided date.
     *
     * @param argument
     *            the parameter passed to the calling method
     * @param beforeDate
     *            the provided date to be checked against
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkDateArgumentIsAfter(Date argument, Date beforeDate, String argumentName) {
        checkArgumentNotNull(argument, argumentName);
        checkArgumentNotNull(beforeDate, "beforeDate");

        checkArgument(argument.after(beforeDate),
                MSGS.format(AFTER_DATE_3, argumentName, argument, beforeDate));

    }

    /**
     * Ensures that the date passed as a parameter is not null and is inside the provided date range
     *
     * @param argument
     *            the date parameter passed to the calling method
     * @param startDate
     *            the start date
     * @param endDate
     *            the end date
     * @param argumentName
     *            the name of the argument, used for reporting errors
     */
    public static void checkDateArgumentIsInRange(Date argument, Date startDate, Date endDate, String argumentName) {
        checkDateArgumentIsAfter(argument, startDate, argumentName);
        checkDateArgumentIsBefore(argument, endDate, argumentName);
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @see com.google.common.base.Preconditions#checkArgument(boolean, Object)
     */
    public static void checkArgumentExpression(boolean expression, String errorMessage) {
        checkArgument(expression, errorMessage);
    }

    public static void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}