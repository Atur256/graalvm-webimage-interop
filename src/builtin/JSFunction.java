package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.String;


@JS.Import("Function")
public class JSFunction extends JSObject {

    public int length;

    public String name;

    public JSValue prototype;

    @JS.Coerce
    @JS(value = "return new Function('arg', body)")
    public static native JSFunction fromBody(String body);

    @JS.Coerce
    @JS(value = "return Function.apply(null, args)")
    public static native JSFunction fromArgs(String[] args);

    @JS.Coerce
    @JS(value = "return this(arg)")
    public native JSValue call(JSValue arg);

    @JS.Coerce
    @JS(value = "return this.apply(thisArg, argsJSArray)")
    public native JSValue apply(JSValue thisArg, JSArray argsJSArray);

    @JS.Coerce
    @JS(value = "return this.bind(thisArg)")
    public native JSFunction bind(JSValue thisArg);

    @JS.Coerce
    @JS(value = "return this.call.apply(this, [thisArg, ...args])")
    public native JSValue callWithArgs(JSValue thisArg, JSArray args);

    @JS.Coerce
    @JS(value = "return this.toString()")
    public native String toStringJS();

}
