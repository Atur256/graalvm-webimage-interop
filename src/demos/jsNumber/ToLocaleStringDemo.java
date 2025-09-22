package demos.jsNumber;

import org.graalvm.webimage.api.JSNumber;
import org.graalvm.webimage.api.JSObject;


public class ToLocaleStringDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSNumber.toLocaleString Demo ===");

        JSNumber number = JSNumber.of(1234567.89);

        // Default locale
        System.out.println("Default locale: " + number.toLocaleString());
        // Expected: Default locale: 1,234,567.89

        // Specific locale
        System.out.println("German (Austria): " + number.toLocaleString("de-AT"));
        System.out.println("US English: " + number.toLocaleString("en-US"));
        // Expected:
        // German (Austria): 1 234 567,89
        // US English: 1,234,567.89

        // Locale + currency options
        JSObject currencyOpts = JSObject.create();
        currencyOpts.set("style", "currency");
        currencyOpts.set("currency", "EUR");
        System.out.println("Currency (de-AT): " + number.toLocaleString("de-AT", currencyOpts));
        // Expected: Currency (de-AT): € 1.234.567,89

        // Locale + fraction options (safe range: 0–20)
        JSObject fractionOpts = JSObject.create();
        fractionOpts.set("minimumFractionDigits", JSNumber.of(4));
        fractionOpts.set("maximumFractionDigits", JSNumber.of(4));
        System.out.println("Fixed fraction (en-US): " + number.toLocaleString("en-US", fractionOpts));
        // Expected: Fixed fraction (en-US): 1,234,567.8900
    }
}
