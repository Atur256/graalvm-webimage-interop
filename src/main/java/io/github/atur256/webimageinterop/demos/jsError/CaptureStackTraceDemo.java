package io.github.atur256.webimageinterop.demos.jsError;

import io.github.atur256.webimageinterop.builtin.JSError;


public class CaptureStackTraceDemo {

    public static void main(String[] args) {
        System.out.println("=== Error.captureStackTrace Demo ===");

        // First: capture stack trace without constructor
        JSError err1 = JSError.of("Trace without constructor");
        JSError.captureStackTrace(err1);

        System.out.println("Error 1: " + err1);
        System.out.println("typeof: " + err1.getClass().getSimpleName());
        System.out.println("Stack trace:");
        System.out.println(err1.get("stack"));
        // Expected:
        // Error 1: Error: Trace without constructor
        // typeof: JSError
        // Stack trace:
        // JavaScript<string; Error: Trace without constructor
        //    [some stacktrace...]
    }
}
