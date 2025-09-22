package demos.jsArray;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.forEach Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b"));
        JSFunction log = JSFunction.fromBody("console.log(arg);");
        arr.forEach(log);
        // Expected:
        // "a"
        // "b"

        JSArray javaArr = JSArray.of("a", "b");
        JSFunction print = JSFunction.fromGeneralConsumer((JSString arg) -> System.out.println(arg.as(String.class)));
        javaArr.forEach(print);
        // Expected:
        // "a"
        // "b"
    }
}
