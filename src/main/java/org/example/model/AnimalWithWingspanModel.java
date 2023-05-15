package org.example.model;

import java.time.LocalDate;

public abstract class AnimalWithWingspanModel extends AnimalModel{

    /**
     * The wingspan of the eagle.
     */

    private double wingspanLength;

    public AnimalWithWingspanModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height);
        this.wingspanLength = wingspan;
    }

    public double getWingspanLength() {
        return wingspanLength;
    }

    public void setWingspanLength(double wingspan) {
        this.wingspanLength = wingspan;
    }
}