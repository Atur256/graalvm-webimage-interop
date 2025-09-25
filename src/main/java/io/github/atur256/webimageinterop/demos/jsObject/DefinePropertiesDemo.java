package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.*;


public class DefinePropertiesDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.defineProperties Demo ===");

        JSObject target = JSObject.create();

        JSObject descriptors = JSObject.create();

        JSObject nameDescriptor = JSObject.create();
        nameDescriptor.set("value", JSString.of("Alice"));
        nameDescriptor.set("writable", JSBoolean.of(true));
        nameDescriptor.set("enumerable", JSBoolean.of(true));
        nameDescriptor.set("configurable", JSBoolean.of(true));
        descriptors.set("name", nameDescriptor);

        JSObject versionDescriptor = JSObject.create();
        versionDescriptor.set("value", JSNumber.of(26));
        versionDescriptor.set("writable", JSBoolean.of(false));
        versionDescriptor.set("enumerable", JSBoolean.of(true));
        versionDescriptor.set("configurable", JSBoolean.of(false));
        descriptors.set("age", versionDescriptor);

        JSObject result = JSObject.defineProperties(target, descriptors);

        // Access defined properties
        System.out.println("name: " + ((JSValue) result.get("name")).as(String.class));
        System.out.println("age: " + ((JSValue) result.get("age")).as(Double.class));
        // Expected:
        // name: Alice
        // age: 26

        // Try modifying writable vs non-writable properties
        result.set("name", JSString.of("Bob")); // Should succeed
        System.out.println("Updated name: " + ((JSValue) result.get("name")).as(String.class));

        try {
            result.set("age", JSNumber.of(21)); // Should fail silently or throw depending on context
            System.out.println("Updated age: " + ((JSValue) result.get("age")).as(Double.class));
        } catch (Exception e) {
            System.out.println("Failed to update 'age': " + e.getMessage());
        }
        // Expected:
        // Updated name: Bob
        // Failed to update 'age': JavaScript<object; TypeError: Cannot assign to read only property 'age' of object '#<Object>'>
    }
}
