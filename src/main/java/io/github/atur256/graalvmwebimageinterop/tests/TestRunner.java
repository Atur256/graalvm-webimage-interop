/*
 * Copyright (c) 2025 Arthur Schwaiger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.atur256.graalvmwebimageinterop.tests;

/**
 * Runs all WebImage interop tests sequentially.
 */
public class TestRunner {

    public static void main(String[] args) {

        System.out.println("Running all WebImage interop tests...\n");

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

        // JSPromise Test
        JSPromiseTest.main(args);
        System.out.println("JSPromise Test finished.");

        // JSRegExp Test
        JSRegExpTest.main(args);
        System.out.println("JSRegExp Test finished.");

        // JSSet Test
        JSSetTest.main(args);
        System.out.println("JSSet Test finished.");

        // JSUri Test
        JSUriTest.main(args);
        System.out.println("JSUri Test finished.");

        System.out.println("\nAll tests completed successfully.");
    }
}
