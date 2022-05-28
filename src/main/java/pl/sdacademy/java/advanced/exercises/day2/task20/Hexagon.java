package pl.sdacademy.java.advanced.exercises.day2.task20;

public class Hexagon extends Shape{
    private final int a;

    public Hexagon(int a) {
        this.a = a;
    }

    @Override
    double calculatePerimeter() {
        return 6 * a;
    }
}
