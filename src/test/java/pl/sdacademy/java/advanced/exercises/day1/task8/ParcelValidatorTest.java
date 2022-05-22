package pl.sdacademy.java.advanced.exercises.day1.task8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParcelValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new ParcelValidator();
    }

    @Test
    void shouldBePossibleToAddNonExpressParcel() {
        //given
        Parcel parcel = new Parcel(35, 40, 45, 29, false);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldNotBePossibleToAddNonExpressParcelWhenSumOfLengthsIsTooHigh() {
        //given
        Parcel parcel = new Parcel(100, 100, 101, 29, false);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddNonExpressParcelWhenXDimensionIsTooLow() {
        //given
        Parcel parcel = new Parcel(29, 30, 35, 29, false);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddNonExpressParcelWhenYDimensionIsTooLow() {
        //given
        Parcel parcel = new Parcel(30, 29, 35, 29, false);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddNonExpressParcelWhenZDimensionIsTooLow() {
        //given
        Parcel parcel = new Parcel(30, 35, 29, 29, false);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddNonExpressParcelWhenWeightIsTooHigh() {
        //given
        Parcel parcel = new Parcel(30, 35, 40, 31, false);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldBePossibleToAddExpressParcel() {
        //given
        Parcel parcel = new Parcel(35, 40, 45, 14, true);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldNotBePossibleToAddExpressParcelWhenSumOfLengthsIsTooHigh() {
        //given
        Parcel parcel = new Parcel(100, 100, 101, 14, true);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddExpressParcelWhenXDimensionIsTooLow() {
        //given
        Parcel parcel = new Parcel(29, 30, 35, 14, true);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddExpressParcelWhenYDimensionIsTooLow() {
        //given
        Parcel parcel = new Parcel(30, 29, 35, 14, true);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddExpressParcelWhenZDimensionIsTooLow() {
        //given
        Parcel parcel = new Parcel(30, 35, 29, 14, true);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBePossibleToAddExpressParcelWhenWeightIsTooHigh() {
        //given
        Parcel parcel = new Parcel(30, 35, 40, 16, true);
        //when
        boolean result = validator.validate(parcel);
        //then
        assertThat(result).isFalse();
    }
}