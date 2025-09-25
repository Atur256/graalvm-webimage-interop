package io.github.atur256.webimageinterop.demos.jsIterator;

import io.github.atur256.webimageinterop.builtin.*;
import org.graalvm.webimage.api.JSBoolean;
import org.graalvm.webimage.api.JSString;

import java.lang.String;


public class FindDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSIterator.find Demo ===");

        JSArray array = JSArray.of("apple", "banana", "cherry");
        JSIterator iterator = JSIterator.from(array);
        JSFunction startsWithB = JSFunction.fromGeneralFunction((JSString arg) -> JSBoolean.of(arg.startsWith("b")));

        String found = iterator.find(startsWithB, String.class);
        System.out.println("First element starting with 'b': " + found);
        // Expected Output: First element starting with 'b': "banana"
    }
}
