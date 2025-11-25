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
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;


/**
 * Provides a Java binding for the JavaScript {@code JSON} object within the WebImage interop layer.
 * This class enables parsing and stringifying of JSON using native JavaScript behavior.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSValue obj = JSJson.parse("{\"name\":\"Alice\"}");
 * String json = JSJson.stringify(obj, 2);
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("JSON")
public class JSJson extends JSObject {

    // === Parsing Methods ===

    /**
     * Parses a JSON string into a {@link JSValue}.
     *
     * @param text the JSON string
     * @return the parsed {@code JSValue}
     */
    @JS.Coerce
    @JS("return JSON.parse(text);")
    public static native JSValue parse(String text);

    /**
     * Parses a JSON string using a custom reviver function.
     *
     * @param text    the JSON string
     * @param reviver the reviver function
     * @return the parsed {@code JSValue}
     */
    @JS.Coerce
    @JS("return JSON.parse(text, reviver);")
    public static native JSValue parse(String text, JSFunction reviver);


    // === Stringify Methods ===

    @JS.Coerce
    @JS("const res = JSON.stringify(value, replacer, space); return res === undefined ? null : res;")
    private static native String nativeStringify(Object value, Object replacer, Object space);

    /**
     * Converts a Java object or {@link JSValue} to a JSON string with optional replacer.
     * If the result is {@code undefined}, {@code null} is returned.
     *
     * @param value    the value to stringify (Java object or {@link JSValue})
     * @param replacer optional replacer function ({@link JSFunction})
     * @return the JSON string, or {@code null} if the value is {@code undefined} or cannot be serialized
     */
    public static String stringify(Object value, Object replacer) {
        String result = nativeStringify(value, replacer, null);
        return result == null || "undefined".equals(result) ? null : result;
    }

    /**
     * Converts a Java object or {@link JSValue} to a JSON string with optional replacer and spacing.
     * If the result is {@code undefined}, {@code null} is returned.
     *
     * @param value    the value to stringify (Java object or {@link JSValue})
     * @param replacer optional replacer function ({@link JSFunction})
     * @param space    optional number of spaces or string for indentation; can be {@code null}
     * @return the JSON string, or {@code null} if the value is {@code undefined} or cannot be serialized
     */
    public static String stringify(Object value, Object replacer, Object space) {
        String result = nativeStringify(value, replacer, space);
        return result == null || "undefined".equals(result) ? null : result;
    }

    /**
     * Converts a Java object or {@link JSValue} to a JSON string.
     * If the value cannot be serialized, or is {@code undefined}, {@code null} is returned.
     *
     * @param value the value to stringify (Java object or {@link JSValue})
     * @return the JSON string, or {@code null} if the value is {@code undefined} or cannot be serialized
     */
    public static String stringify(Object value) {
        return stringify(value, null, null);
    }


    // === Raw JSON Methods ===

    /**
     * Wraps a {@link JSString} as a raw JSON value.
     *
     * @param text the raw JSON string
     * @return the wrapped {@code JSValue}
     */
    @JS.Coerce
    @JS("return JSON.rawJSON(text);")
    public static native JSValue rawJSON(JSString text);

    /**
     * Wraps a {@code String} as a raw JSON value.
     *
     * @param text the raw JSON string
     * @return the wrapped {@code JSValue}
     */
    @JS.Coerce
    @JS("return JSON.rawJSON(text);")
    public static native JSValue rawJSON(String text);

    /**
     * Checks if a Java object is a raw JSON value.
     *
     * @param value the object to check
     * @return {@code true} if the object is raw JSON
     */
    @JS.Coerce
    @JS("return JSON.isRawJSON(value);")
    public static native boolean isRawJSON(Object value);
}
