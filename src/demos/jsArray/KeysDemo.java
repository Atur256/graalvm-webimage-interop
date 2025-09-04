package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.keys Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("a"), JSString.of("b") });
        JSValue keys = arr.keys();
        // TODO: Iterator currently not implemented
        System.out.println("Keys iterator: " + keys); // Expected: 0, 1
    }
}
