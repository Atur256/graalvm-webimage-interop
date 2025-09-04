package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class WithDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.with Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)
        });

        JSArray updated = arr.with(1, JSNumber.of(99));
        System.out.println("Original array: " + arr.toStringJS()); // Expected: [1, 2, 3]
        System.out.println("Updated copy: " + updated.toStringJS()); // Expected: [1, 99, 3]
    }
}
