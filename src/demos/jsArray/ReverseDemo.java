package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;


public class ReverseDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reverse Demo ===");

        JSArray arr = JSArray.of(JSNumber.of(1), JSNumber.of(2), JSNumber.of(3));
        arr.reverse();
        System.out.println("Reversed: " + arr);
        // Expected: Reversed: [3, 2, 1]

        JSArray javaArr = JSArray.of("apple", "banana", "orange");
        javaArr.reverse();
        System.out.println("Reversed: " + javaArr);
        // Expected: Reversed: ["orange", "banana", "apple"]
    }
}
