package io.github.atur256.webimageinterop.demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ToLocaleStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toLocaleString Demo ===");

        JSNumber number = JSNumber.of(1234567.89);

        // Default locale
        String result1 = number.toLocaleString();
        System.out.println("Default locale: " + result1);
        // Expected: Default locale: 1,234,567.89

        // Specific locale
        String result2 = number.toLocaleString("de-AT");
        String result3 = number.toLocaleString("en-US");
        System.out.println("German (Austria): " + result2);
        System.out.println("US English: " + result3);
        // Expected:
        // German (Austria): 1 234 567,89
        // US English: 1,234,567.89

        // Locale + currency options
        JSObject currencyOpts = JSObject.create();
        currencyOpts.set("style", "currency");
        currencyOpts.set("currency", "EUR");
        String result4 = number.toLocaleString("de-AT", currencyOpts);
        System.out.println("Currency (de-AT): " + result4);
        // Expected: Currency (de-AT): € 1.234.567,89

        // Locale + fraction options (safe range: 0–20)
        JSObject fractionOpts = JSObject.create();
        fractionOpts.set("minimumFractionDigits", JSNumber.of(4));
        fractionOpts.set("maximumFractionDigits", JSNumber.of(4));
        String result5 = number.toLocaleString("en-US", fractionOpts);
        System.out.println("Fixed fraction (en-US): " + result5);
        // Expected: Fixed fraction (en-US): 1,234,567.8900

        // Assert values
        System.out.println("Test - 1");
        assertTrue(result1.matches("\\d[,.]\\d{3}[,.]\\d{3}[,.]\\d{2}"));
        assertEquals("1 234 567,89", result2);
        assertEquals("1,234,567.89", result3);
        assertEquals("€ 1.234.567,89", result4);
        assertEquals("1,234,567.8900", result5);
    }
}