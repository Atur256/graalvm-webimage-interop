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

package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSMath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JSMathTest {

    private static final double DELTA = 0.0;

    public static void main(String[] args) {
        testConstants();
        testBasicArithmetic();
        testTrigonometric();
        testHyperbolic();
        testLogarithmic();
        testRoundingAndBitwise();
        testPowerAndRoots();
        testAggregation();
        testRandomAndSign();
        testEdgeCases();
    }

    public static void testConstants() {
        assertEquals(Math.E, JSMath.e(), DELTA);
        assertEquals(Math.log(2), JSMath.ln2(), DELTA);
        assertEquals(Math.log(10), JSMath.ln10(), DELTA);
        assertEquals(1 / Math.log(2), JSMath.log2E(), DELTA);
        assertEquals(1 / Math.log(10), JSMath.log10E(), 1e-15);
        assertEquals(Math.PI, JSMath.pi(), DELTA);
        assertEquals(1 / Math.sqrt(2), JSMath.sqrt12(), 1e-15);
        assertEquals(Math.sqrt(2), JSMath.sqrt2(), DELTA);
    }

    public static void testBasicArithmetic() {
        assertEquals(Math.abs(-5), JSMath.abs(-5), DELTA);
        assertEquals(Math.abs(5), JSMath.abs(5), DELTA);
        assertEquals(Math.abs(-5.0), JSMath.abs(-5.0), DELTA);
        assertEquals(Math.abs(5.0), JSMath.abs(5.0), DELTA);
        assertEquals(Math.ceil(2.1), JSMath.ceil(2.1), DELTA);
        assertEquals(Math.ceil(-2.1), JSMath.ceil(-2.1), DELTA);
        assertEquals(Math.floor(2.9), JSMath.floor(2.9), DELTA);
        assertEquals(Math.floor(-2.9), JSMath.floor(-2.9), DELTA);
        assertEquals((float) 3.9, JSMath.fround(3.9), DELTA);
        assertEquals((float) -3.9, JSMath.fround(-3.9), DELTA);
        assertEquals((float) 0.0, JSMath.fround(0.0), DELTA);
        assertEquals(3.0, JSMath.trunc(3.9), DELTA);
        assertEquals(-3.0, JSMath.trunc(-3.9), DELTA);
        assertEquals(6, JSMath.imul(2, 3));
        assertEquals(-6, JSMath.imul(-2, 3));
        assertEquals(6, JSMath.imul(-2, -3));
    }

    public static void testTrigonometric() {
        assertEquals(Math.cos(0), JSMath.cos(0), DELTA);
        assertEquals(Math.sin(1), JSMath.sin(1), DELTA);
        assertEquals(Math.tan(1), JSMath.tan(1), DELTA);
        assertEquals(Math.atan2(1, 1), JSMath.atan2(1, 1), DELTA);
        assertEquals(Math.atan(1), JSMath.atan(1), DELTA);
        assertEquals(Math.acos(1), JSMath.acos(1), DELTA);
        assertEquals(Math.asin(1), JSMath.asin(1), DELTA);
    }

    public static void testHyperbolic() {
        assertEquals(Math.cosh(0), JSMath.cosh(0), DELTA);
        assertEquals(Math.sinh(1), JSMath.sinh(1), DELTA);
        assertEquals(Math.tanh(1), JSMath.tanh(1), DELTA);
        assertEquals(Math.log(1 + Math.sqrt(0)), JSMath.acosh(1), DELTA);
        assertEquals(Math.log(1 + Math.sqrt(1 + 1)), JSMath.asinh(1), 1e-15);
        assertEquals(0.5 * Math.log((1 + 0.5) / (1 - 0.5)), JSMath.atanh(0.5), DELTA);
    }

    public static void testLogarithmic() {
        assertEquals(Math.log(10), JSMath.log(10), DELTA);
        assertEquals(Math.log1p(1), JSMath.log1p(1), DELTA);
        assertEquals(3.0, JSMath.log2(8), DELTA);
        assertEquals(Math.log10(100), JSMath.log10(100), DELTA);
    }

    public static void testRoundingAndBitwise() {
        assertEquals(3.0, JSMath.round(2.6), DELTA);
        assertEquals(1.0, JSMath.sign(42), DELTA);
        assertEquals(-1.0, JSMath.sign(-42), DELTA);
        assertEquals(0.0, JSMath.sign(0), DELTA);
        assertEquals(31, JSMath.clz32(1));
    }

    public static void testPowerAndRoots() {
        assertEquals(8.0, JSMath.pow(2, 3), DELTA);
        assertEquals(4.0, JSMath.sqrt(16), DELTA);
        assertEquals(3.0, JSMath.cbrt(27), DELTA);
        assertEquals(Math.exp(1), JSMath.exp(1), DELTA);
        assertEquals(1.718281828459045, JSMath.expm1(1), DELTA);
    }

    public static void testAggregation() {
        assertEquals(42.0, JSMath.max(1, 42, -5), DELTA);
        assertEquals(-5.0, JSMath.min(1, 42, -5), DELTA);
        assertEquals(5.0, JSMath.hypot(3, 4), DELTA);
        assertEquals(0.0, JSMath.hypot(), DELTA);
    }

    public static void testRandomAndSign() {
        double r = JSMath.random();
        assertTrue(r >= 0.0 && r < 1.0);
    }

    public static void testEdgeCases() {
        assertTrue(Double.isNaN(JSMath.acos(2)));
        assertTrue(Double.isNaN(JSMath.asin(2)));
        assertTrue(Double.isNaN(JSMath.acosh(0.5)));
        assertTrue(Double.isNaN(JSMath.atanh(2)));
        assertTrue(Double.isNaN(JSMath.sqrt(-1)));
        assertTrue(Double.isNaN(JSMath.log(-1)));
        assertEquals(Double.NEGATIVE_INFINITY, JSMath.log(0), DELTA);
        assertEquals(Double.POSITIVE_INFINITY, JSMath.exp(1000), DELTA);
        assertTrue(Double.isNaN(JSMath.pow(Double.NaN, 2)));
        assertTrue(Double.isNaN(JSMath.pow(2, Double.NaN)));
    }
}
