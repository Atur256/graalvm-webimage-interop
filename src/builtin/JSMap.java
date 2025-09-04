package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


@JS.Import("Map")
public class JSMap extends JSObject {

    @JS(value = "this.clear()")
    public native void clear();

    @JS.Coerce
    @JS(value = "return this.delete(key)")
    public native boolean delete(JSValue key);

    @JS(value = "return this.entries()")
    public native JSValue entries(); // TODO: should be replaced by a Iterator but currently not implemented

    @JS(value = "this.forEach(callback)")
    public native void forEach(JSValue callback);

    @JS(value = "this.forEach(callback, thisArg)")
    public native void forEach(JSValue callback, JSValue thisArg);

    @JS(value = "return this.get(key)")
    public native JSValue get(JSValue key);

    @JS.Coerce
    @JS(value = "return this.has(key)")
    public native boolean has(JSValue key);

    @JS(value = "return this.keys()")
    public native JSValue keys(); // TODO: should be replaced by a Iterator but currently not implemented

    @JS(value = "return this.set(key, value)")
    public native void set(JSValue key, JSValue value);

    @JS(value = "return this.values()")
    public native JSValue values(); // TODO: should be replaced by a Iterator but currently not implemented

    @JS.Coerce
    @JS(value = "return this.size")
    public native int size();

}
