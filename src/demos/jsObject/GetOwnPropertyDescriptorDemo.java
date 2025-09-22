package demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class GetOwnPropertyDescriptorDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.getOwnPropertyDescriptor Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        JSObject descriptor = JSObject.getOwnPropertyDescriptor(obj, "name");

        System.out.println("value: " + descriptor.get("value"));
        System.out.println("writable: " + ((JSValue) descriptor.get("writable")).as(Boolean.class));
        System.out.println("enumerable: " + ((JSValue) descriptor.get("enumerable")).as(Boolean.class));
        System.out.println("configurable: " + ((JSValue) descriptor.get("configurable")).as(Boolean.class));
        // Expected:
        // value: Alice
        // writable: true
        // enumerable: true
        // configurable: true
    }
}
