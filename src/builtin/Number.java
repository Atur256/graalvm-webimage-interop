package builtin;

import org.graalvm.webimage.api.*;

@JS.Import("Number")
public class Number extends JSObject {

    // TODO: Add methods directly to JSNumber????

    @JS.Coerce
    @JS(value = "return isFinite(number)")
    public native static boolean isFinite(java.lang.Number number);

    @JS.Coerce
    @JS(value = "return isNaN(number)")
    public native static boolean isNaN(JSValue number);

    @JS.Coerce
    @JS(value = "return parseFloat(number)")
    public native static float parseFloat(java.lang.Number number);

    @JS.Coerce
    @JS(value = "return parseFloat(number)")
    public native static float parseFloat(java.lang.String number);

    @JS.Coerce
    @JS(value = "return parseInt(number)")
    public native static int parseInt(java.lang.Number number);

    // JSNumber instead of int as return value, because NaN is not defined for int
    @JS.Coerce
    @JS(value = "return parseInt(number)")
    public native static JSNumber parseInt(java.lang.String  number);

    @JS.Coerce
    @JS(value = "return parseInt(number, radix)")
    public native static int parseInt(java.lang.String  number, int radix);
}
