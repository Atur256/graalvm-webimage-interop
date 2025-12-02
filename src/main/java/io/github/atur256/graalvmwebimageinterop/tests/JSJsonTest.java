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

import io.github.atur256.graalvmwebimageinterop.builtin.*;
import org.graalvm.webimage.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class JSJsonTest {

    public static void main(String[] args) {
        testParse();
        testParseWithReviver();
        testRawJson();
        testStringifyBasic();
        testStringifyWithReplacer();
        testStringifyWithSpacing();
        testStringifyCircular();
        testStringifyUndefinedAndNull();
        testRawJson();
    }

    public static void testParse() {
        JSObject parsed = (JSObject) JSJson.parse("{\"name\":\"Alice\",\"age\":30}");
        JSObject empty = (JSObject) JSJson.parse("{}");
        JSValue parsedNull = JSJson.parse("null");
        JSValue array = JSJson.parse("[1,2,3]");

        assertThrows(ThrownFromJavaScript.class, () -> JSJson.parse("{ invalid }"));
        assertEquals("Alice", parsed.get("name", String.class));
        assertEquals(Integer.valueOf(30), parsed.get("age", Integer.class));
        assertEquals(0, JSValue.checkedCoerce(empty.keys(), JSArray.class).length);
        assertNull(parsedNull);
        assertEquals("[1,2,3]", JSJson.stringify(array));
    }

    public static void testParseWithReviver() {
        JSFunction reviver = JSFunction.of((JSString key, JSValue value) -> {
            if(JSString.of("age").equals(key) && value instanceof JSNumber num) {
                return JSNumber.of(num.as(Integer.class) + 1);
            }
            return value;
        });

        JSObject revived = (JSObject) JSJson.parse("{\"name\":\"Bob\",\"age\":40}", reviver);
        JSValue revivedArray = JSJson.parse("[10,20]", reviver);

        assertEquals("Bob", revived.get("name", String.class));
        assertEquals(Integer.valueOf(41), revived.get("age", Integer.class));
        assertEquals("[10,20]", JSJson.stringify(revivedArray));
    }

    public static void testStringifyBasic() {
        JSObject obj = JSObject.create();
        obj.set(JSString.of("name"), JSString.of("Alice"));
        obj.set(JSString.of("age"), JSNumber.of(30));

        String json = JSJson.stringify(obj);

        assertEquals("{\"name\":\"Alice\",\"age\":30}", json);
        assertEquals("\"Hello\"", JSJson.stringify("Hello"));
        assertEquals("42", JSJson.stringify(42));
        assertEquals("true", JSJson.stringify(true));
        assertEquals("null", JSJson.stringify(null));
    }

    public static void testStringifyWithReplacer() {
        JSObject obj = JSObject.create();
        obj.set(JSString.of("name"), JSString.of("Alice"));
        obj.set(JSString.of("age"), JSNumber.of(30));
        JSFunction replacer = JSFunction.of((JSString key, JSValue value) -> {
            if("age".equals(key.asString())) return JSUndefined.undefined();
            return value;
        });

        String json = JSJson.stringify(obj, replacer);
        assertEquals("{\"name\":\"Alice\"}", json);
    }

    public static void testStringifyWithSpacing() {
        JSObject obj = JSObject.create();
        obj.set(JSString.of("name"), JSString.of("Alice"));
        obj.set(JSString.of("age"), JSNumber.of(30));
        JSFunction replacer = JSFunction.of((JSString key, JSValue value) -> {
            if("age".equals(key.asString())) return JSUndefined.undefined();
            return value;
        });

        String jsonPretty = JSJson.stringify(obj, replacer, 2); // 2-space indentation
        String jsonPrettyStr = JSJson.stringify(obj, replacer, "--"); // String spacing

        assertEquals("""
                {
                  "name": "Alice"
                }""", jsonPretty);
        assertEquals("""
                {
                --"name": "Alice"
                }""", jsonPrettyStr);
    }

    public static void testStringifyCircular() {
        // Create circular structure
        JSObject circular = JSObject.create();
        circular.set(JSString.of("self"), circular);

        assertThrows(ThrownFromJavaScript.class, () -> JSJson.stringify(circular));
    }

    public static void testStringifyUndefinedAndNull() {
        assertNull(JSJson.stringify(JSUndefined.instance()));
        assertEquals("null", JSJson.stringify(Double.NaN));
        assertEquals("null", JSJson.stringify(Double.POSITIVE_INFINITY));
    }

    public static void testRawJson() {
        JSValue raw1 = JSJson.rawJSON(JSString.of("\"Hello world\""));
        JSValue raw2 = JSJson.rawJSON("\"Hello world\"");
        JSString notRaw = JSString.of("\"Hello world\"");
        String rawText = "{\"status\":\"ok\"}";
        Object plain = java.util.Map.of("status", "ok");

        assertTrue(JSJson.isRawJSON(raw1));
        assertFalse(JSJson.isRawJSON(notRaw));
        assertFalse(JSJson.isRawJSON(notRaw));
        assertFalse(JSJson.isRawJSON(rawText));
        assertTrue(JSJson.isRawJSON(raw1));
        assertEquals("\"Hello world\"", JSJson.stringify(raw2));
        assertTrue(JSJson.isRawJSON(raw2));
        assertTrue(JSJson.isRawJSON(raw2));
        assertFalse(JSJson.isRawJSON(plain));
        assertFalse(JSJson.isRawJSON(null));
    }
}
