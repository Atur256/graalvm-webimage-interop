package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetOwnPropertyDescriptorDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.getOwnPropertyDescriptor Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        JSObject descriptor = JSObject.getOwnPropertyDescriptor(obj, "name");

        String value = JSValue.checkedCoerce(descriptor.get("value"), String.class);
        boolean writable = JSValue.checkedCoerce(descriptor.get("writable"), Boolean.class);
        boolean enumerable = JSValue.checkedCoerce(descriptor.get("enumerable"), Boolean.class);
        boolean configurable = JSValue.checkedCoerce(descriptor.get("configurable"), Boolean.class);

        System.out.println("value: " + value);
        System.out.println("writable: " + writable);
        System.out.println("enumerable: " + enumerable);
        System.out.println("configurable: " + configurable);
        // Expected:
        // value: Alice
        // writable: true
        // enumerable: true
        // configurable: true

        // Assert values
        assertEquals("Alice", value);
        assertTrue(writable);
        assertTrue(enumerable);
        assertTrue(configurable);
    }
}