package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;

import static org.junit.Assert.assertEquals;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.toStringJS Demo ===");

        JSFunction jsF = JSFunction.fromBody("return 42;");
        String result1 = jsF.toString();
        System.out.println("JSFunction source: " + result1);
        // Expected: JSFunction source: function anonymous(arg) { return 42; }

        JSFunction javaF = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        String result2 = javaF.toString();
        System.out.println("JSFunction source: " + result2);
        // Expected: JSFunction source: function(args) { return javaFunc.apply(args); }

        // Assert values
        assertEquals("""
                function anonymous(arg
                ) {
                return 42;
                }""", result1);
        assertEquals("function(args) { return javaFunc.apply(args); }", result2);
    }
}