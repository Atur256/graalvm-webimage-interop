package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class IsFrozenDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.isFrozen Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        System.out.println("Initially frozen? " + JSObject.isFrozen(obj));
        // Expected: Initially frozen? false

        // Freeze the object
        JSObject.freeze(obj);

        System.out.println("After freeze(): " + JSObject.isFrozen(obj));
        // Expected: After freeze(): true

        // Attempt to modify an existing property
        try {
            obj.set("name", "Bob");
            System.out.println("Renamed 'name' successfully.");
        } catch (Exception e) {
            System.out.println("Failed to rename 'name': " + e.getMessage());
        }
        // Expected: Failed to rename 'name': JavaScript<object; TypeError: Cannot assign to read only property 'name' of object '#<Object>'>

        // Attempt to add a new property
        try {
            obj.set("newProp", "test");
            System.out.println("Added 'newProp' successfully.");
        } catch (Exception e) {
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
    }
}
