package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;


/**
 * Provides Java bindings for JavaScript URI encoding and decoding functions.
 * This class wraps native methods like {@code encodeURI}, {@code decodeURI}, and their component variants.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * String encoded = JSUri.encodeURIComponent("name=Alice & age=42");
 * String decoded = JSUri.decodeURIComponent(encoded);
 * }</pre>
 */
public class JSUri {

    // === URI Encoding/Decoding ===

    /**
     * Encodes a URI by escaping characters that are not valid in a URI.
     *
     * @param uri the URI string to encode
     * @return the encoded URI string
     */
    @JS.Coerce
    @JS("return encodeURI(uri);")
    public static native String encodeURI(String uri);

    /**
     * Decodes an encoded URI string.
     *
     * @param uri the encoded URI string
     * @return the decoded URI string
     */
    @JS.Coerce
    @JS("return decodeURI(uri);")
    public static native String decodeURI(String uri);

    /**
     * Encodes a URI component by escaping all characters except letters, digits, and a few special characters.
     *
     * @param uri the URI component to encode
     * @return the encoded component string
     */
    @JS.Coerce
    @JS("return encodeURIComponent(uri);")
    public static native String encodeURIComponent(String uri);

    /**
     * Decodes an encoded URI component string.
     *
     * @param uri the encoded component string
     * @return the decoded component string
     */
    @JS.Coerce
    @JS("return decodeURIComponent(uri);")
    public static native String decodeURIComponent(String uri);
}
