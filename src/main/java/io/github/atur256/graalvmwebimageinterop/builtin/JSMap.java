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

import java.util.List;


/**
 * Provides a Java binding for the JavaScript {@code Map} object within the WebImage interop layer.
 * This class supports key-value storage and iteration using native JavaScript semantics.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSMap map = new JSMap().set("name", "Alice").set("age", 42);
 * boolean hasName = map.has("name");
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Map")
public class JSMap extends JSObject {

    /**
     * The number of key-value pairs in the map.
     */
    public int size;


    // === Grouping Methods ===

    /**
     * Groups items from a {@link JSIterator} using the provided callback function.
     *
     * @param items    the iterator of items to group
     * @param callback the grouping function that returns a key for each item
     * @return a new {@code JSMap} with grouped entries
     */
    @JS.Coerce
    @JS("return Map.groupBy(items, callback);")
    public static native JSMap groupBy(JSIterator items, JSFunction callback);

    /**
     * Groups items from a {@link JSArray} using the provided callback function.
     *
     * @param items    the array of items to group
     * @param callback the grouping function
     * @return a new {@code JSMap} with grouped entries
     */
    public static JSMap groupBy(JSArray items, JSFunction callback) {
        return groupBy(JSIterator.from(items), callback);
    }

    /**
     * Groups items from a Java {@link List} using the provided callback function.
     *
     * @param items    the list of items to group
     * @param callback the grouping function
     * @param <T>      the type of items in the list
     * @return a new {@code JSMap} with grouped entries
     */
    public static <T> JSMap groupBy(List<T> items, JSFunction callback) {
        return groupBy(fromItems(items.toArray()), callback);
    }

    /**
     * Converts a Java array into a {@link JSIterator}.
     *
     * @param items the array of items
     * @param <T>   the type of items
     * @return a {@code JSIterator} wrapping the array
     */
    private static <T> JSIterator fromItems(T[] items) {
        JSArray jsArr = JSArray.of();
        for(T item : items) {
            jsArr.push(item);
        }
        return JSIterator.from(jsArr);
    }


    // === Core Methods ===

    /**
     * Removes all key-value pairs from the map.
     */
    @JS.Coerce
    @JS("this.clear();")
    public native void clear();


    // === Delete Methods ===

    /**
     * Removes the entry associated with the given {@link JSValue} key.
     *
     * @param key the key to delete
     * @return {@code true} if the entry was present and removed
     */
    @JS.Coerce
    @JS("return this.delete(key);")
    public native boolean delete(JSValue key);

    /**
     * Removes the entry associated with the given {@code int} key.
     *
     * @param key the key to delete
     * @return {@code true} if the entry was present and removed
     */
    @JS.Coerce
    @JS("return this.delete(key);")
    public native boolean delete(int key);

    /**
     * Removes the entry associated with the given {@code double} key.
     *
     * @param key the key to delete
     * @return {@code true} if the entry was present and removed
     */
    @JS.Coerce
    @JS("return this.delete(key);")
    public native boolean delete(double key);

    /**
     * Removes the entry associated with the given {@code boolean} key.
     *
     * @param key the key to delete
     * @return {@code true} if the entry was present and removed
     */
    @JS.Coerce
    @JS("return this.delete(key);")
    public native boolean delete(boolean key);

    /**
     * Removes the entry associated with the given {@code Object} key.
     *
     * @param key the key to delete
     * @return {@code true} if the entry was present and removed
     */
    @JS.Coerce
    @JS("return this.delete(key);")
    public native boolean delete(Object key);


    // === Iteration Methods ===

    /**
     * Returns an iterator over the map's key-value pairs.
     * Each item is a two-element array: {@code [key, value]}.
     *
     * @return a {@link JSIterator} over entries
     */
    @JS.Coerce
    @JS("return this.entries();")
    public native JSIterator entries();

    /**
     * Applies the given callback to each entry in the map.
     *
     * @param callback the function to apply to each entry
     */
    @JS.Coerce
    @JS("this.forEach(callback);")
    public native void forEach(JSFunction callback);

    /**
     * Applies the callback to each entry, binding {@code thisArg} as the {@code this} context.
     *
     * @param callback the function to apply
     * @param thisArg  the {@code this} context
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, JSValue thisArg);

    /**
     * Applies the callback to each entry in the map, binding an {@code int} as the {@code this} context.
     *
     * @param callback the function to apply to each entry
     * @param thisArg  the {@code int} value to bind as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, int thisArg);

    /**
     * Applies the callback to each entry in the map, binding a {@code double} as the {@code this} context.
     *
     * @param callback the function to apply to each entry
     * @param thisArg  the {@code double} value to bind as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, double thisArg);

    /**
     * Applies the callback to each entry in the map, binding a {@code boolean} as the {@code this} context.
     *
     * @param callback the function to apply to each entry
     * @param thisArg  the {@code boolean} value to bind as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, boolean thisArg);

    /**
     * Applies the callback to each entry in the map, binding an {@code Object} as the {@code this} context.
     *
     * @param callback the function to apply to each entry
     * @param thisArg  the {@code Object} to bind as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, Object thisArg);


    // === Get Methods ===

    /**
     * Retrieves the value associated with the given key.
     *
     * @param key the key to look up
     * @return the value associated with the key, or {@code undefined} if not present
     */
    @JS.Coerce
    @JS("return this.get(key);")
    public native Object get(Object key);

    /**
     * Retrieves and coerces the value associated with a {@link JSValue} key.
     *
     * @param key the key to look up
     * @param cls the target class for coercion
     * @param <R> the result type
     * @return the coerced value, or {@code null} if not present
     */
    public <R> R get(JSValue key, Class<R> cls) {
        return JSValue.checkedCoerce(get(key), cls);
    }

    /**
     * Retrieves and coerces the value associated with an {@code int} key.
     *
     * @param key the integer key to look up
     * @param cls the target class for coercion
     * @param <R> the result type
     * @return the coerced value, or {@code null} if not present
     */
    public <R> R get(int key, Class<R> cls) {
        return JSValue.checkedCoerce(get(JSNumber.of(key)), cls);
    }

    /**
     * Retrieves and coerces the value associated with a {@code double} key.
     *
     * @param key the double key to look up
     * @param cls the target class for coercion
     * @param <R> the result type
     * @return the coerced value, or {@code null} if not present
     */
    public <R> R get(double key, Class<R> cls) {
        return JSValue.checkedCoerce(get(JSNumber.of(key)), cls);
    }

    /**
     * Retrieves and coerces the value associated with a {@code boolean} key.
     *
     * @param key the boolean key to look up
     * @param cls the target class for coercion
     * @param <R> the result type
     * @return the coerced value, or {@code null} if not present
     */
    public <R> R get(boolean key, Class<R> cls) {
        return JSValue.checkedCoerce(get(JSBoolean.of(key)), cls);
    }

    /**
     * Retrieves and coerces the value associated with an {@code Object} key.
     *
     * @param key the object key to look up
     * @param cls the target class for coercion
     * @param <R> the result type
     * @return the coerced value, or {@code null} if not present
     */
    public <R> R get(Object key, Class<R> cls) {
        return JSValue.checkedCoerce(get(key), cls);
    }


    // === Has Methods ===

    /**
     * Checks whether the map contains the given {@link JSValue} key.
     *
     * @param key the key to check
     * @return {@code true} if the key exists
     */
    @JS.Coerce
    @JS("return this.has(key);")
    public native boolean has(JSValue key);

    /**
     * Checks whether the map contains the given {@code int} key.
     *
     * @param key the integer key to check
     * @return {@code true} if the key exists in the map
     */
    @JS.Coerce
    @JS("return this.has(key);")
    public native boolean has(int key);

    /**
     * Checks whether the map contains the given {@code double} key.
     *
     * @param key the double key to check
     * @return {@code true} if the key exists in the map
     */
    @JS.Coerce
    @JS("return this.has(key);")
    public native boolean has(double key);

    /**
     * Checks whether the map contains the given {@code boolean} key.
     *
     * @param key the boolean key to check
     * @return {@code true} if the key exists in the map
     */
    @JS.Coerce
    @JS("return this.has(key);")
    public native boolean has(boolean key);

    /**
     * Checks whether the map contains the given {@code Object} key.
     *
     * @param key the object key to check
     * @return {@code true} if the key exists in the map
     */
    @JS.Coerce
    @JS("return this.has(key);")
    public native boolean has(Object key);


    // === Key/Value Iterators ===

    /**
     * Returns an iterator over the map's keys.
     * Each item in the iterator represents a key in insertion order.
     *
     * @return a {@link JSIterator} over the map's keys
     */
    @JS.Coerce
    @JS("return this.keys();")
    public native JSIterator keys();

    /**
     * Returns an iterator over the map's values.
     * Each item in the iterator represents a value in insertion order.
     *
     * @return a {@link JSIterator} over the map's values
     */
    @JS.Coerce
    @JS("return this.values();")
    public native JSIterator values();


    // === Set Methods ===

    // JSValue keys

    /**
     * Sets a key-value pair in the map using {@link JSValue} for both key and value.
     *
     * @param key   the {@code JSValue} key
     * @param value the {@code JSValue} value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(JSValue key, JSValue value);

    /**
     * Sets a key-value pair in the map using a {@link JSValue} key and an {@code int} value.
     *
     * @param key   the {@code JSValue} key
     * @param value the integer value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(JSValue key, int value);

    /**
     * Sets a key-value pair in the map using a {@link JSValue} key and a {@code double} value.
     *
     * @param key   the {@code JSValue} key
     * @param value the double value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(JSValue key, double value);

    /**
     * Sets a key-value pair in the map using a {@link JSValue} key and a {@code boolean} value.
     *
     * @param key   the {@code JSValue} key
     * @param value the boolean value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(JSValue key, boolean value);

    /**
     * Sets a key-value pair in the map using a {@link JSValue} key and a generic {@code Object} value.
     *
     * @param key   the {@code JSValue} key
     * @param value the object value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(JSValue key, Object value);

    // int keys

    /**
     * Sets a key-value pair in the map using an {@code int} key and a {@link JSValue} value.
     *
     * @param key   the integer key
     * @param value the {@code JSValue} to associate with the key
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(int key, JSValue value);

    /**
     * Sets a key-value pair in the map using an {@code int} key and an {@code int} value.
     *
     * @param key   the integer key
     * @param value the integer value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(int key, int value);

    /**
     * Sets a key-value pair in the map using an {@code int} key and a {@code double} value.
     *
     * @param key   the integer key
     * @param value the double value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(int key, double value);

    /**
     * Sets a key-value pair in the map using an {@code int} key and a {@code boolean} value.
     *
     * @param key   the integer key
     * @param value the boolean value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(int key, boolean value);

    /**
     * Sets a key-value pair in the map using an {@code int} key and a generic {@code Object} value.
     *
     * @param key   the integer key
     * @param value the object value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(int key, Object value);

    // double keys

    /**
     * Sets a key-value pair in the map using a {@code double} key and a {@link JSValue} value.
     *
     * @param key   the double key
     * @param value the {@code JSValue} to associate with the key
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(double key, JSValue value);

    /**
     * Sets a key-value pair in the map using a {@code double} key and an {@code int} value.
     *
     * @param key   the double key
     * @param value the integer value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(double key, int value);

    /**
     * Sets a key-value pair in the map using a {@code double} key and a {@code double} value.
     *
     * @param key   the double key
     * @param value the double value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(double key, double value);

    /**
     * Sets a key-value pair in the map using a {@code double} key and a {@code boolean} value.
     *
     * @param key   the double key
     * @param value the boolean value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(double key, boolean value);

    /**
     * Sets a key-value pair in the map using a {@code double} key and a generic {@code Object} value.
     *
     * @param key   the double key
     * @param value the object value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(double key, Object value);

    // boolean keys

    /**
     * Sets a key-value pair in the map using a {@code boolean} key and a {@link JSValue} value.
     *
     * @param key   the boolean key
     * @param value the {@code JSValue} to associate with the key
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(boolean key, JSValue value);

    /**
     * Sets a key-value pair in the map using a {@code boolean} key and an {@code int} value.
     *
     * @param key   the boolean key
     * @param value the integer value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(boolean key, int value);

    /**
     * Sets a key-value pair in the map using a {@code boolean} key and a {@code double} value.
     *
     * @param key   the boolean key
     * @param value the double value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(boolean key, double value);

    /**
     * Sets a key-value pair in the map using a {@code boolean} key and a {@code boolean} value.
     *
     * @param key   the boolean key
     * @param value the boolean value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(boolean key, boolean value);

    /**
     * Sets a key-value pair in the map using a {@code boolean} key and a generic {@code Object} value.
     *
     * @param key   the boolean key
     * @param value the object value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(boolean key, Object value);

    // Object keys

    /**
     * Sets a key-value pair in the map using an {@code Object} key and a {@link JSValue} value.
     *
     * @param key   the object key
     * @param value the {@code JSValue} to associate with the key
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(Object key, JSValue value);

    /**
     * Sets a key-value pair in the map using an {@code Object} key and an {@code int} value.
     *
     * @param key   the object key
     * @param value the integer value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(Object key, int value);

    /**
     * Sets a key-value pair in the map using an {@code Object} key and a {@code double} value.
     *
     * @param key   the object key
     * @param value the double value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(Object key, double value);

    /**
     * Sets a key-value pair in the map using an {@code Object} key and a {@code boolean} value.
     *
     * @param key   the object key
     * @param value the boolean value
     * @return the updated {@code JSMap} instance
     */
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native JSMap set(Object key, boolean value);

    /**
     * Sets a key-value pair in the map using an {@code Object} key and a generic {@code Object} value.
     * This method overrides {@link JSObject#set(Object, Object)} and returns {@code void} to avoid signature conflicts.
     *
     * @param key   the object key
     * @param value the object value
     */
    @Override
    @JS.Coerce
    @JS("return this.set(key, value);")
    public native void set(Object key, Object value);
}
