package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class CatchDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.catch Demo ===");

        JSPromise promise = JSPromise.reject("Oops, something went wrong!");
        JSFunction catchFun = JSFunction.fromConsumer((JSString value) -> System.out.println("Caught error: " + value.as(String.class)));

        promise.catch_(catchFun);
        // Expected: Caught error: Oops, something went wrong!
    }
}
