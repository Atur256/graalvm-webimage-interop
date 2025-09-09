package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class WithDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.with Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)
        });

        JSArray updated = arr.with(1, JSNumber.of(99));
        System.out.println("Original array: " + arr);                      // Expected: [1, 2, 3]
        System.out.println("Updated copy: " + updated.toString());         // Expected: [1, 99, 3]

        JSArray javaArr1 = JSArray.of(2, 4, 10);
        JSArray javaUpdated1 = javaArr1.with(0, 3);
        System.out.println("Original array: " + javaArr1);                 // Expected: [2, 4, 10]
        System.out.println("Updated copy: " + javaUpdated1.toString());    // Expected: [3, 4, 10]


        JSArray javaArr2 = JSArray.of(1.4, 2.6, 5.6, 7.0);
        JSArray javaUpdated2 = javaArr2.with(3, 11.45);
        System.out.println("Original array: " + javaArr2);                 // Expected: [1.4, 2.6, 5.6, 7.0]
        System.out.println("Updated copy: " + javaUpdated2.toString());    // Expected: [1.4, 2.6, 5.6, 11.45]


        JSArray javaArr3 = JSArray.of("apple", "banana", "orange");
        JSArray javaUpdated3 = javaArr3.with(1, "pear");
        System.out.println("Original array: " + javaArr3);                 // Expected: ["apple", "banana", "orange"]
        System.out.println("Updated copy: " + javaUpdated3.toString());    // Expected: ["apple", "pear", "orange"]


        JSArray javaArr4 = JSArray.of(true, false, true, false);
        JSArray javaUpdated4 = javaArr4.with(3, true);
        System.out.println("Original array: " + javaArr4);                      // Expected: [true, false, true, false]
        System.out.println("Updated javaUpdated4: " + javaUpdated4.toString()); // Expected: [1true, false, true, true]

    }
}
