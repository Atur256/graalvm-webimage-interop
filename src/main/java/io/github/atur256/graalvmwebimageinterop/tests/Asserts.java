/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.atur256.graalvmwebimageinterop.tests;

import io.github.atur256.graalvmwebimageinterop.builtin.JSArray;

import java.util.Objects;


/**
 * Utility class providing assertion methods for tests.
 * Works with primitive types, objects, JSArray, and exception checking.
 */
public final class Asserts {

    /**
     * Asserts that the given condition is true.
     *
     * @param condition the condition to evaluate
     * @param message   optional message to include if the assertion fails
     * @throws AssertionError if the condition is false
     */
    public static void assertTrue(boolean condition, String message) {
        if(!condition) {
            fail(message != null ? "Assertion failed: " + message : "Assertion failed");
        }
    }

    /**
     * Asserts that the given condition is true.
     *
     * @param condition the condition to evaluate
     * @throws AssertionError if the condition is false
     */
    public static void assertTrue(boolean condition) {
        assertTrue(condition, null);
    }

    /**
     * Asserts that the given condition is false.
     *
     * @param condition the condition to evaluate
     * @param message   optional message to include if the assertion fails
     * @throws AssertionError if the condition is true
     */
    public static void assertFalse(boolean condition, String message) {
        if(condition) {
            fail(message != null ? "Assertion failed: " + message : "Assertion failed");
        }
    }

    /**
     * Asserts that the given condition is false.
     *
     * @param condition the condition to evaluate
     * @throws AssertionError if the condition is true
     */
    public static void assertFalse(boolean condition) {
        assertFalse(condition, null);
    }

    /**
     * Asserts that two objects are equal.
     *
     * @param expected the expected value
     * @param actual   the actual value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if the expected and actual values are not equal
     */
    public static void assertEquals(Object expected, Object actual, String message) {
        if(!Objects.equals(expected, actual)) {
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
        }
    }

    /**
     * Asserts that two objects are equal.
     *
     * @param expected the expected value
     * @param actual   the actual value
     * @throws AssertionError if the expected and actual values are not equal
     */
    public static void assertEquals(Object expected, Object actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that two int values are equal.
     *
     * @param expected the expected int value
     * @param actual   the actual int value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if the expected and actual values are not equal
     */
    public static void assertEquals(int expected, int actual, String message) {
        if(expected != actual)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two int values are equal without a custom message.
     *
     * @param expected the expected int value
     * @param actual   the actual int value
     * @throws AssertionError if the expected and actual values are not equal
     */
    public static void assertEquals(int expected, int actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that two long values are equal.
     *
     * @param expected the expected long value
     * @param actual   the actual long value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if the expected and actual values are not equal
     */
    public static void assertEquals(long expected, long actual, String message) {
        if(expected != actual)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two long values are equal without a custom message.
     *
     * @param expected the expected long value
     * @param actual   the actual long value
     * @throws AssertionError if the expected and actual values are not equal
     */
    public static void assertEquals(long expected, long actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that two float values are equal within a given epsilon.
     *
     * @param expected the expected float value
     * @param actual   the actual float value
     * @param epsilon  the maximum allowable difference between expected and actual
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if the absolute difference between expected and actual exceeds epsilon
     */
    public static void assertEquals(float expected, float actual, float epsilon, String message) {
        if(Math.abs(expected - actual) > epsilon)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two float values are equal within a given epsilon without a custom message.
     *
     * @param expected the expected float value
     * @param actual   the actual float value
     * @param epsilon  the maximum allowable difference between expected and actual
     * @throws AssertionError if the absolute difference between expected and actual exceeds epsilon
     */
    public static void assertEquals(float expected, float actual, float epsilon) {
        assertEquals(expected, actual, epsilon, null);
    }

    /**
     * Asserts that two double values are equal within a given epsilon.
     *
     * @param expected the expected double value
     * @param actual   the actual double value
     * @param epsilon  the maximum allowable difference between expected and actual
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if the absolute difference between expected and actual exceeds epsilon
     */
    public static void assertEquals(double expected, double actual, double epsilon, String message) {
        if(Math.abs(expected - actual) > epsilon)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two double values are equal within a given epsilon without a custom message.
     *
     * @param expected the expected double value
     * @param actual   the actual double value
     * @param epsilon  the maximum allowable difference between expected and actual
     * @throws AssertionError if the absolute difference between expected and actual exceeds epsilon
     */
    public static void assertEquals(double expected, double actual, double epsilon) {
        assertEquals(expected, actual, epsilon, null);
    }

    /**
     * Asserts that two boolean values are equal.
     *
     * @param expected the expected boolean value
     * @param actual   the actual boolean value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(boolean expected, boolean actual, String message) {
        if(expected != actual)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two boolean values are equal without a custom message.
     *
     * @param expected the expected boolean value
     * @param actual   the actual boolean value
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(boolean expected, boolean actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that two char values are equal.
     *
     * @param expected the expected char value
     * @param actual   the actual char value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(char expected, char actual, String message) {
        if(expected != actual)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two char values are equal without a custom message.
     *
     * @param expected the expected char value
     * @param actual   the actual char value
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(char expected, char actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that two byte values are equal.
     *
     * @param expected the expected byte value
     * @param actual   the actual byte value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(byte expected, byte actual, String message) {
        if(expected != actual)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two byte values are equal without a custom message.
     *
     * @param expected the expected byte value
     * @param actual   the actual byte value
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(byte expected, byte actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that two short values are equal.
     *
     * @param expected the expected short value
     * @param actual   the actual short value
     * @param message  optional message to include if the assertion fails
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(short expected, short actual, String message) {
        if(expected != actual)
            fail("Assertion failed: expected=" + expected + ", actual=" + actual + " | " + message);
    }

    /**
     * Asserts that two short values are equal without a custom message.
     *
     * @param expected the expected short value
     * @param actual   the actual short value
     * @throws AssertionError if expected != actual
     */
    public static void assertEquals(short expected, short actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that the given object is not null.
     *
     * @param obj     the object to check
     * @param message optional message to include if the assertion fails
     * @throws AssertionError if the object is null
     */
    public static void assertNotNull(Object obj, String message) {
        if(obj == null)
            fail(message != null ? "Assertion failed: " + message : "Assertion failed: object is null");
    }

    /**
     * Asserts that the given object is not null without a custom message.
     *
     * @param obj the object to check
     * @throws AssertionError if the object is null
     */
    public static void assertNotNull(Object obj) {
        assertNotNull(obj, null);
    }

    /**
     * Asserts that the given object is null.
     *
     * @param obj     the object to check
     * @param message optional message to include if the assertion fails
     * @throws AssertionError if the object is not null
     */
    public static void assertNull(Object obj, String message) {
        if(obj != null)
            fail(message != null ? "Assertion failed: " + message : "Assertion failed: object is not null");
    }

    /**
     * Asserts that the given object is null without a custom message.
     *
     * @param obj the object to check
     * @throws AssertionError if the object is not null
     */
    public static void assertNull(Object obj) {
        assertNull(obj, null);
    }

    /**
     * Fails a test with the given message.
     *
     * @param message the failure message
     * @throws AssertionError always
     */
    public static void fail(String message) {
        if(message != null)
            throw new AssertionError(message);
        throw new AssertionError();
    }

    /**
     * Asserts that a JSArray contains the expected values in order.
     *
     * @param array  the JSArray to check
     * @param cls    the class type of the elements in the array
     * @param values the expected values
     * @param <T>    the type of the array elements
     * @throws AssertionError if the array length or any element does not match the expected values
     */
    @SafeVarargs
    public static <T> void assertArray(JSArray array, Class<T> cls, T... values) {
        assertEquals(values.length, array.length, "Array length does not match expected values length");
        for(int i = 0; i < values.length; i++) {
            assertEquals(values[i], array.get(i, cls), "Array element at index " + i + " does not match expected value");
        }
    }

    /**
     * Asserts that executing the given Runnable throws an exception of the expected type.
     *
     * @param expectedType the expected exception class
     * @param executable   the Runnable that should throw the exception
     * @param message      optional message to include if the assertion fails
     * @param <T>          the type of the expected exception
     * @throws AssertionError if no exception is thrown, or if an exception of a different type is thrown
     */
    public static <T extends Throwable> void assertThrows(Class<T> expectedType, Runnable executable, String message) {
        try {
            executable.run();
        } catch (Throwable actual) {
            if(expectedType.isInstance(actual)) return; // success
            fail("Unexpected exception type thrown. Expected: " + expectedType.getName() +
                    ", but got: " + actual.getClass().getName() + " | " + message);
        }
        fail("Expected exception of type " + expectedType.getName() + " but none was thrown. | " + message);
    }

    /**
     * Asserts that executing the given Runnable throws an exception of the expected type, without a custom message.
     *
     * @param expectedType the expected exception class
     * @param executable   the Runnable that should throw the exception
     * @param <T>          the type of the expected exception
     * @throws AssertionError if no exception is thrown, or if an exception of a different type is thrown
     */
    public static <T extends Throwable> void assertThrows(Class<T> expectedType, Runnable executable) {
        assertThrows(expectedType, executable, null);
    }
}
