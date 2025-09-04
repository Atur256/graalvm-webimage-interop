package demos.jsPromise;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class PromiseAllSettledDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.allSettled Demo ===");

        JSArray promises = JSArray.of(new JSValue[] {
                JSPromise.resolve(JSString.of("A")),
                JSPromise.reject(JSString.of("B")),
                JSPromise.resolve(JSString.of("C"))
        });

        JSPromise allSettled = JSPromise.allSettled(promises);

        allSettled.then(JSFunction.fromBody(
                "arg.forEach((result, i) => {" +
                        "  if (result.status === 'fulfilled') {" +
                        "    console.log(`Promise ${i} fulfilled with`, result.value);" +
                        "  } else {" +
                        "    console.error(`Promise ${i} rejected with`, result.reason);" +
                        "  }" +
                        "})"
        ));

        // Expected:
        // Promise 0 fulfilled with A
        // Promise 1 rejected with B
        // Promise 2 fulfilled with C
    }
}
