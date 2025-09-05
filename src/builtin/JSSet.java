package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


@JS.Import("Set")
public class JSSet extends JSObject {

    public int size;

    @JS(value = "return this.add(value)")
    public native JSSet add(JSValue value);

    @JS(value = "this.clear()")
    public native void clear();

    @JS.Coerce
    @JS(value = "return this.delete(value)")
    public native boolean delete(JSValue value);

    @JS.Coerce
    @JS(value = "return this.difference(other)")
    public native JSSet difference(JSSet other);

    @JS(value = "return this.entries()")
    public native JSValue entries(); // TODO: should be replaced by a Iterator but currently not implemented

    @JS(value = "this.forEach(callback)")
    public native void forEach(JSValue callback);

    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSValue callback, JSValue thisArg);

    @JS.Coerce
    @JS(value = "return this.has(value)")
    public native boolean has(JSValue value);

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

    @JS(value = "return this.keys()")
    public native JSValue keys(); // TODO: should be replaced by a Iterator but currently not implemented

    @JS.Coerce
    @JS(value = "return this.symmetricDifference(other)")
    public native JSSet symmetricDifference(JSSet other);

    @JS.Coerce
    @JS(value = "return this.union(other)")
    public native JSSet union(JSSet other);

    @JS(value = "return this.values()")
    public native JSValue values(); // TODO: should be replaced by a Iterator but currently not implemented

}
