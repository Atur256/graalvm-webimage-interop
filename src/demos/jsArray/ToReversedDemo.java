package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ToReversedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toReversed Demo ===");

        JSArray arr = JSArray.of(1,2,3);

        JSArray reversed = arr.toReversed();
        System.out.println("Original array: " + arr);                // Expected: [1, 2, 3]
        System.out.println("Reversed copy: " + reversed.toString()); // Expected: [3, 2, 1]
    }
}
