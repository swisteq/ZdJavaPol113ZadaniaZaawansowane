package pl.sdacademy.java.advanced.exercises.day1.task7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WeaponMagazineTest {
    private WeaponMagazine weaponMagazine;

    @BeforeEach
    void initData() {
        weaponMagazine = new WeaponMagazine(5);
    }

    @Test
    void shouldBePossibleToAddNewBulletWhenMagazineIsNotFull() {
        //when
        weaponMagazine.loadBullet("pocisk_1");
        //then
        assertThat(weaponMagazine.isLoaded()).isTrue();
    }

    @Test
    void shouldReturnFalseIfMagazineIsEmpty() {
        //when
        boolean result = weaponMagazine.isLoaded();
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldBeNotPossibleToAddNewBulletWhenMagazineIsFull() {
        //given
        weaponMagazine.loadBullet("pocisk_1");
        weaponMagazine.loadBullet("pocisk_2");
        weaponMagazine.loadBullet("pocisk_3");
        weaponMagazine.loadBullet("pocisk_4");
        weaponMagazine.loadBullet("pocisk_5");
        //when
        assertThatThrownBy(() -> weaponMagazine.loadBullet("pocisk_6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Magazine is full");
    }

    @Test
    void shouldBePossibleToShotWhenMagazineIsNotEmpty() {
        //given
        weaponMagazine.loadBullet("pocisk_1");
        weaponMagazine.loadBullet("pocisk_2");
        weaponMagazine.loadBullet("pocisk_3");
        //when
        String result = weaponMagazine.shot();
        //then
        assertThat(result).isEqualTo("pocisk_3");
    }

    @Test
    void shouldNotBePossibleToShotWhenMagazineIsEmpty() {
        //given
        String expectedResult = "pusty magazynek";
        //when
        String result = weaponMagazine.shot();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldNotBePossibleToShotWhenMagazineIsEmpty_2() {
        //given
        weaponMagazine.loadBullet("pocisk_1");
        weaponMagazine.loadBullet("pocisk_2");
        weaponMagazine.loadBullet("pocisk_3");
        //when
        weaponMagazine.shot();
        weaponMagazine.shot();
        weaponMagazine.shot();
        //then
        assertThat(weaponMagazine.isLoaded()).isFalse();
    }

}