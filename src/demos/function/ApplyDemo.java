package demos.function;

import builtin.Array;
import builtin.Function;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class ApplyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.apply Demo ===");

        Function sum = Function.fromArgs(new String[] { "a", "b", "return a + b;" });
        Array funcArgs = Array.of(new JSValue[] { JSNumber.of(5), JSNumber.of(7) });
        JSValue result = sum.apply(JSValue.undefined(), funcArgs);
        System.out.println("Result of sum.apply: " + result);
        // Expected: 12
    }
}
