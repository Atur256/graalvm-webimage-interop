package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.find Demo ===");

        JSArray arr = JSArray.of(new JSValue[] { JSNumber.of(5), JSNumber.of(10), JSNumber.of(15) });
        JSFunction greaterThan10 = JSFunction.fromBody("return arg > 10;");
        JSValue found = arr.find(greaterThan10);
        System.out.println("Found: " + found); // Expected: 15
    }
}
