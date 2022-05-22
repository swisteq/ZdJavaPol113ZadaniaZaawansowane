package pl.sdacademy.java.advanced.exercises.day1.task8;

public class ParcelValidator implements Validator{
    private static final int TOTAL_MAX_LENGTH = 300;
    private static final int SINGLE_MIN_LENGTH = 30;
    private static final int MAX_WEIGHT_FOR_EXPRESS = 15;
    private static final int MAX_WEIGHT_FOR_NON_EXPRESS = 30;

    @Override
    public boolean validate(Parcel parcel) {
        return isXYZLessThan300(parcel) &&
                isEachDimensionIsMoreThan30(parcel) &&
                isWeightCorrect(parcel);
    }

    private boolean isXYZLessThan300(Parcel parcel) {
        return parcel.getxLength() + parcel.getyLength() + parcel.getzLength() <= TOTAL_MAX_LENGTH;
    }

    private boolean isEachDimensionIsMoreThan30(Parcel parcel) {
        return parcel.getxLength() >= SINGLE_MIN_LENGTH &&
                parcel.getyLength() >= SINGLE_MIN_LENGTH &&
                parcel.getzLength() >= SINGLE_MIN_LENGTH;
    }

    private boolean isWeightCorrect(Parcel parcel) {
        return (parcel.isExpress() && parcel.getWeight() <= MAX_WEIGHT_FOR_EXPRESS) ||
                (!parcel.isExpress() && parcel.getWeight() <= MAX_WEIGHT_FOR_NON_EXPRESS);
    }
}
