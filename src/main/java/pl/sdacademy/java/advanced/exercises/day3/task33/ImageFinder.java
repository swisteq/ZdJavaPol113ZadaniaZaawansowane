package pl.sdacademy.java.advanced.exercises.day3.task33;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ImageFinder {
    public static List<String> findImages(Path directory) {
        //założenie: plik ze zdjęciem to plik z rozszerzeniem *.png lub *.jpeg
        try (Stream<Path> walk = Files.walk(directory)){
            //todo logic
        } catch(IOException e) {
            System.out.println("Exception: " + e);
        }
        return Collections.emptyList();
    }
}
