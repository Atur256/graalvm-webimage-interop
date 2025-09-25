package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class ToStringTagDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.toStringTag Demo ===");

        JSSymbol sym = JSSymbol.toStringTag();

        System.out.println("JSSymbol.toStringTag: " + sym);
        System.out.println("typeof JSSymbol.toStringTag: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.toStringTag: JavaScript<symbol; Symbol(Symbol.toStringTag)>
        // typeof JSSymbol.toStringTag: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.toStringTag.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.toStringTag.description: Symbol.toStringTag
    }
}
