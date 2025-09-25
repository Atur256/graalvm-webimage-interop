package io.github.atur256.webimageinterop.demos.jsFunction;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.*;


public class ApplyDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSFunction.apply Demo ===");

        // === JS-defined function: function(a, b, c) { return a + ' | ' + b + ' | ' + c; }
        JSFunction jsFormatter = JSFunction.fromArgs("a", "b", "c", "return a + ' | ' + b + ' | ' + c;");

        // JSValue input
        JSArray jsArgs = new JSArray();
        jsArgs.push(JSString.of("JSString"));
        jsArgs.push(JSNumber.of(3.14));
        jsArgs.push(JSBoolean.of(true));

        JSString result1 = jsFormatter.apply(JSValue.undefined(), jsArgs);
        System.out.println("JSValue args: " + result1.as(String.class));
        // Expected: JSValue args: JSString | 3.14 | true

        // Java types input
        JSString result2 = jsFormatter.apply(null, "JavaString", 42, false);
        System.out.println("Java types: " + result2.as(String.class));
        // Expected: Java types: [Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]

        // Use applyGeneral
        Object rawResult = jsFormatter.applyGeneral(JSValue.undefined(), jsArgs);
        System.out.println("applyGeneral result: " + rawResult);
        // Expected: applyGeneral result: JavaScript<string; JSString | 3.14 | true>

        // applyRaw(Q thisArg, T... args)
        Object result3 = jsFormatter.applyRaw("RawPrefix", "RawString", 99, true);
        System.out.println("applyRaw(varargs): " + result3);
        // Expected: applyRaw(varargs): JavaScript<string; [Java Proxy: _String] | [Java Proxy: _Integer] | [Java Proxy: _Boolean]>

        // === Java-defined function:
        JSFunction javaDescriber = JSFunction.fromGeneralFunction((String arg) -> "Hello, " + arg + "!");
        String result4 = javaDescriber.apply(null, "Alice");
        System.out.println("Java function result: " + result4);
        // Expected: Java function result: Hello, Alice

        // === Java-defined function:
        JSFunction javaDescriber2 = JSFunction.fromGeneralFunction((Integer arg) -> "Number: " + arg);
        String result42 = javaDescriber2.apply(null, 20);
        System.out.println("Java function result: " + result42);
        // Expected: Java function result:  Number: 20
    }
}
