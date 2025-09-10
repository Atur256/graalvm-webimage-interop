package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class MapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.map Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(1), JSNumber.of(2), JSNumber.of(3)});
        JSFunction doubleFn = JSFunction.fromBody("return arg * 2;");
        JSArray mapped = arr.map(doubleFn);
        System.out.println("Mapped: " + mapped.toString()); // Expected: [2, 4, 6]

        JSArray javaArr = JSArray.of(1, 2, 3);
        JSFunction tripleFn = JSFunction.fromGeneralFunction((Integer arg )-> JSNumber.of(arg * 3));
        JSArray mapped2 = javaArr.map(tripleFn);
        System.out.println("Mapped: " + mapped2.toString()); // Expected: [3, 6, 9]
    }
}
