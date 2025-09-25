package io.github.atur256.webimageinterop.demos.jsPromise;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class FinallyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.finally Demo ===");


        JSPromise rejectedPromise = JSPromise.reject("Oops, something went wrong!");
        JSPromise resolvedPromise = JSPromise.resolve("All good!");
        JSFunction catchFun = JSFunction.fromConsumer((JSString error) -> System.out.println("Caught error: " + error.as(String.class)));
        JSFunction finallyFun = JSFunction.fromRunnable(() -> System.out.println("Finally block executed."));
        JSFunction resolvedFun = JSFunction.fromConsumer((JSString value) -> System.out.println("Resolved with: " + value.as(String.class)));

        rejectedPromise.catch_(catchFun).finally_(finallyFun);
        // Expected: Caught error: Oops, something went wrong! Finally block executed.

        resolvedPromise.then(resolvedFun).finally_(finallyFun);
        // Expected: Caught error: Resolved with: All good! Finally block executed.

    }
}
