package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ReduceRightDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.reduceRight Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("a"), JSString.of("b"), JSString.of("c")});
        JSFunction concat = JSFunction.fromArgs(new String[]{"acc", "val", "return acc + val;"});
        JSValue result = arr.reduceRight(concat, JSString.of(""));
        System.out.println("Reduced right: " + result); // Expected: "cba"
    }
}
