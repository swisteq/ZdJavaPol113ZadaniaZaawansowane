package pl.sdacademy.java.advanced.exercises.day2.task24.exceptions;

public class BasketEmptyException extends RuntimeException{

    public BasketEmptyException(String message) {
        super(message);
    }
}
