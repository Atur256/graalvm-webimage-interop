package demos.function;

import builtin.Function;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class CallDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.call Demo ===");

        Function greet = Function.fromBody("return 'Hello ' + arg;");
        JSValue result = greet.call(JSString.of("Alice"));
        System.out.println("Result of greet.call: " + result);
        // Expected: Hello Alice
    }
}
