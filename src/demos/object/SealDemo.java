package demos.object;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;

public class SealDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.seal Demo ===");

        JSObject obj = JSObject.create();
        Object.seal(obj);
        System.out.println("Seal done.");
    }
}
