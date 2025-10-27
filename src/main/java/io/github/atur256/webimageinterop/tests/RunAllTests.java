package io.github.atur256.webimageinterop.tests;

public class RunAllTests {

    public static void main(String[] args) throws Exception {

        // Run all test

        // JSArray Test
        JSArrayTest.main(args);
        System.out.println("JSArray Test finished.");

        // JSDate Test
        JSDateTest.main(args);
        System.out.println("JSDate Test finished.");

        // JSError Test
        JSErrorTest.main(args);
        System.out.println("JSError Test finished.");

        // JSEval Test
        JSEvalTest.main(args);
        System.out.println("JSEval Test finished.");

        // JSFunction Test
        JSFunctionTest.main(args);
        System.out.println("JSFunction Test finished.");

        // JSIntl Test
        JSIntlTest.main(args);
        System.out.println("JSIntl Test finished.");

        // JSIterator Test
        JSIteratorTest.main(args);
        System.out.println("JSIterator Test finished.");

        // JSJson Test
        JSJsonTest.main(args);
        System.out.println("JSJson Test finished.");

        // JSMap Test
        JSMapTest.main(args);
        System.out.println("JSMap Test finished.");

        // JSMath Test
        JSMathTest.main(args);
        System.out.println("JSMath Test finished.");

        // JSPromis Test
        JSPromiseTest.main(args);
        System.out.println("JSPromis Test finished.");

        // JSSRegExp Test
        JSRegExpTest.main(args);
        System.out.println("JSSRegExp Test finished.");

        // JSSet Test
        JSSetTest.main(args);
        System.out.println("JSSet Test finished.");

        // JSUri Test
        JSUriTest.main(args);
        System.out.println("JSUri Test finished.");

        System.out.println("All Test finished.");
    }
}
