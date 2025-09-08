package builtin;

@FunctionalInterface
public interface JSConsumer<T> {

    void accept(T arg);
}

