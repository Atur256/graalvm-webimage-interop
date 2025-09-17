package demos.jsObject;

import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class DefinePropertyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Object.defineProperty Demo ===");

        // Create target object
        JSObject obj1 = JSObject.create();
        JSObject obj2 = JSObject.create();

        // Create descriptor for non-writable property
        JSObject descriptor = JSObject.create();
        descriptor.set("value", JSString.of("Alice"));
        descriptor.set("writable", JSBoolean.of(false));
        descriptor.set("enumerable", JSBoolean.of(true));
        descriptor.set("configurable", JSBoolean.of(true));

        // Define property using JSString key
        JSObject.defineProperty(obj1, JSString.of("name"), descriptor);

        // Define property using plain String key
        JSObject.defineProperty(obj2, "name", descriptor);

        // Attempt to overwrite both
        try {
            obj1.set("name", "NotAlice");
        } catch (Exception e) {
            System.out.println("Failed to override name in obj1!");
        }
        try {
            obj2.set("name", "StillNotAlice");
        }catch (Exception e) {
            System.out.println("Failed to override name in obj2!");

        }

        // Output results
        System.out.println("obj1.name (JSString key): " + ((JSValue) obj1.get("name")).as(String.class));
        System.out.println("obj2.name (String key): " + ((JSValue) obj2.get("name")).as(String.class));
        // Expected:
        // Failed to override name in obj1!
        //  Failed to override name in obj2!
        //  obj1.name (JSString key): Alice
        //  obj2.name (String key): Alice
    }
}
