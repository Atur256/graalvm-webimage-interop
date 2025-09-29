package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HasOwnDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.hasOwn Demo ===");

        JSObject obj = JSObject.create();
        obj.set("x", 10);

        boolean result1 = JSObject.hasOwn(obj, "x");
        boolean result2 = JSObject.hasOwn(obj, "y");
        System.out.println("HasOwn x: " + result1);
        System.out.println("HasOwn y: " + result2);
        // Expected:
        // HasOwn x: true
        // HasOwn y: false

        // Assert values
        assertTrue(result1);
        assertFalse(result2);
    }
}