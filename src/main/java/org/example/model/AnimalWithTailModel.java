package org.example.model;

import java.time.LocalDate;

public abstract class AnimalWithTailModel extends AnimalModel{


    /**
     * The length of the tiger's tail.
     */

    private double tailLength;

    public AnimalWithTailModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height);
        this.tailLength = tailLength;
    }

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
}
