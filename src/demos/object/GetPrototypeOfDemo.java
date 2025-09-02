package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class GetPrototypeOfDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.getPrototypeOf Demo ===");

        JSObject proto = JSObject.create();
        JSObject obj = Object.create(proto);

        System.out.println("Prototype: " + Object.getPrototypeOf(obj));
    }
}
