package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


@JS.Import("Iterator")
public class JSIterator extends JSObject {

    @JS.Coerce
    @JS(value = "return Iterator.from(iterable)")
    public static native JSIterator from(JSValue iterable);

    @JS(value = "return this.drop(n)")
    public native JSIterator drop(int n);

    @JS.Coerce
    @JS(value = "return this.every(callback)")
    public native boolean every(JSFunction callback);

    @JS(value = "return this.filter(callback)")
    public native JSIterator filter(JSFunction callback);

    @JS(value = "return this.find(callback)")
    public native JSValue find(JSFunction callback);

    @JS(value = "return this.flatMap(callback)")
    public native JSIterator flatMap(JSFunction callback);

    @JS(value = "this.forEach(callback)")
    public native void forEach(JSFunction callback);

    @JS(value = "return this.map(callback)")
    public native JSIterator map(JSFunction callback);

    @JS(value = "return this.reduce(callback)")
    public native JSValue reduce(JSFunction callback);

    @JS(value = "return this.reduce(callback, initialValue)")
    public native JSValue reduce(JSFunction callback, JSValue initialValue);

    @JS.Coerce
    @JS(value = "return this.some(callback)")
    public native boolean some(JSFunction callback);

    @JS(value = "return this.take(n)")
    public native JSIterator take(int n);

    @JS.Coerce
    @JS(value = "return this.toArray()")
    public native JSArray toArray();
}
