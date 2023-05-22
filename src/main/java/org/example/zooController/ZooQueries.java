package org.example.zooController;

import org.example.domain.AnimalModel;
import org.example.domain.AnimalWithTailModel;
import org.example.domain.AnimalWithWingspanModel;
import java.util.Comparator;
import java.util.List;
import static org.example.zooController.AnimalFactory.addUniqueSpecies;

//TODO migliorare struttura dati, HashMap?
//TODO ridurre complessità del codice (cicli for annidati)

/*
This class is used to perform various queries. Specifically, it includes the following queries:

Tallest and shortest animals per species.
Heaviest and lightest animals per species. (one or two methods? or maybe six?)
The animal with the longest tail.
The animal with the longest wingspan.
 */
public class ZooQueries {

    private final List <AnimalWithTailModel> animalsWithTailList;
    private final List <AnimalWithWingspanModel> animalsWithWingspanList;

    public ZooQueries (List<AnimalWithTailModel> animalsWithTailList, List<AnimalWithWingspanModel> animalsWithWingspanList) {
        this.animalsWithTailList = animalsWithTailList;
        this.animalsWithWingspanList = animalsWithWingspanList;

    }

    private static AnimalModel getShortestAnimalBySpecies(List<AnimalModel> animals, String species) {
        return animals.stream()
                .filter(animal -> animal.getClass().getSimpleName().equals(species))
                .min(Comparator.comparingDouble(AnimalModel::getHeight))
                .orElse(null);
    }

    private static AnimalModel getTallestAnimalBySpecies(List<AnimalModel> animals, String species) {
        return animals.stream()
                .filter(animal -> animal.getClass().getSimpleName().equals(species))
                .max(Comparator.comparingDouble(AnimalModel::getHeight))
                .orElse(null);
    }

    public static void getAllTallestAnimals(List<AnimalModel> animals) {
        System.out.println("All tallest animals by species:\n");

        List<String> species = addUniqueSpecies(animals);

        for (String speciesName : species) {
            AnimalModel tallestAnimal = getTallestAnimalBySpecies(animals, speciesName);

            if (tallestAnimal != null) {
                double tallest = tallestAnimal.getHeight();

                System.out.println(speciesName +
                        "\nTallest name: " + tallestAnimal.getName() + " (" + tallest + " cm)\n");
            }
        }
    }

    public static void getAllShortestAnimals(List<AnimalModel> animals) {
        System.out.println("All shortest animals by species:\n");

        List<String> species = addUniqueSpecies(animals);

        for (String speciesName : species) {
            AnimalModel shortestAnimal = getShortestAnimalBySpecies(animals, speciesName);

            if (shortestAnimal != null) {
                double shortest = shortestAnimal.getHeight();

                System.out.println(speciesName +
                        "\nShortest name: " + shortestAnimal.getName() + " (" + shortest + " cm)\n");
            }
        }
    }
    private static AnimalModel getHeaviestAnimalBySpecies(List<AnimalModel> animals, String species) {
        return animals.stream()
                .filter(animal -> animal.getClass().getSimpleName().equals(species))
                .max(Comparator.comparingDouble(AnimalModel::getWeight))
                .orElse(null);
    }

    private static AnimalModel getLightestAnimalBySpecies(List<AnimalModel> animals, String species) {
        return animals.stream()
                .filter(animal -> animal.getClass().getSimpleName().equals(species))
                .min(Comparator.comparingDouble(AnimalModel::getWeight))
                .orElse(null);
    }

    public static void getAllHeaviestAnimals(List<AnimalModel> animals) {
        System.out.println("All heaviest and lightest animals by species:\n");

        List<String> species = addUniqueSpecies(animals);

        for (String speciesName : species) {
            AnimalModel heaviestAnimal = getHeaviestAnimalBySpecies(animals, speciesName);

            if (heaviestAnimal != null) {
                double heaviest = heaviestAnimal.getWeight();

                System.out.println(speciesName +
                        "\nHeaviest name: " + heaviestAnimal.getName() + " (" + heaviest + " kg)\n");
            }
        }
    }

    public static void getAllLightestAnimals(List<AnimalModel> animals) {

        System.out.println("All heaviest lightest animals by species:\n");

        List<String> species = addUniqueSpecies(animals);

        for (String speciesName : species) {
            AnimalModel lightestAnimal = getLightestAnimalBySpecies(animals, speciesName);

            if (lightestAnimal != null) {
                double lightest = lightestAnimal.getWeight();

                System.out.println(speciesName +
                        "\nLightest name: " + lightestAnimal.getName() + " (" + lightest + " kg)\n");
            }
        }
    }

    /*LONGEST TAIL
     * inizializzo 2 variabili maxLongestTail con valore MIN possibile (lunghezza massimo della coda al momento e
     * longestTailAnimal, valore null, sarà l'animale con la coda più lunga per ora.
     * Ciclo for-each su ogni animale con la coda,
     * per ogni animale con la coda verifico se la sua lunghezza è superiore a maxLongestTail, se è superiore,
     * l'aggiorno con il nuovo valore insieme all'animale corrente
     * ed alla fine mi ritorna l'animale con la coda più lunga ez.
     * Faccio uguale uguale per findLargestWingspan
     *
     * */
    public AnimalWithTailModel findLongestTailAnimal() {
        double maxLongestTail = Double.MIN_VALUE;
        AnimalWithTailModel longestTailAnimal = null;

        for (AnimalWithTailModel animalWithTail : animalsWithTailList) {

            if (animalWithTail.getTailLength() > maxLongestTail) {
                maxLongestTail = animalWithTail.getTailLength();
                longestTailAnimal = animalWithTail;
            }
        }
        return longestTailAnimal;
    }



    public  AnimalWithWingspanModel findLargestWingspanAnimal() {
        double maxLargestWingspan = Double.MIN_VALUE;
        AnimalWithWingspanModel animalLargestWingspan = null;

        for (AnimalWithWingspanModel animalWithWings : animalsWithWingspanList) {

            if (animalWithWings.getWingspanLength() > maxLargestWingspan) {
                maxLargestWingspan = animalWithWings.getWingspanLength();
                animalLargestWingspan = animalWithWings;
            }
        }
        return animalLargestWingspan;
    }

    public List<AnimalWithTailModel> getAnimalsWithTailList() {return animalsWithTailList;}

    public List<AnimalWithWingspanModel> getAnimalsWithWingspanList() {return animalsWithWingspanList;}
}

