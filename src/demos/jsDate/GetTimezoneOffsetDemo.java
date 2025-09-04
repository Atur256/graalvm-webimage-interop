package demos.jsDate;

import builtin.JSDate;


public class GetTimezoneOffsetDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getTimezoneOffset Demo ===");
        JSDate date = new JSDate();
        System.out.println("Timezone offset (minutes): " + date.getTimezoneOffset());
        // Expected: Timezone offset: -120 (for CEST)
    }
}
