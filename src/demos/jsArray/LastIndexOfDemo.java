package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class LastIndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.lastIndexOf Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("a"), JSString.of("b"), JSString.of("a") });
        int index = arr.lastIndexOf(JSString.of("a"));
        System.out.println("Last index of 'a': " + index); // Expected: 2
    }
}
