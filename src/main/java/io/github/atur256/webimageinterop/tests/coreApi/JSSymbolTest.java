package io.github.atur256.webimageinterop.tests.coreApi;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSSymbol;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;


public class JSSymbolTest {

    public static void main(String[] args) {
        testForKey();
        testEquality();
        testIsSameSymbol();
        testKeyFor();
    }

    public static void testForKey() {
        JSSymbol sym = JSSymbol.forKey("alpha");

        assertEquals("JavaScript<symbol; Symbol(alpha)>", sym.toString());
    }

    public static void testEquality() {
        JSSymbol sym1 = JSSymbol.forKey("shared");
        JSSymbol sym2 = JSSymbol.forKey("shared");
        JSSymbol sym3 = JSSymbol.forKey("unique");

        assertEquals(sym1, sym2);
        assertNotEquals(sym1, sym3);
    }

    public static void testIsSameSymbol() {
        JSSymbol sym1 = JSSymbol.forKey("shared");
        JSSymbol sym2 = JSSymbol.forKey("shared");
        JSSymbol sym3 = JSSymbol.forKey("unique");

        assertTrue(JSSymbol.isSameSymbol(sym1, sym2));
        assertFalse(JSSymbol.isSameSymbol(sym1, sym3));
    }

    public static void testKeyFor() {
        JSSymbol shared1 = JSSymbol.forKey("alpha");
        JSSymbol shared2 = JSSymbol.forKey("beta");
        String result1 = JSValue.checkedCoerce(JSSymbol.keyFor(shared1), String.class);
        String result2 = JSValue.checkedCoerce(JSSymbol.keyFor(shared2), String.class);
        JSSymbol local = createLocalSymbol("gamma");
        String result3 = JSSymbol.keyFor(local);

        assertEquals("alpha", result1);
        assertEquals("beta", result2);
        assertNull(result3);
    }

    @JS.Coerce
    @JS(value = "return Symbol(desc);")
    private static native JSSymbol createLocalSymbol(String desc);
}