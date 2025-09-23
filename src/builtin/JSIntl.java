package builtin;

import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;


@JS.Import("Intl")
public class JSIntl extends JSObject {

    @JS.Coerce
    @JS(value = """
    const args = [];
            for (let i = 0; i < locales.length; i++) {
                args.push(locales[i]);
            }
    return Intl.getCanonicalLocales(args);""")
    public static native JSArray getCanonicalLocales(String... locales);

    @JS.Coerce
    @JS(value = "return Intl.supportedValuesOf(key);")
    public static native JSArray supportedValuesOf(String key);
}
