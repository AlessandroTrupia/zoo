package org.example;

import org.example.domain.*;
import org.example.domain.AnimalFactory;
import org.example.domain.ZooQueries;
import java.util.List;
/*
il codice rispetta i 5 principi solid?
il codice è LEGGIBILE?
il codice è sostenibile?
il codice è manutenibile?
il codice è scalabile?
il codice è sicuro?
il codice è testabile?
il codice è EFFICIENTE?
il codice è PULITO?
*/

public class Main {

    public static void main(String[] args) {

        testQueries();
    }

    private static void testQueries (){

        AnimalFactory animalFactory = new AnimalFactory();

        List<AnimalModel> animalsList = animalFactory.createAnimals();
        List<AnimalWithTailModel> animalsWithTail = animalFactory.addAnimalsWithTail(animalsList);
        List<AnimalWithWingspanModel> animalsWithWingspan = animalFactory.addAnimalsWithWingspan(animalsList);

        ZooQueries zooQueries = new ZooQueries(animalsWithTail, animalsWithWingspan);

        AnimalWithTailModel longestTailAnimal = zooQueries.getLongestTailAnimal();
        System.out.println("\nThe Longest tail animal is: " + longestTailAnimal.getName() + "\n");

        AnimalWithWingspanModel largestWingspanAnimal = zooQueries.getLargestWingspanAnimal();
        System.out.println("The Largest wingspan animal is: " + largestWingspanAnimal.getName() + "\n");

        zooQueries.getAllTallestAnimals(animalsList);

        zooQueries.getAllShortestAnimals(animalsList);

        zooQueries.getAllHeaviestAnimals(animalsList);

        zooQueries.getAllLightestAnimals(animalsList);


        System.out.println("\nList of all animals:");
        animalsList.forEach(animalModel -> System.out.println(animalModel.toString()));
    }
}
