package io.github.atur256.webimageinterop.demos.jsPromise;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSPromise;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class WithResolversDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Promise.withResolvers Demo ===");

        JSObject control = JSPromise.withResolvers();

        JSObject promise = (JSObject) control.get("promise");
        JSObject resolveFn = (JSObject) control.get("resolve");
        JSObject rejectFn = (JSObject) control.get("reject");

        JSObject thenFn = (JSObject) promise.get("then");
        JSFunction callback = JSFunction.fromConsumer((JSValue value )-> System.out.println("Resolved with: " + value.as(String.class)));


        thenFn.call(promise, callback);

        resolveFn.call(null, JSString.of("Hello from withResolvers"));
        // Expected Output:
        // Resolved with: Hello from withResolvers
    }
}
