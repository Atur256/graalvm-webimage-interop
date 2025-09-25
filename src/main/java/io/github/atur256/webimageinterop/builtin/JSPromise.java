package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.Object;
import java.util.List;


@JS.Import("Promise")
public class JSPromise extends JSObject {

    @JS.Coerce
    @JS(value = "return Promise.all(promises)")
    public static native JSPromise all(JSIterator promises);

    public static JSPromise all(JSArray promises) {
        return all(JSIterator.from(promises));
    }

    public static JSPromise all(JSPromise... promises) {
        return all(fromPromises(promises));
    }

    public static JSPromise all(List<JSPromise> promises) {
        return all(fromPromises(promises.toArray(new JSPromise[0])));
    }

    private static JSIterator fromPromises(JSPromise[] promises) {
        JSArray jsArr = JSArray.of();
        for (JSPromise promise : promises) {
            jsArr.push(promise);
        }
        return JSIterator.from(jsArr);
    }

    @JS.Coerce
    @JS(value = "return Promise.allSettled(promises)")
    public static native JSPromise allSettled(JSIterator promises);

    public static JSPromise allSettled(JSArray promises) {
        return allSettled(JSIterator.from(promises));
    }

    public static JSPromise allSettled(JSPromise... promises) {
        return allSettled(fromPromises(promises));
    }

    public static JSPromise allSettled(List<JSPromise> promises) {
        return allSettled(fromPromises(promises.toArray(new JSPromise[0])));
    }

    @JS.Coerce
    @JS(value = "return Promise.any(promises)")
    public static native JSPromise any(JSIterator promises);

    public static JSPromise any(JSArray promises) {
        return any(JSIterator.from(promises));
    }

    public static JSPromise any(JSPromise... promises) {
        return any(fromPromises(promises));
    }

    public static JSPromise any(List<JSPromise> promises) {
        return any(fromPromises(promises.toArray(new JSPromise[0])));
    }

    @JS.Coerce
    @JS(value = "return Promise.race(promises)")
    public static native JSPromise race(JSIterator promises);

    public static JSPromise race(JSArray promises) {
        return any(JSIterator.from(promises));
    }

    public static JSPromise race(JSPromise... promises) {
        return any(fromPromises(promises));
    }

    public static JSPromise race(List<JSPromise> promises) {
        return any(fromPromises(promises.toArray(new JSPromise[0])));
    }

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
    public static native JSPromise resolve(Object value);

    @JS.Coerce
    @JS(value = "return this.then(onFulfilled)")
    public native JSPromise then(JSFunction onFulfilled);

    @JS.Coerce
    @JS(value = "return this.then(onFulfilled, onRejected)")
    public native JSPromise then(JSFunction onFulfilled, JSFunction onRejected);

    @JS.Coerce
    @JS(value = "return this.catch(onRejected)")
    public native JSPromise catch_(JSFunction onRejected);

    @JS.Coerce
    @JS(value = "return this.finally(onFinally)")
    public native JSPromise finally_(JSFunction onFinally);

    @JS.Coerce
    @JS(value = "return Promise.withResolvers()")
    public static native JSObject withResolvers();
}


