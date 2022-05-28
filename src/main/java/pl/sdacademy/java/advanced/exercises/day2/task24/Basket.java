package pl.sdacademy.java.advanced.exercises.day2.task24;

import pl.sdacademy.java.advanced.exercises.day2.task24.exceptions.BasketEmptyException;
import pl.sdacademy.java.advanced.exercises.day2.task24.exceptions.BasketFullException;

public class Basket {
    private static final int MAX_CAPACITY = 10;
    private static final int MIN_CAPACITY = 0;
    private int items;

    public Basket() {
        items = 0;
    }

    public void add() {
        if(items >= MAX_CAPACITY) {
            throw new BasketFullException("Too many items int the basket!");
        }
        items++;
    }

    public void remove() {
        if(items == MIN_CAPACITY) {
            throw new BasketEmptyException("Can't remove from empty basket");
        }
        items--;
    }
}
