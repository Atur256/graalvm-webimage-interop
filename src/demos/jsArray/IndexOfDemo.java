package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class IndexOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.indexOf Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("a"), JSString.of("b") });
        int index = arr.indexOf(JSString.of("b"));
        System.out.println("Index of 'b': " + index); // Expected: 1
    }
}
