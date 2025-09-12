package builtin;

import org.graalvm.webimage.api.*;

import java.lang.Object;
import java.util.List;


@JS.Import("Map")
public class JSMap extends JSObject {

    public int size;

    @JS.Coerce
    @JS(value = "return Map.groupBy(items, callback)")
    public static native JSMap groupBy(JSIterator items, JSFunction callback);

    public static JSMap groupBy(JSArray items, JSFunction callback) {
        return groupBy(JSIterator.from(items), callback);
    }

    public static <T> JSMap groupBy(List<T> items, JSFunction callback) {
        return groupBy(fromItems(items.toArray()), callback);
    }

    private static <T> JSIterator fromItems(T[] items) {
        JSArray jsArr = JSArray.of();
        for(T item : items) {
            jsArr.push(item);
        }
        return JSIterator.from(jsArr);
    }

    @JS.Coerce
    @JS(value = "this.clear()")
    public native void clear();

    @JS.Coerce
    @JS(value = "return this.delete(key)")
    public native boolean delete(JSValue key);

    @JS.Coerce
    @JS(value = "return this.delete(key)")
    public native boolean delete(int key);

    @JS.Coerce
    @JS(value = "return this.delete(key)")
    public native boolean delete(double key);

    @JS.Coerce
    @JS(value = "return this.delete(key)")
    public native boolean delete(boolean key);

    @JS.Coerce
    @JS(value = "return this.delete(key)")
    public native boolean delete(Object key);

    @JS.Coerce
    @JS(value = "return this.entries()")
    public native JSIterator entries();

    @JS.Coerce
    @JS(value = "this.forEach(callback)")
    public native void forEach(JSFunction callback);

    @JS.Coerce
    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSFunction callback, JSValue thisArg);

    @JS.Coerce
    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSFunction callback, int thisArg);

    @JS.Coerce
    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSFunction callback, double thisArg);

    @JS.Coerce
    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSFunction callback, boolean thisArg);

    @JS.Coerce
    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSFunction callback, Object thisArg);

    @JS.Coerce
    @JS(value = "return this.get(key)")
    public native Object get(Object key);

    @SuppressWarnings("unchecked")
    public <R> R get(JSValue key, Class<R> cls) {
        java.lang.Object result = get(key);
        if(result instanceof JSValue jsResult) return jsResult.as(cls); // TODO: move to JSValue as static checkedCoerce
        return (R) result;
    }

    @SuppressWarnings("unchecked")
    public <R> R get(int key, Class<R> cls) {
        java.lang.Object result = get(JSNumber.of(key));
        if(result instanceof JSValue jsResult) return jsResult.as(cls); // TODO: move to JSValue as static checkedCoerce
        return (R) result;
    }

    @SuppressWarnings("unchecked")
    public <R> R get(double key, Class<R> cls) {
        java.lang.Object result = get(JSNumber.of(key));
        if(result instanceof JSValue jsResult) return jsResult.as(cls); // TODO: move to JSValue as static checkedCoerce
        return (R) result;
    }

    @SuppressWarnings("unchecked")
    public <R> R get(boolean key, Class<R> cls) {
        java.lang.Object result = get(JSBoolean.of(key));
        if(result instanceof JSValue jsResult) return jsResult.as(cls); // TODO: move to JSValue as static checkedCoerce
        return (R) result;
    }

    @SuppressWarnings("unchecked")
    public <R> R get(Object key, Class<R> cls) {
        java.lang.Object result = get(key);
        if(result instanceof JSValue jsResult) return jsResult.as(cls); // TODO: move to JSValue as static checkedCoerce
        return (R) result;
    }

    @JS.Coerce
    @JS(value = "return this.has(key)")
    public native boolean has(JSValue key);

    @JS.Coerce
    @JS(value = "return this.has(key)")
    public native boolean has(int key);

    @JS.Coerce
    @JS(value = "return this.has(key)")
    public native boolean has(double key);

    @JS.Coerce
    @JS(value = "return this.has(key)")
    public native boolean has(boolean key);

    @JS.Coerce
    @JS(value = "return this.has(key)")
    public native boolean has(Object key);

    @JS.Coerce
    @JS(value = "return this.keys()")
    public native JSIterator keys();

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(JSValue key, JSValue value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(JSValue key, int value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(JSValue key, double value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(JSValue key, boolean value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(JSValue key, Object value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(int key, JSValue value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(int key, int value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(int key, double value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(int key, boolean value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(int key, Object value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(double key, JSValue value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(double key, int value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(double key, double value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(double key, boolean value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(double key, Object value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(boolean key, JSValue value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(boolean key, int value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(boolean key, double value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(boolean key, boolean value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(boolean key, Object value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(Object key, JSValue value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(Object key, int value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(Object key, double value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(Object key, boolean value);

    @JS.Coerce
    @JS(value = "return this.set(key, value)")
    public native void set(Object key, Object value);

    @JS.Coerce
    @JS(value = "return this.values()")
    public native JSIterator values();
}