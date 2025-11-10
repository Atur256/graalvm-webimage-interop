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


/**
 * Provides a Java binding for the JavaScript {@code Intl} object within the WebImage interop layer.
 * This class exposes internationalization utilities such as locale normalization and supported values.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSArray locales = JSIntl.getCanonicalLocales("en-US", "de-DE");
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Intl")
public class JSIntl extends JSObject {

    // === Locale Utilities ===

    /**
     * Returns the canonical form of the given locale identifiers.
     * This method normalizes locale strings according to BCP 47.
     *
     * @param locales one or more locale identifiers
     * @return a {@link JSArray} of canonical locale strings
     */
    @JS.Coerce
    @JS("""
            const args = [];
                    for (let i = 0; i < locales.length; i++) {
                        args.push(locales[i]);
                    }
            return Intl.getCanonicalLocales(args);""")
    public static native JSArray getCanonicalLocales(String... locales);

    /**
     * Returns the list of supported values for a given internationalization key.
     * Common keys include {@code "calendar"}, {@code "currency"}, {@code "collation"}, etc.
     *
     * @param key the internationalization key
     * @return a {@link JSArray} of supported values
     */
    @JS.Coerce
    @JS("return Intl.supportedValuesOf(key);")
    public static native JSArray supportedValuesOf(String key);
}
