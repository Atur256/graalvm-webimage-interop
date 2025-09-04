package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class JoinDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.join Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("apple"), JSString.of("banana") });
        String joined = arr.join(", ");
        System.out.println("Joined: " + joined); // Expected: "apple, banana"
    }
}
