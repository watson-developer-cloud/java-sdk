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

import static com.google.common.base.Preconditions.*;
import static com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils.RetrieveAndRankMessages.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
     * For two arguments in a 1:N (N > 0) relationship, ensure that either both arguments are set or neither is set.
     *
     * @param singleArgument
     *            A single string that must not be blank or null if arrayArgument is set.
     * @param arrayArgument
     *            An array of strings that must have at least one value if singleArgument is set.
     */
    public static void check1ToNArgumentPair(CharSequence singleArgument, CharSequence[] arrayArgument) {
        if (arrayArgument == null) {
            checkArgument(isBlank(singleArgument));
            return;
        }

        checkArgument((isNotBlank(singleArgument) && (arrayArgument.length > 0))
                || (isBlank(singleArgument) && (arrayArgument.length == 0)));
    }

    /**
     * For two array arguments in an N:N relationship, ensure that either both are null or that both are of equal size.
     *
     * @param arrayA
     *            An array of values that (if not null) must be of equal length to arrayB.
     * @param arrayB
     *            An array of values that (if not null) must be of equal length to arrayA.
     * @param pairName
     *            A descriptive name of the two array arguments.
     */
    public static void checkNtoNArgumentPair(Object[] arrayA, Object[] arrayB, String pairName) {
        if ((arrayA == null) || (arrayB == null)) {
            checkArgument(arrayA == arrayB, MSGS.format(CHECK_COLLECTIONS_NULL_1, pairName));
            return;
        }

        checkArgument(arrayA.length == arrayB.length,
                MSGS.format(CHECK_PAIR_3, pairName, arrayA.length, arrayB.length));
    }

    /**
     * For two list arguments in an N:N relationship, ensure that either both are null or that both are of equal size.
     *
     * @param listA
     *            A list of values that (if not null) must be of equal length to listB.
     * @param listB
     *            A list of values that (if not null) must be of equal length to listA.
     * @param pairName
     *            A descriptive name of the two list arguments.
     */
    public static void checkNtoNArgumentPair(List<?> listA, List<?> listB, String pairName) {
        if ((listA == null) || (listB == null)) {
            checkArgument(listA == listB, MSGS.format(CHECK_COLLECTIONS_NULL_1, pairName));
            return;
        }

        checkArgument(listA.size() == listB.size(),
                MSGS.format(CHECK_PAIR_3, pairName, listA.size(), listB.size()));
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @see com.google.common.base.Preconditions#checkArgument(boolean, Object)
     */
    public static void checkArgumentExpression(boolean expression, String errorMessage) {
        checkArgument(expression, errorMessage);
    }

}