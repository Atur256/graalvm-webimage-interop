package io.github.atur256.webimageinterop.demos.jsIntl;

import io.github.atur256.webimageinterop.builtin.JSArray;
import io.github.atur256.webimageinterop.builtin.JSIntl;
import org.graalvm.webimage.api.JSValue;


public class SupportedValuesDemo {


    public static void main(String[] args) {
        System.out.println("=== JSIntl.supportedValuesOf Demo ===");

        JSArray calendars = JSIntl.supportedValuesOf("calendar");
        JSArray timeZones = JSIntl.supportedValuesOf("timeZone");

        System.out.println("Supported calendars:");
        for (int i = 0; i < calendars.length; i++) {
            System.out.println("  - " + JSValue.checkedCoerce(calendars.get(i), String.class));
        }
        // Expected:
        // Supported calendars:
        //  - gregory
        //  - buddhist
        //  - chinese
        //  - islamic
        //  - japanese
        //  ...

        System.out.println("Supported time zones:");
        for (int i = 0; i < timeZones.length; i++) {
            System.out.println("  - " + JSValue.checkedCoerce(timeZones.get(i), String.class));
        }
        // Expected:
        //Supported time zones:
        //  - Europe/Vienna
        //  - America/New_York
        //  - Asia/Tokyo
        //  ...
    }
}
