package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class SliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.slice Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(1), JSNumber.of(2), JSNumber.of(3) });
        JSArray sliced = arr.slice(1, 3);
        System.out.println("Sliced: " + sliced.toString()); // Expected: [2, 3]
    }
}
