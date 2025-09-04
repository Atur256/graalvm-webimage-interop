package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ToSplicedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toSpliced Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSString.of("a"), JSString.of("b"), JSString.of("c")
        });

        JSArray spliced = arr.toSpliced(1, 1);
        System.out.println("Original array: " + arr.toStringJS()); // Expected: ["a", "b", "c"]
        System.out.println("Spliced copy: " + spliced.toStringJS()); // Expected: ["a", "c"]
    }
}
