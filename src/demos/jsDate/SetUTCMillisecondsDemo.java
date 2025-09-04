package demos.jsDate;

import builtin.JSDate;


public class SetUTCMillisecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.setUTCMilliseconds Demo ===");
        JSDate date = new JSDate();
        date.setUTCMilliseconds(250);
        System.out.println("Updated UTC milliseconds: " + date.getUTCMilliseconds());
        // Expected: Updated UTC milliseconds: 250
    }
}
