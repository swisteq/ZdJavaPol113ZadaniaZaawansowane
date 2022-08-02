package pl.sdacademy.java.advanced.exercises.day3.task32;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private final String model;
    private final double price;
    private final boolean isNew;

    public Car(String model, double price, boolean isNew) {
        this.model = model;
        this.price = price;
        this.isNew = isNew;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && isNew == car.isNew && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, isNew);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", isNew=" + isNew +
                '}';
    }
}
