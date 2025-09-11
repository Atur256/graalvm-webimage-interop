package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;


public class FromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.from Demo ===");

        // === JSString → JSArray of characters ===
        JSArray arr = JSArray.from(JSString.of("hello"));
        System.out.println("JSString Length: " + arr.length); // Expected: 5
        String firstChar = arr.at(0, String.class);
        System.out.println("JSString First char: " + firstChar); // Expected: "h"

        // === Java String → JSArray of characters ===
        JSArray strArr = JSArray.from("Hello");
        System.out.println("Java String Length: " + strArr.length); // Expected: 5
        String secondChar = arr.at(1, String.class);
        System.out.println("Java String First char: " + secondChar); // Expected: "e"

        // === Java String[] → JSArray ===
        JSArray nameArr = JSArray.from("Alice", "Bob", "Charlie");
        System.out.println("String[] Length: " + nameArr.length); // Expected: 3
        String firstName = nameArr.at(0, String.class);
        System.out.println("String[] First: " + firstName); // Expected: "Alice"

        // === Java int[] → JSArray ===
        JSArray scoreArr = JSArray.from(10, 20, 30);
        System.out.println("int[] Length: " + scoreArr.length); // Expected: 3
        System.out.println("int[] First: " + scoreArr.at(0, Integer.class)); // Expected: 10

        // === Java double[] → JSArray ===
        JSArray priceArr = JSArray.from(9.99, 14.99, 29.99);
        System.out.println("double[] Length: " + priceArr.length); // Expected: 3
        System.out.println("double[] First: " + priceArr.at(0, Double.class)); // Expected: 9.99

        // === Java boolean[] → JSArray ===
        boolean[] flags = {true, false, true};
        JSArray flagArr = JSArray.from(flags);
        System.out.println("boolean[] Length: " + flagArr.length); // Expected: 3
        System.out.println("boolean[] First: " + flagArr.at(0, Boolean.class)); // Expected: 1

        // === Custom class[] → JSArray of strings ===
        JSArray customArr = JSArray.from(new Custom("X"), new Custom("Y"));
        System.out.println("Custom[] Length: " + customArr.length); // Expected: 2
        System.out.println("Custom[] First: " + customArr.at(0, Custom.class).toString()); // Expected: Custom(X)
    }

    // Simple class for custom object
    static class Custom extends JSObject {

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
