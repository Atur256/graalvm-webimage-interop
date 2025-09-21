package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class IsSealedDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.isSealed Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        System.out.println("Initially sealed? " + JSObject.isSealed(obj));
        // Expected: Initially sealed? false

        // Seal the object
        JSObject.seal(obj);

        System.out.println("After seal(): " + JSObject.isSealed(obj));
        // Expected: After seal(): true

        // Attempt to modify an existing property
        try {
            obj.set("name", "Bob");
            System.out.println("Renamed 'name' successfully.");
        } catch (Exception e) {
            System.out.println("Failed to rename 'name': " + e.getMessage());
        }
        // Expected: Renamed 'name' successfully.

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
        // Final name: Bob
        // newProp exists? false
    }
}
