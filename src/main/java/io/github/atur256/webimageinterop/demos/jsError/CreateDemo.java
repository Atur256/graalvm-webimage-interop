package io.github.atur256.webimageinterop.demos.jsError;

import io.github.atur256.webimageinterop.builtin.JSError;
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


public class CreateDemo {

    public static void main(String[] args) {
        System.out.println("=== Error.of Demo ===");

        JSError err1 = JSError.of();
        JSError err2 = JSError.of("Simple message");
        JSError err3 = JSError.of("With cause", createOptions());
        JSError err4 = JSError.of("With file", "demo.js");
        JSError err5 = JSError.of("With file + line", "demo.js", 42);

        printError("err1", err1);
        printError("err2", err2);
        printError("err3", err3);
        printError("err4", err4);
        printError("err5", err5);
        // Expected:
        // [err1]
        // Message: JavaScript<string; >
        // Stack: JavaScript<string; Error
        //    [some stacktrace...]
        //
        // [err2]
        // Message: JavaScript<string; Simple message>
        // Stack: JavaScript<string; Error: Simple message
        //    [some stacktrace...]
        //
        // [err3]
        // Message: JavaScript<string; With cause>
        // Stack: JavaScript<string; Error: With cause
        //    [some stacktrace...]
        //
        // [err4]
        // Message: JavaScript<string; With file>
        // Stack: JavaScript<string; Error: With file
        //    [some stacktrace...]
        //
        // [err5]
        // Message: JavaScript<string; With file + line>
        // Stack: JavaScript<string; Error: With file + line
        //    [some stacktrace...]
    }

    private static void printError(String label, JSError err) {
        System.out.println("[" + label + "]");
        System.out.println("Message: " + err.get("message"));
        System.out.println("Stack: " + err.get("stack") + "\n");
    }

    @JS.Coerce
    @JS(value = "return { cause: 'root failure' };")
    public static native JSObject createOptions();
}
