package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class IsFrozenDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.isFrozen Demo ===");

        JSObject obj = JSObject.create();
        Object.freeze(obj);
        System.out.println("Is frozen: " + Object.isFrozen(obj));
    }
}
