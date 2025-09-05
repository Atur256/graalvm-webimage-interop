package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;

import java.lang.String;


@JS.Import("Array")
public class JSArray extends JSObject {

    public int length;

    @JS.Coerce
    @JS(value = "return Array.from(arrayLike)")
    public static native JSArray from(JSValue arrayLike); // example: "1234", String[] {"a","b"}...

    @JS.Coerce
    @JS(value = "return Array.fromAsync(arrayLike)")
    public static native JSValue fromAsync(JSValue arrayLike);

    @JS.Coerce
    @JS(value = "return Array.isArray(value)")
    public static native boolean isArray(JSValue value);

    @JS.Coerce
    @JS(value = "return Array.of.apply(null, values)")
    public static native JSArray of(JSValue[] values); // .of from java objects

    @JS.Coerce
    @JS(value = "return this.at(index)")
    public native JSValue at(int index);

    @JS.Coerce
    @JS(value = "return Array.prototype.concat.apply(this, jsArrays)")
    public native JSArray concat(JSArray[] jsArrays); // TODO: also java arrays

    @JS.Coerce
    @JS(value = "return this.copyWithin(target, start, end)")
    public native JSArray copyWithin(int target, int start, int end);

    @JS.Coerce
    @JS(value = "return this.entries()")
    public native JSValue entries();

    @JS.Coerce
    @JS(value = "return this.every(callback)")
    public native boolean every(JSValue callback);

    @JS.Coerce
    @JS(value = "this.fill(value, start, end); return this")
    public native JSArray fill(JSValue value, int start, int end);

    @JS.Coerce
    @JS(value = "return this.filter(callback)")
    public native JSArray filter(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.find(callback)")
    public native JSValue find(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.findIndex(callback)")
    public native int findIndex(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.findLast(callback)")
    public native JSValue findLast(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.findLastIndex(callback)")
    public native int findLastIndex(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.flat(depth)")
    public native JSArray flat(int depth);

    @JS.Coerce
    @JS(value = "return this.flatMap(callback)")
    public native JSArray flatMap(JSValue callback);

    @JS.Coerce
    @JS(value = "this.forEach(callback)")
    public native void forEach(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.includes(value)")
    public native boolean includes(JSValue value);

    @JS.Coerce
    @JS(value = "return this.indexOf(value)")
    public native int indexOf(JSValue value);

    @JS.Coerce
    @JS(value = "return this.join(separator)")
    public native String join(String separator);

    @JS.Coerce
    @JS(value = "return this.keys()")
    public native JSValue keys();

    @JS.Coerce
    @JS(value = "return this.lastIndexOf(value)")
    public native int lastIndexOf(JSValue value);

    @JS.Coerce
    @JS(value = "return this.map(callback)")
    public native JSArray map(JSValue callback);

    @JS.Coerce
    @JS(value = "return this.pop()")
    public native JSValue pop();

    @JS.Coerce
    @JS(value = "this.push(value); return this")
    public native JSArray push(JSValue value);

    @JS.Coerce
    @JS(value = "return this.reduce(callback, initialValue)")
    public native JSValue reduce(JSValue callback, JSValue initialValue);

    @JS.Coerce
    @JS(value = "return this.reduceRight(callback, initialValue)")
    public native JSValue reduceRight(JSValue callback, JSValue initialValue);

    @JS.Coerce
    @JS(value = "this.reverse(); return this")
    public native JSArray reverse();

    @JS.Coerce
    @JS(value = "return this.shift()")
    public native JSValue shift();

    @JS.Coerce
    @JS(value = "return this.slice(start, end)")
    public native JSArray slice(int start, int end);

    @JS.Coerce
    @JS(value = "return this.some(callback)")
    public native boolean some(JSValue callback);

    @JS.Coerce
    @JS(value = "this.sort(); return this")
    public native JSArray sort();

    @JS.Coerce
    @JS(value = "return this.splice(start, deleteCount)")
    public native JSArray splice(int start, int deleteCount);

    @JS.Coerce
    @JS(value = "return this.toLocaleString()")
    public native String toLocaleString();

    @JS.Coerce
    @JS(value = "return this.toReversed()")
    public native JSArray toReversed();

    @JS.Coerce
    @JS(value = "return this.toSorted()")
    public native JSArray toSorted();

    @JS.Coerce
    @JS(value = "return this.toSpliced(start, deleteCount)")
    public native JSArray toSpliced(int start, int deleteCount);

    @JS.Coerce
    @JS(value = "return this.toString()")
    public native String toStringJS();

    @JS.Coerce
    @JS(value = "this.unshift(value); return this")
    public native JSArray unshift(JSValue value);

    @JS.Coerce
    @JS(value = "return this.values()")
    public native JSValue values();

    @JS.Coerce
    @JS(value = "return this.with(index, value)")
    public native JSArray with(int index, JSValue value);
}
