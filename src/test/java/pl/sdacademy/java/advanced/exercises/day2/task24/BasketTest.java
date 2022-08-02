package pl.sdacademy.java.advanced.exercises.day2.task24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.java.advanced.exercises.day2.task24.exceptions.BasketEmptyException;
import pl.sdacademy.java.advanced.exercises.day2.task24.exceptions.BasketFullException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
    }

    @Test
    void shouldNotBePossibleToAddNewItemWhenBasketIfFull() {
        //given
        initData();
        //when && then
        assertThatThrownBy(() -> basket.add())
                .isInstanceOf(BasketFullException.class)
                .hasMessage("Too many items int the basket!");
    }

    @Test
    void shouldNotBePossibleToRemoveItemWhenBasketIfEmpty() {
        //when && then
        assertThatThrownBy(() -> basket.remove())
                .isInstanceOf(BasketEmptyException.class)
                .hasMessage("Can't remove from empty basket");
    }

    private void initData() {
        basket.add();
        basket.add();
        basket.add();
        basket.add();
        basket.add();
        basket.add();
        basket.add();
        basket.add();
        basket.add();
        basket.add();
    }

}