package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class JoinDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.join Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("apple"), JSString.of("banana")});
        String joined1 = arr.join(", ");
        System.out.println("Joined: " + joined1);
        // Expected: Joined: "apple", "banana"

        JSArray javaArr1 = JSArray.of("apple", "banana", "orange");
        String joined2 = javaArr1.join(", ");
        System.out.println("Joined: " + joined2);
        // Expected: Joined: "apple", "banana", "orange"

        JSArray javaArr2 = JSArray.of(1, 2, 3, 4, 5, 6);
        String joined3 = javaArr2.join(" | ");
        System.out.println("Joined: " + joined3);
        // Expected: Joined: 1 | 2 | 3 | 4 | 5 | 6
    }
}
