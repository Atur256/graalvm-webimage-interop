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

package io.github.atur256.graalvmwebimageinterop.tests;

import io.github.atur256.graalvmwebimageinterop.builtin.JSArray;
import io.github.atur256.graalvmwebimageinterop.builtin.JSIntl;
import io.github.atur256.graalvmwebimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.ThrownFromJavaScript;

import static org.junit.Assert.*;


public class JSIntlTest {

    public static void main(String[] args) {
        testGetCanonicalLocales();
        testSupportedValuesOf();
        testEdgeCases();
    }

    static void testGetCanonicalLocales() {
        JSArray result = JSIntl.getCanonicalLocales("EN-us", "de", "fr-FR", "zh-hans");

        AssertArray.assertArray(result, String.class, "en-US", "de", "fr-FR", "zh-Hans");
    }

    static void testSupportedValuesOf() {
        JSArray calendars = JSIntl.supportedValuesOf("calendar");
        JSArray timeZones = JSIntl.supportedValuesOf("timeZone");

        assertTrue(calendars.length > 0);
        assertTrue(timeZones.length > 0);
    }

    static void testEdgeCases() {
        JSArray emptyLocales = JSIntl.getCanonicalLocales();

        assertEquals(0, emptyLocales.length);
        assertThrows(ThrownFromJavaScript.class, () -> JSIntl.getCanonicalLocales("invalid-locale", "123"));
        assertThrows(ThrownFromJavaScript.class, () -> JSIntl.supportedValuesOf("nonexistent-key"));
    }
}
