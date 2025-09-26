package io.github.atur256.webimageinterop.demos.jsEval;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class EvalDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSEval.eval Demo ===");

        int result1 = JSEval.eval("2 + 2", Integer.class);
        assertEquals(4, result1);
        System.out.println("eval(\"2 + 2\"): " + result1);
        // Expected: eval("2 + 2"): 4

        int result2 = JSEval.eval("Math.max(10, 20)", Integer.class);
        assertEquals(20, result2);
        System.out.println("eval(\"Math.max(10, 20)\"): " + result2);
        // Expected: eval("Math.max(10, 20)"): 20

        String result3 = JSEval.eval("'Hello ' + 'World'", String.class);
        assertEquals("Hello World", result3);
        System.out.println("eval(\"'Hello ' + 'World'\"): " + result3);
        // Expected: eval("'Hello ' + 'World'"): Hello World

        String result4 = JSEval.eval("typeof 42", String.class);
        assertEquals("number", result4);
        System.out.println("eval(\"typeof 42\"): " + result4);
        // Expected: eval("typeof 42"): number

        int result5 = JSEval.eval("let x = 5; x * 2", Integer.class);
        assertEquals(10, result5);
        System.out.println("eval(\"let x = 5; x * 2\"): " + result5);
        // Expected: eval("let x = 5; x * 2"): 10

        JSObject result6 = JSEval.eval("[1, 2, 3].map(n => n * 2)", JSObject.class);
        JSArray keys = JSValue.checkedCoerce(result6.keys(), JSArray.class);
        assertEquals(3, keys.length);
        assertEquals(2, getValue(result6, 0));
        assertEquals(4, getValue(result6, 1));
        assertEquals(6, getValue(result6, 2));
        System.out.println("eval(\"[1, 2, 3].map(n => n * 2)\"): " + result6);
        // Expected: eval("[1, 2, 3].map(n => n * 2)"): JavaScript<object; 2,4,6>
    }

    private static int getValue(JSObject object, int index) {
        return JSValue.checkedCoerce(object.get(index), Integer.class);
    }
}
