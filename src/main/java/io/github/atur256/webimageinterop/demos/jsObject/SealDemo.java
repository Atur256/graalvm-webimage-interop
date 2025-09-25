package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class SealDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.seal Demo ===");


        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        boolean isSealedBefore = JSObject.isSealed(obj);
        System.out.println("Before seal: isSealed = " + isSealedBefore);
        // Expected: Before seal: isSealed = false

        // Seal the object
        JSObject.seal(obj);

        boolean isSealedAfter = JSObject.isSealed(obj);
        System.out.println("After seal: isSealed = " + isSealedAfter);
        // Expected: After seal: isSealed = true

        // Try modifying an existing property
        try {
            obj.set("name", "Bob");
            System.out.println("Modified 'name' successfully.");
        } catch (Exception e) {
            System.out.println("Failed to modify 'name': " + e.getMessage());
        }
        // Expected: Modified 'name' successfully.

        // Try adding a new property
        try {
            obj.set("newProp", "test");
            System.out.println("Added 'newProp' successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add 'newProp': " + e.getMessage());
        }
        // Expected: Failed to add 'newProp': JavaScript<object; TypeError: Cannot add property newProp, object is not extensible>

        String finalName = JSValue.checkedCoerce(obj.get("name"), String.class);
        boolean exists = JSObject.hasOwn(obj, "newProp");
        System.out.println("Final name: " + finalName);
        System.out.println("newProp exists? " + exists);
        // Expected:
        // Final name: Bob
        // newProp exists? false
    }
}
