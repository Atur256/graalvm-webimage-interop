package demos.jsObject;

import builtin.Object;
import org.graalvm.webimage.api.JSObject;


public class IsSealedDemo {

    public static void main(String[] args) {

        System.out.println("\n=== Object.isSealed Demo ===");

        JSObject obj = JSObject.create();
        Object.seal(obj);
        System.out.println("Is sealed: " + Object.isSealed(obj));
    }
}
