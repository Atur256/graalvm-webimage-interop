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

import java.util.ArrayList;
import java.util.List;


/**
 * Provides a Java binding for the JavaScript {@code Array} object within the WebImage interop layer.
 * Enables native interop for array creation, manipulation, and iteration.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSArray arr = JSArray.of(1, 2, 3);
 * arr.push(4);
 * int first = arr.at(0, Integer.class);
 * JSArray doubled = arr.map(JSFunction.fromFunc((JSNumber x) -> JSNumber.of(x.asInt() * 2)));
 * }</pre>
 *
 * @see JSObject
 * @see JSValue
 * @see JSFunction
 * @see JSPromise
 * @see JSIterator
 */
@JS.Import("Array")
public class JSArray extends JSObject {

    /**
     * The {@code length} property of the JavaScript array.
     */
    public int length;


    // === Factory Methods ===

    /**
     * Converts the given Java object into a {@link JSArray}. This method supports
     * multiple types of inputs and automatically creates a corresponding JSArray:
     * <ul>
     *     <li>{@code null} → returns an empty JSArray</li>
     *     <li>{@link JSArray} → creates a new JSArray with the same elements</li>
     *     <li>{@link String} → converts each character into a JSArray element</li>
     *     <li>{@link JSValue}[] → wraps the JSValue array into a JSArray</li>
     *     <li>{@link Object}[] → wraps the array elements into a JSArray</li>
     *     <li>Primitive arrays (byte[], short[], char[], int[], long[], float[], double[], boolean[]) → converted to JSArray</li>
     *     <li>{@link Iterable} → each element is coerced and added to a JSArray</li>
     *     <li>Other objects → wrapped as a single-element JSArray using {@link #coerce(Object)}</li>
     * </ul>
     *
     * @param any the object to convert into a JSArray; may be null
     * @return a new JSArray representing the input
     */
    public static JSArray from(Object any) {
        return switch(any) {
            case null -> JSArray.of();
            case JSArray js -> JSArray.from(js);
            case String arr -> JSArray.from(arr);
            case JSValue[] arr -> JSArray.from(arr);
            case Object[] arr -> JSArray.from(arr);
            case byte[] arr -> fromPrimitiveByteArray(arr);
            case short[] arr -> fromPrimitiveShortArray(arr);
            case char[] arr -> fromPrimitiveCharArray(arr);
            case int[] arr -> fromPrimitiveIntArray(arr);
            case long[] arr -> fromPrimitiveLongArray(arr);
            case float[] arr -> fromPrimitiveFloatArray(arr);
            case double[] arr -> fromPrimitiveDoubleArray(arr);
            case boolean[] arr -> fromPrimitiveBooleanArray(arr);
            case Iterable<?> it -> JSArray.fromIterable(it);
            default -> JSArray.of(coerce(any));
        };
    }

    // Wrap an existing JSArray into a new JSArray
    @JS.Coerce
    @JS("return Array.from(arr);")
    private static native JSArray from(JSArray arr);

    // Convert an Iterable to a JSArray
    private static JSArray fromIterable(Iterable<?> it) {
        JSArray result = JSArray.of();
        for(Object item : it) {
            result.push(coerce(item));
        }
        return result;
    }

    // Convert a String into a JSArray of characters
    @JS.Coerce
    @JS("return Array.from(str);")
    private static native JSArray from(String str);

    // Convert Object[] into a JSArray
    @JS.Coerce
    @JS("return Array.from(arr);")
    private static native JSArray from(Object[] arr);

    // Convert boolean[] into a JSArray of JSBoolean
    private static JSArray from(boolean[] values) {
        JSValue[] jsValues = new JSValue[values.length];
        for(int i = 0; i < values.length; i++) {
            jsValues[i] = JSBoolean.of(values[i]);
        }
        return JSArray.from(jsValues);
    }

    // Generic primitive array conversion helpers

    // boolean → JSBoolean
    private static JSArray fromPrimitiveBooleanArray(boolean[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSBoolean.of(arr[i]);
        return JSArray.from(jsArr);
    }

    // int → JSNumber
    private static JSArray fromPrimitiveIntArray(int[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSNumber.of(arr[i]);
        return JSArray.from(jsArr);
    }

    // short → JSNumber
    private static JSArray fromPrimitiveShortArray(short[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSNumber.of(arr[i]);
        return JSArray.from(jsArr);
    }

    // byte → JSNumber
    private static JSArray fromPrimitiveByteArray(byte[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSNumber.of(arr[i]);
        return JSArray.from(jsArr);
    }

    // char → JSString
    private static JSArray fromPrimitiveCharArray(char[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSString.of(String.valueOf(arr[i]));
        return JSArray.from(jsArr);
    }

    // long → JSNumber
    private static JSArray fromPrimitiveLongArray(long[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSNumber.of(arr[i]);
        return JSArray.from(jsArr);
    }

    // float → JSNumber
    private static JSArray fromPrimitiveFloatArray(float[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSNumber.of(arr[i]);
        return JSArray.from(jsArr);
    }

    // double → JSNumber
    private static JSArray fromPrimitiveDoubleArray(double[] arr) {
        JSValue[] jsArr = new JSValue[arr.length];
        for(int i = 0; i < arr.length; i++) jsArr[i] = JSNumber.of(arr[i]);
        return JSArray.from(jsArr);
    }

    @JS.Coerce
    @JS("return Array.fromAsync(arrayLike);")
    private static native JSPromise fromAsync(JSValue arrayLike);

    /**
     * Asynchronously creates a {@link JSArray} from any Java object.
     *
     * @param any a Java object to convert to a {@link JSArray} asynchronously
     * @return a {@link JSPromise} resolving to a {@link JSArray}
     */
    public static JSPromise fromAsync(Object any) {
        return fromAsync(from(any));
    }

    /**
     * Determines whether the specified value is an array.
     *
     * @param value a JavaScript value
     * @return {@code true} if the value is an array; {@code false} otherwise
     */
    @JS.Coerce
    @JS("return Array.isArray(value);")
    public static native boolean isArray(JSValue value);


    /**
     * Creates a new {@code JSArray} containing the specified values.
     *
     * @param values a variadic list of values
     * @return a new {@code JSArray}
     */
    public static JSArray of(Object... values) {
        return from(coerceJSArray(values));
    }

    /**
     * Creates an empty {@code JSArray}.
     *
     * @return an empty array
     */
    @JS.Coerce
    @JS("return Array.of();")
    public static native JSArray of();


    // === Conversion Utilities ===

    /**
     * Converts a list of Java values into a {@code JSArray} of JavaScript-compatible values.
     *
     * @param args the values to convert
     * @return a new {@code JSArray} containing coerced values
     */
    private static JSArray coerceJSArray(Object... args) {
        JSArray argsArray = JSArray.of();
        for(Object arg : args) {
            argsArray.push(coerce(arg));
        }
        return argsArray;
    }

    /**
     * Coerces a Java value into a JavaScript-compatible representation.
     *
     * @param arg a Java value
     * @return a JavaScript-compatible representation
     */
    @JS.Coerce
    @JS("return arg;")
    private static native Object coerce(Object arg);

    /**
     * Converts a Java object or collection into a {@code JSArray}.
     *
     * @param arrayLike a Java object, array, or iterable
     * @return a new {@code JSArray} representation
     */
    private static JSArray convertToJSArray(Object arrayLike) {
        switch(arrayLike) {
            case null -> {
                return JSArray.of();
            }
            case JSArray jsArray -> {
                return JSArray.from(jsArray);
            }
            case Object[] array -> {
                return JSArray.from(array);
            }
            case int[] array -> {
                return JSArray.from(array);
            }
            case double[] array -> {
                return JSArray.from(array);
            }
            case boolean[] array -> {
                return JSArray.from(array);
            }
            case Iterable<?> iterable -> {
                List<JSValue> temp = new ArrayList<>();
                for(Object item : iterable) {
                    temp.add(coerceJSValue(item));
                }
                return JSArray.from(temp.toArray(new JSValue[0]));
            }
            default -> {
                return JSArray.of(coerceJSValue(arrayLike));
            }
        }
    }

    private static JSValue coerceJSValue(Object value) {
        if(value instanceof JSValue js) {
            return js;
        }
        else if(value instanceof String || value instanceof Number || value instanceof Boolean || value == null) {
            return (JSValue) coerce(value);
        }
        else {
            return (JSValue) coerce(value);
        }
    }


    // === Element Access ===

    /**
     * Returns the element at the specified index.
     *
     * @param index the index
     * @return the element at the index
     */
    @JS.Coerce
    @JS("return this.at(index);")
    public native Object at(int index);

    /**
     * Returns the element at the specified index, coerced into a given Java type.
     *
     * @param index the index
     * @param cls   the target class
     * @param <R>   the return type
     * @return the coerced element
     */
    public <R> R at(int index, Class<R> cls) {
        return JSValue.checkedCoerce(at(index), cls);
    }


    // === Core Array Operations ===

    /**
     * Concatenates this array with other {@code JSArray} instances.
     *
     * @param jsArrays one or more arrays to concatenate
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return Array.prototype.concat.apply(this, jsArrays);")
    public native JSArray concat(JSArray... jsArrays);

    /**
     * Concatenates this array with various array-like objects or collections.
     *
     * @param arrays one or more array-like objects
     * @return a new concatenated {@code JSArray}
     */
    public JSArray concat(Object... arrays) {
        JSArray[] jsArrays = new JSArray[arrays.length];
        for(int i = 0; i < arrays.length; i++) {
            jsArrays[i] = convertToJSArray(arrays[i]);
        }
        return concat(jsArrays);
    }

    /**
     * Copies a sequence of array elements within the array.
     *
     * @param target the index to copy the sequence to
     * @param start  the index to start copying elements from
     * @param end    the index to end copying (exclusive)
     * @return this array, modified in place
     */
    @JS.Coerce
    @JS("return this.copyWithin(target, start, end);")
    public native JSArray copyWithin(int target, int start, int end);

    /**
     * Returns a new {@link JSIterator} object containing the key/value pairs for each index.
     *
     * @return an iterator of entries
     */
    @JS.Coerce
    @JS("return this.entries();")
    public native JSIterator entries();

    /**
     * Returns an iterator over the array's keys.
     *
     * @return a {@link JSIterator} of keys
     */
    @JS.Coerce
    @JS("return this.keys();")
    public native JSIterator arrayKeys();

    /**
     * Returns an iterator over the array's values.
     *
     * @return a {@link JSIterator} of values
     */
    @JS.Coerce
    @JS("return this.values();")
    public native JSIterator values();

    /**
     * Returns a shallow copy of a portion of the array.
     *
     * @param start the start index (inclusive)
     * @param end   the end index (exclusive)
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.slice(start, end);")
    public native JSArray slice(int start, int end);

    /**
     * Changes the contents by removing elements.
     *
     * @param start       the start index
     * @param deleteCount number of elements to remove
     * @return a new {@code JSArray} of removed elements
     */
    @JS.Coerce
    @JS("return this.splice(start, deleteCount);")
    public native JSArray splice(int start, int deleteCount);

    /**
     * Reverses the array in place.
     *
     * @return this array
     */
    @JS.Coerce
    @JS("return this.reverse();")
    public native JSArray reverse();

    /**
     * Sorts the array in place.
     *
     * @return this array
     */
    @JS.Coerce
    @JS("return this.sort();")
    public native JSArray sort();

    /**
     * Returns a reversed copy of the array.
     *
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.toReversed();")
    public native JSArray toReversed();

    /**
     * Returns a sorted copy of the array.
     *
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.toSorted();")
    public native JSArray toSorted();

    /**
     * Returns a copy with elements removed.
     *
     * @param start       the start index
     * @param deleteCount number of elements to remove
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.toSpliced(start, deleteCount);")
    public native JSArray toSpliced(int start, int deleteCount);

    /**
     * Returns a copy with the value replaced at the given index.
     *
     * @param index the index to update
     * @param value the {@link JSValue} to set
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.with(index, value);")
    public native JSArray with(int index, JSValue value);

    /**
     * Returns a copy with the {@code int} value replaced at the given index.
     *
     * @param index the index to update
     * @param value the value to set
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.with(index, value);")
    public native JSArray with(int index, int value);

    /**
     * Returns a copy with the {@code double} value replaced at the given index.
     *
     * @param index the index to update
     * @param value the value to set
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.with(index, value);")
    public native JSArray with(int index, double value);

    /**
     * Returns a copy with the {@code boolean} value replaced at the given index.
     *
     * @param index the index to update
     * @param value the value to set
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.with(index, value);")
    public native JSArray with(int index, boolean value);

    /**
     * Returns a copy with the {@code Object} value replaced at the given index.
     *
     * @param index the index to update
     * @param value the value to set
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.with(index, value);")
    public native JSArray with(int index, Object value);


    // === Search & Indexing ===

    /**
     * Checks if the array includes the specified {@code Object} value.
     *
     * @param value the value to check
     * @return {@code true} if found; {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.includes(value);")
    public native boolean includes(Object value);

    /**
     * Returns the index of the first occurrence of the given {@code Object} value.
     *
     * @param value the value to locate
     * @return the index or {@code -1} if not found
     */
    @JS.Coerce
    @JS("return this.indexOf(value);")
    public native int indexOf(Object value);

    /**
     * Returns the index of the last occurrence of the given {@code Object} value.
     *
     * @param value the value to locate
     * @return the index or {@code -1} if not found
     */
    @JS.Coerce
    @JS("return this.lastIndexOf(value);")
    public native int lastIndexOf(Object value);

    /**
     * Finds the first element matching the callback.
     *
     * @param callback a {@link JSFunction} to test each element
     * @return the first matching element or {@code null}
     */
    @JS.Coerce
    @JS("return this.find(callback);")
    public native Object find(JSFunction callback);

    /**
     * Finds and coerces the first element matching the callback.
     *
     * @param callback a {@link JSFunction} to test each element
     * @param cls      the target class
     * @return the coerced result
     */
    public <R> R find(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(find(callback), cls);
    }

    /**
     * Finds the index of the first element matching the callback.
     *
     * @param callback a {@link JSFunction} to test each element
     * @return the index or {@code -1}
     */
    @JS.Coerce
    @JS("return this.findIndex(callback);")
    public native int findIndex(JSFunction callback);

    /**
     * Finds the last element matching the callback.
     *
     * @param callback a {@link JSFunction} to test each element
     * @return the last matching element or {@code null}
     */
    @JS.Coerce
    @JS("return this.findLast(callback);")
    public native Object findLast(JSFunction callback);

    /**
     * Finds and coerces the last element matching the callback.
     *
     * @param callback a {@link JSFunction} to test each element
     * @param cls      the target class
     * @return the coerced result
     */
    public <R> R findLast(JSFunction callback, Class<R> cls) {
        return JSValue.checkedCoerce(findLast(callback), cls);
    }

    /**
     * Finds the index of the last element matching the callback.
     *
     * @param callback a {@link JSFunction} to test each element
     * @return the index or {@code -1}
     */
    @JS.Coerce
    @JS("return this.findLastIndex(callback);")
    public native int findLastIndex(JSFunction callback);


    // === Iteration & Testing ===

    /**
     * Executes a callback for each element.
     *
     * @param callback a {@link JSFunction} to apply
     */
    @JS.Coerce
    @JS("this.forEach(callback);")
    public native void forEach(JSFunction callback);

    /**
     * Tests whether all elements in the array pass the test implemented by the provided callback.
     *
     * @param callback a JavaScript function used to test each element
     * @return {@code true} if every element passes the test, otherwise {@code false}
     */
    @JS.Coerce
    @JS("return this.every(callback);")
    public native boolean every(JSFunction callback);

    /**
     * Tests whether at least one element passes the callback test.
     *
     * @param callback a {@link JSFunction} to test each element
     * @return {@code true} if any element passes
     */
    @JS.Coerce
    @JS("return this.some(callback);")
    public native boolean some(JSFunction callback);

    /**
     * Filters elements using the provided callback function.
     *
     * @param callback a {@link JSFunction} used to test each element
     * @return a new {@code JSArray} with elements that pass the test
     */
    @JS.Coerce
    @JS("return this.filter(callback);")
    public native JSArray filter(JSFunction callback);

    /**
     * Maps each element using the callback.
     *
     * @param callback a {@link JSFunction} to transform each element
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.map(callback);")
    public native JSArray map(JSFunction callback);

    /**
     * Flattens nested arrays up to the given depth.
     *
     * @param depth the depth level
     * @return a new flattened {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.flat(depth);")
    public native JSArray flat(int depth);

    /**
     * Maps and flattens the result using the callback.
     *
     * @param callback a {@link JSFunction} to transform each element
     * @return a new {@code JSArray}
     */
    @JS.Coerce
    @JS("return this.flatMap(callback);")
    public native JSArray flatMap(JSFunction callback);


    // === Mutation Methods ===

    /**
     * Adds an {@code Object} to the end of the array.
     *
     * @param value the value to add
     * @return the new length of the array
     */
    @JS.Coerce
    @JS("return this.push(value);")
    public native int push(Object value);

    /**
     * Removes and returns the last element.
     *
     * @return the removed element
     */
    @JS.Coerce
    @JS("return this.pop();")
    public native Object pop();

    /**
     * Removes and coerces the last element.
     *
     * @param cls the target class
     * @return the coerced result
     */
    public <R> R pop(Class<R> cls) {
        return JSValue.checkedCoerce(pop(), cls);
    }

    /**
     * Adds an {@code Object} to the beginning of the array.
     *
     * @param value the value to add
     * @return the new length
     */
    @JS.Coerce
    @JS("return this.unshift(value);")
    public native int unshift(Object value);

    /**
     * Removes and returns the first element.
     *
     * @return the removed element
     */
    @JS.Coerce
    @JS("return this.shift();")
    public native Object shift();

    /**
     * Removes and coerces the first element.
     *
     * @param cls the target class
     * @return the coerced result
     */
    public <R> R shift(Class<R> cls) {
        return JSValue.checkedCoerce(shift(), cls);
    }

    /**
     * Fills elements with the specified {@code Object} value.
     *
     * @param value the value to fill
     * @param start start index (inclusive)
     * @param end   end index (exclusive)
     * @return this array
     */
    @JS.Coerce
    @JS("return this.fill(value, start, end);")
    public native JSArray fill(Object value, int start, int end);


    // === Reduction Methods ===

    /**
     * Reduces the array using the provided callback.
     *
     * @param callback a {@link JSFunction} reducer
     * @return the reduced result
     */
    @JS.Coerce
    @JS("return this.reduce(callback);")
    private native Object reduceJS(JSFunction callback);

    /**
     * Reduces the array using the provided callback and initial value.
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
     * Reduces the array using the provided callback and coerces the result into the specified type.
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
     * Reduces the array using the provided callback and an initial value, coerced into the specified type.
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

    /**
     * Reduces the array from right to left using the callback.
     *
     * @param callback a {@link JSFunction} reducer
     * @return the result
     */
    @JS.Coerce
    @JS("return this.reduceRight(callback);")
    private native Object reduceRightJS(JSFunction callback);

    /**
     * Reduces the array from right to left with an initial value.
     *
     * @param callback     a {@link JSFunction} reducer
     * @param initialValue the initial value
     * @return the result
     */
    @JS.Coerce
    @JS("return this.reduceRight(callback, initialValue);")
    private native <R> Object reduceRightJS(JSFunction callback, R initialValue);

    /**
     * Reduces the array from right to left using the provided callback and coerces the result into the specified type.
     *
     * @param callback a {@link JSFunction} reducer
     * @param cls      the target class
     * @param <R>      the result type
     * @return the coerced result
     */
    public <R> R reduceRight(JSFunction callback, Class<R> cls) {
        Object result = reduceRightJS(callback);
        return JSValue.checkedCoerce(result, cls);
    }

    /**
     * Reduces the array from right to left using the provided callback and an initial value, coerced into the specified type.
     *
     * @param callback     a {@link JSFunction} reducer
     * @param initialValue the initial value for reduction
     * @param cls          the target class
     * @param <R>          the result type
     * @return the coerced result
     */
    public <R> R reduceRight(JSFunction callback, R initialValue, Class<R> cls) {
        Object result = reduceRightJS(callback, initialValue);
        return JSValue.checkedCoerce(result, cls);
    }


    // === String Conversion ===

    /**
     * Joins all elements into a string using the given separator.
     *
     * @param separator the string to separate elements
     * @return the joined string
     */
    @JS.Coerce
    @JS("return this.join(separator);")
    public native String join(String separator);

    /**
     * Joins all elements into a string using the given separator.
     *
     * @param separator the {@link JSString} to separate elements
     * @return the joined string
     */
    @JS.Coerce
    @JS("return this.join(separator);")
    public native String join(JSString separator);

    /**
     * Converts the array to a string.
     *
     * @return the string representation
     */
    @JS.Coerce
    @JS("return this.toString();")
    private native String toJSString();

    /**
     * Returns a formatted string representation of the array.
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return "<JavaScript<" + typeof() + "; [" + toJSString() + "]>";
    }
}
