package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;

import static org.junit.Assert.assertEquals;


public class FromBodyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.fromBody Demo ===");

        JSFunction greet = JSFunction.fromBody("return 'Hello ' + arg;");
        String result = greet.callJS("Alice", String.class);
        System.out.println("Result: " + result);
        // Expected: Result: Hello Alice

        // Assert values
        assertEquals("Hello Alice", result);
    }
}