package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.assertEquals;


public class DescriptionDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.description Demo ===");

        JSSymbol sym = JSSymbol.forKey("alpha");
        String desc = JSSymbol.description(sym);

        System.out.println("JSSymbol: " + sym);
        System.out.println("Description: " + (desc != null ? desc : "null"));
        // Expected:
        // JSSymbol: JavaScript<symbol; Symbol(alpha)>
        // Description: alpha

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(alpha)>", sym.toString());
        assertEquals("alpha", desc);
    }
}