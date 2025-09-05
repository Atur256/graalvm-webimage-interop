package demos.jsIterator;

import builtin.JSArray;
import builtin.JSIterator;
import org.graalvm.webimage.api.JSString;


public class FromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.from Demo ===");

        JSArray array = JSArray.of(new JSString[] {
                JSString.of("apple"),
                JSString.of("banana"),
                JSString.of("cherry")
        });

        JSIterator iterator = JSIterator.from(array);
        System.out.println("Converted to iterator, toArray(): " + iterator.toArray());

        // Expected Output:
        // Converted to iterator, toArray(): ["apple", "banana", "cherry"]
    }
}
