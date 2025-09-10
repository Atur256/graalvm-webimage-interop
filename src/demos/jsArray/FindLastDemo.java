package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FindLastDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.findLast Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(5), JSNumber.of(10), JSNumber.of(15)});
        JSFunction greaterThan5 = JSFunction.fromBody("return arg > 5;");
        int result = arr.findLast(greaterThan5).as(Integer.class);
        System.out.println("Last match > 5: " + result); // Expected: 15

        JSArray javaArr = JSArray.of(new int[]{5, 10, 15});
        JSFunction smallerThan15 = JSFunction.fromGeneralFunction((JSNumber arg) -> JSBoolean.of(arg.as(Integer.class) < 15));
        int result2 = javaArr.findLast(smallerThan15).as(Integer.class);
        System.out.println("Last match < 15: " + result2); // Expected: 10
    }
}
