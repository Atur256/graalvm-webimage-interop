package builtin;

import org.graalvm.webimage.api.*;

import java.lang.String;


@JS.Import("Object")
public class Object extends JSObject {

    // TODO: Add methods directly to JSObject????

    @JS(value = "return Object.assign(target, source);")
    public static native JSObject assign(JSObject target, JSObject source);

    @JS("return Object.assign.apply(Object, [target].concat(Array.from(sources)));")
    public static native JSObject assign(JSObject target, JSObject... sources);

    @JS.Coerce
    @JS(value = "return Object.create(proto)")
    public static native JSObject create(JSObject proto);

    @JS(value = "return Object.create(proto, properties)")
    public static native JSObject create(JSObject proto, JSObject properties);

    @JS(value = "return Object.defineProperty(obj, prop, descriptor)")
    public static native JSObject defineProperty(JSObject obj, JSString prop, JSObject descriptor);

    @JS(value = "return Object.defineProperties(obj, prop)")
    public static native JSObject defineProperties(JSObject obj, JSObject prop);

    @JS(value = "return Object.entries(obj)")
    public static native JSObject entries(JSObject obj);

    @JS(value = "Object.freeze(obj)")
    public static native void freeze(JSObject obj);

    @JS(value = "return Object.fromEntries(iterable)")
    public static native JSObject fromEntries(JSObject iterable);

    @JS.Coerce
    @JS(value = "return Object.getOwnPropertyDescriptor(obj, prop)")
    public static native JSObject getOwnPropertyDescriptor(JSObject obj, java.lang.String prop);

    // TODO: don't know how to return a nested object
//    @JS("return Object.getOwnPropertyDescriptors(obj);")
//    public static native Object getOwnPropertyDescriptors(JSObject obj);

    @JS(value = "return Object.getOwnPropertyNames(obj)")
    public static native JSObject getOwnPropertyNames(JSObject obj);

    // TODO: cannot convert the JSSymbol to a String
//    @JS(value = "return Object.getOwnPropertySymbols(obj)")
//    public static native JSSymbol getOwnPropertySymbols(JSObject obj);

    @JS(value = "return Object.getPrototypeOf(obj)")
    public static native JSObject getPrototypeOf(JSObject obj);

    // TODO: don't know how to pass a runnable
//    @JS(value = "return Object.groupBy(items, callback)")
//    public native static JSObject groupBy(JSObject items, Runnable callback);

    @JS.Coerce
    @JS(value = "return Object.hasOwn(obj, prop)")
    public static native boolean hasOwn(JSObject obj, java.lang.String prop);

    @JS.Coerce
    @JS(value = "return Object.is(value1, value2)")
    public static native boolean is(JSObject value1, JSObject value2);

    @JS.Coerce
    @JS(value = "return Object.isExtensible(obj)")
    public static native boolean isExtensible(JSObject obj);

    @JS.Coerce
    @JS(value = "return Object.isFrozen(obj)")
    public static native boolean isFrozen(JSObject obj);

    @JS.Coerce
    @JS(value = "return Object.isSealed(obj)")
    public static native boolean isSealed(JSObject obj);

    @JS(value = "return Object.preventExtensions(obj)")
    public static native JSObject preventExtensions(JSObject obj);

    @JS(value = "return Object.seal(obj)")
    public static native JSObject seal(JSObject obj);

    @JS(value = "return Object.setPrototypeOf(obj, proto)")
    public static native JSObject setPrototypeOf(JSObject obj, JSObject proto);

    @JS(value = "return Object.values(obj)")
    public static native JSObject values(JSObject obj);

    @JS.Coerce
    @JS(value = "return this.hasOwnProperty(prop)")
    public native boolean hasOwnProperty(String prop);

//
//    @JS.Coerce
//    @JS(value = "return this.prototype.isPrototypeOf(obj)")
//    public native boolean isPrototypeOf(Object obj);


}


