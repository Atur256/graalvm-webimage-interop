package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class SomeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.some Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(1), JSNumber.of(2), JSNumber.of(3) });
        JSFunction isEven = JSFunction.fromBody("return arg % 2 === 0;");
        boolean result = arr.some(isEven);
        System.out.println("Has even: " + result); // Expected: true
    }
}
