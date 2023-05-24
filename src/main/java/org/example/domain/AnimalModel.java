package org.example.domain;

import java.time.LocalDate;
import java.util.Objects;

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
     * Constructs a new Animal instance with the specified values.
     *
     * @param name              the name of the animal
     * @param favouriteFood     the favorite food of the animal
     * @param age               the age of the animal
     * @param joinedInZooDate  the registration date of the animal
     * @param weight            the weight of the animal
     * @param height            the height of the animal
     */

    protected AnimalModel(String name, String favouriteFood, int age, LocalDate joinedInZooDate, double weight, double height) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.joinedInZooDate = joinedInZooDate;
        this.weight = weight;
        this.height = height;
    }
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



    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof AnimalModel that)) return false;

        return age == that.age
                && Double.compare(that.weight, weight) == 0
                && Double.compare(that.height, height) == 0
                && Objects.equals(name, that.name)
                && Objects.equals(favouriteFood, that.favouriteFood)
                && Objects.equals(joinedInZooDate, that.joinedInZooDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favouriteFood, age, joinedInZooDate, weight, height);
    }

    @Override
    public String toString() {
        return "AnimalModel{" +
                "name='" + name + '\'' +
                ", favouriteFood='" + favouriteFood + '\'' +
                ", age=" + age +
                ", joinedInZooDate=" + joinedInZooDate +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
