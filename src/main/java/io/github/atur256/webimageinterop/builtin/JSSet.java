package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.Object;


@JS.Import("Set")
public class JSSet extends JSObject {

    public int size;

    @JS.Coerce
    @JS(value = "return this.add(value)")
    public native JSSet add(JSValue value);

    @JS.Coerce
    @JS(value = "return this.add(value)")
    public native JSSet add(int value);

    @JS.Coerce
    @JS(value = "return this.add(value)")
    public native JSSet add(double value);

    @JS.Coerce
    @JS(value = "return this.add(value)")
    public native JSSet add(boolean value);

    @JS.Coerce
    @JS(value = "return this.add(value)")
    public native JSSet add(Object value);

    @JS.Coerce
    @JS(value = "this.clear()")
    public native void clear();

    @JS.Coerce
    @JS(value = "return this.delete(value)")
    public native boolean delete(JSValue value);

    @JS.Coerce
    @JS(value = "return this.delete(value)")
    public native boolean delete(int value);

    @JS.Coerce
    @JS(value = "return this.delete(value)")
    public native boolean delete(double value);

    @JS.Coerce
    @JS(value = "return this.delete(value)")
    public native boolean delete(boolean value);

    @JS.Coerce
    @JS(value = "return this.delete(value)")
    public native boolean delete(Object value);

    @JS.Coerce
    @JS(value = "return this.difference(other)")
    public native JSSet difference(JSSet other);

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
    @JS(value = "return this.has(value)")
    public native boolean has(JSValue value);

    @JS.Coerce
    @JS(value = "return this.has(value)")
    public native boolean has(int value);

    @JS.Coerce
    @JS(value = "return this.has(value)")
    public native boolean has(double value);

    @JS.Coerce
    @JS(value = "return this.has(value)")
    public native boolean has(boolean value);

    @JS.Coerce
    @JS(value = "return this.has(value)")
    public native boolean has(Object value);

    @JS.Coerce
    @JS(value = "return this.intersection(other)")
    public native JSSet intersection(JSSet other);

    @JS.Coerce
    @JS(value = "return this.isDisjointFrom(other)")
    public native boolean isDisjointFrom(JSSet other);

    @JS.Coerce
    @JS(value = "return this.isSubsetOf(other)")
    public native boolean isSubsetOf(JSSet other);

    @JS.Coerce
    @JS(value = "return this.isSupersetOf(other)")
    public native boolean isSupersetOf(JSSet other);

    @JS.Coerce
    @JS(value = "return this.keys()")
    public native JSIterator keys();

    @JS.Coerce
    @JS(value = "return this.symmetricDifference(other)")
    public native JSSet symmetricDifference(JSSet other);

    @JS.Coerce
    @JS(value = "return this.union(other)")
    public native JSSet union(JSSet other);

    @JS.Coerce
    @JS(value = "return this.values()")
    public native JSIterator values();
}
