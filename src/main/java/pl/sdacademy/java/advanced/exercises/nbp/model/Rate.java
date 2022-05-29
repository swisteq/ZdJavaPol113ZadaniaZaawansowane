package pl.sdacademy.java.advanced.exercises.nbp.model;

import java.util.Objects;

public class Rate{
    public String currency;
    public String code;
    public double mid;

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public double getMid() {
        return mid;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Double.compare(rate.mid, mid) == 0 && Objects.equals(currency, rate.currency) && Objects.equals(code, rate.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, code, mid);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", mid=" + mid +
                '}';
    }
}