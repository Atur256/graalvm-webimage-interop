package builtin;

@FunctionalInterface
public interface JSSupplier<T> {
    T get();
}
