package helpers;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyOptional<T> {

    private T value;

    private static MyOptional<?> EMPTY = new MyOptional<>();

    private MyOptional(T t) {
        this.value = t;
    }

    private MyOptional() {
        this.value = null;
    }

    public static  <T> MyOptional<T> of(T value) {
        value = Objects.requireNonNull(value);
        return new MyOptional(value);
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public static <T> MyOptional<T> empty() {
        return (MyOptional<T>) EMPTY;
    }

    public boolean isPresent() {
        return value != null;
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }

}
