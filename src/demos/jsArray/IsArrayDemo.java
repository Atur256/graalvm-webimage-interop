package demos.jsArray;

import builtin.JSArray;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class IsArrayDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.isArray Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(1), JSNumber.of(2) });
        boolean result = JSArray.isArray(arr);
        System.out.println("Is array: " + result); // Expected: true
    }
}
