package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class IncludesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.includes Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("x"), JSString.of("y") });
        boolean result = arr.includes(JSString.of("y"));
        System.out.println("Includes 'y': " + result); // Expected: true
    }
}
