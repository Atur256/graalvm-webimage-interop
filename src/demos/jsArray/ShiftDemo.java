package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ShiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.shift Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("first"), JSString.of("second") });
        JSValue shifted = arr.shift();
        System.out.println("Shifted: " + shifted); // Expected: "first"
    }
}
