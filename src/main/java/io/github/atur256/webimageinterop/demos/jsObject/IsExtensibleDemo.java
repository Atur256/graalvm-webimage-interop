package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class IsExtensibleDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.isExtensible Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        boolean result1 = JSObject.isExtensible(obj);
        System.out.println("Is original object extensible? " + result1);
        // Expected: Is original object extensible? true

        // Prevent extensions
        JSObject.preventExtensions(obj);

        boolean result2 = JSObject.isExtensible(obj);
        System.out.println("Is object extensible after preventExtensions? " + result2);
        // Expected: Is object extensible after preventExtensions? false

        try {
            obj.set("newProp", "test");
            System.out.println("newProp added successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add newProp: " + e.getMessage());
        }
        // Expected: Failed to add newProp: JavaScript<object; TypeError: Cannot add property newProp, object is not extensible>

        boolean exists = JSObject.hasOwn(obj, "newProp");
        System.out.println("New property added: " + exists);
        // Expected: New property added: false
    }
}
