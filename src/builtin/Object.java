package builtin;

import org.graalvm.webimage.api.*;

@JS.Import("Object")
public class Object extends JSObject {

    // TODO: both assign methods to not correctly work as the only return the unchanged target

    @JS(value = "return Object.assign(target, source);")
    public native static JSObject assign(JSObject target, JSObject source);

    @JS(value = """
    var srcs = Array.prototype.slice.call(sources);
    var args = [target].concat(srcs.map(s => Object.assign({}, s)));
    return Object.assign.apply(target, args);
    """)
    public native static JSObject assign(JSObject target, JSObject... sources);

    @JS(value = "return Object.create(proto)")
    public native static JSObject create(JSObject proto);

    @JS(value = "return Object.create(proto, properties)")
    public native static JSObject create(JSObject proto, JSObject properties);

    @JS(value = "return Object.defineProperty(obj, prop, descriptor)")
    public native static JSObject defineProperty(JSObject obj, JSString prop, JSObject descriptor);

    @JS(value = "return Object.defineProperties(obj, prop)")
    public native static JSObject defineProperties(JSObject obj, JSObject prop);

    @JS(value = "return Object.entries(obj)")
    public native static JSObject entries(JSObject obj);

    @JS(value = "Object.freeze(obj)")
    public native static void freeze(JSObject obj);

    @JS(value = "return Object.fromEntries(iterable)")
    public native static JSObject fromEntries(JSObject iterable);

    @JS.Coerce
    @JS(value = "return Object.getOwnPropertyDescriptor(obj, prop)")
    public native static JSObject getOwnPropertyDescriptor(JSObject obj, String prop);

    @JS(value = "return Object.getOwnPropertyDescriptors(obj)")
    public native static JSObject getOwnPropertyDescriptors(JSObject obj);

    @JS(value = "return Object.getOwnPropertyNames(obj)")
    public native static JSObject getOwnPropertyNames(JSObject obj);

    @JS(value = "return Object.getOwnPropertySymbols(obj)")
    public native static JSObject getOwnPropertySymbols(JSObject obj);

    @JS(value = "return Object.getPrototypeOf(obj)")
    public native static JSObject getPrototypeOf(JSObject obj);

    // TODO: don't know how to pass a runnable
//    @JS(value = "return Object.groupBy(items, callback)")
//    public native static JSObject groupBy(JSObject items, Runnable callback);


    @JS.Coerce
    @JS(value = "return Object.hasOwn(obj, prop)")
    public native static boolean hasOwn(JSObject obj, String prop);

    @JS.Coerce
    @JS(value = "return Object.is(value1, value2)")
    public native static boolean is(JSObject value1, JSObject value2);

    @JS.Coerce
    @JS(value = "return Object.isExtensible(obj)")
    public native static boolean isExtensible(JSObject obj);

    @JS.Coerce
    @JS(value = "return Object.isFrozen(obj)")
    public native static boolean isFrozen(JSObject obj);

    @JS.Coerce
    @JS(value = "return Object.isSealed(obj)")
    public native static boolean isSealed(JSObject obj);

    @JS(value = "return Object.preventExtensions(obj)")
    public native static JSObject preventExtensions(JSObject obj);

    @JS(value = "return Object.seal(obj)")
    public native static JSObject seal(JSObject obj);

    @JS(value = "return Object.setPrototypeOf(obj, proto)")
    public native static JSObject setPrototypeOf(JSObject obj, JSObject proto);

    @JS(value = "return Object.values(obj)")
    public native static JSObject values(JSObject obj);
}


