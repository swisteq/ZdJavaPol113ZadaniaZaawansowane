package pl.sdacademy.java.advanced.exercises.day3.task33;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path dirPath = Path.of("src/main/java/pl/sdacademy/java/advanced/exercises/day3/task33");
        List<String> result = ImageFinder.findImages(dirPath);
        System.out.println(result);
    }
}
