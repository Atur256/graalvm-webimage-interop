package demos.jsDate;

import builtin.JSDate;


public class GetUTCMillisecondsDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCMilliseconds Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC milliseconds: " + date.getUTCMilliseconds());
        // Expected: UTC milliseconds: <0–999>
    }
}
