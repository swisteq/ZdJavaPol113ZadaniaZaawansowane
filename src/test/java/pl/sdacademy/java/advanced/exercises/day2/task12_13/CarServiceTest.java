package pl.sdacademy.java.advanced.exercises.day2.task12_13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    private Car xc60_1;
    private Car xc60_2;

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
        xc60_1 = new Car("xc60", "Volvo", 200_000, 2020, List.of(volvo), EngineType.S6);
        xc60_2 = new Car("xc60", "Volvo", 20_00, 1998, List.of(volvo), EngineType.S3);

        carService = new CarService();
        carService.add(x500);
        carService.add(gls_1);
        carService.add(gls_2);
        carService.add(xc90_1);
        carService.add(xc90_2);
        carService.add(xc60_1);
        carService.add(xc60_2);

//        Optional<Car> mostExpensiveCar = carService.getMostExpensiveCar();
//
//        if(mostExpensiveCar.isPresent()) {
//            //logika1 -> rozpakuj car
//        } else {
//            //logika2 -> rzuć wyjątek
//        }
//        Car car = mostExpensiveCar.orElseThrow();
    }

    @Test
    void shouldReturnAllCars() {
        //when
        List<Car> result = carService.getAll();
        //then
        assertThat(result.size()).isEqualTo(7);
        assertThat(result).containsExactlyInAnyOrder(x500, gls_1, gls_2, xc90_1, xc90_2, xc60_1, xc60_2);
    }

    @Test
    void shouldRemoveCar() {
        //when
        carService.remove(xc90_1);
        //then
        List<Car> result = carService.getAll();
        assertThat(result.size()).isEqualTo(6);
        assertThat(result).containsExactlyInAnyOrder(x500, gls_1, gls_2, xc90_2, xc60_1, xc60_2);
    }

    @Test
    void shouldReturnCarsWithEngineTypeEqualToV12() {
        //when
        List<Car> result = carService.getAllWithEngineV12();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(gls_1, xc90_1);
    }

    @Test
    void shouldReturnCarsWithEngineTypeEqualToV8() {
        //when
        List<Car> result = carService.getAllWithSpecificEngine(EngineType.V8);
        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result).containsExactlyInAnyOrder(gls_2);
    }

    @Test
    void shouldReturnTheMostExpensiveCar() {
        //when
        Car result = carService.getMostExpensiveCar().get();
        //then
        assertThat(result).isEqualTo(gls_1);
    }

    @Test
    void shouldReturnSortedListAscending() {
        //when
        List<Car> result = carService.getSortedCarByName(true);
        //then
        assertThat(result).containsExactly(gls_1, gls_2, x500, xc60_1, xc60_2, xc90_1, xc90_2);
    }

    @Test
    void shouldReturnSortedListDescending() {
        //when
        List<Car> result = carService.getSortedCarByName(false);
        //then
        assertThat(result).containsExactly(xc90_1, xc90_2, xc60_1, xc60_2, x500, gls_1, gls_2);
    }

    @Test
    void shouldReturnListOfCarsWhichManufacturersFounded_LessThan() {
        //when
        List<Car> result = carService.getCarsFoundedIn(1900, Operation.LESS_THAN);
        //then
        assertThat(result).containsExactlyInAnyOrder(x500, gls_1, gls_2);
    }

    @Test
    void shouldReturnCarsProducedBefore1999() {
        //when
        List<Car> result = carService.getCarsProducedBefore1999();
        //then
        assertThat(result).containsExactlyInAnyOrder(xc60_2);
    }

    @Test
    void shouldReturnCheapestCar() {
        //when
        Car result = carService.getCheapestCar().get();
        //then
        assertThat(result).isEqualTo(xc60_2);
    }

    @Test
    void shouldReturnCarsHavingAtLeast2Manufacturers() {
        //when
        List<Car> result = carService.getCarsHavingAtLeast2Manufacturers();
        //then
        assertThat(result).containsExactlyInAnyOrder(gls_1, gls_2);
    }

    @Test
    void shouldReturnCarsProducedBy() {
        //when
        List<Car> result = carService.getCarsProducedBy(volvo);
        //then
        assertThat(result).containsExactlyInAnyOrder(xc90_1, xc90_2, xc60_1, xc60_2);
    }

}