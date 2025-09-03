package demos.function;

import builtin.Array;
import builtin.Function;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class CallWithArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.callWithArgs Demo ===");

        Function multiply = Function.fromArgs(new String[]{"a", "b", "return a * b;"});
        Array funcArgs = Array.of(new JSValue[]{JSNumber.of(6), JSNumber.of(7)});
        JSValue result = multiply.callWithArgs(JSValue.undefined(), funcArgs);
        System.out.println("Result of multiply.callWithArgs: " + result);
        // Expected: 42
    }
}
