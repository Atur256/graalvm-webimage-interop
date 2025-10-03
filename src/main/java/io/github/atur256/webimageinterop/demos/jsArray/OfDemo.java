package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;


public class OfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.of Demo ===");

        // Primitives
        JSArray arr1 = JSArray.of(1, 2, 3);
        System.out.println("Numbers: " + arr1);
        // Expected: Numbers: [1,2,3]

        JSArray arr2 = JSArray.of(1.2, 2.234, 3.87);
        System.out.println("Numbers: " + arr2);
        // Expected: Numbers: [1.2,2.234,3.87]

        JSArray arr3 = JSArray.of(true, false, true);
        System.out.println("Booleans: " + arr3);
        // Expected: Booleans: [true,false,true]

        JSArray arr4 = JSArray.of("apple", "banana", "cherry");
        System.out.println("Strings: " + arr4);
        // Expected: Strings: ["apple","banana","cherry"]

        // Custom objects
        Custom[] customArr = {new Custom("X"), new Custom("Y")};
        JSArray arr5 = JSArray.of((Object[]) customArr);
        System.out.println("Customs: " + arr5);
        // Expected: Customs: ["Custom(X)", "Custom(Y)"]

        // Assert values
        AssertArray.assertArray(arr1, Integer.class, 1, 2, 3);
        AssertArray.assertArray(arr2, Double.class, 1.2, 2.234, 3.87);
        AssertArray.assertArray(arr3, Boolean.class, true, false, true);
        AssertArray.assertArray(arr4, String.class, "apple", "banana", "cherry");
        AssertArray.assertArray(arr5, String.class, "Custom(X)", "Custom(Y)");
    }

    // Simple class for custom object
    static class Custom {

        public String label;

        public Custom(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Custom(" + label + ")";
        }
    }
}