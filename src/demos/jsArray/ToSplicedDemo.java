package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ToSplicedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSpliced Demo ===");

        JSArray arr = JSArray.of("a", "b", "c");

        JSArray spliced = arr.toSpliced(1, 1);
        System.out.println("Original array: " + arr);               // Expected: ["a", "b", "c"]
        System.out.println("Spliced copy: " + spliced.toString());  // Expected: ["a", "c"]
    }
}
