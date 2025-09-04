package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ToSortedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSorted Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSString.of("zebra"), JSString.of("apple"), JSString.of("mango")
        });

        JSArray sorted = arr.toSorted();
        System.out.println("Original array: " + arr.toStringJS()); // Expected: ["zebra", "apple", "mango"]
        System.out.println("Sorted copy: " + sorted.toStringJS()); // Expected: ["apple", "mango", "zebra"]
    }
}
