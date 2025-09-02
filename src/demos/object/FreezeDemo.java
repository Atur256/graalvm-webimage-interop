package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSError;
import org.graalvm.webimage.api.JSObject;


public class FreezeDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.freeze Demo ===");

        JSObject obj = JSObject.create();
        obj.set("name", "Alice");

        Object.freeze(obj);
        try {
            obj.set("name", "Changed"); // ignored
        } catch (JSError e) {
            System.out.println("Frozen value: " + obj.get("name"));
        }
    }
}


