package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.*;


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
        boolean failed1 = false;
        try {
            obj.set("name", "Bob");
            System.out.println("Modified 'name' successfully.");
        } catch (Exception e) {
            failed1 = true;
            System.out.println("Failed to modify 'name': " + e.getMessage());
        }
        // Expected: Modified 'name' successfully.

        // Try adding a new property
        boolean failed2 = false;
        try {
            obj.set("newProp", "test");
            System.out.println("Added 'newProp' successfully.");
        } catch (Exception e) {
            failed2 = true;
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

        // Assert values
        assertFalse(isSealedBefore);
        assertTrue(isSealedAfter);
        assertFalse(failed1);
        assertTrue(failed2);
        assertEquals("Bob", finalName);
        assertFalse(exists);
    }
}