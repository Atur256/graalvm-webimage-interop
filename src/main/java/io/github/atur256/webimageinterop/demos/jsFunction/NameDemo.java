package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;

import static org.junit.Assert.assertEquals;


public class NameDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.name Demo ===");

        JSFunction f = JSFunction.fromBody("return 'test';");
        assertEquals("anonymous", f.name);
        System.out.println("JSFunction name: " + f.name);
        // Expected: JSFunction name: anonymous
    }
}
