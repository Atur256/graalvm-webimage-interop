package io.github.atur256.webimageinterop.demos.jsDate;

import io.github.atur256.webimageinterop.builtin.JSDate;

import static org.junit.Assert.assertEquals;


public class UTCDemo {

    public static void main(String[] args) {
        System.out.println("\n=== JSDate.UTC Overloads Demo ===");

        long ts1 = JSDate.UTC(2025);
        long ts2 = JSDate.UTC(2025, 8);
        long ts3 = JSDate.UTC(2025, 8, 4);
        long ts4 = JSDate.UTC(2025, 8, 4, 13);
        long ts5 = JSDate.UTC(2025, 8, 4, 13, 32);
        long ts6 = JSDate.UTC(2025, 8, 4, 13, 32, 0);
        long ts7 = JSDate.UTC(2025, 8, 4, 13, 32, 0, 500);

        System.out.println("UTC(2025): " + ts1);
        System.out.println("UTC(2025, 8): " + ts2);
        System.out.println("UTC(2025, 8, 4): " + ts3);
        System.out.println("UTC(2025, 8, 4, 13): " + ts4);
        System.out.println("UTC(2025, 8, 4, 13, 32): " + ts5);
        System.out.println("UTC(2025, 8, 4, 13, 32, 0): " + ts6);
        System.out.println("UTC(2025, 8, 4, 13, 32, 0, 500): " + ts7);
        // Expected:
        // UTC(2025): 1735689600000
        // UTC(2025, 8): 1756684800000
        // UTC(2025, 8, 4): 1756944000000
        // UTC(2025, 8, 4, 13): 1756990800000
        // UTC(2025, 8, 4, 13, 32): 1756992720000
        // UTC(2025, 8, 4, 13, 32, 0): 1756992720000
        // UTC(2025, 8, 4, 13, 32, 0, 500): 1756992720500

        // Assert values
        assertEquals(1735689600000L, ts1);
        assertEquals(1756684800000L, ts2);
        assertEquals(1756944000000L, ts3);
        assertEquals(1756990800000L, ts4);
        assertEquals(1756992720000L, ts5);
        assertEquals(1756992720000L, ts6);
        assertEquals(1756992720500L, ts7);
    }
}