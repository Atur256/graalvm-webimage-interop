package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.Object;


@JS.Import("Iterator")
public class JSIterator extends JSObject {

    @JS.Coerce
    @JS(value = "return Iterator.from(iterable);")
    public static native JSIterator from(JSValue iterable);

    @JS.Coerce
    @JS(value = "return this.drop(n);")
    public native JSIterator drop(int n);

    @JS.Coerce
    @JS(value = "return this.every(callback);")
    public native boolean every(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.filter(callback);")
    public native JSIterator filter(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.find(callback);")
    public native Object find(JSFunction callback);

    public <R> R find(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(find(callback), cls);
    }

    @JS.Coerce
    @JS(value = "return this.flatMap(callback);")
    public native JSIterator flatMap(JSFunction callback);

    @JS.Coerce
    @JS(value = "this.forEach(callback);")
    public native void forEach(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.map(callback);")
    public native JSIterator map(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.reduce(callback);")
    private native Object reduceJS(JSFunction callback);

    public <R> R reduce(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(reduceJS(callback), cls);
    }

    @JS.Coerce
    @JS(value = "return this.reduce(callback, initialValue);")
    private native <T> Object reduceJS(JSFunction callback, T initialValue);

    @SuppressWarnings("unchecked")
    public <R> R reduce(JSFunction callback, R initialValue) {
        Object result = reduceJS(callback, initialValue);
        if(result instanceof JSValue jsResult) {
            return jsResult.as((Class<R>) initialValue.getClass());
        }
        return (R) result;
    }

    @JS.Coerce
    @JS(value = "return this.some(callback);")
    public native boolean some(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.take(n);")
    public native JSIterator take(int n);

    @JS.Coerce
    @JS(value = "return this.toArray();")
    public native JSArray toArray();

    @JS.Coerce
    @JS(value = "return this.next();")
    public native JSObject next();

    public <T> T nextValue(Class<T> cls) {
        JSObject result = next();
        if (((JSBoolean) result.get("done")).as(Boolean.class)) return null;
        return ((JSValue) result.get("value")).as(cls);
    }

}