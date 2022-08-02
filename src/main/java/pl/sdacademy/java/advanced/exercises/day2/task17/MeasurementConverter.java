package pl.sdacademy.java.advanced.exercises.day2.task17;

public class MeasurementConverter {

    public float convert(float value, ConversionType conversionType) {
        return value * conversionType.getValue();
    }

    public float convert(float value, ConversionTypeWithFunction conversionType) {
        return conversionType.getConversion().apply(value);
    }
}
