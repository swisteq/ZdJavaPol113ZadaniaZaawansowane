package pl.sdacademy.java.advanced.exercises.day2.task12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private CarService carService;
    private Manufacturer benz;
    private Manufacturer mercedes;
    private Manufacturer volvo;
    private Manufacturer fiat;
    
    private Car x500;
    private Car gls_1;
    private Car gls_2;
    private Car xc90_1;
    private Car xc90_2;
    private Car xc60;

    @BeforeEach
    void setUp() {
        benz = new Manufacturer("Benz", 1883, "Germany");
        mercedes = new Manufacturer("Mercedes", 1901, "Germany");
        volvo = new Manufacturer("Volvo", 1926, "Sweden");
        fiat = new Manufacturer("Fiat", 1899, "Iatly");

        x500 = new Car("x500", "Fiat", 35_000, 2010, List.of(fiat), EngineType.S3);
        gls_1 = new Car("GLS", "Mercedes", 500_000, 2022, List.of(mercedes, benz), EngineType.V12);
        gls_2 = new Car("GLS", "Mercedes", 200_000, 2019, List.of(mercedes, benz), EngineType.V8);
        xc90_1 = new Car("xc90", "Volvo", 300_000, 2022, List.of(volvo), EngineType.V12);
        xc90_2 = new Car("xc90", "Volvo", 150_000, 2018, List.of(volvo), EngineType.V6);
        xc60 = new Car("xc60", "Volvo", 200_000, 2020, List.of(volvo), EngineType.S6);

        carService = new CarService();
        carService.add(x500);
        carService.add(gls_1);
        carService.add(gls_2);
        carService.add(xc90_1);
        carService.add(xc90_2);
        carService.add(xc60);
    }

    @Test
    void shouldReturnAllCars() {
        //when
        List<Car> result = carService.getAll();
        //then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result).containsExactlyInAnyOrder(x500, gls_1, gls_2, xc90_1, xc90_2, xc60);
    }

    @Test
    void shouldRemoveCar() {
        //when
        carService.remove(xc90_1);
        //then
        List<Car> result = carService.getAll();
        assertThat(result.size()).isEqualTo(5);
        assertThat(result).containsExactlyInAnyOrder(x500, gls_1, gls_2, xc90_2, xc60);
    }

}