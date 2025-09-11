package demos.jsArray;

import builtin.JSArray;
import builtin.JSIterator;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.entries Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSString.of("x"), JSString.of("y") });
        JSIterator entries = arr.entries();
        System.out.println("Entries iterator: " + entries.toArray().toString());
        // Expected: Entries iterator: [0,x,1,y]
    }
}
