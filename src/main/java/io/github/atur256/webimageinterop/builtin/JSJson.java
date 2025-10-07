package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import java.lang.Object;
import java.lang.String;
import java.util.function.BiFunction;


@JS.Import("JSON")
public class JSJson extends JSObject {

    @JS.Coerce
    @JS(value = "return JSON.parse(text);")
    public static native JSValue parse(String text);

    @JS.Coerce
    @JS(value = "return JSON.parse(text, reviver);")
    public static native JSValue parse(String text, JSFunction reviver);

    @JS.Coerce
    @JS(value = """
            const res = JSON.stringify(value);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value);

    @JS.Coerce
    @JS(value = """
            const res = JSON.stringify(value);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(Object value);

    @JS.Coerce
    @JS(value = """
            const res = JSON.stringify(value, replacer);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value, JSFunction replacer);

    @JS.Coerce
    @JS(value = """
            const res = JSON.stringify(value, replacer, space);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value, JSFunction replacer, int space);

    @JS.Coerce
    @JS(value = """
            const res = JSON.stringify(value, null, space);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value, int space);

    @JS.Coerce
    @JS(value = """
            const res = JSON.stringify(value, null, space);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(Object value, int space);

    @JS.Coerce
    @JS(value = "return JSON.rawJSON(text);")
    public static native JSValue rawJSON(JSString text);

    @JS.Coerce
    @JS(value = "return JSON.rawJSON(text);")
    public static native JSValue rawJSON(String text);

    @JS.Coerce
    @JS(value = "return JSON.isRawJSON(value);")
    public static native boolean isRawJSON(JSValue value);

    @JS.Coerce
    @JS(value = "return JSON.isRawJSON(value);")
    public static native boolean isRawJSON(Object value);

    @JS.Coerce
    @JS(value = "return function(key, value) { return javaReviver.apply(key, value); }")
    public static native JSFunction fromReviver(BiFunction<JSString, JSValue, JSValue> javaReviver);

    @JS.Coerce
    @JS(value = "return function(key, value) { return javaReplacer.apply(key, value); }")
    public static native JSFunction fromReplacer(BiFunction<JSString, JSValue, JSValue> javaReplacer);
}
