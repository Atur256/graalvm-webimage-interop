package demos.jsPromise;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class PromiseAnyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.any Demo ===");

        JSArray promises = JSArray.of(new JSValue[] {
                JSPromise.reject(JSString.of("Fail 1")),
                JSPromise.resolve(JSString.of("Success")),
                JSPromise.reject(JSString.of("Fail 2"))
        });

        JSPromise any = JSPromise.any(promises);

        any.then(JSFunction.fromBody("console.log('First fulfilled:', arg)"))
                .catch_(JSFunction.fromBody("console.error('All promises rejected:', arg)"));
        // Expected: First fulfilled: Success
    }
}
