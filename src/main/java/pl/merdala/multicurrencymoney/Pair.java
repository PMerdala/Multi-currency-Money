package pl.merdala.multicurrencymoney;

import java.util.Objects;

class Pair<T> {
    private final T from;
    private final T to;

    public Pair(T from, T to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
    }

    @Override
    public String toString() {
        return "Pair<" +
                "" + from +
                "," + to +
                '>';
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

}
