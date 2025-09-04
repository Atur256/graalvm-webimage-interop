package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class SpliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.splice Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSString.of("a"), JSString.of("b"), JSString.of("c"), JSString.of("d")
        });

        JSArray removed = arr.splice(1, 2);
        System.out.println("Removed elements: " + removed.toString()); // Expected: ["b", "c"]
        System.out.println("Remaining array: " + arr.toStringJS()); // Expected: ["a", "d"]
    }
}
