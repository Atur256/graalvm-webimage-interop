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

import io.github.atur256.graalvmwebimageinterop.builtin.JSRegExp;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;
import org.graalvm.webimage.api.ThrownFromJavaScript;

import static io.github.atur256.graalvmwebimageinterop.tests.Asserts.*;


public class JSRegExpTest {

    public static void main(String[] args) {
        testBasicMatch();
        testExecAndGroups();
        testFlagsAndProperties();
        testGlobalState();
        testEdgeCases();
    }

    static void testBasicMatch() {
        JSRegExp regex = JSRegExp.of("hello", "");
        assertTrue(regex.test("hello world"));
        assertFalse(regex.test("goodbye world"));
        assertEquals("JavaScript<object; /hello/>", regex.toString());
    }

    static void testExecAndGroups() {
        JSRegExp regex = JSRegExp.of("(\\d+)-(\\w+)", "");

        JSObject result = JSValue.checkedCoerce(regex.exec("123-abc"), JSObject.class);

        assertEquals("123-abc", result.get(0, String.class));
        assertEquals("123", result.get(1, String.class));
        assertEquals("abc", result.get(2, String.class));
    }

    static void testFlagsAndProperties() {
        JSRegExp regex1 = JSRegExp.of("x", "gimsuyd");
        JSRegExp regex2 = JSRegExp.of("\\p{Script=Latin}", "v");

        assertTrue(regex1.global);
        assertTrue(regex1.hasIndices);
        assertTrue(regex1.ignoreCase);
        assertTrue(regex1.multiline);
        assertTrue(regex1.dotAll);
        assertTrue(regex1.sticky);
        assertTrue(regex1.unicode);
        assertTrue(regex2.unicodeSets);
        assertEquals("dgimsuy", regex1.flags);
        assertEquals("x", regex1.source);
    }

    static void testGlobalState() {
        JSRegExp regex = JSRegExp.of("\\d+", "g");

        JSObject first = JSValue.checkedCoerce(regex.exec("123 456"), JSObject.class);
        JSObject second = JSValue.checkedCoerce(regex.exec("123 456"), JSObject.class);

        assertEquals("123", first.get(0, String.class));
        assertTrue(regex.lastIndex > 0);
        assertEquals("456", second.get(0, String.class));
        assertTrue(regex.lastIndex > 0);
    }

    static void testEdgeCases() {
        JSRegExp empty = JSRegExp.of("", "");
        JSRegExp regex = JSRegExp.of("abc", "");
        JSValue result = regex.exec("xyz");

        assertTrue(empty.test("anything"));
        assertNull(result);
        assertThrows(ThrownFromJavaScript.class, () -> JSRegExp.of("[", ""));
    }
}
