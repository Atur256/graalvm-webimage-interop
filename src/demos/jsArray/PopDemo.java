package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class PopDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.pop Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("x"), JSString.of("y")});
        String popped1 = arr.pop(String.class);
        System.out.println("Popped: " + popped1);
        // Expected: Popped: "y"

        JSArray javaArr = JSArray.of(1, 2, 3);
        int popped2 = javaArr.pop(Integer.class);
        System.out.println("Popped: " + popped2);
        // Expected: Popped: 3
    }
}
