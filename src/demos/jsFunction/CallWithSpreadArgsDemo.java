package demos.jsFunction;

import builtin.JSArray;
import builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


public class CallWithSpreadArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.callWithSpreadArgs Demo ===");

        // === JS-defined function ===
        JSFunction multiply = JSFunction.fromArgs("a", "b", "return a * b;");
        JSArray jsArgs = new JSArray();
        jsArgs.push(JSNumber.of(6));
        jsArgs.push(JSNumber.of(7));
        JSValue jsResult1 = multiply.callWithSpreadArgs(JSValue.undefined(), jsArgs);
        System.out.println("JS-defined multiply result: " + jsResult1.as(Integer.class));
        // Expected: 42

        JSFunction concat = JSFunction.fromArgs("a", "b", "return a + ' - ' + b;");
        JSValue jsResult2 = concat.callWithSpreadArgs(JSValue.undefined(), "Hello", "World");
        System.out.println("JS-defined concat result: " + jsResult2.as(String.class));
        // Expected:  Hello - World

        // Needs to use a JSString in the function as the args spreading prevents the use of Java data types (Solutions: use .call(arg1, arg2) to call a function with two Java data types
        JSFunction javaConcat = JSFunction.fromGeneralBiFunction((JSString prefix, JSString message) -> prefix.as(String.class) + " - " + message.as(String.class));
        String javaResult = javaConcat.callWithSpreadArgs(JSValue.undefined(), "Hello", "World");
        System.out.println("JS-defined concat result: " + javaResult);
        // Expected:  Hello - World
    }
}
