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

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


/**
 * Provides a Java binding for the JavaScript {@code Iterator} object within the WebImage interop layer.
 * This class enables fluent, functional-style iteration over JavaScript iterables.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSIterator iter = JSIterator.from(someJSArray);
 * JSArray result = iter.filter(fn).map(fn2).toArray();
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Iterator")
public class JSIterator extends JSObject {

    // === Factory Method ===

    /**
     * Creates a {@code JSIterator} from a JavaScript iterable.
     *
     * @param iterable the JavaScript iterable to wrap
     * @return a new {@code JSIterator}
     */
    @JS.Coerce
    @JS("return Iterator.from(iterable);")
    public static native JSIterator from(JSValue iterable);


    // === Transformation Methods ===

    /**
     * Skips the first {@code n} elements of the iterator.
     *
     * @param n the number of elements to drop
     * @return a new {@code JSIterator} with remaining elements
     */
    @JS.Coerce
    @JS("return this.drop(n);")
    public native JSIterator drop(int n);

    /**
     * Filters the iterator using the given predicate function.
     *
     * @param callback the predicate function
     * @return a new {@code JSIterator} containing matching elements
     */
    @JS.Coerce
    @JS("return this.filter(callback);")
    public native JSIterator filter(JSFunction callback);

    /**
     * Applies a mapping function to each element of the iterator.
     *
     * @param callback the mapping function
     * @return a new {@code JSIterator} with transformed elements
     */
    @JS.Coerce
    @JS("return this.map(callback);")
    public native JSIterator map(JSFunction callback);

    /**
     * Applies a mapping function to each element and flattens the result.
     *
     * @param callback the mapping function
     * @return a new {@code JSIterator} with flattened output
     */
    @JS.Coerce
    @JS("return this.flatMap(callback);")
    public native JSIterator flatMap(JSFunction callback);

    /**
     * Takes the first {@code n} elements from the iterator.
     *
     * @param n the number of elements to take
     * @return a new {@code JSIterator} with the selected elements
     */
    @JS.Coerce
    @JS("return this.take(n);")
    public native JSIterator take(int n);


    // === Predicate Methods ===

    /**
     * Tests whether all elements in the iterator satisfy the given predicate.
     *
     * @param callback the predicate function to apply
     * @return {@code true} if all elements pass the test, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.every(callback);")
    public native boolean every(JSFunction callback);

    /**
     * Tests whether at least one element in the iterator satisfies the given predicate.
     *
     * @param callback the predicate function to apply
     * @return {@code true} if any element passes the test, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.some(callback);")
    public native boolean some(JSFunction callback);


    // === Search Methods ===

    /**
     * Returns the first element in the iterator that satisfies the given predicate.
     *
     * @param callback the predicate function to apply
     * @return the first matching element, or {@code null} if none found
     */
    @JS.Coerce
    @JS("return this.find(callback);")
    public native Object find(JSFunction callback);

    /**
     * Returns the first matching element coerced to the specified type.
     *
     * @param callback the predicate function to apply
     * @param cls      the target class for coercion
     * @param <R>      the result type
     * @return the coerced matching element, or {@code null} if none found
     */
    public <R> R find(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(find(callback), cls);
    }


    // === Reduction Methods ===

    /**
     * Reduces the iterator using the provided callback.
     *
     * @param callback a {@link JSFunction} reducer
     * @return the reduced result
     */
    @JS.Coerce
    @JS("return this.reduce(callback);")
    private native Object reduceJS(JSFunction callback);

    /**
     * Reduces the iterator using the provided callback and initial value.
     *
     * @param callback     a {@link JSFunction} reducer
     * @param initialValue the initial value
     * @param <T>          the type of the initial value
     * @return the reduced result
     */
    @JS.Coerce
    @JS("return this.reduce(callback, initialValue);")
    private native <T> Object reduceJS(JSFunction callback, T initialValue);

    /**
     * Reduces the iterator using the provided callback and coerces the result into the specified type.
     *
     * @param callback a {@link JSFunction} reducer
     * @param cls      the target class
     * @param <R>      the result type
     * @return the coerced result
     */
    public <R> R reduce(JSFunction callback, Class<R> cls) {
        Object result = reduceJS(callback);
        return JSValue.checkedCoerce(result, cls);
    }

    /**
     * Reduces the iterator using the provided callback and an initial value, coerced into the specified type.
     *
     * @param callback     a {@link JSFunction} reducer
     * @param initialValue the initial value for reduction
     * @param cls          the target class
     * @param <R>          the result type
     * @return the coerced result
     */
    public <R> R reduce(JSFunction callback, R initialValue, Class<R> cls) {
        Object result = reduceJS(callback, initialValue);
        return JSValue.checkedCoerce(result, cls);
    }


    // === Iteration Methods ===

    /**
     * Applies the given callback function to each element in the iterator.
     *
     * @param callback the function to apply to each element
     */
    @JS.Coerce
    @JS("this.forEach(callback);")
    public native void forEach(JSFunction callback);

    /**
     * Retrieves the next item from the iterator.
     * Returns a {@code JSObject} with {@code value} and {@code done} properties.
     *
     * @return the next result object from the iterator
     */
    @JS.Coerce
    @JS("return this.next();")
    public native JSObject next();

    /**
     * Retrieves the next value from the iterator and coerces it to the specified type.
     * Returns {@code null} if the iterator is done.
     *
     * @param cls the expected type of the value
     * @param <T> the result type
     * @return the next value or {@code null} if iteration is complete
     */
    public <T> T nextValue(Class<T> cls) {
        JSObject result = next();
        if(result.get("done", Boolean.class)) return null;
        return result.get("value", cls);
    }

    // === Conversion Method ===

    /**
     * Converts the remaining elements of the iterator into a {@link JSArray}.
     *
     * @return a {@code JSArray} containing all remaining elements
     */
    @JS.Coerce
    @JS("return this.toArray();")
    public native JSArray toArray();
}
