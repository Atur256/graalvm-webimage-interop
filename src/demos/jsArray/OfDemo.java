package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSObject;


public class OfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.of Demo ===");

        // Primitives
        JSArray numbers = JSArray.of(1, 2, 3);
        System.out.println("Numbers: " + numbers.toString()); // Expected: [1,2,3]

        JSArray numbers2 = JSArray.of(1.2, 2.234, 3.87);
        System.out.println("Numbers: " + numbers2.toString()); // Expected: [1.2,2.234,3.87]

        JSArray booleans = JSArray.of(true, false, true);
        System.out.println("Booleans: " + booleans.toString()); // Expected: [true,false,true]

        JSArray strings = JSArray.of("apple", "banana", "cherry");
        System.out.println("Strings: " + strings.toString()); // Expected: ["apple","banana","cherry"]

        // Custom objects
        Custom[] customs = {new Custom("X"), new Custom("Y")};
        JSArray customArr = JSArray.of((Object[]) customs);
        System.out.println("Customs: " + customArr.toString()); // Expected: ["Custom(X)", "Custom(Y)"]
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
