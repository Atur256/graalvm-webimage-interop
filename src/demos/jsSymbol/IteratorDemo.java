package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class IteratorDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.iterator Demo ===");

        JSSymbol sym = JSSymbol.iterator();

        System.out.println("JSSymbol.iterator: " + sym);
        System.out.println("typeof JSSymbol.iterator: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.iterator: JavaScript<symbol; Symbol(Symbol.iterator)>
        // typeof JSSymbol.iterator: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.iterator.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.iterator.description: Symbol.iterator
    }
}
