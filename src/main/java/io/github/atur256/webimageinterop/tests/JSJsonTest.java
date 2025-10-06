package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.builtin.JSJson;
import org.graalvm.webimage.api.*;

import static org.junit.Assert.*;


public class JSJsonTest {

    public static void main(String[] args) {
        testParse();
        testParseWithReviver();
        testStringify();
        testReplacer();
        testIndentation();
        testRawJson();
    }

    public static void testParse() {
        JSObject parsed = (JSObject) JSJson.parse("{\"name\":\"Alice\",\"age\":30}");
        JSObject empty = (JSObject) JSJson.parse("{}");
        JSValue parsedNull = JSJson.parse("null");
        JSValue array = JSJson.parse("[1,2,3]");
        try {
            JSJson.parse("{ invalid }");
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("SyntaxError"));
        }

        assertEquals("Alice", ((JSString) parsed.get("name")).as(String.class));
        assertEquals(Integer.valueOf(30), ((JSNumber) parsed.get("age")).as(Integer.class));
        assertEquals(0, JSValue.checkedCoerce(empty.keys(), JSArray.class).length);
        assertNull(parsedNull);
        assertEquals("[1,2,3]", JSJson.stringify(array));
    }

    public static void testParseWithReviver() {
        JSFunction reviver = JSJson.fromReviver((JSString key, JSValue value) -> {
            if(JSString.of("age").equals(key) && value instanceof JSNumber num) {
                return JSNumber.of(num.as(Integer.class) + 1);
            }
            return value;
        });

        JSObject revived = (JSObject) JSJson.parse("{\"name\":\"Bob\",\"age\":40}", reviver);
        JSValue revivedArray = JSJson.parse("[10,20]", reviver);

        assertEquals("Bob", ((JSString) revived.get("name")).as(String.class));
        assertEquals(Integer.valueOf(41), ((JSNumber) revived.get("age")).as(Integer.class));
        assertEquals("[10,20]", JSJson.stringify(revivedArray));
    }

    public static void testStringify() {
        JSValue jsObj = JSEval.eval("({ name: 'Alice', age: 30 })", JSValue.class);
        JSValue fn = JSEval.eval("(function() {})", JSValue.class);
        JSValue circular = JSEval.eval("(() => { const a = {}; a.self = a; return a; })()", JSValue.class);
        try {
            JSJson.stringify(circular);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Converting circular structure"));
        }

        assertEquals("{\"name\":\"Alice\",\"age\":30}", JSJson.stringify(jsObj));
        assertEquals("\"Bob\"", JSJson.stringify("Bob"));
        assertEquals("undefined", JSJson.stringify(JSUndefined.instance()));
        assertEquals("null", JSJson.stringify(Double.NaN));
        assertEquals("null", JSJson.stringify(Double.POSITIVE_INFINITY));
        assertEquals("undefined", JSJson.stringify(fn));
    }

    public static void testReplacer() {
        JSValue jsObj = JSEval.eval("({ name: 'Alice', age: 30 })", JSValue.class);
        JSFunction replacer = JSJson.fromReplacer((JSString key, JSValue value) -> {
            if(JSString.of("age").equals(key)) return JSUndefined.instance();
            return value;
        });

        JSValue array = JSEval.eval("[1,2,3]", JSValue.class);
        String replaced = JSJson.stringify(array, replacer);

        assertEquals("{\"name\":\"Alice\"}", JSJson.stringify(jsObj, replacer));
        assertEquals("[1,2,3]", replaced);
    }

    public static void testIndentation() {
        JSValue jsObj = JSEval.eval("({ name: 'Alice', age: 30 })", JSValue.class);
        JSFunction replacer = JSJson.fromReplacer((JSString key, JSValue value) -> {
            if(JSString.of("age").equals(key)) return JSUndefined.instance();
            return value;
        });

        String pretty = JSJson.stringify(jsObj, 4);
        String indented = JSJson.stringify(jsObj, replacer, 2);

        assertTrue(pretty.contains("    \"name\": \"Alice\""));
        assertTrue(pretty.contains("    \"age\": 30"));
        assertEquals("\"Bob\"", JSJson.stringify("Bob", 2));
        assertEquals("\"Bob\"", JSJson.stringify(JSString.of("Bob"), 2));
        assertTrue(indented.contains("  \"name\": \"Alice\""));
        assertFalse(indented.contains("age"));
    }

    public static void testRawJson() {
        JSValue raw1 = JSJson.rawJSON(JSString.of("\"Hello world\""));
        JSValue raw2 = JSJson.rawJSON("\"Hello world\"");
        JSString notRaw = JSString.of("\"Hello world\"");
        String rawText = "{\"status\":\"ok\"}";
        Object plain = java.util.Map.of("status", "ok");

        assertTrue(JSJson.isRawJSON(raw1));
        assertFalse(JSJson.isRawJSON(notRaw));
        assertFalse(JSJson.isRawJSON((Object) notRaw));
        assertFalse(JSJson.isRawJSON(rawText));
        assertTrue(JSJson.isRawJSON((Object) raw1));
        assertEquals("\"Hello world\"", JSJson.stringify(raw2));
        assertTrue(JSJson.isRawJSON(raw2));
        assertTrue(JSJson.isRawJSON((Object) raw2));
        assertFalse(JSJson.isRawJSON(plain));
        assertFalse(JSJson.isRawJSON((Object) null));
    }
}
