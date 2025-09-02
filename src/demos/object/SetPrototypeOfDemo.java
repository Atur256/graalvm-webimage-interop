package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class SetPrototypeOfDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.setPrototypeOf Demo ===");

        JSObject protoA = JSObject.create();
        JSObject protoB = JSObject.create();
        JSObject result = Object.setPrototypeOf(protoA, protoB);
        System.out.println("Prototype set: " + result);
    }
}
