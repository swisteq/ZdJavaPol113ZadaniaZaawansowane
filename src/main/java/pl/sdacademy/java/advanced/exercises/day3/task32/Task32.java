package pl.sdacademy.java.advanced.exercises.day3.task32;

import java.io.*;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Task32 {

    public static void main(String[] args) {
        Path dirPath = Path.of("src/main/java/pl/sdacademy/java/advanced/exercises/day3/task32");
        Path inputFile = dirPath.resolve("cars.txt");
        File file = inputFile.toFile();

        List<Car> cars = List.of(
                new Car("Volvo", 300_000, true),
                new Car("GLS", 100_00, false),
                new Car("x500", 50_00, false)
        );
        save(file, cars);
        List<Car> result = load(file);
        System.out.println(result);
        System.out.println(result.size());
    }

    private static void save(File file, List<Car> content) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(content);
        } catch(IOException e) {
            System.out.println("Exception during save file: " + e);
        }
    }

    private static List<Car> load(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Car>) ois.readObject();
        } catch(IOException e) {
            System.out.println("Exception during opening file: " + e);
        } catch(ClassNotFoundException e) {
            System.out.println("Exception during creating  list of cars: " + e);
        }
        return Collections.emptyList();
    }
}
