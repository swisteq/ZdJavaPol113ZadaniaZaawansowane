package pl.sdacademy.java.advanced.exercises.day2.task17;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementConverterTest {
    MeasurementConverter converter = new MeasurementConverter();

    @Test
    void shouldConvertCentimetersToInches() {
        //when
        float result = converter.convert(2f, ConversionType.CENTIMETERS_TO_INCHES);
        //then
        assertThat(result).isEqualTo(0.78f);
    }

    @Test
    void shouldConvertMilesToKilometers() {
        //when
        float result = converter.convert(2f, ConversionType.MILES_TO_KILOMETERS);
        //then
        assertThat(result).isEqualTo(3.22f);
    }

    @Test
    void shouldConvertCentimetersToInches_function() {
        //when
        float result = converter.convert(2f, ConversionTypeWithFunction.CENTIMETERS_TO_INCHES);
        //then
        assertThat(result).isEqualTo(0.78f);
    }

    @Test
    void shouldConvertMilesToKilometers_function() {
        //when
        float result = converter.convert(2f, ConversionTypeWithFunction.MILES_TO_KILOMETERS);
        //then
        assertThat(result).isCloseTo(3.22f, Percentage.withPercentage(1)); // gdy robimy na floatach, to nie ma metody within, tylko withPercentage ;)
    }

}