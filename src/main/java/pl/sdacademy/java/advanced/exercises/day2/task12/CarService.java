package pl.sdacademy.java.advanced.exercises.day2.task12;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void remove(Car car) {
        cars.remove(car);
    }

    public List<Car> getAll() {
        return new ArrayList<>(cars); // tworzymy i zwracamy nową listę samochodów
        //return List.copyOf(cars); //tworzy niemodyfikalną listę samochodów
        //return cars; //będziemy operować cały czas na liście car
    }
}
