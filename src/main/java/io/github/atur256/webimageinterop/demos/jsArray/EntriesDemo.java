package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;

import static org.junit.Assert.assertEquals;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.entries Demo ===");

        JSArray arr = JSArray.of("x","y");
        JSIterator entries = arr.entries();
        String result = entries.toArray().toString();
        assertEquals("[0,x,1,y]", result);
        System.out.println("Entries iterator: " + result);
        // Expected: Entries iterator: [0,x,1,y]
    }
}
