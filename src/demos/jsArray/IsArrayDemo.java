package demos.jsArray;

import builtin.JSArray;


public class IsArrayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.isArray Demo ===");

        JSArray arr = JSArray.of(1, 2);
        boolean result = JSArray.isArray(arr);
        System.out.println("Is array: " + result); // Expected: true
    }
}
