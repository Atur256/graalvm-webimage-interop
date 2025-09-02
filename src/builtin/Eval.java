package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


@JS.Import("Eval")
public class Eval {

    @JS.Coerce
    @JS(value = "return eval(script)")
    public native static JSValue eval(String script);
}
