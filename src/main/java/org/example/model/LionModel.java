package org.example.model;

import java.time.LocalDate;

/**
 * The Lion class represents a lion, which is a type of animal.
 * It extends the Animal class and adds an additional property for the tail length.
 * Lions have all the basic properties and behaviors of animals.
 * This class provides methods to get and set the tail length of the lion.
 * Lions can be instantiated to represent individual lions.
 *
 * @author Alessandro
 * @version 1.0 9/05/2023
 */

public class LionModel extends AnimalWithTailModel {

    /**
     * Constructs a new Lion instance with the specified values.
     *
     * @param name              the name of the lion
     * @param favouriteFood     the favorite food of the lion
     * @param age               the age of the lion
     * @param joinedInZooDate  the registration date of the lion
     * @param weight            the weight of the lion
     * @param height            the height of the lion
     * @param tailLength        the length of the lion's tail
     */
    public LionModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height, tailLength);
    }
}
