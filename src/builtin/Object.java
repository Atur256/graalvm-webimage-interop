package builtin;

import org.graalvm.webimage.api.*;

import java.lang.String;


@JS.Import("Object")
public class Object extends JSObject {

    // TODO: Add methods directly to JSObject


    @JS(value = "return Object.groupBy(items, callback)")
    public native static JSObject groupBy(JSObject items, Runnable callback);

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


