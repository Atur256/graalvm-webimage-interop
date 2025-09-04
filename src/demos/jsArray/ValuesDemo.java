package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ValuesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.values Demo ===");

        JSArray arr = JSArray.of(new JSValue[] {
                JSNumber.of(10), JSNumber.of(20)
        });

        JSValue values = arr.values();
        // TODO: Iterator currently not implemented
        System.out.println("Values iterator: " + values); // Expected: 10, 20
    }
}
