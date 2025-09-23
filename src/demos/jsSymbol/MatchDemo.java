package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class MatchDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.match Demo ===");

        Object sym = JSSymbol.match();

        System.out.println("Symbol.match: " + sym);
        System.out.println("typeof Symbol.match: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.match: JavaScript<symbol; Symbol(Symbol.match)>
        // typeof Symbol.match: JSSymbol

        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.match.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.match.description: Symbol.match
    }
}
