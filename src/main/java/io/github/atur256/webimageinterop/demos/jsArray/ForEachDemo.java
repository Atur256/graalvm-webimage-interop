package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSFunction;
import org.graalvm.webimage.api.JSString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.forEach Demo ===");

        List<String> results = new ArrayList<>();
        JSArray javaArr = JSArray.of("a", "b");
        JSFunction print = JSFunction.fromGeneralConsumer((JSString arg) -> {
            results.add(arg.as(String.class));
            System.out.println(arg.as(String.class));
        });

        javaArr.forEach(print);
        // Expected:
        // "a"
        // "b"

        // Assert values
        assertEquals(2, results.size());
        assertEquals("a", results.get(0));
        assertEquals("b", results.get(1));
    }
}