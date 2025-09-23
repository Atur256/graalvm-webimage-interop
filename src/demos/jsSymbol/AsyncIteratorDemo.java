package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class AsyncIteratorDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.asyncIterator Demo ===");

        Object sym = JSSymbol.asyncIterator();

        System.out.println("Symbol.asyncIterator: " + sym);
        System.out.println("typeof Symbol.asyncIterator: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.asyncIterator: Symbol(Symbol.asyncIterator)
        // typeof Symbol.asyncIterator: JSSymbol

        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.asyncIterator.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.asyncIterator.description: Symbol.asyncIterator
    }
}
