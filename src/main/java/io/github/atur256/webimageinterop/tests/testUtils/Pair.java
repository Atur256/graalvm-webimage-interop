package io.github.atur256.webimageinterop.tests.testUtils;

public record Pair<A, B>(A a, B b) {

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }
}