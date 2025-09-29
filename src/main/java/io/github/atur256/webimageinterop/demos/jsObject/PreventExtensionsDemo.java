package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PreventExtensionsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.preventExtensions Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        boolean isExtensibleBefore = JSObject.isExtensible(obj);
        System.out.println("Before preventExtensions: isExtensible = " + isExtensibleBefore);
        // Expected: Before preventExtensions: isExtensible = true

        // Prevent extensions
        JSObject.preventExtensions(obj);

        boolean isExtensibleAfter = JSObject.isExtensible(obj);
        System.out.println("After preventExtensions: isExtensible = " + isExtensibleAfter);
        // Expected: After preventExtensions: isExtensible = false

        // Try adding a new property
        boolean failed = false;
        try {
            obj.set("newProp", "test");
            System.out.println("newProp added successfully.");
        } catch (Exception e) {
            failed = true;
            System.out.println("Failed to add newProp: " + e.getMessage());
        }
        // Expected: Failed to add newProp: JavaScript<object; TypeError: Cannot add property newProp, object is not extensible>

        boolean exists = JSObject.hasOwn(obj, "newProp");
        System.out.println("Does newProp exist? " + exists);
        // Expected: Does newProp exist? false

        // Assert values
        assertTrue(isExtensibleBefore);
        assertFalse(isExtensibleAfter);
        assertTrue(failed);
        assertFalse(exists);
    }
}