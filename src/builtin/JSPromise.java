package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.Object;
import java.lang.String;


@JS.Import("Promise")
public class JSPromise extends JSObject {

    @JS.Coerce
    @JS(value = "return Promise.all(promises)")
    public static native <T> JSPromise all(T promises);

    @JS.Coerce
    @JS(value = "return Promise.allSettled(promises)")
    public static native <T> JSPromise allSettled(T promises);

    @JS.Coerce
    @JS(value = "return Promise.any(promises)")
    public static native <T> JSPromise any(T promises);

    @JS.Coerce
    @JS(value = "return Promise.race(promises)")
    public static native <T> JSPromise race(T promises);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(JSValue reason);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(int reason);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(double reason);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(boolean reason);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(String reason);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(Object reason);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(JSValue value);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(int value);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(double value);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(boolean value);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(String value);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(Object value);

    @JS.Coerce
    @JS(value = "return this.then(onFulfilled)")
    public native JSPromise then(JSValue onFulfilled);

    @JS.Coerce
    @JS(value = "return this.then(onFulfilled, onRejected)")
    public native JSPromise then(JSValue onFulfilled, JSValue onRejected);

    @JS.Coerce
    @JS(value = "return this.catch(onRejected)")
    public native JSPromise catch_(JSValue onRejected);

    @JS.Coerce
    @JS(value = "return this.finally(onFinally)")
    public native JSPromise finally_(JSValue onFinally);

    @JS.Coerce
    @JS(value = "return Promise.withResolvers()")
    public static native JSObject withResolvers();
}


