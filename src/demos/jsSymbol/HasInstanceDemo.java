package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class HasInstanceDemo {

    public static void main(String[] args) {
        System.out.println("=== Symbol.hasInstance Demo ===");

        Object sym = JSSymbol.hasInstance();

        System.out.println("Symbol.hasInstance: " + sym);
        System.out.println("typeof Symbol.hasInstance: " + sym.getClass().getSimpleName());
        // Expected:
        // Symbol.hasInstance: JavaScript<symbol; Symbol(Symbol.hasInstance)>
        // typeof Symbol.hasInstance: JSSymbol

        Object desc = JSSymbol.description(sym);
        System.out.println("Symbol.hasInstance.description: " + (desc != null ? desc.toString() : "null"));
        // Expected:
        // Symbol.hasInstance.description: Symbol.hasInstance
    }
}
