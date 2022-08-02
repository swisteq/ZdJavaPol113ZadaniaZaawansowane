package pl.sdacademy.java.advanced.exercises.day3.task28;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SkipArrayListTest {

    @Test
    void shouldReturnNewListOfStrings() {
        //given
        SkipArrayList<String> skipArrayList = new SkipArrayList<>();
        skipArrayList.addAll(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"));
        //when
        List<String> result = skipArrayList.getEveryNthElement(2, 3);
        //then
        assertThat(result).containsExactly("c", "g", "k");
    }

    @Test
    void shouldReturnNewListOfIntegers() {
        //given
        SkipArrayList<Integer> skipArrayList = new SkipArrayList<>();
        skipArrayList.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
        //when
        List<Integer> result = skipArrayList.getEveryNthElement(5, 2);
        //then
        assertThat(result).containsExactly(6, 9, 12);
    }

}