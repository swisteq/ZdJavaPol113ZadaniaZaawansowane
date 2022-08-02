package pl.sdacademy.java.advanced.exercises.day3.task30;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task30 {
    public static void main(String[] args) {
        Path dirPath = Path.of("src/main/java/pl/sdacademy/java/advanced/exercises/day3/task30");
        Path inputFile = dirPath.resolve("course.txt");
        if(!inputFile.toFile().exists()) {
            System.out.println("File not exist!");
            return;
        }
        List<String> contents = new ArrayList<>();
        try {
            contents = getFileContents(inputFile);
        } catch(IOException e) {
            System.out.println("Exception during opening file: " + e);
        }
        List<String> reversedContents = reverseFileContents(contents);
        Path outputFile = reverseFileName(inputFile);
        try {
            saveFile(outputFile, reversedContents);
        } catch(IOException e) {
            System.out.println("Exception during saving file: " + e);
        }
    }

    private static List<String> getFileContents(Path inputFile) throws IOException {
        return Files.readAllLines(inputFile);
    }

    private static List<String> reverseFileContents(List<String> content) {
        return content.stream()
                //.map(s -> new StringBuilder(s).reverse().toString())
                //.map(s -> reverseString(s))
                .map(Task30::reverseString)
                .collect(Collectors.toList());
    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static Path reverseFileName(Path inputFile) {
        // założenie: pierwsza kropka rozpoczyna rozszerzenie pliku
        String fileName = inputFile.toFile().getName(); // course.txt
        String fileExtension = "";
        int index = fileName.indexOf(".");
        if(index > 0) { //jeżeli index większy od zera tzn że mamy rozszerzenie pliku
            fileExtension = fileName.substring(index); // .txt
            fileName = fileName.substring(0, index); // course.txt
        }
        String reversedInputFile = new StringBuilder(fileName)
                .reverse()
                .append(fileExtension)
                .toString();
        return inputFile.getParent().resolve(reversedInputFile);
    }

    private static void saveFile(Path outputFile, List<String> content) throws IOException {
        Files.write(outputFile, content);
    }
}
