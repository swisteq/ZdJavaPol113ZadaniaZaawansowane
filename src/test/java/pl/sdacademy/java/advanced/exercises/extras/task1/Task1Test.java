package pl.sdacademy.java.advanced.exercises.extras.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {
    private Task1 task1 = new Task1();

    @Test
    void shouldReturnCorrectList() {
        // given
        List<String> input = List.of("cela", "cep", "ala", "Cal", "domek", "car");
        List<String> expectedResult = List.of("cep", "car");
        // when
        List<String> result = task1.search(input);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnEmptyList() {
        // given
        List<String> input = List.of("cela", "ala", "Cal", "domek");
        // when
        List<String> result = task1.search(input);
        // then
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void shouldReturnCorrectStringWithCommaSeparated() {
        // given
        List<Integer> input = List.of(5, 20, 1, 55, 50);
        // when
        String result = task1.getString(input);
        // then
        assertThat(result).isEqualTo("o5,e20,o1,o55,e50");
    }

}