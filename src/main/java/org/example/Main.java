package org.example;

import org.example.domain.*;
import org.example.zooController.AnimalFactory;
import org.example.zooController.ZooQueries;
import java.util.List;
/*
il codice rispetta i 5 principi solid?
il codice è LEGGIBILE?
il codice è sostenibile?
il codice è manutenibile?
il codice è scalabile?
il codice è sicuro?
il codice è testabile?
il codice è efficiente?
il codice è PULITO?
*/

public class Main {

    public static void main(String[] args) {

        /*List<AnimalModel> animals = AnimalFactory.createAnimals();

        List<AnimalWithTailModel> animalsWithTail = AnimalFactory.addAnimalsWithTail(animals);

        List<AnimalWithWingspanModel> animalsWithWingspan = AnimalFactory.addAnimalsWithWingspan(animals);

        ZooQueries zooQueries = new ZooQueries(animalsWithTail, animalsWithWingspan);


        ZooQueries.getAllTallestAnimals(animals);
        ZooQueries.getAllShortestAnimals(animals);
        ZooQueries.getAllLightestAnimals(animals);
        ZooQueries.getAllHeaviestAnimals(animals);*/

        AnimalFactory animalFactory = new AnimalFactory();

        List<AnimalModel> animals = animalFactory.createAnimals();
        List<AnimalWithTailModel> animalsWithTail = animalFactory.addAnimalsWithTail(animals);
        List<AnimalWithWingspanModel> animalsWithWingspan = animalFactory.addAnimalsWithWingspan(animals);

        ZooQueries zooQueries = new ZooQueries(animalsWithTail, animalsWithWingspan);
        zooQueries.findLongestTailAnimal();
        System.out.println("The Longest tail animal is: " + zooQueries.findLongestTailAnimal().getName() + "\n");

        zooQueries.findLargestWingspanAnimal();
        System.out.println("The Largest wingspan animal is: " + zooQueries.findLargestWingspanAnimal().getName() + "\n");

        zooQueries.getAllTallestAnimals(animals);

        zooQueries.getAllShortestAnimals(animals);

        zooQueries.getAllHeaviestAnimals(animals);

        zooQueries.getAllLightestAnimals(animals);
    }
}
