package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.*;

import static org.junit.Assert.assertEquals;


public class ApplyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.apply Demo ===");

        // JS-defined function: function(a, b, c) { return a + ' | ' + b + ' | ' + c; }
        JSFunction jsFormatter = JSFunction.fromArgs("a", "b", "c", "return a + ' | ' + b + ' | ' + c;");

        // JSValue input
        JSArray jsArgs = new JSArray();
        jsArgs.push(JSString.of("JSString"));
        jsArgs.push(JSNumber.of(3.14));
        jsArgs.push(JSBoolean.of(true));

        JSString result1 = jsFormatter.apply(JSValue.undefined(), jsArgs);
        System.out.println("JSValue args: " + result1.asString());
        // Expected: JSValue args: JSString | 3.14 | true

        // Java types input
        JSString result2 = jsFormatter.apply(null, "JavaString", 42, false);
        System.out.println("Java types: " + result2.asString());
        // Expected: Java types: [Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]

        // Use applyGeneral
        String result3 = JSValue.checkedCoerce(jsFormatter.applyGeneral(JSValue.undefined(), jsArgs), String.class);
        System.out.println("applyGeneral result: " + result3);
        // Expected: applyGeneral result: JSString | 3.14 | true

        // applyRaw(Q thisArg, T... args)
        Object result4 = JSValue.checkedCoerce(jsFormatter.applyRaw("RawPrefix", "RawString", 99, true), String.class);
        System.out.println("applyRaw(varargs): " + result4);
        // Expected: applyRaw(varargs): [Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]

        // === Java-defined function:
        JSFunction javaDescriber = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg + "!");
        String result5 = javaDescriber.apply(null, "Alice");
        System.out.println("Java function result: " + result5);
        // Expected: Java function result: Hello, Alice!

        // === Java-defined function:
        JSFunction javaDescriber2 = JSFunction.fromGeneralFunction((Integer arg) -> "Number: " + arg);
        String result6 = javaDescriber2.apply(null, 20);
        System.out.println("Java function result: " + result6);
        // Expected: Java function result: Number: 20

        // Assert values
        assertEquals("JSString | 3.14 | true", result1.asString());
        assertEquals("[Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]", result2.asString());
        assertEquals("JSString | 3.14 | true", result3);
        assertEquals("[Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]", result4);
        assertEquals("Hello, Alice!", result5);
        assertEquals("Number: 20", result6);
    }
}