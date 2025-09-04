package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class PromiseRejectDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.reject Demo ===");

        JSPromise promise = JSPromise.reject(JSString.of("Error"));
        promise.catch_(JSFunction.fromBody("console.error('Caught:', arg)"));
        // Expected: Caught: Error
    }
}
