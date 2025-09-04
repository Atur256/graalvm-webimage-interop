package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class PromiseFinallyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.finally Demo ===");

        JSPromise promise = JSPromise.resolve(JSString.of("Complete"));
        promise.finally_(JSFunction.fromBody("console.log('Finally called')"));
        // Expected: Finally called
    }
}
