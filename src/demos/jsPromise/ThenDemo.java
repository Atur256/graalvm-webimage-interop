package demos.jsPromise;

import builtin.JSPromise;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;


public class ThenDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.then Demo ===");

        JSPromise resolvedPromise = JSPromise.resolve("Hello from Promise!");
        JSPromise rejectedPromise = JSPromise.reject("Something went wrong!");
        JSFunction resolvedFun = JSFunction.fromConsumer((JSString value) -> System.out.println("Resolved with: " + value.as(String.class)));
        JSFunction rejectedFun = JSFunction.fromConsumer((JSString value) -> System.out.println("Rejected with: " + value.as(String.class)));

        // Using then(onFulfilled)
        resolvedPromise.then(resolvedFun);
        // Expected: Resolved with: Hello from Promise!

        // Using then(onFulfilled, onRejected)
        rejectedPromise.then(resolvedFun, rejectedFun);
        // Expected: Rejected with: Something went wrong
    }
}
