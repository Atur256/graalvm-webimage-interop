package demos.jsIterator;

import builtin.JSArray;
import builtin.JSIterator;

public class DropDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.drop Demo ===");

        JSArray array = JSArray.of("a", "b", "c", "d");
        JSIterator iterator = JSIterator.from(array).drop(2);

        System.out.println("After dropping 2 elements: " + iterator.toArray());
        // Expected Output: After dropping 2 elements: ["c","d"]
    }
}
