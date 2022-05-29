package pl.sdacademy.java.advanced.exercises.day3.task33;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImageFinder {
    public static List<String> findImages(Path directory) {
        //założenie: plik ze zdjęciem to plik z rozszerzeniem *.png lub *.jpeg
        //Files.walk(path) -> przechodzi po drzewie folderów, zaczynając od directory
        try (Stream<Path> walk = Files.walk(directory)){
            return walk
                    //.map(Path::toFile)
                    //.map(File::getName)
                    .map(p -> p.getFileName().toString())
                    .filter(i -> i.endsWith(".png") || i.endsWith(".jpeg"))
                    .collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println("Exception: " + e);
        }
        return Collections.emptyList();
    }
}
