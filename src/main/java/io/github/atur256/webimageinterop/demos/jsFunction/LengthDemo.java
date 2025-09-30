package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;

import static org.junit.Assert.assertEquals;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.length Demo ===");

        JSFunction jsF = JSFunction.fromArgs("x", "y", "z", "return x + y + z;");
        System.out.println("Declared parameters: " + jsF.length);
        // Expected: Declared parameters: 3

        JSFunction javaF = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        System.out.println("Declared parameters: " + javaF.length);
        // Expected: Declared parameters: 1

        // Assert values
        assertEquals(3, jsF.length);
        assertEquals(1, javaF.length);
    }
}