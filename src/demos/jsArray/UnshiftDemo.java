package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class UnshiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.unshift Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("b") });
        arr.unshift(JSString.of("a"));
        System.out.println("After unshift: " + arr.toStringJS()); // Expected: ["a", "b"]
    }
}
