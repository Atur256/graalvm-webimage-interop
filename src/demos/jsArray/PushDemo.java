package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class PushDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.push Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("a") });
        arr.push(JSString.of("b"));
        System.out.println("After push: " + arr.toStringJS()); // Expected: ["a", "b"]
    }
}
