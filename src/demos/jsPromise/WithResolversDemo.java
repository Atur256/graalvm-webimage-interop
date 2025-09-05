package demos.jsPromise;

import builtin.JSEval;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;


public class WithResolversDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Promise.withResolvers Demo ===");

        JSObject control = JSPromise.withResolvers();

        JSObject promise = (JSObject) control.get("promise");
        JSObject resolveFn = (JSObject) control.get("resolve");
        JSObject rejectFn = (JSObject) control.get("reject");

        JSObject thenFn = (JSObject) promise.get("then");
        JSObject callback = (JSObject) JSEval.eval("(value => console.log('Resolved with:', value))");

        thenFn.call(promise, callback);

        resolveFn.call(null, JSString.of("Hello from withResolvers"));
        // Expected Output:
        // Resolved with: Hello from withResolvers
    }
}
