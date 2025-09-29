package io.github.atur256.webimageinterop.demos.jsSymbol;

import org.graalvm.webimage.api.JSSymbol;

import static org.junit.Assert.*;


public class ValueOfDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSSymbol.valueOf Demo ===");

        JSSymbol original = JSSymbol.forKey("alpha");
        JSSymbol value = JSSymbol.valueOf(original);

        System.out.println("Original symbol: " + original);
        System.out.println("ValueOf symbol: " + value);
        System.out.println("Same reference: " + (original == value));
        System.out.println("Description: " + JSSymbol.description(value));
        // Expected:
        // Original symbol: JavaScript<symbol; Symbol(alpha)>
        // ValueOf symbol: JavaScript<symbol; Symbol(alpha)>
        // Same reference: false
        // Description: alpha

        // Assert values
        assertEquals("JavaScript<symbol; Symbol(alpha)>", original.toString());
        assertEquals("JavaScript<symbol; Symbol(alpha)>", value.toString());
        assertNotSame(original, value);
        assertEquals("alpha", JSSymbol.description(value));
    }
}