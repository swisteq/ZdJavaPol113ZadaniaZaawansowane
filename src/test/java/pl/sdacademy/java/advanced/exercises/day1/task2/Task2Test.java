package pl.sdacademy.java.advanced.exercises.day1.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {
    private final static List<String> UNSORTED = List.of("A", "B", "b", "Z", "d", "C");
    private final static List<String> EXPECTED_RESULT = List.of("Z", "d", "C", "B", "b", "A");

    @Test
    void shouldReverseListOfStringsIgnoringCaseSensitive() {
        //when
        List<String> result = Task2.sortIgnoreCaseSensitive(UNSORTED);
        //then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }
}