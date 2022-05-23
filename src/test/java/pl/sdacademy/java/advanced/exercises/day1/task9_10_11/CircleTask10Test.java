package pl.sdacademy.java.advanced.exercises.day1.task9_10_11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class CircleTask10Test {
    private Circle circle;

    @BeforeEach
    void init() {
        circle = new Circle(new Point2D(1, 2), new Point2D(3, 0));
        circle.move(new MoveDirection(-1, -2));
    }

    @Test
    void shouldReturnCorrectNewPoints() {
        assertThat(circle.getCenter()).isEqualTo(new Point2D(0, 0));
        assertThat(circle.getPoint()).isEqualTo(new Point2D(2, -2));
    }

    @Test
    void shouldReturnCorrectRadius() {
        //when
        double result = circle.getRadius();
        //then
        //assertThat(result).isEqualTo(2.82842712474619);
        assertThat(result).isCloseTo(2.82, within(0.01));
    }

    @Test
    void shouldReturnCorrectPerimeter() {
        //when
        double result = circle.getPerimeter();
        //then
        assertThat(result).isCloseTo(17.7, within(0.1));
    }

    @Test
    void shouldReturnCorrectArea() {
        //when
        double result = circle.getArea();
        //then
        assertThat(result).isCloseTo(25.1, within(0.1));
    }
}