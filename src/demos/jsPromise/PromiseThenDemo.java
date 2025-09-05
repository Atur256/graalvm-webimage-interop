package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;

public class PromiseThenDemo {
    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.then Demo ===");

        // Create a resolved promise with the value "Done"
        JSPromise promise = JSPromise.resolve(JSString.of("Done"));

        // Define success and error handlers
        JSFunction onFulfilled = JSFunction.fromBody("console.log('Then resolved with:', arg)");
        JSFunction onRejected = JSFunction.fromBody("console.error('Then rejected with:', arg)");

        // Attach handlers using .then
        promise.then(onFulfilled, onRejected);
        // Expected output: Then resolved with: Done
    }
}
