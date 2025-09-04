package demos.jsDate;

import builtin.JSDate;


public class UTCDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.UTC Overloads Demo ===");

        double ts1 = JSDate.UTC(2025);
        double ts2 = JSDate.UTC(2025, 8); // September
        double ts3 = JSDate.UTC(2025, 8, 4);
        double ts4 = JSDate.UTC(2025, 8, 4, 13);
        double ts5 = JSDate.UTC(2025, 8, 4, 13, 32);
        double ts6 = JSDate.UTC(2025, 8, 4, 13, 32, 0);
        double ts7 = JSDate.UTC(2025, 8, 4, 13, 32, 0, 500);

        System.out.println("UTC(2025): " + ts1); // Expected: UTC(2025): 1.7356896E12
        System.out.println("UTC(2025, 8): " + ts2); // Expected: UTC(2025, 8): 1.7566848E12
        System.out.println("UTC(2025, 8, 4): " + ts3); // Expected: UTC(2025, 8, 4): 1.756944E12
        System.out.println("UTC(2025, 8, 4, 13): " + ts4); // Expected: UTC(2025, 8, 4, 13): 1.7569908E12
        System.out.println("UTC(2025, 8, 4, 13, 32): " + ts5); // Expected: UTC(2025, 8, 4, 13, 32): 1.75699272E12
        System.out.println("UTC(2025, 8, 4, 13, 32, 0): " + ts6); // Expected: UTC(2025, 8, 4, 13, 32, 0): 1.75699272E12
        System.out.println("UTC(2025, 8, 4, 13, 32, 0, 500): " + ts7); // Expected: UTC(2025, 8, 4, 13, 32, 0, 500): 1.7569927205E12
    }
}
