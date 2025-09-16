package demos.jsPromise;

import builtin.JSFunction;
import builtin.JSPromise;
import org.graalvm.webimage.api.*;


public class RejectDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSPromise.reject Demo ===");

        // === JSString ===
        JSPromise promise1 = JSPromise.reject(JSString.of("Error"));
        promise1.catch_(JSFunction.fromConsumer((JSString arg) -> System.out.println("Caught: " + arg.as(String.class))));
        // Expected: Caught: Error

        // === String ===
        JSPromise stringPromise = JSPromise.reject("Error: String");
        stringPromise.catch_(JSFunction.fromConsumer((JSString arg) -> System.out.println("Caught String: " + arg.as(String.class))));
        // Expected: Caught String: Error: String

        // === Integer ===
        JSPromise intPromise = JSPromise.reject(404);
        intPromise.catch_(JSFunction.fromConsumer((JSNumber arg) -> System.out.println("Caught Integer: " + arg.as(Integer.class))));
        // Expected: Caught Integer: 404

        // === Double ===
        JSPromise doublePromise = JSPromise.reject(3.14159);
        doublePromise.catch_(JSFunction.fromConsumer((JSNumber arg) -> System.out.println("Caught Double: " + arg.as(Double.class))));
        // Expected: Caught Double: 3.14159

        // === Boolean ===
        JSPromise boolPromise = JSPromise.reject(true);
        boolPromise.catch_(JSFunction.fromConsumer((JSBoolean arg) -> System.out.println("Caught Boolean: " + arg.as(Boolean.class))));
        // Expected: Caught Boolean: true

        // === Custom Class ===
        CustomError custom = new CustomError("Something went wrong");
        JSPromise customPromise = JSPromise.reject(custom);
        customPromise.catch_(JSFunction.fromConsumer((JSValue arg )->System.out.println("Custom Boolean: " + arg.as(CustomError.class).toString())));
        // Expected: Caught Custom: CustomError(Something went wrong)
    }

    static class CustomError extends JSObject {

        public String message;

        public CustomError(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "CustomError(" + message + ")";
        }
    }
}
