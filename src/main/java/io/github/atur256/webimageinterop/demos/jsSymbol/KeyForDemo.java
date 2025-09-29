package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSSymbol;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class KeyForDemo {


    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.keyFor Demo ===");

        JSSymbol shared1 = JSSymbol.forKey("alpha");
        JSSymbol shared2 = JSSymbol.forKey("beta");

        String result1 = JSValue.checkedCoerce(JSSymbol.keyFor(shared1), String.class);
        String result2 = JSValue.checkedCoerce(JSSymbol.keyFor(shared2), String.class);
        System.out.println("JSSymbol.keyFor(Symbol.for(\"alpha\")): " + result1);
        System.out.println("JSSymbol.keyFor(Symbol.for(\"beta\")): " + result2);
        // Expected:
        // JSSymbol.keyFor(Symbol.for("alpha")): alpha
        // JSSymbol.keyFor(Symbol.for("beta")): beta

        // Non-registry symbol: Symbol("gamma")
        JSSymbol local = createLocalSymbol("gamma");

        JSValue result3 = JSSymbol.keyFor(local);
        System.out.println("JSSymbol.keyFor(Symbol(\"gamma\")): " + result3);
        // Expected:
        // JSSymbol.keyFor(Symbol("gamma")): JavaScript<undefined; undefined>

        // Assert values
        assertEquals("alpha", result1);
        assertEquals("beta", result2);
        assertEquals(JSValue.undefined(), result3);
    }

    @JS.Coerce
    @JS(value = "return Symbol(desc);")
    public static native JSSymbol createLocalSymbol(String desc);
}