package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class PreventExtensionsDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.preventExtensions Demo ===");

        JSObject obj = JSObject.create();
        Object.preventExtensions(obj);
        System.out.println("Prevent extensions done.");
    }
}
