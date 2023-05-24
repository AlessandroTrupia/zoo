package org.example.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalWithWingspanModel extends AnimalModel{

    protected AnimalWithWingspanModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height);
        this.wingspanLength = wingspan;
    }
    /**
     * The wingspan of the eagle.
     */

    private double wingspanLength;

    public double getWingspanLength() {
        return wingspanLength;
    }

    public void setWingspanLength(double wingspan) {
        this.wingspanLength = wingspan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalWithWingspanModel that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.wingspanLength, wingspanLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingspanLength);
    }
}