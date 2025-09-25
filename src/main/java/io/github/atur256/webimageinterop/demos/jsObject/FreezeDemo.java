package io.github.atur256.webimageinterop.demos.jsObject;

import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.ThrownFromJavaScript;


public class FreezeDemo {

    public static void main(String[] args) {

        System.out.println("\n=== JSObject.freeze Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        JSObject.freeze(obj);
        try {
            obj.set("name", "Changed"); // ignored
        } catch (ThrownFromJavaScript e) {
            System.out.println("Frozen value: " + obj.get("name"));
        }
        // Expected:
        // Frozen value: Alice
    }
}


