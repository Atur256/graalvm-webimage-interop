package demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;


public class SpeciesDemo {

    public static void main(String[] args) {
        System.out.println("=== JSSymbol.species Demo ===");

        JSSymbol sym = JSSymbol.species();

        System.out.println("JSSymbol.species: " + sym);
        System.out.println("typeof JSSymbol.species: " + sym.getClass().getSimpleName());
        // Expected:
        // JSSymbol.species: JavaScript<symbol; Symbol(Symbol.species)>
        // typeof JSSymbol.species: JSSymbol

        String desc = JSSymbol.description(sym);
        System.out.println("JSSymbol.species.description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol.species.description: Symbol.species
    }
}
