package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.*;

import java.lang.Boolean;
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
    @JS(value = "return new Function('arg', body);")
    public static native JSFunction fromBody(String body);

    @JS.Coerce
    @JS(value = "return Function.apply(null, args);")
    public static native JSFunction fromArgs(String... args);

    @JS.Coerce
    @JS(value = "return function(args) { return javaFunc.apply(args); }")
    public static native <T, R> JSFunction fromFunc(Function<T, R> javaFunc);

    @JS.Coerce
    @JS(value = "return function(args) { return javaFunc.apply(args); }")
    public static native <T extends JSValue, R extends JSValue> JSFunction fromJSFunc(Function<T, R> javaFunc);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaBiFunc.apply(a, b); }")
    public static native <A, B, R> JSFunction fromBiFunc(BiFunction<A, B, R> javaBiFunc);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaBiFunc.apply(a, b); }")
    public static native <A extends JSValue, B extends JSValue, R extends JSValue> JSFunction fromJSBiFunc(BiFunction<A, B, R> javaBiFunc);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaTriFunction.apply(this, a, b); }")
    public static native <A, B, C, R> JSFunction fromTriFunc(TriFunction<A, B, C, R> javaTriFunction);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaTriFunction.apply(this, a, b); }")
    public static native <A extends JSValue, B extends JSValue, C extends JSValue, R extends JSValue> JSFunction fromJSTriFunc(TriFunction<A, B, C, R> javaTriFunction);

    @JS.Coerce
    @JS(value = "return function() { javaRunnable.run(); }")
    public static native JSFunction fromRun(Runnable javaRunnable);

    @JS.Coerce
    @JS(value = "return function(arg) { javaConsumer.accept(arg); }")
    public static native <T> JSFunction fromCons(Consumer<T> javaConsumer);

    @JS.Coerce
    @JS(value = "return function(arg) { javaConsumer.accept(arg); }")
    public static native <T extends JSValue> JSFunction fromJSCons(Consumer<T> javaConsumer);

    @JS.Coerce
    @JS(value = "return function(a, b) { javaBiConsumer.accept(a, b); }")
    public static native <A, B> JSFunction fromBiCons(BiConsumer<A, B> javaBiConsumer);

    @JS.Coerce
    @JS(value = "return function(a, b) { javaBiConsumer.accept(a, b); }")
    public static native <A extends JSValue, B extends JSValue> JSFunction fromJSBiCons(BiConsumer<A, B> javaBiConsumer);

    @JS.Coerce
    @JS(value = "return function(value, key) { javaTriConsumer.accept(this, value, key); }")
    public static native <A, B, C> JSFunction fromTriCons(TriConsumer<A, B, C> javaTriConsumer);

    @JS.Coerce
    @JS(value = "return function(value, key) { javaTriConsumer.accept(this, value, key); }")
    public static native <A extends JSValue, B extends JSValue, C extends JSValue> JSFunction fromJSTriCons(TriConsumer<A, B, C> javaTriConsumer);

    @JS.Coerce
    @JS(value = "return function() { return javaSupplier.get(); }")
    public static native <T> JSFunction fromSupp(Supplier<T> javaSupplier);

    // === WithThis Variants ===

    @JS.Coerce
    @JS(value = "return function(arg) { return javaFunction.apply(this); }")
    public static native <R> JSFunction fromThisFunc(Function<Object, R> javaFunction);

    @JS.Coerce
    @JS(value = "return function(arg) { return javaFunction.apply(this); }")
    public static native <R extends JSValue> JSFunction fromThisJSFunc(Function<JSObject, R> javaFunction);

    @JS.Coerce
    @JS(value = "return function(arg) { return javaBiFunction.apply(this, arg); }")
    public static native <T, R> JSFunction fromFuncWithThis(BiFunction<Object, T, R> javaBiFunction);

    @JS.Coerce
    @JS(value = "return function(arg) { return javaBiFunction.apply(this, arg); }")
    public static native <T extends JSValue, R extends JSValue> JSFunction fromJSFuncWithThis(BiFunction<JSObject, T, R> javaBiFunction);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaTriFunc.apply(this, a, b); }")
    public static native <A, B, R> JSFunction fromBiFuncWithThis(TriFunction<Object, A, B, R> javaTriFunc);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaTriFunc.apply(this, a, b); }")
    public static native <A extends JSValue, B extends JSValue, R extends JSValue> JSFunction fromJSBiFuncWithThis(TriFunction<JSObject, A, B, R> javaTriFunc);

    @JS.Coerce
    @JS(value = "return function(arg) { javaConsumer.accept(this); }")
    public static native JSFunction fromThisCons(Consumer<Object> javaConsumer);

    @JS.Coerce
    @JS(value = "return function(arg) { javaConsumer.accept(this); }")
    public static native JSFunction fromThisJSCons(Consumer<JSObject> javaConsumer);

    @JS.Coerce
    @JS(value = "return function(arg) { javaBiConsumer.accept(this, arg); }")
    public static native <T> JSFunction fromConsWithThis(BiConsumer<Object, T> javaBiConsumer);

    @JS.Coerce
    @JS(value = "return function(arg) { javaBiConsumer.accept(this, arg); }")
    public static native <T extends JSValue> JSFunction fromJSConsWithThis(BiConsumer<JSObject, T> javaBiConsumer);

    @JS.Coerce
    @JS(value = "return function(a, b) { javaTriConsumer.accept(this, a, b); }")
    public static native <A, B> JSFunction fromBiConsWithThis(TriConsumer<Object, A, B> javaTriConsumer);

    @JS.Coerce
    @JS(value = "return function(a, b) { javaTriConsumer.accept(this, a, b); }")
    public static native <A extends JSValue, B extends JSValue> JSFunction fromJSBiConsWithThis(TriConsumer<JSObject, A, B> javaTriConsumer);

    // === Invocation Methods ===
    @JS.Coerce
    @JS(value = "return this(arg);")
    public native <T> Object callJS(T arg); // Call with arg and no coercion (raw Object return)

    public <T, R> R callJS(T args, Class<R> cls) {
        return JSValue.checkedCoerce(callJS(args), cls);
    }

    @JS(value = "return this(arg);")
    public native <T, R> R call(T arg);

    @JS(value = "return this(arg1, arg2);")
    public native <T, R, Q> R call(T arg1, Q arg2);

    @JS.Coerce
    @JS(value = "return this();")
    public native <R> R call();

    @JS.Coerce
    @JS(value = "return this.apply(thisArg, argsJSArray);")
    public native Object applyGeneral(JSValue thisArg, JSValue argsJSArray);

    @JS.Coerce
    @JS(value = "return this.apply(thisArg, argsJSArray);")
    public native <R> R apply(JSValue thisArg, JSValue argsJSArray);

    @SafeVarargs
    @JS.Coerce
    @JS(value = "return this.apply(thisArg, args);")
    public final native <T, R, Q> R apply(Q thisArg, T... args);

    @SafeVarargs
    @JS(value = "return this.apply(thisArg, args);")
    public final native <T, Q> Object applyRaw(Q thisArg, T... args); // Apply with varargs and no coercion (raw Object return)

    @JS.Coerce
    @JS(value = "return this.apply(thisArg, args);")
    public native <T> Object applyJS(Object thisArg, T args);

    @SuppressWarnings("unchecked")
    public <T, R> R applyJS(Object thisArg, T args, Class<R> cls) {
        Object result = applyJS(thisArg, args);
        if(result instanceof JSValue jsResult) return jsResult.as(cls);
        return (R) result;
    }

    private JSValue toJSValue(Object arg) {
        if(arg instanceof Object[] array) {
            JSArray jsArray = new JSArray();
            for(Object item : array) {
                jsArray.push(toJSValue(item));
            }
            return jsArray;
        }

        if(arg instanceof int[] array) {
            JSArray jsArray = new JSArray();
            for(int item : array) {
                jsArray.push(JSNumber.of(item));
            }
            return jsArray;
        }

        return switch(arg) {
            case null -> JSUndefined.instance();
            case JSValue jsValue -> jsValue;
            case String s -> JSString.of(s);
            case Boolean b -> JSBoolean.of(b);
            case Integer i -> JSNumber.of(i.longValue());
            case Long l -> JSNumber.of(l);
            case Short s -> JSNumber.of(s.longValue());
            case Byte b -> JSNumber.of(b.longValue());
            case Float f -> JSNumber.of(f.doubleValue());
            case Double d -> JSNumber.of(d);
            default -> JSString.of(arg.toString());
        };
    }

    @JS.Coerce
    @JS(value = "return this.bind(thisArg);")
    public native JSFunction bind(JSValue thisArg);

    public final <T> JSFunction bind(T thisArg) {
        return bind(toJSValue(thisArg));
    }

    @JS.Coerce
    @JS(value = "return this.call.apply(this, [thisArg, ...args]);")
    public native <R> R callWithSpreadArgs(JSValue thisArg, JSArray args);

    @SafeVarargs
    public final <T, R> R callWithSpreadArgs(JSValue thisArg, T... args) {
        JSArray jsArgs = new JSArray();
        for(T arg : args) {
            jsArgs.push(toJSValue(arg));
        }
        return callWithSpreadArgs(thisArg, jsArgs);
    }

    @JS.Coerce
    @JS(value = "return this.toString();")
    public native String toJSString();

    public String toString() {
        return "<JavaScript<" + typeof() + "; " + toJSString() + ">";
    }
}
