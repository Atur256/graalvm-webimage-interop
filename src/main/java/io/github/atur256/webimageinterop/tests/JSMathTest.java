package io.github.atur256.webimageinterop.tests;

import io.github.atur256.webimageinterop.builtin.JSMath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JSMathTest {

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
        assertEquals(2.718281828459045, JSMath.E(), 1e-15);
        assertEquals(0.6931471805599453, JSMath.LN2(), 1e-15);
        assertEquals(2.302585092994046, JSMath.LN10(), 1e-15);
        assertEquals(1.4426950408889634, JSMath.LOG2E(), 1e-15);
        assertEquals(0.4342944819032518, JSMath.LOG10E(), 1e-15);
        assertEquals(3.141592653589793, JSMath.PI(), 1e-15);
        assertEquals(0.7071067811865476, JSMath.SQRT1_2(), 1e-15);
        assertEquals(1.4142135623730951, JSMath.SQRT2(), 1e-15);
    }

    public static void testBasicArithmetic() {
        assertEquals(5.0, JSMath.abs(-5), 0);
        assertEquals(5.0, JSMath.abs(5), 0);
        assertEquals(5.0, JSMath.abs(-5.0), 0);
        assertEquals(5.0, JSMath.abs(5.0), 0);
        assertEquals(3.0, JSMath.ceil(2.1), 0);
        assertEquals(-2.0, JSMath.ceil(-2.1), 0);
        assertEquals(2.0, JSMath.floor(2.9), 0);
        assertEquals(-3.0, JSMath.floor(-2.9), 0);
        assertEquals(3.9000000953674316, JSMath.fround(3.9), 0);
        assertEquals(-3.9000000953674316, JSMath.fround(-3.9), 0);
        assertEquals(0.0, JSMath.fround(0.0), 0);
        assertEquals(3.0, JSMath.trunc(3.9), 0);
        assertEquals(-3.0, JSMath.trunc(-3.9), 0);
        assertEquals(6, JSMath.imul(2, 3));
        assertEquals(-6, JSMath.imul(-2, 3));
        assertEquals(6, JSMath.imul(-2, -3));
    }

    public static void testTrigonometric() {
        assertEquals(1.0, JSMath.cos(0), 1e-15);
        assertEquals(0.8414709848078965, JSMath.sin(1), 1e-15);
        assertEquals(1.5574077246549023, JSMath.tan(1), 1e-15);
        assertEquals(Math.atan2(1, 1), JSMath.atan2(1, 1), 1e-15);
        assertEquals(Math.atan(1), JSMath.atan(1), 1e-15);
        assertEquals(Math.acos(1), JSMath.acos(1), 1e-15);
        assertEquals(Math.asin(1), JSMath.asin(1), 1e-15);
    }

    public static void testHyperbolic() {
        assertEquals(1.0, JSMath.cosh(0), 1e-15);
        assertEquals(1.1752011936438014, JSMath.sinh(1), 1e-15);
        assertEquals(0.7615941559557649, JSMath.tanh(1), 1e-15);
        assertEquals(0.0, JSMath.acosh(1), 1e-15);
        assertEquals(0.881373587019543, JSMath.asinh(1), 1e-15);
        assertEquals(0.5493061443340548, JSMath.atanh(0.5), 1e-15);
    }

    public static void testLogarithmic() {
        assertEquals(Math.log(10), JSMath.log(10), 1e-15);
        assertEquals(Math.log1p(1), JSMath.log1p(1), 1e-15);
        assertEquals(3.0, JSMath.log2(8), 1e-15);
        assertEquals(Math.log10(100), JSMath.log10(100), 1e-15);
    }

    public static void testRoundingAndBitwise() {
        assertEquals(3.0, JSMath.round(2.6), 0);
        assertEquals(1.0, JSMath.sign(42), 0);
        assertEquals(-1.0, JSMath.sign(-42), 0);
        assertEquals(0.0, JSMath.sign(0), 0);
        assertEquals(31, JSMath.clz32(1));
    }

    public static void testPowerAndRoots() {
        assertEquals(8.0, JSMath.pow(2, 3), 0);
        assertEquals(4.0, JSMath.sqrt(16), 0);
        assertEquals(3.0, JSMath.cbrt(27), 1e-15);
        assertEquals(2.718281828459045, JSMath.exp(1), 1e-15);
        assertEquals(1.718281828459045, JSMath.expm1(1), 1e-15);
    }

    public static void testAggregation() {
        assertEquals(42.0, JSMath.max(1, 42, -5), 0);
        assertEquals(-5.0, JSMath.min(1, 42, -5), 0);
        assertEquals(5.0, JSMath.hypot(3, 4), 1e-15);
        assertEquals(0.0, JSMath.hypot(), 0);
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
        assertEquals(Double.NEGATIVE_INFINITY, JSMath.log(0), 0);
        assertEquals(Double.POSITIVE_INFINITY, JSMath.exp(1000), 0);
        assertTrue(Double.isNaN(JSMath.pow(Double.NaN, 2)));
        assertTrue(Double.isNaN(JSMath.pow(2, Double.NaN)));
    }
}
