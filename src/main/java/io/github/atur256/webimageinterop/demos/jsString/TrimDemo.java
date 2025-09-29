package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class TrimDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.trim Demo ===");

        JSString padded = JSString.of("   To be, or not to be   ");

        String result1 = padded.trim().as(String.class);
        String result2 = padded.trimStart().as(String.class);
        String result3 = padded.trimEnd().as(String.class);
        String result4 = padded.trimLeft().as(String.class);
        String result5 = padded.trimRight().as(String.class);

        System.out.println("trim():       [" + result1 + "]");
        System.out.println("trimStart():  [" + result2 + "]");
        System.out.println("trimEnd():    [" + result3 + "]");
        System.out.println("trimLeft():   [" + result4 + "]");
        System.out.println("trimRight():  [" + result5 + "]");
        // Expected:
        // trim():       [To be, or not to be]
        // trimStart():  [To be, or not to be   ]
        // trimEnd():    [   To be, or not to be]
        // trimLeft():   [To be, or not to be   ]
        // trimRight():  [   To be, or not to be]

        // Assert values
        assertEquals("To be, or not to be", result1);
        assertEquals("To be, or not to be   ", result2);
        assertEquals("   To be, or not to be", result3);
        assertEquals("To be, or not to be   ", result4);
        assertEquals("   To be, or not to be", result5);
    }
}