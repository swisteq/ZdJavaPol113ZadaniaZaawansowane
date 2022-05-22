package pl.sdacademy.java.advanced.exercises.day1.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private Storage storage;

    @BeforeEach
    void init() {
        storage = new Storage();
    }

    @Test
    void shouldAddNewKeyElement() {
        //when
        storage.addToStorage("0", "value0_0");
        //then
        assertThat(storage.getValues("0")).containsExactly("value0_0");
    }

    @Test
    void shouldAddNewValueUnderExistingKey() {
        //given
        storage.addToStorage("0", "value0_0");
        //when
        storage.addToStorage("0", "value0_1");
        //then
        assertThat(storage.getValues("0"))
                .containsExactlyInAnyOrder("value0_1", "value0_0");
    }

    @Test
    void shouldReturnKeysWithSpecificValue() {
        //given
        storage.addToStorage("0", "value0_0");
        storage.addToStorage("0", "value0_1");
        storage.addToStorage("1", "value1_0");
        storage.addToStorage("1", "value0_0");
        storage.addToStorage("2", "value2_0");
        //when
        List<String> result = storage.findValues("value0_0");
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder("0", "1");
    }

    @Test
    void shouldNotReturnAnyKeysWhenValueNotExist() {
        //given
        storage.addToStorage("0", "value0_0");
        storage.addToStorage("0", "value0_1");
        storage.addToStorage("1", "value1_0");
        storage.addToStorage("1", "value0_0");
        storage.addToStorage("2", "value2_0");
        //when
        List<String> result = storage.findValues("abc");
        //then
        assertThat(result.size()).isEqualTo(0);
    }

}