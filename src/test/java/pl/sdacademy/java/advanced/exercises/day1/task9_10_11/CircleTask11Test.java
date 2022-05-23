package pl.sdacademy.java.advanced.exercises.day1.task9_10_11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class CircleTask11Test {
    private Circle circle;

    @BeforeEach
    void setUp() {
        Point2D center = new Point2D(0, 0);
        Point2D point = new Point2D(3, 0);
        circle = new Circle(center, point);
        circle.resize(3);
    }

    @Test
    void shouldReturnCorrectNewPositionForPointAndCenter() {
        // given
        Point2D expectedNewCenter = new Point2D(0, 0);
        Point2D expectedNewPoint = new Point2D(9, 0);
        // when
        Point2D point = circle.getPoint();
        Point2D center = circle.getCenter();
        // then
        assertThat(point).isEqualTo(expectedNewPoint);
        assertThat(center).isEqualTo(expectedNewCenter);
    }

    @Test
    void shouldReturnCorrectRadius() {
        //when
        double result = circle.getRadius();
        //then
        assertThat(result).isCloseTo(9, within(0.01D));
    }

    @Test
    void shouldReturnCorrectPerimeter() {
        //when
        double result = circle.getPerimeter();
        //then
        assertThat(result).isCloseTo(56.54, within(0.01D));
    }

    @Test
    void shouldReturnCorrectArea() {
        //when
        double result = circle.getArea();
        //then
        assertThat(result).isCloseTo(254.46, within(0.01D));
    }
}