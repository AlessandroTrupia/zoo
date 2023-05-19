package org.example.domain;

import java.time.LocalDate;

/**
 * The Eagle class represents an eagle, which is a type of animal.
 * It extends the Animal class and adds an additional property for the wingspan.
 * Eagles have all the basic properties and behaviors of animals.
 * Eagles can be instantiated to represent individual eagles.
 *
 * @author Alessandro
 * @version 1.0 9/05/2023
 */

public class EagleModel extends AnimalWithWingspanModel {

    public EagleModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height, wingspan);
    }

}