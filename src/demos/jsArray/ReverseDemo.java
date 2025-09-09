package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ReverseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reverse Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)});
        arr.reverse();
        System.out.println("Reversed: " + arr); // Expected: [3, 2, 1]
    }
}
