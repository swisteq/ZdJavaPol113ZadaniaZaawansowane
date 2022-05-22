package pl.sdacademy.java.advanced.exercises.day1.task8;

import java.util.Objects;

public class Parcel {
    private final int xLength;
    private final int yLength;
    private final int zLength;
    private final float weight;
    private final boolean isExpress;

    public Parcel(int xLength, int yLength, int zLength, float weight, boolean isExpress) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
        this.weight = weight;
        this.isExpress = isExpress;
    }

    public int getxLength() {
        return xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public int getzLength() {
        return zLength;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isExpress() {
        return isExpress;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return xLength == parcel.xLength && yLength == parcel.yLength && zLength == parcel.zLength && Float.compare(parcel.weight, weight) == 0 && isExpress == parcel.isExpress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLength, yLength, zLength, weight, isExpress);
    }
}
