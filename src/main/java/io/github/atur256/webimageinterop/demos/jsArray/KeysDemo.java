package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.keys Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b") );
        JSIterator keys = arr.keys();
        String result = keys.toArray().toString();
        assertEquals("[0,1]", result);
        System.out.println("Keys iterator: " + result);
        // Expected: Keys iterator: [0,1]
    }
}
