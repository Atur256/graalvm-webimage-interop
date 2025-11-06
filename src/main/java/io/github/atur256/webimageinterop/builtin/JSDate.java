package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;

import java.lang.String;


/**
 * Provides a Java binding for the JavaScript {@code Date} object within the WebImage interop layer.
 * This class enables native interop between Java and JavaScript date operations.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSDate now = JSDate.create();
 * int year = now.getFullYear();
 * now.setMonth(11); // December
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("Date")
public class JSDate extends JSObject {

    // === Factory Methods ===

    /**
     * Creates a new {@code JSDate} representing the current time.
     *
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date();")
    public static native JSDate create();

    /**
     * Creates a {@code JSDate} from a timestamp.
     *
     * @param value milliseconds since epoch
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(Number(value));")
    public static native JSDate create(long value);

    /**
     * Creates a {@code JSDate} from a date string.
     *
     * @param dateString a valid date string
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(dateString);")
    public static native JSDate create(String dateString);

    /**
     * Creates a copy of an existing {@code JSDate}.
     *
     * @param dateObject the date to copy
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(dateObject);")
    public static native JSDate create(JSDate dateObject);

    /**
     * Creates a {@code JSDate} with year and month.
     *
     * @param year  the year
     * @param month the month (0–11)
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(year, month);")
    public static native JSDate create(int year, int month);

    /**
     * Creates a {@code JSDate} with year, month, and day.
     *
     * @param year  the year
     * @param month the month (0–11)
     * @param day   the day of the month
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(year, month, day);")
    public static native JSDate create(int year, int month, int day);

    /**
     * Creates a {@code JSDate} with year, month, day, and hours.
     *
     * @param year  the year
     * @param month the month (0–11)
     * @param day   the day of the month
     * @param hours the hour (0–23)
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(year, month, day, hours);")
    public static native JSDate create(int year, int month, int day, int hours);

    /**
     * Creates a {@code JSDate} with year, month, day, hours, and minutes.
     *
     * @param year    the year
     * @param month   the month (0–11)
     * @param day     the day of the month
     * @param hours   the hour (0–23)
     * @param minutes the minute (0–59)
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(year, month, day, hours, minutes);")
    public static native JSDate create(int year, int month, int day, int hours, int minutes);

    /**
     * Creates a {@code JSDate} with year, month, day, hours, minutes, and seconds.
     *
     * @param year    the year
     * @param month   the month (0–11)
     * @param day     the day of the month
     * @param hours   the hour (0–23)
     * @param minutes the minute (0–59)
     * @param seconds the second (0–59)
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(year, month, day, hours, minutes, seconds);")
    public static native JSDate create(int year, int month, int day, int hours, int minutes, int seconds);

    /**
     * Creates a {@code JSDate} with full date and time components.
     *
     * @param year         the year
     * @param month        the month (0–11)
     * @param day          the day of the month
     * @param hours        the hour (0–23)
     * @param minutes      the minute (0–59)
     * @param seconds      the second (0–59)
     * @param milliseconds the millisecond (0–999)
     * @return a new {@code JSDate}
     */
    @JS.Coerce
    @JS("return new Date(year, month, day, hours, minutes, seconds, milliseconds);")
    public static native JSDate create(int year, int month, int day, int hours, int minutes, int seconds, int milliseconds);


    // === Static Utility Methods ===

    /**
     * Returns the current timestamp in milliseconds since the Unix epoch.
     *
     * @return the current time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.now();")
    public static native long now();

    /**
     * Parses a date string and returns the corresponding timestamp.
     *
     * @param dateString a valid date string
     * @return the time in milliseconds since the Unix epoch
     */
    @JS.Coerce
    @JS("return Date.parse(dateString);")
    public static native long parse(String dateString);

    /**
     * Returns the UTC timestamp for the specified year.
     *
     * @param year the year
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year);")
    public static native long UTC(int year);

    /**
     * Returns the UTC timestamp for the specified year and month.
     *
     * @param year  the year
     * @param month the month (0–11)
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year, month);")
    public static native long UTC(int year, int month);

    /**
     * Returns the UTC timestamp for the specified date.
     *
     * @param year  the year
     * @param month the month (0–11)
     * @param day   the day of the month
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year, month, day);")
    public static native long UTC(int year, int month, int day);

    /**
     * Returns the UTC timestamp for the specified date and hour.
     *
     * @param year  the year
     * @param month the month (0–11)
     * @param day   the day of the month
     * @param hours the hour (0–23)
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year, month, day, hours);")
    public static native long UTC(int year, int month, int day, int hours);

    /**
     * Returns the UTC timestamp for the specified date and time.
     *
     * @param year    the year
     * @param month   the month (0–11)
     * @param day     the day of the month
     * @param hours   the hour (0–23)
     * @param minutes the minute (0–59)
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year, month, day, hours, minutes);")
    public static native long UTC(int year, int month, int day, int hours, int minutes);

    /**
     * Returns the UTC timestamp for the specified date and time.
     *
     * @param year    the year
     * @param month   the month (0–11)
     * @param day     the day of the month
     * @param hours   the hour (0–23)
     * @param minutes the minute (0–59)
     * @param seconds the second (0–59)
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year, month, day, hours, minutes, seconds);")
    public static native long UTC(int year, int month, int day, int hours, int minutes, int seconds);

    /**
     * Returns the UTC timestamp for the specified date and time.
     *
     * @param year    the year
     * @param month   the month (0–11)
     * @param day     the day of the month
     * @param hours   the hour (0–23)
     * @param minutes the minute (0–59)
     * @param seconds the second (0–59)
     * @param ms      the millisecond (0–999)
     * @return the UTC time in milliseconds
     */
    @JS.Coerce
    @JS("return Date.UTC(year, month, day, hours, minutes, seconds, ms);")
    public static native long UTC(int year, int month, int day, int hours, int minutes, int seconds, int ms);


    // === Getters (Local Time) ===

    /**
     * Returns the day of the month (1–31) in local time.
     *
     * @return the day of the month
     */
    @JS.Coerce
    @JS("return this.getDate();")
    public native int getDate();

    /**
     * Returns the day of the week (0–6) in local time.
     * Sunday is 0, Monday is 1, and so on.
     *
     * @return the day of the week
     */
    @JS.Coerce
    @JS("return this.getDay();")
    public native int getDay();

    /**
     * Returns the full year in local time.
     *
     * @return the year
     */
    @JS.Coerce
    @JS("return this.getFullYear();")
    public native int getFullYear();

    /**
     * Returns the hour (0–23) in local time.
     *
     * @return the hour
     */
    @JS.Coerce
    @JS("return this.getHours();")
    public native int getHours();

    /**
     * Returns the milliseconds (0–999) in local time.
     *
     * @return the milliseconds
     */
    @JS.Coerce
    @JS("return this.getMilliseconds();")
    public native int getMilliseconds();

    /**
     * Returns the minutes (0–59) in local time.
     *
     * @return the minutes
     */
    @JS.Coerce
    @JS("return this.getMinutes();")
    public native int getMinutes();

    /**
     * Returns the month (0–11) in local time.
     * January is 0, December is 11.
     *
     * @return the month
     */
    @JS.Coerce
    @JS("return this.getMonth();")
    public native int getMonth();

    /**
     * Returns the seconds (0–59) in local time.
     *
     * @return the seconds
     */
    @JS.Coerce
    @JS("return this.getSeconds();")
    public native int getSeconds();

    /**
     * Returns the timestamp in milliseconds since the Unix epoch.
     *
     * @return the time in milliseconds
     */
    @JS.Coerce
    @JS("return this.getTime();")
    public native long getTime();

    /**
     * Returns the timezone offset in minutes from UTC.
     * Positive values are west of UTC, negative are east.
     *
     * @return the timezone offset
     */
    @JS.Coerce
    @JS("return this.getTimezoneOffset();")
    public native int getTimezoneOffset();


    // === Getters (UTC Time) ===

    /**
     * Returns the day of the month (1–31) in UTC time.
     *
     * @return the UTC day of the month
     */
    @JS.Coerce
    @JS("return this.getUTCDate();")
    public native int getUTCDate();

    /**
     * Returns the day of the week (0–6) in UTC time.
     * Sunday is 0, Monday is 1, and so on.
     *
     * @return the UTC day of the week
     */
    @JS.Coerce
    @JS("return this.getUTCDay();")
    public native int getUTCDay();

    /**
     * Returns the full year in UTC time.
     *
     * @return the UTC year
     */
    @JS.Coerce
    @JS("return this.getUTCFullYear();")
    public native int getUTCFullYear();

    /**
     * Returns the hour (0–23) in UTC time.
     *
     * @return the UTC hour
     */
    @JS.Coerce
    @JS("return this.getUTCHours();")
    public native int getUTCHours();

    /**
     * Returns the milliseconds (0–999) in UTC time.
     *
     * @return the UTC milliseconds
     */
    @JS.Coerce
    @JS("return this.getUTCMilliseconds();")
    public native int getUTCMilliseconds();

    /**
     * Returns the minutes (0–59) in UTC time.
     *
     * @return the UTC minutes
     */
    @JS.Coerce
    @JS("return this.getUTCMinutes();")
    public native int getUTCMinutes();

    /**
     * Returns the month (0–11) in UTC time.
     * January is 0, December is 11.
     *
     * @return the UTC month
     */
    @JS.Coerce
    @JS("return this.getUTCMonth();")
    public native int getUTCMonth();

    /**
     * Returns the seconds (0–59) in UTC time.
     *
     * @return the UTC seconds
     */
    @JS.Coerce
    @JS("return this.getUTCSeconds();")
    public native int getUTCSeconds();


    // === Setters (Local Time) ===

    @JS.Coerce
    @JS("return this.setDate(date);")
    public native void setDate(int date);

    @JS.Coerce
    @JS("return this.setFullYear(year);")
    public native void setFullYear(int year);

    @JS.Coerce
    @JS("return this.setHours(hours);")
    public native void setHours(int hours);

    @JS.Coerce
    @JS("return this.setMilliseconds(ms);")
    public native void setMilliseconds(int ms);

    @JS.Coerce
    @JS("return this.setMinutes(minutes);")
    public native void setMinutes(int minutes);

    @JS.Coerce
    @JS("return this.setMonth(month);")
    public native void setMonth(int month);

    @JS.Coerce
    @JS("return this.setSeconds(seconds);")
    public native void setSeconds(int seconds);

    @JS.Coerce
    @JS("return this.setTime(Number(time));")
    public native void setTime(long time);


    // === Setters (UTC Time) ===

    /**
     * Sets the day of the month in local time.
     *
     * @param date the day of the month (1–31)
     */
    @JS.Coerce
    @JS("return this.setUTCDate(date);")
    public native void setUTCDate(int date);

    /**
     * Sets the full year in local time.
     *
     * @param year the year to set
     */
    @JS.Coerce
    @JS("return this.setUTCFullYear(year);")
    public native void setUTCFullYear(int year);

    /**
     * Sets the hour in local time.
     *
     * @param hours the hour (0–23)
     */
    @JS.Coerce
    @JS("return this.setUTCHours(hours);")
    public native void setUTCHours(int hours);

    /**
     * Sets the milliseconds in local time.
     *
     * @param ms the milliseconds (0–999)
     */
    @JS.Coerce
    @JS("return this.setUTCMilliseconds(ms);")
    public native void setUTCMilliseconds(int ms);

    /**
     * Sets the minutes in local time.
     *
     * @param minutes the minutes (0–59)
     */
    @JS.Coerce
    @JS("return this.setUTCMinutes(minutes);")
    public native void setUTCMinutes(int minutes);

    /**
     * Sets the month in local time.
     *
     * @param month the month (0–11)
     */
    @JS.Coerce
    @JS("return this.setUTCMonth(month);")
    public native void setUTCMonth(int month);

    /**
     * Sets the seconds in local time.
     *
     * @param seconds the seconds (0–59)
     */
    @JS.Coerce
    @JS("return this.setUTCSeconds(seconds);")
    public native void setUTCSeconds(int seconds);


    // === String Conversion ===

    /**
     * Returns a human-readable date string (e.g., "Thu Nov 06 2025").
     *
     * @return the local date string
     */
    @JS.Coerce
    @JS("return this.toDateString();")
    public native String toDateString();

    /**
     * Returns the date in ISO 8601 format (e.g., "2025-11-06T12:36:31.763Z").
     *
     * @return the ISO string
     */
    @JS.Coerce
    @JS("return this.toISOString();")
    public native String toISOString();

    /**
     * Returns a JSON-compatible string representation of the date.
     *
     * @return the JSON string
     */
    @JS.Coerce
    @JS("return this.toJSON();")
    public native String toJSON();

    /**
     * Returns a locale-sensitive date string.
     *
     * @return the localized date string
     */
    @JS.Coerce
    @JS("return this.toLocaleDateString();")
    public native String toLocaleDateString();

    /**
     * Returns a locale-sensitive date and time string.
     *
     * @return the localized date-time string
     */
    @JS.Coerce
    @JS("return this.toLocaleString();")
    public native String toLocaleString();

    /**
     * Returns a locale-sensitive time string.
     *
     * @return the localized time string
     */
    @JS.Coerce
    @JS("return this.toLocaleTimeString();")
    public native String toLocaleTimeString();

    /**
     * Returns the internal JavaScript string representation of the date.
     *
     * @return the raw JavaScript string
     */
    @JS.Coerce
    @JS("return this.toString();")
    private native String toStringJS();

    /**
     * Returns a formatted string representation of the date.
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return "JavaScript<" + typeof() + "; " + toStringJS() + ">";
    }

    /**
     * Returns the time portion of the date as a string.
     *
     * @return the time string
     */
    @JS.Coerce
    @JS("return this.toTimeString();")
    public native String toTimeString();

    /**
     * Returns the date as a UTC string.
     *
     * @return the UTC string
     */
    @JS.Coerce
    @JS("return this.toUTCString();")
    public native String toUTCString();
}