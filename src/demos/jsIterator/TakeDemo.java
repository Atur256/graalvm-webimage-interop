package demos.jsIterator;

import builtin.*;

import java.lang.String;


public class TakeDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.take Demo ===");

        JSArray array = JSArray.of("a", "b", "c", "d");
        JSIterator iterator = JSIterator.from(array).take(2);

        System.out.println("First 2 elements: " + iterator.toArray());
        // Expected Output: First 2 elements:  ["a", "b"]
    }
}
