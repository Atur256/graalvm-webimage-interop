package io.github.atur256.webimageinterop.demos.jsError;

import io.github.atur256.webimageinterop.builtin.JSError;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("=== JSObject.toString Demo ===");

        JSError err = JSError.of("Something went wrong");

        String str = err.toString();

        System.out.println("Error object: " + err);
        System.out.println("typeof: " + err.getClass().getSimpleName());
        System.out.println("toString(): " + str);
        // Expected:
        // Error object: Error: Something went wrong
        // typeof: JSError
        // toString(): Error: Something went wrong
    }
}
