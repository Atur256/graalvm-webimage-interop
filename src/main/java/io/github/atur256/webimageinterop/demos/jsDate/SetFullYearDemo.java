package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;


public class SetFullYearDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setFullYear Demo ===");
        JSDate date = new JSDate();
        date.setFullYear(2030);
        System.out.println("Updated year: " + date.getFullYear());
        // Expected: Updated year: 2030
    }
}
