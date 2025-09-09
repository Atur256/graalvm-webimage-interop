package builtin;

import org.graalvm.webimage.api.*;

import java.lang.Boolean;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


@JS.Import("Function")
public class JSFunction extends JSObject {

    public int length;

    public String name;

    public JSValue prototype;

    // === JS Function Constructors ===

    @JS.Coerce
    @JS(value = "return new Function('arg', body)")
    public static native JSFunction fromBody(String body);

    @JS.Coerce
    @JS(value = "return Function.apply(null, args)")
    public static native JSFunction fromArgs(String[] args);

    // === Java Lambda Wrappers ===

    @JS.Coerce
    @JS(value = "return function(args) { return javaFunc.apply(args); }")
    public static native <T, R> JSFunction fromFunction(Function<T, R> javaFunc);

    @JS.Coerce
    @JS(value = "return function(a, b) { return javaBiFunc.apply(a, b); }")
    public static native <A, B, R> JSFunction fromBiFunction(java.util.function.BiFunction<A, B, R> javaBiFunc);

    @JS.Coerce
    @JS(value = "return function() { javaRunnable.run(); }")
    public static native JSFunction fromRunnable(Runnable javaRunnable);

    @JS.Coerce
    @JS(value = "return function(arg) { javaConsumer.accept(arg); }")
    public static native <T> JSFunction fromConsumer(Consumer<T> javaConsumer);

    @JS.Coerce
    @JS(value = "return function(a, b) { javaBiConsumer.accept(a, b); }")
    public static native <A, B> JSFunction fromBiConsumer(java.util.function.BiConsumer<A, B> javaBiConsumer);

    @JS.Coerce
    @JS(value = "return function() { return javaSupplier.get(); }")
    public static native <T> JSFunction fromSupplier(Supplier<T> javaSupplier);

    // === Call Overloads ===

    @JS.Coerce
    @JS(value = "return this(arg)")
    public native <T, R> R callJS(T arg); // If function is a JS function and not a Java function

    @JS(value = "return this(arg)")
    public native <T, R> R call(T arg);

    @JS(value = "return this(arg1, arg2)")
    public native <T, R, Q> R call(T arg1, Q arg2);

    @JS.Coerce
    @JS(value = "return this()")
    public native <R> R call();

    // === Apply Overloads ===

    @JS.Coerce
    @JS(value = "return this.apply(thisArg, argsJSArray)")
    public native <R> R apply(JSValue thisArg, JSValue argsJSArray);

    @SafeVarargs
    public final <T, R, Q> R apply(Q thisArg, T... args) {
        JSArray jsArgs = new JSArray();
        for(T arg : args) {
            jsArgs.push(toJSValue(arg));
        }
        return apply(toJSValue(thisArg), jsArgs);
    }

    private JSValue toJSValue(java.lang.Object arg) {
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
            default -> JSString.of(arg.toString()); // TODO: custom classes do currently not work
        };
    }

    // === Bind ===

    @JS.Coerce
    @JS(value = "return this.bind(thisArg)")
    public native JSFunction bind(JSValue thisArg);

    public final <T> JSFunction bind(T thisArg) {
        return bind(toJSValue(thisArg));
    }

    // === Call with Spread ===

    @JS.Coerce
    @JS(value = "return this.call.apply(this, [thisArg, ...args])")
    public native <R> R callWithSpreadArgs(JSValue thisArg, JSArray args);

    @SafeVarargs
    public final <T, R> R callWithSpreadArgs(JSValue thisArg, T... args) {
        JSArray jsArgs = new JSArray();
        for(T arg : args) {
            jsArgs.push(toJSValue(arg));
        }
        return callWithSpreadArgs(thisArg, jsArgs);
    }

    // === ToString ===

    @JS.Coerce
    @JS(value = "return this.toString()")
    public native String toStringJS();
}

