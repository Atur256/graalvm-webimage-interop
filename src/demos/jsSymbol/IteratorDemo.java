package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class IteratorDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.iterator Demo ===");

        Object sym = JSSymbol.iterator();

        System.out.println("Symbol.iterator: " + sym);
        System.out.println("typeof Symbol.iterator: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.iterator: JavaScript<symbol; Symbol(Symbol.iterator)>
        // typeof Symbol.iterator: JSSymbol

        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.iterator.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.iterator.description: Symbol.iterator
    }
}
