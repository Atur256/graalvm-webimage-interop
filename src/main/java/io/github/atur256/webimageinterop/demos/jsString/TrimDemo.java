package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;


public class TrimDemo {

    public static void main(String[] args) {
        System.out.println("=== JSString.trim Demo ===");

        JSString padded = JSString.of("   To be, or not to be   ");

        System.out.println("trim():       [" + padded.trim().as(String.class) + "]");
        System.out.println("trimStart():  [" + padded.trimStart().as(String.class) + "]");
        System.out.println("trimEnd():    [" + padded.trimEnd().as(String.class) + "]");
        System.out.println("trimLeft():   [" + padded.trimLeft().as(String.class) + "]");
        System.out.println("trimRight():  [" + padded.trimRight().as(String.class) + "]");
        // Expected:
        // trim():       [To be, or not to be]
        // trimStart():  [To be, or not to be   ]
        // trimEnd():    [   To be, or not to be]
        // trimLeft():   [To be, or not to be   ]
        // trimRight():  [   To be, or not to be]
    }
}
