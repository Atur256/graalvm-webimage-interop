package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class MatchAllDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.matchAll Demo ===");

        Object sym = JSSymbol.matchAll();

        System.out.println("Symbol.matchAll: " + sym);
        System.out.println("typeof Symbol.matchAll: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.matchAll: JavaScript<symbol; Symbol(Symbol.matchAll)>
        // typeof Symbol.matchAll: JSSymbol

        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.matchAll.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.matchAll.description: Symbol.matchAll
    }
}
