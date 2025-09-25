package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class MatchDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.match Demo ===");

        JSSymbol sym = JSSymbol.match();

        System.out.println("JSSymbol.match: " + sym);
        System.out.println("typeof JSSymbol.match: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.match: JavaScript<symbol; Symbol(Symbol.match)>
        // typeof JSSymbol.match: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.match.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.match.description: Symbol.match
    }
}
