package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.*;


public class IsFrozenDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.isFrozen Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        boolean isFrozen1 = JSObject.isFrozen(obj);
        System.out.println("Initially frozen? " + isFrozen1);
        // Expected: Initially frozen? false

        // Freeze the object
        JSObject.freeze(obj);

        boolean isFrozen2 = JSObject.isFrozen(obj);
        System.out.println("After freeze(): " + isFrozen2);
        // Expected: After freeze(): true

        // Attempt to modify an existing property
        boolean failed1 = false;
        try {
            obj.set("name", "Bob");
            System.out.println("Renamed 'name' successfully.");
        } catch (Exception e) {
            failed1 = true;
            System.out.println("Failed to rename 'name': " + e.getMessage());
        }
        // Expected: Failed to rename 'name': JavaScript<object; TypeError: Cannot assign to read only property 'name' of object '#<Object>'>

        // Attempt to add a new property
        boolean failed2 = false;
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
        // Final name: Alice
        // newProp exists? false

        // Assert values
        assertFalse(isFrozen1);
        assertTrue(isFrozen2);
        assertTrue(failed1);
        assertTrue(failed2);
        assertEquals("Alice", finalName);
        assertFalse(exists);
    }
}