package pl.sdacademy.java.advanced.exercises.day2.task20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    void shouldCalculateVolume() {
        //given
        Shape cube = new Cube(2);
        //when
        double result = ((Cube) cube).calculateVolume();
        //then
        assertThat(result).isEqualTo(8);
    }

    @Test
    void shouldCalculatePerimeter() {
        //given
        Shape cube = new Cube(2);
        //when
        double result = ((Cube) cube).calculatePerimeter();
        //then
        assertThat(result).isEqualTo(24);
    }

}