/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.atur256.graalvmwebimageinterop.builtin;

import org.graalvm.webimage.api.*;

import java.util.function.*;


/**
 * Provides a Java binding for the JavaScript {@code Function} object within the WebImage interop layer.
 * This class enables dynamic creation and invocation of JavaScript functions from Java.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSFunction jsFunc = JSFunction.of(() -> JSNumber.of(42));
 * int result = jsFunc.invoke(Integer.class);
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Function")
public class JSFunction extends JSObject {

    /**
     * The number of expected arguments.
     */
    public int length;

    /**
     * The name of the function.
     */
    public String name;

    /**
     * The prototype object of the function.
     */
    public JSValue prototype;


    // === Factory Methods ===


    /**
     * Creates a JavaScript function with a single argument named {@code arg} and the given body.
     *
     * @param body the JavaScript function body
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return new Function('arg', body);")
    public static native JSFunction fromBody(String body);

    /**
     * Creates a new JavaScript function from the given parameter names and function body.
     *
     * @param params the names of the function parameters
     * @param body   the JavaScript function body
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return new Function(...Array.from(params), body);")
    public static native JSFunction fromArgs(String[] params, String body);

    /**
     * Wraps a generic Java object into a JavaScript function.
     * <p>
     * The Java object must be a callable Java interface.
     *
     * @param f the Java object to wrap
     * @return a new {@code JSFunction} wrapping {@code f}
     */
    @JS.Coerce
    @JS("return function(...args) { return f(...args); }")
    public static native JSFunction of(Object f);

    /**
     * Wraps a Java {@link Function} into a JavaScript function.
     *
     * @param javaFunc the Java function to wrap
     * @param <T>      the input type
     * @param <R>      the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(args) { return javaFunc(args); }")
    public static native <T, R> JSFunction of(Function<T, R> javaFunc);

    /**
     * Wraps a Java {@link BiFunction} into a JavaScript function.
     *
     * @param javaBiFunc the Java bi-function to wrap
     * @param <A>        the first input type
     * @param <B>        the second input type
     * @param <R>        the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(a, b) { return javaBiFunc(a, b); }")
    public static native <A, B, R> JSFunction of(BiFunction<A, B, R> javaBiFunc);

    /**
     * Wraps a Java {@code TriFunction} into a JavaScript function.
     *
     * @param javaTriFunction the Java tri-function to wrap
     * @param <A>             the first input type
     * @param <B>             the second input type
     * @param <C>             the third input type
     * @param <R>             the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(a, b, c) { return javaTriFunction(a,b, c); }")
    public static native <A, B, C, R> JSFunction of(TriFunction<A, B, C, R> javaTriFunction);

    /**
     * Wraps a Java {@link Runnable} into a JavaScript function with no arguments.
     *
     * @param javaRunnable the Java runnable to wrap
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function() { javaRunnable(); }")
    public static native JSFunction of(Runnable javaRunnable);

    /**
     * Wraps a Java {@link Consumer} into a JavaScript function.
     *
     * @param javaConsumer the Java consumer to wrap
     * @param <T>          the input type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(arg) { javaConsumer(arg); }")
    public static native <T> JSFunction of(Consumer<T> javaConsumer);

    /**
     * Wraps a Java {@link BiConsumer} into a JavaScript function.
     *
     * @param javaBiConsumer the Java bi-consumer to wrap
     * @param <A>            the first input type
     * @param <B>            the second input type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(a, b) { javaBiConsumer(a, b); }")
    public static native <A, B> JSFunction of(BiConsumer<A, B> javaBiConsumer);

    /**
     * Wraps a Java {@code TriConsumer} into a JavaScript function.
     *
     * @param javaTriConsumer the Java tri-consumer to wrap
     * @param <A>             the first input type
     * @param <B>             the second input type
     * @param <C>             the third input type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(a, b, c) { javaTriConsumer(a, b, c); }")
    public static native <A, B, C> JSFunction of(TriConsumer<A, B, C> javaTriConsumer);

    /**
     * Wraps a Java {@link Supplier} into a JavaScript function with no arguments.
     *
     * @param javaSupplier the Java supplier to wrap
     * @param <A>          the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function() { return javaSupplier(); }")
    public static native <A> JSFunction of(Supplier<A> javaSupplier);


    // === WithThis Variants ===

    /**
     * Wraps a generic Java object into a JavaScript function that uses {@code this} as the first argument.
     * <p>
     * The Java object must be a callable Java interface.
     *
     * @param f the Java object to wrap
     * @return a new {@code JSFunction} wrapping {@code f}, using {@code this} as the first argument
     */
    @JS.Coerce
    @JS("return function(...args) { return f(this, ...args); }")
    public static native JSFunction withThis(Object f);

    /**
     * Wraps a Java {@link Function} into a JavaScript function that uses {@code this} as the input.
     *
     * @param javaFunction the Java function to wrap
     * @param <A>          the input type (bound to {@code this})
     * @param <R>          the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(arg) { return javaFunction(this); }")
    public static native <A, R> JSFunction withThis(Function<A, R> javaFunction);

    /**
     * Wraps a Java {@link BiFunction} into a JavaScript function that uses {@code this} as the first argument.
     *
     * @param javaBiFunction the Java bi-function to wrap
     * @param <A>            the first input type (bound to {@code this})
     * @param <B>            the second input type
     * @param <R>            the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(arg) { return javaBiFunction(this, arg); }")
    public static native <A, B, R> JSFunction withThis(BiFunction<A, B, R> javaBiFunction);

    /**
     * Wraps a Java {@code TriFunction} into a JavaScript function that uses {@code this} as the first argument.
     *
     * @param javaTriFunc the Java tri-function to wrap
     * @param <A>         the first input type (bound to {@code this})
     * @param <B>         the second input type
     * @param <C>         the third input type
     * @param <R>         the return type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(a, b) { return javaTriFunc(this, a, b); }")
    public static native <A, B, C, R> JSFunction withThis(TriFunction<A, B, C, R> javaTriFunc);

    /**
     * Wraps a Java {@link Consumer} into a JavaScript function that passes {@code this} as the input.
     *
     * @param javaConsumer the Java consumer to wrap
     * @param <A>          the input type (bound to {@code this})
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(arg) { javaConsumer(this); }")
    public static native <A> JSFunction withThis(Consumer<A> javaConsumer);

    /**
     * Wraps a Java {@link BiConsumer} into a JavaScript function that uses {@code this} as the first argument.
     *
     * @param javaBiConsumer the Java bi-consumer to wrap
     * @param <A>            the first input type (bound to {@code this})
     * @param <B>            the second input type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(arg) { javaBiConsumer(this, arg); }")
    public static native <A, B> JSFunction withThis(BiConsumer<A, B> javaBiConsumer);

    /**
     * Wraps a Java {@code TriConsumer} into a JavaScript function that uses {@code this} as the first argument.
     *
     * @param javaTriConsumer the Java tri-consumer to wrap
     * @param <A>             the first input type (bound to {@code this})
     * @param <B>             the second input type
     * @param <C>             the third input type
     * @return a new {@code JSFunction}
     */
    @JS.Coerce
    @JS("return function(a, b) { javaTriConsumer(this, a, b); }")
    public static native <A, B, C> JSFunction withThis(TriConsumer<A, B, C> javaTriConsumer);


    // === Invocation Methods ===

    /**
     * Invokes the JavaScript function with the given arguments.
     *
     * @param args the arguments to pass
     * @return the raw result of the invocation
     */
    public Object invokeRaw(Object... args) {
        return this.invoke(coerceArray(args));
    }

    /**
     * Invokes the JavaScript function and coerces the result to the specified type.
     *
     * @param cls  the target class for coercion
     * @param args the arguments to pass
     * @param <R>  the result type
     * @return the coerced result
     */
    public <R> R invokeRaw(Class<R> cls, Object... args) {
        return JSValue.checkedCoerce(invokeRaw(args), cls);
    }

    /**
     * Invokes the JavaScript function and coerces the result to the specified type.
     * This variant uses the {@code invoke} method inherited from {@link JSObject}.
     *
     * @param cls  the target class for coercion
     * @param args the arguments to pass
     * @param <R>  the result type
     * @return the coerced result
     */
    public <R> R invoke(Class<R> cls, Object... args) {
        return JSValue.checkedCoerce(this.invoke(args), cls);
    }

    /**
     * Calls the JavaScript function with a specified {@code this} context and arguments.
     *
     * @param self the {@code this} context
     * @param args the arguments to pass
     * @return the raw result of the call
     */
    public Object callRaw(Object self, Object... args) {
        return this.call(self, coerceArray(args));
    }

    /**
     * Calls the JavaScript function with a {@code this} context and coerces the result.
     *
     * @param cls  the target class for coercion
     * @param self the {@code this} context
     * @param args the arguments to pass
     * @param <R>  the result type
     * @return the coerced result
     */
    public <R> R callRaw(Class<R> cls, Object self, Object... args) {
        return JSValue.checkedCoerce(callRaw(self, args), cls);
    }

    /**
     * Calls the JavaScript function with a {@code this} context and coerces the result.
     * This variant uses the {@code call} method inherited from {@link JSObject}.
     *
     * @param cls  the target class for coercion
     * @param self the {@code this} context
     * @param args the arguments to pass
     * @param <R>  the result type
     * @return the coerced result
     */
    public <R> R call(Class<R> cls, Object self, Object... args) {
        return JSValue.checkedCoerce(this.call(self, args), cls);
    }


    // === Conversion Utilities ===

    /**
     * Converts a variable-length list of Java arguments into a plain {@code Object[]} array,
     * applying JavaScript-compatible coercion to each element.
     *
     * @param args the Java arguments to convert
     * @return an {@code Object[]} array of coerced values
     */
    private static Object[] coerceArray(Object... args) {
        Object[] argsArray = new Object[args.length];
        for(int i = 0; i < args.length; i++) {
            argsArray[i] = coerce(args[i]);
        }
        return argsArray;
    }

    /**
     * Coerces a single Java object into a JavaScript-compatible value.
     *
     * @param arg the Java object to coerce
     * @return the JavaScript-compatible value
     */
    @JS.Coerce
    @JS("return arg;")
    private static native Object coerce(Object arg);


    // === Binding Methods ===

    /**
     * Binds the JavaScript function to the specified {@code this} context and returns a new {@code JSFunction}.
     * This method uses JavaScript coercion to ensure the result is a valid function.
     *
     * @param thisArg the object to bind as {@code this}
     * @param <T>     the type of the {@code this} context
     * @return a new bound {@code JSFunction}
     */
    @JS.Coerce
    @JS("return this.bind(thisArg);")
    public native <T> JSFunction bindRaw(T thisArg);

    /**
     * Binds the JavaScript function to the specified {@code this} context.
     * This method returns a raw JavaScript object before coercion.
     *
     * @param thisArg the object to bind as {@code this}
     * @param <T>     the type of the {@code this} context
     * @return the bound function as a raw object
     */
    @JS("return this.bind(thisArg);")
    private native <T> Object bindImpl(T thisArg);

    /**
     * Binds the JavaScript function to the specified {@code this} context and coerces the result to {@code JSFunction}.
     *
     * @param thisArg the object to bind as {@code this}
     * @param <T>     the type of the {@code this} context
     * @return a new bound {@code JSFunction}
     */
    public <T> JSFunction bind(T thisArg) {
        return JSValue.checkedCoerce(bindImpl(thisArg), JSFunction.class);
    }


    // === String Methods ===

    /**
     * Returns the JavaScript string representation of the function.
     * Equivalent to calling {@code Function.prototype.toString()} in JavaScript.
     *
     * @return the raw JavaScript function as a string
     */
    @JS.Coerce
    @JS("return this.toString();")
    public native String toJSString();
}
