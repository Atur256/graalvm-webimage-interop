package demos.jsObject;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class IsExtensibleDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.isExtensible Demo ===");

        JSObject obj = JSObject.create();
        System.out.println("Is extensible: " + Object.isExtensible(obj));
    }
}
