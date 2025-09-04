package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FindLastDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findLast Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(5), JSNumber.of(10), JSNumber.of(15) });
        JSFunction greaterThan5 = JSFunction.fromBody("return arg > 5;");
        JSValue result = arr.findLast(greaterThan5);
        System.out.println("Last match > 5: " + result); // Expected: 15
    }
}
