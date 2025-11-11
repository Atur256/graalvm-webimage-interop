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
