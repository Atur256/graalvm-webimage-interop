package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class PromiseResolveDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.resolve Demo ===");

        JSPromise promise = JSPromise.resolve(JSString.of("Success"));
        promise.then(JSFunction.fromBody("console.log('Resolved with:', arg)"), JSFunction.fromBody("console.error(arg)"));
        // Expected: Resolved with: Success
    }
}
