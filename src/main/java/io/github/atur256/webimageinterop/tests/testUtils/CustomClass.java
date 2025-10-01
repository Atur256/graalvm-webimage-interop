package io.github.atur256.webimageinterop.tests.testUtils;

import org.jetbrains.annotations.NotNull;


public record CustomClass(String name) {

    @Override
    @NotNull
    public String toString() {
        return "CustomClass(" + name + ")";
    }
}
