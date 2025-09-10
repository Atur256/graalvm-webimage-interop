package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ToStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toStringJS Demo ===");

        JSArray arr = JSArray.of("apple", "banana", "cherry");

        String result = arr.toString();
        System.out.println("Array as string: " + result);
        // Expected: ["apple","banana","cherry"]
    }
}
