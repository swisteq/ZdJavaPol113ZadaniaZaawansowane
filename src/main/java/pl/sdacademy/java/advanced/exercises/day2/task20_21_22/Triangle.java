package pl.sdacademy.java.advanced.exercises.day2.task20_21_22;

public class Triangle extends Shape{
    private final int a;
    private final int b;
    private final int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double calculatePerimeter() {
        return a + b + c;
    }
}
