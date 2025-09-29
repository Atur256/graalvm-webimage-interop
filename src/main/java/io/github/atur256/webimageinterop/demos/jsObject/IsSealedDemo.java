package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.*;


public class IsSealedDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.isSealed Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        boolean isSealed1 = JSObject.isSealed(obj);
        System.out.println("Initially sealed? " + isSealed1);
        // Expected: Initially sealed? false

        // Seal the object
        JSObject.seal(obj);

        boolean isSealed2 = JSObject.isSealed(obj);
        System.out.println("After seal(): " + isSealed2);
        // Expected: After seal(): true

        // Attempt to modify an existing property
        boolean failed1 = false;
        try {
            obj.set("name", "Bob");
            System.out.println("Renamed 'name' successfully.");
        } catch (Exception e) {
            failed1 = true;
            System.out.println("Failed to rename 'name': " + e.getMessage());
        }
        // Expected: Renamed 'name' successfully.

        // Attempt to add a new property
        boolean failed2 = failed1;
        try {
            obj.set("newProp", "test");
            System.out.println("Added 'newProp' successfully.");
        } catch (Exception e) {
            failed2 = true;
            System.out.println("Failed to add 'newProp': " + e.getMessage());
        }
        // Expected: Failed to add 'newProp': JavaScript<object; TypeError: Cannot add property newProp, object is not extensible>

        String finalName = (String) obj.get("name");
        boolean exists = JSObject.hasOwn(obj, "newProp");
        System.out.println("Final name: " + finalName);
        System.out.println("newProp exists? " + exists);
        // Expected:
        // Final name: Bob
        // newProp exists? false

        // Assert values
        assertFalse(isSealed1);
        assertTrue(isSealed2);
        assertFalse(failed1);
        assertTrue(failed2);
        assertEquals("Bob", finalName);
        assertFalse(exists);
    }
}