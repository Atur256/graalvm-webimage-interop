package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.JSString;


public class PromiseRejectDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.reject Demo ===");

        // === JSString ===
        JSPromise promise1 = JSPromise.reject(JSString.of("Error"));
        promise1.catch_(JSFunction.fromBody("console.error('Caught:', arg)"));
        // Expected: Caught: Error

        // === String ===
        JSPromise stringPromise = JSPromise.reject("Error: String");
        stringPromise.catch_(JSFunction.fromBody("console.error('Caught String:', arg)"));
        // Expected: Caught String: Error: String

        // === Integer ===
        JSPromise intPromise = JSPromise.reject(404);
        intPromise.catch_(JSFunction.fromBody("console.error('Caught Integer:', arg)"));
        // Expected: Caught Integer: 404

        // === Double ===
        JSPromise doublePromise = JSPromise.reject(3.14159);
        doublePromise.catch_(JSFunction.fromBody("console.error('Caught Double:', arg)"));
        // Expected: Caught Double: 3.14159

        // === Boolean ===
        JSPromise boolPromise = JSPromise.reject(true);
        boolPromise.catch_(JSFunction.fromBody("console.error('Caught Boolean:', arg)"));
        // Expected: Caught Boolean: true

        // === Custom Class ===
        CustomError custom = new CustomError("Something went wrong");
        JSPromise customPromise = JSPromise.reject(custom);
        customPromise.catch_(JSFunction.fromBody("console.error('Caught Custom:', arg)"));
        // Expected: Caught Custom: CustomError(Something went wrong)
    }

    // Simple record for custom error object
    record CustomError(String message) {

        @Override
        public String toString() {
            return "CustomError(" + message + ")";
        }
    }
}
