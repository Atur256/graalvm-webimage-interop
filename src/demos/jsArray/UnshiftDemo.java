package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class UnshiftDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.unshift Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("b")});
        int newLength1 = arr.unshift(JSString.of("a"));
        System.out.println("After unshift: " + arr + " with length: " + newLength1);
        // Expected: ["a", "b"] with length: 2

        JSArray javaArr1 = JSArray.of(1, 2, 3);
        int newLength2 = javaArr1.unshift(4);
        System.out.println("After unshift: " + javaArr1 + " with length: " + newLength2);
        // Expected: [4, 1, 2, 3] with length: 4

        JSArray javaArr2 = JSArray.of(1.1, 2.2, 3.3);
        int newLength3 = javaArr2.unshift(JSNumber.of(4.4));
        System.out.println("After unshift: " + javaArr2 + " with length: " + newLength3);
        // Expected: [4.4, 1.1, 2.2, 3.3] with length: 4

        JSArray javaArr3 = JSArray.of(true, true, true, true);
        int newLength4 = javaArr3.unshift(false);
        System.out.println("After unshift: " + javaArr3 + " with length: " + newLength4);
        // Expected: [false, true, true, true, true] with length: 5

        JSArray javaArr4 = JSArray.of("apple", "banana", "orange");
        int newLength5 = javaArr4.unshift("pear");
        System.out.println("After unshift: " + javaArr4 + " with length: " + newLength5);
        // Expected: ["pear", "apple", "banana", "orange"] with length: 4
    }
}
