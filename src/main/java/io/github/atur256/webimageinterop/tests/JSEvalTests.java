package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class JSEvalTests {

    public static void main(String[] args) {
        JSObject result6 = JSEval.eval("[1, 2, 3].map(n => n * 2)", JSObject.class);
        JSArray keys = JSValue.checkedCoerce(result6.keys(), JSArray.class);

        assertEquals(Integer.valueOf(4), JSEval.eval("2 + 2", Integer.class));
        assertEquals(Integer.valueOf(20), JSEval.eval("Math.max(10, 20)", Integer.class));
        assertEquals("Hello World", JSEval.eval("'Hello ' + 'World'", String.class));
        assertEquals("number", JSEval.eval("typeof 42", String.class));
        assertEquals(Integer.valueOf(10), JSEval.eval("let x = 5; x * 2", Integer.class));
        assertEquals(3, keys.length);
        assertEquals(2, getValue(result6, 0));
        assertEquals(4, getValue(result6, 1));
        assertEquals(6, getValue(result6, 2));
    }

    private static int getValue(JSObject object, int index) {
        return JSValue.checkedCoerce(object.get(index), Integer.class);
    }
}