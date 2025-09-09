package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class FlatMapDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.flatMap Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSNumber.of(1), JSNumber.of(2)});
        JSFunction duplicate = JSFunction.fromBody("return [arg, arg];");
        JSArray result = arr.flatMap(duplicate);
        System.out.println("FlatMapped: " + result.toStringJS()); // Expected: [1, 1, 2, 2]

        JSArray javaArr = JSArray.of(1, 2);
        JSFunction javaTriple = JSFunction.fromFunction((JSNumber arg) -> JSArray.from(new int[]{
                arg.as(Integer.class), arg.as(Integer.class), arg.as(Integer.class)
        }));
        JSArray result2 = javaArr.flatMap(javaTriple);
        System.out.println("FlatMapped: " + result2.toStringJS()); // Expected: [1, 1, 1, 2, 2, 2]
    }
}
