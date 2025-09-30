package io.github.atur256.webimageinterop.demos.jsArray;

import io.github.atur256.webimageinterop.builtin.JSArray;

import static org.junit.Assert.assertTrue;


public class ToLocaleStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSArray.toLocaleString Demo ===");

        JSArray arr = JSArray.of(123456.789, 987654.321);

        String localized = arr.toLocaleString();
        System.out.println("Localized string: " + localized);
        // Expected: Locale-formatted numbers, e.g. "123,456.789,987,654.321"

        // Assert values
        assertTrue(localized.matches("\\d{3}[,.]\\d{3}[,.]\\d{3},\\d{3}[,.]\\d{3}[,.]\\d{3}"));
    }
}