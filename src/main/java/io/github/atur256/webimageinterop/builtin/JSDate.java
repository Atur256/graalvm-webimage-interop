package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;

import java.lang.String;


@JS.Import("Date")
public class JSDate extends JSObject {

    @JS.Coerce
    @JS(value = "return new Date();")
    public static native JSDate create(); // TODO: don't test it

    @JS.Coerce
    @JS(value = "return new Date(value);")
    public static native JSDate create(double value); // TODO: use long and convert BigInt to Number

    @JS.Coerce
    @JS(value = "return new Date(dateString);")
    public static native JSDate create(String dateString);

    @JS.Coerce
    @JS(value = "return new Date(dateObject);")
    public static native JSDate create(JSDate dateObject);

    @JS.Coerce
    @JS(value = "return new Date(year, month);")
    public static native JSDate create(int year, int month);

    @JS.Coerce
    @JS(value = "return new Date(year, month, day);")
    public static native JSDate create(int year, int month, int day);

    @JS.Coerce
    @JS(value = "return new Date(year, month, day, hours);")
    public static native JSDate create(int year, int month, int day, int hours);

    @JS.Coerce
    @JS(value = "return new Date(year, month, day, hours, minutes);")
    public static native JSDate create(int year, int month, int day, int hours, int minutes);

    @JS.Coerce
    @JS(value = "return new Date(year, month, day, hours, minutes, seconds);")
    public static native JSDate create(int year, int month, int day, int hours, int minutes, int seconds);

    @JS.Coerce
    @JS(value = "return new Date(year, month, day, hours, minutes, seconds, milliseconds);")
    public static native JSDate create(int year, int month, int day, int hours, int minutes, int seconds, int milliseconds);

    @JS.Coerce
    @JS(value = "return Date.now();")
    public static native long now(); // TODO: don't test it

    @JS.Coerce
    @JS(value = "return Date.parse(dateString);")
    public static native long parse(String dateString);

    @JS.Coerce
    @JS(value = "return Date.UTC(year);")
    public static native long UTC(int year);

    @JS.Coerce
    @JS(value = "return Date.UTC(year, month);")
    public static native long UTC(int year, int month);

    @JS.Coerce
    @JS(value = "return Date.UTC(year, month, day);")
    public static native long UTC(int year, int month, int day);

    @JS.Coerce
    @JS(value = "return Date.UTC(year, month, day, hours);")
    public static native long UTC(int year, int month, int day, int hours);

    @JS.Coerce
    @JS(value = "return Date.UTC(year, month, day, hours, minutes);")
    public static native long UTC(int year, int month, int day, int hours, int minutes);

    @JS.Coerce
    @JS(value = "return Date.UTC(year, month, day, hours, minutes, seconds);")
    public static native long UTC(int year, int month, int day, int hours, int minutes, int seconds);

    @JS.Coerce
    @JS(value = "return Date.UTC(year, month, day, hours, minutes, seconds, ms);")
    public static native long UTC(int year, int month, int day, int hours, int minutes, int seconds, int ms);

    @JS.Coerce
    @JS(value = "return this.getDate();")
    public native int getDate();

    @JS.Coerce
    @JS(value = "return this.getDay();")
    public native int getDay();

    @JS.Coerce
    @JS(value = "return this.getFullYear();")
    public native int getFullYear();

    @JS.Coerce
    @JS(value = "return this.getHours();")
    public native int getHours();

    @JS.Coerce
    @JS(value = "return this.getMilliseconds();")
    public native int getMilliseconds();

    @JS.Coerce
    @JS(value = "return this.getMinutes();")
    public native int getMinutes();

    @JS.Coerce
    @JS(value = "return this.getMonth();")
    public native int getMonth();

    @JS.Coerce
    @JS(value = "return this.getSeconds();")
    public native int getSeconds();

    @JS.Coerce
    @JS(value = "return this.getTime();")
    public native long getTime();

    @JS.Coerce
    @JS(value = "return this.getTimezoneOffset();")
    public native int getTimezoneOffset();

    @JS.Coerce
    @JS(value = "return this.getUTCDate();")
    public native int getUTCDate();

    @JS.Coerce
    @JS(value = "return this.getUTCDay();")
    public native int getUTCDay();

    @JS.Coerce
    @JS(value = "return this.getUTCFullYear();")
    public native int getUTCFullYear();

    @JS.Coerce
    @JS(value = "return this.getUTCHours();")
    public native int getUTCHours();

    @JS.Coerce
    @JS(value = "return this.getUTCMilliseconds();")
    public native int getUTCMilliseconds();

    @JS.Coerce
    @JS(value = "return this.getUTCMinutes();")
    public native int getUTCMinutes();

    @JS.Coerce
    @JS(value = "return this.getUTCMonth();")
    public native int getUTCMonth();

    @JS.Coerce
    @JS(value = "return this.getUTCSeconds();")
    public native int getUTCSeconds();

    @JS.Coerce
    @JS(value = "return this.setDate(date);")
    public native void setDate(int date);

    @JS.Coerce
    @JS(value = "return this.setFullYear(year);")
    public native void setFullYear(int year);

    @JS.Coerce
    @JS(value = "return this.setHours(hours);")
    public native void setHours(int hours);

    @JS.Coerce
    @JS(value = "return this.setMilliseconds(ms);")
    public native void setMilliseconds(int ms);

    @JS.Coerce
    @JS(value = "return this.setMinutes(minutes);")
    public native void setMinutes(int minutes);

    @JS.Coerce
    @JS(value = "return this.setMonth(month);")
    public native void setMonth(int month);

    @JS.Coerce
    @JS(value = "return this.setSeconds(seconds);")
    public native void setSeconds(int seconds);

    @JS.Coerce
    @JS(value = "return this.setTime(time);")
    public native void setTime(double time);

    @JS.Coerce
    @JS(value = "return this.setUTCDate(date);")
    public native void setUTCDate(int date);

    @JS.Coerce
    @JS(value = "return this.setUTCFullYear(year);")
    public native void setUTCFullYear(int year);

    @JS.Coerce
    @JS(value = "return this.setUTCHours(hours);")
    public native void setUTCHours(int hours);

    @JS.Coerce
    @JS(value = "return this.setUTCMilliseconds(ms);")
    public native void setUTCMilliseconds(int ms);

    @JS.Coerce
    @JS(value = "return this.setUTCMinutes(minutes);")
    public native void setUTCMinutes(int minutes);

    @JS.Coerce
    @JS(value = "return this.setUTCMonth(month);")
    public native void setUTCMonth(int month);

    @JS.Coerce
    @JS(value = "return this.setUTCSeconds(seconds);")
    public native void setUTCSeconds(int seconds);

    @JS.Coerce
    @JS(value = "return this.toDateString();")
    public native String toDateString();

    @JS.Coerce
    @JS(value = "return this.toISOString();")
    public native String toISOString();

    @JS.Coerce
    @JS(value = "return this.toJSON();")
    public native String toJSON();

    @JS.Coerce
    @JS(value = "return this.toLocaleDateString();")
    public native String toLocaleDateString();

    @JS.Coerce
    @JS(value = "return this.toLocaleString();")
    public native String toLocaleString();

    @JS.Coerce
    @JS(value = "return this.toLocaleTimeString();")
    public native String toLocaleTimeString();

    @JS.Coerce
    @JS(value = "return this.toString();")
    private native String toStringJS();

    public String toString() {
        return "JavaScript<" + typeof() + "; " + toStringJS() + ">";
    }

    @JS.Coerce
    @JS(value = "return this.toTimeString();")
    public native String toTimeString();

    @JS.Coerce
    @JS(value = "return this.toUTCString();")
    public native String toUTCString();
}