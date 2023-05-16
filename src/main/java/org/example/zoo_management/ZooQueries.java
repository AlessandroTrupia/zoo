package org.example.zoo_management;

import org.example.model.AnimalModel;
import org.example.model.AnimalWithTailModel;
import org.example.model.AnimalWithWingspanModel;
import java.util.List;
import java.util.logging.Logger;

import static org.example.zoo_management.AnimalFactory.addUniqueSpecies;


/*
 * Questa classe serve ad eseguire varie interrogazioni,
 * nello specifico : gli animali più alti, bassi, pesanti e leggeri per specie
 *                   l'animale con la coda più lunga
 *                   l'animale con l'apertura alare più lunga
 * */
public class ZooQueries {

    //Creazione liste di AnimalWithTailModel e AnimalWithWingspanModel presenti nello zoo
    private final List <AnimalWithTailModel> animalsWithTailList;
    private final List <AnimalWithWingspanModel> animalsWithWingspanList;

    static Logger logger = Logger.getLogger(ZooQueries.class.getName());

    public ZooQueries(List<AnimalWithTailModel> animalsWithTailList, List<AnimalWithWingspanModel> animalsWithWingspanList) {
        this.animalsWithTailList = animalsWithTailList;
        this.animalsWithWingspanList = animalsWithWingspanList;

    }

    /*
     * Tallest and shortest per specie, la resa dei conti
     * Chiamo il metodo getUniqueSpecies cosi mi prendo l'elenco di specie uniche nella lista animali,
     * dopo eseguo un ciclo "for" molto simile a quelli commenti e utilizzati prima che non dovevo fare,
     * per farla breve inizializzo le due variabili, tallest e shortest, valori MIN e MAX possibili,
     * dopo inizializzo altre 2 variabili che saranno i miei animali più alti e bassi per ora con valore null,
     * altro ciclo "for" annidato su ogni animale, il primo if serve per capire se il nome della specie dell'animale
     * corrisponde alla specie corrente all'interno del ciclo esterno."(animal.getClass().getSimpleName().equals(specie)"
     * Dopo verifico se la loro altezza è maggiore di tallest o inferiore, in entrambi i casi affermativi,
     * aggiorno il valore dell'animale nel ciclo.
     * In fine controllo se non sono null i tallest e shortest e li stampo con i loro dettagli.
     * */
    public static void findTallestAndShortestAnimals(List<AnimalModel> animals) {
        logger.info("Tallest and shortest animals by species:" + "\n");

        // Creare un elenco di Stringhe delle specie uniche presenti nello zoo utilizzando il metodo "getUniqueSpecies"
        List<String> species = addUniqueSpecies(animals);

        // Trovare l'esemplare più alto e più basso per ogni specie
        for (String specie : species) {
            double tallest = Double.MIN_VALUE;
            double shortest = Double.MAX_VALUE;
            AnimalModel tallestAnimal = null;
            AnimalModel shortestAnimal = null;

            for (AnimalModel animal : animals) {
                if (animal.getClass().getSimpleName().equals(specie)) {
                    if (animal.getHeight() > tallest) {
                        tallest = animal.getHeight();
                        tallestAnimal = animal;
                    }
                    if (animal.getHeight() < shortest) {
                        shortest = animal.getHeight();
                        shortestAnimal = animal;
                    }
                }
            }

            if (tallestAnimal != null && shortestAnimal != null) {
                logger.info(specie +
                        "\nTallest: "  + tallestAnimal.getName()   + " (" + tallest + " cm)"  +
                        "\nShortest: " + shortestAnimal.getName()  + " (" + shortest + " cm)" + "\n");
            }
        }
    }

    //Heaviest and lightest per specie, stessa logica di sopra, leggiti il metodo se non la ricordi "findTallestAndShortest"
    public static void findHeaviestAndLightestAnimals(List<AnimalModel> animals) {
        logger.info("Heaviest and lightest animals by species:" + "\n");

        // Creo un elenco delle specie uniche presenti nello zoo, uguale a sopra
        List<String> species = addUniqueSpecies(animals);

        // Trovare l'esemplare più pesante e più leggero per ogni specie
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
                logger.info(specie +
                        "\nHeaviest: " + heaviestAnimal.getName() + " (" + heaviest + " kg)" +
                        "\nLightest: " + lightestAnimal.getName() + " (" + lightest + " kg)" + "\n");
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


    //LARGEST WINGSPAN
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

