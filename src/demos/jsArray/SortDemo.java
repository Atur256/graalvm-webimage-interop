package demos.jsArray;

import builtin.JSArray;


public class SortDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.sort Demo ===");

        JSArray arr = JSArray.of("banana", "apple", "cherry");

        arr.sort();
        System.out.println("Sorted array: " + arr);
        // Expected: Sorted array: ["apple", "banana", "cherry"]
    }
}
