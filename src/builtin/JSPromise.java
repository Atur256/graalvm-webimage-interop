package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


@JS.Import("Promise")
public class JSPromise extends JSObject {

    @JS.Coerce
    @JS(value = "return Promise.all(promises)")
    public static native JSPromise all(JSValue promises);

    @JS.Coerce
    @JS(value = "return Promise.allSettled(promises)")
    public static native JSPromise allSettled(JSValue promises);

    @JS.Coerce
    @JS(value = "return Promise.any(promises)")
    public static native JSPromise any(JSValue promises);

    @JS.Coerce
    @JS(value = "return Promise.race(promises)")
    public static native JSPromise race(JSValue promises);

    @JS.Coerce
    @JS(value = "return Promise.reject(reason)")
    public static native JSPromise reject(JSValue reason);

    @JS.Coerce
    @JS(value = "return Promise.resolve(value)")
    public static native JSPromise resolve(JSValue value);

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


