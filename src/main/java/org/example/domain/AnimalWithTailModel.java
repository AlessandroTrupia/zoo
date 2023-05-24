package org.example.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalWithTailModel extends AnimalModel{

    protected AnimalWithTailModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height);
        this.tailLength = tailLength;
    }
    /**
     * The length of the tiger's tail.
     */

    private double tailLength;
    /**
     *
     *getter and setter tailLenght
     */

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof AnimalWithTailModel that)) return false;

        if (!super.equals(o)) return false;

        return Double.compare(that.tailLength, tailLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tailLength);
    }
}
