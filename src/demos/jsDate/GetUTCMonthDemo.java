package demos.jsDate;

import builtin.JSDate;


public class GetUTCMonthDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.getUTCMonth Demo ===");
        JSDate date = new JSDate();
        System.out.println("UTC month (0=Jan): " + date.getUTCMonth());
        // Expected: UTC month: <1-12>
    }
}
