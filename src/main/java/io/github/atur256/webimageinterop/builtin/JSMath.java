package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


@JS.Import("Math")
public class JSMath extends JSObject {

    @JS.Coerce
    @JS(value = "return Math.E;")
    public static native double e();

    @JS.Coerce
    @JS(value = "return Math.LN2;")
    public static native double ln2();

    @JS.Coerce
    @JS(value = "return Math.LN10;")
    public static native double ln10();

    @JS.Coerce
    @JS(value = "return Math.LOG2E;")
    public static native double log2E();

    @JS.Coerce
    @JS(value = "return Math.LOG10E;")
    public static native double log10E();

    @JS.Coerce
    @JS(value = "return Math.PI;")
    public static native double pi();

    @JS.Coerce
    @JS(value = "return Math.SQRT1_2;")
    public static native double sqrt12();

    @JS.Coerce
    @JS(value = "return Math.SQRT2;")
    public static native double sqrt2();

    @JS.Coerce
    @JS(value = "return Math.abs(x);")
    public static native double abs(double x);

    @JS.Coerce
    @JS(value = "return Math.acos(x);")
    public static native double acos(double x);

    @JS.Coerce
    @JS(value = "return Math.acosh(x);")
    public static native double acosh(double x);

    @JS.Coerce
    @JS(value = "return Math.asin(x);")
    public static native double asin(double x);

    @JS.Coerce
    @JS(value = "return Math.asinh(x);")
    public static native double asinh(double x);

    @JS.Coerce
    @JS(value = "return Math.atan(x);")
    public static native double atan(double x);

    @JS.Coerce
    @JS(value = "return Math.atan2(y, x);")
    public static native double atan2(double y, double x);

    @JS.Coerce
    @JS(value = "return Math.atanh(x);")
    public static native double atanh(double x);

    @JS.Coerce
    @JS(value = "return Math.cbrt(x);")
    public static native double cbrt(double x);

    @JS.Coerce
    @JS(value = "return Math.ceil(x);")
    public static native double ceil(double x);

    @JS.Coerce
    @JS(value = "return Math.clz32(x);")
    public static native int clz32(int x);

    @JS.Coerce
    @JS(value = "return Math.cos(x);")
    public static native double cos(double x);

    @JS.Coerce
    @JS(value = "return Math.cosh(x);")
    public static native double cosh(double x);

    @JS.Coerce
    @JS(value = "return Math.exp(x);")
    public static native double exp(double x);

    @JS.Coerce
    @JS(value = "return Math.expm1(x);")
    public static native double expm1(double x);

    @JS.Coerce
    @JS(value = "return Math.floor(x);")
    public static native double floor(double x);

    @JS.Coerce
    @JS(value = "return Math.fround(x);")
    public static native double fround(double x);

    @JS.Coerce
    @JS(value = "return Math.hypot(...args);")
    public static native double hypot(double... args);

    @JS.Coerce
    @JS(value = "return Math.imul(a, b);")
    public static native int imul(int a, int b);

    @JS.Coerce
    @JS(value = "return Math.log(x);")
    public static native double log(double x);

    @JS.Coerce
    @JS(value = "return Math.log1p(x);")
    public static native double log1p(double x);

    @JS.Coerce
    @JS(value = "return Math.log2(x);")
    public static native double log2(double x);

    @JS.Coerce
    @JS(value = "return Math.log10(x);")
    public static native double log10(double x);

    @JS.Coerce
    @JS(value = "return Math.max(...args);")
    public static native double max(double... args);

    @JS.Coerce
    @JS(value = "return Math.min(...args);")
    public static native double min(double... args);

    @JS.Coerce
    @JS(value = "return Math.pow(base, exponent);")
    public static native double pow(double base, double exponent);

    @JS.Coerce
    @JS(value = "return Math.random();")
    public static native double random();

    @JS.Coerce
    @JS(value = "return Math.round(x);")
    public static native double round(double x);

    @JS.Coerce
    @JS(value = "return Math.sign(x);")
    public static native double sign(double x);

    @JS.Coerce
    @JS(value = "return Math.sin(x);")
    public static native double sin(double x);

    @JS.Coerce
    @JS(value = "return Math.sinh(x);")
    public static native double sinh(double x);

    @JS.Coerce
    @JS(value = "return Math.sqrt(x);")
    public static native double sqrt(double x);

    @JS.Coerce
    @JS(value = "return Math.tan(x);")
    public static native double tan(double x);

    @JS.Coerce
    @JS(value = "return Math.tanh(x);")
    public static native double tanh(double x);

    @JS.Coerce
    @JS(value = "return Math.trunc(x);")
    public static native double trunc(double x);
}
