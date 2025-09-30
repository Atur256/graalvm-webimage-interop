package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIterator;
import io.github.atur256.webimageinterop.demos.AssertArray;
import org.graalvm.webimage.api.JSValue;

import static org.junit.Assert.assertEquals;


public class EntriesDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.entries Demo ===");

        JSArray arr = JSArray.of("x", "y");
        JSIterator entries = arr.entries();
        JSArray result = entries.toArray();
        System.out.println("Entries iterator: " + result.toString());
        // Expected: Entries iterator: [0,x,1,y]

        // Assert values
        JSArray pair1 = JSValue.checkedCoerce(result.get(0), JSArray.class);
        JSArray pair2 = JSValue.checkedCoerce(result.get(1), JSArray.class);
        assertEquals(Integer.valueOf(0), JSValue.checkedCoerce(pair1.get(0), Integer.class));
        assertEquals("x", JSValue.checkedCoerce(pair1.get(1), String.class));
        assertEquals(Integer.valueOf(1), JSValue.checkedCoerce(pair2.get(0), Integer.class));
        assertEquals("y", JSValue.checkedCoerce(pair2.get(1), String.class));
    }
}