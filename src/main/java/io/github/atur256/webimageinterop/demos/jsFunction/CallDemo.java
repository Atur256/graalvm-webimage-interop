package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;
import org.jetbrains.annotations.NotNull;

import static org.junit.Assert.assertEquals;


public class CallDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.call Demo ===");

        // Java function: describe type and value
        JSFunction describe = JSFunction.fromGeneralFunction((Object arg) -> {
            if(arg == null) return "null: null";
            return arg.getClass().getSimpleName() + ": " + arg;
        });

        // Call with Java types
        String result1 = describe.call("Java string");
        assertEquals("String: Java string", result1);
        System.out.println(result1);
        // Expected: String: Java string

        String result2 = describe.call(42);
        assertEquals("Integer: 42", result2);
        System.out.println(result2);
        // Expected: Integer: 42

        String result3 = describe.call(3.14);
        assertEquals("Double: 3.14", result3);
        System.out.println(result3);
        // Expected: Double: 3.14

        String result4 = describe.call(true);
        assertEquals("Boolean: true", result4);
        System.out.println(result4);
        // Expected: Boolean: true

        String result5 = describe.call(null);
        assertEquals("null: null", result5);
        System.out.println(result5);
        // Expected: null: null

        String result6 = describe.call(new CustomClass("Alice"));
        assertEquals("CustomClass: CustomClass(Alice)", result6);
        System.out.println(result6);
        // Expected: CustomClass: CustomClass(Alice)

        // Call with JSValue
        JSValue jsValue = JSString.of("JSValue string");
        String result7 = describe.call(jsValue);
        assertEquals("JSString: JavaScript<string; JSValue string>", result7);
        System.out.println(result7);
        // Expected: JSString: JSString: JavaScript<string; JSValue string>

        // Call with no arguments
        JSFunction noArg = JSFunction.fromSupplier(() -> "No args called");
        String result8 = noArg.call();
        assertEquals("No args called", result8);
        System.out.println("call(): " + result8);
        // Expected: call(): No args called

        // Java biFunction: describe type and value with prefix
        JSFunction describeBi = JSFunction.fromGeneralBiFunction((String prefix, Object arg) -> {
            if(arg == null) return "null: null";
            return prefix + arg.getClass().getSimpleName() + ": " + arg;
        });
        String result9 = describeBi.call("Prefix: ", "Java string");
        assertEquals("Prefix: String: Java string", result9);
        System.out.println(result9);
        // Expected: Prefix: String: Java string
    }

    record CustomClass(String name) {

        @Override
        @NotNull
        public String toString() {
            return "CustomClass(" + name + ")";
        }
    }
}
