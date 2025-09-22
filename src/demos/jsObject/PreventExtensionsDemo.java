package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


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
        try {
            obj.set("newProp", "test");
            System.out.println("newProp added successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add newProp: " + e.getMessage());
        }
        // Expected: Failed to add newProp: JavaScript<object; TypeError: Cannot add property newProp, object is not extensible>

        boolean exists = JSObject.hasOwn(obj, "newProp");
        System.out.println("Does newProp exist? " + exists);
        // Expected: Does newProp exist? false
    }
}
