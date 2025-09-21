package demos.jsObject;

import org.graalvm.webimage.api.JSObject;


public class HasOwnPropertyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== hasOwnProperty Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");
        obj.set("role", "Assistant");

        // Check for own properties
        System.out.println("Has 'name'? " + obj.hasOwnProperty("name"));
        System.out.println("Has 'role'? " + obj.hasOwnProperty("role"));
        System.out.println("Has 'describe'? " + obj.hasOwnProperty("describe"));
        // Expected:
        // Has 'name'? true
        // Has 'role'? true
        // Has 'describe'? false

        // Add a prototype with 'describe'
        JSObject proto = JSObject.create();
        proto.set("describe", "I am a helper");
        JSObject.setPrototypeOf(obj, proto);

        // Still not an own property
        System.out.println("After prototype set:");
        System.out.println("Has 'describe'? " + obj.hasOwnProperty("describe"));
        // Expected:
        // After prototype set:
        // Has 'describe'? false
    }
}
