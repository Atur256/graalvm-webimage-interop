package demos.jsPromise;

import builtin.JSArray;
import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class PromiseRaceDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.race Demo ===");

        JSArray promises = JSArray.of(new JSValue[] {
                JSPromise.resolve(JSString.of("First")),
                JSPromise.resolve(JSString.of("Second"))
        });

        JSPromise race = JSPromise.race(promises);
        race.then(JSFunction.fromBody("console.log('Race winner:', arg)"));
        // Expected: Race winner: First
    }
}
