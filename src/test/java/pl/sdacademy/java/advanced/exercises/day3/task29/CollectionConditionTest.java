package pl.sdacademy.java.advanced.exercises.day3.task29;

import org.junit.jupiter.api.Test;
import pl.sdacademy.java.advanced.exercises.day3.task29.CollectionCondition;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionConditionTest {
    @Test
    void shouldCalculatePercentageFromListOfStrings() {
        //given
        CollectionCondition collectionCondition = new CollectionCondition();
        List<String> strings = List.of("java", "python", "scala", "c++", "c#");
        double expectedResult = 60.0;
        //when
        double result = collectionCondition.partOf(strings, str -> str.length() > 3);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldCalculatePercentageFromListOfIntegers() {
        //given
        CollectionCondition collectionCondition = new CollectionCondition();
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        double expectedResult = 80.0;
        //when
        double result = collectionCondition.partOf(integers, i -> i >= 3);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}