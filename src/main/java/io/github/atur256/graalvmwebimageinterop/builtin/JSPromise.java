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

import java.util.List;


/**
 * Provides a Java binding for the JavaScript {@code Promise} object within the WebImage interop layer.
 * This class supports creation, resolution, rejection, and chaining of asynchronous operations.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSPromise promise = JSPromise.resolve("done");
 * promise.then(fn).catch_(errFn).finally_(cleanupFn);
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Promise")
public class JSPromise extends JSObject {

    // === Composition Methods ===

    /**
     * Returns a promise that resolves when all input promises resolve.
     *
     * @param promises an iterator of promises
     * @return a promise resolving to an array of results
     */
    @JS.Coerce
    @JS("return Promise.all(promises);")
    public static native JSPromise all(JSIterator promises);

    /**
     * Returns a promise that resolves when all input promises resolve.
     *
     * @param promises an array of promises
     * @return a promise resolving to an array of results
     */
    public static JSPromise all(JSArray promises) {
        return all(JSIterator.from(promises));
    }

    /**
     * Returns a promise that resolves when all input promises resolve.
     *
     * @param promises a vararg array of promises
     * @return a promise resolving to an array of results
     */
    public static JSPromise all(JSPromise... promises) {
        return all(fromPromises(promises));
    }

    /**
     * Returns a promise that resolves when all input promises resolve.
     *
     * @param promises a list of promises
     * @return a promise resolving to an array of results
     */
    public static JSPromise all(List<JSPromise> promises) {
        return all(fromPromises(promises.toArray(new JSPromise[0])));
    }

    /**
     * Converts an array of {@code JSPromise} instances into a {@code JSIterator}.
     *
     * @param promises the array of promises
     * @return a {@code JSIterator} wrapping the promises
     */
    private static JSIterator fromPromises(JSPromise[] promises) {
        JSArray jsArr = JSArray.of();
        for(JSPromise promise : promises) {
            jsArr.push(promise);
        }
        return JSIterator.from(jsArr);
    }

    /**
     * Returns a promise that resolves when all input promises settle.
     *
     * @param promises an iterator of promises
     * @return a promise resolving to an array of result objects
     */
    @JS.Coerce
    @JS("return Promise.allSettled(promises);")
    public static native JSPromise allSettled(JSIterator promises);

    /**
     * Returns a promise that resolves when all input promises settle.
     *
     * @param promises an array of promises
     * @return a promise resolving to an array of result objects
     */
    public static JSPromise allSettled(JSArray promises) {
        return allSettled(JSIterator.from(promises));
    }

    /**
     * Returns a promise that resolves when all input promises settle.
     *
     * @param promises a vararg array of promises
     * @return a promise resolving to an array of result objects
     */
    public static JSPromise allSettled(JSPromise... promises) {
        return allSettled(fromPromises(promises));
    }

    /**
     * Returns a promise that resolves when all input promises settle.
     *
     * @param promises a list of promises
     * @return a promise resolving to an array of result objects
     */
    public static JSPromise allSettled(List<JSPromise> promises) {
        return allSettled(fromPromises(promises.toArray(new JSPromise[0])));
    }

    /**
     * Returns a promise that resolves as soon as any input promise resolves.
     *
     * @param promises an iterator of promises
     * @return a promise resolving to the first fulfilled value
     */
    @JS.Coerce
    @JS("return Promise.any(promises);")
    public static native JSPromise any(JSIterator promises);

    /**
     * Returns a promise that resolves as soon as any input promise resolves.
     *
     * @param promises an array of promises
     * @return a promise resolving to the first fulfilled value
     */
    public static JSPromise any(JSArray promises) {
        return any(JSIterator.from(promises));
    }

    /**
     * Returns a promise that resolves as soon as any input promise resolves.
     *
     * @param promises a vararg array of promises
     * @return a promise resolving to the first fulfilled value
     */
    public static JSPromise any(JSPromise... promises) {
        return any(fromPromises(promises));
    }

    /**
     * Returns a promise that resolves as soon as any input promise resolves.
     *
     * @param promises a list of promises
     * @return a promise resolving to the first fulfilled value
     */
    public static JSPromise any(List<JSPromise> promises) {
        return any(fromPromises(promises.toArray(new JSPromise[0])));
    }

    /**
     * Returns a promise that settles as soon as any input promise settles.
     *
     * @param promises an iterator of promises
     * @return a promise resolving or rejecting with the first settled result
     */
    @JS.Coerce
    @JS("return Promise.race(promises);")
    public static native JSPromise race(JSIterator promises);

    /**
     * Returns a promise that settles as soon as any input promise settles.
     *
     * @param promises an array of promises
     * @return a promise resolving or rejecting with the first settled result
     */
    public static JSPromise race(JSArray promises) {
        return any(JSIterator.from(promises));
    }

    /**
     * Returns a promise that settles as soon as any input promise settles.
     *
     * @param promises a vararg array of promises
     * @return a promise resolving or rejecting with the first settled result
     */
    public static JSPromise race(JSPromise... promises) {
        return any(fromPromises(promises));
    }

    /**
     * Returns a promise that settles as soon as any input promise settles.
     *
     * @param promises a list of promises
     * @return a promise resolving or rejecting with the first settled result
     */
    public static JSPromise race(List<JSPromise> promises) {
        return any(fromPromises(promises.toArray(new JSPromise[0])));
    }


    // === Rejection Methods ===

    /**
     * Returns a promise that is rejected with the given {@link JSValue} reason.
     *
     * @param reason the {@code JSValue} reason for rejection
     * @return a rejected {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.reject(reason);")
    public static native JSPromise reject(JSValue reason);

    /**
     * Returns a promise that is rejected with the given {@code int} reason.
     *
     * @param reason the integer reason for rejection
     * @return a rejected {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.reject(reason);")
    public static native JSPromise reject(int reason);

    /**
     * Returns a promise that is rejected with the given {@code double} reason.
     *
     * @param reason the double reason for rejection
     * @return a rejected {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.reject(reason);")
    public static native JSPromise reject(double reason);

    /**
     * Returns a promise that is rejected with the given {@code boolean} reason.
     *
     * @param reason the boolean reason for rejection
     * @return a rejected {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.reject(reason);")
    public static native JSPromise reject(boolean reason);

    /**
     * Returns a promise that is rejected with the given {@code Object} reason.
     *
     * @param reason the object reason for rejection
     * @return a rejected {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.reject(reason);")
    public static native JSPromise reject(Object reason);


    // === Resolution Methods ===

    /**
     * Returns a promise that is resolved with the given {@link JSValue}.
     *
     * @param value the {@code JSValue} to resolve with
     * @return a resolved {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.resolve(value);")
    public static native JSPromise resolve(JSValue value);

    /**
     * Returns a promise that is resolved with the given {@code int} value.
     *
     * @param value the integer value to resolve with
     * @return a resolved {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.resolve(value);")
    public static native JSPromise resolve(int value);

    /**
     * Returns a promise that is resolved with the given {@code double} value.
     *
     * @param value the double value to resolve with
     * @return a resolved {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.resolve(value);")
    public static native JSPromise resolve(double value);

    /**
     * Returns a promise that is resolved with the given {@code boolean} value.
     *
     * @param value the boolean value to resolve with
     * @return a resolved {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.resolve(value);")
    public static native JSPromise resolve(boolean value);

    /**
     * Returns a promise that is resolved with the given {@code Object} value.
     *
     * @param value the object value to resolve with
     * @return a resolved {@code JSPromise}
     */
    @JS.Coerce
    @JS("return Promise.resolve(value);")
    public static native JSPromise resolve(Object value);


    // === Instance Methods ===

    /**
     * Attaches a fulfillment handler to the promise.
     *
     * @param onFulfilled the function to execute when the promise is fulfilled
     * @return a new {@code JSPromise} chained from this one
     */
    @JS.Coerce
    @JS("return this.then(onFulfilled);")
    public native JSPromise then(JSFunction onFulfilled);

    /**
     * Attaches fulfillment and rejection handlers to the promise.
     *
     * @param onFulfilled the function to execute when the promise is fulfilled
     * @param onRejected  the function to execute when the promise is rejected
     * @return a new {@code JSPromise} chained from this one
     */
    @JS.Coerce
    @JS("return this.then(onFulfilled, onRejected);")
    public native JSPromise then(JSFunction onFulfilled, JSFunction onRejected);

    /**
     * Attaches a rejection handler to the promise.
     *
     * @param onRejected the function to execute when the promise is rejected
     * @return a new {@code JSPromise} chained from this one
     */
    @JS.Coerce
    @JS("return this.catch(onRejected);")
    public native JSPromise catch_(JSFunction onRejected);

    /**
     * Attaches a finalization handler to the promise.
     *
     * @param onFinally the function to execute when the promise settles (fulfilled or rejected)
     * @return a new {@code JSPromise} chained from this one
     */
    @JS.Coerce
    @JS("return this.finally(onFinally);")
    public native JSPromise finally_(JSFunction onFinally);


    // === Utility ===

    /**
     * Creates an object containing a promise and its associated {@code resolve} and {@code reject} functions.
     *
     * @return a {@code JSObject} with {@code promise}, {@code resolve}, and {@code reject} properties
     */
    @JS.Coerce
    @JS("return Promise.withResolvers();")
    public static native JSObject withResolvers();
}
