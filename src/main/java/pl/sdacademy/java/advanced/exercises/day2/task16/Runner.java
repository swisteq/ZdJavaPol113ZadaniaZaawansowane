package pl.sdacademy.java.advanced.exercises.day2.task16;

import java.util.Arrays;

public enum Runner {
    BEGINNER(201, Integer.MAX_VALUE),
    INTERMEDIATE(101, 200),
    ADVANCED(0, 100);

    private static final Runner[] VALUES = values(); // values() zwraca nam wszystkie elementy z enuma - BEGINNER, INTERMEDIATE, ADVANCED w postaci tablicy
    private final int minMinutes;
    private final int maxMinutes;

    Runner(int minMinutes, int maxMinutes) {
        this.minMinutes = minMinutes;
        this.maxMinutes = maxMinutes;
    }

    public static Runner getFitnessLevel(int runningTimeInMinutes) {
        return Arrays.stream(VALUES)
                .filter(runner -> runningTimeInMinutes <= runner.maxMinutes && runningTimeInMinutes >= runner.minMinutes)
                .findFirst()
                .orElse(BEGINNER);
                //.orElseThrow(() -> new IllegalArgumentException("Podany czas jest spoza zakresu!"));
    }
}
