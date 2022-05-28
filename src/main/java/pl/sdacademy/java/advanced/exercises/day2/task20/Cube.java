package pl.sdacademy.java.advanced.exercises.day2.task20;

public class Cube extends Shape3D{
    private final int a;

    public Cube(int a) {
        this.a = a;
    }

    @Override
    double calculatePerimeter() {
        return 12 * a;
    }

    @Override
    double calculateVolume() {
        return Math.pow(a, 3);
    }
}
