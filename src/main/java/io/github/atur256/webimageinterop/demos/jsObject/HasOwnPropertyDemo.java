package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HasOwnPropertyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.hasOwnProperty Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");
        obj.set("role", "Assistant");

        // Check for own properties
        boolean name = obj.hasOwnProperty("name");
        boolean role = obj.hasOwnProperty("role");
        boolean describeBefore = obj.hasOwnProperty("describe");
        System.out.println("Has 'name'? " + name);
        System.out.println("Has 'role'? " + role);
        System.out.println("Has 'describe'? " + describeBefore);
        // Expected:
        // Has 'name'? true
        // Has 'role'? true
        // Has 'describe'? false

        // Assert values
        assertTrue(name);
        assertTrue(role);
        assertFalse(describeBefore);
    }
}