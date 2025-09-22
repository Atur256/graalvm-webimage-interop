package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;


public class FlatDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSArray.flat Demo ===");

        JSArray innerMost = JSArray.of( JSNumber.of(4) );
        JSArray level3 = JSArray.of( JSNumber.of(3), innerMost );
        JSArray level2 = JSArray.of( JSNumber.of(2), level3 );
        JSArray root = JSArray.of(JSNumber.of(1), level2 );

        JSArray flat = root.flat(3);
        System.out.println("Flat: " + flat.toString());
        // Expected: Flat : [1,2,3,4]
    }
}
