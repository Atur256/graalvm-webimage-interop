package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.*;

import java.lang.Object;
import java.lang.String;
import java.util.List;


@JS.Import("Array")
public class JSArray extends JSObject {

    public int length;

    @JS.Coerce
    @JS(value = "return Array.from(arrayLike);")
    public static native JSArray from(JSValue arrayLike);

    @JS.Coerce
    @JS(value = "return Array.from(arrayLike);")
    public static native JSArray from(JSValue[] arrayLike);

    @JS.Coerce
    @JS(value = "return Array.from(str);")
    public static native JSArray from(String str);

    @JS.Coerce
    @JS(value = "return Array.from(values);")
    public static native JSArray from(int[] values);

    @JS.Coerce
    @JS(value = "return Array.from(values);")
    public static native JSArray from(double[] values);

    public static JSArray from(boolean[] values) {
        JSValue[] jsValues = new JSValue[values.length];
        for(int i = 0; i < values.length; i++) {
            jsValues[i] = JSBoolean.of(values[i]);
        }
        return JSArray.from(jsValues);
    }

    @JS.Coerce
    @JS(value = "return Array.from(values);")
    public static native JSArray from(Object[] values);

    @JS.Coerce
    @JS(value = "return Array.fromAsync(arrayLike);")
    public static native JSPromise fromAsync(JSValue arrayLike);

    @JS.Coerce
    @JS(value = "return Array.isArray(value);")
    public static native boolean isArray(JSValue value);

    public static JSArray of(Object... values) {
        return from(coerceJSArray(values));
    }

    @JS.Coerce
    @JS(value = "return Array.of();")
    public static native JSArray of(); // Needed to create an empty JSArray

    private static JSArray coerceJSArray(Object... args) {
        JSArray argsArray = JSArray.of();
        for(Object arg : args) {
            argsArray.push(coerce(arg));
        }
        return argsArray;
    }

    @JS.Coerce
    @JS("return arg;")
    private static native Object coerce(Object arg);

    @JS.Coerce
    @JS(value = "return this.at(index);")
    public native Object at(int index);

    public <R> R at(int index, Class<R> cls) {
        return JSValue.checkedCoerce(at(index), cls);
    }

    @JS.Coerce
    @JS(value = "return Array.prototype.concat.apply(this, jsArrays);")
    public native JSArray concat(JSArray... jsArrays);

    public JSArray concat(Object... arrays) {
        JSArray[] jsArrays = new JSArray[arrays.length];
        for(int i = 0; i < arrays.length; i++) {
            jsArrays[i] = convertToJSArray(arrays[i]);
        }
        return concat(jsArrays);
    }

    private static JSArray convertToJSArray(Object arrayLike) {
        switch(arrayLike) {
            case null -> {
                return JSArray.of();
            }
            case JSArray jsArray -> {
                return jsArray;
            }
            case Object[] array -> {
                return JSArray.from(array);
            }
            case int[] array -> {
                return JSArray.from(array);
            }
            case double[] array -> {
                return JSArray.from(array);
            }
            case boolean[] array -> {
                return JSArray.from(array);
            }
            case Iterable<?> iterable -> {
                JSValue[] values = new JSValue[((List<?>) iterable).size()];
                int i = 0;
                for(Object item : iterable) {
                    values[i++] = coerceJSArray(item);
                }
                return JSArray.from(values);
            }
            default -> {
            }
        }

        return JSArray.of(coerceJSArray(arrayLike)); // fallback: wrap single object
    }

    @JS.Coerce
    @JS(value = "return this.copyWithin(target, start, end);")
    public native JSArray copyWithin(int target, int start, int end);

    @JS.Coerce
    @JS(value = "return this.entries();")
    public native JSIterator entries();

    @JS.Coerce
    @JS(value = "return this.every(callback);")
    public native boolean every(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.fill(value, start, end);")
    public native JSArray fill(JSValue value, int start, int end);

    @JS.Coerce
    @JS(value = "return this.fill(value, start, end);")
    public native JSArray fill(int value, int start, int end);

    @JS.Coerce
    @JS(value = "return this.fill(value, start, end);")
    public native JSArray fill(double value, int start, int end);

    @JS.Coerce
    @JS(value = "return this.fill(value, start, end);")
    public native JSArray fill(boolean value, int start, int end);

    @JS.Coerce
    @JS(value = "return this.fill(value, start, end);")
    public native JSArray fill(Object value, int start, int end);

    @JS.Coerce
    @JS(value = "return this.filter(callback);")
    public native JSArray filter(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.find(callback);")
    public native Object find(JSFunction callback);

    public <R> R find(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(find(callback), cls);
    }

    @JS.Coerce
    @JS(value = "return this.findIndex(callback);")
    public native int findIndex(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.findLast(callback);")
    public native Object findLast(JSFunction callback);

    public <R> R findLast(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(findLast(callback), cls);
    }

    @JS.Coerce
    @JS(value = "return this.findLastIndex(callback);")
    public native int findLastIndex(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.flat(depth);")
    public native JSArray flat(int depth);

    @JS.Coerce
    @JS(value = "return this.flatMap(callback);")
    public native JSArray flatMap(JSFunction callback);

    @JS.Coerce
    @JS(value = "this.forEach(callback);")
    public native void forEach(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.includes(value);")
    public native boolean includes(JSValue value);

    @JS.Coerce
    @JS(value = "return this.includes(value);")
    public native boolean includes(int value);

    @JS.Coerce
    @JS(value = "return this.includes(value);")
    public native boolean includes(double value);

    @JS.Coerce
    @JS(value = "return this.includes(value);")
    public native boolean includes(boolean value);

    @JS.Coerce
    @JS(value = "return this.includes(value);")
    public native boolean includes(Object value);

    @JS.Coerce
    @JS(value = "return this.indexOf(value);")
    public native int indexOf(JSValue value);

    @JS.Coerce
    @JS(value = "return this.indexOf(value);")
    public native int indexOf(int value);

    @JS.Coerce
    @JS(value = "return this.indexOf(value);")
    public native int indexOf(double value);

    @JS.Coerce
    @JS(value = "return this.indexOf(value);")
    public native int indexOf(boolean value);

    @JS.Coerce
    @JS(value = "return this.indexOf(value);")
    public native int indexOf(Object value);

    @JS.Coerce
    @JS(value = "return this.join(separator);")
    public native String join(String separator);

    @JS.Coerce
    @JS(value = "return this.keys();")
    public native JSIterator keys();

    @JS.Coerce
    @JS(value = "return this.lastIndexOf(value);")
    public native int lastIndexOf(JSValue value);

    @JS.Coerce
    @JS(value = "return this.lastIndexOf(value);")
    public native int lastIndexOf(int value);

    @JS.Coerce
    @JS(value = "return this.lastIndexOf(value);")
    public native int lastIndexOf(double value);

    @JS.Coerce
    @JS(value = "return this.lastIndexOf(value);")
    public native int lastIndexOf(boolean value);

    @JS.Coerce
    @JS(value = "return this.lastIndexOf(value);")
    public native int lastIndexOf(Object value);

    @JS.Coerce
    @JS(value = "return this.map(callback);")
    public native JSArray map(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.pop();")
    public native Object pop();

    public <R> R pop(Class<R> cls) {
        return JSValue.checkedCoerce(pop(), cls);
    }

    @JS.Coerce
    @JS(value = "return this.push(value);")
    public native int push(JSValue value);

    @JS.Coerce
    @JS(value = "return this.push(value);")
    public native int push(int value);

    @JS.Coerce
    @JS(value = "return this.push(value);")
    public native int push(double value);

    @JS.Coerce
    @JS(value = "return this.push(value);")
    public native int push(boolean value);

    @JS.Coerce
    @JS(value = "return this.push(value);")
    public native int push(Object value);

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
    @JS(value = "return this.reduceRight(callback);")
    private native Object reduceRightJS(JSFunction callback);

    public <R> R reduceRight(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(reduceRightJS(callback), cls);
    }

    @JS.Coerce
    @JS(value = "return this.reduceRight(callback, initialValue);")
    private native <R> Object reduceRightJS(JSFunction callback, R initialValue);

    @SuppressWarnings("unchecked")
    public <R> R reduceRight(JSFunction callback, R initialValue) {
        Object result = reduceRightJS(callback, initialValue);
        if(result instanceof JSValue jsResult) {
            return jsResult.as((Class<R>) initialValue.getClass());
        }
        return (R) result;
    }

    @JS.Coerce
    @JS(value = "return this.reverse();")
    public native JSArray reverse();

    @JS.Coerce
    @JS(value = "return this.shift();")
    public native Object shift();

    public <R> R shift(Class<R> cls) {
        return JSValue.checkedCoerce(shift(), cls);
    }

    @JS.Coerce
    @JS(value = "return this.slice(start, end);")
    public native JSArray slice(int start, int end);

    @JS.Coerce
    @JS(value = "return this.some(callback);")
    public native boolean some(JSFunction callback);

    @JS.Coerce
    @JS(value = "return this.sort();")
    public native JSArray sort();

    @JS.Coerce
    @JS(value = "return this.splice(start, deleteCount);")
    public native JSArray splice(int start, int deleteCount);

    @JS.Coerce
    @JS(value = "return this.toLocaleString();")
    public native String toLocaleString();

    @JS.Coerce
    @JS(value = "return this.toReversed();")
    public native JSArray toReversed();

    @JS.Coerce
    @JS(value = "return this.toSorted();")
    public native JSArray toSorted();

    @JS.Coerce
    @JS(value = "return this.toSpliced(start, deleteCount);")
    public native JSArray toSpliced(int start, int deleteCount);

    @JS.Coerce
    @JS(value = "return this.toString();")
    private native String toJSString();

    public String toString() {
        return "<JavaScript<" + typeof() + "; [" + toJSString() + "]>";
    }

    @JS.Coerce
    @JS(value = "return this.unshift(value);")
    public native int unshift(JSValue value);

    @JS.Coerce
    @JS(value = "return this.unshift(value);")
    public native int unshift(int value);

    @JS.Coerce
    @JS(value = "return this.unshift(value);")
    public native int unshift(double value);

    @JS.Coerce
    @JS(value = "return this.unshift(value);")
    public native int unshift(boolean value);

    @JS.Coerce
    @JS(value = "return this.unshift(value);")
    public native int unshift(Object value);

    @JS.Coerce
    @JS(value = "return this.values();")
    public native JSIterator values();

    @JS.Coerce
    @JS(value = "return this.with(index, value);")
    public native JSArray with(int index, JSValue value);

    @JS.Coerce
    @JS(value = "return this.with(index, value);")
    public native JSArray with(int index, int value);

    @JS.Coerce
    @JS(value = "return this.with(index, value);")
    public native JSArray with(int index, double value);

    @JS.Coerce
    @JS(value = "return this.with(index, value);")
    public native JSArray with(int index, boolean value);

    @JS.Coerce
    @JS(value = "return this.with(index, value);")
    public native JSArray with(int index, Object value);
}
