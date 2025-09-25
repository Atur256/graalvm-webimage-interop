package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class SearchDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.search Demo ===");

        JSSymbol sym = JSSymbol.search();

        System.out.println("JSSymbol.search: " + sym);
        System.out.println("typeof JSSymbol.search: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.search: JavaScript<symbol; Symbol(Symbol.search)>
        // typeof JSSymbol.search: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.search.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.search.description: Symbol.search
    }
}
