package org.example.domain;

import java.time.LocalDate;

/**
 * The Tiger class represents a tiger, which is a type of animal.
 * It extends the Animal class and adds an additional property for the tail length.
 * Tigers have all the basic properties and behaviors of animals.
 * This class provides methods to get and set the tail length of the tiger.
 * Tigers can be instantiated to represent individual tigers.
 *
 * @author Alessandro
 * @version 1.0 9/05/2023
 */

public class TigerModel extends AnimalWithTailModel {

    /**
     * Constructs a new Tiger instance with the specified values.
     *
     * @param name              the name of the tiger
     * @param favouriteFood     the favorite food of the tiger
     * @param age               the age of the tiger
     * @param joinedInZooDate  the registration date of the tiger
     * @param weight            the weight of the tiger
     * @param height            the height of the tiger
     * @param tailLength        the length of the tiger's tail
     */

    public TigerModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, joinedInZooDate, weight, height, tailLength);
    }
}
