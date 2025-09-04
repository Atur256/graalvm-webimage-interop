package demos.jsFunction;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ApplyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.apply Demo ===");

        JSFunction sum = JSFunction.fromArgs(new String[] { "a", "b", "return a + b;" });
        JSArray funcArgs = JSArray.of(new JSValue[] { JSNumber.of(5), JSNumber.of(7) });
        JSValue result = sum.apply(JSValue.undefined(), funcArgs);
        System.out.println("Result of sum.apply: " + result);
        // Expected: 12
    }
}
