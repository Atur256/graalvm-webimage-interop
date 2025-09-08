package demos.jsFunction;

import builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class CallDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.call Demo ===");

        // Java function: describe type and value
        JSFunction describe = JSFunction.fromJavaFunction((Object arg) -> {
            if(arg == null) return "null: null";
            return arg.getClass().getSimpleName() + ": " + arg;
        });

        // === Call with Java types
        System.out.println("String: " + describe.call("Java string"));
        // Expected: String: Java string
        System.out.println("Integer: " + describe.call(42));
        // Expected: Integer: 42
        System.out.println("Double: " + describe.call(3.14));
        // Expected: Double: 3.14
        System.out.println("Boolean: " + describe.call(true));
        // Expected: Boolean: true
        System.out.println("Null: " + describe.call(null));
        // Expected: null: null
        System.out.println("CustomClass: " + describe.call(new CustomClass("Alice")));
        // Expected: CustomClass: CustomClass(Alice)

        // === Call with JSValue
        JSValue jsValue = JSString.of("JSValue string");
        System.out.println("JSValue: " + describe.call(jsValue));
        // Expected: JSString: JSValue string

        // === Call with no arguments
        JSFunction noArg = JSFunction.fromSupplier(() -> "No args called");
        System.out.println("call(): " + noArg.call());
        // Expected: No args called
    }

    record CustomClass(String name) {

        @Override
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}
