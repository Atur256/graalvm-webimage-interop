package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.String;


@JS.Import("Function")
public class Function extends JSObject {

    @JS.Coerce
    @JS(value = "return new Function('arg', body)")
    public static native Function fromBody(String body);

    @JS.Coerce
    @JS(value = "return Function.apply(null, args)")
    public static native Function fromArgs(String[] args);

    @JS.Coerce
    @JS(value = "return this(arg)")
    public native JSValue call(JSValue arg);

    @JS.Coerce
    @JS(value = "return this.apply(thisArg, argsArray)")
    public native JSValue apply(JSValue thisArg, Array argsArray);

    @JS.Coerce
    @JS(value = "return this.bind(thisArg)")
    public native Function bind(JSValue thisArg);

    @JS.Coerce
    @JS(value = "return this.call.apply(this, [thisArg, ...args])")
    public native JSValue callWithArgs(JSValue thisArg, Array args);

    @JS.Coerce
    @JS(value = "return this.toString()")
    public native String toStringJS();

    @JS.Coerce
    @JS(value = "return this.length")
    public native int length();

    @JS.Coerce
    @JS(value = "return this.name")
    public native String name();

    @JS.Coerce
    @JS(value = "return this.prototype")
    public native JSValue prototype();
}
