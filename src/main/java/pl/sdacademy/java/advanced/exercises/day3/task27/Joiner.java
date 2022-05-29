package pl.sdacademy.java.advanced.exercises.day3.task27;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joiner<T> {
    private final String separator;

    public Joiner(String separator) {
        this.separator = separator;
    }

    public String join(T... parts) {
        //Stream.of(parts)
        return Arrays.stream(parts)
                //.map(t -> t.toString())
                .map(Object::toString)
                .collect(Collectors.joining(separator));
    }
}
