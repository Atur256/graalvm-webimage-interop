package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.toStringJS Demo ===");

        JSFunction jsF = JSFunction.fromBody("return 42;");
        System.out.println("JSFunction source: " + jsF.toStringJS());
        // Expected: JSFunction source: function anonymous(arg) { return 42; }

        JSFunction javaF = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg);
        System.out.println("JSFunction source: " + javaF.toStringJS());
        // Expected: JSFunction source: function anonymous(arg) { return 42; }
    }
}
