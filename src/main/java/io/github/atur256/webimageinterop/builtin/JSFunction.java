package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.*;

import java.lang.String;
import java.util.function.*;
import java.lang.Object;


@JS.Import("Function")
public class JSFunction extends JSObject {

    public int length;

    public String name;

    public JSValue prototype;

    // === Factory Methods ===

    @JS.Coerce
    @JS("return new Function('arg', body);")
    public static native JSFunction fromBody(String body);

    @JS.Coerce
    @JS("return new Function(...Array.from(args));")
    public static native JSFunction fromArgs(String... args);

    @JS.Coerce
    @JS("return function(args) { return javaFunc(args); }")
    public static native <T, R> JSFunction fromFunc(Function<T, R> javaFunc);

    @JS.Coerce
    @JS("return function(a, b) { return javaBiFunc(a, b); }")
    public static native <A, B, R> JSFunction fromBiFunc(BiFunction<A, B, R> javaBiFunc);

    @JS.Coerce
    @JS("return function(a, b, c) { return javaTriFunction(a,b, c); }")
    public static native <A, B, C, R> JSFunction fromTriFunc(TriFunction<A, B, C, R> javaTriFunction);

    @JS.Coerce
    @JS("return function() { javaRunnable(); }")
    public static native JSFunction fromRun(Runnable javaRunnable);

    @JS.Coerce
    @JS("return function(arg) { javaConsumer(arg); }")
    public static native <T> JSFunction fromCons(Consumer<T> javaConsumer);

    @JS.Coerce
    @JS("return function(a, b) { javaBiConsumer(a, b); }")
    public static native <A, B> JSFunction fromBiCons(BiConsumer<A, B> javaBiConsumer);

    @JS.Coerce
    @JS("return function(a, b, c) { javaTriConsumer(a, b, c); }")
    public static native <A, B, C> JSFunction fromTriCons(TriConsumer<A, B, C> javaTriConsumer);

    @JS.Coerce
    @JS("return function() { return javaSupplier(); }")
    public static native <A> JSFunction fromSupp(Supplier<A> javaSupplier);

    // === WithThis Variants ===

    @JS.Coerce
    @JS("return function(arg) { return javaFunction(this); }")
    public static native <A, R> JSFunction fromThisFunc(Function<A, R> javaFunction);

    @JS.Coerce
    @JS("return function(arg) { return javaBiFunction(this, arg); }")
    public static native <A, B, R> JSFunction fromFuncWithThis(BiFunction<A, B, R> javaBiFunction);

    @JS.Coerce
    @JS("return function(a, b) { return javaTriFunc(this, a, b); }")
    public static native <A, B, C, R> JSFunction fromBiFuncWithThis(TriFunction<A, B, C, R> javaTriFunc);

    @JS.Coerce
    @JS("return function(arg) { javaConsumer(this); }")
    public static native <A> JSFunction fromThisCons(Consumer<A> javaConsumer);

    @JS.Coerce
    @JS("return function(arg) { javaBiConsumer(this, arg); }")
    public static native <A, B> JSFunction fromConsWithThis(BiConsumer<A, B> javaBiConsumer);

    @JS.Coerce
    @JS("return function(a, b) { javaTriConsumer(this, a, b); }")
    public static native <A, B, C> JSFunction fromBiConsWithThis(TriConsumer<A, B, C> javaTriConsumer);

    // === Invocation Methods ===

    @JS.Coerce
    @JS("return this(...args);")
    private native Object invokeJSImpl(JSArray args);

    public Object invokeJS(Object... args) {
        return invokeJSImpl(coerceJSArray(args));
    }

    public <R> R invokeJS(Class<R> cls, Object... args) {
        return JSValue.checkedCoerce(invokeJS(args), cls);
    }

    public <R> R invoke(Class<R> cls, Object... args) {
        return JSValue.checkedCoerce(this.invoke(args), cls);
    }

    public Object callJS(Object self, Object... args) {
        return this.call(self, coerceArray(args));
    }

    public <R> R callJS(Class<R> cls, Object self, Object... args) {
        return JSValue.checkedCoerce(callJS(self, args), cls);
    }

    public <R> R call(Class<R> cls, Object self, Object... args) {
        return JSValue.checkedCoerce(this.call(self, args), cls);
    }

    private static JSArray coerceJSArray(Object... args) {
        JSArray argsArray = JSArray.of();
        for(Object arg : args) {
            argsArray.push(coerce(arg));
        }
        return argsArray;
    }

    private static Object[] coerceArray(Object... args) {
        Object[] argsArray = new Object[args.length];
        for(int i = 0; i < args.length; i++) {
            argsArray[i] = coerce(args[i]);
        }
        return argsArray;
    }

    @JS.Coerce
    @JS("return arg;")
    private static native Object coerce(Object arg);

    @JS.Coerce
    @JS("return this.bind(thisArg);")
    public native <T> JSFunction bindJS(T thisArg);

    @JS("return this.bind(thisArg);")
    private native <T> Object bindImpl(T thisArg);

    public <T> JSFunction bind(T thisArg) {
        return JSValue.checkedCoerce(bindImpl(thisArg), JSFunction.class);
    }

    @JS.Coerce
    @JS("return this.toString();")
    public native String toJSString();

    public String toString() {
        return "<JavaScript<" + typeof() + "; " + toJSString() + ">";
    }
}
