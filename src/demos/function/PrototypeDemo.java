package demos.function;

import builtin.Function;
import org.graalvm.webimage.api.JSValue;


public class PrototypeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== Function.prototype Demo ===");

        Function f = Function.fromBody("return true;");
        JSValue proto = f.prototype();
        System.out.println("Function prototype: " + proto);
        // Expected: [object Object]
    }
}
