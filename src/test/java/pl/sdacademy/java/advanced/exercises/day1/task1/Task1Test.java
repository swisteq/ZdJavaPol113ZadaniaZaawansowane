package pl.sdacademy.java.advanced.exercises.day1.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {
    private final static List<String> UNSORTED = List.of("A", "B", "Z", "C", "D");
    private final static List<String> SORTED = List.of("Z", "D", "C", "B", "A");

    @Test
    void shouldReverseListOfStrings_usingAnonymousClass() {
        //when
        List<String> result = Task1.sortUsingAnonymousClass(UNSORTED);
        //then
        assertThat(result).isEqualTo(SORTED);
    }

    @Test
    void shouldReverseListOfStrings_usingOwnComparator() {
        //when
        List<String> result = Task1.sortUsingOwnComparator(UNSORTED);
        //then
        assertThat(result).isEqualTo(SORTED);
    }

    @Test
    void shouldReverseListOfStrings_usingStream() {
        //when
        List<String> result = Task1.sortUsingStream(UNSORTED);
        //then
        assertThat(result).isEqualTo(SORTED);
    }

}