package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;


public class FromDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.from Demo ===");

        JSArray arr = JSArray.from(JSString.of("hello"));
        System.out.println("Length: " + arr.length); // Expected: 5
        System.out.println("First char: " + arr.get(0)); // Expected: "h"
    }
}
