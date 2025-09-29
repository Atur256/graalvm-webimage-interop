package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class SpeciesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.species Demo ===");

        JSSymbol sym = JSSymbol.species();

        String name = sym.getClass().getSimpleName();
        System.out.println("JSSymbol.species: " + sym);
        System.out.println("typeof JSSymbol.species: " + name);
        // Expected:
        // JSSymbol.species: JavaScript<symbol; Symbol(Symbol.species)>
        // typeof JSSymbol.species: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.species.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.species.description: Symbol.species

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(Symbol.species)>", sym.toString());
        assertEquals("JSSymbol", name);
        assertEquals("Symbol.species", desc);
    }
}