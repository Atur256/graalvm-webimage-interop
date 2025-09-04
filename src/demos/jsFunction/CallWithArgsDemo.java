package demos.jsFunction;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class CallWithArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.callWithArgs Demo ===");

        JSFunction multiply = JSFunction.fromArgs(new String[]{"a", "b", "return a * b;"});
        JSArray funcArgs = JSArray.of(new JSValue[]{JSNumber.of(6), JSNumber.of(7)});
        JSValue result = multiply.callWithArgs(JSValue.undefined(), funcArgs);
        System.out.println("Result of multiply.callWithArgs: " + result);
        // Expected: 42
    }
}
