package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;


public class PushDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.push Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"));
        arr.push(JSString.of("b"));
        System.out.println("After push: " + arr);
        // Expected: After push: ["a", "b"]

        JSArray javaArr1 = JSArray.of("a");
        javaArr1.push("b");
        arr.push(JSString.of("c"));
        System.out.println("After push: " + javaArr1);
        // Expected: After push: ["a", "b", "c"]

        JSArray javaArr2 = JSArray.of(1, 2, 3);
        javaArr2.push(4);
        System.out.println("After push: " + javaArr2);
        // Expected: After push: [1, 2, 3, 4]

        JSArray javaArr3 = JSArray.of(1.2, 2.3, 3.4);
        javaArr3.push(4.5);
        System.out.println("After push: " + javaArr3);
        // Expected: After push: [1.2, 2.3, 3.4, 4.5]

        JSArray javaArr4 = JSArray.of(true, false, true, true);
        javaArr4.push(false);
        System.out.println("After push: " + javaArr4);
        // Expected: After push: [true, false, true, true, false]

        JSArray javaArr5 = JSArray.of("apple", "banana", "orange");
        javaArr5.push("pear");
        System.out.println("After push: " + javaArr5);
        // Expected: After push: ["apple", "banana", "orange", "pear"]
    }
}
