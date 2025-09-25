package tests;

import tests.jsJson.JSJsonTestRunner;
import tests.jsNumber.JSNumberTestRunner;

import java.util.Map;


/**
 * Central test orchestrator for all demo-based test suites.
 * Invokes each package-level test runner and prints a grouped summary of results.
 */
public class TestRunner {

    /**
     * Entry point for running all demo test suites.
     * Executes each package-level runner and prints pass/fail results grouped by domain.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("=== Running All Tests ===\n");

        // Run JSNumber demo tests
        System.out.println("▶ Running JSNumber Tests:");
        Map<String, Boolean> jsNumberResults = JSNumberTestRunner.runAll();
        System.out.println("--------------------------------------------------\n");

        // Run JSJson demo tests
        System.out.println("▶ Running JSJson Tests:");
        Map<String, Boolean> jsJsonResults = JSJsonTestRunner.runAll();
        System.out.println("--------------------------------------------------\n");

        // Print grouped summary
        System.out.println("=== Summary ===");
        int totalPassed = 0;
        int totalFailed = 0;

        totalPassed += printGroupedSummary("JSNumber", jsNumberResults);
        totalFailed += jsNumberResults.size() - totalPassed;

        int jsJsonPassed = printGroupedSummary("JSJson", jsJsonResults);
        totalPassed += jsJsonPassed;
        totalFailed += jsJsonResults.size() - jsJsonPassed;

        // Global totals
        System.out.println("\n=== Totals ===");
        System.out.println("Total Tests Passed: " + totalPassed);
        System.out.println("Total Tests Failed: " + totalFailed);
        System.out.println("Total Tests       : " + (totalPassed + totalFailed));
    }

    /**
     * Prints a grouped summary for a given domain and returns the number of passed tests.
     *
     * @param groupName the name of the test group (e.g. JSNumber)
     * @param results   the map of test labels to pass/fail status
     * @return the number of passed tests in this group
     */
    private static int printGroupedSummary(String groupName, Map<String, Boolean> results) {
        System.out.println("\n▶ " + groupName + " Summary:");
        int passed = 0;

        for (Map.Entry<String, Boolean> entry : results.entrySet()) {
            String label = entry.getKey();
            boolean pass = entry.getValue();
            System.out.printf("%-25s : %s\n", label, pass ? "PASS" : "FAIL");
            if (pass) passed++;
        }

        System.out.printf("Passed: %d / %d\n", passed, results.size());
        return passed;
    }
}
