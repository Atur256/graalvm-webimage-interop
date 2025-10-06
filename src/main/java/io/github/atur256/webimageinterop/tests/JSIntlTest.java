package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIntl;
import io.github.atur256.webimageinterop.tests.testUtils.AssertArray;
import org.graalvm.webimage.api.ThrownFromJavaScript;

import static org.junit.Assert.*;


public class JSIntlTest {

    public static void main(String[] args) {
        testGetCanonicalLocales();
        testSupportedValuesOf();
        testEdgeCases();
    }

    static void testGetCanonicalLocales() {
        JSArray result = JSIntl.getCanonicalLocales("EN-us", "de", "fr-FR", "zh-hans");

        AssertArray.assertArray(result, String.class, "en-US", "de", "fr-FR", "zh-Hans");
    }

    static void testSupportedValuesOf() {
        JSArray calendars = JSIntl.supportedValuesOf("calendar");
        JSArray timeZones = JSIntl.supportedValuesOf("timeZone");

        assertTrue(calendars.length > 0);
        assertTrue(timeZones.length > 0);
    }

    static void testEdgeCases() {
        JSArray emptyLocales = JSIntl.getCanonicalLocales();

        assertEquals(0, emptyLocales.length);
        try {
            JSIntl.getCanonicalLocales("invalid-locale", "123");
            fail();
        } catch (ThrownFromJavaScript thrownFromJavaScript) {
            assertTrue(thrownFromJavaScript.getMessage().contains("RangeError: Incorrect locale information provided"));
        }
        try {
            JSIntl.supportedValuesOf("nonexistent-key");
            fail();
        } catch (ThrownFromJavaScript thrownFromJavaScript) {
            assertTrue(thrownFromJavaScript.getMessage().contains("RangeError: Invalid key : nonexistent-key"));
        }
    }
}
