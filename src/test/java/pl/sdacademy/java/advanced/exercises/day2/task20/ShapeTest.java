package pl.sdacademy.java.advanced.exercises.day2.task20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void shouldCalculatePerimeterForRectangle() {
        //given
        Shape rectangle = new Rectangle(2, 4);
        //when
        double result = rectangle.calculatePerimeter();
        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void shouldCalculatePerimeterForTriangle() {
        //given
        Shape triangle = new Triangle(2, 4, 5);
        //when
        double result = triangle.calculatePerimeter();
        //then
        assertThat(result).isEqualTo(11);
    }

    @Test
    void shouldCalculatePerimeterForHexagon() {
        //given
        Shape hexagon = new Hexagon(2);
        //when
        double result = hexagon.calculatePerimeter();
        //then
        assertThat(result).isEqualTo(12);
    }

}