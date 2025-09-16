package demos.jsArray;

import builtin.JSArray;


public class ToReversedDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toReversed Demo ===");

        JSArray arr = JSArray.of(1, 2, 3);

        JSArray reversed = arr.toReversed();
        System.out.println("Original array: " + arr);
        System.out.println("Reversed copy: " + reversed.toString());
        // Expected:
        // Original array: [1, 2, 3]
        // Reversed copy: [3, 2, 1]
    }
}
