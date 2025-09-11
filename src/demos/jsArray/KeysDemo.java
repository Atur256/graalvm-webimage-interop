package demos.jsArray;

import builtin.JSArray;
import builtin.JSIterator;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.keys Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("a"), JSString.of("b") });
        JSIterator keys = arr.keys();
        System.out.println("Keys iterator: " + keys.toArray().toString());
        // Expected: Keys iterator: [0,1]
    }
}
