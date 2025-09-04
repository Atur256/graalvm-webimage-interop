package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class PromiseCatchDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.catch Demo ===");

        JSPromise promise = JSPromise.reject(JSString.of("Oops"));
        promise.catch_(JSFunction.fromBody("console.error('Caught:', arg)"));
        // Expected: Caught: Oops
    }
}
