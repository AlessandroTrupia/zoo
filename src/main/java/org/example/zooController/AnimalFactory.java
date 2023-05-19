package org.example.zooController;

import org.example.domain.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalFactory {

    private AnimalFactory() {
    }

    public static List <AnimalModel> createAnimals(){

        List <AnimalModel> animals = new ArrayList<>();

        AnimalModel[] animalArray = {
                new LionModel("LeoneNano", "SadZebra",
                        5, LocalDate.now(), 170, 110, 100),
                new LionModel("LeoneMedio", "SadZebra",
                        5, LocalDate.now(), 180, 115, 110),
                new LionModel("Kimba il leone bianco", "VerySadZebra",
                        8, LocalDate.now(), 255, 135, 120),

                new TigerModel("TigreNana", "SadDeer",
                        5, LocalDate.now(), 220, 90, 90),
                new TigerModel("TigreMedia", "SadDeer",
                        5, LocalDate.now(), 250, 110, 115),
                new TigerModel("TigreAlta", "SuperSadDeer",
                        10, LocalDate.now(), 300, 130, 130),

                new EagleModel("AquilaNana", "SuperSadRabbit",
                        20, LocalDate.now(), 2.4, 80, 180),
                new EagleModel("AquilaMedia", "SadRabbit",
                        15, LocalDate.now(), 3.2, 90, 190),
                new EagleModel("AquilaAlta", "SadRabbit",
                        15, LocalDate.now(), 3.5, 100, 200),

        };
        Collections.addAll(animals, animalArray);
        return animals;
    }

    /*
     Creating a list to store unique species of AnimalModel,
     In the for loop, iterate over each animal in the "animals" list passed as a parameter.
     For each animal, I should obtain the class name using getClass().getSimpleName().
     Then, using an "if" statement, I check if the obtained species already exists to avoid duplicates.
     If it doesn't exist, I add this species to the list.
     Finally, I return the list.
     */
    public static List<String> addUniqueSpecies(List<AnimalModel> animals) {
        List<String> species = new ArrayList<>();

        for (AnimalModel animal : animals) {
            String specie = animal.getClass().getSimpleName();
            if (!species.contains(specie)) {
                species.add(specie);
            }
        }
        return species;
    }
//Caching risultati?
    public static List<AnimalWithTailModel> addAnimalsWithTail(List<AnimalModel> animals) {

        List<AnimalWithTailModel> animalsWithTail = new ArrayList<>();

        for (AnimalModel animal : animals) {
            if (animal instanceof AnimalWithTailModel) {
                animalsWithTail.add((AnimalWithTailModel) animal);
            }
        }

        return animalsWithTail;
    }

    public static List<AnimalWithWingspanModel> addAnimalsWithWingspan(List<AnimalModel> animals) {

        List<AnimalWithWingspanModel> animalsWithWingspan = new ArrayList<>();

        for (AnimalModel animal : animals) {
            if (animal instanceof AnimalWithWingspanModel) {
                animalsWithWingspan.add((AnimalWithWingspanModel)animal);
            }
        }

        return animalsWithWingspan;
    }
}

