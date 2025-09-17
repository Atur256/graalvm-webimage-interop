package demos.jsObject;

import builtin.Object;
import org.graalvm.webimage.api.JSError;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


public class FreezeDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.freeze Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        JSObject.freeze(obj);
        try {
            obj.set("name", "Changed"); // ignored
        } catch (JSError e) {
            System.out.println("Frozen value: " + obj.get("name"));
        }
        // Expected:
        // Frozen value: Alice
    }
}


