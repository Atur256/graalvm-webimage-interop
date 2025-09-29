package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DefinePropertyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.defineProperty Demo ===");

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
        boolean failed1 = false;
        try {
            obj1.set("name", "NotAlice");
        } catch (Exception e) {
            System.out.println("Failed to override name in obj1!");
            failed1 = true;
        }
        boolean failed2 = false;
        try {
            obj2.set("name", "StillNotAlice");
        } catch (Exception e) {
            System.out.println("Failed to override name in obj2!");
            failed2 = true;
        }

        // Output results
        String name1 = JSValue.checkedCoerce(obj1.get("name"), String.class);
        String name2 = JSValue.checkedCoerce(obj2.get("name"), String.class);
        System.out.println("obj1.name (JSString key): " + name1);
        System.out.println("obj2.name (String key): " + name2);
        // Expected:
        // Failed to override name in obj1!
        // Failed to override name in obj2!
        // obj1.name (JSString key): Alice
        // obj2.name (String key): Alice

        // Assert values
        assertTrue(failed1);
        assertTrue(failed2);
        assertEquals("Alice", name1);
        assertEquals("Alice", name2);
    }
}