package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.find Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(5), JSNumber.of(10), JSNumber.of(15)});
        JSFunction greaterThan10 = JSFunction.fromBody("return arg > 10;");
        int found1 = arr.find(greaterThan10, Integer.class);
        System.out.println("Found: " + found1); // Expected: 15

        JSArray JavaArr = JSArray.of(5, 10, 15);
        JSFunction smallerThan10 = JSFunction.fromGeneralFunction((Integer arg) -> JSBoolean.of(arg < 10));
        int found2 = JavaArr.find(smallerThan10, Integer.class);
        System.out.println("Found: " + found2); // Expected: 5
    }
}
