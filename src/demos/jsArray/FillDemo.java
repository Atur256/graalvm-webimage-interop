package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FillDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.fill Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(1), JSNumber.of(2), JSNumber.of(3) });
        arr.fill(JSNumber.of(0), 1, 3);
        System.out.println("After fill: " + arr); // Expected: [1, 0, 0]
    }
}
