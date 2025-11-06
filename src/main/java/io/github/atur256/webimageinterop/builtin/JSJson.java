package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import java.util.function.BiFunction;


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

    /**
     * Converts a {@link JSValue} to a JSON string.
     *
     * @param value the value to stringify
     * @return the JSON string
     */
    @JS.Coerce
    @JS("""
            const res = JSON.stringify(value);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value);

    /**
     * Converts a Java object to a JSON string.
     *
     * @param value the object to stringify
     * @return the JSON string
     */
    @JS.Coerce
    @JS("""
            const res = JSON.stringify(value);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(Object value);

    /**
     * Converts a {@link JSValue} to a JSON string using a replacer function.
     *
     * @param value    the value to stringify
     * @param replacer the replacer function
     * @return the JSON string
     */
    @JS.Coerce
    @JS("""
            const res = JSON.stringify(value, replacer);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value, JSFunction replacer);

    /**
     * Converts a {@link JSValue} to a formatted JSON string using a replacer and indentation.
     *
     * @param value    the value to stringify
     * @param replacer the replacer function
     * @param space    the number of spaces for indentation
     * @return the formatted JSON string
     */
    @JS.Coerce
    @JS("""
            const res = JSON.stringify(value, replacer, space);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value, JSFunction replacer, int space);

    /**
     * Converts a {@link JSValue} to a formatted JSON string with indentation.
     *
     * @param value the value to stringify
     * @param space the number of spaces for indentation
     * @return the formatted JSON string
     */
    @JS.Coerce
    @JS("""
            const res = JSON.stringify(value, null, space);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(JSValue value, int space);

    /**
     * Converts a Java object to a formatted JSON string with indentation.
     *
     * @param value the object to stringify
     * @param space the number of spaces for indentation
     * @return the formatted JSON string
     */
    @JS.Coerce
    @JS("""
            const res = JSON.stringify(value, null, space);
            return res === undefined? 'undefined' : res;
            """)
    public static native String stringify(Object value, int space);


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
     * Checks if a {@link JSValue} is a raw JSON value.
     *
     * @param value the value to check
     * @return {@code true} if the value is raw JSON
     */
    @JS.Coerce
    @JS("return JSON.isRawJSON(value);")
    public static native boolean isRawJSON(JSValue value);

    /**
     * Checks if a Java object is a raw JSON value.
     *
     * @param value the object to check
     * @return {@code true} if the object is raw JSON
     */
    @JS.Coerce
    @JS("return JSON.isRawJSON(value);")
    public static native boolean isRawJSON(Object value);


    // === Function Wrappers ===

    /**
     * Wraps a Java {@link BiFunction} as a JSON reviver function.
     *
     * @param javaReviver the Java reviver function
     * @return a {@code JSFunction} usable in {@code JSON.parse}
     */
    @JS.Coerce
    @JS("return function(key, value) { return javaReviver.apply(key, value); }")
    public static native JSFunction fromReviver(BiFunction<JSString, JSValue, JSValue> javaReviver);

    /**
     * Wraps a Java {@link BiFunction} as a JSON replacer function.
     *
     * @param javaReplacer the Java replacer function
     * @return a {@code JSFunction} usable in {@code JSON.stringify}
     */
    @JS.Coerce
    @JS("return function(key, value) { return javaReplacer.apply(key, value); }")
    public static native JSFunction fromReplacer(BiFunction<JSString, JSValue, JSValue> javaReplacer);
}
