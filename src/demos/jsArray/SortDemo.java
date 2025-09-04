package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class SortDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.sort Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{
                JSString.of("banana"), JSString.of("apple"), JSString.of("cherry")
        });

        arr.sort();
        System.out.println("Sorted array: " + arr.toStringJS()); // Expected: ["apple", "banana", "cherry"]
    }
}
