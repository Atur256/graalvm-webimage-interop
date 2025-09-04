package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class CopyWithinDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.copyWithin Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(1), JSNumber.of(2), JSNumber.of(3), JSNumber.of(4) });
        arr.copyWithin(0, 2, 4);
        System.out.println("After copyWithin: " + arr.toStringJS()); // Expected: [3, 4, 3, 4]
    }
}
