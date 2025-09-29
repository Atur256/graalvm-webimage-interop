package io.github.atur256.webimageinterop.demos.jsString;

import org.graalvm.webimage.api.JSString;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class LengthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSString.length Demo ===");

        JSString text = JSString.of("Life, the universe and everything. Answer:");

        int result = text.length();
        System.out.println(JSValue.checkedCoerce(text, String.class) + result);
        // Expected: Life, the universe and everything. Answer:: 42

        // Assert values
        assertEquals(42, result);
    }
}