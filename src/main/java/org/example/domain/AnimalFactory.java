package org.example.domain;

import org.example.domain.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalFactory {

    public List <AnimalModel> createAnimals(){

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

    /*Caching risultati?
    * */
    public List<AnimalWithTailModel> addAnimalsWithTail(List<AnimalModel> animals) {
        return animals.stream()
                .filter(AnimalWithTailModel.class::isInstance)
                .map(AnimalWithTailModel.class::cast)
                .collect(Collectors.toList());
    }

    public List<AnimalWithWingspanModel> addAnimalsWithWingspan(List<AnimalModel> animals) {
        return animals.stream()
                .filter(AnimalWithWingspanModel.class::isInstance)
                .map(AnimalWithWingspanModel.class::cast)
                .collect(Collectors.toList());
    }
}

