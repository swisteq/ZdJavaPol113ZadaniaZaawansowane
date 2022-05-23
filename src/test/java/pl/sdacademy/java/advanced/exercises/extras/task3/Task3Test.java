package pl.sdacademy.java.advanced.exercises.extras.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {
    private List<Product> products;
    private List<Order> orders;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;
    private Product product6;
    private Product product7;
    private Order order1;
    private Order order2;
    private Order order3;
    private Order order4;
    private Order order5;

    @BeforeEach
    void setUp() {
        product1 = new Product(1L, "AAA", "Computer", 2500);
        product2 = new Product(2L, "BBB", "Computer", 5001);
        product3 = new Product(3L, "CCC", "Computer", 1000);
        product4 = new Product(4L, "DDD", "Computer", 9000);
        product5 = new Product(5L, "EEE", "Book", 8000);
        product6 = new Product(6L, "FFF", "Computer", 5000);
        product7 = new Product(7L, "GGG", "Phone", 3000);

        order1 = new Order(1l, List.of(product1, product2, product3, product4), LocalDate.of(2022, 01, 15));
        order2 = new Order(2l, List.of(product1, product2, product3, product4, product5), LocalDate.of(2022, 01, 5));
        order3 = new Order(3l, List.of(product5), LocalDate.of(2022, 05, 5));
        order4 = new Order(4l, List.of(product5, product6), LocalDate.of(2022, 02, 15));
        order5 = new Order(5l, List.of(product7), LocalDate.of(2022, 03, 15));

        products = List.of(product1, product2, product3, product4, product5, product6, product7);
        orders = List.of(order1, order2, order3, order4, order5);
    }

    @Test
    void shouldReturnCorrectListForPointA() {
        //when
        List<Product> result = Task3.pointA(products);
        //then
        assertThat(result).containsExactlyInAnyOrder(product2, product4);
    }

    @Test
    void shouldReturnCorrectListForPointB() {
        //given
        List<Product> expectedResult = List.of(
                new Product(1L, "AAA", "Computer", 2000),
                new Product(2L, "BBB", "Computer", 4000.8),
                new Product(3L, "CCC", "Computer", 800),
                new Product(4L, "DDD", "Computer", 7200),
                new Product(6L, "FFF", "Computer", 4000)
        );
        //when
        List<Product> result = Task3.pointB(products);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnCorrectProductForPointC() {
        //when
        Product result = Task3.pointC(products);
        //then
        assertThat(result).isEqualTo(product3);
    }

    @Test
    void shouldReturnCorrectListForPointD() {
        //when
        List<Order> result = Task3.pointD(orders);
        //then
        assertThat(result).containsExactlyInAnyOrder(order2, order3, order4);
    }

    @Test
    void shouldReturnCorrectListForPointE() {
        //when
        List<Product> result = Task3.pointE(orders);
        //then
        assertThat(result).containsExactlyInAnyOrder(product1, product2, product3, product4, product5);
    }

    @Test
    void shouldReturnCorrectListForPointF() {
        //when
        List<Order> result = Task3.pointF(orders);
        //then
        assertThat(result).containsExactlyInAnyOrder(order3, order5);
    }

    @Test
    void shouldReturnCorrectListForPointG() {
        //when
        double result = Task3.pointG(orders);
        //then
        assertThat(result).isEqualTo(25_501);
    }
}