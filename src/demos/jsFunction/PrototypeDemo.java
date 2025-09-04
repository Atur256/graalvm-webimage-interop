package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSValue;


public class PrototypeDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.prototype Demo ===");

        JSFunction f = JSFunction.fromBody("return true;");
        JSValue proto = f.prototype();
        System.out.println("JSFunction prototype: " + proto);
        // Expected: [object Object]
    }
}
