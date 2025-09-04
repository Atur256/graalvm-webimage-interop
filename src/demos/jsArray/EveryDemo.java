package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class EveryDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Array.every Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(2), JSNumber.of(4), JSNumber.of(6) });
        JSFunction isEven = JSFunction.fromBody("return arg % 2 === 0;");
        boolean result = arr.every(isEven);
        System.out.println("All even: " + result); // Expected: true
    }

}
