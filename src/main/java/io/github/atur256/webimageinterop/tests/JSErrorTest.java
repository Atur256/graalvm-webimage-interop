package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSError;
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSUndefined;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.*;


public class JSErrorTest {

    public static void main(String[] args) {
        testOf();
        testCaptureStackTrace();
        testToString();
        testErrorWithCause();
    }


    public static void testOf() {
        JSError err1 = JSError.of();
        JSError err2 = JSError.of("Simple message");
        JSError err3 = JSError.of("With cause", createOptions());
        JSError err4 = JSError.of("With file", "demo.js");
        JSError err5 = JSError.of("With file + line", "demo.js", 42);

        assertMessage(err2, "Simple message");
        assertMessage(err3, "With cause");
        assertMessage(err4, "With file");
        assertMessage(err5, "With file + line");
        assertStackContains(err1, "Error");
        assertStackContains(err2, "Simple message");
        assertStackContains(err3, "With cause");
        assertStackContains(err4, "With file");
        assertStackContains(err5, "With file + line");
    }

    public static void testCaptureStackTrace() {
        JSError err = JSError.of("Trace without constructor");
        JSError.captureStackTrace(err);

        assertEquals("JSError", err.getClass().getSimpleName());
        assertMessage(err, "Trace without constructor");
        assertStackContains(err, "Trace without constructor");
    }

    public static void testToString() {
        JSError err = JSError.of("Something went wrong");
        String str = err.toString();

        assertEquals("JSError", err.getClass().getSimpleName());
        assertTrue(err.get("stack").toString().contains("Something went wrong"));
        assertEquals("Error: Something went wrong", str);
    }

    public static void testErrorWithCause() {
        JSError err = JSError.of("Something broke", createOptions());
        JSError errorWithoutCause = JSError.of("Something broke");

        assertEquals("JSError", err.getClass().getSimpleName());
        assertEquals("Something broke", err.message);
        assertEquals("Error", err.name);
        assertEquals("root failure", JSValue.checkedCoerce(err.cause, String.class));

        assertEquals("JSError", errorWithoutCause.getClass().getSimpleName());
        assertEquals("Something broke", errorWithoutCause.message);
        assertEquals("Error", errorWithoutCause.name);
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(errorWithoutCause.cause, JSUndefined.class));
    }

    private static void assertMessage(JSError err, String expected) {
        String actual = JSValue.checkedCoerce(err.get("message"), String.class);
        assertEquals(expected, actual);
    }

    private static void assertStackContains(JSError err, String expectedSubstring) {
        String stack = JSValue.checkedCoerce(err.get("stack"), String.class);
        assertTrue(stack.contains(expectedSubstring));
    }

    @JS.Coerce
    @JS("return { cause: 'root failure' };")
    public static native JSObject createOptions();
}
