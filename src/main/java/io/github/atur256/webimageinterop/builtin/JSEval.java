package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSValue;

import java.lang.Object;
import java.lang.String;


@JS.Import("Eval")
public class JSEval {

    @JS.Coerce
    @JS(value = "return eval(script)")
    public native static Object eval(String script);

    public static <R> R eval(String script, Class<R> cls) {
        return JSValue.checkedCoerce(eval(script), cls);
    }
}
