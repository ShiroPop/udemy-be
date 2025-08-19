package p0818;

import java.util.function.Function;

public class GenericBox <T>{
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public static <T> GenericBox<T> of(T value) {
        return new GenericBox<>(value);
    }

    public static <T> void swap(GenericBox<T> a, GenericBox<T> b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("swap 대상이 null일 수 없습니다.")
        }

        T temp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(temp);
    }

    public <R> GenericBox<R> map(Function<? super T, ? extends R> f) {
        if (value == null) {
            return new GenericBox<>(null);
        } else {
            return new GenericBox<>(f.apply(value));
        }
    }
}
