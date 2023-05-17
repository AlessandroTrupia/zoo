package org.example.zoo_management;

import org.example.model.AnimalModel;
import org.example.model.AnimalWithTailModel;
import org.example.model.AnimalWithWingspanModel;
import java.util.List;

import static org.example.zoo_management.AnimalFactory.addUniqueSpecies;


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

    /*
     Tallest and shortest per species
     I call the addUniqueSpecies method to get a list of unique species in the animal list.
     I initialize two variables, tallest and shortest, with MIN and MAX values respectively.
     Then I initialize two more variables, tallestAnimal and shortestAnimal, with null values for now.
     I create a nested "for" loop for each animal, where the first if statement checks if the animal's species name matches the current species within the outer loop. "(animal.getClass().getSimpleName().equals(species)"
     Then I check if their height is greater than tallest or shorter than shortest, and in both cases, I update the animal value within the loop.
     Finally, I check if tallestAnimal and shortestAnimal are not null, and I print them with their details.
     * */
    public static void getAllShortestTallestAnimals (List <AnimalModel> animals) {
        System.out.println("All shortest and tallest animals by species:\n");

        List <String> species = addUniqueSpecies(animals);

        for (String specie: species) {

            double shortest = Double.MAX_VALUE;
            double tallest = Double.MIN_VALUE;
            AnimalModel shortestAnimal = null;
            AnimalModel tallestAnimal = null;

            for (AnimalModel animal : animals){
                if (animal.getClass().getSimpleName().equals(specie)) {
                    if (animal.getHeight() < shortest) {
                        shortest = animal.getHeight();
                        shortestAnimal = animal;
                    }
                    if (animal.getHeight() > tallest) {
                        tallest = animal.getHeight();
                        tallestAnimal = animal;
                    }
                }
            }
            if (shortestAnimal != null && tallestAnimal != null) {
                System.out.println(specie +
                        "\nShortest name: "  + shortestAnimal.getName()    +  " (" + shortest +   " cm)\n" +
                        "Tallest name: "  + tallestAnimal.getName()     +  " (" + tallest +    " cm)\n");
            }
        }
    }

    public static void getAllHeaviestLightestAnimals(List<AnimalModel> animals) {
        System.out.println("All heaviest and lightest animals by species:\n");

        List<String> species = addUniqueSpecies(animals);

        for (String specie : species) {
            double heaviest = Double.MIN_VALUE;
            double lightest = Double.MAX_VALUE;
            AnimalModel heaviestAnimal = null;
            AnimalModel lightestAnimal = null;

            for (AnimalModel animal : animals) {
                if (animal.getClass().getSimpleName().equals(specie)) {
                    if (animal.getWeight() > heaviest) {
                        heaviest = animal.getWeight();
                        heaviestAnimal = animal;
                    }
                    if (animal.getWeight() < lightest) {
                        lightest = animal.getWeight();
                        lightestAnimal = animal;
                    }
                }
            }

            if (heaviestAnimal != null && lightestAnimal != null) {
                System.out.println(specie +
                        "\nHeaviest name: " + heaviestAnimal.getName() + " (" + heaviest + " kg)\n" +
                        "Lightest name: " + lightestAnimal.getName() + " (" + lightest + " kg)" + "\n");
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
    public AnimalWithTailModel findLongestTailAnimal(){
        double maxLongestTail = Double.MIN_VALUE;
        AnimalWithTailModel longestTailAnimal = null;

        for (AnimalWithTailModel animalWithTail : animalsWithTailList){

            if (animalWithTail.getTailLength() > maxLongestTail){
                maxLongestTail = animalWithTail.getTailLength();
                longestTailAnimal = animalWithTail;
            }
        }
        return longestTailAnimal;
    }



    public AnimalWithWingspanModel findLargestWingspanAnimal(){
        double maxLargestWingspan = Double.MIN_VALUE;
        AnimalWithWingspanModel animalLargestWingspan = null;

        for (AnimalWithWingspanModel animalWithWings : animalsWithWingspanList){

            if (animalWithWings.getWingspanLength() > maxLargestWingspan){
                maxLargestWingspan = animalWithWings.getWingspanLength();
                animalLargestWingspan = animalWithWings;
            }
        }
        return animalLargestWingspan;
    }

    public List<AnimalWithTailModel> getAnimalsWithTailList() {return animalsWithTailList;}

    public List<AnimalWithWingspanModel> getAnimalsWithWingspanList() {return animalsWithWingspanList;}
}

