package pl.sdacademy.java.advanced.exercises.day2.task25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.java.advanced.exercises.day2.task25.exceptions.BasketEmptyException;
import pl.sdacademy.java.advanced.exercises.day2.task25.exceptions.BasketFullException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BasketTest {
    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
    }

    @Test
    //void shouldNotBePossibleToAddNewItemWhenBasketIfFull() throws BasketFullException{
    void shouldNotBePossibleToAddNewItemWhenBasketIfFull(){
        //given
        // checked exception -> albo try/catch lub throws BasketFullException w sygnaturze metody
        try {
            initData();
        } catch(BasketFullException e) {
            System.out.println("Exception: " + e);
        }
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

    private void initData() throws BasketFullException{
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