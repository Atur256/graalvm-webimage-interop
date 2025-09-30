package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class CallWithSpreadArgsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.callWithSpreadArgs Demo ===");

        // JS-defined function ===
        JSFunction multiply = JSFunction.fromArgs("a", "b", "return a * b;");
        JSArray jsArgs = new JSArray();
        jsArgs.push(JSNumber.of(6));
        jsArgs.push(JSNumber.of(7));
        int result1 = JSValue.checkedCoerce(multiply.callWithSpreadArgs(JSValue.undefined(), jsArgs), Integer.class);
        System.out.println("JS-defined multiply result: " + result1);
        // Expected: JS-defined multiply result:  42

        JSFunction concat = JSFunction.fromArgs("a", "b", "return a + ' - ' + b;");
        String result2 = JSValue.checkedCoerce(concat.callWithSpreadArgs(JSValue.undefined(), "Hello", "World"), String.class);
        System.out.println("JS-defined concat result: " + result2);
        // Expected: JS-defined concat result: Hello - World

        // Needs to use a JSString in the function as the args spreading prevents the use of Java data types (Solutions: use .call(arg1, arg2) to call a function with two Java data types
        JSFunction javaConcat = JSFunction.fromGeneralBiFunction((JSString prefix, JSString message) -> prefix.as(String.class) + " - " + message.as(String.class));
        String result3 = javaConcat.callWithSpreadArgs(JSValue.undefined(), "Hello", "World");
        System.out.println("JS-defined concat result: " + result3);
        // Expected: JS-defined concat result: Hello - World

        // Assert values
        assertEquals(42, result1);
        assertEquals("Hello - World", result2);
        assertEquals("Hello - World", result3);
    }
}