package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.*;


public class CreateDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.create Demo ===");

        // Create a prototype object with a method
        JSObject proto = JSObject.create();
        proto.set("greet", JSFunction.fromGeneralFunction((String name) -> "Hello, " + name));

        // Create an object with the prototype
        JSObject obj1 = JSObject.create(proto);
        JSFunction greetFn = ((JSValue) obj1.get("greet")).as(JSFunction.class);
        String greeting = greetFn.apply(null, "Alice");
        System.out.println("Greeting from proto method: " + greeting);
        // Expected: Greeting from proto method: Hello, Alice

        // Create a property descriptor object
        JSObject nameDescriptor = JSObject.create();
        nameDescriptor.set("value", JSString.of("Bob"));
        nameDescriptor.set("writable", JSBoolean.of(false));
        nameDescriptor.set("enumerable", JSBoolean.of(true));
        nameDescriptor.set("configurable", JSBoolean.of(true));

        JSObject properties = JSObject.create();
        properties.set("name", nameDescriptor);

        // Create an object with prototype and properties
        JSObject obj2 = JSObject.create(proto, properties);
        try {
            obj2.set("name", "Alice");
        } catch (Exception e) {
            System.out.println("Error: Cannot assign to read only property 'name' of object.");
        }
        System.out.println("obj2.name: " + ((JSValue) obj2.get("name")).as(String.class));
        // Expected:
        // Error: Cannot assign to read only property 'name' of object.
        // obj2.name: Bob

        // Call inherited method
        JSFunction greetFn2 = ((JSValue) obj2.get("greet")).as(JSFunction.class);
        String greeting2 = greetFn2.apply(null, "World");
        System.out.println("Greeting from obj2: " + greeting2);
        // Expected: Greeting from obj2: Hello, World
    }
}

