package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.forEach Demo ===");

        JSArray arr = JSArray.of(new JSValue[]{JSString.of("a"), JSString.of("b")});
        JSFunction log = JSFunction.fromBody("console.log(arg);");
        arr.forEach(log);
        // Expected: logs "a", "b" to console

        JSArray javaArr = JSArray.of("a", "b");
        JSFunction print = JSFunction.fromConsumer((JSString arg) -> System.out.println(arg.as(String.class)));
        javaArr.forEach(print);
        // Expected: a \n b
    }
}
