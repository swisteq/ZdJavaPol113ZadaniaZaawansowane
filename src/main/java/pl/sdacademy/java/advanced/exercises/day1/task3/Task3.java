package pl.sdacademy.java.advanced.exercises.day1.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("Java", 18);
        input.put("Pyhton", 1);
        input.put("C#", 10);
        input.put("Pascal", 5);
        input.put("PHP", 0);
        System.out.println(getDescription(input));
    }

    public static String getDescription(Map<String, Integer> input) {
        return input.entrySet()
                .stream()
                .map(entry -> "Klucz: " + entry.getKey() + ", Klucz: " + entry.getValue())
                .collect(Collectors.joining(", " + System.lineSeparator(), "", "."));
    }
}
