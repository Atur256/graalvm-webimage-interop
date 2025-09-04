package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class PopDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.pop Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("x"), JSString.of("y") });
        JSValue popped = arr.pop();
        System.out.println("Popped: " + popped); // Expected: "y"
    }
}
