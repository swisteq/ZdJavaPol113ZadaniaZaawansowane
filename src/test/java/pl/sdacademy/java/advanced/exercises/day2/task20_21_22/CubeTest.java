package pl.sdacademy.java.advanced.exercises.day2.task20_21_22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void shouldVerifyFillMethod_LessThatMaxVolume() {
        //given
        Shape cube = new Cube(2);
        //when
        double result = ((Cube) cube).fill(5);
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void shouldVerifyFillMethod_EqualMaxVolume() {
        //given
        Shape cube = new Cube(2);
        //when
        double result = ((Cube) cube).fill(8);
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldVerifyFillMethod_MoreThatMaxVolume() {
        //given
        Shape cube = new Cube(2);
        //when
        double result = ((Cube) cube).fill(10);
        //then
        assertThat(result).isEqualTo(1);
    }

}