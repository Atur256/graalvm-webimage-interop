package io.github.atur256.webimageinterop.demos.jsIntl;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIntl;


public class CanonicalLocalesDemo {

    public static void main(String[] args) {
        System.out.println("=== JSIntl.getCanonicalLocales Demo ===");

        JSArray result = JSIntl.getCanonicalLocales("EN-us", "de", "fr-FR", "zh-hans");

        System.out.println("Results: " + result.toString());
        // Expected: Results: [en-US,de,fr-FR,zh-Hans]
    }
}
