package pl.sdacademy.java.advanced.exercises.day3.task27;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JoinerTest {

    @Test
    void shouldReturnCorrectStringFromStrings() {
        //given
        Joiner<String> joiner = new Joiner<>("+");
        String expectedResult = "a+b+c+d";
        //when
        String result = joiner.join("a", "b", "c", "d");
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnCorrectStringFromIntegers() {
        //given
        Joiner<Integer> joiner = new Joiner<>("|");
        String expectedResult = "2|5|7|9";
        //when
        String result = joiner.join(2, 5, 7, 9);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnCorrectStringFromFloats() {
        //given
        Joiner<Float> joiner = new Joiner<>("-");
        String expectedResult = "2.0-5.0";
        //when
        String result = joiner.join(2.0f, 5.0f);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

}