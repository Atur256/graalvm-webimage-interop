package io.github.atur256.webimageinterop.builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSValue;


/**
 * Provides a Java binding for the JavaScript {@code RegExp} object within the WebImage interop layer.
 * This class enables creation and execution of regular expressions.
 *
 * <p><b>Example Usage:</b></p>
 * <pre>{@code
 * JSRegExp regex = JSRegExp.of("\\d+", "g");
 * boolean matched = regex.test("123abc");
 * }</pre>
 *
 * @see JSObject
 */
@JS.Import("RegExp")
public class JSRegExp extends JSObject {

    // === Factory Method ===

    /**
     * Creates a new {@code RegExp} instance with the given pattern and flags.
     *
     * @param pattern the regular expression pattern
     * @param flags   the flags (e.g. "g", "i", "m")
     * @return a new {@code JSRegExp} instance
     */
    @JS.Coerce
    @JS("return new RegExp(pattern, flags);")
    public static native JSRegExp of(String pattern, String flags);


    // === Properties ===

    /**
     * The index at which to start the next match.
     */
    public int lastIndex;

    /**
     * Whether the {@code dotAll} flag is enabled.
     */
    public boolean dotAll;

    /**
     * The flags used in the regular expression.
     */
    public String flags;

    /**
     * Whether the {@code global} flag is enabled.
     */
    public boolean global;

    /**
     * Whether the {@code hasIndices} flag is enabled.
     */
    public boolean hasIndices;

    /**
     * Whether the {@code ignoreCase} flag is enabled.
     */
    public boolean ignoreCase;

    /**
     * Whether the {@code multiline} flag is enabled.
     */
    public boolean multiline;

    /**
     * The source pattern of the regular expression.
     */
    public String source;

    /**
     * Whether the {@code sticky} flag is enabled.
     */
    public boolean sticky;

    /**
     * Whether the {@code unicode} flag is enabled.
     */
    public boolean unicode;

    /**
     * Whether the {@code unicodeSets} flag is enabled.
     */
    public boolean unicodeSets;


    // === Methods ===

    /**
     * Executes the regular expression against the given string.
     *
     * @param string the input string to match
     * @return a {@link JSValue} containing the match result or {@code null}
     */
    @JS.Coerce
    @JS("return this.exec(string);")
    public native JSValue exec(String string);

    /**
     * Tests whether the regular expression matches the given string.
     *
     * @param string the input string to test
     * @return {@code true} if the pattern matches, {@code false} otherwise
     */
    @JS.Coerce
    @JS("return this.test(string);")
    public native boolean test(String string);


    // === ToString Methods ===

    /**
     * Returns the string representation of the regular expression.
     *
     * @return the string form of the regular expression
     */
    @JS.Coerce
    @JS("return this.toString();")
    private native String toStringJS();

    /**
     * Returns a formatted string representation of the JavaScript regular expression.
     *
     * @return a string describing the type and pattern
     */
    @Override
    public String toString() {
        return "JavaScript<" + typeof() + "; " + toStringJS() + ">";
    }
}
