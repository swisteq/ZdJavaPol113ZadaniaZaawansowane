package pl.sdacademy.java.advanced.exercises.day2.task12;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Car> getAllWithEngineV12() {
        return cars.stream()
                .filter(car -> car.getEngineType().equals(EngineType.V12))
                .collect(Collectors.toList());
    }

    public List<Car> getAllWithSpecificEngine(EngineType engineType) {
        return cars.stream()
                .filter(car -> car.getEngineType().equals(engineType))
                .collect(Collectors.toList());
    }

    public Optional<Car> getMostExpensiveCar() {
        return cars.stream()
                .max(Comparator.comparingDouble(Car::getPrice));
                //.max(Comparator.comparingDouble(car -> car.getPrice()));
    }

    public List<Car> getSortedCarByName(boolean ascending) {
        if(ascending) {
            return cars.stream()
                    .sorted(Comparator.comparing(Car::getName))
                    .collect(Collectors.toList());
        }
        return cars.stream()
                .sorted(Comparator.comparing(Car::getName).reversed())
                .collect(Collectors.toList());
    }

    public List<Car> getCarsFoundedIn(int foundedYear, Operation operator) {
        //.allMatch()
        switch(operator) {
            case GREATER_THAN:
                return cars.stream()
                        .filter(car -> car.getManufacturers().stream()
                                .anyMatch(m -> m.getFoundedInYear() > foundedYear))
                        .collect(Collectors.toList());
            case LESS_THAN:
                return cars.stream()
                        .filter(car -> car.getManufacturers().stream()
                                .anyMatch(m -> m.getFoundedInYear() < foundedYear))
                        .collect(Collectors.toList());
            case EQUAL:
                return cars.stream()
                        .filter(car -> car.getManufacturers().stream()
                                .anyMatch(m -> m.getFoundedInYear() == foundedYear))
                        .collect(Collectors.toList());
            default:
                //throw new IllegalArgumentException("no logic for this operator!");
                return Collections.emptyList();
        }
    }
}
