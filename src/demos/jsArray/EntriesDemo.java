package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.entries Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("x"), JSString.of("y") });
        JSValue entries = arr.entries();
        // TODO: Iterator currently not implemented
        System.out.println("Entries iterator: " + entries); // Expected: [0, "x"], [1, "y"]
    }
}
