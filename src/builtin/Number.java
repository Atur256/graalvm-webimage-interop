package builtin;

import org.graalvm.webimage.api.*;


public class Number {

    @JS.Coerce
    @JS(value = "return isFinite(number)")
    public native static Boolean isFinite(java.lang.Number number);

    @JS(value = "return isNaN(number)")
    public native static JSBoolean isNaN(JSValue number);

    @JS.Coerce
    @JS(value = "return parseFloat(number)")
    public native static float parseFloat(java.lang.Number number);

    @JS.Coerce
    @JS(value = "return parseFloat(number)")
    public native static float parseFloat(String number);

    @JS.Coerce
    @JS(value = "return parseInt(number)")
    public native static int parseInt(java.lang.Number number);

    // JSNumber instead of int as return value, because NaN is not defined for int
    @JS.Coerce
    @JS(value = "return parseInt(number)")
    public native static JSNumber parseInt(String number);

    @JS.Coerce
    @JS(value = "return parseInt(number, radix)")
    public native static int parseInt(String number, int radix);
}
