package org.example.zoo_management;

import org.example.model.*;
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
     * Creazione di lista per contenere le specie uniche di AnimalModel,
     * nel ciclo for itero su ciascun animale nella lista "animals" passata come parametro,
     * per ogni animale, dovrei ottenere il nome della classe con getClass.get().getSimpleName(), (e.g. spoiler alert : "EagleModel)
     * dopo con "if" controllo se già esiste la specie appena ottenuta per evitare eventuali duplicati, altrimenti aggiungo
     * sta specie alla lista, in fine restituisco l'elenco.
     * A cosa mi serve sto metodo? Mi dovrebbe consentire di ottenere un elenco di specie uniche presenti, in modo da poter
     * eseguire operazioni specifiche tipo le query, per ogni specie individuale.
     * WORKA! :)
     */
    public static List<String> getUniqueSpecies(List<AnimalModel> animals) {
        List<String> species = new ArrayList<>();

        for (AnimalModel animal : animals) {
            String specie = animal.getClass().getSimpleName();
            if (!species.contains(specie)) {
                species.add(specie);
            }
        }
        return species;
    }

    //filtro e add animali con la coda
    public static List<AnimalWithTailModel> filterAnimalsWithTail(List<AnimalModel> animals) {

        List<AnimalWithTailModel> animalsWithTail = new ArrayList<>();

        for (AnimalModel animal : animals) {
            if (animal instanceof AnimalWithTailModel) {
                animalsWithTail.add((AnimalWithTailModel) animal);
            }
        }

        return animalsWithTail;
    }

    //filtro e add animali apertura alare
    public static List<AnimalWithWingspanModel> filterAnimalsWithWingspan(List<AnimalModel> animals) {

        List<AnimalWithWingspanModel> animalsWithWingspan = new ArrayList<>();

        for (AnimalModel animal : animals) {
            if (animal instanceof AnimalWithWingspanModel) {
                animalsWithWingspan.add((AnimalWithWingspanModel)animal);
            }
        }

        return animalsWithWingspan;
    }
}

