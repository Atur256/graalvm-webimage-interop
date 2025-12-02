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


import io.github.atur256.graalvmwebimageinterop.builtin.JSError;
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSUndefined;
import org.graalvm.webimage.api.JSValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JSErrorTest {

    @Test
    public void testOf() {
//        JSError err1 = JSError.of();
//        JSError err2 = JSError.of("Simple essage");
//        JSError err3 = JSError.of("With cause", createOptions());
//
//        assertMessage(err2, "Simple message");
//        assertMessage(err3, "With cause");
//        assertStackContains(err1, "Error");
//        assertStackContains(err2, "Simple message");
//        assertStackContains(err3, "With cause");
    }

    @Test
    public void testCaptureStackTrace() {
//        JSError err = JSError.of("Trace without constructor");
//        JSError.captureStackTrace(err);
//
//        assertEquals("JSError", err.getClass().getSimpleName());
//        assertMessage(err, "Trace without constructor");
//        assertStackContains(err, "Trace without constructor");
    }

    @Test
    public void testToString() {
//        JSError err = JSError.of("Something went wrong");
//        String str = err.toString();
//
//        assertEquals("JSError", err.getClass().getSimpleName());
//        assertTrue(err.get("stack", String.class).contains("Something went wrong"));
//        assertEquals("Error: Something went wrong", str);
    }

    @Test
    public void testErrorWithCause() {
//        JSError err = JSError.of("Something broke", createOptions());
//        JSError errorWithoutCause = JSError.of("Something broke");
//
//        assertEquals("JSError", err.getClass().getSimpleName());
//        assertEquals("Something broke", err.message);
//        assertEquals("Error", err.name);
//        assertEquals("root failure", JSValue.checkedCoerce(err.cause, String.class));
//
//        assertEquals("JSError", errorWithoutCause.getClass().getSimpleName());
//        assertEquals("Something broke", errorWithoutCause.message);
//        assertEquals("Error", errorWithoutCause.name);
//        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(errorWithoutCause.cause, JSUndefined.class));
    }

    private static void assertMessage(JSError err, String expected) {
        String actual = err.get("message", String.class);
        assertEquals(expected, actual);
    }

    private static void assertStackContains(JSError err, String expectedSubstring) {
        String stack = err.get("stack", String.class);
        assertTrue(stack.contains(expectedSubstring));
    }

    @JS.Coerce
    @JS("return { cause: 'root failure' };")
    public static native JSObject createOptions();
}
