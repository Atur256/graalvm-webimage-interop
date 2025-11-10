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

package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


/**
 * Provides a Java binding for the JavaScript {@code Set} object within the WebImage interop layer.
 * This class supports standard set operations such as add, delete, union, and iteration.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSSet set = new JSSet().add(1).add(2);
 * boolean hasOne = set.has(1);
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Set")
public class JSSet extends JSObject {

    /**
     * The number of elements in the set.
     */
    public int size;


    // === Add Methods ===

    /**
     * Adds a {@link JSValue} to the set.
     *
     * @param value the {@code JSValue} to add
     * @return the updated {@code JSSet} instance
     */
    @JS.Coerce
    @JS("return this.add(value);")
    public native JSSet add(JSValue value);

    /**
     * Adds an {@code int} value to the set.
     *
     * @param value the integer to add
     * @return the updated {@code JSSet} instance
     */
    @JS.Coerce
    @JS("return this.add(value);")
    public native JSSet add(int value);

    /**
     * Adds a {@code double} value to the set.
     *
     * @param value the double to add
     * @return the updated {@code JSSet} instance
     */
    @JS.Coerce
    @JS("return this.add(value);")
    public native JSSet add(double value);

    /**
     * Adds a {@code boolean} value to the set.
     *
     * @param value the boolean to add
     * @return the updated {@code JSSet} instance
     */
    @JS.Coerce
    @JS("return this.add(value);")
    public native JSSet add(boolean value);

    /**
     * Adds an {@code Object} to the set.
     *
     * @param value the object to add
     * @return the updated {@code JSSet} instance
     */
    @JS.Coerce
    @JS("return this.add(value);")
    public native JSSet add(Object value);


    // === Clear Method ===

    /**
     * Removes all elements from the set.
     */
    @JS.Coerce
    @JS("this.clear();")
    public native void clear();


    // === Delete Methods ===

    /**
     * Removes the specified {@link JSValue} from the set.
     *
     * @param value the {@code JSValue} to remove
     * @return {@code true} if the value was present and removed, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.delete(value);")
    public native boolean delete(JSValue value);

    /**
     * Removes the specified {@code int} value from the set.
     *
     * @param value the integer to remove
     * @return {@code true} if the value was present and removed, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.delete(value);")
    public native boolean delete(int value);

    /**
     * Removes the specified {@code double} value from the set.
     *
     * @param value the double to remove
     * @return {@code true} if the value was present and removed, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.delete(value);")
    public native boolean delete(double value);

    /**
     * Removes the specified {@code boolean} value from the set.
     *
     * @param value the boolean to remove
     * @return {@code true} if the value was present and removed, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.delete(value);")
    public native boolean delete(boolean value);

    /**
     * Removes the specified {@code Object} from the set.
     *
     * @param value the object to remove
     * @return {@code true} if the value was present and removed, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.delete(value);")
    public native boolean delete(Object value);


    // === Set Operations ===

    /**
     * Returns a new set containing elements in this set but not in {@code other}.
     *
     * @param other the set to subtract
     * @return a new {@code JSSet} with the difference
     */
    @JS.Coerce
    @JS("return this.difference(other);")
    public native JSSet difference(JSSet other);

    /**
     * Returns a new set containing elements common to both sets.
     *
     * @param other the set to intersect with
     * @return a new {@code JSSet} with the intersection
     */
    @JS.Coerce
    @JS("return this.intersection(other);")
    public native JSSet intersection(JSSet other);

    /**
     * Returns {@code true} if this set shares no elements with {@code other}.
     *
     * @param other the set to compare with
     * @return {@code true} if disjoint, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.isDisjointFrom(other);")
    public native boolean isDisjointFrom(JSSet other);

    /**
     * Returns {@code true} if this set is a subset of {@code other}.
     *
     * @param other the set to compare with
     * @return {@code true} if this is a subset, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.isSubsetOf(other);")
    public native boolean isSubsetOf(JSSet other);

    /**
     * Returns {@code true} if this set is a superset of {@code other}.
     *
     * @param other the set to compare with
     * @return {@code true} if this is a superset, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.isSupersetOf(other);")
    public native boolean isSupersetOf(JSSet other);

    /**
     * Returns a new set containing elements in either this set or {@code other}.
     *
     * @param other the set to unite with
     * @return a new {@code JSSet} with the union
     */
    @JS.Coerce
    @JS("return this.union(other);")
    public native JSSet union(JSSet other);

    /**
     * Returns a new set containing elements in either set but not both.
     *
     * @param other the set to compare with
     * @return a new {@code JSSet} with the symmetric difference
     */
    @JS.Coerce
    @JS("return this.symmetricDifference(other);")
    public native JSSet symmetricDifference(JSSet other);


    // === Iteration Methods ===

    /**
     * Returns an iterator of key-value pairs for each element in the set.
     *
     * @return a {@code JSIterator} over [value, value] pairs
     */
    @JS.Coerce
    @JS("return this.entries();")
    public native JSIterator entries();

    /**
     * Returns an iterator of keys in the set.
     * For sets, keys are the same as values.
     *
     * @return a {@code JSIterator} over the set's keys
     */
    @JS.Coerce
    @JS("return this.keys();")
    public native JSIterator keys();

    /**
     * Returns an iterator of values in the set.
     *
     * @return a {@code JSIterator} over the set's values
     */
    @JS.Coerce
    @JS("return this.values();")
    public native JSIterator values();


    // === forEach Methods ===

    /**
     * Executes the {@code callback} function once for each element in the set.
     *
     * @param callback the function to execute for each element
     */
    @JS.Coerce
    @JS("this.forEach(callback);")
    public native void forEach(JSFunction callback);

    /**
     * Executes the {@code callback} function with {@code thisArg} as its {@code this} context.
     *
     * @param callback the function to execute
     * @param thisArg  the {@code JSValue} to use as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, JSValue thisArg);

    /**
     * Executes the {@code callback} function with {@code thisArg} as its {@code this} context.
     *
     * @param callback the function to execute
     * @param thisArg  the {@code int} to use as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, int thisArg);

    /**
     * Executes the {@code callback} function with {@code thisArg} as its {@code this} context.
     *
     * @param callback the function to execute
     * @param thisArg  the {@code double} to use as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, double thisArg);

    /**
     * Executes the {@code callback} function with {@code thisArg} as its {@code this} context.
     *
     * @param callback the function to execute
     * @param thisArg  the {@code boolean} to use as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, boolean thisArg);

    /**
     * Executes the {@code callback} function with {@code thisArg} as its {@code this} context.
     *
     * @param callback the function to execute
     * @param thisArg  the {@code Object} to use as {@code this}
     */
    @JS.Coerce
    @JS("this.forEach(callback, thisArg);")
    public native void forEach(JSFunction callback, Object thisArg);


    // === Has Methods ===

    /**
     * Checks whether the set contains the specified {@link JSValue}.
     *
     * @param value the {@code JSValue} to check
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.has(value);")
    public native boolean has(JSValue value);

    /**
     * Checks whether the set contains the specified {@code int} value.
     *
     * @param value the integer to check
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.has(value);")
    public native boolean has(int value);

    /**
     * Checks whether the set contains the specified {@code double} value.
     *
     * @param value the double to check
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.has(value);")
    public native boolean has(double value);

    /**
     * Checks whether the set contains the specified {@code boolean} value.
     *
     * @param value the boolean to check
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.has(value);")
    public native boolean has(boolean value);

    /**
     * Checks whether the set contains the specified {@code Object}.
     *
     * @param value the object to check
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.has(value);")
    public native boolean has(Object value);
}
