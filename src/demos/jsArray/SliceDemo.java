package demos.jsArray;

import builtin.JSArray;


public class SliceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.slice Demo ===");

        JSArray arr1 = JSArray.of(1, 2, 3);
        JSArray sliced1 = arr1.slice(1, 3);
        System.out.println("Sliced: " + sliced1.toString());
        // Expected: Sliced: [2, 3]

        JSArray arr2 = JSArray.of("apple", "banana", "cherry");
        JSArray sliced2 = arr2.slice(1, 2);
        System.out.println("Sliced: " + sliced2.toString());
        // Expected: Sliced: ["banana"]
    }
}
