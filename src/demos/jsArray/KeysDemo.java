package demos.jsArray;

import builtin.JSArray;
import builtin.JSIterator;
import org.graalvm.webimage.api.JSString;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.keys Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b") );
        JSIterator keys = arr.keys();
        System.out.println("Keys iterator: " + keys.toArray().toString());
        // Expected: Keys iterator: [0,1]
    }
}
