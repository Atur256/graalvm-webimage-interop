package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSString;

import static org.junit.Assert.assertEquals;


public class KeysDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.keys Demo ===");

        JSArray arr = JSArray.of(JSString.of("a"), JSString.of("b"));
        JSIterator keys = arr.keys();
        JSArray result = keys.toArray();
        System.out.println("Keys iterator: " + result.toString());
        // Expected: Keys iterator: [0,1]

        // Assert values
        AssertArray.assertArray(result, Integer.class, 0, 1);
    }
}