package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import java.lang.String;


@JS.Import("JSON")
public class JSJson extends JSObject {

    @JS.Coerce
    @JS(value = "return JSON.parse(text)")
    public static native JSValue parse(java.lang.String text);

    @JS.Coerce
    @JS(value = "return JSON.stringify(value)")
    public static native String stringify(JSValue value);

    @JS.Coerce
    @JS(value = "return JSON.rawJSON(text)")
    public static native JSValue rawJSON(JSString text);

    @JS.Coerce
    @JS(value = "return JSON.isRawJSON(value)")
    public static native boolean isRawJSON(JSValue value);
}
