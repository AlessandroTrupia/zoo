package org.example.domain;

import java.time.LocalDate;

/**
 * The Animal class represents an abstract animal.
 * It provides basic information about the animal, such as its name, favorite food, age, registration date, weight, and height.
 * This class serves as a base class and cannot be instantiated directly.
 * Subclasses should inherit from this class to represent specific types of animals.
 *
 * @author Alessandro
 * @version 1.0 9/05/2023
 */

public abstract class AnimalModel {

    /**
     * The name of the animal.
     */

    private String name;

    /**
     * The favorite food of the animal.
     */

    private String favouriteFood;

    /**
     * The age of the animal.
     */

    private int age;

    /**
     * The date when the animal joined the zoo.
     */

    private LocalDate joinedInZooDate;

    /**
     * The weight of the animal.
     */

    private double weight;

    /**
     * The height of the animal.
     */

    private double height;

    /**
     * Constructs a new Animal instance with the specified values.
     *
     * @param name              the name of the animal
     * @param favouriteFood     the favorite food of the animal
     * @param age               the age of the animal
     * @param joinedInZooDate  the registration date of the animal
     * @param weight            the weight of the animal
     * @param height            the height of the animal
     */

    public AnimalModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.joinedInZooDate = joinedInZooDate;
        this.weight = weight;
        this.height = height;
    }

    /**
     *
     * Getter and Setter per each field
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getJoinedInZooDate() {
        return joinedInZooDate;
    }

    public void setJoinedInZooDate(LocalDate joinedInZooDate) {
        this.joinedInZooDate = joinedInZooDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
