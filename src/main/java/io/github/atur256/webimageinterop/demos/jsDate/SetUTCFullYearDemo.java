package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetUTCFullYearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCFullYear Demo ===");
        JSDate date = new JSDate();
        date.setUTCFullYear(2030);
        System.out.println("Updated UTC year: " + date.getUTCFullYear());
        // Expected: Updated UTC year: 2030
    }
}
