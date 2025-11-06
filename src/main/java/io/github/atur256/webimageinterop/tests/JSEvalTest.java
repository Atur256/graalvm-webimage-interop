package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class JSEvalTest {

    public static void main(String[] args) {
        JSObject result6 = JSEval.eval("[1, 2, 3].map(n => n * 2)", JSObject.class);
        JSArray keys = JSValue.checkedCoerce(result6.keys(), JSArray.class);

        assertEquals(Integer.valueOf(4), JSEval.eval("2 + 2", Integer.class));
        assertEquals(Integer.valueOf(20), JSEval.eval("Math.max(10, 20)", Integer.class));
        assertEquals("Hello World", JSEval.eval("'Hello ' + 'World'", String.class));
        assertEquals("number", JSEval.eval("typeof 42", String.class));
        assertEquals(Integer.valueOf(10), JSEval.eval("let x = 5; x * 2", Integer.class));
        assertEquals(3, keys.length);
        assertEquals(Integer.valueOf(2), JSValue.checkedCoerce(result6.get(0), Integer.class));
        assertEquals(Integer.valueOf(4), JSValue.checkedCoerce(result6.get(1), Integer.class));
        assertEquals(Integer.valueOf(6), JSValue.checkedCoerce(result6.get(2), Integer.class));
    }
}
