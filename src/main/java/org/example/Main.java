package org.example;

import org.example.model.*;
import org.example.zoo_management.AnimalFactory;
import org.example.zoo_management.ZooQueries;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // Creazione degli animali
        List<AnimalModel> animals = AnimalFactory.createAnimals();

        // Filtraggio degli animali con coda
        List<AnimalWithTailModel> animalsWithTail = AnimalFactory.filterAnimalsWithTail(animals);

        // Filtraggio delle aquile
        List<AnimalWithWingspanModel> animalsWithWingspan = AnimalFactory.filterAnimalsWithWingspan(animals);

        // Creazione oggetto zooQueries e inizializzo le liste per consentire all'oggetto di accedere
        ZooQueries zooQueries = new ZooQueries(animalsWithTail, animalsWithWingspan);

        zooQueries.findLongestTail();
        zooQueries.findLargestWingspan();
        logger.info("The Largest wingspan animal is: " + zooQueries.findLargestWingspan().getName() + "\n");
        logger.info("The Longest tail animal is: " + zooQueries.findLongestTail().getName() + "\n");

        ZooQueries.findTallestAndShortest(animals);
        ZooQueries.findHeaviestAndLightest(animals);
    }
}
/*
Bene se stai leggendo questo significa che ho incollato le domande da pormi alla fine come "ultimo" step
(ci sarà al 100% migliorie o correzioni però sei vicino alla fine), adesso inizia la tua personale "Code Review"
Buon divertimento :D :D

rispetto i 5 principi solid?
il codice è leggibile?
il codice è sostenibile?
il codice è manutenibile?
il codice è scalabile?
il codice è sicuro?
il codice è testabile?
il codice è efficiente?
il codice è pulito?
*/