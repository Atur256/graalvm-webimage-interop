package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class MatchAllDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.matchAll Demo ===");

        JSSymbol sym = JSSymbol.matchAll();

        System.out.println("JSSymbol.matchAll: " + sym);
        System.out.println("typeof JSSymbol.matchAll: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.matchAll: JavaScript<symbol; Symbol(Symbol.matchAll)>
        // typeof JSSymbol.matchAll: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.matchAll.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.matchAll.description: Symbol.matchAll
    }
}
