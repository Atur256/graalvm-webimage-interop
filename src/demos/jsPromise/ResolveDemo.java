package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;


public class ResolveDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.resolve Demo ===");

        // === JSString ===
        JSPromise promise = JSPromise.resolve(JSString.of("Success"));
        promise.then(JSFunction.fromBody("console.log('Resolved with:', arg)"), JSFunction.fromBody("console.error(arg)"));
        // Expected: Resolved with: Success

        // === String ===
        JSPromise stringPromise = JSPromise.resolve("Success: String");
        stringPromise.then(
                JSFunction.fromConsumer((JSString arg) -> System.out.println(arg.as(String.class))),
                JSFunction.fromBody("console.error(arg)")
        );
        // Expected: Success: String

        // === Integer ===
        JSPromise intPromise = JSPromise.resolve(42);
        intPromise.then(
                JSFunction.fromBody("console.log('Resolved Integer:', arg)"),
                JSFunction.fromBody("console.error(arg)")
        );
        // Expected: Resolved Integer: 42

        // === Double ===
        JSPromise doublePromise = JSPromise.resolve(3.14159);
        doublePromise.then(
                JSFunction.fromBody("console.log('Resolved Double:', arg)"),
                JSFunction.fromBody("console.error(arg)")
        );
        // Expected: Resolved Double: 3.14159

        // === Boolean ===
        JSPromise boolPromise = JSPromise.resolve(true);
        boolPromise.then(
                JSFunction.fromBody("console.log('Resolved Boolean:', arg)"),
                JSFunction.fromBody("console.error(arg)")
        );
        // Expected: Resolved Boolean: true

        // === Custom Class ===
        CustomResult custom = new CustomResult("Operation complete");
        JSPromise customPromise = JSPromise.resolve(custom);
        customPromise.then(
                JSFunction.fromBody("console.log('Resolved Custom:', arg.toString())"),
                JSFunction.fromBody("console.error(arg)")
        );
        // Expected: Resolved Custom: CustomResult(Operation complete)
    }

    static class CustomResult {

        public String message;

        public CustomResult(String message) {
            this.message = message;
        }

        public String toString() {
            return "CustomResult(" + message + ")";
        }
    }
}
