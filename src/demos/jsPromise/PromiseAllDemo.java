package demos.jsPromise;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSValue;


public class PromiseAllDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.all Demo ===");

        JSArray promises = JSArray.of(new JSValue[] {
                JSPromise.resolve(JSNumber.of(1)),
                JSPromise.resolve(JSNumber.of(2)),
                JSPromise.resolve(JSNumber.of(3))
        });

        JSPromise all = JSPromise.all(promises);
        all.then(JSFunction.fromBody("console.log('All resolved:', arg)"));
        // Expected: All resolved: [1, 2, 3]
    }
}
