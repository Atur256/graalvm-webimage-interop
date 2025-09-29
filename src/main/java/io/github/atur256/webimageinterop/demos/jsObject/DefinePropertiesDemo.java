package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.*;

import static org.junit.Assert.*;


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
        String name = JSValue.checkedCoerce(result.get("name"), String.class);
        int age = JSValue.checkedCoerce(result.get("age"), Integer.class);
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        // Expected:
        // name: Alice
        // age: 26

        // Try modifying writable vs non-writable properties
        result.set("name", JSString.of("Bob")); // Should succeed
        String newName = JSValue.checkedCoerce(result.get("name"), String.class);
        System.out.println("Updated name: " + newName);
        // Expected:
        // Updated name: Bob

        boolean failed = false;
        try {
            result.set("age", JSNumber.of(21)); // Should fail silently or throw depending on context
            System.out.println("Updated age: " + ((JSValue) result.get("age")).as(Double.class));
        } catch (Exception e) {
            failed = true;
            System.out.println("Failed to update 'age': " + e.getMessage());
        }
        // Expected:
        // Failed to update 'age': JavaScript<object; TypeError: Cannot assign to read only property 'age' of object '#<Object>'>

        // Assert values
        assertEquals("Alice", name);
        assertEquals(26, age);
        assertEquals("Bob", newName);
        assertTrue(failed);
    }
}