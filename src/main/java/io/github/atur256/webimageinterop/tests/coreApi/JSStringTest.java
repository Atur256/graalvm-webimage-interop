package io.github.atur256.webimageinterop.tests.coreApi;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSEval;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class JSStringTest {

    private static final JSString HELLO_STRING = JSString.of("Hello");
    private static final JSString WORLD_STRING = JSString.of("World");
    private static final JSString HELLO_WORLD_STRING = JSString.of("Hello World");
    private static final JSString JAVASCRIPT_STRING = JSString.of("JavaScript");
    private static final JSString ARROWS_STRING = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193);
    private static final JSString MATH_STRING = JSString.fromCodePoint(0x2211, 0x221A, 0x03C0, 0x221E);
    private static final JSString CURRENCY_STRING = JSString.fromCodePoint(0x20AC, 0x00A5, 0x20B9, 0x0024);
    private static final JSString LONG_TEXT = JSString.of("The quick brown fox jumps over the lazy dog.");

    public static void main(String[] args) {
        testAt();
        testCharAt();
        testCharCodeAt();
        testCodePointAt();
        testConcat();
        testEndsWith();
        testIncludes();
        testFromCharCode();
        testFromCodePoint();
        testIndexOf();
        testLastIndexOf();
        testIsWellFormed();
        testLength();
        testLocaleCompare();
        testMatchAll();
        testMatch();
        testNormalize();
        testPadEnd();
        testPadStart();
        testRaw();
        testRepeat();
        testReplace();
        testReplaceAll();
        testSearch();
        testSlice();
        testSplit();
        testStartsWith();
        testToLocaleLowerCase();
        testToLocaleUpperCase();
        testToLowerCase();
        testToUpperCase();
        testToWellFormed();
        testTrim();
    }

    public static void testAt() {
        assertEquals("H", HELLO_STRING.at(0).as(String.class));
        assertEquals("o", HELLO_STRING.at(4).as(String.class));
        assertEquals(JSUndefined.undefined(), JSValue.checkedCoerce(HELLO_STRING.at(10), JSUndefined.class));
        assertEquals("o", HELLO_STRING.at(-1).as(String.class));
        assertEquals("S", JAVASCRIPT_STRING.at(4).as(String.class));
        assertEquals("i", JAVASCRIPT_STRING.at(-3).as(String.class));
        assertEquals("↑", ARROWS_STRING.at(1).as(String.class));
        assertEquals("→", ARROWS_STRING.at(-2).as(String.class));
        assertEquals("∑", MATH_STRING.at(0).as(String.class));
        assertEquals("∞", MATH_STRING.at(3).as(String.class));
        assertEquals("₹", CURRENCY_STRING.at(2).as(String.class));
        assertEquals("$", CURRENCY_STRING.at(-1).as(String.class));
    }

    public static void testCharAt() {
        assertEquals("H", HELLO_STRING.charAt(0).as(String.class));
        assertEquals("o", HELLO_STRING.charAt(4).as(String.class));
        assertEquals("", HELLO_STRING.charAt(-1).as(String.class));
        assertEquals("S", JAVASCRIPT_STRING.charAt(4).as(String.class));
        assertEquals("t", JAVASCRIPT_STRING.charAt(9).as(String.class));
        assertEquals("", JAVASCRIPT_STRING.charAt(10).as(String.class));
        assertEquals("←", ARROWS_STRING.charAt(0).as(String.class));
        assertEquals("→", ARROWS_STRING.charAt(2).as(String.class));
        assertEquals("√", MATH_STRING.charAt(1).as(String.class));
        assertEquals("∞", MATH_STRING.charAt(3).as(String.class));
        assertEquals("₹", CURRENCY_STRING.charAt(2).as(String.class));
        assertEquals("$", CURRENCY_STRING.charAt(3).as(String.class));
    }

    public static void testCharCodeAt() {
        assertEquals(72, HELLO_STRING.charCodeAt(0));
        assertEquals(111, HELLO_STRING.charCodeAt(4));
        assertEquals(-1, HELLO_STRING.charCodeAt(-1));
        assertEquals(-1, HELLO_STRING.charCodeAt(10));
        assertEquals(8592, ARROWS_STRING.charCodeAt(0));
        assertEquals(8594, ARROWS_STRING.charCodeAt(2));
        assertEquals(8730, MATH_STRING.charCodeAt(1));
        assertEquals(8734, MATH_STRING.charCodeAt(3));
        assertEquals(8377, CURRENCY_STRING.charCodeAt(2));
        assertEquals(36, CURRENCY_STRING.charCodeAt(3));
    }

    public static void testCodePointAt() {
        assertEquals(72, HELLO_STRING.codePointAt(0));
        assertEquals(111, HELLO_STRING.codePointAt(4));
        assertEquals(-1, HELLO_STRING.codePointAt(-1));
        assertEquals(-1, HELLO_STRING.codePointAt(10));
        assertEquals(8592, ARROWS_STRING.codePointAt(0));
        assertEquals(8594, ARROWS_STRING.codePointAt(2));
        assertEquals(8730, MATH_STRING.codePointAt(1));
        assertEquals(8734, MATH_STRING.codePointAt(3));
        assertEquals(8377, CURRENCY_STRING.codePointAt(2));
        assertEquals(36, CURRENCY_STRING.codePointAt(3));
    }

    public static void testConcat() {
        JSString comma = JSString.of(", ");
        JSString exclaim = JSString.of("!");
        JSString label = JSString.of("Arrows: ");
        JSString mathLabel = JSString.of("Math: ");

        assertEquals("Hello, World!", HELLO_STRING.concat(comma, WORLD_STRING, exclaim).as(String.class));
        assertEquals("Arrows: ←↑→↓", label.concat(ARROWS_STRING).as(String.class));
        assertEquals("Math: ∑√π∞", mathLabel.concat(MATH_STRING).as(String.class));
    }

    public static void testEndsWith() {
        assertTrue(HELLO_WORLD_STRING.endsWith(WORLD_STRING));
        assertFalse(HELLO_WORLD_STRING.endsWith("world"));
        assertFalse(HELLO_WORLD_STRING.endsWith(HELLO_STRING));
        assertTrue(HELLO_WORLD_STRING.endsWith(HELLO_STRING, 5));
        assertTrue(ARROWS_STRING.endsWith(JSString.fromCodePoint(0x2192, 0x2193)));
        assertTrue(ARROWS_STRING.endsWith(JSString.fromCodePoint(0x2191), 2));
        assertTrue(MATH_STRING.endsWith(JSString.fromCodePoint(0x03C0, 0x221E)));
        assertTrue(MATH_STRING.endsWith(JSString.fromCodePoint(0x221A), 2));
        assertFalse(MATH_STRING.endsWith(JSString.fromCodePoint(0x221E), 3));
    }

    public static void testIncludes() {
        assertTrue(HELLO_WORLD_STRING.includes(WORLD_STRING));
        assertFalse(HELLO_WORLD_STRING.includes("world"));
        assertTrue(HELLO_WORLD_STRING.includes("lo"));
        assertFalse(HELLO_WORLD_STRING.includes("lo", 5));
        assertTrue(ARROWS_STRING.includes(JSString.fromCodePoint(0x2191)));
        assertTrue(ARROWS_STRING.includes(JSString.fromCodePoint(0x2191), 1));
        assertTrue(MATH_STRING.includes(JSString.fromCodePoint(0x221A)));
        assertTrue(MATH_STRING.includes(JSString.fromCodePoint(0x03C0), 2));
    }

    public static void testFromCharCode() {
        assertEquals("", JSString.fromCharCode().as(String.class));
        assertEquals("A", JSString.fromCharCode(65).as(String.class));
        assertEquals("Hello", JSString.fromCharCode(72, 101, 108, 108, 111).as(String.class));
        assertEquals("$©®", JSString.fromCharCode(36, 169, 174).as(String.class));
        assertEquals("😀", JSString.fromCharCode(0xD83D, 0xDE00).as(String.class));
    }


    public static void testFromCodePoint() {
        assertEquals("", JSString.fromCodePoint().as(String.class));
        assertEquals("A", JSString.fromCodePoint(65).as(String.class));
        assertEquals("Hello", JSString.fromCodePoint(72, 101, 108, 108, 111).as(String.class));
        assertEquals("$©®", JSString.fromCodePoint(36, 169, 174).as(String.class));
        assertEquals("😀", JSString.fromCodePoint(0x1F600).as(String.class));
        assertEquals("Ω🚀", JSString.fromCodePoint(0x03A9, 0x1F680).as(String.class));
    }

    public static void testIndexOf() {
        assertEquals(6, HELLO_WORLD_STRING.indexOf("World"));
        assertEquals(-1, HELLO_WORLD_STRING.indexOf("world"));
        assertEquals(2, HELLO_WORLD_STRING.indexOf("l"));
        assertEquals(9, HELLO_WORLD_STRING.indexOf("l", 4));
        assertEquals(2, HELLO_WORLD_STRING.indexOf("l"), -4);
        assertEquals(1, ARROWS_STRING.indexOf(JSString.fromCodePoint(0x2191)));
        assertEquals(2, ARROWS_STRING.indexOf(JSString.fromCodePoint(0x2192), 2));
        assertEquals(2, MATH_STRING.indexOf(JSString.fromCodePoint(0x03C0)));
        assertEquals(1, MATH_STRING.indexOf(JSString.fromCodePoint(0x221A), 1));
    }

    public static void testLastIndexOf() {
        JSString phrase1 = JSString.of("Hello Hello");
        JSString phrase2 = JSString.fromCodePoint(0x2190, 0x2191, 0x2192, 0x2193, 0x2190, 0x2191, 0x2192, 0x2193);

        assertEquals(6, phrase1.lastIndexOf("Hello"));
        assertEquals(0, phrase1.lastIndexOf("Hello", 5));
        assertEquals(0, phrase1.lastIndexOf("Hello", -5));
        assertEquals(9, phrase1.lastIndexOf("lo"));
        assertEquals(6, phrase2.lastIndexOf(JSString.fromCodePoint(0x2192)));
        assertEquals(6, phrase2.lastIndexOf(JSString.fromCodePoint(0x2192), 6));
    }

    public static void testIsWellFormed() {
        JSString highPlusAscii = JSString.fromCharCode(0xD800, 0x0041);
        JSString lowPlusAscii = JSString.fromCharCode(0xDC00, 0x0042);
        JSString reversedPair = JSString.fromCharCode(0xDC00, 0xD800);

        assertTrue(HELLO_WORLD_STRING.isWellFormed());
        assertTrue(MATH_STRING.isWellFormed());
        assertFalse(highPlusAscii.isWellFormed());
        assertFalse(lowPlusAscii.isWellFormed());
        assertFalse(reversedPair.isWellFormed());
    }

    public static void testLength() {
        JSString text = JSString.of("Life, the universe and everything. Answer:");

        assertEquals(42, text.length());
    }

    public static void testLocaleCompare() {
        JSString a = JSString.of("a");
        JSString A = JSString.of("A");
        JSString a2 = JSString.of("ä");
        JSString ae = JSString.of("ae");
        Map<String, Object> caseSensitive = Map.of("sensitivity", "case");
        Map<String, Object> accentSensitive = Map.of("sensitivity", "accent");

        assertEquals(1, A.localeCompare("a"));
        assertEquals(-1, a.localeCompare("A"));
        assertEquals(0, A.localeCompare("A"));
        assertEquals(-1, a2.localeCompare("ae", "de"));
//        assertEquals(-1, a.localeCompare("A", "en", caseSensitive));
//        assertEquals(1, A.localeCompare("a", "en", caseSensitive));
        assertEquals(-1, a.localeCompare(A));
        assertEquals(-1, a2.localeCompare(ae, JSString.of("sv")));
//        assertEquals(-1, a2.localeCompare("a", "en", accentSensitive));
//        assertEquals(1, a.localeCompare(a2, JSString.of("en"), accentSensitive));
//        assertEquals(0, a2.localeCompare("ä", "en", accentSensitive));
    }

    public static void testMatchAll() {
        JSString phrase = JSString.of("Price: $12, Discount: $5, Tax: $2");
//        JSObject iterator = phrase.matchAll(JSEval.eval("/\\$(\\d+)/g"));

//        String result = collectIterator(iterator);
//
//        assertEquals("$12,12,$5,5,$2,2", result);
    }

    @JS.Coerce
    @JS("return Array.from(it).toString();")
    private static native String collectIterator(Object it);

    @JS.Coerce
    @JS("return it.toString();")
    private static native String objToString(Object it);


    public static void testMatch() {
        JSString phrase = JSString.of("Hello 123 World 456");
        JSString mixed = JSString.of("Hello 123 World ABC xyz");

//        Object result1 = phrase.match("World");
//        Object result2 = mixed.match(JSEval.eval("/[A-Z]/g"));
//        Object result3 = phrase.match("\\d+");
//        Object result4 = phrase.match(JSEval.eval("/\\d+/g"));
//
//        AssertArray.assertArray(JSValue.checkedCoerce(phrase.match("World"), JSArray.class), String.class, "World");
//        AssertArray.assertArray(JSValue.checkedCoerce(mixed.match(JSEval.eval("/[A-Z]/g")), JSArray.class), String.class, "H", "W", "A", "B", "C");
//        AssertArray.assertArray(JSValue.checkedCoerce(phrase.match("\\d+"), JSArray.class), String.class, "123");
//        AssertArray.assertArray(JSValue.checkedCoerce(phrase.match(JSEval.eval("/\\d+/g")), JSArray.class), String.class, "123", "456");
//        assertNull(phrase.match("XYZ"));
    }

    public static void testNormalize() {
        JSString composed = JSString.fromCodePoint(0x00E9);
        JSString decomposed = JSString.fromCodePoint(0x0065, 0x0301);
        JSString fullWidth = JSString.fromCodePoint(0xFF21);

        assertEquals("é", composed.as(String.class));
        assertEquals("é", decomposed.as(String.class));
        assertEquals("é", decomposed.normalize().as(String.class));
        assertEquals("é", decomposed.normalize("NFD").as(String.class));
        assertEquals("é", composed.normalize("NFD").as(String.class));
        assertEquals("é", composed.normalize("NFC").as(String.class));
        assertEquals("é", decomposed.normalize("NFC").as(String.class));
        assertEquals("Ａ", fullWidth.as(String.class));
        assertEquals("A", fullWidth.normalize("NFKC").as(String.class));
    }

    public static void testPadEnd() {
        JSString base = JSString.of("Hi");

        assertEquals("Hi   ", base.padEnd(5).as(String.class));
        assertEquals("Hi***", base.padEnd(5, "*").as(String.class));
        assertEquals("Hi*****", base.padEnd(7, JSString.of("*")).as(String.class));
    }

    public static void testPadStart() {
        JSString base = JSString.of("Hi");

        assertEquals("   Hi", base.padStart(5).as(String.class));
        assertEquals("---Hi", base.padStart(5, "-").as(String.class));
        assertEquals("-----Hi", base.padStart(7, JSString.of("-")).as(String.class));
    }

    public static void testRaw() {
        JSObject template = JSObject.create();
        template.set("raw", new String[]{"Line1\n", "Line2\t", "End"});

        assertEquals("Line1\nLine2\tEnd", JSString.raw(template).as(String.class));
        assertEquals("Line1\nALine2\tBEnd", JSString.raw(template, "A", "B").as(String.class));
    }

    public static void testRepeat() {
        JSString base = JSString.of("Echo");

        assertEquals("EchoEchoEcho", base.repeat(3).as(String.class));
        assertEquals("HelloHelloHelloHello", HELLO_STRING.repeat(4).as(String.class));
    }

    public static void testReplace() {
        JSString phrase = JSString.of("foo bar foo");
        JSString digits = JSString.of("Price: 42");
        Object replacer1 = JSEval.eval("(match) => '[' + match + ']'");
        JSFunction replacer2 = JSFunction.fromJavaFunction((JSString match) -> JSString.of("(" + match.asString() + ")"));

//        assertEquals("baz bar foo", phrase.replace("foo", "baz").as(String.class));
//        assertEquals("baz bar foo", phrase.replace(JSEval.eval("/foo/"), "baz").as(String.class));
//        assertEquals("World, Hello", HELLO_WORLD_STRING.replace(JSEval.eval("/(\\w+) (\\w+)/"), "$2, $1").as(String.class));
//        assertEquals("Price: [42]", digits.replace(JSEval.eval("/\\d+/"), replacer1).as(String.class));
//        assertEquals("Price: (42)", digits.replace(JSEval.eval("/\\d+/"), replacer2).as(String.class));
//        assertEquals("foo bar foo", phrase.replace("xyz", "baz").as(String.class));
//        assertEquals("123 bar foo", phrase.replace("foo", 123).as(String.class));
//
//        JSString multi = JSString.of("foo bar foo");
//        assertEquals("baz bar baz", multi.replace(JSEval.eval("/foo/g"), "baz").as(String.class));
    }

    public static void testReplaceAll() {
        JSString multi = JSString.of("foo bar foo");

//        assertEquals("baz bar baz", multi.replace(JSEval.eval("/foo/g"), "baz").as(String.class));
    }

    public static void testSearch() {
        JSString text = JSString.of("Find 42 here");

//        assertEquals(5, text.search(JSEval.eval("/\\d+/")));
//        assertEquals(0, text.search("Find"));
//        assertEquals(-1, text.search(JSEval.eval("/find/")));
//        assertEquals(0, text.search(JSEval.eval("/find/i")));
//        assertEquals(-1, text.search(JSEval.eval("/^42/")));
//        assertEquals(-1, text.search("XYZ"));
    }

    public static void testSlice() {
        assertEquals("the lazy dog.", LONG_TEXT.slice(31).as(String.class));
        assertEquals("dog.", LONG_TEXT.slice(-4).as(String.class));
        assertEquals("quick brown fox", LONG_TEXT.slice(4, 19).as(String.class));
        assertEquals("lazy", LONG_TEXT.slice(-9, -5).as(String.class));
    }

    public static void testSplit() {
        JSString csv = JSString.of("red,green,blue,yellow");
        JSObject regexObject = JSEval.eval("/,/", JSObject.class);

        JSArray all1 = JSValue.checkedCoerce(csv.split(","), JSArray.class);
        JSArray limited = JSValue.checkedCoerce(csv.split(",", 2), JSArray.class);
        JSArray allByObject = JSValue.checkedCoerce(csv.split(regexObject), JSArray.class);
        JSArray limitedByObject = JSValue.checkedCoerce(csv.split(regexObject, 2), JSArray.class);
        JSArray allChars = JSValue.checkedCoerce(csv.split(""), JSArray.class);

        AssertArray.assertArray(all1, String.class, "red", "green", "blue", "yellow");
        AssertArray.assertArray(limited, String.class, "red", "green");
        AssertArray.assertArray(allByObject, String.class, "red", "green", "blue", "yellow");
        AssertArray.assertArray(limitedByObject, String.class, "red", "green");
        AssertArray.assertArray(allChars, String.class, "r", "e", "d", ",", "g", "r", "e", "e", "n", ",", "b", "l", "u", "e", ",", "y", "e", "l", "l", "o", "w");
    }

    public static void testStartsWith() {
        JSString text = JSString.of("To be, or not to be, that is the question.");

        assertTrue(text.startsWith("To be"));
        assertFalse(text.startsWith("to be"));
        assertTrue(text.startsWith(JSString.of("To be")));
        assertFalse(text.startsWith(JSString.of("question")));
        assertTrue(text.startsWith("not", 10));
        assertFalse(text.startsWith("To", 3));
        assertTrue(text.startsWith(JSString.of("not"), 10));
        assertFalse(text.startsWith(JSString.of("To"), 3));
        assertFalse(text.startsWith("To", 100));
        assertFalse(text.startsWith(JSString.of("To"), 100));
    }

    public static void testToLocaleLowerCase() {
        JSString turkish = JSString.fromCodePoint(0x0130).concat(JSString.of("stanbul"));
        JSString english = JSString.of("HELLO WORLD");

        assertEquals("i̇stanbul", turkish.toLocaleLowerCase().as(String.class));
        assertEquals("istanbul", turkish.toLocaleLowerCase("tr").as(String.class));
        assertEquals("istanbul", turkish.toLocaleLowerCase(JSString.of("tr")).as(String.class));
        assertEquals("hello world", english.toLocaleLowerCase().as(String.class));
        assertEquals("hello world", english.toLocaleLowerCase("en").as(String.class));
        assertEquals("hello world", english.toLocaleLowerCase(JSString.of("en")).as(String.class));
    }

    public static void testToLocaleUpperCase() {
        JSString turkish = JSString.fromCodePoint(0x0069).concat(JSString.of("stanbul"));
        JSString english = JSString.of("hello world");

        assertEquals("ISTANBUL", turkish.toLocaleUpperCase().as(String.class));
        assertEquals("İSTANBUL", turkish.toLocaleUpperCase("tr").as(String.class));
        assertEquals("İSTANBUL", turkish.toLocaleUpperCase(JSString.of("tr")).as(String.class));
        assertEquals("HELLO WORLD", english.toLocaleUpperCase().as(String.class));
        assertEquals("HELLO WORLD", english.toLocaleUpperCase("en").as(String.class));
        assertEquals("HELLO WORLD", english.toLocaleUpperCase(JSString.of("en")).as(String.class));
    }

    public static void testToLowerCase() {
        assertEquals("the quick brown fox jumps over the lazy dog.", LONG_TEXT.toLowerCase().as(String.class));
    }

    public static void testToUpperCase() {
        assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.", LONG_TEXT.toUpperCase().as(String.class));
    }

    public static void testToWellFormed() {
        JSString str1 = JSString.of("ab").concat(JSString.fromCodePoint(0xD800));
        JSString str2 = str1.concat(JSString.of("c"));
        JSString str3 = JSString.fromCodePoint(0xDFFF).concat(JSString.of("ab"));
        JSString str4 = JSString.of("c").concat(JSString.fromCodePoint(0xDFFF)).concat(JSString.of("ab"));
        JSString str5 = JSString.of("abc");
        JSString str6 = JSString.of("ab").concat(JSString.fromCodePoint(0x1F604)).concat(JSString.of("c"));

        assertEquals("ab�", str1.toWellFormed().as(String.class));
        assertEquals("ab�c", str2.toWellFormed().as(String.class));
        assertEquals("�ab", str3.toWellFormed().as(String.class));
        assertEquals("c�ab", str4.toWellFormed().as(String.class));
        assertEquals("abc", str5.toWellFormed().as(String.class));
        assertEquals("ab\uD83D\uDE04c", str6.toWellFormed().as(String.class));
    }

    public static void testTrim() {
        JSString padded = JSString.of("   To be, or not to be   ");

        assertEquals("To be, or not to be", padded.trim().as(String.class));
        assertEquals("To be, or not to be   ", padded.trimStart().as(String.class));
        assertEquals("   To be, or not to be", padded.trimEnd().as(String.class));
    }
}