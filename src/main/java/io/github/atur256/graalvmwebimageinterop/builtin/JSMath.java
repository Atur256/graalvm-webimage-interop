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

package io.github.atur256.graalvmwebimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


/**
 * Provides a Java binding for the JavaScript {@code Math} object within the WebImage interop layer.
 * This class exposes constants and functions for mathematical operations.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * double result = JSMath.pow(2, 8);  // 256.0
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Math")
public class JSMath extends JSObject {

    /**
     * Creates a new, empty {@link JSMath}.
     */
    protected JSMath() {
        super();
    }

    // === Constants ===

    /**
     * Euler's number (e ≈ 2.718).
     *
     * @return the value of Euler's number
     */
    @JS.Coerce
    @JS("return Math.E;")
    public static native double e();

    /**
     * Natural logarithm of 2 (ln(2)).
     *
     * @return the value of ln(2)
     */
    @JS.Coerce
    @JS("return Math.LN2;")
    public static native double ln2();

    /**
     * Natural logarithm of 10 (ln(10)).
     *
     * @return the value of ln(10)
     */
    @JS.Coerce
    @JS("return Math.LN10;")
    public static native double ln10();

    /**
     * Base-2 logarithm of e (log₂(e)).
     *
     * @return the value of log₂(e)
     */
    @JS.Coerce
    @JS("return Math.LOG2E;")
    public static native double log2E();

    /**
     * Base-10 logarithm of e (log₁₀(e)).
     *
     * @return the value of log₁₀(e)
     */
    @JS.Coerce
    @JS("return Math.LOG10E;")
    public static native double log10E();

    /**
     * The mathematical constant π (pi).
     *
     * @return the value of π
     */
    @JS.Coerce
    @JS("return Math.PI;")
    public static native double pi();

    /**
     * Square root of 1/2 (√0.5).
     *
     * @return the value of √0.5
     */
    @JS.Coerce
    @JS("return Math.SQRT1_2;")
    public static native double sqrt12();

    /**
     * Square root of 2 (√2).
     *
     * @return the value of √2
     */
    @JS.Coerce
    @JS("return Math.SQRT2;")
    public static native double sqrt2();


    // === Basic Arithmetic ===

    /**
     * Returns the absolute value of a number.
     *
     * @param x the input number
     * @return the absolute value of {@code x}
     */
    @JS.Coerce
    @JS("return Math.abs(x);")
    public static native double abs(double x);

    /**
     * Returns the smallest integer greater than or equal to a number.
     *
     * @param x the input number
     * @return the ceiling of {@code x}
     */
    @JS.Coerce
    @JS("return Math.ceil(x);")
    public static native double ceil(double x);

    /**
     * Returns the largest integer less than or equal to a number.
     *
     * @param x the input number
     * @return the floor of {@code x}
     */
    @JS.Coerce
    @JS("return Math.floor(x);")
    public static native double floor(double x);

    /**
     * Returns the value of a number rounded to the nearest integer.
     *
     * @param x the input number
     * @return the rounded value of {@code x}
     */
    @JS.Coerce
    @JS("return Math.round(x);")
    public static native double round(double x);

    /**
     * Returns the integer part of a number by removing any fractional digits.
     *
     * @param x the input number
     * @return the truncated value of {@code x}
     */
    @JS.Coerce
    @JS("return Math.trunc(x);")
    public static native double trunc(double x);

    /**
     * Returns the sign of a number, indicating whether the number is positive, negative, or zero.
     *
     * @param x the input number
     * @return {@code 1} if positive, {@code -1} if negative, {@code 0} if zero, or {@code NaN} if not a number
     */
    @JS.Coerce
    @JS("return Math.sign(x);")
    public static native double sign(double x);


    // === Powers and Roots ===

    /**
     * Returns the result of raising {@code base} to the power of {@code exponent}.
     *
     * @param base     the base number
     * @param exponent the exponent to raise the base to
     * @return {@code base} raised to the power of {@code exponent}
     */
    @JS.Coerce
    @JS("return Math.pow(base, exponent);")
    public static native double pow(double base, double exponent);

    /**
     * Returns the square root of a number.
     *
     * @param x the input number
     * @return the square root of {@code x}
     */
    @JS.Coerce
    @JS("return Math.sqrt(x);")
    public static native double sqrt(double x);

    /**
     * Returns the cube root of a number.
     *
     * @param x the input number
     * @return the cube root of {@code x}
     */
    @JS.Coerce
    @JS("return Math.cbrt(x);")
    public static native double cbrt(double x);


    // === Logarithmic Functions ===

    /**
     * Returns the natural logarithm (base e) of a number.
     *
     * @param x the input number
     * @return the natural logarithm of {@code x}
     */
    @JS.Coerce
    @JS("return Math.log(x);")
    public static native double log(double x);

    /**
     * Returns the natural logarithm of {@code 1 + x}.
     *
     * @param x the input number
     * @return the natural logarithm of {@code 1 + x}
     */
    @JS.Coerce
    @JS("return Math.log1p(x);")
    public static native double log1p(double x);

    /**
     * Returns the base-2 logarithm of a number.
     *
     * @param x the input number
     * @return the base-2 logarithm of {@code x}
     */
    @JS.Coerce
    @JS("return Math.log2(x);")
    public static native double log2(double x);

    /**
     * Returns the base-10 logarithm of a number.
     *
     * @param x the input number
     * @return the base-10 logarithm of {@code x}
     */
    @JS.Coerce
    @JS("return Math.log10(x);")
    public static native double log10(double x);


    // === Exponential Functions ===

    /**
     * Returns Euler's number (e) raised to the power of {@code x}.
     *
     * @param x the exponent
     * @return the value of {@code e^x}
     */
    @JS.Coerce
    @JS("return Math.exp(x);")
    public static native double exp(double x);

    /**
     * Returns {@code e^x - 1}, a more accurate result for small values of {@code x}.
     *
     * @param x the exponent
     * @return the value of {@code e^x - 1}
     */
    @JS.Coerce
    @JS("return Math.expm1(x);")
    public static native double expm1(double x);


    // === Trigonometric Functions ===

    /**
     * Returns the sine of an angle (in radians).
     *
     * @param x the angle in radians
     * @return the sine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.sin(x);")
    public static native double sin(double x);

    /**
     * Returns the cosine of an angle (in radians).
     *
     * @param x the angle in radians
     * @return the cosine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.cos(x);")
    public static native double cos(double x);

    /**
     * Returns the tangent of an angle (in radians).
     *
     * @param x the angle in radians
     * @return the tangent of {@code x}
     */
    @JS.Coerce
    @JS("return Math.tan(x);")
    public static native double tan(double x);

    /**
     * Returns the arcsine (inverse sine) of a number, in radians.
     *
     * @param x the input value
     * @return the arcsine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.asin(x);")
    public static native double asin(double x);

    /**
     * Returns the arccosine (inverse cosine) of a number, in radians.
     *
     * @param x the input value
     * @return the arccosine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.acos(x);")
    public static native double acos(double x);

    /**
     * Returns the arctangent (inverse tangent) of a number, in radians.
     *
     * @param x the input value
     * @return the arctangent of {@code x}
     */
    @JS.Coerce
    @JS("return Math.atan(x);")
    public static native double atan(double x);

    /**
     * Returns the arctangent of the quotient {@code y/x}, in radians.
     *
     * @param y the vertical component
     * @param x the horizontal component
     * @return the angle between the positive x-axis and the point {@code (x, y)}
     */
    @JS.Coerce
    @JS("return Math.atan2(y, x);")
    public static native double atan2(double y, double x);


    // === Hyperbolic Functions ===

    /**
     * Returns the hyperbolic sine of a number.
     *
     * @param x the input value
     * @return the hyperbolic sine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.sinh(x);")
    public static native double sinh(double x);

    /**
     * Returns the hyperbolic cosine of a number.
     *
     * @param x the input value
     * @return the hyperbolic cosine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.cosh(x);")
    public static native double cosh(double x);

    /**
     * Returns the hyperbolic tangent of a number.
     *
     * @param x the input value
     * @return the hyperbolic tangent of {@code x}
     */
    @JS.Coerce
    @JS("return Math.tanh(x);")
    public static native double tanh(double x);

    /**
     * Returns the inverse hyperbolic sine of a number.
     *
     * @param x the input value
     * @return the inverse hyperbolic sine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.asinh(x);")
    public static native double asinh(double x);

    /**
     * Returns the inverse hyperbolic cosine of a number.
     *
     * @param x the input value
     * @return the inverse hyperbolic cosine of {@code x}
     */
    @JS.Coerce
    @JS("return Math.acosh(x);")
    public static native double acosh(double x);

    /**
     * Returns the inverse hyperbolic tangent of a number.
     *
     * @param x the input value
     * @return the inverse hyperbolic tangent of {@code x}
     */
    @JS.Coerce
    @JS("return Math.atanh(x);")
    public static native double atanh(double x);


    // === Bitwise and Integer Math ===

    /**
     * Returns the number of leading zero bits in the 32-bit binary representation of a number.
     *
     * @param x the input integer
     * @return the count of leading zero bits
     */
    @JS.Coerce
    @JS("return Math.clz32(x);")
    public static native int clz32(int x);

    /**
     * Returns the result of a 32-bit integer multiplication.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the 32-bit integer product of {@code a} and {@code b}
     */
    @JS.Coerce
    @JS("return Math.imul(a, b);")
    public static native int imul(int a, int b);

    /**
     * Returns the nearest 32-bit single precision float representation of a number.
     *
     * @param x the input number
     * @return the 32-bit float approximation of {@code x}
     */
    @JS.Coerce
    @JS("return Math.fround(x);")
    public static native double fround(double x);


    // === Aggregates and Random ===

    /**
     * Returns the largest of the given numbers.
     *
     * @param args the input numbers
     * @return the maximum value among {@code args}
     */
    @JS.Coerce
    @JS("return Math.max(...args);")
    public static native double max(double... args);

    /**
     * Returns the smallest of the given numbers.
     *
     * @param args the input numbers
     * @return the minimum value among {@code args}
     */
    @JS.Coerce
    @JS("return Math.min(...args);")
    public static native double min(double... args);

    /**
     * Returns the square root of the sum of squares of the given numbers.
     *
     * @param args the input numbers
     * @return the Euclidean norm of {@code args}
     */
    @JS.Coerce
    @JS("return Math.hypot(...args);")
    public static native double hypot(double... args);

    /**
     * Returns a pseudo-random number between {@code 0} (inclusive) and {@code 1} (exclusive).
     *
     * @return a random double in the range [0, 1)
     */
    @JS.Coerce
    @JS("return Math.random();")
    public static native double random();
}
