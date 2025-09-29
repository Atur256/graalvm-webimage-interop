package io.github.atur256.webimageinterop.demos.jsObject;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class SetPrototypeOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSObject.setPrototypeOf Demo ===");

        // Create a plain object
        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        // Create a prototype with a method using 'this' binding
        JSObject proto = JSObject.create();
        proto.set("describe", JSFunction.fromArgs("return 'I am ' + String(this.name);"));

        // Set the prototype
        JSObject result = JSObject.setPrototypeOf(obj, proto);

        // Access inherited method via prototype chain
        JSFunction describeFn = JSValue.checkedCoerce(result.get("describe"), JSFunction.class);
        String description = JSValue.checkedCoerce(describeFn.applyRaw(result), String.class);

        System.out.println("Inherited describe(): " + description);
        // Expected: I am Alice

        // Assert values
        assertEquals("I am Alice", description);
    }
}